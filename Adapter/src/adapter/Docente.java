/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adapter;

/**
 *
 * @author Paulo
 */
public class Docente extends Pessoa {
    private String SIAPE;
    
    public Docente(String nome, String SIAPE) { 
        super(nome);
        this.SIAPE = SIAPE;
    }
    public String getSIAPE() { return this.SIAPE; }
    
    @Override
    public void imprimir() {
        System.out.println(super.getNome() + 
                " (Docente) - " + this.getSIAPE());
    }
    
}
