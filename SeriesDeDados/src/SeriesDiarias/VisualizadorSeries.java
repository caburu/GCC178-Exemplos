/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SeriesDiarias;

import SeriesDiarias.SerieDadosDiarios;
import java.awt.Dimension;
import java.util.List;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;


/**
 * Tela para visualização de uma Série de Dados Diários.
 * 
 * Para usar a classe crie o visualizador passando a série a ser exibida e, em
 * seguida, chame o método exibir.
 * 
 * Usa a biblioteca JFreeChart para exibir um gráfico de linha mostrando os dados
 * da série. Obs: a janela é posicionada aleatoriamente na tela.
 * 
 * @author julio
 */
public class VisualizadorSeries {
    // Janela que contém o gráfico
    private ApplicationFrame janela;
    
    /**
     * Constrói a visualização dos dados. Cria a janela e o gráfico a ser exibido
     * nela.
     * 
     * @param serieDados A série de dados que terá seus dados exibidos em um gráfico
     */
    public VisualizadorSeries(SerieDadosDiarios serieDados) {
        // cria a janela
        janela = new ApplicationFrame("Visualizador Series Diarias");
        janela.setDefaultCloseOperation(ApplicationFrame.EXIT_ON_CLOSE);
        
        // cria o gráfico que contém os dados da série
        JFreeChart graficoLinha = ChartFactory.createLineChart(
                serieDados.obterIdentificacaoSerie(), // Título do gráfico
                "Dia",    // Nome do eixo X
                "Valor",  // Nome do eixo Y
                criarDataset(serieDados), // método que cria os dados do gráfico
                PlotOrientation.VERTICAL, // Orientação do gráfico
                true,true,false); // legenda, tooltips, urls
        
        // adiciona o gráfico na janela
        ChartPanel painelGrafico = new ChartPanel(graficoLinha);
        painelGrafico.setPreferredSize(new Dimension(600, 400));        
        janela.setContentPane(painelGrafico);      
        janela.pack( );
        
        // posiciona a janela aleatoriamente na tela
        RefineryUtilities.positionFrameRandomly(janela);
    }
    
    /**
     * Exibe a janela com o gráfico
     */
    public void exibir() {
        janela.setVisible(true);
    }

    
    /**
     * Método interno que cria o conjunto de dados do gráfico
     * 
     * @param serieDados Série de dados que terá o gráfico exibido.
     * @return Retorna o conjunto de dados (dataset) do gráfico.
     */
    private DefaultCategoryDataset criarDataset(SerieDadosDiarios serieDados) {
       DefaultCategoryDataset dataset = new DefaultCategoryDataset();
            
       // para cada dia do gráfico adiciona um valor no conjunto de dados       
       for(int dia = serieDados.obterDiaInicial(); dia <= serieDados.obterDiaFinal(); dia++) {      
         
           dataset.addValue(
                   serieDados.obterDado(dia), 
                   serieDados.obterIdentificacaoSerie(),
                   Integer.toString(dia));
       }
      
       return dataset;
    }
}
