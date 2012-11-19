package com.softserve.academy.food.model;

import com.softserve.academy.food.entity.DishAttachment;

public class DishAttachmentModel extends AttachmentModel {

    DishModel dishModel;

    public DishAttachmentModel() {}

    public DishAttachmentModel(DishAttachment dishAttachment) {
        super.setId(dishAttachment.getId());
        super.setName(dishAttachment.getName());
        super.setPath(dishAttachment.getPath());
        dishModel = dishAttachment.getDish().toModel();
    }

    public DishAttachmentModel(String name, String path) {
        super.setName(name);
        super.setPath(path);
    }

    public DishAttachment toEntity() {
        return new DishAttachment(this);
    }

    public DishModel getDishModel() {
        return dishModel;
    }

    public void setDishModel(DishModel dishModel) {
        this.dishModel = dishModel;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((dishModel == null) ? 0 : dishModel.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (!(obj instanceof DishModel))
            return false;
        return true;
    }
}
