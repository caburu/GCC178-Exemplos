/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exemplo_jdbc_sqlite;

import java.util.List;

/**
 * Classe que executa o programa.
 * 
 * ATENÇÃO: leia o arquivo "Instrucoes.txt"
 * 
 * @author julio
 */
public class Programa {
	
    /**
     * Método que inicia o programa.
     * 
     * @param args Os parâmetros de linha de comando
     */
    public static void main(String[] args) {
	
        List<Animal> animais;

        System.out.println("\nCriando o Banco de Dados...");
        TesteBD testeBD = new TesteBD();

        System.out.println("\nCriando as tabelas do banco...");
        testeBD.criarTabelas();

        Animal cachorro = new Animal("Rex", "Cachorro", 5, 20);
        Animal gato = new Animal("Bichano", "Gato", 8, 6);

        System.out.println("\nInserindo animais no banco...");
        testeBD.inserirAnimal(cachorro);
        testeBD.inserirAnimal(gato);

        System.out.println("\nBuscando animais do banco...");
        animais = testeBD.buscarAnimais();

        for (Animal animal : animais) {
                System.out.println(animal);
        }		

        Animal a1 = animais.get(0);
        System.out.println("\nAlterando nome e idade do " + a1.getNome() + "...");

        String nomeAtual = a1.getNome();
        a1.setNome("Mano");
        a1.setIdade(6);

        testeBD.modificarAnimal(nomeAtual, a1);

        System.out.println("Buscando animais do banco...");
        animais = testeBD.buscarAnimais();

        for (Animal animal : animais) {
                System.out.println(animal);
        }

        Animal a2 = animais.get(1);
        System.out.println("\nApagando "+ a2.getNome() + "...");		

        testeBD.apagarAnimal(a2);

        System.out.println("Buscando animais do banco...");
        animais = testeBD.buscarAnimais();

        for (Animal animal : animais) {
                System.out.println(animal);
        }
    }
}