package ui;

import model.Contact;
import service.PhoneDirectory;
import util.FileManager;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private PhoneDirectory phoneDirectory;
    private Scanner scanner;

    public UserInterface() {
        phoneDirectory = new PhoneDirectory();
        scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            try {
                System.out.println("1. Add Contact");
                System.out.println("2. Find Contact by Name");
                System.out.println("3. Find Contact by Phone Number");
                System.out.println("4. Remove Contact");
                System.out.println("5. Display All Contacts");
                System.out.println("6. Save Contacts");
                System.out.println("7. Load Contacts");
                System.out.println("8. Update Contact");
                System.out.println("9. Sort Contacts");
                System.out.println("10. Clear Phonebook");
                System.out.println("11. Exit");
                System.out.print("Choose an option: ");
                int option = Integer.parseInt(scanner.nextLine());

                switch (option) {
                    case 1:
                        addContact();
                        break;
                    case 2:
                        findContactByName();
                        break;
                    case 3:
                        findContactByPhoneNumber();
                        break;
                    case 4:
                        removeContact();
                        break;
                    case 5:
                        displayAllContacts();
                        break;
                    case 6:
                        saveContacts();
                        break;
                    case 7:
                        loadContacts();
                        break;
                    case 8:
                        updateContact();
                        break;
                    case 9:
                        sortContacts();
                        break;
                    case 10:
                        clearPhonebook();
                        break;
                    case 11:
                        return;
                    default:
                        System.out.println("Invalid option.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
            }
        }
    }


    private void addContact() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter phone number: ");
        String phoneNumber = scanner.nextLine();
        phoneDirectory.addContact(new Contact(name, phoneNumber));
    }

    private void findContactByName() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        List<Contact> contacts = phoneDirectory.findContactsByName(name);
        if (contacts.isEmpty()) {
            System.out.println("No contacts found with the name: " + name);
        } else {
            for (Contact contact : contacts) {
                System.out.println(contact);
            }
        }
    }

    private void findContactByPhoneNumber() {
        System.out.print("Enter phone number: ");
        String phoneNumber = scanner.nextLine();
        Contact contact = phoneDirectory.findContactByPhoneNumber(phoneNumber);
        if (contact != null) {
            System.out.println(contact);
        } else {
            System.out.println("Contact with number: " + phoneNumber + " not found.");
        }
    }

    private void removeContact() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        phoneDirectory.removeContact(name);
    }

    private void displayAllContacts() {
        if(phoneDirectory.getContacts().isEmpty()){
            System.out.println("The phonebook is empty.");
        }
        else{
            for (Contact contact : phoneDirectory.getContacts()) {
                System.out.println(contact);
            }
        }
    }

    private void saveContacts() {
        try {
            System.out.print("Enter filename: ");
            String filename = scanner.nextLine();
            FileManager.saveContacts(phoneDirectory.getContacts(), filename);
            System.out.println("Contacts saved to " + filename + ".txt");
        } catch (IOException e) {
            System.out.println("Error saving contacts: " + e.getMessage());
        }
    }

    private void loadContacts() {
        try {
            System.out.print("Enter filename: ");
            String filename = scanner.nextLine();
            List<Contact> contacts = FileManager.loadContacts(filename);
            phoneDirectory.getContacts().addAll(contacts);
            System.out.println("Contacts loaded from " + filename + ".txt");
        } catch (IOException e) {
            System.out.println("Error loading contacts: " + e.getMessage());
        }
    }

    private void updateContact() {
        System.out.print("Enter the phone number of the contact to update: ");
        String phoneNumber = scanner.nextLine();
        Contact contact = phoneDirectory.findContactByPhoneNumber(phoneNumber);

        if (contact == null) {
            System.out.println("Contact not found.");
            return;
        }

        System.out.println("What do you want to update?");
        System.out.println("1. Name");
        System.out.println("2. Phone Number");
        System.out.print("Choose an option: ");
        int option = Integer.parseInt(scanner.nextLine());

        switch (option) {
            case 1:
                System.out.print("Enter the new name: ");
                String newName = scanner.nextLine();
                contact.setName(newName);
                System.out.println("Name updated.");
                break;
            case 2:
                System.out.print("Enter the new phone number: ");
                String newPhoneNumber = scanner.nextLine();
                contact.setPhoneNumber(newPhoneNumber);
                System.out.println("Phone number updated.");
                break;
            default:
                System.out.println("Invalid option.");
                break;
        }
    }

    private void sortContacts() {
        System.out.println("1. Sort by name");
        System.out.println("2. Sort by phone number");
        System.out.print("Choose an option: ");
        int option = Integer.parseInt(scanner.nextLine());

        if (option == 1) {
            phoneDirectory.sortContactsByName();
            displayAllContacts();
        } else if (option == 2) {
            phoneDirectory.sortContactsByPhoneNumber();
            displayAllContacts();
        } else {
            System.out.println("Invalid option.");
        }
    }

    private void clearPhonebook() {
        phoneDirectory.clearContacts();
        System.out.println("Phonebook has been cleared.");
    }

}
