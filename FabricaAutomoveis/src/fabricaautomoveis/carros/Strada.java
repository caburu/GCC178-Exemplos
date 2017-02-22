/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fabricaautomoveis.carros;

/**
 *
 * @author julio
 */
public class Strada extends Carro {
    
    public Strada(String cor) {
        super("Strada", Marca.FIAT, cor, 35000, Categoria.PICKUP);
    }
    
}
