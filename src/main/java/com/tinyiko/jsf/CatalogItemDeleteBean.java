package com.tinyiko.jsf;

import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.tinyiko.CatalogItem;

@Named
@RequestScoped
public class CatalogItemDeleteBean {
	
	private Long catalogItemId;

	
	private CatalogItem catalogItem;
	
	@Inject
	private CatalogItemFormBean catalogItemFormBean;
	
	
	public void fetchItem() {
		
		List<CatalogItem> catalogItems = this.catalogItemFormBean.getCatalogItems().stream().filter(i -> {
			return i.getItemId() == catalogItemId;
		}).collect(Collectors.toList());
	
		if(catalogItems.isEmpty()) {
			this.catalogItem = null;
		}else {
			this.catalogItem = catalogItems.get(0);
		}
	}
	
	public String removeItem() {
		this.catalogItemFormBean.getCatalogItems().removeIf(item ->{
			return item.getItemId().equals(this.catalogItemId);
		});
		return "list?faces-redirect=true";
	}

	public Long getCatalogItemId() {
		return catalogItemId;
	}

	public void setCatalogItemId(Long catalogItemId) {
		this.catalogItemId = catalogItemId;
	}

	public CatalogItem getCatalogItem() {
		return catalogItem;
	}

	public void setCatalogItem(CatalogItem catalogItem) {
		this.catalogItem = catalogItem;
	}

	public CatalogItemFormBean getCatalogItemFormBean() {
		return catalogItemFormBean;
	}

	public void setCatalogItemFormBean(CatalogItemFormBean catalogItemFormBean) {
		this.catalogItemFormBean = catalogItemFormBean;
	}
	
	
	
	
	
}
