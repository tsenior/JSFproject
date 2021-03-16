package com.tinyiko.jsf;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.tinyiko.CatalogItem;
import com.tinyiko.CatalogLocal;

//Backing Bean

@RequestScoped
@Named
public class CatalogItemFormBean implements Serializable{
	
	@Inject
	private CatalogLocal catalogLocalBean;
	
	@Inject
	private InventoryService inventoryService;
	
	private CatalogItem catalogItem = new CatalogItem();
	
	private List<CatalogItem> catalogItems = new ArrayList<>();
	
	private String searchText;
	
	public void searchByName() {
		this.catalogItems = this.catalogLocalBean.searchByName(this.searchText);
	}
	
	public String addItem() {
	//	long itemId = this.catalogLocalBean.getItems().size() + 1;
		this.catalogLocalBean.addItem(new CatalogItem(this.catalogItem.getName(), this.catalogItem.getManufacturer(),
				this.catalogItem.getDescription(),this.catalogItem.getAvailableDate()));
		
		this.inventoryService.createItem(this.catalogItem.getItemId(), this.catalogItem.getName());
		
		return "list?faces-redirect=true";
	}
	
	public void init() {
		this.catalogItems = this.catalogLocalBean.getItems();
	}
	
	public String getSearchText() {
		return searchText;
	}

	public void setSearchText(String searchText) {
		this.searchText = searchText;
	}

	public CatalogItem getCatalogItem() {
		return catalogItem;
	}

	public void setCatalogItem(CatalogItem catalogItem) {
		this.catalogItem = catalogItem;
	}

	public List<CatalogItem> getCatalogItems() {
		return catalogItems;
	}

	public void setCatalogItems(List<CatalogItem> catalogItems) {
		this.catalogItems = catalogItems;
	}
}
