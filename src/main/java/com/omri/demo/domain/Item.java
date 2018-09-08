package com.omri.demo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class Item {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	private String item_name;
	
	@Column(nullable = false)
	private String inventory_code;
	
	@Column(nullable = false)
	private int amount;
	

	protected Item() {
	     // no-args constructor required by JPA spec
        // this one is protected since it shouldn't be used directly
    }
	
	
	public Item(String item_name, String inventory_code, int amount) {
		this.item_name = item_name;
		this.inventory_code = inventory_code;
		this.amount = amount;
	}

    @ApiModelProperty(notes = "Item id", required = true)
	public Long getId() {
		return id;
	}
	
	
    @ApiModelProperty(notes = "Item name", required = true)
	public String getItemName() {
		return item_name;
	}


	public void setItemName(String item_name) {
		this.item_name = item_name;
	}


    @ApiModelProperty(notes = "The inventory code of the item", required = true)
	public String getInventoryCode() {
		return inventory_code;
	}


	public void setInventoryCode(String inventory_code) {
		this.inventory_code = inventory_code;
	}


    @ApiModelProperty(notes = "The amount of an item in inventory", required = true)
	public int getAmount() {
		return amount;
	}


	public void setAmount(int amount) {
		this.amount = amount;
	}


}
