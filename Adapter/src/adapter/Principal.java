/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adapter;

/**
 *
 * @author Paulo
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GerenciadorPessoas ger = new GerenciadorPessoas();
        Docente dc1 = new Docente("Paulo", "999");
        Docente dc2 = new Docente("José", "998");
        Tecnico tc1 = new Tecnico("Pedro", "997");
        Discente di1 = new Discente("Maria", "996");
        ger.cadastrarPessoa(dc1); ger.cadastrarPessoa(dc2);
        ger.cadastrarPessoa(tc1); ger.cadastrarPessoa(di1);
        ger.gerarRelatorio();
    }
}
