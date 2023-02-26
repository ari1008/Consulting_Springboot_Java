package com.plateforme.consultant.exposition;

import com.plateforme.consultant.domain.Consultant;

import javax.validation.constraints.NotNull;
import java.util.List;

public class SearchConsultantResponse {

    @NotNull
    private final int page;

    @NotNull
    private final int size;


    private final String filterOr;

    private final String filterAnd;


    private final String orders;

    private final List<ModifyConsultantResponse> consultants;

    public SearchConsultantResponse(int page, int size, String filterOr, String filterAnd, String orders, List<ModifyConsultantResponse> consultants) {
        this.page = page;
        this.size = size;
        this.filterOr = filterOr;
        this.filterAnd = filterAnd;
        this.orders = orders;
        this.consultants = consultants;
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

    public List<ModifyConsultantResponse> getConsultants() {
        return consultants;
    }
}
