package id.ac.unri.platformandrorahmi2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;

public class HomeActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    TextView nama, lahir, email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mDrawerLayout = findViewById(R.id.drawer);
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.buka,R.string.tutup);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        String str_nama = getIntent().getExtras().getString("nama");
        String str_email = getIntent().getExtras().getString("email");
        String str_lahir = getIntent().getExtras().getString("lahir");

        NavigationView navigationView = findViewById(R.id.nav_view);
        View headerView = navigationView.getHeaderView(0);

        nama = headerView.findViewById(R.id.nama);
        nama.setText(str_nama);
        email = headerView.findViewById(R.id.email);
        email.setText(str_email);
        lahir = headerView.findViewById(R.id.lahir);
        lahir.setText(str_lahir);

        replaceFragment(new FirstFragment());

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                item.setChecked(true);
                mDrawerLayout.closeDrawer(GravityCompat.START);
                switch (id){
                    case R.id.nav_account:
                        replaceFragment(new FirstFragment());
                        break;

                    case R.id.nav_records:
                        replaceFragment(new SecondFragment());
                        break;

                    case R.id.nav_news:
                        replaceFragment(new ThirdFragment());

                        break;

                    case R.id.nav_contactus:
                        replaceFragment(new FourthFragment());
                        break;

                    case R.id.nav_logout:
                        Intent intent = new Intent(HomeActivity.this, LoginActivity.class);
                        startActivity(intent);
                        finish();
                        break;

                    default:
                        return true;
                }
                return true;
            }
        });
    }
    private void replaceFragment (Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.framelayout, fragment);
        fragmentTransaction.commit();
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}