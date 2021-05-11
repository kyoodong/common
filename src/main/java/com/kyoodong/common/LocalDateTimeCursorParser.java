package com.kyoodong.common;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class LocalDateTimeCursorParser implements CursorParser<LocalDateTime> {

    @Override
    public String toCursor(LocalDateTime localDateTime) {
        if (localDateTime == null) {
            return null;
        }
        return localDateTime.toEpochSecond(ZoneOffset.UTC) + "." + localDateTime.getNano();
    }

    @Override
    public LocalDateTime parseCursor(String cursor) {
        if (cursor == null) {
            return null;
        }

        String[] data = cursor.split(".");
        long seconds = Long.parseLong(data[0]);
        int nanos = Integer.parseInt(data[1]);
        return LocalDateTime.ofEpochSecond(seconds, nanos, ZoneOffset.UTC);
    }
}
