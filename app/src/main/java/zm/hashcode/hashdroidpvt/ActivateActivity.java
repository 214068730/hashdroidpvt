package zm.hashcode.hashdroidpvt;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class ActivateActivity extends AppCompatActivity {
    private  EditText emailAddress;
    private  EditText password;
    private  EditText orgcode;
    private  Button activateButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activate);
        emailAddress=(EditText)findViewById(R.id.activate_emailAddress);
        password=(EditText) findViewById(R.id.activate_password);
        orgcode=(EditText) findViewById(R.id.activate_organisationCode);
        activateButton = (Button) findViewById(R.id.activate_activateButton);


        activateButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                // Do something in response to button click
                Log.d("EMAIL",emailAddress.getText().toString());
                Log.d("PASS",password.getText().toString());
                Log.d("CODE",orgcode.getText().toString());


            }
        });




    }
}
