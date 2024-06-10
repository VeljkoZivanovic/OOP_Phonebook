package util;

import model.Contact;

import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

public class FileManager {
    private static final String DIRECTORY = "Phonebook";

    public static void saveContacts(List<Contact> contacts, String filename) throws IOException {
        Path dirPath = Paths.get(DIRECTORY);
        if (!Files.exists(dirPath)) {
            Files.createDirectory(dirPath);
        }

        Path filePath = dirPath.resolve(filename + ".txt");
        try (BufferedWriter writer = Files.newBufferedWriter(filePath)) {
            for (Contact contact : contacts) {
                writer.write(contact.getName() + "," + contact.getPhoneNumber());
                writer.newLine();
            }
        }
    }

    public static List<Contact> loadContacts(String filename) throws IOException {
        Path filePath = Paths.get(DIRECTORY, filename + ".txt");
        if (!Files.exists(filePath)) {
            throw new FileNotFoundException("File not found: " + filePath.toString());
        }

        List<Contact> contacts;
        try (BufferedReader reader = Files.newBufferedReader(filePath)) {
            contacts = new ArrayList<>();
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 2) {
                    contacts.add(new Contact(parts[0], parts[1]));
                }
            }
        }
        return contacts;
    }
}



