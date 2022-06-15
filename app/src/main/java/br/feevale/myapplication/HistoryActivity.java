package br.feevale.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class HistoryActivity extends AppCompatActivity {

    private Button btBack;
    private Boolean excluirUltimo;
    private ListView listCalculo;
    private List<Calculos> calculosList = new ArrayList<>();
    private Calculos calculo;
    private CalculosAdapter calculosAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        listCalculo = findViewById(R.id.listCalculos);
        calculo = (Calculos) getIntent().getSerializableExtra("calculos");
        excluirUltimo = getIntent().getBooleanExtra("limparUltimo", false);
        calculosList = calculo.getCalculosList();

        if (excluirUltimo && calculosList.size() > 0){
            calculosList.remove(calculosList.size() - 1);
        }
        calculosAdapter = new CalculosAdapter(calculosList , getBaseContext());
        listCalculo.setAdapter(calculosAdapter);
        calculosAdapter.notifyDataSetChanged();

        btBack = findViewById(R.id.btBack);

    }

    public void retornarTelaAnterior(View view) {
        finish();
    }

     @Override
    public void onBackPressed(){
      //para não permitir a volta com a seta
    }



}

