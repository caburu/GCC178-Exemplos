/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fabricaautomoveis.carros;

/**
 * Enumerador para representar as possíveis categorias de carros
 * 
 * @author julio
 */
public enum Categoria {
    
    POPULAR(1), 
    PICKUP(2), 
    LUXO(3);
    
    private int id;
    
    private Categoria(int id) {
        this.id = id;
    }
    
    public static Categoria peloID(int id) {
        for (Categoria c : Categoria.values()) {
            if (c.id == id) {
                return c;
            }
        }
        throw new RuntimeException("Não existe categoria de id " + id);
    }
}
