package com.tinyiko.jsf.backingbean;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.tinyiko.ejbean.CatalogLocal;
import com.tinyiko.entities.CatalogItem;
import com.tinyiko.entities.ItemManager;

@Named
@ConversationScoped
public class CatalogItemDetailBean implements Serializable{
	
	private Long catalogItemId;


	private CatalogItem catalogItem;

	@Inject
	private Conversation conversation;

	@Inject
	private CatalogLocal catalogBean;
	
	
	private ItemManager itemManager = new ItemManager();


	public void fetchItem() {
		this.catalogItem = this.catalogBean.findItem(this.catalogItemId);

	}

	public void addManager() {
		this.itemManager.getCatalogItems().add(this.catalogItem);
		this.catalogItem.getItemManagers().add(this.itemManager);
		
		this.catalogBean.saveItem(catalogItem);
		this.catalogItem = this.catalogBean.findItem(catalogItemId);
	}

	@PostConstruct
	public void init() {
		this.conversation.begin();
	}

	@PreDestroy
	public void destroy() {
		this.conversation.end();
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

	public ItemManager getItemManager() {
		return itemManager;
	}

	public void setItemManager(ItemManager itemManager) {
		this.itemManager = itemManager;
	}

}





