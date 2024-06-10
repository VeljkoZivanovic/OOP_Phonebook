package service;

import model.Contact;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class PhoneDirectory {
    private List<Contact> contacts;
    private Scanner scanner;

    public PhoneDirectory() {
        contacts = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void addContact(Contact contact) {
        for (Contact c : contacts) {
            if (c.getPhoneNumber().equals(contact.getPhoneNumber())) {
                System.out.println("Contact already exists");
                return;
            }
        }
        contacts.add(contact);
        System.out.println("Contact added successfully!");
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public List<Contact> findContactsByName(String name) {
        List<Contact> matchingContacts = new ArrayList<>();
        for (Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(name)) {
                matchingContacts.add(contact);
            }
        }
        return matchingContacts;
    }


    public Contact findContactByPhoneNumber(String phoneNumber) {
        for (Contact contact : contacts) {
            if (contact.getPhoneNumber().equalsIgnoreCase(phoneNumber)) {
                return contact;
            }
        }
        return null;
    }

    public void removeContact(String phoneNumber) {
        if(contacts.isEmpty()){
            System.out.println("No contacts in the phonebook!");
        }
        else{
            for (Contact c: contacts) {
                if(c.getPhoneNumber().equalsIgnoreCase(phoneNumber)){
                    contacts.remove(c);
                    System.out.println("Contact removed successfully!");
                }
                else System.out.println("No contacts found with the number: " + phoneNumber);

            }
        }
    }
    public void sortContactsByName() {
        contacts.sort(Comparator.comparing(Contact::getName));
    }

    public void sortContactsByPhoneNumber() {
        contacts.sort(Comparator.comparing(Contact::getPhoneNumber));
    }
    public void clearContacts() {
        contacts.clear();
    }

}

