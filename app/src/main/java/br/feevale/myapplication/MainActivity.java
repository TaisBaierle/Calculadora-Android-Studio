package br.feevale.myapplication;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private Button history, clear;
    private TextView tvVisorCalculos;

    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;
    private Button btn5;
    private Button btn6;
    private Button btn7;
    private Button btn8;
    private Button btn9;
    private Button btZero;
    private Button btPonto;

    private Button btsoma;
    private Button btmult;
    private Button btsub;
    private Button btdiv;
    private Button btigual;

    private List<Calculos> calculosList = new ArrayList<>();
    private Boolean excluirUltimo;
    private Intent intent;
    private String expressaoMatematica;

    View.OnClickListener btNumeros = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            inserirNumeroVisor(v);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.excluirUltimo = false;
        this.intent = new Intent(this, HistoryActivity.class);
        inicializarComponentes();
    }

    public void abrirTelaHistory(View view) {
        Calculos c = new Calculos();
        c.setCalculosList(this.calculosList);
        intent.putExtra("calculos", c);
        intent.putExtra("limparUltimo", this.excluirUltimo);
        startActivity(intent);
    }

    public void inserirNumeroVisor(View view) {
        Button botao = (Button) view;
        tvVisorCalculos.setText(tvVisorCalculos.getText() + botao.getText().toString());
    }

    public void limparTela(View view) {

        tvVisorCalculos.setText("");
        excluirUltimo = true;
    }

    public void calcular(View view) {
        String calculoFinal = "";
        Calculos calculo;
        try {
            calculo = new Calculos();
            expressaoMatematica = tvVisorCalculos.getText().toString();
            Expression expressao = new ExpressionBuilder(tvVisorCalculos.getText().toString()).build();
            double resultado = expressao.evaluate();
            double resto = resultado - Math.floor(resultado);

            tvVisorCalculos.setText("");

            if (resto != 0f) {
                tvVisorCalculos.setText(String.valueOf(resultado));
            }else{
                tvVisorCalculos.setText(String.valueOf((int)resultado));
            }
            for(char c : expressaoMatematica.toCharArray()){
                if ((String.valueOf(c).equals(".")) || (Character.isDigit(c))){
                    calculoFinal = calculoFinal + c;
                }else {
                    calculoFinal = calculoFinal + " " + c + " ";
                }
            }
            calculo.setExpressao(calculoFinal +" = " + resultado);
            calculosList.add(calculo);
        } catch (Exception e) {
            Toast.makeText(getBaseContext(), "Não foi possível fazer o cálculo", Toast.LENGTH_LONG).show();
        }
    }

    public void inicializarComponentes() {
        history = findViewById(R.id.btHistory);
        clear = findViewById(R.id.btClear);
        tvVisorCalculos = findViewById(R.id.tvVisorCalculos);

        //Mapeeamento dos componentes
        btn1 = findViewById(R.id.btUm);
        btn2 = findViewById(R.id.btDois);
        btn3 = findViewById(R.id.btTres);
        btn4 = findViewById(R.id.btQuatro);
        btn5 = findViewById(R.id.btCinco);
        btn6 = findViewById(R.id.btSeis);
        btn7 = findViewById(R.id.btSete);
        btn8 = findViewById(R.id.btOito);
        btn9 = findViewById(R.id.btNove);
        btZero = findViewById(R.id.btZero);

        btsoma = findViewById(R.id.btSoma);
        btmult = findViewById(R.id.btMult);
        btsub = findViewById(R.id.btMenos);
        btdiv = findViewById(R.id.btDivisao);
        btigual = findViewById(R.id.btIgual);
        btPonto = findViewById(R.id.btPonto);

        //Vinculo com o evento
        btn1.setOnClickListener(btNumeros);
        btn2.setOnClickListener(btNumeros);
        btn3.setOnClickListener(btNumeros);
        btn4.setOnClickListener(btNumeros);
        btn5.setOnClickListener(btNumeros);
        btn6.setOnClickListener(btNumeros);
        btn7.setOnClickListener(btNumeros);
        btn8.setOnClickListener(btNumeros);
        btn9.setOnClickListener(btNumeros);
        btZero.setOnClickListener(btNumeros);

        btsoma.setOnClickListener(btNumeros);
        btmult.setOnClickListener(btNumeros);
        btsub.setOnClickListener(btNumeros);
        btdiv.setOnClickListener(btNumeros);
        btPonto.setOnClickListener(btNumeros);
    }

}