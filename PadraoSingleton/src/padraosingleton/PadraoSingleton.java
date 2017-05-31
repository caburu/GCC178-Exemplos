/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package padraosingleton;

/**
 *
 * @author Paulo Júnior
 */
public class PadraoSingleton {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Configuracao conf = Configuracao.getInstancia();
        Configuracao conf1 = Configuracao.getInstancia();
        
        // Testa se conf e conf1 são a mesma instância.
        // O resultado esperado é que sim, pois o padrão
        // Singleton garante isso.
        if (conf == conf1) System.out.println("Deu certo!");
        else System.out.println("Deu errado!");
    }
    
}
