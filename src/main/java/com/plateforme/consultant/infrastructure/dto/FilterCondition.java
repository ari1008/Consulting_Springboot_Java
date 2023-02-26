package com.plateforme.consultant.infrastructure.dto;

import com.plateforme.consultant.infrastructure.enums.FilterOperationEnum;

public class FilterCondition {

    private final String field;
    private final FilterOperationEnum operator;
    private final Object value;

    public FilterCondition(String field, FilterOperationEnum operator, Object value) {
        this.field = field;
        this.operator = operator;
        this.value = value;
    }

    public FilterOperationEnum getOperator() {
        return operator;
    }

    public Object getValue() {
        return value;
    }

    public String getField() {
        return field;
    }
}
