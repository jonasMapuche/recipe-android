package br.com.stomach.recipe;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.ui.AppBarConfiguration;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;

import br.com.stomach.recipe.databinding.ActivityMainBinding;
import br.com.stomach.recipe.views.BotView;
import br.com.stomach.recipe.views.MainView;
import br.com.stomach.recipe.views.SettingView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;

    private int navigation;

    private static double ACTION_BACK = 16908332;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarMain.toolbar);

        DrawerLayout drawer = binding.drawerLayout;
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, binding.appBarMain.toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.floating_plus);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavigationBot();
            }
        });

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        navigation = 0;

        MainView home = new MainView(this);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        if (navigation == 0) inflater.inflate(R.menu.main_setting, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.item_setting) {
            NavigationSetting();
            return true;
        }
        if (id == ACTION_BACK) {
            NavigationHome();
            return true;
        }
        return onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            NavigationHome();
        } else if (id == R.id.nav_bot) {
            NavigationBot();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void NavigationSetting() {
        FrameLayout frame_main;
        frame_main = (FrameLayout) findViewById(R.id.frm_lay_main);
        frame_main.setVisibility(View.INVISIBLE);

        FrameLayout frame_setting;
        frame_setting = (FrameLayout) findViewById(R.id.frm_lay_setting);
        frame_setting.setVisibility(View.VISIBLE);

        FrameLayout frame_bot;
        frame_bot = (FrameLayout) findViewById(R.id.frm_lay_bot);
        frame_bot.setVisibility(View.INVISIBLE);

        setSupportActionBar(binding.appBarMain.toolbar);
        binding.appBarMain.toolbar.setNavigationIcon(R.drawable.ic_back);

        navigation = 2;

        SettingView setting = new SettingView(this);
    }

    public void NavigationHome() {
        FrameLayout frame_main;
        frame_main = (FrameLayout) findViewById(R.id.frm_lay_main);
        frame_main.setVisibility(View.VISIBLE);

        FrameLayout frame_setting;
        frame_setting = (FrameLayout) findViewById(R.id.frm_lay_setting);
        frame_setting.setVisibility(View.INVISIBLE);

        FrameLayout frame_bot;
        frame_bot = (FrameLayout) findViewById(R.id.frm_lay_bot);
        frame_bot.setVisibility(View.INVISIBLE);

        setSupportActionBar(binding.appBarMain.toolbar);
        binding.appBarMain.toolbar.setNavigationIcon(R.drawable.ic_back);

        DrawerLayout drawer = binding.drawerLayout;
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, binding.appBarMain.toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        navigation = 0;

    }

    public void NavigationBot() {
        FrameLayout frame_main;
        frame_main = (FrameLayout) findViewById(R.id.frm_lay_main);
        frame_main.setVisibility(View.INVISIBLE);

        FrameLayout frame_setting;
        frame_setting = (FrameLayout) findViewById(R.id.frm_lay_setting);
        frame_setting.setVisibility(View.INVISIBLE);

        FrameLayout frame_bot;
        frame_bot = (FrameLayout) findViewById(R.id.frm_lay_bot);
        frame_bot.setVisibility(View.VISIBLE);

        setSupportActionBar(binding.appBarMain.toolbar);
        binding.appBarMain.toolbar.setNavigationIcon(R.drawable.ic_back);

        navigation = 1;

        BotView bot = new BotView(this);
    }
}