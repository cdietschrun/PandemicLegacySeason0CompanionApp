package cdietschrun.pandemiclegacyseason0companionapp.activities;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import java.util.HashSet;
import java.util.Set;

import cdietschrun.pandemiclegacyseason0companionapp.R;

public class MainActivity extends AppCompatActivity
{
    private AppBarConfiguration appBarConfiguration;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pls0_activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        NavHostFragment navHostFragment = (NavHostFragment)getSupportFragmentManager()
                .findFragmentById(R.id.nav_host_fragment);

        NavController navController = navHostFragment.getNavController();

        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();

//        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
        Set<Integer> topLevelDestinations = new HashSet<>();
        topLevelDestinations.add(R.id.objective_menu_dest);
//        topLevelDestinations.add(R.id.deeplink_dest);
//        if (null != drawerLayout) {
            appBarConfiguration = new AppBarConfiguration.Builder(topLevelDestinations)
//                    .setDrawerLayout(drawerLayout)
                    .build();
//        }

        setupActionBar(navController, appBarConfiguration);

//        setupNavigationMenu(navController);

//        setupBottomNavMenu(navController);
    }

    private void setupActionBar(NavController navController,
                                AppBarConfiguration appBarConfig)
    {
        // This allows NavigationUI to decide what label to show in the action bar
        // By using appBarConfig, it will also determine whether to
        // show the up arrow or drawer menu icon
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfig);
    }

//    private void setupNavigationMenu(NavController navController)
//    {
//        // In split screen mode, you can drag this view out from the left
//        // This does NOT modify the actionbar
//        NavigationView sideNavView = findViewById(R.id.nav_view);
//        if (null != sideNavView)
//        {
//            NavigationUI.setupWithNavController(sideNavView,navController);
//        }
//    }

    @Override
    public boolean onSupportNavigateUp()
    {
        //        // Allows NavigationUI to support proper up navigation or the drawer layout
        //        // drawer menu, depending on the situation
        return NavigationUI.navigateUp(Navigation.findNavController(this, R.id.nav_host_fragment), appBarConfiguration);
    }

//    private void setupBottomNavMenu(NavController navController)
//    {
//        BottomNavigationView bottomNav = findViewById(R.id.bottom_nav_view);
//        if (null != bottomNav)
//        {
//            NavigationUI.setupWithNavController(bottomNav, navController);
//        }
//    }
}