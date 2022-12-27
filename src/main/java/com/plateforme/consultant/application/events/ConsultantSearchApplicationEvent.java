package com.plateforme.consultant.application.events;

import com.plateforme.kernel.Event;

import javax.validation.constraints.NotNull;

public class ConsultantSearchApplicationEvent implements Event {

    @NotNull
    private  final int page;

    @NotNull
    private final int size;


    private final String filterOr;

    private final String filterAnd;

    private final String orders;

    public ConsultantSearchApplicationEvent(int page, int size, String filterOr, String filterAnd, String orders) {
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
}
