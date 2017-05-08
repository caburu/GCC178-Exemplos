/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adapter;

/**
 *
 * @author Paulo
 */
public class Tecnico extends Pessoa {
    private String codigo;
    
    public Tecnico(String nome, String codigo) { 
        super(nome);
        this.codigo = codigo;
    }
    public String getCodigo() { return this.codigo; }
    
    @Override
    public void imprimir() {
        System.out.println(super.getNome() + 
                " (Técnico) - " + this.getCodigo());
    }
    
}
