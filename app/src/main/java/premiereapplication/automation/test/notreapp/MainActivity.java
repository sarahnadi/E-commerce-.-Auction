package premiereapplication.automation.test.notreapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {




    public Button button2;
    public void init(){
        button2= (Button)findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent toy = new Intent(MainActivity.this,Login1.class);
                startActivity(toy);
            }
        });
    }

    public Button button3;
    public void initcategorie(){
        button3= (Button)findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent toy = new Intent(MainActivity.this,Register.class);
                startActivity(toy);
            }
        });
    }
    public Button btnEnchere;
    public void nouvelleEnchere(){
        btnEnchere= (Button)findViewById(R.id.btnEnchere);
        btnEnchere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent toy = new Intent(MainActivity.this,Main_Activity_product.class);
                startActivity(toy);
            }
        });
    }

    public Button button4;
    public void mes_ventes(){
        button4= (Button)findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent toy = new Intent(MainActivity.this,ProductList.class);
                startActivity(toy);
            }
        });
    }


    private RecyclerView.LayoutManager mLayoutManager;
    private RecyclerView.Adapter mAdapter;
    private ArrayList<String> mDataset;



    @Override
    protected void onCreate(Bundle savedInstanceState){


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        initcategorie();
        nouvelleEnchere();
        mes_ventes();
        mDataset= new ArrayList<>();
        for(int i=0;i<10;i++)
        {
            mDataset.add("new title #" + i);
        }



        mLayoutManager= new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);

        mAdapter= new MainAdapter(mDataset);




        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


                /* !!!!!!!!!!! HEEEEEELP !!!!! Cette partie à crée erreur dont le role est inconnue dans mon prog !!!!!!!!
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        */


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }



    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void displaySelectedScreen(int itemId) {

        //creating fragment object
        Fragment fragment = null;

        //initializing the fragment object which is selected
        switch (itemId) {
            case R.id.nav_menu1:
                fragment = new Menu1();
                Log.i("Menu1","Menu1");
                Intent intent=new Intent ( getApplicationContext(),Login1.class);
               startActivity(intent);
                break;

            case R.id.nav_menu2:
                fragment = new Menu2();
                break;
            case R.id.nav_menu5:
                fragment = new Menu5();
                break;
            case R.id.nav_menu6:
                Intent intent6=new Intent ( getApplicationContext(),ProductList.class);
                startActivity(intent6);
                break;
            case R.id.nav_menu7:
                Intent intent7=new Intent ( getApplicationContext(),ProductList.class);
                startActivity(intent7);
                break;
            case R.id.nav_menu8:
                Intent intent8=new Intent ( getApplicationContext(),A_propos.class);
                startActivity(intent8);
                break;
            case R.id.nav_menu9:
                fragment = new Menu9();
                Intent intent1=new Intent ( getApplicationContext(),Main2Activity.class);
                startActivity(intent1);

                break;
        }

        //replacing the fragment


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        //calling the method displayselectedscreen and passing the id of selected menu
        displaySelectedScreen(item.getItemId());
        //make this method blank
        return true;
    }}