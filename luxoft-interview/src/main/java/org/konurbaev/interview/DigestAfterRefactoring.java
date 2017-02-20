package org.konurbaev.interview;

import java.util.HashMap;
import java.util.Map;

public abstract class DigestAfterRefactoring {
        private final Map<byte[], byte[]> cache = new HashMap<>();

        public byte[] digest(byte[] input) {
            byte[] result = cache.get(input);
            if (result == null) {
                result = doDigest(input);
                synchronized (cache) {
                    cache.putIfAbsent(input, result);
                }
            }
            return result;
        }

        protected abstract byte[] doDigest(byte[] input);
}
/*
    массив байтов в качестве ключа не меняем, чтобы не менять интерфейс doDigest
*/