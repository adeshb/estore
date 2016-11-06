package com.estore.jpa;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the feature_options database table.
 * 
 */
@Embeddable
public class FeatureOptionPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private int featureOptionId;

	@Column(insertable=false, updatable=false)
	private int featureTypeId;

	public FeatureOptionPK() {
	}
	public int getFeatureOptionId() {
		return this.featureOptionId;
	}
	public void setFeatureOptionId(int featureOptionId) {
		this.featureOptionId = featureOptionId;
	}
	public int getFeatureTypeId() {
		return this.featureTypeId;
	}
	public void setFeatureTypeId(int featureTypeId) {
		this.featureTypeId = featureTypeId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof FeatureOptionPK)) {
			return false;
		}
		FeatureOptionPK castOther = (FeatureOptionPK)other;
		return 
			(this.featureOptionId == castOther.featureOptionId)
			&& (this.featureTypeId == castOther.featureTypeId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.featureOptionId;
		hash = hash * prime + this.featureTypeId;
		
		return hash;
	}
}