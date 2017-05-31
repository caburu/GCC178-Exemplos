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
public class Configuracao {

    private static Configuracao instancia = null;

    public static Configuracao getInstancia() {
        if (instancia == null) {
            instancia = new Configuracao();
        }
        return instancia;
    }

    private Configuracao() {
        // lê as configurações do sistema.
    }
}
