package com.example.healty.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.healty.R;
import com.example.healty.providers.AuthProvider;
import com.hbb20.CountryCodePicker;

public class MainActivity extends AppCompatActivity {
    Button mButtonSendCode;
    EditText mEditTextPhone;
    CountryCodePicker mCountryCode;
    AuthProvider mAuthProvider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButtonSendCode = findViewById(R.id.btnSendCode);
        mEditTextPhone = findViewById(R.id.editTextPhone);
        mCountryCode = findViewById(R.id.ccp);
        mAuthProvider = new AuthProvider();

        mButtonSendCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getData();
                //goToCodeVerification();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (mAuthProvider.getSessionUser() != null){
            Intent intent = new Intent(MainActivity.this, HomeActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }
    }

    private void getData(){
        String code = mCountryCode.getSelectedCountryCodeWithPlus();
        String phone = mEditTextPhone.getText().toString();

        if (phone.equals("")){
            Toast.makeText(this, "Debes ingresar el numero celular", Toast.LENGTH_SHORT).show();
        }else {
            goToCodeVerification(code + phone);
            Toast.makeText(MainActivity.this, "telefono: " +code + " " + phone, Toast.LENGTH_SHORT).show();
        }
    }
    private void goToCodeVerification(String phone){
        Intent intent = new Intent(MainActivity.this, CodeVerificationActivity.class);
        intent.putExtra("phone",phone);
        startActivity(intent);
    }
}