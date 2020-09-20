package com.java.nikitchem_example.model;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Stock {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	

	private int quantity;
	private String store;

	@JoinTable(name = "stocks_products", 
			joinColumns = @JoinColumn(name = "stock_id", referencedColumnName = "id"))
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private List<Product> products = new ArrayList<Product>();
	
}

