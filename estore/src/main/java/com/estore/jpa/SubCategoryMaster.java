package com.estore.jpa;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	private int subCategoryId;

	@Temporal(TemporalType.TIMESTAMP)
	private Date created;

	private String description;

	private byte status;

	private String subCategory;

	@Lob
	private byte[] thumbnail;

	private Timestamp updated;

	//bi-directional many-to-one association to Product
	@JsonIgnore
	@OneToMany(mappedBy="subCategoryMaster")
	private List<Product> products;

	//bi-directional many-to-one association to SubCatProductMap
	@JsonIgnore
	@OneToMany(mappedBy="subCategoryMaster")
	private List<SubCatProductMap> subCatProductMaps;

	//bi-directional many-to-one association to CategoryMaster
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="categoryId")
	private CategoryMaster categoryMaster;

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

	public List<Product> getProducts() {
		return this.products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Product addProduct(Product product) {
		getProducts().add(product);
		product.setSubCategoryMaster(this);

		return product;
	}

	public Product removeProduct(Product product) {
		getProducts().remove(product);
		product.setSubCategoryMaster(null);

		return product;
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

}