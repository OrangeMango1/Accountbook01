package com.example.myapplication;

import android.os.Bundle;
import androidx.annotation.NonNull;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    private GridView gridView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 7));
        recyclerView.setAdapter(CalendarAdapter);

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = dateFormat.format(calendar.getTime());




        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

// 하단 바 아이템 선택 이벤트 처리
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {



                if (item.getItemId() == R.id.navigation_button1) {
                    // 버튼 1 선택 시 수행할 작업
                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    Fragment1 fragment1 = new Fragment1();
                    transaction.replace(R.id.frame,fragment1);
                    transaction.commit();

                    return true;
                } else if (item.getItemId() == R.id.navigation_button2) {
                    // 버튼 2 선택 시 수행할 작업
                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    Fragment2 fragment2 = new Fragment2();
                    transaction.replace(R.id.frame,fragment2);
                    transaction.commit();
                    return true;
                } else if (item.getItemId() == R.id.navigation_button3) {
                    // 버튼 3 선택 시 수행할 작업
                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    Fragment3 fragment3 = new Fragment3();
                    transaction.replace(R.id.frame,fragment3);
                    transaction.commit();
                    return true;
                }
                else if (item.getItemId() == R.id.navigation_button4) {
                    // 버튼 4 선택 시 수행할 작업
                   /* FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    Fragment1 fragment1 = new Fragment1();
                    transaction.replace(R.id.frame,fragment1);
                    transaction.addToBackStack(null);
                    transaction.commit();*/
                    return true;
                }
                return false;
            }
        });

    }
}



