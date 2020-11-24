package com.creation.view.service;

import com.creation.entity.Auth;
import com.creation.entity.Role;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.util.HashSet;

@Component
public class MainFrameService {
    public void visibleByRoleSaler(Auth auth, HashSet<JComponent> components) {
        if (!auth.getUser().getRole().equals(Role.USER)) {
            for (JComponent component : components) component.setVisible(true);
        } else for (JComponent component : components) component.setVisible(false);
    }
}
