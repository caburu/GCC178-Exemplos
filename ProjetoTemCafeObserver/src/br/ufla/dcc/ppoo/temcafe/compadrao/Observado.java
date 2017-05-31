package br.ufla.dcc.ppoo.temcafe.compadrao;

public interface Observado {
    public void adicionarObservador(Observador obs);
    public void notificarObservadores();
}
