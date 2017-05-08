package br.ufla.dcc.ppoo.temcafe.sensor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * Esta classe simula o funcionamento de sensor colocado na garrafa de café. Seu
 * objetivo é disponibilizar e atualizar um arquivo de texto contendo o 
 * volume atual da garrafa de café.
 *
 * @author Profs. Júlio César e Paulo Afonso
 */
public class SensorGarrafaCafe {

    /**
     * Constante pública que representa o nome do arquivo onde o volume da
     * garrafa de café será disponibilizado.
     */
    public static String NOME_ARQ = "sensor-garrafa.txt";

    /**
     * Constante pública que representa o volume da garrafa (em ml)
     * quando a mesma está completamente cheia.
     */
    public static int VOL_GARRAFA_CHEIA = 1000;
    
    /**
     * Constante pública que representa o volume da garrafa (em ml)
     * quando a mesma está completamente vazia.
     */
    public static int VOL_GARRAFA_VAZIA = 0;
    
    /**
     * Constante pública que representa o volume (em ml) de um 
     * café simples.
     */
    public static int VOL_CAFE_SIMPLES = 100;
    
    /**
     * Constante pública que representa o volume (em ml) de um 
     * café duplo.
     */
    public static int VOL_CAFE_DUPLO = 200;

    private static SensorGarrafaCafe instancia;
    
    /**
     * Esse método estático garante que haverá apenas uma instância
     * da classe SensorGarrafa em todo programa.
     * @return A única instância do sensor da garrafa de café.
     */
    public static SensorGarrafaCafe obterInstancia() {
        if (instancia == null) {
            instancia = new SensorGarrafaCafe();
        }
        return instancia;
    }
    
    private SensorGarrafaCafe(int volume) {
        atualizarVolume(volume);
    }
    
    private SensorGarrafaCafe() {
        this(VOL_GARRAFA_CHEIA);
    }
    
    /**
     * Atualiza o volume atual da garrafa de café, descontando do mesmo, 
     * o volume de um café simples (definido pela constante  {@link GarrafaDeCafe#VOL_CAFE_SIMPLES}). 
     * Caso o valor do novo volume seja menor do que volume mínimo permitido
     * o volume será atualizado para o volume de uma garrafa de café vazia 
     * (definido pela constante  {@link GarrafaDeCafe#VOL_GARRAFA_VAZIA}).
     */
    public void tomarCafeSimples() {
        int volume = obterVolume();
        if (volume - VOL_CAFE_SIMPLES < VOL_GARRAFA_VAZIA) {
            atualizarVolume(VOL_GARRAFA_VAZIA);
        } else {
            atualizarVolume(volume - VOL_CAFE_SIMPLES);
        }
    }
    
    /**
     * Atualiza o volume atual da garrafa de café, descontando do mesmo, 
     * o volume de um café duplo (definido pela constante  {@link GarrafaDeCafe#VOL_CAFE_DUPLO}). 
     * Caso o valor do novo volume seja menor do que volume mínimo permitido
     * o volume será atualizado para o volume de uma garrafa de café vazia 
     * (definido pela constante  {@link GarrafaDeCafe#VOL_GARRAFA_VAZIA}).
     */
    public void tomarCafeDuplo() {
        int volume = obterVolume();
        if (volume - VOL_CAFE_DUPLO < VOL_GARRAFA_VAZIA) {
            atualizarVolume(VOL_GARRAFA_VAZIA);
        } else {
            atualizarVolume(volume - VOL_CAFE_DUPLO);
        }
    }
    
    /**
     * Atualiza o volume atual da garrafa de café para o volume
     * de uma garrafa de café cheia (definido pela constante 
     * {@link GarrafaDeCafe#VOL_GARRAFA_CHEIA}).
     */
    public void encherGarrafa() {
        atualizarVolume(VOL_GARRAFA_CHEIA);
    }
    
    /**
     * Escreve o volume da garrafa de café no arquivo
     * {@link SensorGarrafaCafe#NOME_ARQ}.
     *
     * @param volume Volume a ser escrito no arquivo {@link SensorGarrafaCafe#NOME_ARQ}..
     */
    private void atualizarVolume(int volume) {
        try {
            FileWriter fw = new FileWriter(NOME_ARQ);
            fw.write(String.valueOf(volume));
            fw.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * Lê o volume disponibilizado no arquivo de texto {@link SensorGarrafaCafe#NOME_ARQ} e retorna.
     * @return O volume atual disponibilizado no arquivo de texto {@link SensorGarrafaCafe#NOME_ARQ} ou
     * -1, caso algum erro de leitura do arquivo aconteça.
     */
    public int obterVolume() {
        int volume = -1;
        try {
            BufferedReader br = 
                    new BufferedReader(new FileReader(NOME_ARQ));
            volume = Integer.parseInt(br.readLine());
            br.close();
            return volume;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return volume;
        }
    }
}
