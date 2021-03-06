package com.tinyiko.jsf;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import com.tinyiko.CatalogItem;
import com.tinyiko.CatalogLocal;

@SessionScoped
@Named
public class CatalogItemFormBean implements Serializable{
	
	@EJB
	private CatalogLocal catalogLocalBean;
	
	private CatalogItem catalogItem = new CatalogItem();
	
	private List<CatalogItem> catalogItems = new ArrayList<>();
	
	public String addItem() {
		long itemId = this.catalogLocalBean.getItems().size() + 1;
		
		this.catalogLocalBean.addItem(new CatalogItem(itemId, this.catalogItem.getName(), this.catalogItem.getManufacturer(),
				this.catalogItem.getDescription(),this.catalogItem.getAvailableDate()));
		
		this.catalogLocalBean.getItems().stream().forEach(item ->{
			System.out.println(item.toString());
		});
		
		return "list?faces-redirect=true";
	}
	
	public void init() {
		this.catalogItems = this.catalogLocalBean.getItems();
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
