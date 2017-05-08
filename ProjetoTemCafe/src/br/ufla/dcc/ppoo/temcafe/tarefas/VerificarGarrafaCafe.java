package br.ufla.dcc.ppoo.temcafe.tarefas;

import br.ufla.dcc.ppoo.temcafe.gui.TelaMonitorGarrafaCafe;
import br.ufla.dcc.ppoo.temcafe.sensor.SensorGarrafaCafe;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;


public class VerificarGarrafaCafe implements Job {

    private SensorGarrafaCafe sensorGarrafaCafe;
    private TelaMonitorGarrafaCafe monitorGarrafaCafe;

    public VerificarGarrafaCafe() {
        sensorGarrafaCafe = SensorGarrafaCafe.obterInstancia();
        monitorGarrafaCafe = TelaMonitorGarrafaCafe.obterInstancia();
    }

    @Override
    public void execute(JobExecutionContext jec) throws JobExecutionException {
        monitorGarrafaCafe.alterarSituacaoGarrafa(sensorGarrafaCafe.obterVolume());

        monitorGarrafaCafe.alterarUltimaAtualizacao(
                new SimpleDateFormat("HH:mm:ss").
                format(Calendar.getInstance().getTime()));
    }

}
