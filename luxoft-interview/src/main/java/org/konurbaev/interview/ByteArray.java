package org.konurbaev.interview;

import java.util.Arrays;

public class ByteArray {
    byte[] bytes;

    public ByteArray(byte[] bytes){
        this.bytes = bytes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ByteArray)) return false;

        ByteArray byteArray = (ByteArray) o;

        return Arrays.equals(bytes, byteArray.bytes);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(bytes);
    }
}
