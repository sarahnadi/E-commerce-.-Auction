package premiereapplication.automation.test.notreapp;

import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.content.*;
import android.widget.*;


import java.util.ArrayList;

/**
 * Created by Sarah on 05/06/2017.
 */

public class ProductList extends AppCompatActivity {

    ListView gridView;
    ArrayList<Product> list;
    ProductListAdapter adapter = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_list_view);

        gridView =(ListView) findViewById(R.id.gridView);
        list = new ArrayList<>();
        adapter = new ProductListAdapter(this, R.layout.product_list_activity, list);
        gridView.setAdapter(adapter);

        // récupérer toutes les données à partir d SQLite
        Cursor cursor = Main_Activity_product.sqLiteHelper.getData("SELECT * FROM PRODUCT");
        list.clear();
        while(cursor.moveToNext()){
            int id = cursor.getInt(0);
            String name = cursor.getString(1);
            String price = cursor.getString(2);
            String date = cursor.getString(3);
            String nom_vendeur = cursor.getString(4);
            String desc = cursor.getString(5);
            byte[] image = cursor.getBlob(6);

            list.add(new Product( name, price,  date, nom_vendeur, desc, image,  id));

        }
        adapter.notifyDataSetChanged();

        gridView.setOnItemClickListener(new AdapterView
        .OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Product product = list.get(i);
                Intent intent = new Intent(ProductList.this, Acheter_produit.class);
                intent.putExtra("product", product);
                startActivity(intent);
               /** Toast.makeText(getApplicationContext(), product
                        .getName(), Toast.LENGTH_SHORT).show();*/


            }

        });

    }
}
