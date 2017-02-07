package exemplo_jdbc_sqlite;

/**
 * Classe que representa um Animal. Um animal possui nome, espécie, idade e peso
 * (em quilos). Com exceção da espécie os demais dados podem ser alterados.
 * 
 * Classe simples apenas para demonstrar a utilização de Banco de Dados.
 * 
 * @author julio
 */
public class Animal {
	private String nome;
	private String especie;
	private int idade;
	private double peso;

        /**
         * Cria um animal a partir de suas características.
         * 
         * @param nome Nome do animal
         * @param especie Espécie do animal
         * @param idade Idade do animal (em anos)
         * @param peso Peso do animal (em quilos)
         */
	public Animal(String nome, String especie, int idade, double peso) {
		this.nome = nome;
		this.especie = especie;
		this.idade = idade;
		this.peso = peso;
	}
	
        /**
         * Retorna o nome do animal.
         * 
         * @return O nome do animal
         */
	public String getNome() {
		return nome;
	}
	
        /**
         * Altera o nome do animal.
         * 
         * @param nome Novo nome do animal.
         */
	public void setNome(String nome) {
		this.nome = nome;
	}
	
        /**
         * Retorna a espécie do animal.
         * 
         * @return A espécie do animal.
         */
	public String getEspecie() {
		return especie;
	}
	
        /**
         * Retorna a idade do animal.
         * 
         * @return A idade do animal.
         */
	public int getIdade() {
		return idade;
	}
	
        /**
         * Altera a idade do animal.
         * 
         * @param idade Nova idade do animal (em anos).
         */
	public void setIdade(int idade) {
		this.idade = idade;
	}
	
        /**
         * Retorna o peso do animal.
         * 
         * @return O peso do animal (em quilos).
         */
	public double getPeso() {
		return peso;
	}
	
        /**
         * Altera o peso do animal.
         * 
         * @param peso Novo peso do animal (em quilos).
         */
	public void setPeso(double peso) {
		this.peso = peso;
	}
	
        /**
         * Retorna a representação do animal como String. Monta uma frase com
         * os dados do animal.
         * 
         * @return Representação do animal como String.
         */
	@Override
	public String toString() {
		return nome + " eh um " + especie + " que tem " + 
                       idade + " anos e pesa " + peso + " quilos";
	}
}
