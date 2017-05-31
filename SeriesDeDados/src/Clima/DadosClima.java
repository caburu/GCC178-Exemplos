/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clima;

import SeriesDiarias.SerieDadosDiarios;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author julio
 */
public abstract class DadosClima implements SerieDadosDiarios {
    
    private int diaInicial;
    private int diaFinal;
    private Map<Integer, Integer> dados;
    private String cidade;
    
    public DadosClima(String cidade, int diaInicial, int diaFinal) {
        this.cidade = cidade;
        dados = new HashMap<>();
        
        for (int i = diaInicial; i <= diaFinal; i++) {
            dados.put(i, 0);
        }
    }
    
    @Override
    public int obterDiaInicial() {
        return diaInicial;
    }
    
    @Override
    public int obterDiaFinal() {
        return diaFinal;
    }
    
    @Override
    public int obterDado(int dia) {
        if (dia >= diaInicial && dia <= diaFinal) {
            return dados.get(dia);
        }
        else {
            System.out.println("Erro: dia " + dia + " inválido!");
            return -1;
        }
    }
    
    public String getCidade() {
        return cidade;
    }
    
    public void adicionarDado(int dia, int valor) {
        dados.put(dia, valor);
    }
}
