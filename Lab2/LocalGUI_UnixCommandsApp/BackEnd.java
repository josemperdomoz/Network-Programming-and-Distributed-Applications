/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2_netprog;



import javax.swing.JOptionPane;
import java.io.BufferedReader;
//import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.util.*;

/**
 *
 * @author Usuario
 */
public class BackEnd implements Runnable 
{
    public String input;
    public javax.swing.JTextArea outputField;
    public boolean isClicked;
        
        public BackEnd(String inputString, javax.swing.JTextArea outputField, boolean isClicked)
        {
        this.input = inputString;
        this.outputField = outputField;
        this.isClicked = isClicked;
        }
    
        public void run() 
        {
        if(this.isClicked)
        {
            try
            {
                int numberOfIterations = Integer.parseInt(this.input);
                int iteration = 1;
                String output ="";
                while( iteration <= numberOfIterations )
                {   
                    output = output + iteration + "\n";
                    iteration++;
                }
                this.outputField.setText(output + numberOfIterations + " iterations completed." );
                //this.outputField.setText(this.numberOfIterations + " iterations completed.");
            }
            catch(Exception e)
            {
                System.out.println(e.toString());
            }
        }
        else
        {
            executeCommand();
            return;
        }
        }
        
        public void executeCommand(){
            
            String command = this.input;
            
            
            String line;
            String result ="";
            try
            {   
                Process p = null;
                ProcessBuilder builder;
                
                String bashDir = "C:\\Users\\Usuarios\\bin\\sh";
                String shell2 = "/mnt/c/Users/Usuarios/bin/sh";
                //String bashShell = new String(shell + " -c ");
                //String[] commands = {"sh", "-c", command};
                
                
                
                
                
                // Executing command
                builder = new ProcessBuilder("bash", "-c" , command);
                //builder.directory(new File("C:\\Users\\Usuarios\\home\\jperdomo"));
                builder.redirectErrorStream(true);
                p = builder.start();
                
                //   /mnt/c/Users/Usuarios/home/jperdomo
                //   /bin/bash
                // Reading Input 
                BufferedReader r = new BufferedReader( new InputStreamReader(p.getInputStream()));
                // (line = r.readLine()) != null
                while(true)
                {   
                    line = r.readLine();
                    if( line == null)
                    {
                        break;
                    }
                    result = result + line + "\n";
                    this.outputField.setText(result);
                    if(this.isClicked)
                    {
                        result="";
                        r.close();
                        break;
                    }
                    
                    
                }
                
                this.outputField.setText(result);
            } 
            catch(Exception e)
            {
                this.outputField.setText(e.toString());
            }
            
            
        }      
} 









        

