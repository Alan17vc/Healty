package com.example.healty.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.healty.R;
import com.google.android.material.textfield.TextInputEditText;

import java.util.Objects;

public class CreateDietActivity extends AppCompatActivity {
    TextInputEditText mWeight;
    TextInputEditText mSize;
    TextInputEditText mAge;
    TextInputEditText mSex;
    TextInputEditText mActivityPhysical;
    TextView pesoA;
    TextView pesoB;
    Button btnGetFormula;
    Button btnGetPorcent;

    double formulaHombre;
    double formulaMujer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_diet);
        mWeight = findViewById(R.id.textInputWeight);
        mSize = findViewById(R.id.textInputSize);
        mAge = findViewById(R.id.textInputAge);
        mSex = findViewById(R.id.textInputSex);
        mActivityPhysical = findViewById(R.id.textInputActivityPhysical);
        pesoA = findViewById(R.id.pesoA);
        pesoB = findViewById(R.id.pesoB);
        btnGetFormula = findViewById(R.id.btnGetFormula);
        btnGetPorcent = findViewById(R.id.btnGetPorcent);



        btnGetFormula.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String peso = mWeight.getText().toString();
                String talla = mSize.getText().toString();
                String edad = mAge.getText().toString();
                String fisica = mActivityPhysical.getText().toString();
                if (peso != null && talla != null && edad != null && fisica != null){
                    if (!peso.equals("") && !talla.equals("") && !edad.equals("") && !fisica.equals("")){
                        getHarrisBenedict();
                    }
                    else {
                        Toast.makeText(CreateDietActivity.this, "Ingresa los datos", Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    Toast.makeText(CreateDietActivity.this, "Ingresa los datos", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnGetPorcent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (formulaHombre != 0){
                    String formH = String.valueOf(formulaHombre);
                    goToCalculatePercentage(formH);
                }
                else {
                    String formM = String.valueOf(formulaMujer);
                    goToCalculatePercentage(formM);
                }

            }
        });


    }

    private void goToCalculatePercentage(String formula) {
        Intent intent = new Intent(CreateDietActivity.this, CalculatePercentageActivity.class);
        intent.putExtra("formula", formula);
        startActivity(intent);
    }

    private void getHarrisBenedict() {
        btnGetPorcent.setVisibility(View.VISIBLE);
        int peso = Integer.parseInt(Objects.requireNonNull(mWeight.getText()).toString());
        int talla = Integer.parseInt(Objects.requireNonNull(mSize.getText()).toString());
        int edad = Integer.parseInt(Objects.requireNonNull(mAge.getText()).toString());
        String sexo = Objects.requireNonNull(mSex.getText()).toString();
        double actividadFisica = Double.parseDouble(Objects.requireNonNull(mActivityPhysical.getText()).toString());

        double suma;
        double imc;

        if (sexo.equals("h") || (sexo.equals("H")) || (sexo.equals("hombre")) || (sexo.equals("Hombre"))){
            formulaHombre = 66 + (13.7 * peso) + (5 * talla) - (6.8 * edad) ;
            suma = formulaHombre * 0.10;
            formulaHombre = formulaHombre + suma;
            formulaHombre = formulaHombre * actividadFisica;
            pesoA.setText(String.valueOf(formulaHombre));
        }
        else {
            formulaMujer = 655 + (9.6 * peso) + (1.8 * talla) - (4.7 * edad);
            suma = formulaMujer * 0.10;
            formulaMujer = suma + formulaMujer;
            pesoA.setText(String.valueOf(formulaMujer));
        }

        imc = peso / Math.pow(talla, 2) * Math.pow(10, 4);
        pesoB.setText(String.valueOf(imc));

    }

}