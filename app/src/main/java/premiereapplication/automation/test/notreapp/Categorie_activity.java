package premiereapplication.automation.test.notreapp;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.miguelcatalan.materialsearchview.MaterialSearchView;
import java.util.ArrayList;
import java.util.List;
public class Categorie_activity extends AppCompatActivity {
    MaterialSearchView searchView;
    ListView lstView;
    String[] lstSource = {
            "Vétements",
            "Informatique et Multimedia",
            "Sacs et Valises",
            "Accessoires",
            "Chaussures",
            "Véhicules",
            "Immobilier",
            "Art",
            "Livres",
            "Timbres",
            "Monnaies"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categorie_activity);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//        getSupportActionBar().setTitle("Material Search");
//        toolbar.setTitleTextColor(Color.parseColor("#FFFFFF"));
        lstView = (ListView) findViewById(R.id.LstView);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, lstSource);
        lstView.setAdapter(adapter);

        searchView = (MaterialSearchView) findViewById(R.id.search_view);
        searchView.setOnSearchViewListener(new MaterialSearchView.SearchViewListener() {
            public void onSearchViewShown(){
            }
            public void onSearchViewClosed(){
                lstView = (ListView) findViewById(R.id.LstView);
                ArrayAdapter adapter = new ArrayAdapter(Categorie_activity.this, android.R.layout.simple_list_item_1, lstSource);
                lstView.setAdapter(adapter);
            }
        });

        searchView.setOnQueryTextListener(new MaterialSearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if(newText != null && !newText.isEmpty()){
                    List<String> lstFound = new ArrayList<String>();
                    for (String item:lstSource) {
                        if(item.contains(newText))
                            lstFound.add(item);
                    }
                    ArrayAdapter adapter = new ArrayAdapter(Categorie_activity.this, android.R.layout.simple_list_item_1, lstFound);
                    lstView.setAdapter(adapter);
                }
                else {
                    ArrayAdapter adapter = new ArrayAdapter(Categorie_activity.this, android.R.layout.simple_list_item_1, lstSource);
                    lstView.setAdapter(adapter);
                }
                return true;
            }

        });
    }




}





