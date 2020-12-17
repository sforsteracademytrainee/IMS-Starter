package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.ItemDAO;
import com.qa.ims.persistence.domain.Item;
import com.qa.ims.utils.Utils;

public class ItemController implements CrudController<Item> {
	
	public static final Logger LOGGER = LogManager.getLogger();
	
	private ItemDAO itemDAO;
	private Utils utils;
	
	public ItemController(ItemDAO itemDAO, Utils utils) {
		super();
		this.itemDAO = itemDAO;
		this.utils = utils;
	}
	
	@Override
	public List<Item> readAll() {
		List<Item> items = itemDAO.readAll();
		for (Item item : items) {
			LOGGER.info(item.toString());
		}
		return null;
	}

	@Override
	public Item create() {
		LOGGER.info("Please enter a name");
		String name = utils.getString();
		LOGGER.info("Please enter a value");
		float value = utils.getFloat();
		LOGGER.info("Please enter a category (1 for General)");
		int category = utils.getInt();
		LOGGER.info("Please enter a quantity");
		int quantity = utils.getInt();
		Item item = itemDAO.create(new Item(name, value, category, quantity));
		LOGGER.info("Item created");
		return item;
	}

	@Override
	public Item update() {
		LOGGER.info("Please enter the id of the item you would like to update");
		Long id = utils.getLong();
		LOGGER.info("Please enter a name");
		String name = utils.getString();
		LOGGER.info("Please enter a value");
		float value = utils.getFloat();
		LOGGER.info("Please enter a category (1 for General)");
		int category = utils.getInt();
		LOGGER.info("Please enter a quantity");
		int quantity = utils.getInt();
		Item item = itemDAO.update(new Item(id, name, value, category, quantity));
		LOGGER.info("Item updated");
		return item;
	}

	@Override
	public int delete() {
		LOGGER.info("Please enter the id of the item you would like to delete");
		Long id = utils.getLong();
		return itemDAO.delete(id);
	}

}