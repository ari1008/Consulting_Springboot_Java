package com.plateforme.consultant.domain;

import com.plateforme.kernel.Event;

public class ConsultantSearched implements Event {
    private final int page;

    private final int size;


    private final String filterOr;

    private final String filterAnd;

    private final String orders;

    public ConsultantSearched(int page, int size, String filterOr, String filterAnd, String orders) {
        this.page = page;
        this.size = size;
        this.filterOr = filterOr;
        this.filterAnd = filterAnd;
        this.orders = orders;
    }

    public int getPage() {
        return page;
    }

    public int getSize() {
        return size;
    }

    public String getFilterOr() {
        return filterOr;
    }

    public String getFilterAnd() {
        return filterAnd;
    }

    public String getOrders() {
        return orders;
    }
}
