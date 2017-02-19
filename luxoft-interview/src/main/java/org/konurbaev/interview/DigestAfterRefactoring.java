package org.konurbaev.interview;

import java.util.HashMap;
import java.util.Map;

public class DigestAfterRefactoring {
    public abstract class DigestBeforeRefactoring {
        private final Map<String, byte[]> cache = new HashMap<>();

        public byte[] digest(String input) {
            byte[] result = cache.get(input);
            if (result == null) {
                result = doDigest(input);
                synchronized (cache) {
                    cache.putIfAbsent(input, result);
                }
            }
            return result;
        }

        protected abstract byte[] doDigest(String input);
    }
}
