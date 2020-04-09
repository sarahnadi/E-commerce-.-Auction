package premiereapplication.automation.test.notreapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Encherir extends AppCompatActivity {

    private TextView txtPrice;
    private Button btnConfirmer;
    private EditText editBid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encherir);

        btnConfirmer = (Button) findViewById(R.id.btnConfirmer);
        btnConfirmer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Votre enchère a été ajouté ! Merci",Toast.LENGTH_SHORT).show();
                editBid = (EditText) findViewById(R.id.editBid);
                editBid.setText("");

            }
        });

            //Toast.makeText(getApplicationContext(), "Vous n'avez pas la permission d'accéder au fichier location!",Toast.LENGTH_SHORT).show();




    }

}