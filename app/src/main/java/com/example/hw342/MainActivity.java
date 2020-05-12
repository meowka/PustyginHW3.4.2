package com.example.hw342;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static int currentThemeRes = -1;
    private static int currentMarginRes = 1;
    String[] color = {"Зелёный", "Чёрный", "Синий"};
    String[] margin = {"мелкие", "средние", "большие"};
    Button btnOk;
    Spinner spinnerColor;
    Spinner spinnerMargin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (currentThemeRes != -1) {
            setTheme(currentThemeRes);
        }
        if (currentMarginRes!=1){
            setTheme(currentMarginRes);
        }
        setContentView(R.layout.activity_main);
        init();
    }

    public void init() {
        spinnerColor = findViewById(R.id.spinnerColor);
        spinnerMargin = findViewById(R.id.spinnerMargin);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, color);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerColor.setAdapter(adapter);
        ArrayAdapter<String> adapterMargin = new ArrayAdapter<>(this,R.layout.support_simple_spinner_dropdown_item, margin);
        adapterMargin.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerMargin.setAdapter(adapterMargin);
        btnOk = findViewById(R.id.button);
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (spinnerColor.getSelectedItem().toString()) {
                    case "Зелёный":
                        currentThemeRes = R.style.AppThemeGreen;
                        recreate();
                        break;
                    case "Синий":
                        currentThemeRes = R.style.AppTheme_Blue;
                        Toast.makeText(getApplicationContext(), "select ", Toast.LENGTH_SHORT).show();
                        recreate();
                        break;
                    case "Чёрный":
                        currentThemeRes = R.style.AppTheme_Black;
                        recreate();
                        break;
                }
                switch (spinnerMargin.getSelectedItem().toString()){
                    case "мелкие":
                        currentMarginRes = R.style.SmallMargin;
                        recreate();
                        break;
                    case "средние":
                        currentMarginRes = R.style.MiddleMargin;
                        recreate();
                        break;
                    case "большие":
                        currentMarginRes = R.style.LargeMargin;
                        recreate();
                        break;
                }
            }
        });
    }
}
