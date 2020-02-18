/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author Freak
 */
public class ClsControlVersion {
    public static String NombreVersion(){
        return "Beta";
    }
    public static long VersionFuerte(){
        return 1;
    }
    public static long VersionMedia(){
        return 0;
    }
    public static long VersionBaja(){
        return 0;
    }
    public static long Compilado(){
        return 0;
    }
    public static String Descripcion(){
        return "Desarrollo";
    }
    public static String Version(){
        return String.format("%1$s v%2$s.%3$s.%4$s.%5$s - %6$s", NombreVersion(),VersionFuerte(),VersionMedia(),VersionBaja(),Compilado(),Descripcion());
    }
}
