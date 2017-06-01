/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cotacao;

import SeriesDiarias.SerieDadosDiarios;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author julio
 */
public abstract class SerieCotacoes implements SerieDadosDiarios {
    private int diaInicial;
    private int diaFinal;
    private String localidade;
    private Map<Integer, Integer> dadosCotacoes;
    
    public SerieCotacoes(String localidade, int diaInicial, int diaFinal) {
        this.diaInicial = diaInicial;
        this.diaFinal = diaFinal;
        this.localidade = localidade;
        
        dadosCotacoes = new HashMap<>();
        
        for (int i = diaInicial; i < diaFinal; i++) {
            dadosCotacoes.put(i, 0);
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
        return dadosCotacoes.get(dia);
    }
    
    public String getLocalidade() {
        return localidade;
    }
    
    public void adicionarCotacao(int dia, int cotacao) {
        dadosCotacoes.put(dia, cotacao);
    }
}
