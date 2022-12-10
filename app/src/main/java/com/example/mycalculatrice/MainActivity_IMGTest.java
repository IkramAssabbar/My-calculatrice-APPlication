package com.example.mycalculatrice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity_IMGTest extends AppCompatActivity {
private TextView pd,tl,age,sex,imc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_imctest);
        pd=findViewById(R.id.textPoids);
        tl=findViewById(R.id.textTaille);
        age=findViewById(R.id.textAGE);
        sex=findViewById(R.id.textSexe);
        imc=findViewById(R.id.textResult);
    Bundle bn=getIntent().getExtras();
    int age1= bn.getInt("Age");
    float tl1=bn.getFloat("Taille");
    float pds=bn.getFloat("Poids");
    float resultaImc=bn.getFloat("IMC");
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
imc.setText(" le resultat de votre Calcul est "+String.format("%.02f",resultaImc));




    }
}