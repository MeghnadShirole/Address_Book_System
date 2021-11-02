package com.company;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Iterator;

    /**
     * Address Book Controller implementation class
     *
     * @author bridgeit
     *
     *
     */
    public class AddressBookController implements AddressBook {
        Scanner scanner = new Scanner(System.in);
        Person person = new Person();
        CheckUniqueness ch=new CheckUniqueness();
        LinkedList<Person> linkedList = new LinkedList<>();
        HashMap<String, LinkedList> hashMap = new HashMap<>();
       // String addressBookName;

        public void createAddressBook() {
            System.out.println("\nCreate address book ");
            System.out.println("\n give name to address book ");
            String addressBookName = scanner.next();
            System.out.println("Address book name is :" + addressBookName);
            if (hashMap.containsKey(addressBookName)) {
                System.out.println("\n address book is already exist with same name ,do u want to create another?(yes/no)");
                String ans = scanner.next();
                if (ans.equalsIgnoreCase("yes")) {
                    createAddressBook();
                }
            } else {
                hashMap.put(addressBookName, new LinkedList<Person>());
            }
        }

        /*
         * (non-Javadoc)Adding person details to the address book
         *
         * @see service.AddressBook#addPerson(java.lang.String)
         */
        public void addPerson(String addressBookName1) {
            if (hashMap.containsKey(addressBookName1)) {
                person = new Person();
                linkedList = new LinkedList<Person>();
                System.out.println("\nEnter first name :");
                String firstName = scanner.next();
                person.setFirstName(firstName);
                System.out.println("\nEnter last name :");
                String lastName = scanner.next();
                person.setLastName(lastName);
                System.out.println("\nEnter address :");
                scanner.next();
                String address = scanner.nextLine();
                person.setAddress(address);
                System.out.println("\nEnter state name :");
                String state = scanner.next();
                person.setState(state);
                System.out.println("\nEnter zip code :");
                int zip = scanner.nextInt();
                int length1=Integer.toString(zip).length();//to check the length of int ,it is done by converting int to string and then calc length
                if(length1==6){
                    person.setZip(zip);
                }
                else{
                    System.out.println("Invalid length of zip code it must be 6 digits only");
                    System.out.println("\nEnter zip code :");
                    int zip1 = scanner.nextInt();
                    int length=Integer.toString(zip1).length();
                    if(length==6){
                        person.setZip(zip);
                    }
                }
                System.out.println("\nEnter 10 digit phone number :");
                long phone = scanner.nextLong();
                int length2=Long.toString(phone).length();
                if(length2==10){
                    person.setPhone(phone);
                    ch.checkUniqueness(firstName);
                }

                else{
                    System.out.println("Invalid length of phone number it must be 10 digits only");
                    System.out.println("\nEnter 10 digit phone number :");
                    long phone1 = scanner.nextLong();
                    int length3=Long.toString(phone1).length();
                    if(length3==10){
                        person.setPhone(phone1);
                        ch.checkUniqueness(firstName);
                    }
                }
                //person.display();

                hashMap.computeIfAbsent(addressBookName1, k -> new LinkedList<Person>());
                hashMap.get(addressBookName1).add(person);

               // if (hashMap.get(addressBookName1) == null) {
                 //   hashMap.put(addressBookName1, new LinkedList<Person>());
               // }
               // hashMap.get(addressBookName1).add(person);

                //System.out.println("\n" + hashMap);

                linkedList = hashMap.get(addressBookName1);
                for (int i = 0; i < linkedList.size(); i++) {
                    Person p1 = linkedList.get(i);
                    System.out.println("person name is :"+p1.getFirstName());
                    p1.display();
                }
            }
            else {
                System.out.println("\n Address book is not in record,u first create address book ");
                createAddressBook();
            }
        }

        /*
         * (non-Javadoc)Deleting person with its details from an address list
         *
         * @see service.AddressBook#deletePerson()
         */
        @Override
        public void deletePerson() {
            System.out.println("\n Enter the name of address book which you want to delete ....");
            String deleteName = scanner.next();
            System.out.println("\n Enter the firstname of user which record you want to delete ");
            String first = scanner.next();
            @SuppressWarnings("unchecked")
            LinkedList<Person> linkedList = hashMap.get(deleteName);

            if (linkedList != null) {
                for (int i = 0; i < linkedList.size(); i++) {
                    Person p1 = linkedList.get(i);
                    if (p1.getFirstName().equalsIgnoreCase(first)) {
                        linkedList.remove(i);
                        System.out.println("Delete Successful.......  .");
                        System.out.println("\n" + linkedList);
                    }
                }

                System.out.println(linkedList.remove(deleteName));
            } else {
                System.out.println("no data available");
            }
            assert linkedList != null;
            for (Person per : linkedList) {
                System.out.println(per);
            }
            System.out.println("\n" + hashMap);

        }

        /*
         * (non-Javadoc)Updating person details which belongs to any address book
         *
         * @see service.AddressBook#updatePerson()
         */
        @Override
        public void updatePerson() {
            System.out.println("\n Enter the name of address book which you want to update ....");
            String updateName = scanner.next();
            System.out.println("\nEnter first name :");
            String first = scanner.next();
            boolean flag = hashMap.containsKey(updateName);
            if (flag) {
                LinkedList<Person> linkedList = hashMap.get(updateName);
                for (int i = 0; i < linkedList.size(); i++) {
                    Person p1 = linkedList.get(i);
                    if (p1.getFirstName().equalsIgnoreCase(first)) {
                        System.out.println("\nU can update now   ");
                        System.out.println("\nEnter first name :");
                        String firstName = scanner.next();
                        person.setFirstName(firstName);
                        System.out.println("\nEnter last name :");
                        String lastName = scanner.next();
                        person.setLastName(lastName);
                        System.out.println("\nEnter address :");
                        String address = scanner.next();
                        person.setAddress(address);
                        System.out.println("\nEnter state name :");
                        String state = scanner.next();
                        person.setState(state);
                        System.out.println("\nEnter zip code :");
                        int zip = scanner.nextInt();
                        int length1 = Integer.toString(zip).length();// to check length of int
                        if (length1 == 6) {
                            person.setZip(zip);
                        } else {
                            System.out.println("invalid length of zip code it must be 6 digits only");
                            System.out.println("\nEnter zip code :");
                            int zip1 = scanner.nextInt();
                            int length = Integer.toString(zip1).length();
                            if (length == 6) {
                                person.setZip(zip);
                            }
                        }
                        System.out.println("\nEnter phone number :");
                        long phone = scanner.nextLong();
                        int length2 = Long.toString(phone).length();
                        if (length2 == 10) {
                            person.setPhone(phone);
                        } else {
                            System.out.println("Invalid length of phone number it must be 10 digits only");
                            System.out.println("\nEnter 10 digit phone number :");
                            long phone1 = scanner.nextLong();
                            int length3 = Long.toString(phone1).length();
                            if (length3 == 10) {
                                person.setPhone(phone1);
                            }
                        }
                        System.out.println("\nUpdate successful ....");
                        // person.display();
                    }
                }
            }
            linkedList = hashMap.get(updateName);
            for (int i = 0; i < linkedList.size(); i++) {
                Person p1 = linkedList.get(i);
                System.out.println("person name is :" + p1.getFirstName());
                p1.display();
            }
            //System.out.println("\n" + hashMap);
        }
    }

