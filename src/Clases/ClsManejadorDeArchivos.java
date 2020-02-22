/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.List;
/**
 *
 * @author yanki
 */
public class ClsManejadorDeArchivos {
    public static boolean ExisteArchivo(String Ruta){
        try{
            File Archivo = new File(Ruta);
            if(!Archivo.exists()){
                return false;
            }
        }catch(Exception e){
            return false;
        }
        return true;
    }
    public static String LeerArchivo(String Ruta,boolean SaltoDeLinea){
        String TextoDeArchivo = "";
        try{
            BufferedReader bf = new BufferedReader(new FileReader(Ruta));
            String Temp = "";
            String bfLee;
            while((bfLee = bf.readLine()) != null){
                Temp = Temp + bfLee + (SaltoDeLinea ? "\n" : "");
            }
            bf.close();
            TextoDeArchivo = Temp;
        }catch(Exception e){
            return "";
        }
        return TextoDeArchivo;
    }
    public static boolean EscribirArchivo(String Ruta,List<String> Registros){
        boolean estatus = true;
        try {
            FileWriter fichero = new FileWriter(Ruta);
            PrintWriter pw = new PrintWriter(fichero);
            if (!Registros.isEmpty()){
                for (String Registro: Registros){
                    pw.println(Registro);
                }
                fichero.close();
            } else {
                estatus = false;
            }
        } catch (Exception e) {
            estatus = false;
        }
        return estatus;
    }
}
