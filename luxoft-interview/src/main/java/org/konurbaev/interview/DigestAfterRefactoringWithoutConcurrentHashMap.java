package org.konurbaev.interview;

import java.util.HashMap;
import java.util.Map;

public abstract class DigestAfterRefactoringWithoutConcurrentHashMap {
    private final Map<ByteArray, byte[]> cache = new HashMap<>();

    public byte[] digest(byte[] input) {
        byte[] result;

        synchronized (cache) {
            result = cache.get(input);
            if (result != null) {
                return result;
            }
        }

        result = doDigest(input);

        synchronized (cache) {
            cache.putIfAbsent(new ByteArray(input), result);
        }

        return result;
    }

    protected abstract byte[] doDigest(byte[] input);
}

/*
1. cache объявлен как final, что обеспечивает безопасную публикацию даже,
если ссылка на Digest передается в другой поток через гонку.

2. Генерация значения происходит теперь не в synchronized блоке,
соответственно будет возможно генерировать два ключа одновременно.

3. Переопределен ключ для Map на обертку для byte[].
В этой обертке переопределены методы equals и hashCode.
Теперь два массива, содержащие одни и те же данные, будут считаться одинаковыми,
Кэш не будет распухать бесконечно, пока не кончится память.

4. Чтение и запись в мапу происходят в synchronized блоках,
поэтому поток не может читать мапу в то время, пока другой поток её меняет.
Это приводит к тому, что тот, кто читает, получив ссылку на массив,
увидит все изменения с массивом, которые сделал поток, который его записывал.

В противном случае, без синхронизации чтения, если и прочитаешь из мапы не null,
то нет гарантий что увидишь все изменения в массиве,
которые сделал поток, который клал массив в мапу,
ибо между этими двумя потоками нет общей точки синхронизации.

5. При объявлении HashMap убраны повторно указанные типы.
*/