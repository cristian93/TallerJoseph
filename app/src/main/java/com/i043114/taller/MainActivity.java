package com.i043114.taller;

import android.app.FragmentTransaction;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


// aqui va el codigo
        FloatingActionButton btn_one = (FloatingActionButton) findViewById(R.id.fab_1);
        registerForContextMenu(btn_one);

        BottomNavigationView bnv = (BottomNavigationView) findViewById(R.id.bnv_1);
        bnv.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.item_1:
                        UnoFragment unoFragment = new UnoFragment();
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.fl_1, unoFragment)
                                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                                .addToBackStack(null)
                                .commit();
                        Toast.makeText(MainActivity.this, "ITEM 1", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.item_2:
                        DosFragment dosFragment = new DosFragment();
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.fl_1, dosFragment)
                                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                                .addToBackStack(null)
                                .commit();
                        Toast.makeText(MainActivity.this, "ITEM 2", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.item_3:
                        TresFragment tresFragment = new TresFragment();
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.fl_1, tresFragment)
                                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                                .addToBackStack(null)
                                .commit();
                        Toast.makeText(MainActivity.this, "ITEM 3", Toast.LENGTH_SHORT).show();
                        break;
                }
                return true;
            }
        });



    }
    public boolean  onCreateOptionsMenu ( Menu menu_a){
        getMenuInflater().inflate(R.menu.menu1,menu_a);
        return true;

    }


    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        menu.setHeaderTitle("Mis opciones");
        inflater.inflate(R.menu.menu1, menu);
    }


}
