/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Concessionaria;

import fabricaautomoveis.carros.Carro;
import fabricaautomoveis.carros.Categoria;
import fabricaautomoveis.carros.Freemont;
import fabricaautomoveis.carros.Gol;
import fabricaautomoveis.carros.Marca;
import fabricaautomoveis.carros.Strada;
import fabricaautomoveis.carros.Uno;
import java.util.ArrayList;
import java.util.List;

/**
 * Representa uma concessionária que vende carros de uma determinada Marca.
 * 
 * @author julio
 */
public class Concessionaria {
    // Nome da concessionária
    private String nome;
    // Carros da concessionária
    private List<Carro> carros;
    // Marca da qual a concessionária vende os carros
    private Marca marcaFranquia;
    
    /**
     * Uma concessionária é construída com um nome e uma Marca da qual vende carros
     * @param nome O nome da concessionária.
     * @param marca A marca da qual a concessionária vende os carros
     */
    public Concessionaria(String nome, Marca marca) {
        this.nome = nome;        
        this.marcaFranquia = marca;
        carros = new ArrayList<>();
    }
    
    /**
     * Retorna o nome da concessionária
     * 
     * @return O nome da concessionária
     */
    public String getNome() {
        return nome;
    }
    
    /**
     * Retorna a Marca da qual a concessionária vende os carros.
     * 
     * @return A marca dos carros
     */
    public Marca getMarcaFranquia() {
        return marcaFranquia;
    }
    
    /**
     * Realiza a compra de um carro de uma determinada categoria e com uma cor
     * @param categoria Categoria do carro a ser comprado.
     * @param cor Cor do carro a ser comprado
     * 
     * @return Verdadeiro se o carro pode ser comprado (modelo disponível)
     */
    public boolean comprarCarro(Categoria categoria, String cor) {
        Carro carro = null;
        
        if (marcaFranquia == Marca.VW && categoria == Categoria.POPULAR) {
            carro = new Gol(cor);
        }
        else if (marcaFranquia == Marca.FIAT && categoria == Categoria.POPULAR) {
            carro = new Uno(cor);
        }
        else if (marcaFranquia == Marca.FIAT && categoria == Categoria.PICKUP) {
            carro = new Strada(cor);
        }
        else if (marcaFranquia == Marca.FIAT && categoria == Categoria.LUXO) {
            carro = new Freemont(cor);
        }
        
        if (carro != null) {
            carro.produzir();
            carro.pintar();
            carro.liberarDocumentacao();
            carros.add(carro);
            return true;
        }
        else {
            System.out.println("Não há modelos disponíveis para essa categoria");
            return false;
        }
    }
}
