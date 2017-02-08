package exemplo_jdbc_sqlite;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;

/**
 * Classe para demonstrar a utilização do JDBC para conectar a um banco de dados.
 * Está sendo utilizado o banco de dados SQLite.
 * 
 * Download do drive JDBC para SQLite: http://bitbucket.org/xerial/sqlite-jdbc/downloads
 *
 * @author julio
 */
public class TesteBD {
    // Atributo que guarda o nome do banco de dados a ser criado
    private final String nomeBD = "bd_teste.db";    

    /**
     * Método interno (privado) para fazer a conexão com o banco de dados.
     * 
     * @return Retorna a conexão que permite acessar o banco de dados.
     */
    private Connection conectar() {
        // A conexão com o banco é feita através de uma "String de Conexão". Ela
        // tem o formato: "jdbc:tipo_de_banco:nome_do_banco". No caso estamos
        // usando um banco do SQLite e o nome está guardado no atributo nomeBD.
        // Para se conectar em um banco de tipo diferente bastaria usar a String
        // de conexão apropriada
        String strConexao = "jdbc:sqlite:" + nomeBD;

        try {
            // A clases DriverManager possui um método estático getConnection que
            // retorna a conexão com o banco a partir da String de conexão
            Connection conexao = DriverManager.getConnection(strConexao);
            return conexao;
        }
        catch (Exception e) {
            // Obs: para manter o foco no que está sendo aprendido, o tratamento
            //      de exceção está apenas exibindo a mensagem de erro. Em uma
            //      aplicação normal deveria ser feito o tratamento adequando.
            //      Esse comentário vale para todos os tratamentos da classe.
            System.out.println("Erro ao tentar abrir conexao: " + e.getMessage());
            return null;
        }
    }

    /**
     * Método que cria as tabelas do nosso banco de dados. Em uma aplicação
     * normal, o banco de dados não é criado pelo programa que o usuário utilizará.
     * Geralmente ele é criado durante a instalação do programa, uma vez que ele
     * deve ser criado uma única vez.
     */
    public void criarTabelas() {
        // Obtém a conexão com o banco de dados
        Connection conexao = conectar();

        // Se conseguiu conectar
        if (conexao != null) {
            try {
                // cria um objeto que permitirá executar um comando no banco de dados
                Statement comando = conexao.createStatement();
                
                // Monta uma string com o comando SQL para criar a tabela ANIMAL
                // que guardará os dados dos animais.
                //
                // Campos String são criados com o tipo CHAR(tamanho), inteiros
                // com o tipo INT e float ou double com o tipo REAL. O 'NOT NULL'
                // indica que a coluna não pode ser vazia na tabela (tem que ter
                // algum valor).
                String sql = "CREATE TABLE ANIMAL " +
                             "(NOME     CHAR(50)    NOT NULL, " +
                             " ESPECIE	CHAR(50)    NOT NULL, " +
                             " IDADE	INT         NOT NULL, " +
                             " PESO	REAL        NOT NULL);";

                // executa o comando SQL
                comando.executeUpdate(sql);

                // ATENÇÃO: é muito importante fechar o comando e a conexão com
                // o banco de dados para liberar os recursos e acessos.
                comando.close();
                conexao.close();
            }				
            catch (Exception e) {
                System.out.println(e.getMessage());
            }		
        }		
    }

