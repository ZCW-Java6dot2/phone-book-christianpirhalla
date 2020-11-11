package com.zipcodewilmington.phonebook;

import java.util.*;
//import java.util.HashMap;


/**
 * Created by leon on 1/23/18.
 * Made WAY better by kristofer 6/16/20
 */
public class PhoneBook {

    private final Map<String, List<String>> phonebook;

    public PhoneBook(Map<String, List<String>> map) {
        this.phonebook = map;
    }

    public PhoneBook() {
        this(new LinkedHashMap<String, List<String>>() {
        });
    }

    public void add(String name, String phoneNumber) {
        String[] number = {phoneNumber};
        phonebook.putIfAbsent(name, Arrays.asList(number));
    }

    public void addAll(String name, String... phoneNumbers) {
        phonebook.putIfAbsent(name, Arrays.asList(phoneNumbers));
    }

    public void remove(String name) {
        phonebook.remove(name);
    }

    public Boolean hasEntry(String name) {
        return phonebook.containsKey(name);
    }

    public Boolean hasEntry(String name, String number){
        if (phonebook.containsKey(name) && phonebook.get(name).contains(number)){
            return true;
        }
        return false;
    }

    public List<String> lookup(String name) {
        return phonebook.get(name);
    }

    public String reverseLookup(String phoneNumber)  {
        for (String s : phonebook.keySet()){
            for (String n : phonebook.get(s)){
                if (n.equals(phoneNumber)){
                    return s;
                }
            }
        }
        return "No name associated with that number";
    }

    public List<String> getAllContactNames() {
        ArrayList<String> contactNames = new ArrayList<>();
        for (String s : phonebook.keySet()){
            contactNames.add(s);
        }
        return contactNames;
    }

    public Map<String, List<String>> getMap() {
        return phonebook;
    }
}
