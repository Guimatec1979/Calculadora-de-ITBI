package com.guimatec.itbi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    Button btnCalcular, btnLimpar;
    TextView txtValor;
    EditText editvalorTransacao, editvalorVenal, editpercentualImpostos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editpercentualImpostos  = findViewById(R.id.editpercentualImpostos);
        editvalorVenal = findViewById(R.id.editvalorVenal);
        editvalorTransacao = findViewById(R.id.editvalorTransacao);
        txtValor = findViewById(R.id.txtValor);

        btnCalcular = findViewById(R.id.btnCalcular);
        btnLimpar = findViewById(R.id.btnLimpar);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                float vl_transacao, vl_venal, valorImposto, pct_imposto;

                vl_transacao = Float.parseFloat(editvalorTransacao.getText().toString());
                vl_venal = Float.parseFloat(editvalorVenal.getText().toString());

                pct_imposto = Integer.parseInt(editpercentualImpostos.getText().toString());


                if (vl_transacao >= vl_venal){

                    valorImposto = vl_transacao * pct_imposto / 100;

                } else {
                    valorImposto = vl_venal * pct_imposto / 100;
                }

                txtValor.setText("R$ " + valorImposto);


            }
        });

        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editpercentualImpostos.setText("");
                editvalorVenal.setText("");
                editvalorTransacao.setText("");
                txtValor.setText("");
            }
        });


    }
}
