package com.proyects.microservices.app.productscommonsmicroservice.models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import com.sun.istack.NotNull;

@Entity
@Table(name = "products")
public class Product implements Serializable {

	private static final long serialVersionUID = -8165569117907559095L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "mark")
	private String mark;
	
	@Column(name = "description")
	private String description;
	
	//Corregir: hacer un ManyToOne
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "products_to_categories", joinColumns = @JoinColumn(name="products_id"), 
	inverseJoinColumns = @JoinColumn(name="categories_id"), 
	uniqueConstraints = {@UniqueConstraint(columnNames = {"products_id", "categories_id"})})
	private List <Category> category;
	
	@Column(name = "price")
	private Double price;
	
	@Column(name = "nationality")
	private String nationality;
	
	@Column(name = "create_at")
	@Temporal(value = TemporalType.DATE)
	private Date create_at;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public Date getCreate_at() {
		return create_at;
	}

	public void setCreate_at(Date create_at) {
		this.create_at = create_at;
	}

	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public List<Category> getCategory() {
		return category;
	}

	public void setCategory(List<Category> category) {
		this.category = category;
	}

}
