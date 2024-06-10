import model.Contact;
import service.PhoneDirectory;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class PhoneDirectoryTest {

    @Test
    public void testAddContact() {
        PhoneDirectory directory = new PhoneDirectory();
        Contact contact = new Contact("John Doe", "123456789");
        directory.addContact(contact);
        assertEquals(1, directory.getContacts().size());
    }

    @Test
    public void testFindContactsByName() {
        PhoneDirectory directory = new PhoneDirectory();
        Contact contact = new Contact("John Doe", "123456789");
        directory.addContact(contact);
        List<Contact> foundContacts = directory.findContactsByName("John Doe");
        assertFalse(foundContacts.isEmpty());
        assertEquals("John Doe", foundContacts.get(0).getName());
    }

    @Test
    public void testFindContactsByPhoneNumber(){
        PhoneDirectory directory = new PhoneDirectory();
        Contact contact = new Contact("John Doe", "123456789");
        directory.addContact(contact);
        Contact found = directory.findContactByPhoneNumber("123456789");
        assertNotNull(found);
        assertEquals("123456789", found.getPhoneNumber());
    }
}


