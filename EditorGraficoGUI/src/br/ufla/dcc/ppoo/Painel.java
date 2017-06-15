package br.ufla.dcc.ppoo;

import java.util.ArrayList;
import java.util.List;

public class Painel {

    private List<FormaGeometrica> objetos;

    public Painel() {
        objetos = new ArrayList<FormaGeometrica>();
    }

    public void adicionarElemento(FormaGeometrica obj) {
        objetos.add(obj);
    }

    public void exibirObjetos() {
        for (FormaGeometrica obj : objetos) {
            obj.exibir();            
        }
    }
    
    public double calcularAreaTotal() {
        double soma = 0.0;
        for (FormaGeometrica obj : objetos) {
            soma += obj.obterArea();
        }
        return soma;
    }
}
