/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adapter;

/**
 *
 * @author Paulo
 */
public class Discente extends Pessoa {
    private DiscenteDeOutroProjeto discente;
    public Discente(String nome, String matricula) {
        super(nome);
        this.discente = new DiscenteDeOutroProjeto(nome, matricula);
    }
    public String getMatricula() { return discente.getMatricula(); }
    @Override
    public void imprimir() {
        System.out.println(super.getNome() + " (Discente) - " + this.getMatricula());        
    }    
}
