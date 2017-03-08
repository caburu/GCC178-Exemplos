/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telaExemplo;

import apiTemperatuta.ControladorTemperatura;
import java.util.Scanner;

/**
 *
 * @author julio
 */
public class Programa {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {                                
        ControladorTemperatura contTemp = new ControladorTemperatura();
        
        TelaMonitoramentoSimples telaMS = new TelaMonitoramentoSimples(contTemp);                              
        
        contTemp.definirTela(telaMS);
        
        telaMS.exibir();
    }
}
