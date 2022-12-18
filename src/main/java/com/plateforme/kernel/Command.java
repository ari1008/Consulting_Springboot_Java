package com.plateforme.kernel;

public interface Command {
    default String name() {
        return this.getClass().getSimpleName();
    }
}
