package com.plateforme.kernel;

public interface Event {
    default String name() {
        return getClass().getSimpleName();
    }
}
