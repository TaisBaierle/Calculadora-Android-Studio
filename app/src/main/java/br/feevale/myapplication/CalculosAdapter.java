package br.feevale.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class CalculosAdapter extends BaseAdapter {
    LayoutInflater inflater;
    List<Calculos> calculos;

    public CalculosAdapter(List<Calculos> calculos, Context ctx){
       this.calculos = calculos;
       inflater = LayoutInflater.from(ctx);
    }
    @Override
    public int getCount() {
        return calculos.size();
    }

    @Override
    public Object getItem(int i) {
        return calculos.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = inflater.inflate(R.layout.calculo_item, null);
        TextView tvCalculo = v.findViewById(R.id.tvNomeItem);
        Calculos c = calculos.get(i);
        tvCalculo.setText(c.getExpressao());
        return v;
    }
}
