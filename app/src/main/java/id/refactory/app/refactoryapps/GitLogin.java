package id.refactory.app.refactoryapps;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

import id.refactory.app.refactoryapps.services.ApiClient;
import id.refactory.app.refactoryapps.services.AuthRequest;
import id.refactory.app.refactoryapps.services.RegAPI;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GitLogin extends AppCompatActivity {
    private Dialog MyDialog;
    private Button webDialog;
    private WebView loginView;

    LoadListener loadlistener = new LoadListener();
    ApiClient api = new ApiClient();

    String url = api.getUri();

    SessionManager session;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        session = new SessionManager(getApplicationContext());

        webDialog = ( Button ) findViewById(R.id.btn_login);
        webDialog.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                dialogWebview();
            }
        });


    }


    public void dialogWebview(){
        loginView = new WebView(this);
        loginView.getSettings().setJavaScriptEnabled(true);
        loginView.getSettings().setDomStorageEnabled(true);
        loginView.getSettings().setDatabaseEnabled(true);
        loginView.getSettings().setAppCacheEnabled(true);
        loginView.addJavascriptInterface(this.loadlistener,"HTMLOUT");

        loginView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String Url) {

                if(Url.contains("https://app.refactory.id/callback?code=")) {
                    gitCode(Url);
                } else {
                    Log.d("False not yet find", "");
                }

                return false;
            }

            @Override
            public void onPageStarted(WebView view, String Url, Bitmap favicon){

            }

            public void onPageFinished(WebView view, String Url){
                view.loadUrl("javascript:window.HTMLOUT.processHTML('<html>'+document.getElementsByTagName('html')[0].innerHTML+'</html>');");

            }

        });

        loginView.loadUrl(url);

        String getURL = loginView.getUrl();
        this.MyDialog = new Dialog(this);
        this.MyDialog.requestWindowFeature(Window.FEATURE_NO_TITLE );
        this.MyDialog.setContentView(loginView);
        this.MyDialog.setTitle("Login With Github");
        this.MyDialog.show();

    }


    public void gitCode(String code){
        Log.d("gitcode", code);
        String currentString = code;
        String[] codeSplit = currentString.split("=");
        String Code = codeSplit[1];

        getToken(Code);
    }

    public void getToken(String codeGet){

        ApiClient get = new ApiClient();
        String code = codeGet;

        ApiClient apiClient = new ApiClient();
        String URL = apiClient.getURL();
        String grant_type = apiClient.getGrantType();
        String client_id = apiClient.getClient_id();
        String client_secret = apiClient.getClientSecret();
        final String redirect_uri = apiClient.redirectUri();


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        final AuthRequest auth = new AuthRequest(code, grant_type, client_id, client_secret, redirect_uri);

        RegAPI api = retrofit.create(RegAPI.class);

        Call<AuthRequest> call = api.setCode(auth);

        call.enqueue(new Callback<AuthRequest>() {

            @Override
            public void onResponse(Call<AuthRequest> call, Response<AuthRequest> authRequest) {

                String accessToken = authRequest.body().getAccessToken();
                Integer expiresToken = authRequest.body().getExpiresIn();
                String refreshToken = authRequest.body().getRefreshToken();
                String tokenType = authRequest.body().getTokenType();

                session.createLogin(accessToken,expiresToken,refreshToken,tokenType);

                MyDialog.dismiss();

                Intent i = new Intent(getApplicationContext(), Dashboard.class);
                startActivity(i);
                finish();

                //Log.e("", "response 33: "+new Gson().toJson(authRequest.body()) );
            }

            @Override
            public void onFailure(Call<AuthRequest> call, Throwable t) {
                Log.d("Message", "onFailure: " + t.getMessage());
            }

        });
    }

    public void onBackPressPed() {
        if (loginView.canGoBack()){
            loginView.goBack();
        }else {
            super.onBackPressed();
        }
    }


}