
import Clima.ControladorDadosClima;
import SeriesDiarias.VisualizadorSeries;
import SeriesDiarias.ControladorSeries;
import SeriesDiarias.SerieDadosDiarios;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author julio
 */
public class Programa {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ControladorSeries controladorClima = new ControladorDadosClima();
        
        List<SerieDadosDiarios> series = controladorClima.obterSeriesDados();
        
        for (SerieDadosDiarios serie : series) {
            System.out.println(serie.obterIdentificacaoSerie());
            for (int i = serie.obterDiaInicial(); i <= serie.obterDiaFinal(); i++) {
                System.out.println("Dia " + i + ": " + serie.obterDado(i));
            }
            System.out.println();
        }
        
        for (SerieDadosDiarios serie : series) {
            VisualizadorSeries visualizador = new VisualizadorSeries(serie);
            visualizador.exibir();
        }
    }
    
}
