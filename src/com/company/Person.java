package com.company;


/**Person class in which we are assigning the values by using getters and setters
 * @author bridgeit
 *
 */
public class Person {
    private String firstName;
    private String lastName;
    private String address;
    private String state;
    private int zip;
    private long phone;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public String getState() {
        return state;
    }

    public int getZip() {
        return zip;
    }

    public long getPhone() {
        return phone;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    /**Displaying details of a person
     *
     */

    public void display() {
        System.out.println("------------------------ADDRESS BOOK-----------------------");

        System.out.println("Person details are :");

        System.out.println("\n\t\t\tFirstName is :				 " + getFirstName());
        System.out.println("\n\t\t\tLastName is  : 		 		 " + getLastName());
        System.out.println("\n\t\t\tAddress is   : 				 " + getAddress());
        System.out.println("\n\t\t\tState is     : 				 " + getState());
        System.out.println("\n\t\t\tZipcode is   : 				 " + getZip());
        System.out.println("\n\t\t\tphone is     : 				 " + getPhone());
    }

}

