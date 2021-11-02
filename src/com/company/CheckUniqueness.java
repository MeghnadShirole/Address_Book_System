package com.company;

import java.util.HashSet;

public class CheckUniqueness{
    Person person=new Person();
    HashSet<String> hashSet=new HashSet<>();
    public Person checkUniqueness(String firstname)
    {
        if(!hashSet.contains(firstname)){
            hashSet.add(firstname);
            for(Object hs:hashSet){
                String str=(String) hs;
                System.out.println(hs);
                person.setFirstName(str);
            }
            return person;
        }
        else{
            System.out.println("This name already exists,please enter another name");
            return null;
        }
    }
}