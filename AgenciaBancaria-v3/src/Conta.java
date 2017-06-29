/**
 * Representa uma conta bancária.
 * 
 * Uma conta bancária possui um número de identificação e um saldo. E possui
 * operações para consultar esses valores e fazer saques, depósitos e 
 * transferências.
 * 
 * @author julio
 */
public class Conta {
    // Um conta possui um número e um saldo
    private int numero;	
    private double saldo;	
    
    /**
     * Cria uma conta com um saldo inicial
     * 
     * @param numero Número da conta a ser criada
     * @param saldoInicial Saldo inicial da conta
     */
    Conta(int numero, double saldoInicial) {
        this.numero = numero;
        saldo = saldoInicial;
    }
    
    /**
     * Cria um aconta com saldo zerado.
     * 
     * @param numero Número da conta a ser criada.
     */
    Conta(int numero) {
        this(numero, 0.0);
    }


    /**
     * Retorna o saldo da conta.
     * 
     * @return Saldo da conta
     */
    public double getSaldo() {
        return saldo;
    }

    /**
     * Retorna o número que identufica a conta
     * 
     * @return Número da conta
     */
    public int getNumero() {
        return numero;
    }

    /**
     * Deposita um valor na conta.
     * 
     * @param valor Valor a ser depositado.
     */
    public void depositar(double valor) {
        saldo += valor;
    }

    /**
     * Saca um valor da conta (se ela tiver saldo suficiente)
     * 
     * @param valor Valor a ser sacado.
     * @return Retorna se o saque foi efetivamente realizado.
     */
    public boolean sacar(double valor) {
        // se a conta tem saldo suficiente, faz o saque
        if (saldo >= valor) {
            saldo -= valor;
            return true;
        }
        else
            return false;		
    }

    /**
     * Transfere um valor da conta para uma outra conta.
     * 
     * @param contaDestino Conta para o qual o valor será transferido
     * @param valor Valor a ser transferido para a outra conta.
     * @return Retorna se a transferência foi efetivamente ralizada.
     */
    public boolean transferir(Conta contaDestino, double valor) {
        // tenta sacar o valor da conta; se for possível deposita na de destino
        if (sacar(valor)) {
            contaDestino.depositar(valor);
            return true;
        }
        else
            return false;
    }
    
    /**
     * Retorna um extrato da conta (número e saldo).
     * 
     * @return O extrato da conta no formato Conta NNN - saldo: R$ NNNN)
     */
    public String extrato() {
        return "Conta " + numero + " - saldo: R$ " + saldo;
    }
}