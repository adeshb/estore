package com.estore.jpa;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.sql.Timestamp;


/**
 * The persistent class for the sub_cat_product_map database table.
 * 
 */
@Entity
@Table(name="sub_cat_product_map")
@NamedQuery(name="SubCatProductMap.findAll", query="SELECT s FROM SubCatProductMap s")
public class SubCatProductMap implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private SubCatProductMapPK id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date ceated;

	private Timestamp updated;

	//bi-directional many-to-one association to Product
	@ManyToOne
	@JoinColumn(name="productCatalogId", insertable=false,  updatable=false)
	private Product product;

	//bi-directional many-to-one association to SubCategoryMaster
	@ManyToOne
	@JoinColumn(name="subCategoryId", insertable=false,  updatable=false)
	private SubCategoryMaster subCategoryMaster;

	public SubCatProductMap() {
	}

	public SubCatProductMapPK getId() {
		return this.id;
	}

	public void setId(SubCatProductMapPK id) {
		this.id = id;
	}

	public Date getCeated() {
		return this.ceated;
	}

	public void setCeated(Date ceated) {
		this.ceated = ceated;
	}

	public Timestamp getUpdated() {
		return this.updated;
	}

	public void setUpdated(Timestamp updated) {
		this.updated = updated;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public SubCategoryMaster getSubCategoryMaster() {
		return this.subCategoryMaster;
	}

	public void setSubCategoryMaster(SubCategoryMaster subCategoryMaster) {
		this.subCategoryMaster = subCategoryMaster;
	}

}