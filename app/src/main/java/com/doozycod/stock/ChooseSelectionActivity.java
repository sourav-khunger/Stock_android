package com.doozycod.stock;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ChooseSelectionActivity extends AppCompatActivity {
    Button scannerButton, enterCodeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_selection);
        scannerButton = findViewById(R.id.scanner);
        enterCodeButton = findViewById(R.id.enterItemCode);
        scannerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ChooseSelectionActivity.this, MainActivity.class));
            }
        });
        enterCodeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ChooseSelectionActivity.this, ManualItemActivity.class));

            }
        });
    }
}
