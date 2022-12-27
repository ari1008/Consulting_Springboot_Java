package com.plateforme.kernel;

public interface CommandHandler<C extends Command, R> {
    R handle(C command) throws Exception;
}
