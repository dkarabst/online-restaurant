package com.softserve.academy.food.entity;

import com.softserve.academy.food.model.UserAttachmentModel;

import javax.persistence.*;

@Entity
@PrimaryKeyJoinColumn(name="ATTACHMENTS_ID", referencedColumnName="ATTACHMENTS_ID")
public class UserAttachment extends Attachment {

	@ManyToOne(fetch = FetchType.LAZY)
    private User user;

    public UserAttachment(UserAttachmentModel userAttachmentModel) {
        super.setId(userAttachmentModel.getId());
        super.setName(userAttachmentModel.getName());
        super.setPath(userAttachmentModel.getPath());
        user = userAttachmentModel.getUserModel().toEntity();
    }

    public UserAttachmentModel toModel() {
        return new UserAttachmentModel(this);
    }

    public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (!(obj instanceof UserAttachment))
			return false;
		UserAttachment other = (UserAttachment) obj;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UserAttachment [user=" + user + "]";
	}
}
