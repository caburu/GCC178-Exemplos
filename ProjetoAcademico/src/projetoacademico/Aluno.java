package projetoacademico;

import java.io.Serializable;

/**
 * Classe que representa um aluno. Aluno possui matrícula, nome e nota.
 * 
 * @author prof. Paulo e prof. Julio
 */
public class Aluno implements Serializable {
    private int matricula;
    private String nome;
    private double nota;

    /**
     * Constrói um aluno a partir de sua matrícula, nome e nota.
     * 
     * @param matricula Matrícula do aluno
     * @param nome Nome do aluno
     * @param nota Nota do aluno
     */
    public Aluno(int matricula, String nome, double nota) {
        this.matricula = matricula;
        this.nome = nome;
        this.nota = nota;
    }

    /**
     * Retorna a matrícula do aluno.
     * 
     * @return A matrícula do aluno.
     */
    public int getMatricula() {
        return matricula;
    }
    
    /**
     * Retorna o nome do aluno.
     * 
     * @return O nome do aluno.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Retorna a nota do aluno.
     * 
     * @return A nota do aluno.
     */
    public double getNota() {
        return nota;
    }
    
    
}
