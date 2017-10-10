package id.refactory.app.refactoryapps;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import id.refactory.app.refactoryapps.api.services.RappClient;
import id.refactory.app.refactoryapps.api.services.RetrofitConnect;
import id.refactory.app.refactoryapps.theAdapter.PagerAdapter;
import id.refactory.app.refactoryapps.fragments.HRFragment;
import id.refactory.app.refactoryapps.fragments.HomeFragment;
import id.refactory.app.refactoryapps.fragments.OSFragment;
import id.refactory.app.refactoryapps.fragments.SOFFragment;
import id.refactory.app.refactoryapps.fragments.WPMFragment;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements HomeFragment.OnFragmentInteractionListener,
        WPMFragment.OnFragmentInteractionListener, HRFragment.OnFragmentInteractionListener, SOFFragment.OnFragmentInteractionListener,
        OSFragment.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        setContentView(R.layout.test_dataview);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tablayout);

        // set tab head tobe title
//        tabLayout.addTab(tabLayout.newTab().setText("Project"));
//        tabLayout.addTab(tabLayout.newTab().setText("WPM"));
//        tabLayout.addTab(tabLayout.newTab().setText("HackerRank"));
//        tabLayout.addTab(tabLayout.newTab().setText("StackOverFlow"));
//        tabLayout.addTab(tabLayout.newTab().setText("OpenSource"));

         //set tab head tobe Icon
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_projects));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_wpm));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_hr));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_sof));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_os));

        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        final PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.setOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });






    }
}
