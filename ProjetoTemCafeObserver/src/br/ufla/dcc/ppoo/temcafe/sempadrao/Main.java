package br.ufla.dcc.ppoo.temcafe.sempadrao;


public class Main {

    public static void main(String args[]) {
        TelaMonitorGarrafaCafe monitor = new TelaMonitorGarrafaCafe();
        TelaCopa copa = new TelaCopa(monitor);
        copa.exibir();
        monitor.exibir();
    }

}
