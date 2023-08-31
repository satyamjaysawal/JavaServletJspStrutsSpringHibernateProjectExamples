package com.exampleAbstraction;

import java.util.ArrayList;
import java.util.List;

public class Library {
   List<Item> items = new ArrayList<>();


    public void addItem(Item item) {
        items.add(item);
    }

    public void displayItems() {
        for (Item item : items) {
        	 System.out.println("Type: " + item.getType());
             System.out.println("Details: " + item);
             System.out.println();  
        }
    }
}
