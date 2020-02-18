package Funcionalidades;


import ConexionMySql.ClsConexionMySql;
import ConexionMySql.ClsResultSet;
import Entidades.ClsPantalla;
import Interfaces.CveEstatus;
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Freak
 */
public class ClsOperaPantalla {
    /**
     * Consulta por llaves de tabla 
     * @param NumeroDePantalla
     * @param NumeroDePantallaHija
     * @param CveTipoDeMenu
     * @return Regresa elemento de tipo Pantalla
     */
    public Entidades.ClsPantalla Consulta(String NumeroDePantalla,String NumeroDePantallaHija,String CveTipoDeMenu){
        ClsPantalla Pantalla = new ClsPantalla();
        ClsResultSet Rec = new ClsResultSet();
        NumeroDePantalla = "" + NumeroDePantalla;
        NumeroDePantallaHija = "" + NumeroDePantallaHija;
        CveTipoDeMenu = "" + CveTipoDeMenu;
        String Sql = "";
        if (!NumeroDePantalla.equals("")){
            Sql += Sql.equals("") ? " " : " and ";
            Sql += ClsPantalla.RelacionesPantalla.NumeroDePantalla.Campo() + " = '" + NumeroDePantalla + "'";
        }
        if (!NumeroDePantallaHija.equals("")){
            Sql += Sql.equals("") ? " " : " and ";
            Sql += ClsPantalla.RelacionesPantalla.NumeroDePantallaHija.Campo() + " = '" + NumeroDePantallaHija + "'";
        }
        if (!CveTipoDeMenu.equals("")){
            Sql += Sql.equals("") ? " " : " and ";
            Sql += ClsPantalla.RelacionesPantalla.CveTipoDeMenu.Campo() + " = '" + CveTipoDeMenu + "'";
        }
        String FiltroEstatus = ClsPantalla.RelacionesPantalla.CveEstatus.Campo() + " = " + CveEstatus.Activo;
        Sql = "select * from " + ClsPantalla.RelacionesPantalla.Tabla.NombreVista() + " where " + (Sql.equals("") ? FiltroEstatus : Sql + " and " + FiltroEstatus);
        Rec = ClsConexionMySql.Consulta(Sql);
        while (Rec.Lee()){
            Pantalla = new ClsPantalla(Rec,true);
        }
        return Pantalla;
    }
    /**
     * Consulta por llaves de tabla
     * @param NumeroDePantalla
     * @param NumeroDePantallaHija
     * @param CveTipoDeMenu
     * @param Filtro
     * @return Lista de tipo Pantalla
     */
    public List<Entidades.ClsPantalla> ConsultaLista(String NumeroDePantalla,String NumeroDePantallaHija,String CveTipoDeMenu,String Filtro){
        List<ClsPantalla> Pantallas = new ArrayList<ClsPantalla>();
        ClsPantalla Pantalla = new ClsPantalla();
        ClsResultSet Rec = new ClsResultSet();
        NumeroDePantalla = "" + NumeroDePantalla;
        NumeroDePantallaHija = "" + NumeroDePantallaHija;
        CveTipoDeMenu = "" + CveTipoDeMenu;
        String Sql = "";
        if (!NumeroDePantalla.equals("")){
            Sql += Sql.equals("") ? " " : " and ";
            Sql += ClsPantalla.RelacionesPantalla.NumeroDePantalla.Campo() + " = '" + NumeroDePantalla + "'";
        }
        if (!NumeroDePantallaHija.equals("")){
            Sql += Sql.equals("") ? " " : " and ";
            Sql += ClsPantalla.RelacionesPantalla.NumeroDePantallaHija.Campo() + " = '" + NumeroDePantallaHija + "'";
        }
        if (!CveTipoDeMenu.equals("")){
            Sql += Sql.equals("") ? " " : " and ";
            Sql += ClsPantalla.RelacionesPantalla.CveTipoDeMenu.Campo() + " = '" + CveTipoDeMenu + "'";
        }
        if (!Filtro.equals("")){
            Sql += Sql.equals("") ? " " : " and ";
            Sql += Filtro + " ";
        }
        String FiltroEstatus = ClsPantalla.RelacionesPantalla.CveEstatus.Campo() + " = " + CveEstatus.Activo + " order by " + ClsPantalla.RelacionesPantalla.NombreDePantallaInterno.Campo() + ","
                + ClsPantalla.RelacionesPantalla.NombreDePantallaMenuHija.Campo();
        Sql = "select * from " + ClsPantalla.RelacionesPantalla.Tabla.NombreVista() + " where " + (Sql.equals("") ? FiltroEstatus : Sql + " and " + FiltroEstatus);
        Rec = ClsConexionMySql.Consulta(Sql);
        while (Rec.Lee()){
            Pantalla = new ClsPantalla(Rec,true);
            Pantallas.add(Pantalla);
        }
        return Pantallas;
    }
}
