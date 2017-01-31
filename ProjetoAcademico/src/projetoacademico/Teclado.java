package projetoacademico;

import java.util.Scanner;

/**
 * Classe utilitária para ler dados do teclado em um programa de linha de comando
 * 
 * @author prof. Paulo e prof. Julio
 */
public class Teclado {

    // Objeto Scanner utlizado para a leitura
    private static final Scanner scanner = new Scanner(System.in);

    /**
     * Obtém um número inteiro digitado pelo usuário (exiba a mensagem passada)
     * 
     * @param msg Mensagem a ser exibida ao pedir um número inteiro para o 
     *            usuário (nula caso não tenha mensagem)
     * @return Retorna o inteiro lido do usuário.
     */
    public static int lerInteiro(String msg) {

        if (msg != null)
            System.out.print(msg);

        int retorno = scanner.nextInt();

        // Limpa o buffer de entrada
        scanner.nextLine();

        return retorno;
    }
    
    /**
     * Obtém um string digitada pelo usuário (exibe a mensagem passada)
     * 
     * @param msg Mensagem a ser exibida ao pedir um número inteiro para o 
     *            usuário (nula caso não tenha mensagem)
     * @return Retorna a string lida do usuário.
     */
    public static String lerString(String msg) {
        if (msg != null)
            System.out.print(msg);

        return scanner.nextLine();
    }

    /**
     * Obtém um número real digitado pelo usuário (exiba a mensagem passada)
     * 
     * @param msg Mensagem a ser exibida ao pedir um número inteiro para o 
     *            usuário (nula caso não tenha mensagem)
     * @return Retorna o número real lido do usuário.
     */
    public static double lerDouble(String msg) {
        System.out.print(msg);

        double retorno = scanner.nextDouble();

        // Limpa o buffer de entrada
        scanner.nextLine();

        return retorno;
    }
}
