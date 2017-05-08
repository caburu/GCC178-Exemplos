/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adapter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Paulo
 */
public class GerenciadorPessoas {
    private List<Pessoa> pessoas;
    public GerenciadorPessoas() {
        pessoas = new ArrayList<>();
    }
    public void cadastrarPessoa(Pessoa p) { this.pessoas.add(p); }
    public void gerarRelatorio() {
        for(Pessoa p: pessoas) {
            p.imprimir();
        }
    }
}
