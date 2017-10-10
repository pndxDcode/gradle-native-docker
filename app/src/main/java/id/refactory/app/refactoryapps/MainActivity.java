package id.refactory.app.refactoryapps;

import android.app.Dialog;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.webkit.JavascriptInterface;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Dialog MyDialog;
    private Button webDialog;
    WebView loginView;
    LoadListener loadlistener = new LoadListener();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnClick();
    }

    public void btnClick(){
       webDialog = ( Button ) findViewById(R.id.btn_login);

        webDialog.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                dialogWebview();
            }
        });

    }

    public void dialogWebview(){
        String url = "https://app.refactory.id/oauth/authorize?client_id=4&response_type=code&redirect_uri=https://app.refactory.id/callback&scope=";
        loginView = new WebView(this);
        loginView.getSettings().setJavaScriptEnabled(true);

        loginView.getSettings().setDatabaseEnabled(true);
        loginView.getSettings().setAppCacheEnabled(true);
        loginView.addJavascriptInterface(loadlistener,"HTMLOUT");

        loginView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                Log.d("Should", "shouldOverrideUrlLoading: ");
                return true;
            }

            @Override
            public void onPageStarted(WebView view, String Url, Bitmap favicon){

            }

            public void onPageFinished(WebView view, String Url){
                view.loadUrl("javascript:window.HTMLOUT.processHTML('<html>'+document.getElementsByTagName('html')[0].innerHTML+'</html>');");
                view.loadUrl("javascript:clickFunction()");
            }
        });

        loginView.loadUrl(url);
        String getURL = loginView.getUrl();
        Log.d("URL", getURL);
        MyDialog = new Dialog(MainActivity.this);
        MyDialog.requestWindowFeature(Window.FEATURE_NO_TITLE );
        MyDialog.setContentView(loginView);
        MyDialog.setTitle("Login With Github");
        MyDialog.show();
    }

    @Override
    public void onBackPressed() {
        if (loginView.canGoBack()){
            loginView.goBack();
        }else {
            super.onBackPressed();
        }
    }
}

class LoadListener{
    @JavascriptInterface
    public void processHTML(String html){
        Log.e("Result HTML", html);
    }
}