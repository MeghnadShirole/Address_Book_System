package com.company;

/*Service class
 * @author bridge it
 *
 */
public class Service {
    AddressBook addressBook = new AddressBookController();

    public void createAddressBook() {
        addressBook.createAddressBook();
    }

    public void addPerson(String addressBookName1) {
        addressBook.addPerson(addressBookName1);
    }

    public void deletePerson() {
        addressBook.deletePerson();
    }

    public void updatePerson() {
        addressBook.updatePerson();
    }

}
