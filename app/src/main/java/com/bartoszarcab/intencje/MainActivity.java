package com.bartoszarcab.intencje;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Button button1 = findViewById(R.id.btnBartoszArcab);

        Button button_url = findViewById(R.id.btnUrl);
        EditText edit_url = findViewById(R.id.editUrl);

        Button button2 = findViewById(R.id.btnGPS);

        button1.setOnClickListener(v ->{
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            startActivity(intent);
        });
        button2.setOnClickListener(v ->{
            Intent intent = new Intent(MainActivity.this, ThirdActivity.class);
            startActivity(intent);
        });

        button_url.setOnClickListener(v ->{
            String url = edit_url.getText().toString().trim();
            if (!url.startsWith("http://") && !url.startsWith("https://")){
                url = "https://" + url;
            }
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(url));
            startActivity(intent);
        });

    }
}