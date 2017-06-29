
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author julio
 */
public class InterfaceAgencia {
    private Agencia agencia;
    private Scanner entrada;

    public InterfaceAgencia(String nomeAgencia) {
        agencia = new Agencia(nomeAgencia);
        entrada = new Scanner(System.in);
    }
    
    public void exibir() {        
        
        int opcao;
        do {
            opcao = exibirMenu();
            tratarOpcaoMenu(opcao);
        } while (opcao != 6);
    }

    private int exibirMenu() {
        System.out.println("Bem-vindo à agência " + agencia.getNome() + "!\n");
        System.out.println(
                "1 - Criar conta\n" +
                "2 - Relatório\n" +
                "3 - Depósito\n" +
                "4 - Saque\n" +
                "5 - Transferência\n" +
                "6 - Sair\n" );
        System.out.print("Digite sua opcao: ");
        return entrada.nextInt();
    }

    private void tratarOpcaoMenu(int opcao) {
        System.out.println();
        switch (opcao) {
            case 1:
                    criarConta();
                    break;
            case 2:
                    exibirRelatorio();				
                    break;
            case 3:
                    fazerDeposito();
                    break;
            case 4:
                    fazerSaque();
                    break;
            case 5:
                    fazerTransferencia();
                    break;
            case 6:
                    System.out.println("\nObrigado por usar os servicos da Agencia " 
                            + agencia.getNome() + "!\n");
                    break;
            default:
                    System.out.println("\nOpcao invalida!\n");
                    break;
        }
    }

    private void criarConta() {
        try {
            int nroConta = agencia.criarConta();
            System.out.println("Conta " + nroConta + " criada!");
        }
        catch (Exception e) {
                System.out.println(e.getMessage());
        }

        aguardarEnter();
    }

    private void exibirRelatorio() {
        System.out.println(agencia.gerarRelatorio());
        
        aguardarEnter();
    }

    private int pedirConta() {
        System.out.print("Digite o numero da conta: ");
        return entrada.nextInt();
    }

    private void aguardarEnter() {
        System.out.print("\n... pressione ENTER para continuar...");

        try {
                System.in.read();
        } 
        catch (Exception e){			
        }

        System.out.println("\n");
    }

    private double pedirValor() {
        System.out.print("Digite o valor: ");
        return entrada.nextDouble();
    }

    private void fazerDeposito() {		
        try {
            agencia.depositar(pedirConta(), pedirValor());
            System.out.println("Deposito realizado com sucesso!");
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        aguardarEnter();
    }

    private void fazerSaque() {	
        if (agencia.sacar(pedirConta(), pedirValor())) {
            System.out.println("Saque realizado com sucesso!");
        }
        else {
            System.out.println("Não foi possível sacar!");
        }

        aguardarEnter();
    }

    private void fazerTransferencia() {	
        if (agencia.transferir(pedirConta(), pedirConta(), pedirValor())) {	            
            System.out.println("Transferencia realizada com sucesso!");		
        }
        else {
            System.out.println("Não foi possível transferir!");
        }

        aguardarEnter();
    }
}
