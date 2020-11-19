package com.creation.core.application;

import com.creation.view.core.SwingAction;
import org.springframework.stereotype.Component;

@Component
public class UserException extends RuntimeException {
    final
    SwingAction swingAction;

    public UserException(SwingAction swingAction) {
        this.swingAction = swingAction;
    }

    public Throwable throwing(String mes) {
        swingAction.displayError("Ошибка", mes);
        return new Throwable();
    }
}
