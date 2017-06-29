/**
 * Classe para representar Contas de Poupança.
 * 
 * Uma conta poupança possui uma taxa de rendimento e um método para aplicação
 * do rendimento.
 * 
 * @author julio
 */
public class ContaPoupanca extends Conta {
    // taxa de rendimento da poupança
    double taxaRendimento;

    /**
     * Cria uma conta de poupança com um número e uma taxa de rendimento.
     * 
     * @param numero Número de identificação da poupança.
     * @param taxaRendimento Taxa de rendimento da poupança.
     */
    public ContaPoupanca(int numero, double taxaRendimento) {
        super(numero);
        this.taxaRendimento = taxaRendimento;
    }

    /**
     * Aplica a taxa de rendimento ao saldo atual da poupança
     */
    public void render() {
        // deposita na própria conta o valor do rendimento
        depositar(getSaldo()*taxaRendimento);
    }

    /**
     * Retorna a taxa de rendimento da poupança.
     * 
     * @return A taxa de rendimento.
     */
    public double getTaxaRendimento() {
        return taxaRendimento;
    }
}