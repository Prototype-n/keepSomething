package automation.utils.models;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "user")
public class User {

	private User() {}
	
	private boolean enabled;
	private String created;
	private String product;
	private String parent;
	private String deletionDeadline;
	private boolean subscribed;
	private String externalId;

	public String getParent() {
		return parent;
	}

	public void setParent(String parent) {
		this.parent = parent;
	}

	public boolean getSubscribed() {
		return subscribed;
	}

	public void setSubscribed(boolean subscribed) {
		this.subscribed = subscribed;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	public boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getDeletionDeadline() {
		return deletionDeadline;
	}

	public void setDeletionDeadline(String deletionDeadline) {
		this.deletionDeadline = deletionDeadline;
	}

	public String getExternalId() {
		return externalId;
	}

	public void setExternalId(String externalId) {
		this.externalId = externalId;
	}
	
    public static Builder newBuilder() {
        return new User().new Builder();
    }
    

	public class Builder {

        private Builder() { }

        public Builder setParent(String parent) {
            User.this.parent = parent;
            return this;
        }

        public Builder setSubscribed(boolean subscribed) {
            User.this.subscribed = subscribed;
            return this;
        }
        
        public Builder setProduct(String product) {
            User.this.product = product;
            return this;
        }

        public Builder setCreated(String created) {
            User.this.created = created;
            return this;
        }
        
        public Builder setEnabled(boolean enabled) {
            User.this.enabled = enabled;
            return this;
        }
        public User build() {
            return User.this;
        }
    }


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((created == null) ? 0 : created.hashCode());
		result = prime * result + ((deletionDeadline == null) ? 0 : deletionDeadline.hashCode());
		result = prime * result + (enabled ? 1231 : 1237);
		result = prime * result + ((externalId == null) ? 0 : externalId.hashCode());
		result = prime * result + ((parent == null) ? 0 : parent.hashCode());
		result = prime * result + ((product == null) ? 0 : product.hashCode());
		result = prime * result + (subscribed ? 1231 : 1237);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (created == null) {
			if (other.created != null)
				return false;
		} else if (!created.equals(other.created))
			return false;
		if (deletionDeadline == null) {
			if (other.deletionDeadline != null)
				return false;
		} else if (!deletionDeadline.equals(other.deletionDeadline))
			return false;
		if (enabled != other.enabled)
			return false;
		if (externalId == null) {
			if (other.externalId != null)
				return false;
		} else if (!externalId.equals(other.externalId))
			return false;
		if (parent == null) {
			if (other.parent != null)
				return false;
		} else if (!parent.equals(other.parent))
			return false;
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (!product.equals(other.product))
			return false;
		if (subscribed != other.subscribed)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [enabled=" + enabled + ", created=" + created + ", product=" + product + ", parent=" + parent
				+ ", deletionDeadline=" + deletionDeadline + ", subscribed=" + subscribed + ", externalId=" + externalId
				+ "]";
	}
}


