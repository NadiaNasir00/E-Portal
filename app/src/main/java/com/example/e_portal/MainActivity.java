package com.example.e_portal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private String selectedtopicname = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button btntopic1 = findViewById(R.id.btntopic1);
        final Button btntopic2 = findViewById(R.id.btntopic2);
        final Button btntopic3 = findViewById(R.id.btntopic3);
        final Button btntopic4 = findViewById(R.id.btntopic4);
        final Button btntopic5 = findViewById(R.id.btntopic5);

        btntopic1.setOnClickListener(view -> {
            selectedtopicname = "Implicit Differentiation";
            btntopic1.setBackgroundResource(R.drawable.whiteboarder);
            Intent intent = new Intent(MainActivity.this, Question.class);
            intent.putExtra("selectedtopic", selectedtopicname);
            startActivity(intent);
        });

        btntopic2.setOnClickListener(view -> {
            selectedtopicname = "Derivatives of Logarithmic Functions";
            btntopic1.setBackgroundResource(R.drawable.whiteboarder);
            Intent intent = new Intent(MainActivity.this, Question.class);
            intent.putExtra("selectedtopic", selectedtopicname);
            startActivity(intent);
        });

        btntopic3.setOnClickListener(view -> {
            selectedtopicname = "Derivatives of Exponential and Inverse Trigonometric Functions";
            btntopic1.setBackgroundResource(R.drawable.whiteboarder);
            Intent intent = new Intent(MainActivity.this, Question.class);
            intent.putExtra("selectedtopic", selectedtopicname);
            startActivity(intent);
        });

        btntopic4.setOnClickListener(view -> {
            selectedtopicname = "Local Linear Approximation: Differentials";
            btntopic1.setBackgroundResource(R.drawable.whiteboarder);
            Intent intent = new Intent(MainActivity.this, Question.class);
            intent.putExtra("selectedtopic", selectedtopicname);
            startActivity(intent);
        });

        btntopic5.setOnClickListener(view -> {
            selectedtopicname = "L’Hôpital’s Rule: Indeterminate Forms";
            btntopic1.setBackgroundResource(R.drawable.whiteboarder);
            Intent intent = new Intent(MainActivity.this, Question.class);
            intent.putExtra("selectedtopic", selectedtopicname);
            startActivity(intent);
        });

    }
}