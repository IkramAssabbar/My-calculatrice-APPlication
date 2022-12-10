package com.example.mycalculatrice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivityCalculateur_IMG_IMC extends AppCompatActivity {

    TextView Poids,Taille,Age;
    RadioButton f,H ;
    Button IMC,IMG;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_calculateur_img_imc);
        Poids=(TextView) findViewById(R.id.inputpoids);
        Taille=(TextView) findViewById(R.id.inputTaille);
        Age=(TextView) findViewById(R.id.inputAge);
        f= findViewById(R.id.ButtonFemme);
        H= findViewById(R.id.ButtonHomme);
        IMC=findViewById(R.id.buttonIMC);
        IMG=findViewById(R.id.buttonIMG);
        IMC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    float poids=1;
                    float taille=1;
                    float imc;
                    int age=0;
                    int s=0;
                poids=Float.parseFloat(Poids.getText().toString());
                taille=Float.parseFloat(Taille.getText().toString());
                age=Integer.parseInt(Age.getText().toString());
                   //test de sexe
                    if(f.isChecked())
                        s=0;
                    else
                        s=1;
                taille=taille/100;
                //IMC CALCULE
                imc=poids/(taille*taille);
                //intent
                Intent intent=new Intent(MainActivityCalculateur_IMG_IMC.this,MainActivity_IMGTest.class);
            Bundle bn=new Bundle();
            bn.putInt("Age",age);
                bn.putFloat("Taille",  taille);
                bn.putFloat("Poids",  poids);
                bn.putInt("f",s);
                bn.putFloat("IMC",imc);
                intent.putExtras(bn);
                startActivity(intent);

            }
        });
IMG.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        float poids=1;
        float taille=1;
        float imgC;
        int age=0;
        int s=0;
        poids=Float.parseFloat(Poids.getText().toString());
        taille=Float.parseFloat(Taille.getText().toString());
        age=Integer.parseInt(Age.getText().toString());
        if(f.isChecked())
            s=0;
        else
            s=1;
        taille=taille/100;
        //IMG CALCULE
        imgC=(float)(1.29*(poids/(taille*taille))*0.20*age-(11.4*s)-8);
            Intent intent =new Intent(MainActivityCalculateur_IMG_IMC.this,MainActivity_IMCTest.class);
        Bundle bn=new Bundle();
        bn.putInt("Age",age);
        bn.putFloat("Taille",  taille);
        bn.putFloat("Poids",  poids);
        bn.putInt("f",s);
        bn.putFloat("IMG",imgC);
        intent.putExtras(bn);
        startActivity(intent);
    }
});

    }
}