package com.adbhut.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "product")
public class Product {
	
	static Gson gson = new GsonBuilder().setPrettyPrinting().create();
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column
	private String name;

	@Column
	private String description;

	@Column(name = "IMAGE_URL")
	private String imageUrl;

	@Column
	private BigDecimal price;

	@Override
	public String toString() {
		return new Gson().toJson(this);
	}
}
