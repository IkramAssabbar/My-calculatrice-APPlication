package com.example.mycalculatrice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivityConvertisseur extends AppCompatActivity {
    Button btnresulta;
    TextView afficheReponse;
    EditText getvalue;
    RadioButton Rcm,RM,Rdm,Rmm,Rcm1,RM1,Rmm1,Rdm1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_convertisseur);
        btnresulta =(Button) findViewById(R.id.btnresultat);
        afficheReponse=(TextView) findViewById(R.id.result);
        getvalue=(EditText) findViewById(R.id.inputnumber);
        Rcm=(RadioButton) findViewById(R.id.btncm);
        RM=(RadioButton)findViewById(R.id.btnmetre);
        Rdm=(RadioButton)findViewById(R.id.btndm);
        Rmm=(RadioButton)findViewById(R.id.btnmm);
        Rcm1=(RadioButton)findViewById(R.id.btnCmetre);
        RM1=(RadioButton)findViewById(R.id.btnmetre2);
        Rmm1=(RadioButton)findViewById(R.id.btnMmetre);
        Rdm1=(RadioButton)findViewById(R.id.btnDmetre);
    btnresulta.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if(getvalue.getText().toString().isEmpty()){
            afficheReponse.setText("please enter a number");}
        else
            {
                Double x=Double.parseDouble(String.valueOf(getvalue.getText()));
               if(RM.isChecked() && RM1.isChecked())
               {
                   x=x;
                   afficheReponse.setText(String.valueOf(x));
               }
                else if(RM.isChecked() && Rcm1.isChecked())
                {
                    x=x*100;
                    afficheReponse.setText(String.valueOf(x));
                }
               else if(RM.isChecked() && Rmm1.isChecked())
               {
                   x=x*1000;
                   afficheReponse.setText(String.valueOf(x));
               }
               else if(RM.isChecked() && Rdm1.isChecked())
               {
                   x=x*10;
                   afficheReponse.setText(String.valueOf(x));
               }
               if(Rcm.isChecked())
               {
                   if(Rcm1.isChecked())
                   {
                       x=x;
                       afficheReponse.setText(String.valueOf(x));
                   }
                   else if(Rdm1.isChecked())
                   {
                       x=x*0.1;
                       afficheReponse.setText(String.valueOf(x));
                   }
                   else if(Rmm1.isChecked())
                   {
                       x=x*10;
                       afficheReponse.setText(String.valueOf(x));
                   }
                   else if(RM1.isChecked())
                   {
                       x=x*0.01;
                       afficheReponse.setText(String.valueOf(x));
                   }
               }
               if(Rdm.isChecked())
               {
                   if(Rdm1.isChecked())
                   {
                       x=x;
                       afficheReponse.setText(String.valueOf(x));
                   }
                   else if(Rcm1.isChecked())
                   {
                       x=x*10;
                       afficheReponse.setText(String.valueOf(x));
                   }
                   else if(Rmm1.isChecked())
                   {
                       x=x*100;
                       afficheReponse.setText(String.valueOf(x));
                   }
                   else if(RM1.isChecked())
                   {
                       x=x*0.1;
                       afficheReponse.setText(String.valueOf(x));
                   }

               }
               if(Rmm.isChecked())
               {
                   if(Rmm1.isChecked())
                   {
                       x=x;
                       afficheReponse.setText(String.valueOf(x));
                   }
                   if(Rdm1.isChecked())
                   {
                       x=x*0.1;
                               afficheReponse.setText(String.valueOf(x));
                   }
                   if(Rcm1.isChecked())
                   {
                       x=x*0.01;
                       afficheReponse.setText(String.valueOf(x));
                   }
                   if(RM1.isChecked())
                   {
                       x=x/1000;
                       afficheReponse.setText(String.valueOf(x));
                   }

               }
            }

        }
    });

    }
}