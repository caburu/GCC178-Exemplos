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
 *
 * @author julio
 */
public class Concessionaria {
    
    private String nome;
    private List<Carro> carros;
    private Marca marcaFranquia;
    
    public Concessionaria(String nome, Marca marca) {
        this.nome = nome;        
        this.marcaFranquia = marca;
        carros = new ArrayList<>();
    }
    
    public String getNome() {
        return nome;
    }
    
    public Marca getMarcaFranquia() {
        return marcaFranquia;
    }
    
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
