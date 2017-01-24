import java.util.*;

/**
 * Programa que fornece uma interface para a Rede Social, dando acesso as acoes
 * disponiveis no Feed de Noticias
 * 
 * @author Julio Cesar Alves
 * @version 2016-10-26
 */
public class Programa {
    // Objeto do feed de noticias
    private static FeedNoticias feed;

    /**
     * Metodo que inicia a aplicacao, tratando o ciclo do menu.
     * 
     * @param args Parametos do programa (nao utilizado)
     */
    public static void main(String[] args) {
        feed = new FeedNoticias();
        Scanner entrada = new Scanner(System.in);

        int opcao;
        do
        {
            exibirMenu();
            opcao = entrada.nextInt();
            tratarOpcaoMenu(opcao);			
        } while (opcao != 4);		
    }

    /**
     * Exibe o menu na saida padrao
     */
    private static void exibirMenu() {
        System.out.println("\nREDE SOCIAL ");
        System.out.println("1 - Exibir o Feed de Noticias");
        System.out.println("2 - Postar mensagem de texto");
        System.out.println("3 - Postar mensagem com foto");
        System.out.println("4 - Sair\n");
        System.out.print("Digite sua opcao: ");
    }

    /**
     * Trata a opcao de menu passada
     * 
     * @param opcao Opcao de menu a ser tratada
     */
    private static void tratarOpcaoMenu(int opcao) {
        switch (opcao) {
            case 1:
                feed.exibir();
                break;
            case 2:
                postarTexto();				
                break;
            case 3:
                postarFoto();
                break;
            case 4:
                System.out.println("\nObrigado!\n");
                break;
            default:
                System.out.println("\nOpcao Invalida!\n");
                break;
        }
    }

    /**
     * Trata a opcao de postar uma mensagem de texto. Pede ao usuario o autor e
     * o texto da mensagem e a adiciona no feed de noticias.
     */
    private static void postarTexto() {
        String autor, mensagem;
        Scanner entrada = new Scanner(System.in);

        System.out.println("Digite o autor:");
        autor = entrada.nextLine();

        System.out.println("Digite a mensagem de texto:");
        mensagem = entrada.nextLine();

        feed.postarMensagemTexto(autor, mensagem);
    }

    /**
     * Trata a opcao de postar uma mensagem com foto. Pede ao usuario o autor, o
     * o nome do arquivo da foto e a legen da da foto e adiciona a mensagem no 
     * feed de noticias.
     */
    private static void postarFoto() {
        String autor, foto, legenda;
        Scanner entrada = new Scanner(System.in);

        System.out.println("Digite o autor:");
        autor = entrada.nextLine();

        System.out.println("Digite o nome do arquivo da foto:");
        foto = entrada.nextLine();

        System.out.println("Digite a legenda da foto:");
        legenda = entrada.nextLine();

        feed.postarMensagemFoto(autor, foto, legenda);
    }
}
