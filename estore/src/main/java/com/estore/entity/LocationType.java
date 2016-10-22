package com.estore.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.sql.Timestamp;
import java.util.List;


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
	@Column(unique=true, nullable=false)
	private int typeId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable=false)
	private Date created;

	@Column(nullable=false)
	private byte status;

	@Column(nullable=false, length=45)
	private String type;

	private Timestamp updated;

	//bi-directional many-to-one association to CategoryMaster
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