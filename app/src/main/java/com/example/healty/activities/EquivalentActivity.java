package com.example.healty.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import com.example.healty.R;

public class EquivalentActivity extends AppCompatActivity {
    EditText mEditTextEq, mEditTextLip, mEditTextEqCerealesSG, mEditTextEqCerealesCG, mEditTextEqLeguminosas, mEditTextEqAoaMbag;
    TextView mTextViewKcal, mTextViewPro, mTextViewLip, mTextViewHco;
    TextView mTextViewKcalFrutas, mTextViewProFrutas, mTextViewLipFrutas, mTextViewHcoFrutas;
    TextView mTextViewKcalCerealesSG, mTextViewProCerealesSG, mTextViewLipCerealesSG, mTextViewHcoCerealesSG;
    TextView mTextViewKcalCerealesCG, mTextViewProCerealesCG, mTextViewLipCerealesCG, mTextViewHcoCerealesCG;
    TextView mTextViewKcalLeguminosas, mTextViewProLeguminosas, mTextViewLipLeguminosas, mTextViewHcoLeguminosas;
    TextView mTextViewKcalAoaMbag, mTextViewProAoaMbag, mTextViewLipAoaMbag, mTextViewHcoAoaMbag;
    EditText mEditTextEqAoaBag, mEditTextEqAoaMag, mEditTextEqAoaAag, mEditTextEqLecheDes, mEditTextEqLecheSemi;
    TextView mTextViewKcalAoaBag, mTextViewProAoaBag, mTextViewLipAoaBag, mTextViewHcoAoaBag, mEditTextEqLecheEntera;
    TextView mTextViewKcalAoaMag, mTextViewProAoaMag, mTextViewLipAoaMag, mTextViewHcoAoaMag;
    TextView mTextViewKcalAoaAag, mTextViewProAoaAag, mTextViewLipAoaAag, mTextViewHcoAoaAag;
    TextView mTextViewKcalLecheDes, mTextViewProLecheDes, mTextViewLipLecheDes, mTextViewHcoLecheDes;
    TextView mTextViewKcalLecheSemi, mTextViewProLecheSemi, mTextViewLipLecheSemi, mTextViewHcoLecheSemi;
    TextView mTextViewKcalLecheEntera, mTextViewProLecheEntera, mTextViewLipLecheEntera, mTextViewHcoLecheEntera;

