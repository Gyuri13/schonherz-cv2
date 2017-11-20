package com.mycompany.mavenproba;


import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DB {
    final String JDBC_DREIVER="org.apache.derby.jdbc.EmbeddedDriver";
    final String URL="jdbc:derby:sampleDB;create=true";
    final String USERNAME="";
    final String PASSWORLD="";
    
    Connection con=null;
    Statement ownStatement = null;
    
    DB(){
    
        
        try {//CONNECTON deklarálás
          //  Class.forName(JDBC_DREIVER)// nem találja az osztáty==itt  egy driver
            con = DriverManager.getConnection(URL);
        } catch (Exception ex) {
            System.out.println(""+ex);
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(con != null){
            try {//Statement deklarálás
                ownStatement = con.createStatement();
            } catch (SQLException ex) {
                System.out.println("statement létrehozási hiba: "+ex);
            }
        }
        DatabaseMetaData dbm=null;
        try {//META ADAT deklarálás & adattábla létrehozása ha még nincs
             dbm = con.getMetaData();
        } catch (SQLException ex) {
            System.out.println("Meta adat lekérdezési hiba: "+ex);
        }
        
        try {
            ResultSet rs = dbm.getTables(null, "APP", "USERS", null);
            if(!rs.next())
            {
                ownStatement.execute("CREATE TABLE USERS(Name varchar(20),Adress varchar(20),Age INT)");
                System.out.println("Az adatbázis létrejött");
            }
            
            
            
        } catch (SQLException ex) {
             System.out.println("Adattábla létrehozás: "+ex);
        }
        
        
        
        }
    
    public void addUser(String name,String adress,Integer age)//biztonság?? 
    {
        try {
            String sq1 = "INSERT INTO USERS (Name,Adress,Age)VALUES (?,?,?)"; 
            PreparedStatement prepStatement = con.prepareStatement(sq1);
            prepStatement.setString(1, name);
            prepStatement.setString(2, adress);
            prepStatement.setInt(3,age);
            prepStatement.execute();
        } catch (SQLException ex) {
            
            System.out.println("új rekord hozzáadáával van giond: "+ex);
        }
    }
    
        
     public ArrayList<User> getAllUser()
    {
        ArrayList<User> userlist = null;//ha hiba null ha üres akkor csak üres list
        String sql="SELECT * FROM USERS ";
        try {
            ResultSet rs=ownStatement.executeQuery(sql);
            
            userlist = new ArrayList<User>();
            
            while(rs.next())
            {
                User user=new User(rs.getString("Name"),rs.getString("Adress"),rs.getInt("Age"));
             
                userlist.add(user);
                 
            }
        } catch (SQLException ex) {
            
            System.out.println("Gond van a kiolvasásal: "+ex);
        }
        return userlist;
    } 
   
}
