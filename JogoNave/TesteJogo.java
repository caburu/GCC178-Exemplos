/**
 * Classe que executa o Jogo
 * 
 * @author Julio Cesar Alves
 * @version 2016-09-16
 */
public class TesteJogo {        
    public static void main(String[] args) {
        Nave nave = new Nave();
        Inimigo inimigo = new Inimigo();
        Placar placar = new Placar();                
        Cenario cenario = new Cenario(nave, inimigo, placar);
        
        cenario.executarLoopDeJogo();
    }
}
