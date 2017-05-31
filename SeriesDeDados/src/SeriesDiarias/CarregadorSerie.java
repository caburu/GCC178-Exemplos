package SeriesDiarias;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Interface para carregadores de Séries de Dados. Define uma interface para
 * que uma série de dados seja carregada e possa ser utilizada.
 * 
 * @author julio
 */
public interface CarregadorSerie {
    /**
     * Carrega uma série de dados diários e a retorna.
     * 
     * @return A série de dados carregada.
     */
    SerieDadosDiarios carregarSerie(); 
}
