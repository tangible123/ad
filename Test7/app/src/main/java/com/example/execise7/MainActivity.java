package com.example.execise7;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    private NavHostFragment navHostFragment ;
    private NavController navController ;
    private AppBarConfiguration appBarConfiguration ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //绑定导航页面
        navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
        navController = navHostFragment.getNavController() ;
        DrawerLayout drawerLayout = findViewById(R.id.drawLayout) ;
        appBarConfiguration = new AppBarConfiguration.Builder(R.id.storage)
                .setOpenableLayout(drawerLayout).build() ;
        NavigationUI.setupActionBarWithNavController(this,navController,appBarConfiguration);

        NavigationView navView = findViewById(R.id.nav_view) ;
        NavigationUI.setupWithNavController(navView,navController);
    }

    @Override
    public boolean onSupportNavigateUp() {
        return NavigationUI.navigateUp(navController,appBarConfiguration) || super.onSupportNavigateUp() ;
    }
}