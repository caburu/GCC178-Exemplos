package projetoacademico;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Classe que trata a interface de usuário e realiza as ações do sistema
 * 
 * @author prof. Paulo e prof. Julio
 */
public class ProjetoAcademico {

    // Lista de alunos cadastrados
    private List<Aluno> alunos = new ArrayList<Aluno>();
    
    // Nome do arquivo onde são guardados os dados dos alunos
    private final String nomeArquivo = "alunos.dat";

    private int exibirMenu() {
        System.out.println("\n1. Cadastrar aluno\n" +
                           "2. Remove aluno\n" +
                           "3. Exibir relatório\n" +
                           "4. Sair");
        System.out.print("Escolha a opção desejada: ");
        return Teclado.lerInteiro(null);
    }

    private void carregarDados() {
        try {
            File f = new File(nomeArquivo);
            if (f.exists()) {
                ObjectInputStream ois
                        = new ObjectInputStream(new FileInputStream(f));
                alunos = (ArrayList<Aluno>) ois.readObject();
                ois.close();
            } else {
                alunos = new ArrayList<Aluno>();
            }
        } catch (Exception ex) {
            Logger.getLogger(ProjetoAcademico.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void salvarDados() {
        try {
            ObjectOutputStream oos
                    = new ObjectOutputStream(new FileOutputStream(nomeArquivo));
            oos.writeObject(alunos);
            oos.close();
        } catch (Exception ex) {
            Logger.getLogger(ProjetoAcademico.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void cadastrarAluno() {
        int mat = Teclado.lerInteiro("Informe a matrícula do aluno: ");
        String nome = Teclado.lerString("Informe o nome do aluno: ");
        double nota = Teclado.lerDouble("Informe a nota do aluno: ");

        alunos.add(new Aluno(mat, nome, nota));
    }

    private void removerAluno() {
        int mat = Teclado.lerInteiro("Informe a matrícula do aluno: ");

        boolean removeu = false;
        Iterator<Aluno> iterador = alunos.iterator();        
        while (iterador.hasNext() && !removeu) {
            Aluno aluno = iterador.next();
            
            if (aluno.getMatricula() == mat) {
                iterador.remove();
                removeu = true;
            }
        }
        
        if (!removeu) {
            System.out.println("Matricula " + mat + " não encontrada!");
        }
    }

    private void exibirRelatorio() {
        for (Aluno a : alunos) {
            System.out.printf("%-6d%-15s%-4.2f\n",
                    a.getMatricula(), a.getNome(), a.getNota());
        }
    }

    private void iniciar() {
        int op;
        carregarDados();
        do {
            op = exibirMenu();
            switch (op) {
                case 1:
                    cadastrarAluno();
                    break;
                case 2:
                    removerAluno();
                    break;
                case 3:
                    exibirRelatorio();
                    break;
                case 4:
                    salvarDados();
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente...");
            }
        } while (op != 4);
    }

    /**
     * Classe principal que inicia a aplicação
     * 
     * @param args Argumentos do programa (não utilizado atualmente)
     */
    public static void main(String[] args) {
        new ProjetoAcademico().iniciar();
    }

}
