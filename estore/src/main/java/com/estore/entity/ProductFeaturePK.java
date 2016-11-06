package com.estore.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the product_features database table.
 * 
 */
@Embeddable
public class ProductFeaturePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false, unique=true, nullable=false)
	private int productId;

	@Column(insertable=false, updatable=false, unique=true, nullable=false)
	private int featureTypeId;

	@Column(insertable=false, updatable=false, unique=true, nullable=false)
	private int featureOptionId;

	public ProductFeaturePK() {
	}
	public int getProductId() {
		return this.productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getFeatureTypeId() {
		return this.featureTypeId;
	}
	public void setFeatureTypeId(int featureTypeId) {
		this.featureTypeId = featureTypeId;
	}
	public int getFeatureOptionId() {
		return this.featureOptionId;
	}
	public void setFeatureOptionId(int featureOptionId) {
		this.featureOptionId = featureOptionId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ProductFeaturePK)) {
			return false;
		}
		ProductFeaturePK castOther = (ProductFeaturePK)other;
		return 
			(this.productId == castOther.productId)
			&& (this.featureTypeId == castOther.featureTypeId)
			&& (this.featureOptionId == castOther.featureOptionId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.productId;
		hash = hash * prime + this.featureTypeId;
		hash = hash * prime + this.featureOptionId;
		
		return hash;
	}
}