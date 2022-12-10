package com.example.mycalculatrice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity_IMCTest extends AppCompatActivity {
    private TextView pd,tl,age,sex,imgc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_imgtest);
        pd=findViewById(R.id.textPoids);
        tl=findViewById(R.id.textTaille);
        age=findViewById(R.id.textAGE);
        sex=findViewById(R.id.textSexe);
        imgc=findViewById(R.id.textResult);
        Bundle bn=getIntent().getExtras();
        int age1= bn.getInt("Age");
        float tl1=bn.getFloat("Taille");
        float pds=bn.getFloat("Poids");
        float resultaImg=bn.getFloat("IMG");
        String sex1;
        int sexHomme;
        sexHomme= bn.getInt("f");
        if(sexHomme==0)
            sex1="Femme";
        else
            sex1="Homme";
//affichage
        sex.setText("Vous Etes "+sex1);
        age.setText("votre age est "+age1);
        pd.setText("votre poids est "+pds+" KG");
        tl.setText("votre taille est "+tl1+"Metre");
        imgc.setText(" le resultat de votre Calcul est "+String.format("%.02f",resultaImg));




    }
}