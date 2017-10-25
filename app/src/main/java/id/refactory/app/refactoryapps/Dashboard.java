package id.refactory.app.refactoryapps;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.HashMap;

import id.refactory.app.refactoryapps.fragments.HRFragment;
import id.refactory.app.refactoryapps.fragments.HomeFragment;
import id.refactory.app.refactoryapps.fragments.OSFragment;
import id.refactory.app.refactoryapps.fragments.SOFFragment;
import id.refactory.app.refactoryapps.fragments.WPMFragment;
import id.refactory.app.refactoryapps.theAdapter.PagerAdapter;


public class Dashboard extends AppCompatActivity implements HomeFragment.OnFragmentInteractionListener, WPMFragment.OnFragmentInteractionListener, HRFragment.OnFragmentInteractionListener, SOFFragment.OnFragmentInteractionListener, OSFragment.OnFragmentInteractionListener {

    SessionManager session;
    private String berer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tablayout);

        // For set tab head to be title
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

    public String GetToken() {
        session = new SessionManager(getApplicationContext());

        //Toast.makeText(getApplicationContext(),"User Login Status " + session.loggedIn(), Toast.LENGTH_LONG).show();
        //session.checkLogin();

        HashMap<String, String> tokenDetails = session.getTokenDetails();

        String tokn = tokenDetails.get(SessionManager.KEY_NAME);
        berer = "Bearer " +tokn ;

        Log.e("uu", berer );
        return berer;

    }

}
