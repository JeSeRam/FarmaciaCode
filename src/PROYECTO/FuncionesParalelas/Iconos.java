/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PROYECTO.FuncionesParalelas;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author Freak
 */
public class Iconos {
    public static ImageIcon Icono;
    public static String getRutaIconoCorrecto(){
        return "/Content/Imagenes/Correcto.png";
    }
    public static String getRutaIconoIncorrecto(){
        return "/Content/Imagenes/Incorrecto.png";
    }
    public static ImageIcon ColocaIcono(String Ruta,int Ancho, int Largo,int Alineado){
        Icono = new ImageIcon(new Object(){}.getClass().getResource(Ruta));
        Image Imagen = Icono.getImage();
        Image ImagenXY = Imagen.getScaledInstance(Ancho, Largo, Alineado);
        ImageIcon IconoF = new ImageIcon(ImagenXY);
        return IconoF;
    }
}
