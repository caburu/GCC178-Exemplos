package aulaquartz;


import java.io.BufferedReader;
import java.io.FileReader;
import javax.swing.JOptionPane;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Julio
 */
public class LeitorArquivo implements Job {

    @Override
    public void execute(JobExecutionContext jec) throws JobExecutionException {
        try {
            BufferedReader arquivo = new BufferedReader(new FileReader("teste.txt"));
            String linha = arquivo.readLine();
            JOptionPane.showMessageDialog(null, linha);
            arquivo.close();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
}
