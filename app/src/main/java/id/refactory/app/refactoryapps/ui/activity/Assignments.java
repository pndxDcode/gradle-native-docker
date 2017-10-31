package id.refactory.app.refactoryapps.ui.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import id.refactory.app.refactoryapps.R;
import id.refactory.app.refactoryapps.api.request.RetrofitAssignment;
import id.refactory.app.refactoryapps.api.request.RetrofitConnection;
import id.refactory.app.refactoryapps.api.request.services.RequestToken;
import id.refactory.app.refactoryapps.models.AdapterAssignments;
import id.refactory.app.refactoryapps.models.DataAssignments;
import id.refactory.app.refactoryapps.models.ResultAssignments;
import id.refactory.app.refactoryapps.models.UpdateAssignments;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class Assignments extends AppCompatActivity{

    private RecyclerView recyclerView;
    private AdapterAssignments mAdapter;
    List<DataAssignments> assignments;
    private RecyclerView.LayoutManager mLayoutManager;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assignments);
        initViews();
    }

    private void initViews(){
        recyclerView = (RecyclerView)findViewById(R.id.assignment_numbers);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        loadDataAssignments();
    }

    private void loadDataAssignments(){
        RequestToken token = new RequestToken();
        String dataToken = token.getToken();

        RetrofitConnection retro = new RetrofitConnection();
        Retrofit a = retro.initializeRetrofit();

        RetrofitAssignment apiservice = a.create(RetrofitAssignment.class);
        Call<ResultAssignments> call = apiservice.listData(dataToken);
        call.enqueue(new Callback<ResultAssignments>() {
            @Override
            public void onResponse(Call<ResultAssignments> call, Response<ResultAssignments> response) {

                if(response.isSuccessful()){
                    assignments = new ArrayList<>();
                    ResultAssignments result = response.body();
//                    Log.d("yeah", "onResponse: "+new Gson().toJson(result));
                    assignments = result.getDataResponse();

                    //Filter Project
                    ArrayList<DataAssignments> dataResults = new ArrayList<DataAssignments>();
                    for (DataAssignments data: assignments){
                        if(data.getAssignment_type().toUpperCase().equals("PROJECT")){
                            dataResults.add(data);
                        }
                    }

                    //this data loads
                    mAdapter = new AdapterAssignments(dataResults); //assignments

                    //attach to recycleview
                    mLayoutManager = new LinearLayoutManager(getApplicationContext());
                    recyclerView.setLayoutManager(mLayoutManager);
                    recyclerView.setItemAnimator(new DefaultItemAnimator());
                    recyclerView.setAdapter(mAdapter);

                }

            }

            @Override
            public void onFailure(Call<ResultAssignments> call, Throwable t) {
                Log.d("Error",t.getMessage());
            }
        });
    }




}
