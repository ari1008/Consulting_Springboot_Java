package com.plateforme.validation;

import javax.validation.ConstraintViolation;
import java.util.Set;

public interface Command<C>{

    default <C> void validate(C command) {
        var validator = UseCaseValidator.getInstance().validator();
        final Set<ConstraintViolation<C>> violations = validator.validate(command);
        if (!violations.isEmpty()) {
            throw new RuntimeException(violations.toString());
        }
    }
}
