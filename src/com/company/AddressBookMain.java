package com.company;

import java.util.Scanner;

/**Main class logic
 * @author bridgeit
 *
 */
public class AddressBookMain {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Service service = new Service();
        System.out.println("****************Menu*****************");

        String answer;

        do {

            System.out.println(
                    "\nchoices are :\n1. create AddressBook \n2. Add Person \n3. Delete Person \n4. Update Person ");
            System.out.println("\nEnter your choice ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    service.createAddressBook();
                    break;
                case 2:
                    System.out.println("\nGive the name to address book ");
                    String addressBookName1 = scanner.next();
                    service.addPerson(addressBookName1);
                    break;
                case 3:
                    service.deletePerson();
                    break;
                case 4:
                    service.updatePerson();
                    break;
            }
            System.out.println("\n Do you want to continue :? (yes/no) ");
            answer = scanner.next();
        } while (answer.equalsIgnoreCase("yes"));

        if (answer.equalsIgnoreCase("no")) {
            System.out.println("thank you.....");
        }
    }
}