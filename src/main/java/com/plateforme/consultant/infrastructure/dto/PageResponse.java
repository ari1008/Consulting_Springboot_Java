package com.plateforme.consultant.infrastructure.dto;

import org.springframework.data.domain.Page;

import java.util.List;

public class PageResponse<T> {

    private int totalPages;
    private long totalItems;
    private int currentPage;
    private boolean first;
    private boolean last;
    private int itemsPerPage;
    private int pageSize;

    private List<T> items;

    public void setPageStats(Page pg, List<T> elts) {
        first = pg.isFirst();
        last = pg.isLast();
        currentPage = pg.getNumber() + 1;
        pageSize = pg.getSize();
        totalPages = pg.getTotalPages();
        totalItems = pg.getTotalElements();
        itemsPerPage = pg.getNumberOfElements();
        items = elts;
    }


    public int getTotalPages() {
        return totalPages;
    }

    public long getTotalItems() {
        return totalItems;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public boolean isFirst() {
        return first;
    }

    public boolean isLast() {
        return last;
    }

    public int getItemsPerPage() {
        return itemsPerPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public List<T> getItems() {
        return items;
    }
}
