package com.example.myapplication;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private EditText etEmail, etPassword;
    private Button btnLogin;
    private TextView tvWelcome, tvForgotPassword, tvHeader, tvAction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etEmail = findViewById(R.id.email);
        etPassword = findViewById(R.id.password);
        btnLogin = findViewById(R.id.btnLogin);
        tvWelcome = findViewById(R.id.text2);
        tvAction = findViewById(R.id.text3);
        tvForgotPassword = findViewById(R.id.forgotPassword);
        tvHeader = findViewById(R.id.text);

        updateButtonState();



        btnLogin.setOnClickListener(view -> {
            String email = etEmail.getText().toString();
            String password = etPassword.getText().toString();

            if (email.equals("admin") && password.equals("admin")) {
                Toast.makeText(MainActivity.this, "Вы успешно зарегистрировались", Toast.LENGTH_SHORT).show();
                showWelcomeMessage();
            } else {
                Toast.makeText(MainActivity.this, "Неправильный логин и пароль", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void updateButtonState() {
        if (!etEmail.getText().toString().isEmpty() && !etPassword.getText().toString().isEmpty()) {
            btnLogin.setBackgroundTintList(getResources().getColorStateList(R.color.orange));
        } else {
            btnLogin.setBackgroundTintList(getResources().getColorStateList(R.color.gray));
        }
    }

    private void showWelcomeMessage() {
        tvAction.setVisibility(View.GONE);
        etEmail.setVisibility(View.GONE);
        etPassword.setVisibility(View.GONE);
        btnLogin.setVisibility(View.GONE);
        tvForgotPassword.setVisibility(View.GONE);
        tvHeader.setVisibility(View.GONE);

        tvWelcome.setText("Добро пожаловать!");
        tvWelcome.setVisibility(View.VISIBLE);
    }
}