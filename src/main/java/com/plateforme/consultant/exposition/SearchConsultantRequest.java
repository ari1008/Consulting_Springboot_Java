package com.plateforme.consultant.exposition;

import javax.validation.constraints.NotNull;

public class SearchConsultantRequest {

    @NotNull
    private  final int page;

    @NotNull
    private final int size;


    private final String filterOr;

    private final String filterAnd;


    private final String orders;


    public SearchConsultantRequest(int page, int size, String filterOr, String filterAnd, String orders) {
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
