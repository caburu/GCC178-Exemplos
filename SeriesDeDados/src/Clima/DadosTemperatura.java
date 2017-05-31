/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clima;

/**
 *
 * @author julio
 */
public class DadosTemperatura extends DadosClima {

    public DadosTemperatura(String cidade, int diaInicial, int diaFinal) {
        super(cidade, diaInicial, diaFinal);
    }

    @Override
    public String obterIdentificacaoSerie() {
        return "Dados de Temperatura de " + getCidade();
    }
    
    
}
