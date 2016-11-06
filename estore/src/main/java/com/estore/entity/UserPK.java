package com.estore.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the user database table.
 * 
 */
@Embeddable
public class UserPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(unique=true, nullable=false)
	private int userId;

	@Column(insertable=false, updatable=false, unique=true, nullable=false)
	private int addressId;

	public UserPK() {
	}
	public int getUserId() {
		return this.userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getAddressId() {
		return this.addressId;
	}
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof UserPK)) {
			return false;
		}
		UserPK castOther = (UserPK)other;
		return 
			(this.userId == castOther.userId)
			&& (this.addressId == castOther.addressId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.userId;
		hash = hash * prime + this.addressId;
		
		return hash;
	}
}