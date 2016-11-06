package com.estore.jpa;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the feature_options database table.
 * 
 */
@Entity
@Table(name="feature_options")
@NamedQuery(name="FeatureOption.findAll", query="SELECT f FROM FeatureOption f")
public class FeatureOption implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private FeatureOptionPK id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date created;

	private String optionName;

	private byte status;

	private Timestamp updated;

	//bi-directional many-to-one association to FeatureTypeMaster
	@ManyToOne
	@JoinColumn(name="featureTypeId", insertable=false, updatable=false)
	private FeatureTypeMaster featureTypeMaster;

	//bi-directional many-to-one association to ProductFeature
	@OneToMany(mappedBy="featureOption")
	private List<ProductFeature> productFeatures;

	public FeatureOption() {
	}

	public FeatureOptionPK getId() {
		return this.id;
	}

	public void setId(FeatureOptionPK id) {
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

	public Timestamp getUpdated() {
		return this.updated;
	}

	public void setUpdated(Timestamp updated) {
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
		productFeature.setFeatureOption(this);

		return productFeature;
	}

	public ProductFeature removeProductFeature(ProductFeature productFeature) {
		getProductFeatures().remove(productFeature);
		productFeature.setFeatureOption(null);

		return productFeature;
	}

}