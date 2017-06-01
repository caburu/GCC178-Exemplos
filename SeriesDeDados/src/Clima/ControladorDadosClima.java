/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clima;

import SeriesDiarias.SerieDadosDiarios;
import SeriesDiarias.ControladorSeries;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author julio
 */
public class ControladorDadosClima implements ControladorSeries {
    private List<DadosClima> seriesDadosClima;
    
    public ControladorDadosClima() {
        seriesDadosClima = new ArrayList<>();
        
        DadosClima serieChuva = new DadosChuva("Lavras", 1, 5);
        serieChuva.adicionarDado(1, 0);
        serieChuva.adicionarDado(2, 20);
        serieChuva.adicionarDado(3, 40);
        serieChuva.adicionarDado(4, 90);
        serieChuva.adicionarDado(5, 80);
        
        seriesDadosClima.add(serieChuva);
        
        DadosClima serieTemperatura = new DadosTemperatura("Lavras", 1, 5);
        serieTemperatura.adicionarDado(1, 20);
        serieTemperatura.adicionarDado(2, 19);
        serieTemperatura.adicionarDado(3, 22);
        serieTemperatura.adicionarDado(4, 23);
        serieTemperatura.adicionarDado(5, 21);
        
        seriesDadosClima.add(serieTemperatura);
    }

    @Override
    public List<SerieDadosDiarios> obterSeriesDados() {
        return Collections.unmodifiableList(seriesDadosClima);
    }
}
