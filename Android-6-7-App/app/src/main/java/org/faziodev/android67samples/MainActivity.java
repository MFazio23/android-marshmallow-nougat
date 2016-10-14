package org.faziodev.android67samples;

import android.app.Fragment;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;

import org.faziodev.android67samples.fragments.marshmallow.AppLinkingFragment;
import org.faziodev.android67samples.fragments.marshmallow.AutoBackupFragment;
import org.faziodev.android67samples.fragments.marshmallow.DozeFragment;
import org.faziodev.android67samples.fragments.marshmallow.PermissionsFragment;
import org.faziodev.android67samples.fragments.nougat.DataSaverFragment;
import org.faziodev.android67samples.fragments.nougat.MultiWindowFragment;
import org.faziodev.android67samples.fragments.nougat.NotificationsFragment;
import org.faziodev.android67samples.fragments.nougat.QuickSettingsTileFragment;

public class MainActivity extends AppCompatActivity
    implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
            this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        drawer.openDrawer(Gravity.LEFT);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }/*

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
    }*/

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        Fragment selectedFragment = null;
        String title = "";
        int id = item.getItemId();

        switch (id) {
            case R.id.nav_mm_permissions:
                selectedFragment = new PermissionsFragment();
                title = "MM - Permissions";
                break;
            case R.id.nav_mm_doze:
                selectedFragment = new DozeFragment();
                title = "MM - Doze + App Standby";
                break;
            case R.id.nav_mm_auto_backup:
                selectedFragment = new AutoBackupFragment();
                title = "MM - Auto-Backup";
                break;
            case R.id.nav_mm_app_linking:
                selectedFragment = new AppLinkingFragment();
                title = "MM - App Linking";
                break;
            case R.id.nav_n_notifications:
                selectedFragment = new NotificationsFragment();
                title = "N - Notifications";
                break;
            case R.id.nav_n_multi_window:
                selectedFragment = new MultiWindowFragment();
                title = "N - Multi-Window";
                break;
            case R.id.nav_n_data_saver:
                selectedFragment = new DataSaverFragment();
                title = "N - Data Saver";
                break;
            case R.id.nav_n_quick_settings_tile:
                selectedFragment = new QuickSettingsTileFragment();
                title = "N - Quick Settings Tile API";
                break;
        }

        if (selectedFragment != null) {
            final FragmentTransaction transaction = this.getFragmentManager().beginTransaction();

            transaction.replace(R.id.fragment_container, selectedFragment);
            transaction.addToBackStack(null);

            transaction.commit();
        }

        if (this.getSupportActionBar() != null) {
            this.getSupportActionBar().setTitle(title);
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
