package premiereapplication.automation.test.notreapp;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * Created by Sarah on 14/06/2017.
 */

public class Main_Activity_product  extends AppCompatActivity {

    EditText editName, editPrice,editDate,editSeller,editDesc ;
    Button btnChoose, btnList, btnAdd;
    ImageView imageView;final int REQUEST_CODE_GALLERY = 999;

    public static SQLiteHelper sqLiteHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main__product);
        init();
        sqLiteHelper = new SQLiteHelper(this, "ProductDB.sqlite", null, 1);
        sqLiteHelper.queryData("CREATE TABLE IF NOT EXISTS PRODUCT (Id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR, price VARCHAR, date VARCHAR ,nom_vendeur VARCHAR ,desc VARCHAR ,image BLOG)");
        //quand on clique sur choisir image on choisit de la gallerie
        btnChoose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ActivityCompat.requestPermissions(
                        Main_Activity_product.this,
                        new String[] {Manifest.permission.READ_EXTERNAL_STORAGE},
                        REQUEST_CODE_GALLERY
                );
            }
        });

        // qd on clique sur ajouter on insert dans la base********************************************
        //**********************************************************************************************
        Button btnAdd = (Button)findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                try{

                    sqLiteHelper.insertData(
                            editName.getText().toString().trim(),
                            editPrice.getText().toString().trim(),
                            editDate.getText().toString().trim(),
                            editSeller.getText().toString().trim(),
                            editDesc.getText().toString().trim(),
                            imageViewToByte(imageView)
                    );
                    Toast.makeText(getApplicationContext(), "Ajout avec succès!", Toast.LENGTH_SHORT).show();
                    editName.setText("");
                    editPrice.setText("");
                    editDate.setText("");
                    editSeller.setText("");
                    editDesc.setText("");
                    imageView.setImageResource(R.mipmap.ic_launcher);

                }
                catch(Exception e){
                    e.printStackTrace();
                }

            }
        });
        Button btnList = (Button)findViewById(R.id.btnList);
        btnList.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view ) {
                Intent intent = new Intent(Main_Activity_product.this, ProductList.class);
                startActivity(intent);
            }
        });
    }
    // LA PARTIE EN HAUT ---------------------------------------------------------
    //**********************************************************************************************
    private byte[] imageViewToByte(ImageView image) {
        Bitmap bitmap = ((BitmapDrawable)image.getDrawable()).getBitmap();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
        byte[] byteArray = stream.toByteArray();
        return byteArray;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == REQUEST_CODE_GALLERY){
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Intent intent = new Intent (Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent, REQUEST_CODE_GALLERY);

            }
            else {
                Toast.makeText(getApplicationContext(), "Vous n'avez pas la permission d'accéder au fichier location!",Toast.LENGTH_SHORT).show();
            }
            return;
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == REQUEST_CODE_GALLERY && resultCode == RESULT_OK && data != null){
            Uri uri = data.getData();
            try {
                InputStream inputStream = getContentResolver().openInputStream(uri);
                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                imageView.setImageBitmap(bitmap);

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        super.onActivityResult(requestCode, resultCode, data);
    }

    private void init() {
        editName = (EditText) findViewById(R.id.editName);
        editPrice = (EditText) findViewById(R.id.editPrice);
        editDate = (EditText) findViewById(R.id.editDate);
        editSeller = (EditText) findViewById(R.id.editSeller);
        editDesc = (EditText) findViewById(R.id.editDesc);
        btnChoose = (Button) findViewById(R.id.btnChoose);
        btnList = (Button) findViewById(R.id.btnList);
        imageView = (ImageView) findViewById(R.id.imageView);
    }
}
