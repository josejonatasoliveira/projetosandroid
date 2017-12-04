package com.example.usuario.letsparty;

import android.app.Fragment;
import android.os.PersistableBundle;
import android.support.annotation.IdRes;
import android.support.design.internal.BottomNavigationItemView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ncapdevi.fragnav.FragNavController;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnMenuTabClickListener;
import com.roughike.bottombar.OnTabReselectListener;
import com.roughike.bottombar.TabSelectionInterceptor;

import java.util.ArrayList;
import java.util.List;

public class PrincipalActivity extends AppCompatActivity {
    private BottomBar bottomBar;
    private FragNavController fragNavController;

    //indices dos fragmentos
    private final int TAB_FIRST = FragNavController.TAB1;
    private final int TAB_SECOND = FragNavController.TAB2;
    private final int TAB_THIRD = FragNavController.TAB3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);


        //FragNav
        //lista de fragmentos
        List<Fragment> fragments = new ArrayList<>(3);

        //adiciona fragmentos a lista
        fragments.add(HomeFragment.newInstance(0));
        fragments.add(AddFragment.newInstance(0));
        fragments.add(TicketFragment.newInstance(0));

        //ligando aos fragmentos do frame
        fragNavController = new FragNavController(getSupportFragmentManager(),R.id.frame,fragments);
        //Fim do fragnav

        //BottomBar menu
        bottomBar = BottomBar.attach(this,savedInstanceState);
        bottomBar.setItems(R.menu.bottom_navigation_principal);
        bottomBar.setOnMenuTabClickListener(new OnMenuTabClickListener() {
            @Override
            public void onMenuTabSelected(int menuItemId) {
                switch (menuItemId){
                    case R.id.home:
                        fragNavController.switchTab(TAB_FIRST);
                        break;
                    case R.id.add:
                        fragNavController.switchTab(TAB_SECOND);
                        break;
                    case R.id.ticket:
                        fragNavController.switchTab(TAB_THIRD);
                        break;
                }
            }

            @Override
            public void onMenuTabReSelected(int menuItemId) {
                if (menuItemId == R.id.home){
                    fragNavController.clearStack();
                }
            }
        });//fim do bottombar menu

    }

    @Override
    public void onBackPressed() {
        if (fragNavController.getCurrentStack().size() > 1){
            fragNavController.pop();
        }

        super.onBackPressed();
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState);
        bottomBar.onSaveInstanceState(outState);
    }
}
