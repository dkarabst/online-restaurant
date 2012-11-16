package com.softserve.academy.model;

import com.softserve.academy.entity.UserAttachment;

public class UserAttachmentModel extends AttachmentModel {

    UserModel userModel;

    public UserAttachmentModel() {}

    public UserAttachmentModel(UserAttachment userAttachment) {
        super.setId(userAttachment.getId());
        super.setName(userAttachment.getName());
        super.setPath(userAttachment.getPath());
        userModel = userAttachment.getUser().toModel();
    }

    public UserAttachmentModel(String name, String path) {
        super.setName(name);
        super.setPath(path);
    }

    public UserAttachment toEntity() {
        return new UserAttachment(this);
    }

    public UserModel getUserModel() {
        return userModel;
    }

    public void setUserModel(UserModel userModel) {
        this.userModel = userModel;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((userModel == null) ? 0 : userModel.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (!(obj instanceof UserAttachmentModel))
            return false;
        UserAttachmentModel other = (UserAttachmentModel) obj;
        if (userModel == null) {
            if (other.userModel != null)
                return false;
        } else if (!userModel.equals(other.userModel))
            return false;
        return true;
    }
}
