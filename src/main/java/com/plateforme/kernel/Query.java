package com.plateforme.kernel;

public interface Query {
    default String name() {
        return this.getClass().getSimpleName();
    }
}
