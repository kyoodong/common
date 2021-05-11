package com.kyoodong.common;

import java.util.List;

public class CursorPagination<T> {
    private String cursor;
    private String nextCursor;
    private int frameSize;
    private List<T> items;

    public CursorPagination(String cursor, String nextCursor, int frameSize, List<T> items) {
        this.cursor = cursor;
        this.nextCursor = nextCursor;
        this.frameSize = frameSize;
        this.items = items;
    }

    public String getCursor() {
        return cursor;
    }

    public String getNextCursor() {
        return nextCursor;
    }

    public int getFrameSize() {
        return frameSize;
    }

    public List<T> getItems() {
        return items;
    }

    public boolean hasNext() {
        return nextCursor != null && !nextCursor.isEmpty();
    }
}
