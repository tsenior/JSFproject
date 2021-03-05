package com.tinyiko.jsf;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import com.tinyiko.CatalogItem;

@SessionScoped
@Named
public class CatalogItemFormBean implements Serializable{
	
	private CatalogItem catalogItem = new CatalogItem();
	
	private List<CatalogItem> catalogItems = new ArrayList<>();
	
	public String addItem() {
		long itemId = this.catalogItems.size() + 1;
		
		this.catalogItems.add(new CatalogItem(itemId, this.catalogItem.getName(), this.catalogItem.getManufacturer(),
				this.catalogItem.getDescription(),this.catalogItem.getAvailableDate() ));
		this.catalogItems.stream().forEach(item ->{
			System.out.println(item.toString());
		});
		
		return "list?faces-redirect=true";
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
