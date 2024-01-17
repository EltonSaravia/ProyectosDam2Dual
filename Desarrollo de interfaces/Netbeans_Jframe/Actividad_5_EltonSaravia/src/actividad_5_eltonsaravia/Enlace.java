/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package actividad_5_eltonsaravia;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import javax.swing.*;

/**
 *
 * @author alumno
 */
public class Enlace extends JLabel implements Serializable{
    
    private String navegador;
    private String url;
    
    public Enlace(){
        
    }

    public String getNavegador() {
        return navegador;
    }

    public void setNavegador(String navegador) {
        this.navegador = navegador;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    
   /* private void btn_StartActionPerformed(java.awt.event.ActionEvent evt)    
    {
      String[] command ={"CMD", "/C", "MyCmdCommand"};
      ProcessBuilder probuilder = new ProcessBuilder( command );
      probuilder.directory(new File(dri+":\\"));   

      try 
      {
            Process process = probuilder.start();
            process.waitFor();
      }

      catch(IOException e)
      {
            JOptionPane.showMessageDialog(this, e);
      }*/
   // }
    
}


