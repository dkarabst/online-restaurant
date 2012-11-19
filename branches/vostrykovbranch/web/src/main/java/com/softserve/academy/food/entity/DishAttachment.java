package com.softserve.academy.food.entity;

import com.softserve.academy.food.model.DishAttachmentModel;

import javax.persistence.*;

@Entity
@PrimaryKeyJoinColumn(name="ATTACHMENTS_ID", referencedColumnName="ATTACHMENTS_ID")
public class DishAttachment extends Attachment {

	@ManyToOne(fetch = FetchType.LAZY)
    private Dish dish;

    public DishAttachment() {}

    public DishAttachment(DishAttachmentModel dishAttachmentModel) {
        super.setId(dishAttachmentModel.getId());
        super.setName(dishAttachmentModel.getName());
        super.setPath(dishAttachmentModel.getPath());
        dish = dishAttachmentModel.getDishModel().toEntity();
    }

    public DishAttachmentModel toModel() {
        return new DishAttachmentModel(this);
    }


    public Dish getDish() {
		return dish;
	}

	public void setDish(Dish dish) {
		this.dish = dish;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((dish == null) ? 0 : dish.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (!(obj instanceof DishAttachment))
			return false;
		DishAttachment other = (DishAttachment) obj;
		if (dish == null) {
			if (other.dish != null)
				return false;
		} else if (!dish.equals(other.dish))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DishAttachment [dish=" + dish + "]";
	}
}
