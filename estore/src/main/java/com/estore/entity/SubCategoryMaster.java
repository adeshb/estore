package com.estore.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the sub_category_master database table.
 * 
 */
@Entity
@Table(name="sub_category_master")
@NamedQuery(name="SubCategoryMaster.findAll", query="SELECT s FROM SubCategoryMaster s")
public class SubCategoryMaster implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int subCategoryId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable=false)
	private Date created;

	@Column(length=45)
	private String description;

	private byte status;

	@Column(nullable=false, length=20)
	private String subCategory;

	@Lob
	private byte[] thumbnail;

	private Timestamp updated;

	//bi-directional many-to-one association to Product
	@OneToMany(mappedBy="subCategoryMaster")
	private List<Product> products1;

	//bi-directional many-to-one association to SubCatProductMap
	@OneToMany(mappedBy="subCategoryMaster")
	private List<SubCatProductMap> subCatProductMaps;

	//bi-directional many-to-one association to CategoryMaster
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="categoryId", nullable=false)
	private CategoryMaster categoryMaster;

	//bi-directional many-to-many association to Product
	@ManyToMany
	@JoinTable(
		name="sub_cat_product_map"
		, joinColumns={
			@JoinColumn(name="subCategoryId", nullable=false)
			}
		, inverseJoinColumns={
			@JoinColumn(name="productCatalogId", nullable=false)
			}
		)
	private List<Product> products2;

	public SubCategoryMaster() {
	}

	public int getSubCategoryId() {
		return this.subCategoryId;
	}

	public void setSubCategoryId(int subCategoryId) {
		this.subCategoryId = subCategoryId;
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

	public String getSubCategory() {
		return this.subCategory;
	}

	public void setSubCategory(String subCategory) {
		this.subCategory = subCategory;
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

	public List<Product> getProducts1() {
		return this.products1;
	}

	public void setProducts1(List<Product> products1) {
		this.products1 = products1;
	}

	public Product addProducts1(Product products1) {
		getProducts1().add(products1);
		products1.setSubCategoryMaster(this);

		return products1;
	}

	public Product removeProducts1(Product products1) {
		getProducts1().remove(products1);
		products1.setSubCategoryMaster(null);

		return products1;
	}

	public List<SubCatProductMap> getSubCatProductMaps() {
		return this.subCatProductMaps;
	}

	public void setSubCatProductMaps(List<SubCatProductMap> subCatProductMaps) {
		this.subCatProductMaps = subCatProductMaps;
	}

	public SubCatProductMap addSubCatProductMap(SubCatProductMap subCatProductMap) {
		getSubCatProductMaps().add(subCatProductMap);
		subCatProductMap.setSubCategoryMaster(this);

		return subCatProductMap;
	}

	public SubCatProductMap removeSubCatProductMap(SubCatProductMap subCatProductMap) {
		getSubCatProductMaps().remove(subCatProductMap);
		subCatProductMap.setSubCategoryMaster(null);

		return subCatProductMap;
	}

	public CategoryMaster getCategoryMaster() {
		return this.categoryMaster;
	}

	public void setCategoryMaster(CategoryMaster categoryMaster) {
		this.categoryMaster = categoryMaster;
	}

	public List<Product> getProducts2() {
		return this.products2;
	}

	public void setProducts2(List<Product> products2) {
		this.products2 = products2;
	}

}