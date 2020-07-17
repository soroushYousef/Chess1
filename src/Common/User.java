package Common;

import java.io.Serializable;

public class User implements Serializable {
    private final String userName;
    private  String password;
    private int numberOfLoses ;
    private int numberOfVictories;

    public User(String userName,String password){
        this.userName = userName;
        this.password = password;
        numberOfLoses = 0;
    }

    public String getUserName(){
        return userName;
    }
    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password = password;
    }
    @Override
    public boolean equals(Object obj){
        User temp = (User)obj;
        return (temp.getPassword().equals(password) && temp.getUserName().equals(userName));
    }

    public String joinGameNameMaker(){
        return String.format("user name : %s%n password : %s %n loses : %d %n victories : %d ",userName,password,numberOfLoses,numberOfVictories);

    }
}
