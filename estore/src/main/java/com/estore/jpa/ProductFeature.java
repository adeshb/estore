package com.estore.jpa;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.sql.Timestamp;


/**
 * The persistent class for the product_features database table.
 * 
 */
@Entity
@Table(name="product_features")
@NamedQuery(name="ProductFeature.findAll", query="SELECT p FROM ProductFeature p")
public class ProductFeature implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ProductFeaturePK id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date created;

	private byte status;

	private Timestamp updated;

	//bi-directional many-to-one association to FeatureOption
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="featureOptionId", referencedColumnName="featureOptionId", updatable=false, insertable=false),
		@JoinColumn(name="featureTypeId", referencedColumnName="featureTypeId", updatable=false, insertable=false)  
		})
	private FeatureOption featureOption;

	//bi-directional many-to-one association to Product
	@ManyToOne
	@JoinColumn(name="productId", updatable=false, insertable=false)
	private Product product;

	public ProductFeature() {
	}

	public ProductFeaturePK getId() {
		return this.id;
	}

	public void setId(ProductFeaturePK id) {
		this.id = id;
	}

	public Date getCreated() {
		return this.created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public byte getStatus() {
		return this.status;
	}

	public void setStatus(byte status) {
		this.status = status;
	}

	public Timestamp getUpdated() {
		return this.updated;
	}

	public void setUpdated(Timestamp updated) {
		this.updated = updated;
	}

	public FeatureOption getFeatureOption() {
		return this.featureOption;
	}

	public void setFeatureOption(FeatureOption featureOption) {
		this.featureOption = featureOption;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}