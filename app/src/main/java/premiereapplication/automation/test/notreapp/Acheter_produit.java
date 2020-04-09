package premiereapplication.automation.test.notreapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import static premiereapplication.automation.test.notreapp.R.id.imageView;

public class Acheter_produit extends AppCompatActivity {
    private Button btnEncherir;
    private TextView txtName;
    private TextView txtPrice;
    private TextView txtDate;
    private TextView txtSeller;
    private TextView txtDesc;
    private ImageView imgProduct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acheter_produit);
        Intent intent = getIntent();
        Product product = (Product) intent.getSerializableExtra("product");
        btnEncherir = (Button) findViewById(R.id.btnEncherir);
        btnEncherir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Acheter_produit.this, Encherir.class);
                startActivity(intent);
            }
        });
        txtName = (TextView) findViewById(R.id.txtName);
        txtName.setText(product.getName());
        txtPrice = (TextView) findViewById(R.id.txtPrice);
        txtPrice.setText(product.getPrice());
        txtDate = (TextView) findViewById(R.id.txtDate);
        txtDate.setText(product.getDate());
        txtSeller = (TextView) findViewById(R.id.txtSeller);
        txtSeller.setText(product.getNom_vendeur());
        txtDesc = (TextView) findViewById(R.id.txtDesc);
        txtDesc.setText(product.getDesc());

        imgProduct = (ImageView) findViewById(R.id.imgProduct);
        byte [] productImage = product.getImage();
        Bitmap bitmap = BitmapFactory.decodeByteArray(productImage, 0, productImage.length);
        imgProduct.setImageBitmap(bitmap);
    }

}