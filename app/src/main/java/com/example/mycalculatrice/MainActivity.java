package com.example.mycalculatrice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.material.button.MaterialButton;
import  org.mozilla.javascript.Context;
import  org.mozilla.javascript.Scriptable;
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView solution, result;
    MaterialButton button_C, button_openbracket, buttoncloseBrack;
    MaterialButton ButtonDivide, Bplus, BMoins, BMultiple, buttonEgale;
    MaterialButton B0, B1, B2, B3, B4, B5, B6, B7, B8, B9;
    MaterialButton BAC, BPoint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        android.content.Context context = getApplicationContext();
        CharSequence text = "switching";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();


        result = findViewById(R.id.result);
        solution = findViewById(R.id.solution);
        attribuerId(button_C, R.id.button_c);
        attribuerId(button_openbracket, R.id.button_openBracket);
        attribuerId(buttoncloseBrack, R.id.button_closeBracket);
        attribuerId(ButtonDivide, R.id.button_Devise);
        attribuerId(Bplus, R.id.button_plus);
        attribuerId(BMoins, R.id.button_Moins);

        attribuerId(BMultiple, R.id.button_multiple);
        attribuerId(buttonEgale, R.id.button_Egale);
        attribuerId(B0, R.id.button_0);
        attribuerId(B1, R.id.button_1);
        attribuerId(B2, R.id.button_2);
        attribuerId(B3, R.id.button_3);
        attribuerId(B4, R.id.button_4);
        attribuerId(B5, R.id.button_5);
        attribuerId(B6, R.id.button_6);
        attribuerId(B7, R.id.button_7);
        attribuerId(B8, R.id.button_8);
        attribuerId(B9, R.id.button_9);
        attribuerId(BAC, R.id.button_AC);
        attribuerId(BPoint, R.id.button_Point);
    }

    @Override
    public void onClick(View view) {
        MaterialButton button = (MaterialButton) view;
        String btntxt = button.getText().toString();

        String datacalcule = solution.getText().toString();

        if (btntxt.equals("AC"))
        {
            solution.setText(" ");
            result.setText("0");
             return;
        }
        if (btntxt.equals("=")) {
           solution.setText(result.getText());
            return;

        }
        if (btntxt.equals("C")) {
            if(datacalcule.length()>1)
            { datacalcule = datacalcule.substring(0, datacalcule.length() - 1);}
            else {
                solution.setText(" ");
                result.setText("0");
            }
        } else {
            datacalcule = datacalcule + btntxt;
        }

        solution.setText(datacalcule);
        String finalresult = getResult(datacalcule);
        if (!finalresult.equals("err")) {
            result.setText(finalresult);
        }
    }

    String getResult(String data) {
        try {
            Context context = Context.enter();
            context.setOptimizationLevel(-1);
            Scriptable sc = context.initStandardObjects();
            String finalresult = context.evaluateString(sc, data, "Javascript", 1, null).toString();

            if (finalresult.endsWith(".0")) {
                finalresult = finalresult.replace(".0", "");
            }
            return finalresult;
        } catch (Exception e) {
            return "err";
        }
    }

    void attribuerId(MaterialButton btn, int id) {
        btn = findViewById(id);
        btn.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menucalculatrice, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.simple:
                Toast.makeText(this, "Calculatrice simple selected", Toast.LENGTH_SHORT).show();

                break;


            case R.id.CalculateurIMC_IMG:
                Intent IMcG=new Intent(this,MainActivityCalculateur_IMG_IMC.class);
                startActivity(IMcG);
                Toast.makeText(this, "Calculateur IMC selected", Toast.LENGTH_SHORT).show();
                // return true;
                break;
            case R.id.Scientifique:
                Intent openAct=new Intent(this,MainActivityCalculScientifique.class);
                startActivity(openAct);
                Toast.makeText(this, "Calculatrice Scientifique  selected", Toast.LENGTH_SHORT).show();
                // return true;
                break;
            case R.id.convertisseur:
                Intent convertisseur=new Intent(this,MainActivityConvertisseur.class);
                startActivity(convertisseur);
                Toast.makeText(this, "Convertisseur du Metre  selected", Toast.LENGTH_SHORT).show();
                // return true;
                break;
            // default:

        }
        return super.onOptionsItemSelected(item);
        //return true;
    }



}
