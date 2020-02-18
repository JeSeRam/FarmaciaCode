package Funcionalidades;


import ConexionMySql.ClsConexionMySql;
import ConexionMySql.ClsResultSet;
import Entidades.ClsPantalla;
import Entidades.ClsPantallaPerfil;
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
public class ClsOperaPantallaPerfil {
    public List Consulta(long NumeroDePerfil, int CveTipoDeMenu,long NumeroDePantalla, String NumeroDePantallaHija,boolean Menu){
        List Resultado = new ArrayList();
        ClsResultSet Rec = new ClsResultSet();
        String Sql = "";
        if (NumeroDePerfil != 0){
            Sql += Sql.equals("") ? " " : " and ";
            Sql += ClsPantallaPerfil.RelacionesPantallaPerfil.NumeroDePerfil.Campo() + " = '" + NumeroDePerfil + "'";
        }
        if (CveTipoDeMenu != 0){
            Sql += Sql.equals("") ? " " : " and ";
            Sql += ClsPantallaPerfil.RelacionesPantallaPerfil.CveTipoDeMenu.Campo() + " = '" + CveTipoDeMenu + "'";
        }
        if (NumeroDePantalla != 0){
            Sql += Sql.equals("") ? " " : " and ";
            Sql += ClsPantallaPerfil.RelacionesPantallaPerfil.NumeroDePantalla.Campo() + " = '" + NumeroDePantalla + "'";
        }
        if (!NumeroDePantallaHija.equals("")){
            Sql += Sql.equals("") ? " " : " and ";
            Sql += ClsPantallaPerfil.RelacionesPantallaPerfil.NumeroDePantallaHija.Campo() + " = '" + NumeroDePantallaHija + "'";
        }
        if (Menu){
            Sql += Sql.equals("") ? " " : " and ";
            Sql += ClsPantallaPerfil.RelacionesPantallaPerfil.NumeroDePantalla.Campo() + " not in (0,1,2) and ";
            Sql += ClsPantallaPerfil.RelacionesPantallaPerfil.NumeroDePantallaHija.Campo() + " in (select " + ClsPantalla.RelacionesPantalla.NumeroDePantallaHija.Campo() +" from "+
                    ClsPantalla.RelacionesPantalla.Tabla.NombreVista()+" where "+ ClsPantalla.RelacionesPantalla.CveApareceEnMenu.Campo() +" = 1)";
        }
        if (!Sql.equals("")){
            Sql += Sql.equals("") ? " " : " and ";
            Sql += ClsPantallaPerfil.RelacionesPantallaPerfil.CveEstatus.Campo() + " = " + CveEstatus.Activo;
        }else{
            Sql += " " + ClsPantallaPerfil.RelacionesPantallaPerfil.CveEstatus.Campo() + " = " + CveEstatus.Activo;
        }
        Sql = "select * from " + ClsPantallaPerfil.RelacionesPantallaPerfil.Tabla.NombreVista() + " where" + Sql + " order by 3,4";
        Rec = ClsConexionMySql.Consulta(Sql);
        while (Rec.Lee()){
            Resultado.add(new ClsPantallaPerfil(Rec,true));
        }
        return Resultado;
    }
}
