package com.ntnn.binarysearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortingItem {
    public static class Item implements Comparable<Item> {
        String itemName;
        Integer cost;

        Item(String name, Integer cost) {
            this.itemName = name;
            this.cost = cost;
        }

        @Override
        public int compareTo(Item o) {
            int compareOne = this.cost.compareTo(o.cost);
            if (this.cost.compareTo(o.cost) != 0) return compareOne;
            return this.itemName.compareTo(o.itemName);
        }
    }

    public static void main(String[] args) {
        List<Item> items = Arrays.asList(new Item("coca", 4), new Item("tomato", 4), new Item("soda", 2), new Item("breads", 5));
        Collections.sort(items);
        items.forEach(v -> System.out.println(""+ v.itemName));
    }
}
