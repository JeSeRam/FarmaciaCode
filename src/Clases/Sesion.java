/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import ConexionMySql.ClsConexionMySql;
import ConexionMySql.ClsResultSet;
import Entidades.ClsAsignaPerfil;
import Entidades.ClsPantallaPerfil;
import Entidades.ClsUsuario;
import Interfaces.CveEstatus;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Freak
 */
public class Sesion {
    private static long _NumeroDeUsuario;
    private static String _NombreDeUsuario;
    private static long _NumeroDePerfil;
    private static String _NombreDePerfil;
    private static int _CveTipoDeMenu;
    private static String _TextoTipoDeMenu;
    private static List<ClsPantallaPerfil> _PantallasAbiertas = new ArrayList();
    public static long NumeroDeUsuario(){
        return _NumeroDeUsuario;
    }
    public static void NumeroDeUsuario(long NumeroDeUsuario){
        _NumeroDeUsuario = NumeroDeUsuario;
    }
    public static String NombreDeUsuario(){
        return _NombreDeUsuario;
    }
    public static void NombreDeUsuario(String NombreDeUsuario){
        _NombreDeUsuario = NombreDeUsuario;
    }
    public static long NumeroDePerfil(){
        return _NumeroDePerfil;
    }
    public static String NombreDePerfil(){
        return _NombreDePerfil;
    }
    public static int CveTipoDeMenu(){
        return _CveTipoDeMenu;
    }
    public static void CveTipoDeMenu(int CveTipoDeMenu){
        _CveTipoDeMenu = CveTipoDeMenu;
    }
    public static String TextoTipoDeMenu(){
        return _TextoTipoDeMenu;
    }
    public static List<ClsPantallaPerfil> PantallasAbiertas(){
        return _PantallasAbiertas;
    }
    public static void TextoTipoDeMenu(String TextoTipoDeMenu){
        _TextoTipoDeMenu = TextoTipoDeMenu;
    }
    public static void PantallasAbiertas(ClsPantallaPerfil PantallasAbiertas){
        _PantallasAbiertas.add(PantallasAbiertas);
    }
    public static void RecuperaPerfil(){
        String sql = "";
        ClsResultSet Rec = new ClsResultSet();
        sql = "select " + ClsAsignaPerfil.RelacionesAsignaPerfil.Tabla.NombreVista() + ".* " +
                "from " + ClsAsignaPerfil.RelacionesAsignaPerfil.Tabla.NombreVista() + " " +
                "inner join " + ClsUsuario.RelacionesUsuario.Tabla.NombreTabla() + " on (" +
                ClsUsuario.RelacionesUsuario.NumeroDeUsuario.Campo() + " = " + ClsAsignaPerfil.RelacionesAsignaPerfil.NumeroDeUsuario.Campo() + ") " +
                "where " + ClsAsignaPerfil.RelacionesAsignaPerfil.NumeroDeUsuario.Campo() + " = " + _NumeroDeUsuario + " AND " +
                ClsAsignaPerfil.RelacionesAsignaPerfil.CveEstatus.Campo() + " = " + CveEstatus.Activo;
        Rec = ClsConexionMySql.Consulta(sql);
        while (Rec.Lee()){
            _NumeroDePerfil = Long.parseLong(Rec.Campo(ClsAsignaPerfil.RelacionesAsignaPerfil.NumeroDePerfil.Campo()).toString());
            _NombreDePerfil = (String) Rec.Campo(ClsAsignaPerfil.RelacionesAsignaPerfil.NombreDePerfil.Campo());
        }
    }
    public static boolean TipoPermiso(long NumeroDePerfil, long NumeroDePantalla){
        String sql = "";
        ClsResultSet Rec = new ClsResultSet();
        sql = "select * " +
                "from " + ClsPantallaPerfil.RelacionesPantallaPerfil.Tabla.NombreVista() + " " +
                "where " + ClsPantallaPerfil.RelacionesPantallaPerfil.NumeroDePerfil.Campo() + " = " + NumeroDePerfil + " AND " +
                ClsPantallaPerfil.RelacionesPantallaPerfil.NumeroDePantallaHija.Campo() + " = " + NumeroDePantalla;
        Rec = ClsConexionMySql.Consulta(sql);
        if (Rec.TieneRegistros()){
            return true;
        }
        return false;
    }
    /**
     * Cierra ventana dependiendo el numero de esta
     * @param NumeroDePantalla
     * @return True si fue cerrado y False si no.
     */
    public static boolean CierreVentana(long NumeroDePantalla){
        try{
            return _PantallasAbiertas.removeIf(x -> x.NumeroDePantallaHija() == NumeroDePantalla);
        }catch(Exception ex){
            return false;
        }
    }
    public static long CuentaPantallas(){
        try{
            String sql = "";
            ClsResultSet Rec = new ClsResultSet();
            sql = "select count(distinct("+ClsPantallaPerfil.RelacionesPantallaPerfil.NumeroDePantalla.Campo()+")) as NumeroPantalla from "+ClsPantallaPerfil.RelacionesPantallaPerfil.Tabla.NombreVista() 
                    + " where " + ClsPantallaPerfil.RelacionesPantallaPerfil.NumeroDePerfil.Campo() + " = "
                    + NumeroDePerfil() + " and " + ClsPantallaPerfil.RelacionesPantallaPerfil.CveTipoDeMenu.Campo() + " = " 
                    + CveTipoDeMenu() + " and " + ClsPantallaPerfil.RelacionesPantallaPerfil.NumeroDePantalla.Campo() + " not in (0,1,2)";
            Rec = ClsConexionMySql.Consulta(sql);
            while(Rec.Lee()){
                return Long.parseLong(Rec.Campo("NumeroPantalla").toString());
            }
            return 0;
        }catch(Exception ex){
            return 0;
        }
    }
    /**
     * Obtiene el secuencial con el nombre de la secuancia a la que consultara
     * @param NombreDeLaSecuencia
     * @return Regresa el sigiente secuencial de la tabla a la que corresponda la secuencia
     */
    public static long SecuencialDisponible(String NombreDeLaSecuencia){
        String sql = "select nextval('" + NombreDeLaSecuencia + "') as sigiente";
        ClsResultSet Rec = new ClsResultSet();
        Rec = ClsConexionMySql.Consulta(sql);
        while(Rec.Lee()){
            return Long.parseLong(Rec.Campo("sigiente").toString());
        }
        return 0;
    }
    
    public static void LimpiaSesion(){
        NumeroDeUsuario(0);
        NombreDeUsuario("");
        _NumeroDePerfil = 0;
        _NombreDePerfil = "";
        CveTipoDeMenu(0);
        TextoTipoDeMenu("");
        _PantallasAbiertas.clear();
    }
}
