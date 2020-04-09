package premiereapplication.automation.test.notreapp;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Sarah on 22/05/2017.
 */

public class UserLocalStore {

    public static final String SP_NAME = "userDetails";
    SharedPreferences userLocalDatabase;

    public UserLocalStore(Context context) {
        userLocalDatabase = context.getSharedPreferences(SP_NAME,0);
    }
    public void storeUserData(User user){
        SharedPreferences.Editor spEditor = userLocalDatabase.edit();
        spEditor.putString("name",user.name);
        spEditor.putInt("age",user.age);
        spEditor.putString("password",user.username);
        spEditor.commit();
    }
    public User getLoggedInUser(){
        String name = userLocalDatabase.getString("name","");
        int age = userLocalDatabase.getInt("age",-1);
        String username = userLocalDatabase.getString("username","");
        String password = userLocalDatabase.getString("password","");

        User storedUser = new User(name,age,username,password);
        return storedUser;
    }

public void setUserLoggedIn(boolean loggedIn){
    SharedPreferences.Editor spEditor = userLocalDatabase.edit();
    spEditor.putBoolean("loggedIn",loggedIn);
    spEditor.commit();
}
 public boolean getUserLoggedIn()
 {
     if (userLocalDatabase.getBoolean("loggedIn",false)==true){
         return true;
     }else{
         return false;
     }
 }
public void clearUserData(){
    SharedPreferences.Editor spEditor = userLocalDatabase.edit();
    spEditor.clear();
    spEditor.commit();
}
}
