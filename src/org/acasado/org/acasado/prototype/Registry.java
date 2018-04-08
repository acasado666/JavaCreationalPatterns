package org.acasado.org.acasado.prototype;

import java.util.HashMap;
import java.util.Map;

public class Registry {

	private Map<String, Item> items = new HashMap<String, Item>();
	
	public Registry() {
		loadItems();
	}
	
	public Item createItem (String type) {
		Item item = null;
		
		try {
			// From Map we get the appropiate value and clone it
			item = (Item) items.get(type).clone();
		}
		catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		
		return item;
	}

	//Contains items to be cloned one of each
	private void loadItems() {
		Movie movie = new Movie();
		movie.setTitle("Basic Movie");
		movie.setPrice(24.99);
		movie.setRuntime("2 hours");
		items.put("Movie", movie);
		
		Book book = new Book();
		book.setNumberOfPages(335);
		book.setPrice(19.99);
		book.setTitle("Basic Book");
		items.put("Book", book);
	}
}
