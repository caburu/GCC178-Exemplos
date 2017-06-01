package SeriesDiarias;

import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Interface para controladores de Séries de Dados.
 * Define uma interface para que possam ser buscadas/consultadas séries de dados.
 * 
 * @author julio
 */
public interface ControladorSeries {
    /**
     * Retorna uma lista de séries de dados.
     * 
     * @return A lista de séries de dados.
     */
    List<SerieDadosDiarios> obterSeriesDados();
}
