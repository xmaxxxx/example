package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText editTextName;
    private EditText editTextEmail;
    private Button buttonSubmit;
    private CheckBox checkBox1;
    private Switch switch1;
    private RadioButton radioButton1;
    private ImageView imageView1;
    private ImageButton imageButton1;
    private TextView textViewResult;
    private RecyclerView recyclerView;
    private MyAdapter adapter;
    private List<ItemModel> itemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize UI components
        editTextName = findViewById(R.id.editTextName);
        editTextEmail = findViewById(R.id.editTextEmail);
        buttonSubmit = findViewById(R.id.buttonSubmit);
        checkBox1 = findViewById(R.id.checkBox1);
        switch1 = findViewById(R.id.switch1);
        radioButton1 = findViewById(R.id.radioButton1);
        imageView1 = findViewById(R.id.imageView1);
        imageButton1 = findViewById(R.id.imageButton1);
        textViewResult = findViewById(R.id.textViewResult);
        recyclerView = findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        itemList = new ArrayList<>();
        itemList.add(new ItemModel("Item 1", R.drawable.aj));
        itemList.add(new ItemModel("Item 2", R.drawable.aj));
        itemList.add(new ItemModel("Item 3", R.drawable.aj));

        adapter = new MyAdapter(this, itemList);
        recyclerView.setAdapter(adapter);


        buttonSubmit.setOnClickListener(v -> {
            String name = editTextName.getText().toString().trim();
            String email = editTextEmail.getText().toString().trim();

            if (name.isEmpty() || email.isEmpty()) {
                Toast.makeText(MainActivity.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
            } else {
                Intent intent = new Intent(MainActivity.this, UserInfoActivity.class);
                intent.putExtra("name", name);
                intent.putExtra("email", email);
                intent.putExtra("agreeToTerms", checkBox1.isChecked());
                intent.putExtra("notificationsEnabled", switch1.isChecked());
                intent.putExtra("returningUser", radioButton1.isChecked());
                startActivity(intent);
            }
        });

        imageButton1.setOnClickListener(v -> {
            int width = imageView1.getWidth();
            int height = imageView1.getHeight();
            Toast.makeText(MainActivity.this, "Image width = " + width + " and height = " + height, Toast.LENGTH_SHORT).show();
        });
    }
}
