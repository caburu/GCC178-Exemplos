/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threadscorredores;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author julio
 */
public class ThreadsCorredores {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        List<Corredor> corredores = new ArrayList<>();
        Random random = new Random();
        
        System.out.println("Digite o número de corredores: ");
        int nroCorredores = entrada.nextInt();
        
        System.out.println("Digite a distância da corrida: ");
        int distancia = entrada.nextInt();
        
        for (int i = 0; i < nroCorredores; i++) {
            String nome = "" + i;
            corredores.add(new Corredor(nome, random.nextInt(9)+1, distancia));
        }
        
        for (Corredor corredor : corredores) {
            Thread t = new Thread(corredor);
            t.start();
        }
        
        try {
            
            boolean temAlguemCorrendo = true;
            
            while (temAlguemCorrendo) {            
                temAlguemCorrendo = false;
                System.out.println();
                for (Corredor corredor : corredores) {
                    String texto = "Corredor " + corredor.obterNome() + ": " +
                            new String(new char[corredor.obterPosicaoAtual()]).replace("\0", "*");
                    System.out.println(texto);
                    if (!corredor.terminouCorrida()) {
                        temAlguemCorrendo = true;
                    }
                }                
                Thread.sleep(50);
            }
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
    
}
