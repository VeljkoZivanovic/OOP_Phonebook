//package Test;
//
//import model.Contact;
//import service.PhoneDirectory;
//
//public class PhoneDirectoryTest {
//
//    @Test
//    public void testAddContact() {
//        PhoneDirectory directory = new PhoneDirectory();
//        Contact contact = new Contact("John Doe", "123456789");
//        directory.addContact(contact);
//        assertEquals(1, directory.getContacts().size());
//    }
//
//    @Test
//    public void testFindContactByName() {
//        PhoneDirectory directory = new PhoneDirectory();
//        Contact contact = new Contact("John Doe", "123456789");
//        directory.addContact(contact);
//        Contact found = directory.findContactByName("John Doe");
//        assertNotNull(found);
//        assertEquals("123456789", found.getPhoneNumber());
//    }
//
//    @Test
//    public void testRemoveContact() {
//        PhoneDirectory directory = new PhoneDirectory();
//        Contact contact = new Contact("John Doe", "123456789");
//        directory.addContact(contact);
//        directory.removeContact("John Doe");
//        assertNull(directory.findContactByName("John Doe"));
//    }
//
//    @Test
//    public void testUpdateContact() {
//        PhoneDirectory directory = new PhoneDirectory();
//        Contact contact = new Contact("John Doe", "123456789");
//        directory.addContact(contact);
//        directory.updateContact("John Doe", "Jane Doe", "987654321");
//        Contact updated = directory.findContactByName("Jane Doe");
//        assertNotNull(updated);
//        assertEquals("987654321", updated.getPhoneNumber());
//    }
//}
//
