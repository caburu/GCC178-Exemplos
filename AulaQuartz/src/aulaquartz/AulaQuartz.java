/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aulaquartz;

import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

/**
 *
 * @author Julio
 */
public class AulaQuartz {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Scheduler agendador = StdSchedulerFactory.getDefaultScheduler();            
            
            JobDetail tarefa = JobBuilder.newJob(LeitorArquivo.class)
                    .withIdentity("Tarefa", "Grupo")
                    .build();
            
            Trigger disparador = TriggerBuilder.newTrigger()
                    .withIdentity("Disparador", "Grupo")
                    .startNow()
                    .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                        .withIntervalInSeconds(10)
                        .repeatForever())
                    .build();
            
            agendador.scheduleJob(tarefa, disparador);
            agendador.start();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }
    
}
