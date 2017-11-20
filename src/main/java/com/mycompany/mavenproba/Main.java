package com.mycompany.mavenproba;

import java.util.ArrayList;

public class Main {
    
    public static void main(String[]args)
    {
        System.out.println("Wut?");
        
        DB db=new DB();
        
        
        db.addUser("Barbara","Eger",26);
        /*
        db.addUser("Elemér","Budapest",23);
        db.addUser("Andris","Kaposvár",21);
        db.addUser("Cili","Matektankönyv",18);
        db.addUser("Hugo","Hugrabugg",45);
        */
       
        ArrayList<User> userlist=db.getAllUser();
        for(User i:userlist)
        {
            System.out.println(i.getName()+"  "+i.getAge());
        }
        
    }

}
