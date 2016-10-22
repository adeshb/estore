package com.estore.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the category_master database table.
 * 
 */
@Entity
@Table(name="category_master")
@NamedQuery(name="CategoryMaster.findAll", query="SELECT c FROM CategoryMaster c")
public class CategoryMaster implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int categoryId;

	@Column(length=20)
	private String category;

	@Temporal(TemporalType.TIMESTAMP)
	private Date created;

	@Column(length=45)
	private String description;

	private byte status;

	@Lob
	private byte[] thumbnail;

	private Timestamp updated;

	//bi-directional many-to-one association to LocationType
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="typeId", nullable=false)
	private LocationType locationType;

	//bi-directional many-to-one association to SubCategoryMaster
	@OneToMany(mappedBy="categoryMaster")
	private List<SubCategoryMaster> subCategoryMasters;

	public CategoryMaster() {
	}

	public int getCategoryId() {
		return this.categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
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

	public byte getStatus() {
		return this.status;
	}

	public void setStatus(byte status) {
		this.status = status;
	}

	public byte[] getThumbnail() {
		return this.thumbnail;
	}

	public void setThumbnail(byte[] thumbnail) {
		this.thumbnail = thumbnail;
	}

	public Timestamp getUpdated() {
		return this.updated;
	}

	public void setUpdated(Timestamp updated) {
		this.updated = updated;
	}

	public LocationType getLocationType() {
		return this.locationType;
	}

	public void setLocationType(LocationType locationType) {
		this.locationType = locationType;
	}

	public List<SubCategoryMaster> getSubCategoryMasters() {
		return this.subCategoryMasters;
	}

	public void setSubCategoryMasters(List<SubCategoryMaster> subCategoryMasters) {
		this.subCategoryMasters = subCategoryMasters;
	}

	public SubCategoryMaster addSubCategoryMaster(SubCategoryMaster subCategoryMaster) {
		getSubCategoryMasters().add(subCategoryMaster);
		subCategoryMaster.setCategoryMaster(this);

		return subCategoryMaster;
	}

	public SubCategoryMaster removeSubCategoryMaster(SubCategoryMaster subCategoryMaster) {
		getSubCategoryMasters().remove(subCategoryMaster);
		subCategoryMaster.setCategoryMaster(null);

		return subCategoryMaster;
	}

}