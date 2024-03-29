package umn.ac.id.week03_36215;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import umn.ac.id.week03_36215.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import java.util.LinkedList;
import java.util.Objects;


public class MainActivity extends AppCompatActivity {

    private final LinkedList<String> mDaftarKata = new
            LinkedList<>();
    private RecyclerView mRecyclerView;
    private DaftarKataAdapter mAdapter;
    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;
    private View fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        mAdapter = new DaftarKataAdapter(this, mDaftarKata);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        for (int i = 1; i < 21; i++){
            mDaftarKata.add("Kata " + i);
        }

        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

                NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int jumlahKata = mDaftarKata.size();
                mDaftarKata.addLast("Kata " + (jumlahKata + 1) + " telah ditambahkan");
                Objects.requireNonNull
                        (mRecyclerView.getAdapter()).notifyItemInserted(jumlahKata);
                mRecyclerView.smoothScrollToPosition(jumlahKata);

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }
}