package com.estore.jpa;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the feature_type_master database table.
 * 
 */
@Entity
@Table(name="feature_type_master")
@NamedQuery(name="FeatureTypeMaster.findAll", query="SELECT f FROM FeatureTypeMaster f")
public class FeatureTypeMaster implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int featureTypeId;

	@Temporal(TemporalType.TIMESTAMP)
	private Date created;

	private String description;

	private String featureType;

	private byte status;

	private Timestamp updated;

	//bi-directional many-to-one association to FeatureOption
	@OneToMany(mappedBy="featureTypeMaster")
	private List<FeatureOption> featureOptions;

	public FeatureTypeMaster() {
	}

	public int getFeatureTypeId() {
		return this.featureTypeId;
	}

	public void setFeatureTypeId(int featureTypeId) {
		this.featureTypeId = featureTypeId;
	}

	public Date getCreated() {
		return this.created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getFeatureType() {
		return this.featureType;
	}

	public void setFeatureType(String featureType) {
		this.featureType = featureType;
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

	public List<FeatureOption> getFeatureOptions() {
		return this.featureOptions;
	}

	public void setFeatureOptions(List<FeatureOption> featureOptions) {
		this.featureOptions = featureOptions;
	}

	public FeatureOption addFeatureOption(FeatureOption featureOption) {
		getFeatureOptions().add(featureOption);
		featureOption.setFeatureTypeMaster(this);

		return featureOption;
	}

	public FeatureOption removeFeatureOption(FeatureOption featureOption) {
		getFeatureOptions().remove(featureOption);
		featureOption.setFeatureTypeMaster(null);

		return featureOption;
	}

}