package org.konurbaev.interview;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class DigestAfterRefactoringWithConcurrentHashMap {
        private final Map<ByteArray, byte[]> cache = new ConcurrentHashMap<>();

        public byte[] digest(byte[] input) {
            return cache.putIfAbsent(new ByteArray(input), doDigest(input));
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

4. Запись и чтение в мапу теперь регулирует ConcurrentHashMap,
Это приводит к тому, что тот, кто читает, получив ссылку на массив,
увидит все изменения с массивом, которые сделал поток, который его записывал.

5. При объявлении ConcurrentHashMap убраны повторно указанные типы.

6. HashMap заменен на ConcurrentHashMap для снятия проблем с многопоточностью.
*/
