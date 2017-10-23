package id.refactory.app.refactoryapps;

import android.content.Intent;

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

public class MainActivity extends AppCompatActivity implements HomeFragment.OnFragmentInteractionListener,WPMFragment.OnFragmentInteractionListener, HRFragment.OnFragmentInteractionListener, SOFFragment.OnFragmentInteractionListener,OSFragment.OnFragmentInteractionListener
    {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //  //Calling method dashBoard that has been made below
       // dashBoard();

        gitLogin();
    }

// //Call Dashboard.class and run it
//    public void dashBoard() {
//        Intent intents = new Intent(this, Dashboard.class);
//        startActivity(intents);
//    }

        public void gitLogin(){
            Intent intent = new Intent(this, GitLogin.class);
            startActivity(intent);
        }

}
