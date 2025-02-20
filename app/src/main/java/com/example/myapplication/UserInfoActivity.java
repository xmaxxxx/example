package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class UserInfoActivity extends AppCompatActivity {

    private TextView textViewUserInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);

        textViewUserInfo = findViewById(R.id.textViewUserInfo);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String email = intent.getStringExtra("email");
        boolean agreeToTerms = intent.getBooleanExtra("agreeToTerms", false);
        boolean notificationsEnabled = intent.getBooleanExtra("notificationsEnabled", false);
        boolean returningUser = intent.getBooleanExtra("returningUser", false);

        String userInfo = "Name: " + name + "\n" +
                "Email: " + email + "\n" +
                "Agree to Terms: " + agreeToTerms + "\n" +
                "Notifications Enabled: " + notificationsEnabled + "\n" +
                "Returning User: " + returningUser;

        textViewUserInfo.setText(userInfo);
    }
}
