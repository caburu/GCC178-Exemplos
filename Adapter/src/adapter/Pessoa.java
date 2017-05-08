/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adapter;

/**
 *
 * @author Paulo
 */
public abstract class Pessoa {
    private String nome;
    
    public Pessoa(String nome) { this.nome = nome; }
    public String getNome() { return this.nome; }
    public abstract void imprimir();    
}
