package com.tinyiko.jsf;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.tinyiko.CatalogItem;
import com.tinyiko.CatalogLocal;

@Named
@ConversationScoped
public class CatalogItemDeleteBean implements Serializable{
	
	private Long catalogItemId;

	
	private CatalogItem catalogItem;
	
	@Inject
	private CatalogItemFormBean catalogItemFormBean;
	
	@Inject
	private CatalogLocal catalogBean;
	
	@Inject
	private Conversation conversation;
	
	
	public void fetchItem() {
		conversation.begin();
		this.catalogItem=catalogBean.findItem(this.catalogItemId);

	}
	
	public String removeItem() {
		/*this.catalogItemFormBean.getCatalogItems().removeIf(item ->{
			return item.getItemId().equals(this.catalogItemId);
		});*/
		this.catalogBean.deleteItem(this.catalogItem);
		conversation.end();
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
