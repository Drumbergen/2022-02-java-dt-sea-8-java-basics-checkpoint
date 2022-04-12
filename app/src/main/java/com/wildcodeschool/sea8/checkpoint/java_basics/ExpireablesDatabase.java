package com.wildcodeschool.sea8.checkpoint.java_basics;

import java.util.ArrayList;
import java.util.List;

public class ExpireablesDatabase<E extends IExpireable> {
    private List<E> listOfExpireables = new ArrayList<>();

    public void addItem(E item) {
        // TODO: add a new item to the list
        listOfExpireables.add(item);  // Andi
    }

    public void removeExpired() {
        // TODO: implement the neccessary function to delete all expired entries from the list
        
    }

    public void sortByExpirationDate(boolean descending) {
        // TODO: sort the list by the expiration date of it's entries
        // hint: use a comparator and expiryDate()
    }

    public E getFirstEntry() {
        // TODO: Return first item in the list
        return listOfExpireables.get(1); // Andi
    }

    public E getLastEntry() {
        // TODO: Return last item in the list
        return listOfExpireables.get(listOfExpireables.size()-1); // Andi
    }

    public List<E> getList() {
        return listOfExpireables;
    }

}
