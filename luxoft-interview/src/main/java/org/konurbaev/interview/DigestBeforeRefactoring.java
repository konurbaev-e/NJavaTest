package org.konurbaev.interview;

import java.util.HashMap;
import java.util.Map;

// REVIEW IS NEEDED
public abstract class DigestBeforeRefactoring {
    private Map<byte[], byte[]> cache = new HashMap<byte[], byte[]>();

    public byte[] digest(byte[] input) {
        byte[] result = cache.get(input);
        if (result == null) {
            synchronized (cache) {
                result = cache.get(input);
                if (result == null) {
                    result = doDigest(input);
                    cache.put(input, result);
                }
            }
        }
        return result;
    }

    protected abstract byte[] doDigest(byte[] input);
}
/*
1. Минорный баг - ничто не мешает сделать cache как final,
что обеспечило бы безопасную публикацию даже, если ссылка на Digest передается
в другой поток через гонку.

2. Хуже - генерация значения происходит в synchronized блоке,
это слишком жирная блокировка, генерировать два ключа одновременно будет невозможно.

3. Совсем плохо. Метод equals/hashCode не переопределены у массивов,
соответственно два массива, содержащие одни и те же данные, будут считаться разными,
мапа будет распухать бесконечно, пока не кончится память,
т.е. кэш в принципе не работает. Как решение, можно заменить на String

4. Ну и совсем катастрофа. Запись и чтение в мапу происходит через гонку,
поток может читать мапу в то время, пока другой поток её меняет.
Это приводит к тому, что тот, кто читает, может, получив ссылку на массив,
не увидеть всех изменений с массивом, которые сделал поток, который его записывал,
ну и в отдельных тяжелых случаях читающий мог даже в бесконечный цикл попасть.

5. При объявлении HashMap излишне повторно указывать типы, начиная с Java 7.

6. Правильней вообще объявить кэш как ConcurrentHashMap,
тогда он снимает проблемы с многопоточностью.
*/