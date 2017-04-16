package com.michael.models;

import java.util.List;

/**
 * Created by maste on 4/16/2017.
 */
public class Datasets<T> {
    private List<T> Items;
    private long Count;

    public List<T> getItems() {
        return Items;
    }

    public void setItems(List<T> items) {
        Items = items;
    }

    public long getCount() {
        return Count;
    }

    public void setCount(long count) {
        Count = count;
    }
}
