package com.mycompany.mavenproba;

public class User { 


    private String Name;
    private String Adress;
    private int age;
    
    public User(String Name, String Adress, int age) {
        this.Name = Name;
        this.Adress = Adress;
        this.age = age;
   }
    public User(){
         this.Name = "Name?";
        this.Adress = "Adress?";
        this.age = 0;
    }
    
    

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getAdress() {
        return Adress;
    }

    public void setAdress(String Adress) {
        this.Adress = Adress;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    
    
    

}
