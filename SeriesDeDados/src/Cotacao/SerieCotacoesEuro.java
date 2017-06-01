/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cotacao;

/**
 *
 * @author julio
 */
public class SerieCotacoesEuro extends SerieCotacoes {

    public SerieCotacoesEuro(String localidade, int diaInicial, int diaFinal) {
        super(localidade, diaInicial, diaFinal);
    }

    @Override
    public String obterIdentificacaoSerie() {
        return "Cotações do euro - " + getLocalidade();
    }
    
}
