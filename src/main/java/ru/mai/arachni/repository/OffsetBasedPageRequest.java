package ru.mai.arachni.repository;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.data.domain.Pageable;

import org.springframework.data.domain.Sort;
import org.springframework.lang.NonNull;

public class OffsetBasedPageRequest implements Pageable {
    private final int limit;
    private final long offset;
    private final Sort sort;

    public OffsetBasedPageRequest(long offsetParam, int limitParam, Sort sortParam) {
        if (offsetParam < 0) {
            throw new IllegalArgumentException("Offset не может быть меньше 0");
        }

        if (limitParam < 1) {
            throw new IllegalArgumentException("Limit не может быть меньше 1");
        }
        this.limit = limitParam;
        this.offset = offsetParam;
        this.sort = sortParam;
    }

    @Override
    public int getPageNumber() {
        return (int) (offset / limit);
    }

    @Override
    public int getPageSize() {
        return limit;
    }

    @Override
    public long getOffset() {
        return offset;
    }

    @Override
    @NonNull
    public Sort getSort() {
        return sort;
    }

    @Override
    @NonNull
    public Pageable next() {
        return new OffsetBasedPageRequest(getOffset() + getPageSize(), getPageSize(), getSort());
    }

    public OffsetBasedPageRequest previous() {
        return hasPrevious()
                ? new OffsetBasedPageRequest(getOffset() - getPageSize(), getPageSize(), getSort())
                : this;
    }


    @Override
    @NonNull
    public Pageable previousOrFirst() {
        return hasPrevious() ? previous() : first();
    }

    @Override
    @NonNull
    public Pageable first() {
        return new OffsetBasedPageRequest(0, getPageSize(), getSort());
    }

    @Override
    @NonNull
    public Pageable withPage(int pageNumber) {
        return new OffsetBasedPageRequest(offset * limit, getPageSize(), getSort());
    }

    @Override
    public boolean hasPrevious() {
        return offset > limit;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("limit", limit)
                .append("offset", offset)
                .append("sort", sort)
                .toString();
    }
}
