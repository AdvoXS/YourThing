package com.creation.view.elements.row.creators;

import com.creation.entity.Entity;
import com.creation.view.elements.row.RowItemPanel;

public interface RowItemCreator {
    RowItemPanel createItem(Entity entity);
}
