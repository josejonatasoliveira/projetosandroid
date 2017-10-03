package com.edu.fatec.inviteme;

import android.support.annotation.IdRes;
import android.support.design.internal.BottomNavigationItemView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabReselectListener;
import com.roughike.bottombar.TabSelectionInterceptor;

public class PrincipalActivity extends AppCompatActivity {
    //private BottomBar bottomBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        BottomBar bottomBar = (BottomBar) findViewById(R.id.bottomBar);

        bottomBar.setOnTabReselectListener(new OnTabReselectListener() {
            @Override
            public void onTabReSelected(@IdRes int tabId) {
                public void onTabSelected(@IdRes int tabid){
                    if (tabid == R.id.home){

                    }
                }
            }
        });
        //bottomNavigationItemView



    }
}
