package com.example.healty.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TextView;

import com.example.healty.R;

public class CalculatePercentageActivity extends AppCompatActivity {
    TextView mTextViewFormula;
    String mExtraTxtFormula;
    TableLayout mTableLayout;
    EditText mEditTextHCO;
    EditText mEditTextPro;
    EditText mEditTextLip;
    Button mBtnChangeSave;
    TextView mTextViewSuma, mTextViewHcoKcal, mTextViewLip, mTextViewPro, mTextViewSumaKcal, mTextViewSumaGramos, mTextViewGramosHco, mTextViewGramosLip, mTextViewGramosPro;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate_percentage);

        mTextViewFormula = findViewById(R.id.txtFormula);
        mExtraTxtFormula = getIntent().getStringExtra("formula");

        mTableLayout = findViewById(R.id.tableCalculate);

        mEditTextHCO = findViewById(R.id.editTextHCO);
        mEditTextPro = findViewById(R.id.editTextPro);
        mEditTextLip = findViewById(R.id.editTextLip);
        mBtnChangeSave = findViewById(R.id.btnChangeSave);
        mTextViewSuma = findViewById(R.id.textViewSuma);
        mTextViewHcoKcal = findViewById(R.id.textViewHcoKcal);
        mTextViewLip = findViewById(R.id.textViewLip);
        mTextViewPro = findViewById(R.id.textViewPro);
        mTextViewSumaKcal = findViewById(R.id.textViewSumaKcal);
        mTextViewSumaGramos = findViewById(R.id.textViewSumaGramos);
        mTextViewGramosHco = findViewById(R.id.textViewGramosHco);
        mTextViewGramosLip = findViewById(R.id.textViewGramosLip);
        mTextViewGramosPro = findViewById(R.id.textViewGramosPro);

        mTextViewFormula.setText(mExtraTxtFormula);

        generateCalculate();

        mBtnChangeSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToEquivalent();
            }
        });
    }

    private void goToEquivalent() {
        Intent intent = new Intent(CalculatePercentageActivity.this, EquivalentActivity.class);
        startActivity(intent);
    }

    private void generateCalculate() {
        int min = 1, max = 101, valor, conteo = 0, aux = 0;
        int random;
        random = (int) (min + Math.random() * (max - min));
        conteo += random;
        Log.d("minimo","min " + min + " max " + max + " conteo HCO" + conteo + " random " + random);
        mEditTextHCO.setText(String.valueOf(random));
        aux = random;

        if (random <= 49){
            aux = random;
            max = 100 - random;
            min = random;
            random = (int) (min + Math.random() * (max - min));
            conteo += random;
            Log.d("minimo","min " + min + " max " + max + " conteo LIP  1 : " + conteo + " random " + random);
            mEditTextLip.setText(String.valueOf(random));
        }
        if (aux == 50){
            aux = random;
            min = random;
            max = 100;
            random = (int) (min + Math.random() * (max - min));
            conteo += random;
            Log.d("minimo","min " + min + " max " + max + " conteo LIP   2 : " + conteo + " random " + random);
            mEditTextLip.setText(String.valueOf(random));
        }
        if (aux > 50){
            max = 100 - random;
            min = 1;
            random = (int) (min + Math.random() * (max - min));
            conteo += random;
            Log.d("minimo","min " + min + " max " + max + " conteo LIP   3 : " + conteo + " random " + random);
            mEditTextLip.setText(String.valueOf(random));
        }

        ///////////////////////////////////////
        valor = 0;
        valor = 100 - conteo;
        conteo += valor;
        Log.d("minimo","min " + min + " max " + max + " conteo PRO" + conteo + " valor " + valor);
        mEditTextPro.setText(String.valueOf(valor));
        mTextViewSuma.setText(String.valueOf(conteo));

        getKcal(mEditTextHCO, mEditTextLip, mEditTextPro);

        mEditTextHCO.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //int hco1 = Integer.parseInt(mEditTextHCO.getText().toString());
                if (!mEditTextHCO.getText().toString().isEmpty()){
                    calculatePro();
                    //mEditTextPro.setText("80");
                }
                else {
                    mEditTextPro.setText("0");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mEditTextLip.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!mEditTextLip.getText().toString().isEmpty()){
                    calculatePro();
                    //mEditTextPro.setText("80");
                }
                else {
                    mEditTextPro.setText("0");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }


    private void calculatePro() {
        int hco = Integer.parseInt(mEditTextHCO.getText().toString());
        int pro = Integer.parseInt(mEditTextPro.getText().toString());
        int lip = Integer.parseInt(mEditTextLip.getText().toString());

        int suma, resta, valor;
        suma = hco + lip;
        resta = 100 - suma;
        valor = resta;
        mEditTextPro.setText(String.valueOf(valor));

        suma = 0;
        suma = hco + lip + valor;
        mTextViewSuma.setText(String.valueOf(suma));

        // calcular kcal y gramos
        calculateKcalGramos();
    }

    private void calculateKcalGramos() {
        int hco = Integer.parseInt(mEditTextHCO.getText().toString());
        int lip = Integer.parseInt(mEditTextLip.getText().toString());
        int pro = Integer.parseInt(mEditTextPro.getText().toString());
        float kcal = (float) Double.parseDouble(mExtraTxtFormula);
        float resultHco, resultLip, resultPro, suma;

        resultHco = (kcal / 100) * hco;
        resultLip = (kcal / 100) * lip;
        resultPro = (kcal / 100) * pro;

        mTextViewHcoKcal.setText(String.valueOf(resultHco));
        mTextViewLip.setText(String.valueOf(resultLip));
        mTextViewPro.setText(String.valueOf(resultPro));

        suma = resultHco + resultLip + resultPro;
        mTextViewSumaKcal.setText(String.valueOf(suma));

        // Gramos

        float gramosHco, gramosLip, gramosPro, sumaGramos;
        gramosHco = (resultHco / 4);
        gramosLip = (resultLip / 9);
        gramosPro = (resultPro / 4);

        mTextViewGramosHco.setText(String.valueOf(gramosHco));
        mTextViewGramosLip.setText(String.valueOf(gramosLip));
        mTextViewGramosPro.setText(String.valueOf(gramosPro));


        sumaGramos = gramosHco + gramosLip + gramosPro;

        mTextViewSumaGramos.setText(String.valueOf(sumaGramos));

    }

    private void getKcal(EditText mEditTextHCO, EditText mEditTextLip, EditText mEditTextPro) {
        int hco = Integer.parseInt(mEditTextHCO.getText().toString());
        int lip = Integer.parseInt(mEditTextLip.getText().toString());
        int pro = Integer.parseInt(mEditTextPro.getText().toString());
        float kcal = (float) Double.parseDouble(mExtraTxtFormula);
        float resultHco, resultLip, resultPro, suma;

        resultHco = (kcal / 100) * hco;
        resultLip = (kcal / 100) * lip;
        resultPro = (kcal / 100) * pro;

        mTextViewHcoKcal.setText(String.valueOf(resultHco));
        mTextViewLip.setText(String.valueOf(resultLip));
        mTextViewPro.setText(String.valueOf(resultPro));

        suma = resultHco + resultLip + resultPro;
        mTextViewSumaKcal.setText(String.valueOf(suma));

        // Gramos

        float gramosHco, gramosLip, gramosPro, sumaGramos;
        gramosHco = (resultHco / 4);
        gramosLip = (resultLip / 9);
        gramosPro = (resultPro / 4);

        mTextViewGramosHco.setText(String.valueOf(gramosHco));
        mTextViewGramosLip.setText(String.valueOf(gramosLip));
        mTextViewGramosPro.setText(String.valueOf(gramosPro));


        sumaGramos = gramosHco + gramosLip + gramosPro;

        mTextViewSumaGramos.setText(String.valueOf(sumaGramos));



    }

}