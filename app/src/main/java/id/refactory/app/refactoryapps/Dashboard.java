package id.refactory.app.refactoryapps;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;

public class Dashboard extends AppCompatActivity {
    SessionManager session;
    Button btnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        session = new SessionManager(getApplicationContext());

        TextView token = (TextView) findViewById(R.id.DataToken);
        btnLogout = (Button) findViewById(R.id.logout);

        Toast.makeText(getApplicationContext(),"User Login Status " + session.loggedIn(), Toast.LENGTH_LONG).show();

        session.checkLogin();
        HashMap<String, String> tokenDetails = session.getTokenDetails();

        String tok = tokenDetails.get(SessionManager.KEY_NAME);

        token.setText(tok);
        btnLogout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0){
                session.logout();
            }
        });
    }
}
