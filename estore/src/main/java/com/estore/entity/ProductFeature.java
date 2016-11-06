package com.estore.entity;

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
	@Column(nullable=false)
	private Date created;

	@Column(nullable=false)
	private byte status;

	private Timestamp updated;

	//bi-directional many-to-one association to Product
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="productId", nullable=false, insertable=false, updatable=false)
	private Product product;

	//bi-directional many-to-one association to FeatureOption
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name="featureOptionId", referencedColumnName="featureOptionId", nullable=false, insertable=false, updatable=false),
		@JoinColumn(name="featureTypeId", referencedColumnName="featureTypeId", nullable=false, insertable=false, updatable=false)
		})
	private FeatureOption featureOption;

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

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public FeatureOption getFeatureOption() {
		return this.featureOption;
	}

	public void setFeatureOption(FeatureOption featureOption) {
		this.featureOption = featureOption;
	}

}