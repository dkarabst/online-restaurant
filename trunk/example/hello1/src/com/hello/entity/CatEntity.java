package com.hello.entity;

import javax.persistence.*;

@Entity
@Table(name="CATEGORIES")
public class CatEntity {
	@Id
	@Column(name="CAT_ID")
	@GeneratedValue (strategy = GenerationType.AUTO)
	private int catId;
	
	@Column(name="CAT_NAME", length=30)
	private String catName;

	public int getCatId() {
		return catId;
	}

	public void setCatId(int catId) {
		this.catId = catId;
	}

	public String getCatName() {
		return catName;
	}

	public void setCatName(String catName) {
		this.catName = catName;
	}
}
