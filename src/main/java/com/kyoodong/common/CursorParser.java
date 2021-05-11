package com.kyoodong.common;

public interface CursorParser<T> {

    String toCursor(T t);

    T parseCursor(String cursor);
}
