package com.estore.jpa;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the location_type database table.
 * 
 */
@Entity
@Table(name="location_type")
@NamedQuery(name="LocationType.findAll", query="SELECT l FROM LocationType l")
public class LocationType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int typeId;

	@Temporal(TemporalType.TIMESTAMP)
	private Date created;

	private byte status;

	private String type;

	private Timestamp updated;

	//bi-directional many-to-one association to CategoryMaster
	@JsonIgnore
	@OneToMany(mappedBy="locationType")
	private List<CategoryMaster> categoryMasters;

	public LocationType() {
	}

	public int getTypeId() {
		return this.typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
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

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Timestamp getUpdated() {
		return this.updated;
	}

	public void setUpdated(Timestamp updated) {
		this.updated = updated;
	}

	public List<CategoryMaster> getCategoryMasters() {
		return this.categoryMasters;
	}

	public void setCategoryMasters(List<CategoryMaster> categoryMasters) {
		this.categoryMasters = categoryMasters;
	}

	public CategoryMaster addCategoryMaster(CategoryMaster categoryMaster) {
		getCategoryMasters().add(categoryMaster);
		categoryMaster.setLocationType(this);

		return categoryMaster;
	}

	public CategoryMaster removeCategoryMaster(CategoryMaster categoryMaster) {
		getCategoryMasters().remove(categoryMaster);
		categoryMaster.setLocationType(null);

		return categoryMaster;
	}

}