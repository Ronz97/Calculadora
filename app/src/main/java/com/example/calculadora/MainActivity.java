package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button numero0,numero1,numero2,numero3,numero4,numero5,numero6,numero7,numero8,numero9;
    private Button ponto,soma,multiplicacao,subtracao,divisao,igual,botao_limpar;
    private TextView txtExpressao,txtResultado;
    private ImageView backspace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        IniciarComponetes();
        getSupportActionBar().hide();

        numero0.setOnClickListener(this);
        numero1.setOnClickListener(this);
        numero2.setOnClickListener(this);
        numero3.setOnClickListener(this);
        numero4.setOnClickListener(this);
        numero5.setOnClickListener(this);
        numero6.setOnClickListener(this);
        numero7.setOnClickListener(this);
        numero8.setOnClickListener(this);
        numero9.setOnClickListener(this);
        ponto.setOnClickListener(this);
        soma.setOnClickListener(this);
        subtracao.setOnClickListener(this);
        multiplicacao.setOnClickListener(this);

        botao_limpar.setOnClickListener(new View.OnClickListener() { // LIMPAR A TELA
            @Override
            public void onClick(View v) {
                txtExpressao.setText("");
                txtResultado.setText("");
            }
        });

        backspace.setOnClickListener(new View.OnClickListener() {// para apagar var por var
            @Override
            public void onClick(View v) {
                TextView expressao = findViewById(R.id.txt_expressao);
                String string = expressao.getText().toString();
                if(!string.isEmpty()){
                    byte var0=0;
                    int var1 = string.length()-1;
                    String txtExpressao = string.substring(var0,var1);
                    expressao.setText(txtExpressao);

                }
                txtResultado.setText("");

            }
        });

    }
    private void IniciarComponetes(){ // Atribuir valores as IDs
        numero0 = findViewById(R.id.nmb_0);
        numero1 = findViewById(R.id.nmb_1);
        numero2 = findViewById(R.id.nmb_2);
        numero3 = findViewById(R.id.nmb_3);
        numero4 = findViewById(R.id.nmb_4);
        numero5 = findViewById(R.id.nmb_5);
        numero6 = findViewById(R.id.nmb_6);
        numero7 = findViewById(R.id.nmb_7);
        numero8 = findViewById(R.id.nmb_8);
        numero9 = findViewById(R.id.nmb_9);
        ponto = findViewById(R.id.ponto);
        soma = findViewById(R.id.soma);
        multiplicacao = findViewById(R.id.multiplicacao);
        divisao = findViewById(R.id.divisao);
        subtracao = findViewById(R.id.subtracao);
        igual = findViewById(R.id.igual);
        botao_limpar = findViewById(R.id.bt_limpar);
        txtExpressao = findViewById(R.id.txt_expressao);
        txtResultado = findViewById(R.id.txt_resultado);
        backspace = findViewById(R.id.backspace);


    }
    public void AcrescentarUmaExpressao(String string,boolean limpar_dados){
        if(txtResultado.getText().equals("")){
            txtExpressao.setText("");

        }
        if(limpar_dados){
            txtResultado.setText("");
            txtExpressao.append(string);
        }else {
            txtExpressao.append(txtResultado.getText());
            txtExpressao.append(string);
            txtResultado.setText("");
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.nmb_0:
                AcrescentarUmaExpressao("0",true);
                break;
            case R.id.nmb_1:
                AcrescentarUmaExpressao("1",true);
                break;
            case R.id.nmb_2:
                AcrescentarUmaExpressao("2",true);
                break;
            case R.id.nmb_3:
                AcrescentarUmaExpressao("3",true);
                break;
            case R.id.nmb_4:
                AcrescentarUmaExpressao("4",true);
                break;
            case R.id.nmb_5:
                AcrescentarUmaExpressao("5",true);
                break;
            case R.id.nmb_6:
                AcrescentarUmaExpressao("6",true);
                break;
            case R.id.nmb_7:
                AcrescentarUmaExpressao("7",true);
                break;
            case R.id.nmb_8:
                AcrescentarUmaExpressao("8",true);
                break;
            case R.id.nmb_9:
                AcrescentarUmaExpressao("9",true);
                break;
            case R.id.ponto:
                AcrescentarUmaExpressao(".",true);
                break;
            case R.id.soma:
                AcrescentarUmaExpressao("+",false);
                break;
            case R.id.multiplicacao:
                AcrescentarUmaExpressao("*",false);
                break;
            case R.id.subtracao:
                AcrescentarUmaExpressao("-",false);
                break;
            case R.id.divisao:
                AcrescentarUmaExpressao("/",false);
                break;

        }
    }
}