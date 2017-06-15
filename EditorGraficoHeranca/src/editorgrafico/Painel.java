package editorgrafico;

import editorgrafico.FormaGeometrica;
import java.util.ArrayList;
import java.util.List;

public class Painel {

    private List<ObjetoDesenhavel> fObjetos;

    public Painel() {
        fObjetos = new ArrayList<ObjetoDesenhavel>();
    }

    public void adicionarElemento(ObjetoDesenhavel obj) {
        fObjetos.add(obj);
    }

    public void exibirObjetos() {
        for (ObjetoDesenhavel obj : fObjetos) {
            obj.exibir();            
        }
    }
    
    public double calcularAreaTotal() {
        double soma = 0.0;
        for (ObjetoDesenhavel obj : fObjetos) {
            soma += obj.obterArea();
        }
        return soma;
    }
}
