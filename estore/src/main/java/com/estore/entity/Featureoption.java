package com.estore.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the featureoptions database table.
 * 
 */
@Entity
@Table(name="featureoptions")
@NamedQuery(name="Featureoption.findAll", query="SELECT f FROM Featureoption f")
public class Featureoption implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private FeatureoptionPK id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable=false)
	private Date created;

	@Column(nullable=false, length=45)
	private String optionName;

	@Column(nullable=false)
	private byte status;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable=false)
	private Date updated;

	//bi-directional many-to-one association to FeatureTypeMaster
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="featureTypeId", nullable=false, insertable=false, updatable=false)
	private FeatureTypeMaster featureTypeMaster;

	//bi-directional many-to-one association to ProductFeature
	@OneToMany(mappedBy="featureoption")
	private List<ProductFeature> productFeatures;

	public Featureoption() {
	}

	public FeatureoptionPK getId() {
		return this.id;
	}

	public void setId(FeatureoptionPK id) {
		this.id = id;
	}

	public Date getCreated() {
		return this.created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public String getOptionName() {
		return this.optionName;
	}

	public void setOptionName(String optionName) {
		this.optionName = optionName;
	}

	public byte getStatus() {
		return this.status;
	}

	public void setStatus(byte status) {
		this.status = status;
	}

	public Date getUpdated() {
		return this.updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	public FeatureTypeMaster getFeatureTypeMaster() {
		return this.featureTypeMaster;
	}

	public void setFeatureTypeMaster(FeatureTypeMaster featureTypeMaster) {
		this.featureTypeMaster = featureTypeMaster;
	}

	public List<ProductFeature> getProductFeatures() {
		return this.productFeatures;
	}

	public void setProductFeatures(List<ProductFeature> productFeatures) {
		this.productFeatures = productFeatures;
	}

	public ProductFeature addProductFeature(ProductFeature productFeature) {
		getProductFeatures().add(productFeature);
		productFeature.setFeatureoption(this);

		return productFeature;
	}

	public ProductFeature removeProductFeature(ProductFeature productFeature) {
		getProductFeatures().remove(productFeature);
		productFeature.setFeatureoption(null);

		return productFeature;
	}

}