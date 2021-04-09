package com.example.fragmenttest;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        toolbar.setTitle(getResources().getString(R.string.app_name));
        TabLayout tabLayout = findViewById(R.id.tablayout);
        /*TabItem firstfrag = findViewById(R.id.FirstFragment);
        TabItem secondfrag = findViewById(R.id.SecondFragment);
        TabItem thirdfrag = findViewById(R.id.ThirdFragment);*/
        ViewPager pager = findViewById(R.id.pager);
        PageAdapter pageAdapter = new PageAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        pager.setAdapter(pageAdapter);
        pager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                pager.setCurrentItem(tab.getPosition());{

                if (tab.getPosition() == 0){ //tab.getPosition() == 0 is for the first tab, Wifi tab
                    //can add if want to
                    toolbar.setBackgroundColor(ContextCompat.getColor(MainActivity.this,
                            R.color.teal_200));
                }
                else if (tab.getPosition() == 1){ //Mapping tab
                    toolbar.setBackgroundColor(ContextCompat.getColor(MainActivity.this,
                            R.color.pink));
                }

                else if (tab.getPosition() == 2){ //Tracking tab
                    toolbar.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.lightblue));
                }
                else {
                    //toolbar.setBackgroundColor(ContextCompat.getColor(MainActivity.this,R.color.pink));

                }
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        pager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        //Page Listener allows the user to swipe from left to right and vice versa

    }

}