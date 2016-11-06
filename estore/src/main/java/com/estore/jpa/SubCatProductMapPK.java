package com.estore.jpa;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the sub_cat_product_map database table.
 * 
 */
@Embeddable
public class SubCatProductMapPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private int subCategoryId;

	@Column(insertable=false, updatable=false)
	private int productCatalogId;

	public SubCatProductMapPK() {
	}
	public int getSubCategoryId() {
		return this.subCategoryId;
	}
	public void setSubCategoryId(int subCategoryId) {
		this.subCategoryId = subCategoryId;
	}
	public int getProductCatalogId() {
		return this.productCatalogId;
	}
	public void setProductCatalogId(int productCatalogId) {
		this.productCatalogId = productCatalogId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof SubCatProductMapPK)) {
			return false;
		}
		SubCatProductMapPK castOther = (SubCatProductMapPK)other;
		return 
			(this.subCategoryId == castOther.subCategoryId)
			&& (this.productCatalogId == castOther.productCatalogId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.subCategoryId;
		hash = hash * prime + this.productCatalogId;
		
		return hash;
	}
}