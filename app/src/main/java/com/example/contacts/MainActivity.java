package com.example.contacts;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.backendless.Backendless;
import com.backendless.BackendlessUser;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;

public class MainActivity extends AppCompatActivity {

    Button btnLogout,btnCreateContact,btnContactList;
    TextView tvUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnLogout=findViewById(R.id.btnLogout);
        btnCreateContact=findViewById(R.id.btnCreateContact);
        btnContactList=findViewById(R.id.btnContactList);
        tvUser=findViewById(R.id.tvUser);

        tvUser.setText("Logged in as "+ ContactsApplication.user.getProperty("name") + " ( " +
                ContactsApplication.user.getEmail()+" ) ");

        btnCreateContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Create_Contact.class));
            }
        });

        btnContactList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,ContactList.class));
            }
        });
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"Busy signing you out...please wait...",Toast.LENGTH_LONG).show ();

                Backendless.UserService.logout(new AsyncCallback<Void>() {
                    @Override
                    public void handleResponse(Void response) {
                        Toast.makeText(MainActivity.this,"User signed out successfully!",Toast.LENGTH_SHORT).show ();
                        startActivity(new Intent(MainActivity.this,Login.class));
                        MainActivity.this.finish();
                    }

                    @Override
                    public void handleFault(BackendlessFault fault) {
                        Toast.makeText(MainActivity.this,"Error "+fault.getMessage(),Toast.LENGTH_SHORT).show ();
                    }
                });
            }
        });
    }
}