    public void inserirAnimal(Animal animal) {
        // Obtém a conexão com o banco de dados
        Connection conexao = conectar();

        // Se conseguiu conectar
        if (conexao != null) {
            try {
                // cria um objeto que permitirá executar um comando no banco de dados
                Statement comando = conexao.createStatement();
                
                // Monta uma string com o comando SQL para inserir um animal na
                // tabela ANIMAL. Os dados devem ser fornecidos na mesma ordem
                // que as colunas foram listadas.
                //
                // ATENÇÃO: dentro da String SQL os campos que são string precisam
                // estar entre aspas simples.
                String sql = "INSERT INTO ANIMAL(NOME, ESPECIE, IDADE, PESO) " +
                             "VALUES ('" + animal.getNome() + "', '" + animal.getEspecie() +
                             "', " + animal.getIdade() + ", " + animal.getPeso() + ");"; 

                // executa o comando SQL
                comando.executeUpdate(sql);

                // ATENÇÃO: é muito importante fechar o comando e a conexão com
                // o banco de dados para liberar os recursos e acessos.
                comando.close();
                conexao.close();
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public List<Animal> buscarAnimais() {
        // Obtém a conexão com o banco de dados
        Connection conexao = conectar();

        // Se conseguiu conectar
        if (conexao != null) {
            try {
                // cria um objeto que permitirá executar um comando no banco de dados
                Statement comando = conexao.createStatement();
                
                // Monta uma string com o comando SQL para buscar os dados dos
                // animais na tabela ANIMAL
                String sql = "SELECT * FROM ANIMAL;";

                // Repare que para buscar os dados usamos um outro método: o
                // executeQuery. Ele retorna os resultados em um objeto do tipo
                // ResultSet que pode ser percorrido para se obter os dados de
                // cada linha da tabela
                ResultSet resultado = comando.executeQuery(sql);

                // Criamos uma lista a ser preenchida com os animais buscados no
                // no banco.
                List<Animal> animais = new ArrayList<>();

                // O método next() faz o 'cursor" do ResultSet apontar cada hora
                // para uma linha da tabela. Enquanto existirem linhas ele muda
                // o cursor e retorna true.
                while (resultado.next()) {                    
                    // Pegamos então os dados de uma linha da tabela especificando
                    // o nome da coluna a qual queremos os dados. Para obtermos
                    // os dados de acordo com o tipo desejado usamos os gets
                    // apropriados (getString, getInt, etc.)
                    String nome = resultado.getString("NOME");
                    String especie = resultado.getString("ESPECIE");
                    int idade = resultado.getInt("IDADE");
                    double peso = resultado.getDouble("PESO");
                    
                    // Agora que já temos os dados podemos criar um objeto da
                    // classe Animal e adicioná-lo à lista a ser retornada
                    Animal animal = new Animal(nome, especie, idade, peso);
                    animais.add(animal);					
                }
                
                // ATENÇÃO: é muito importante fechar o comando e a conexão com
                // o banco de dados para liberar os recursos e acessos. Nesse
                // caso precisamos fechar também o ResultSet.
                resultado.close();
                comando.close();
                conexao.close();

                // Enfim, retornamos os animais que foram buscados do banco de
                // dados
                return animais;
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return null;
    }

    public void modificarAnimal(String nomeAtual, Animal animal) {
        // Obtém a conexão com o banco de dados
        Connection conexao = conectar();

        // Se conseguiu conectar
        if (conexao != null) {
            try {
                // cria um objeto que permitirá executar um comando no banco de dados
                Statement comando = conexao.createStatement();
                
                // Monta uma string com o comando SQL para alterar os dados de 
                // um animal na tabela ANIMAL.
                // O comando WHERE é usado para indicar qual(is) linha(s) será(ão)
                // alterada(s). Serão alteradas todas as linhas que casarem com
                // a condição colocada.
                //
                // ATENÇÃO 1: se você esquer do WHERE o comando atualizará todas 
                // as linhas da tabela.
                // ATENÇÃO: dentro da String SQL os campos que são string precisam
                // estar entre aspas simples.
                String sql = "UPDATE ANIMAL SET " +
                                         " NOME = '" + animal.getNome() + "', " +
                                         " ESPECIE = '" + animal.getEspecie() + "', " +
                                         " IDADE = " + animal.getIdade() + ", " +
                                         " PESO = " + animal.getPeso() + " " + 
                                         "WHERE NOME = '" + nomeAtual + "';";

                // executa o comando SQL
                comando.executeUpdate(sql);

                // ATENÇÃO: é muito importante fechar o comando e a conexão com
                // o banco de dados para liberar os recursos e acessos.
                comando.close();
                conexao.close();
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }		
    }

    public void apagarAnimal(Animal animal) {
        // Obtém a conexão com o banco de dados
        Connection conexao = conectar();

        // Se conseguiu conectar
        if (conexao != null) {
            try {
                // cria um objeto que permitirá executar um comando no banco de dados
                Statement comando = conexao.createStatement();
                
                // Monta uma string com o comando SQL para apagar um animal da
                // tabela ANIMAL.
                // O comando WHERE é usado para indicar qual(is) linha(s) será(ão)
                // apagada(s). Serão apagadas todas as linhas que casarem com
                // a condição colocada.
                //
                // ATENÇÃO 1: se você esquer do WHERE o comando apagará todas as
                // linhas da tabela.
                // ATENÇÃO 2: dentro da String SQL os campos que são string precisam
                // estar entre aspas simples.                
                String sql = "DELETE FROM ANIMAL " +
                                         "WHERE NOME = '" + animal.getNome() + "';";

                // executa o comando SQL
                comando.executeUpdate(sql);

                // ATENÇÃO: é muito importante fechar o comando e a conexão com
                // o banco de dados para liberar os recursos e acessos.
                comando.close();
                conexao.close();
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