    EditText mEditTextEqLecheCa, mEditTextEqAceitesSP, mEditTextEqAceitesCP, mEditTextEqAzucarSG, mEditTextEqAzucarCG;
    TextView mTextViewKcalLecheCa, mTextViewProLecheCa, mTextViewLipLecheCa, mTextViewHcoLecheCa;
    TextView mTextViewKcalAceitesSP, mTextViewProAceitesSP, mTextViewLipAceitesSP, mTextViewHcoAceitesSP;
    TextView mTextViewKcalAceitesCP, mTextViewProAceitesCP, mTextViewLipAceitesCP, mTextViewHcoAceitesCP;
    TextView mTextViewKcalAzucarSG, mTextViewProAzucarSG, mTextViewLipAzucarSG, mTextViewHcoAzucarSG;
    TextView mTextViewKcalAzucarCG, mTextViewProAzucarCG, mTextViewLipAzucarCG, mTextViewHcoAzucarCG;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equivalent);

        mEditTextEq = findViewById(R.id.editTextEq);
        mTextViewKcal = findViewById(R.id.textViewKcal);
        mTextViewPro = findViewById(R.id.textViewPro);
        mTextViewLip = findViewById(R.id.textViewLip);
        mTextViewHco = findViewById(R.id.textViewHco);

        mEditTextLip = findViewById(R.id.editTextLip);
        mTextViewKcalFrutas = findViewById(R.id.textViewKcalFrutas);
        mTextViewProFrutas = findViewById(R.id.textViewProFrutas);
        mTextViewLipFrutas = findViewById(R.id.textViewLipFrutas);
        mTextViewHcoFrutas = findViewById(R.id.textViewHcoFrutas);

        mEditTextEqCerealesSG = findViewById(R.id.editTextEqCerealesSG);
        mTextViewKcalCerealesSG = findViewById(R.id.textViewKcalCerealesSG);
        mTextViewProCerealesSG = findViewById(R.id.textViewProCerealesSG);
        mTextViewLipCerealesSG = findViewById(R.id.textViewLipCerealesSG);
        mTextViewHcoCerealesSG = findViewById(R.id.textViewHcoCerealesSG);

        mEditTextEqCerealesCG = findViewById(R.id.editTextEqCerealesCG);
        mTextViewKcalCerealesCG = findViewById(R.id.textViewKcalCerealesCG);
        mTextViewProCerealesCG = findViewById(R.id.textViewProCerealesCG);
        mTextViewLipCerealesCG = findViewById(R.id.textViewLipCerealesCG);
        mTextViewHcoCerealesCG = findViewById(R.id.textViewHcoCerealesCG);

        mEditTextEqLeguminosas = findViewById(R.id.editTextEqLeguminosas);
        mTextViewKcalLeguminosas = findViewById(R.id.textViewKcalLeguminosas);
        mTextViewProLeguminosas = findViewById(R.id.textViewProLeguminosas);
        mTextViewLipLeguminosas = findViewById(R.id.textViewLipLeguminosas);
        mTextViewHcoLeguminosas = findViewById(R.id.textViewHcoLeguminosas);

        mEditTextEqAoaMbag = findViewById(R.id.editTextEqAoaMbag);
        mTextViewKcalAoaMbag = findViewById(R.id.textViewKcalAoaMbag);
        mTextViewProAoaMbag = findViewById(R.id.textViewProAoaMbag);
        mTextViewLipAoaMbag = findViewById(R.id.textViewLipAoaMbag);
        mTextViewHcoAoaMbag = findViewById(R.id.textViewHcoAoaMbag);

        mEditTextEqAoaBag = findViewById(R.id.editTextEqAoaBag);
        mTextViewKcalAoaBag = findViewById(R.id.textViewKcalAoaBag);
        mTextViewProAoaBag = findViewById(R.id.textViewProAoaBag);
        mTextViewLipAoaBag = findViewById(R.id.textViewLipAoaBag);
        mTextViewHcoAoaBag = findViewById(R.id.textViewHcoAoaBag);

        mEditTextEqAoaMag = findViewById(R.id.editTextEqAoaMag);
        mTextViewKcalAoaMag = findViewById(R.id.textViewKcalAoaMag);
        mTextViewProAoaMag = findViewById(R.id.textViewProAoaMag);
        mTextViewLipAoaMag = findViewById(R.id.textViewLipAoaMag);
        mTextViewHcoAoaMag = findViewById(R.id.textViewHcoAoaMag);

        mEditTextEqAoaAag = findViewById(R.id.editTextEqAoaAag);
        mTextViewKcalAoaAag = findViewById(R.id.textViewKcalAoaAag);
        mTextViewProAoaAag = findViewById(R.id.textViewProAoaAag);
        mTextViewLipAoaAag = findViewById(R.id.textViewLipAoaAag);
        mTextViewHcoAoaAag = findViewById(R.id.textViewHcoAoaAag);

        mEditTextEqLecheDes = findViewById(R.id.editTextEqLecheDes);
        mTextViewKcalLecheDes = findViewById(R.id.textViewKcalLecheDes);
        mTextViewProLecheDes = findViewById(R.id.textViewProLecheDes);
        mTextViewLipLecheDes = findViewById(R.id.textViewLipLecheDes);
        mTextViewHcoLecheDes = findViewById(R.id.textViewHcoLecheDes);

        mEditTextEqLecheSemi = findViewById(R.id.editTextEqLecheSemi);
        mTextViewKcalLecheSemi = findViewById(R.id.textViewKcalLecheSemi);
        mTextViewProLecheSemi = findViewById(R.id.textViewProLecheSemi);
        mTextViewLipLecheSemi = findViewById(R.id.textViewLipLecheSemi);
        mTextViewHcoLecheSemi = findViewById(R.id.textViewHcoLecheSemi);

        mEditTextEqLecheEntera = findViewById(R.id.editTextEqLecheEntera);
        mTextViewKcalLecheEntera = findViewById(R.id.textViewKcalLecheEntera);
        mTextViewProLecheEntera = findViewById(R.id.textViewProLecheEntera);
        mTextViewLipLecheEntera = findViewById(R.id.textViewLipLecheEntera);
        mTextViewHcoLecheEntera = findViewById(R.id.textViewHcoLecheEntera);

        mEditTextEqLecheCa = findViewById(R.id.editTextEqLecheCa);
        mTextViewKcalLecheCa = findViewById(R.id.textViewKcalLecheCa);
        mTextViewProLecheCa = findViewById(R.id.textViewProLecheCa);
        mTextViewLipLecheCa = findViewById(R.id.textViewLipLecheCa);
        mTextViewHcoLecheCa = findViewById(R.id.textViewHcoLecheCa);

        mEditTextEqAceitesSP = findViewById(R.id.editTextEqAceitesSP);
        mTextViewKcalAceitesSP = findViewById(R.id.textViewKcalAceitesSP);
        mTextViewProAceitesSP = findViewById(R.id.textViewProAceitesSP);
        mTextViewLipAceitesSP = findViewById(R.id.textViewLipAceitesSP);
        mTextViewHcoAceitesSP = findViewById(R.id.textViewHcoAceitesSP);

        mEditTextEqAceitesCP = findViewById(R.id.editTextEqAceitesCP);
        mTextViewKcalAceitesCP = findViewById(R.id.textViewKcalAceitesCP);
        mTextViewProAceitesCP = findViewById(R.id.textViewProAceitesCP);
        mTextViewLipAceitesCP = findViewById(R.id.textViewLipAceitesCP);
        mTextViewHcoAceitesCP = findViewById(R.id.textViewHcoAceitesCP);

        mEditTextEqAzucarSG = findViewById(R.id.editTextEqAzucarSG);
        mTextViewKcalAzucarSG = findViewById(R.id.textViewKcalAzucarSG);
        mTextViewProAzucarSG = findViewById(R.id.textViewProAzucarSG);
        mTextViewLipAzucarSG = findViewById(R.id.textViewLipAzucarSG);
        mTextViewHcoAzucarSG = findViewById(R.id.textViewHcoAzucarSG);

        mEditTextEqAzucarCG = findViewById(R.id.editTextEqAzucarCG);
        mTextViewKcalAzucarCG = findViewById(R.id.textViewKcalAzucarCG);
        mTextViewProAzucarCG = findViewById(R.id.textViewProAzucarCG);
        mTextViewLipAzucarCG = findViewById(R.id.textViewLipAzucarCG);
        mTextViewHcoAzucarCG = findViewById(R.id.textViewHcoAzucarCG);


        fillTable();
    }

    private void fillTable() {
        getValues("Verduras");
        getValues("Frutas");
        getValues("Cereales S/G");
        getValues("Cereales C/G");
        getValues("Leguminosas");
        getValues("AOA MBAG");
        getValues("AOA BAG");
        getValues("AOA MAG");
        getValues("AOA AAG");
        getValues("Leche Des");
        getValues("Leche Semi");
        getValues("Leche Entera");
        getValues("Leche CA");
        getValues("Aceites SP");
        getValues("Aceites CP");
        getValues("Azucar SG");
        getValues("Azucar CG");
    }

    private void getValues(String name) {
        float kcal = 0, pro = 0, lip = 0, hco = 0;

        if (name.equals("Verduras")){
            float random, min = 1, max = 10;
            kcal = 25;
            pro = 2;
            lip = 0;
            hco = 4;

            random = (int) (min + Math.random() * (max - min));

            kcal = kcal * random;
            pro = pro * random;
            lip = lip * random;
            hco = hco * random;

            mEditTextEq.setText(String.valueOf(random));
            mTextViewKcal.setText(String.valueOf(kcal));
            mTextViewPro.setText(String.valueOf(pro));
            mTextViewLip.setText(String.valueOf(lip));
            mTextViewHco.setText(String.valueOf(hco));
        }
        if (name.equals("Frutas")){
            float random, min = 1, max = 10;

            kcal = 60;
            pro = 0;
            lip = 0;
            hco = 15;

            random = (int) (min + Math.random() * (max - min));

            kcal = kcal * random;
            pro = pro * random;
            lip = lip * random;
            hco = hco * random;

            mEditTextLip.setText(String.valueOf(random));
            mTextViewKcalFrutas.setText(String.valueOf(kcal));
            mTextViewProFrutas.setText(String.valueOf(pro));
            mTextViewLipFrutas.setText(String.valueOf(lip));
            mTextViewHcoFrutas.setText(String.valueOf(hco));
        }

        if (name.equals("Cereales S/G")){
            float random, min = 1, max = 20;

            kcal = 70;
            pro = 2;
            lip = 0;
            hco = 15;

            random = (int) (min + Math.random() * (max - min));

            kcal = kcal * random;
            pro = pro * random;
            lip = lip * random;
            hco = hco * random;

            mEditTextEqCerealesSG.setText(String.valueOf(random));
            mTextViewKcalCerealesSG.setText(String.valueOf(kcal));
            mTextViewProCerealesSG.setText(String.valueOf(pro));
            mTextViewLipCerealesSG.setText(String.valueOf(lip));
            mTextViewHcoCerealesSG.setText(String.valueOf(hco));
        }

        if (name.equals("Cereales C/G")){
            float random, min = 1, max = 10;

            kcal = 115;
            pro = 2;
            lip = 5;
            hco = 15;

            random = (int) (min + Math.random() * (max - min));

            kcal = kcal * random;
            pro = pro * random;
            lip = lip * random;
            hco = hco * random;

            mEditTextEqCerealesCG.setText(String.valueOf(random));
            mTextViewKcalCerealesCG.setText(String.valueOf(kcal));
            mTextViewProCerealesCG.setText(String.valueOf(pro));
            mTextViewLipCerealesCG.setText(String.valueOf(lip));
            mTextViewHcoCerealesCG.setText(String.valueOf(hco));
        }

        if (name.equals("Leguminosas")){
            float random, min = 1, max = 10;

            kcal = 120;
            pro = 8;
            lip = 1;
            hco = 20;

            random = (int) (min + Math.random() * (max - min));

            kcal = kcal * random;
            pro = pro * random;
            lip = lip * random;
            hco = hco * random;

            mEditTextEqLeguminosas.setText(String.valueOf(random));
            mTextViewKcalLeguminosas.setText(String.valueOf(kcal));
            mTextViewProLeguminosas.setText(String.valueOf(pro));
            mTextViewLipLeguminosas.setText(String.valueOf(lip));
            mTextViewHcoLeguminosas.setText(String.valueOf(hco));
        }

        if (name.equals("AOA MBAG")){
            float random, min = 1, max = 12;

            kcal = 40;
            pro = 7;
            lip = 1;
            hco = 0;

            random = (int) (min + Math.random() * (max - min));

            kcal = kcal * random;
            pro = pro * random;
            lip = lip * random;
            hco = hco * random;

            mEditTextEqAoaMbag.setText(String.valueOf(random));
            mTextViewKcalAoaMbag.setText(String.valueOf(kcal));
            mTextViewProAoaMbag.setText(String.valueOf(pro));
            mTextViewLipAoaMbag.setText(String.valueOf(lip));
            mTextViewHcoAoaMbag.setText(String.valueOf(hco));
        }

        if (name.equals("AOA BAG")){
            float random, min = 1, max = 12;

            kcal = 55;
            pro = 7;
            lip = 3;
            hco = 0;

            random = (int) (min + Math.random() * (max - min));

            kcal = kcal * random;
            pro = pro * random;
            lip = lip * random;
            hco = hco * random;

            mEditTextEqAoaBag.setText(String.valueOf(random));
            mTextViewKcalAoaBag.setText(String.valueOf(kcal));
            mTextViewProAoaBag.setText(String.valueOf(pro));
            mTextViewLipAoaBag.setText(String.valueOf(lip));
            mTextViewHcoAoaMbag.setText(String.valueOf(hco));
        }

        if (name.equals("AOA MAG")){
            float random, min = 1, max = 12;

            kcal = 75;
            pro = 7;
            lip = 5;
            hco = 0;

            random = (int) (min + Math.random() * (max - min));

            kcal = kcal * random;
            pro = pro * random;
            lip = lip * random;
            hco = hco * random;

            mEditTextEqAoaMag.setText(String.valueOf(random));
            mTextViewKcalAoaMag.setText(String.valueOf(kcal));
            mTextViewProAoaMag.setText(String.valueOf(pro));
            mTextViewLipAoaMag.setText(String.valueOf(lip));
            mTextViewHcoAoaMag.setText(String.valueOf(hco));
        }

        if (name.equals("AOA AAG")){
            float random, min = 1, max = 12;

            kcal = 100;
            pro = 7;
            lip = 8;
            hco = 0;

            random = (int) (min + Math.random() * (max - min));

            kcal = kcal * random;
            pro = pro * random;
            lip = lip * random;
            hco = hco * random;

            mEditTextEqAoaAag.setText(String.valueOf(random));
            mTextViewKcalAoaAag.setText(String.valueOf(kcal));
            mTextViewProAoaAag.setText(String.valueOf(pro));
            mTextViewLipAoaAag.setText(String.valueOf(lip));
            mTextViewHcoAoaAag.setText(String.valueOf(hco));
        }

        if (name.equals("Leche Des")){
            float random, min = 1, max = 7;

            kcal = 95;
            pro = 9;
            lip = 2;
            hco = 12;

            random = (int) (min + Math.random() * (max - min));

            kcal = kcal * random;
            pro = pro * random;
            lip = lip * random;
            hco = hco * random;

            mEditTextEqLecheDes.setText(String.valueOf(random));
            mTextViewKcalLecheDes.setText(String.valueOf(kcal));
            mTextViewProLecheDes.setText(String.valueOf(pro));
            mTextViewLipLecheDes.setText(String.valueOf(lip));
            mTextViewHcoLecheDes.setText(String.valueOf(hco));
        }

        if (name.equals("Leche Semi")){
            float random, min = 1, max = 7;

            kcal = 110;
            pro = 9;
            lip = 4;
            hco = 12;

            random = (int) (min + Math.random() * (max - min));

            kcal = kcal * random;
            pro = pro * random;
            lip = lip * random;
            hco = hco * random;

            mEditTextEqLecheSemi.setText(String.valueOf(random));
            mTextViewKcalLecheSemi.setText(String.valueOf(kcal));
            mTextViewProLecheSemi.setText(String.valueOf(pro));
            mTextViewLipLecheSemi.setText(String.valueOf(lip));
            mTextViewHcoLecheSemi.setText(String.valueOf(hco));
        }

        if (name.equals("Leche Entera")){
            float random, min = 1, max = 7;

            kcal = 150;
            pro = 9;
            lip = 8;
            hco = 12;

            random = (int) (min + Math.random() * (max - min));

            kcal = kcal * random;
            pro = pro * random;
            lip = lip * random;
            hco = hco * random;

            mEditTextEqLecheEntera.setText(String.valueOf(random));
            mTextViewKcalLecheEntera.setText(String.valueOf(kcal));
            mTextViewProLecheEntera.setText(String.valueOf(pro));
            mTextViewLipLecheEntera.setText(String.valueOf(lip));
            mTextViewHcoLecheEntera.setText(String.valueOf(hco));
        }

        if (name.equals("Leche CA")){
            float random, min = 1, max = 7;

            kcal = 200;
            pro = 8;
            lip = 5;
            hco = 30;

            random = (int) (min + Math.random() * (max - min));

            kcal = kcal * random;
            pro = pro * random;
            lip = lip * random;
            hco = hco * random;

            mEditTextEqLecheCa.setText(String.valueOf(random));
            mTextViewKcalLecheCa.setText(String.valueOf(kcal));
            mTextViewProLecheCa.setText(String.valueOf(pro));
            mTextViewLipLecheCa.setText(String.valueOf(lip));
            mTextViewHcoLecheCa.setText(String.valueOf(hco));
        }

        if (name.equals("Aceites SP")){
            float random, min = 1, max = 10;

            kcal = 45;
            pro = 0;
            lip = 5;
            hco = 0;

            random = (int) (min + Math.random() * (max - min));

            kcal = kcal * random;
            pro = pro * random;
            lip = lip * random;
            hco = hco * random;

            mEditTextEqAceitesSP.setText(String.valueOf(random));
            mTextViewKcalAceitesSP.setText(String.valueOf(kcal));
            mTextViewProAceitesSP.setText(String.valueOf(pro));
            mTextViewLipAceitesSP.setText(String.valueOf(lip));
            mTextViewHcoAceitesSP.setText(String.valueOf(hco));
        }

        if (name.equals("Aceites CP")){
            float random, min = 1, max = 10;

            kcal = 70;
            pro = 3;
            lip = 5;
            hco = 3;

            random = (int) (min + Math.random() * (max - min));

            kcal = kcal * random;
            pro = pro * random;
            lip = lip * random;
            hco = hco * random;

            mEditTextEqAceitesCP.setText(String.valueOf(random));
            mTextViewKcalAceitesCP.setText(String.valueOf(kcal));
            mTextViewProAceitesCP.setText(String.valueOf(pro));
            mTextViewLipAceitesCP.setText(String.valueOf(lip));
            mTextViewHcoAceitesCP.setText(String.valueOf(hco));
        }

        if (name.equals("Azucar SG")){
            float random, min = 1, max = 10;

            kcal = 40;
            pro = 0;
            lip = 0;
            hco = 10;

            random = (int) (min + Math.random() * (max - min));

            kcal = kcal * random;
            pro = pro * random;
            lip = lip * random;
            hco = hco * random;

            mEditTextEqAzucarSG.setText(String.valueOf(random));
            mTextViewKcalAzucarSG.setText(String.valueOf(kcal));
            mTextViewProAzucarSG.setText(String.valueOf(pro));
            mTextViewLipAzucarSG.setText(String.valueOf(lip));
            mTextViewHcoAzucarSG.setText(String.valueOf(hco));
        }

        if (name.equals("Azucar CG")){
            float random, min = 1, max = 10;

            kcal = 85;
            pro = 0;
            lip = 5;
            hco = 10;

            random = (int) (min + Math.random() * (max - min));

            kcal = kcal * random;
            pro = pro * random;
            lip = lip * random;
            hco = hco * random;

            mEditTextEqAzucarCG.setText(String.valueOf(random));
            mTextViewKcalAzucarCG.setText(String.valueOf(kcal));
            mTextViewProAzucarCG.setText(String.valueOf(pro));
            mTextViewLipAzucarCG.setText(String.valueOf(lip));
            mTextViewHcoAzucarCG.setText(String.valueOf(hco));
        }

        mEditTextEq.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!mEditTextEq.getText().toString().isEmpty()){
                    calculate("Verduras");
                    //mEditTextPro.setText("80");
                }
                else {
                    mTextViewKcal.setText("0");
                    mTextViewPro.setText("0");
                    mTextViewLip.setText("0");
                    mTextViewHco.setText("0");
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
                    calculate("Frutas");
                    //mEditTextPro.setText("80");
                }
                else {
                    mTextViewKcalFrutas.setText("0");
                    mTextViewProFrutas.setText("0");
                    mTextViewLipFrutas.setText("0");
                    mTextViewHcoFrutas.setText("0");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mEditTextEqCerealesSG.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!mEditTextEqCerealesSG.getText().toString().isEmpty()){
                    calculate("Cereales S/G");
                    //mEditTextPro.setText("80");
                }
                else {
                    mTextViewKcalCerealesSG.setText("0");
                    mTextViewProCerealesSG.setText("0");
                    mTextViewLipCerealesSG.setText("0");
                    mTextViewHcoCerealesSG.setText("0");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mEditTextEqCerealesCG.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!mEditTextEqCerealesCG.getText().toString().isEmpty()){
                    calculate("Cereales C/G");
                    //mEditTextPro.setText("80");
                }
                else {
                    mTextViewKcalCerealesCG.setText("0");
                    mTextViewProCerealesCG.setText("0");
                    mTextViewLipCerealesCG.setText("0");
                    mTextViewHcoCerealesCG.setText("0");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mEditTextEqLeguminosas.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!mEditTextEqLeguminosas.getText().toString().isEmpty()){
                    calculate("Leguminosas");
                    //mEditTextPro.setText("80");
                }
                else {
                    mTextViewKcalLeguminosas.setText("0");
                    mTextViewProLeguminosas.setText("0");
                    mTextViewLipLeguminosas.setText("0");
                    mTextViewHcoLeguminosas.setText("0");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mEditTextEqAoaMbag.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!mEditTextEqAoaMbag.getText().toString().isEmpty()){
                    calculate("AOA MBAG");
                    //mEditTextPro.setText("80");
                }
                else {
                    mTextViewKcalAoaMbag.setText("0");
                    mTextViewProAoaMbag.setText("0");
                    mTextViewLipAoaMbag.setText("0");
                    mTextViewHcoAoaMbag.setText("0");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mEditTextEqAoaBag.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!mEditTextEqAoaBag.getText().toString().isEmpty()){
                    calculate("AOA BAG");
                    //mEditTextPro.setText("80");
                }
                else {
                    mTextViewKcalAoaBag.setText("0");
                    mTextViewProAoaBag.setText("0");
                    mTextViewLipAoaBag.setText("0");
                    mTextViewHcoAoaBag.setText("0");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mEditTextEqAoaMag.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!mEditTextEqAoaMag.getText().toString().isEmpty()){
                    calculate("AOA MAG");
                    //mEditTextPro.setText("80");
                }
                else {
                    mTextViewKcalAoaMag.setText("0");
                    mTextViewProAoaMag.setText("0");
                    mTextViewLipAoaMag.setText("0");
                    mTextViewHcoAoaMag.setText("0");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mEditTextEqAoaAag.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!mEditTextEqAoaAag.getText().toString().isEmpty()){
                    calculate("AOA AAG");
                    //mEditTextPro.setText("80");
                }
                else {
                    mTextViewKcalAoaAag.setText("0");
                    mTextViewProAoaAag.setText("0");
                    mTextViewLipAoaAag.setText("0");
                    mTextViewHcoAoaAag.setText("0");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mEditTextEqLecheDes.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!mEditTextEqLecheDes.getText().toString().isEmpty()){
                    calculate("Leche Des");
                    //mEditTextPro.setText("80");
                }
                else {
                    mTextViewKcalLecheDes.setText("0");
                    mTextViewProLecheDes.setText("0");
                    mTextViewLipLecheDes.setText("0");
                    mTextViewHcoLecheDes.setText("0");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mEditTextEqLecheSemi.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!mEditTextEqLecheSemi.getText().toString().isEmpty()){
                    calculate("Leche Semi");
                    //mEditTextPro.setText("80");
                }
                else {
                    mTextViewKcalLecheSemi.setText("0");
                    mTextViewProLecheSemi.setText("0");
                    mTextViewLipLecheSemi.setText("0");
                    mTextViewHcoLecheSemi.setText("0");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mEditTextEqLecheEntera.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!mEditTextEqLecheEntera.getText().toString().isEmpty()){
                    calculate("Leche Entera");
                    //mEditTextPro.setText("80");
                }
                else {
                    mTextViewKcalLecheEntera.setText("0");
                    mTextViewProLecheEntera.setText("0");
                    mTextViewLipLecheEntera.setText("0");
                    mTextViewHcoLecheEntera.setText("0");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mEditTextEqLecheCa.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!mEditTextEqLecheCa.getText().toString().isEmpty()){
                    calculate("Leche CA");
                    //mEditTextPro.setText("80");
                }
                else {
                    mTextViewKcalLecheCa.setText("0");
                    mTextViewProLecheCa.setText("0");
                    mTextViewLipLecheCa.setText("0");
                    mTextViewHcoLecheCa.setText("0");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mEditTextEqAceitesSP.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!mEditTextEqAceitesSP.getText().toString().isEmpty()){
                    calculate("Aceites SP");
                    //mEditTextPro.setText("80");
                }
                else {
                    mTextViewKcalAceitesSP.setText("0");
                    mTextViewProAceitesSP.setText("0");
                    mTextViewLipAceitesSP.setText("0");
                    mTextViewHcoAceitesSP.setText("0");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mEditTextEqAceitesCP.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!mEditTextEqAceitesCP.getText().toString().isEmpty()){
                    calculate("Aceites CP");
                    //mEditTextPro.setText("80");
                }
                else {
                    mTextViewKcalAceitesCP.setText("0");
                    mTextViewProAceitesCP.setText("0");
                    mTextViewLipAceitesCP.setText("0");
                    mTextViewHcoAceitesCP.setText("0");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mEditTextEqAzucarSG.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!mEditTextEqAzucarSG.getText().toString().isEmpty()){
                    calculate("Azucar SG");
                    //mEditTextPro.setText("80");
                }
                else {
                    mTextViewKcalAzucarSG.setText("0");
                    mTextViewProAzucarSG.setText("0");
                    mTextViewLipAzucarSG.setText("0");
                    mTextViewHcoAzucarSG.setText("0");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mEditTextEqAzucarCG.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!mEditTextEqAzucarCG.getText().toString().isEmpty()){
                    calculate("Azucar CG");
                    //mEditTextPro.setText("80");
                }
                else {
                    mTextViewKcalAzucarCG.setText("0");
                    mTextViewProAzucarCG.setText("0");
                    mTextViewLipAzucarCG.setText("0");
                    mTextViewHcoAzucarCG.setText("0");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }

    private void calculate(String name) {
        if (name.equals("Verduras")){
            float eq = Float.parseFloat(mEditTextEq.getText().toString());
            float kcal = 25, pro = 2, lip = 0, hco = 4;

            kcal = kcal * eq;
            pro = pro * eq;
            lip = lip * eq;
            hco = hco * eq;

            mTextViewKcal.setText(String.valueOf(kcal));
            mTextViewPro.setText(String.valueOf(pro));
            mTextViewLip.setText(String.valueOf(lip));
            mTextViewHco.setText(String.valueOf(hco));
        }
        if (name.equals("Frutas")){
            if (!mEditTextLip.getText().toString().isEmpty()){
                float eqLip = Float.parseFloat(mEditTextLip.getText().toString());
                float kcal = 60, pro = 0, lip = 0, hco = 15;

                kcal = kcal * eqLip;
                pro = pro * eqLip;
                lip = lip * eqLip;
                hco = hco * eqLip;

                mTextViewKcalFrutas.setText(String.valueOf(kcal));
                mTextViewProFrutas.setText(String.valueOf(pro));
                mTextViewLipFrutas.setText(String.valueOf(lip));
                mTextViewHcoFrutas.setText(String.valueOf(hco));
            }
        }

        if (name.equals("Cereales S/G")){
            if (!mEditTextEqCerealesSG.getText().toString().isEmpty()){
                float eqCerealSG = Float.parseFloat(mEditTextEqCerealesSG.getText().toString());
                float kcal = 70, pro = 2, lip = 0, hco = 15;

                kcal = kcal * eqCerealSG;
                pro = pro * eqCerealSG;
                lip = lip * eqCerealSG;
                hco = hco * eqCerealSG;

                mTextViewKcalCerealesSG.setText(String.valueOf(kcal));
                mTextViewProCerealesSG.setText(String.valueOf(pro));
                mTextViewLipCerealesSG.setText(String.valueOf(lip));
                mTextViewHcoCerealesSG.setText(String.valueOf(hco));
            }
        }

        if (name.equals("Cereales C/G")){
            if (!mEditTextEqCerealesCG.getText().toString().isEmpty()){
                float eqCerealCG = Float.parseFloat(mEditTextEqCerealesCG.getText().toString());
                float kcal = 115, pro = 2, lip = 5, hco = 15;

                kcal = kcal * eqCerealCG;
                pro = pro * eqCerealCG;
                lip = lip * eqCerealCG;
                hco = hco * eqCerealCG;

                mTextViewKcalCerealesCG.setText(String.valueOf(kcal));
                mTextViewProCerealesCG.setText(String.valueOf(pro));
                mTextViewLipCerealesCG.setText(String.valueOf(lip));
                mTextViewHcoCerealesCG.setText(String.valueOf(hco));
            }
        }

        if (name.equals("Leguminosas")){
            if (!mEditTextEqLeguminosas.getText().toString().isEmpty()){
                float eqLeguminosas = Float.parseFloat(mEditTextEqLeguminosas.getText().toString());
                float kcal = 120, pro = 8, lip = 1, hco = 20;

                kcal = kcal * eqLeguminosas;
                pro = pro * eqLeguminosas;
                lip = lip * eqLeguminosas;
                hco = hco * eqLeguminosas;

                mTextViewKcalLeguminosas.setText(String.valueOf(kcal));
                mTextViewProLeguminosas.setText(String.valueOf(pro));
                mTextViewLipLeguminosas.setText(String.valueOf(lip));
                mTextViewHcoLeguminosas.setText(String.valueOf(hco));
            }
        }

        if (name.equals("AOA MBAG")){
            if (!mEditTextEqAoaMbag.getText().toString().isEmpty()){
                float eqAoa = Float.parseFloat(mEditTextEqAoaMbag.getText().toString());
                float kcal = 40, pro = 7, lip = 1, hco = 0;

                kcal = kcal * eqAoa;
                pro = pro * eqAoa;
                lip = lip * eqAoa;
                hco = hco * eqAoa;

                mTextViewKcalAoaMbag.setText(String.valueOf(kcal));
                mTextViewProAoaMbag.setText(String.valueOf(pro));
                mTextViewLipAoaMbag.setText(String.valueOf(lip));
                mTextViewHcoAoaMbag.setText(String.valueOf(hco));
            }
        }

        if (name.equals("AOA BAG")){
            if (!mEditTextEqAoaBag.getText().toString().isEmpty()){
                float eqAoa = Float.parseFloat(mEditTextEqAoaBag.getText().toString());
                float kcal = 55, pro = 7, lip = 3, hco = 0;

                kcal = kcal * eqAoa;
                pro = pro * eqAoa;
                lip = lip * eqAoa;
                hco = hco * eqAoa;

                mTextViewKcalAoaBag.setText(String.valueOf(kcal));
                mTextViewProAoaBag.setText(String.valueOf(pro));
                mTextViewLipAoaBag.setText(String.valueOf(lip));
                mTextViewHcoAoaBag.setText(String.valueOf(hco));
            }
        }

        if (name.equals("AOA MAG")){
            if (!mEditTextEqAoaMag.getText().toString().isEmpty()){
                float eqAoaMag = Float.parseFloat(mEditTextEqAoaMag.getText().toString());
                float kcal = 75, pro = 7, lip = 5, hco = 0;

                kcal = kcal * eqAoaMag;
                pro = pro * eqAoaMag;
                lip = lip * eqAoaMag;
                hco = hco * eqAoaMag;

                mTextViewKcalAoaMag.setText(String.valueOf(kcal));
                mTextViewProAoaMag.setText(String.valueOf(pro));
                mTextViewLipAoaMag.setText(String.valueOf(lip));
                mTextViewHcoAoaMag.setText(String.valueOf(hco));
            }
        }

        if (name.equals("AOA AAG")){
            if (!mEditTextEqAoaAag.getText().toString().isEmpty()){
                float eqAoaAag = Float.parseFloat(mEditTextEqAoaAag.getText().toString());
                float kcal = 100, pro = 7, lip = 8, hco = 0;

                kcal = kcal * eqAoaAag;
                pro = pro * eqAoaAag;
                lip = lip * eqAoaAag;
                hco = hco * eqAoaAag;

                mTextViewKcalAoaAag.setText(String.valueOf(kcal));
                mTextViewProAoaAag.setText(String.valueOf(pro));
                mTextViewLipAoaAag.setText(String.valueOf(lip));
                mTextViewHcoAoaAag.setText(String.valueOf(hco));
            }
        }

        if (name.equals("Leche Des")){
            if (!mEditTextEqLecheDes.getText().toString().isEmpty()){
                float eqAoaAag = Float.parseFloat(mEditTextEqLecheDes.getText().toString());
                float kcal = 95, pro = 9, lip = 2, hco = 12;

                kcal = kcal * eqAoaAag;
                pro = pro * eqAoaAag;
                lip = lip * eqAoaAag;
                hco = hco * eqAoaAag;

                mTextViewKcalLecheDes.setText(String.valueOf(kcal));
                mTextViewProLecheDes.setText(String.valueOf(pro));
                mTextViewLipLecheDes.setText(String.valueOf(lip));
                mTextViewHcoLecheDes.setText(String.valueOf(hco));
            }
        }

        if (name.equals("Leche Semi")){
            if (!mEditTextEqLecheSemi.getText().toString().isEmpty()){
                float eqAoaAag = Float.parseFloat(mEditTextEqLecheSemi.getText().toString());
                float kcal = 110, pro = 9, lip = 4, hco = 12;

                kcal = kcal * eqAoaAag;
                pro = pro * eqAoaAag;
                lip = lip * eqAoaAag;
                hco = hco * eqAoaAag;

                mTextViewKcalLecheSemi.setText(String.valueOf(kcal));
                mTextViewProLecheSemi.setText(String.valueOf(pro));
                mTextViewLipLecheSemi.setText(String.valueOf(lip));
                mTextViewHcoLecheSemi.setText(String.valueOf(hco));
            }
        }

        if (name.equals("Leche Entera")){
            if (!mEditTextEqLecheEntera.getText().toString().isEmpty()){
                float eqAoaAag = Float.parseFloat(mEditTextEqLecheEntera.getText().toString());
                float kcal = 150, pro = 9, lip = 8, hco = 12;

                kcal = kcal * eqAoaAag;
                pro = pro * eqAoaAag;
                lip = lip * eqAoaAag;
                hco = hco * eqAoaAag;

                mTextViewKcalLecheEntera.setText(String.valueOf(kcal));
                mTextViewProLecheEntera.setText(String.valueOf(pro));
                mTextViewLipLecheEntera.setText(String.valueOf(lip));
                mTextViewHcoLecheEntera.setText(String.valueOf(hco));
            }
        }

        if (name.equals("Leche CA")){
            if (!mEditTextEqLecheCa.getText().toString().isEmpty()){
                float eqAoaAag = Float.parseFloat(mEditTextEqLecheCa.getText().toString());
                float kcal = 200, pro = 8, lip = 5, hco = 30;

                kcal = kcal * eqAoaAag;
                pro = pro * eqAoaAag;
                lip = lip * eqAoaAag;
                hco = hco * eqAoaAag;

                mTextViewKcalLecheCa.setText(String.valueOf(kcal));
                mTextViewProLecheCa.setText(String.valueOf(pro));
                mTextViewLipLecheCa.setText(String.valueOf(lip));
                mTextViewHcoLecheCa.setText(String.valueOf(hco));
            }
        }

        if (name.equals("Aceites SP")){
            if (!mEditTextEqAceitesSP.getText().toString().isEmpty()){
                float eqAoaAag = Float.parseFloat(mEditTextEqAceitesSP.getText().toString());
                float kcal = 45, pro = 0, lip = 5, hco = 0;

                kcal = kcal * eqAoaAag;
                pro = pro * eqAoaAag;
                lip = lip * eqAoaAag;
                hco = hco * eqAoaAag;

                mTextViewKcalAceitesSP.setText(String.valueOf(kcal));
                mTextViewProAceitesSP.setText(String.valueOf(pro));
                mTextViewLipAceitesSP.setText(String.valueOf(lip));
                mTextViewHcoAceitesSP.setText(String.valueOf(hco));
            }
        }

        if (name.equals("Aceites CP")){
            if (!mEditTextEqAceitesCP.getText().toString().isEmpty()){
                float eqAoaAag = Float.parseFloat(mEditTextEqAceitesCP.getText().toString());
                float kcal = 70, pro = 3, lip = 5, hco = 3;

                kcal = kcal * eqAoaAag;
                pro = pro * eqAoaAag;
                lip = lip * eqAoaAag;
                hco = hco * eqAoaAag;

                mTextViewKcalAceitesCP.setText(String.valueOf(kcal));
                mTextViewProAceitesCP.setText(String.valueOf(pro));
                mTextViewLipAceitesCP.setText(String.valueOf(lip));
                mTextViewHcoAceitesCP.setText(String.valueOf(hco));
            }
        }

        if (name.equals("Azucar SG")){
            if (!mEditTextEqAzucarSG.getText().toString().isEmpty()){
                float eqAoaAag = Float.parseFloat(mEditTextEqAzucarSG.getText().toString());
                float kcal = 40, pro = 0, lip = 0, hco = 10;

                kcal = kcal * eqAoaAag;
                pro = pro * eqAoaAag;
                lip = lip * eqAoaAag;
                hco = hco * eqAoaAag;

                mTextViewKcalAzucarSG.setText(String.valueOf(kcal));
                mTextViewProAzucarSG.setText(String.valueOf(pro));
                mTextViewLipAzucarSG.setText(String.valueOf(lip));
                mTextViewHcoAzucarSG.setText(String.valueOf(hco));
            }
        }

        if (name.equals("Azucar CG")){
            if (!mEditTextEqAzucarCG.getText().toString().isEmpty()){
                float eqAoaAag = Float.parseFloat(mEditTextEqAzucarCG.getText().toString());
                float kcal = 85, pro = 0, lip = 5, hco = 10;

                kcal = kcal * eqAoaAag;
                pro = pro * eqAoaAag;
                lip = lip * eqAoaAag;
                hco = hco * eqAoaAag;

                mTextViewKcalAzucarCG.setText(String.valueOf(kcal));
                mTextViewProAzucarCG.setText(String.valueOf(pro));
                mTextViewLipAzucarCG.setText(String.valueOf(lip));
                mTextViewHcoAzucarCG.setText(String.valueOf(hco));
            }
        }

    }
}