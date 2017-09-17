package bankindonesia.coba.activity;


import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import bankindonesia.coba.R;
import bankindonesia.coba.fragment.home.HomePJFragment;
import bankindonesia.coba.fragment.kehadiran.JadwalKehadiranFragment;
import bankindonesia.coba.fragment.kehadiran.ViewKehadiranFragment;
import bankindonesia.coba.fragment.laporan.InsertLaporanFragment;
import bankindonesia.coba.fragment.laporan.TabelLaporanFragment;
import bankindonesia.coba.fragment.laporan.ViewLaporanFragment;
import bankindonesia.coba.fragment.penyelenggaraan.JadwalPenyelenggaraanFragment;
import bankindonesia.coba.fragment.penyelenggaraan.ViewPenyelenggaraanFragment;

public class ProfilePJActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_pj);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //NOTE:  Checks first item in the navigation drawer initially
        navigationView.setCheckedItem(R.id.nav_home);

        //NOTE:  Open fragment1 initially.
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.mainFrame, new HomePJFragment());
        ft.commit();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
//            super.onBackPressed();
            AlertDialog.Builder builder = new AlertDialog.Builder(this,R.style.DialogeTheme);
            builder.setMessage("Apakah anda yakin untuk LOG OUT?")
                    .setCancelable(false)
                    .setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            setResult(Activity.RESULT_OK);
                            ProfilePJActivity.this.finish();
                        }
                    })
                    .setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                        }
                    });
            AlertDialog alert = builder.create();
            alert.show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.search_menu, menu);
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
//            return true;
            Intent intent = new Intent (this, SearchKehadiranActivity.class);
            startActivity(intent);
        } else if(id == R.id.action_settings2) {
            Intent intent = new Intent (this, SearchPenyelenggaraanActivity.class);
            startActivity(intent);
        } else if(id == R.id.action_settings3) {
//            Fragment fragment = new SearchLaporanFragment();
//            FragmentManager fragmentManager = getSupportFragmentManager();
//            fragmentManager.beginTransaction().replace(R.id.mainFrame, fragment).commit();
            Intent intent = new Intent (this, SearchLaporanActivity.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        Fragment fragment = null;
//        DialogFragment dialogFragment;
        if (id == R.id.nav_home) {
            fragment = new HomePJFragment();
        } else if (id == R.id.nav_logout){
            AlertDialog.Builder builder = new AlertDialog.Builder(this,R.style.DialogeTheme);
            builder.setMessage("Are you sure you want to exit?")
                    .setCancelable(true)
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            setResult(Activity.RESULT_OK);
                            ProfilePJActivity.this.finish();
                        }
                    })
                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                        }
                    });
            AlertDialog alert = builder.create();
            alert.show();
        }

        else if (id == R.id.nav_updatekehadiran) {
            fragment = new JadwalKehadiranFragment();
        } else if (id == R.id.nav_viewkehadiran) {
            fragment = new ViewKehadiranFragment();
        }

        else if (id == R.id.nav_updatepenyelenggaraan) {
            fragment = new JadwalPenyelenggaraanFragment();
        } else if (id == R.id.nav_viewpenyelenggaraan) {
            fragment = new ViewPenyelenggaraanFragment();
        }

        else if (id == R.id.nav_insertlaporan) {
            fragment = new InsertLaporanFragment();
        } else if (id == R.id.nav_updatelaporan) {
            fragment = new TabelLaporanFragment();
        } else if (id == R.id.nav_viewlaporan) {
            fragment = new ViewLaporanFragment();
        }

        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.mainFrame, fragment).commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
