package com.example.bestdeals;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements FragmentA.onFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Setting Fragment A
        FragmentA fragA = new FragmentA();
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.main_layout, fragA)
                .commit();
    }

    //Passing fragment A data to Fragment B
    @Override
    public void passData(int pic, String deals, String  name, String  details,
                         String per, String  price, String  discPrice, String loc) {
        FragmentB fragB = FragmentB.newInstance(pic, deals, name, details, per, price, discPrice, loc);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.main_layout, fragB)
                .addToBackStack(null)
                .commit();
    }
}