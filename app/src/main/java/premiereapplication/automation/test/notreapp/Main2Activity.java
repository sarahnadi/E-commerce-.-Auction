package premiereapplication.automation.test.notreapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {
    Button bLogout;
    EditText etName, etUsername ;
    UserLocalStore userLocalStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        etName=(EditText) findViewById(R.id.etName);

        etUsername=(EditText) findViewById(R.id.etUsername);

        bLogout =(Button) findViewById(R.id.bLogout);

        bLogout.setOnClickListener(this);
        userLocalStore = new UserLocalStore(this);
    }
     @Override
     protected void onStart(){
         super.onStart();
         if (authenticate() == true){
             displayUserDetails();

         }

     }
        private boolean authenticate () {
            return userLocalStore.getUserLoggedIn();

        }
        private void displayUserDetails(){
            User user =userLocalStore.getLoggedInUser();
            etUsername.setText(user.username);
            etName.setText(user.name);


        }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bLogout:

                userLocalStore.clearUserData();
                userLocalStore.setUserLoggedIn(false);

                Intent intent=new Intent ( getApplicationContext(),Login1.class);
                startActivity(intent);


                break;


        }
    }
}
