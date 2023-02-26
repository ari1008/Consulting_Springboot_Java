package com.plateforme.consultant.exposition;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;

public class SearchConsultantRequest {

    @NotNull
    private final int page;

    @NotNull
    private final int size;


    private final String filterOr;

    private final String filterAnd;


    private final String orders;


    public SearchConsultantRequest(@JsonProperty("page") int page,
                                   @JsonProperty("size") int size,
                                   @JsonProperty("filterOr") String filterOr,
                                   @JsonProperty("filterAnd") String filterAnd,
                                   @JsonProperty("orders") String orders) {
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
