package com.zipcodewilmington.phonebook;

import java.util.*;

/**
 * Created by leon on 1/23/18.
 */
public class PhoneBook {
    public Map<String, List<String>> phoneBook;

    public PhoneBook(Map<String, List<String>> map) { phoneBook = map; }
    public PhoneBook(){

        phoneBook = new LinkedHashMap<>();
    }

    public void add(String name, String phoneNumber) {
     ArrayList<String> number = new ArrayList<>(Arrays.asList(phoneNumber));
        phoneBook.put(name, number);
        }

    public void addAll(String name, String... phoneNumbers) {
       ArrayList<String> number = new ArrayList<>(Arrays.asList(phoneNumbers));
       phoneBook.put(name, number);
    }

    public void remove(String name) { phoneBook.remove(name);}

    public Boolean hasEntry(String name){
        ArrayList<String> number = new ArrayList<>(Arrays.asList(name));
        return phoneBook.containsKey(name) || phoneBook.containsValue(number);
    }

    public List<String> lookup(String name) {
        return phoneBook.get(name);
    }

    public String reverseLookup(String phoneNumber) {
        for (Map.Entry<String, List<String>> entry : phoneBook.entrySet()) {
            if (entry.getValue().contains(phoneNumber)) {
                return entry.getKey();
            }
        }
        return null;
    }

    public List<String> getAllContactNames() {
        ArrayList<String> names = new ArrayList<>();
        for (String name: phoneBook.keySet()){
            names.add(name);
        }
        return names;
    }
    public Map<String, List<String>> getMap() {

        return phoneBook;
    }
}
