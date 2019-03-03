package com.example.pemrogramanvisualtugas1;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText username, password;
    Button login_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username     = (EditText) findViewById(R.id.username);
        password     = (EditText) findViewById(R.id.password);
        login_button = (Button) findViewById(R.id.login_button);

        login_button.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View v) {

            String usernameKey = username.getText().toString();
            String passwordKey = password.getText().toString();

            boolean kosongkah = false;
            if (v.getId() == R.id.login_button) {
                if (TextUtils.isEmpty(usernameKey)) {
                    kosongkah = true;
                    username.setError("Username Tidak Boleh Kosong");
                }
                if (TextUtils.isEmpty(passwordKey)) {
                    kosongkah = true;
                    password.setError("Password Tidak Boleh Kosong");
                }
            }

            if (usernameKey.equals("201665010") && passwordKey.equals("123gamcen")) {
                Toast.makeText(getApplicationContext(), "Login Successed", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, Welcome.class);
                MainActivity.this.startActivity(intent);
                finish();
            } else {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage("Username Atau Password Salah").setNegativeButton("Coba Lagi", null).create().show();
            }
        }
    });
  }
}