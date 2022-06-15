package br.feevale.myapplication;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class Calculos implements Serializable {

    private String expressao;
    private List<Calculos> calculosList = new ArrayList<>();

    public List<Calculos> getCalculosList() {

        return calculosList;
    }

    public void setCalculosList(List<Calculos> calculosList) {

        this.calculosList = calculosList;
    }

    public String getExpressao() {
        return expressao;
    }

    public void setExpressao(String expressao) {

        this.expressao = expressao;
    }
}
