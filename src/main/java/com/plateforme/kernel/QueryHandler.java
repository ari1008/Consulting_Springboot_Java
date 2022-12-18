package com.plateforme.kernel;

public interface QueryHandler<Q extends Query, R> {
    R handle(Q query);
}
