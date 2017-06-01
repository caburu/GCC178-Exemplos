/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cotacao;

import SeriesDiarias.ControladorSeries;
import SeriesDiarias.SerieDadosDiarios;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author julio
 */
public class ControladorSeriesCotacoes implements ControladorSeries {
    private List<SerieDadosDiarios> series;
    
    public ControladorSeriesCotacoes() {
        series = new ArrayList<>();
        
        SerieCotacoes cotacoesDolarBrasil = new SerieCotacoesDolar("Brasil", 2, 5);
        cotacoesDolarBrasil.adicionarCotacao(2, 2);
        cotacoesDolarBrasil.adicionarCotacao(3, 3);
        cotacoesDolarBrasil.adicionarCotacao(4, 2);
        cotacoesDolarBrasil.adicionarCotacao(5, 2);
        
        SerieCotacoes cotacoesEuroBrasil = new SerieCotacoesEuro("Brasil", 2, 5);
        cotacoesEuroBrasil.adicionarCotacao(2, 3);
        cotacoesEuroBrasil.adicionarCotacao(3, 4);
        cotacoesEuroBrasil.adicionarCotacao(4, 4);
        cotacoesEuroBrasil.adicionarCotacao(5, 3);
        
        series.add(cotacoesEuroBrasil);
        series.add(cotacoesDolarBrasil);
    }

    @Override
    public List<SerieDadosDiarios> obterSeriesDados() {
        return series;
    }
    
}
