package com.jbk.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="category")
public class CategoryEntity {

	@Id
	private long categoryid;
	
	@Column(nullable=false,unique=true)
	private String categorynm;
	
	@Column(nullable=false,unique=true)
	private String description;
	
	@Column(nullable=false)
	private int discount;
	
	@Column(nullable=false)
	private int gst;
	
	
	public CategoryEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CategoryEntity(long categoryid, String categorynm, String description, int discount, int gst) {
		super();
		this.categoryid = categoryid;
		this.categorynm = categorynm;
		this.description = description;
		this.discount = discount;
		this.gst = gst;
	}
	public long getCategoryid() {
		return categoryid;
	}
	public void setCategoryid(long categoryid) {
		this.categoryid = categoryid;
	}
	public String getCategorynm() {
		return categorynm;
	}
	public void setCategorynm(String categorynm) {
		this.categorynm = categorynm;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	public int getGst() {
		return gst;
	}
	public void setGst(int gst) {
		this.gst = gst;
	}
	@Override
	public String toString() {
		return "CategoryModel [categoryid=" + categoryid + ", categorynm=" + categorynm + ", description=" + description
				+ ", discount=" + discount + ", gst=" + gst + "]";
	}
	
}
