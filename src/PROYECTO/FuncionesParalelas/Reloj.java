/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PROYECTO.FuncionesParalelas;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JLabel;

/**
 *
 * @author Freak
 * @version Beta
 */
public class Reloj extends Thread{
    // <editor-fold defaultstate="collapsed" desc="Constructor">
    public Reloj (JLabel Reloj){
        this.Reloj=Reloj;
    }// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="clase Run">
    public void run(){
        while(true){
            Date date=new Date();
            SimpleDateFormat sdf=new SimpleDateFormat("hh:mm:ss");
            Reloj.setText(sdf.format(date));
            try{
                this.sleep(1000);
            }catch(Exception ex){}
        }
    }// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Declaracion de variables">
    private final JLabel Reloj;
    // </editor-fold>
}
