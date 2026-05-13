package com.example.randomnumberapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText firstDigitInput, lastDigitInput, lengthInput;
    private Button generateButton;
    private TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstDigitInput = findViewById(R.id.firstDigitInput);
        lastDigitInput = findViewById(R.id.lastDigitInput);
        lengthInput = findViewById(R.id.lengthInput);
        generateButton = findViewById(R.id.generateButton);
        resultText = findViewById(R.id.resultText);

        generateButton.setOnClickListener(v -> generateNumber());
    }

    private void generateNumber() {
        String firstStr = firstDigitInput.getText().toString().trim();
        String lastStr = lastDigitInput.getText().toString().trim();
        String lengthStr = lengthInput.getText().toString().trim();
        if (firstStr.isEmpty() || lastStr.isEmpty() || lengthStr.isEmpty()) {
            Toast.makeText(this, "الرجاء ملء جميع الحقول", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            int first = Integer.parseInt(firstStr);
            int last = Integer.parseInt(lastStr);
            int length = Integer.parseInt(lengthStr);
            String result = RandomNumberGenerator.generateRandomNumber(first, last, length);
            resultText.setText("النتيجة: " + result);
        } catch (Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}
