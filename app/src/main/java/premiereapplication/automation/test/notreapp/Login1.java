package premiereapplication.automation.test.notreapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.kosalgeek.android.json.JsonConverter;
import com.kosalgeek.asynctask.AsyncResponse;
import com.kosalgeek.asynctask.PostResponseAsyncTask;

import java.util.ArrayList;

public class Login1 extends AppCompatActivity implements View.OnClickListener{

    Button bLogin;
    EditText etUsername, etPassword;
    TextView tvRegisterLink;
    UserLocalStore userLocalStore;
    String output = "";
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            //hadi
    AsyncResponse test = new AsyncResponse()
    {
        public void processFinish(String paramAnonymousString)
        {
            ArrayList<Login1Serialize> localObject2 = new JsonConverter().toArrayList(paramAnonymousString, Login1Serialize.class);

            try
            {

                for(Login1Serialize p: localObject2){
                    output += "email: " + p.getEmail();
                    output += ", name: " + p.getName();
                }
                Toast.makeText(getApplicationContext(), output, Toast.LENGTH_LONG).show();

            }
            catch (Exception  e)
            {
                Toast.makeText(getApplicationContext(), "Aucune Connexion Internet",Toast.LENGTH_LONG).show();
                return;
            }

        }
    };
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //hadi
        final PostResponseAsyncTask readData = new PostResponseAsyncTask(this,test);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login1);

        etUsername= (EditText) findViewById(R.id.etUsername);
        etPassword= (EditText) findViewById(R.id.etPassword);
        tvRegisterLink =(TextView) findViewById(R.id.tvRegisterLink);


        tvRegisterLink.setOnClickListener(this);
        userLocalStore = new UserLocalStore(this);


        Button mEmailSignInButton = (Button) findViewById(R.id.bLogin);
        mEmailSignInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //attemptLogin();
                try
                {
                    //hadi
                    readData.execute(new String[] { "http://wholeservices.net/test/authentification.php?username=" + etUsername.getText().toString() + "&mdp=" +etPassword.getText().toString() });
                    return;
                }
                finally {
                    if (output!=null) {
                        Intent main = new Intent(getApplicationContext(), MainActivity.class);
                        // main.putExtra(ItemDetailFragment.ARG_ITEM_ID, id);
                        startActivity(main);
                    }else  Toast.makeText(getApplicationContext(), "Erreur",Toast.LENGTH_LONG).show();




                }
            }
        });
    }



    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bLogin:
            User user = new User(null, null) ;
                userLocalStore.storeUserData(user);
            userLocalStore.setUserLoggedIn(true);


                break;
            case R.id.tvRegisterLink:
                Intent intent=new Intent ( getApplicationContext(),Register.class);
                startActivity(intent);
                break;



        }
    }
}
