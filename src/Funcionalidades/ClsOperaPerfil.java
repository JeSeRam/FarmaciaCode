/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Funcionalidades;

import ConexionMySql.ClsConexionMySql;
import ConexionMySql.ClsResultSet;
import Entidades.ClsPerfil;
import Interfaces.CveEstatus;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Freak
 */
public class ClsOperaPerfil {
    /**
     * Consulta por llaves de tabla 
     * @param NumeroDePerfil
     * @return Regresa elemento de tipo Pantalla
     */
    public Entidades.ClsPerfil Consulta(String NumeroDePerfil){
        ClsPerfil Perfil = new ClsPerfil();
        ClsResultSet Rec = new ClsResultSet();
        NumeroDePerfil = "" + NumeroDePerfil;
        String Sql = "";
        if (!NumeroDePerfil.equals("")){
            Sql += Sql.equals("") ? " " : " and ";
            Sql += ClsPerfil.RelacionesPerfil.NumeroDePerfil.Campo() + " = '" + NumeroDePerfil + "'";
        }
        String FiltroEstatus = ClsPerfil.RelacionesPerfil.CveEstatus.Campo() + " = " + CveEstatus.Activo;
        Sql = "select * from " + ClsPerfil.RelacionesPerfil.Tabla.NombreVista() + " where " + (Sql.equals("") ? FiltroEstatus : Sql + " and " + FiltroEstatus);
        Rec = ClsConexionMySql.Consulta(Sql);
        while (Rec.Lee()){
            Perfil = new ClsPerfil(Rec,true);
        }
        return Perfil;
    }
    /**
     * Consulta por llaves de tabla
     * @param NumeroDePerfil
     * @param Filtro
     * @return Lista de tipo Perfil
     */
    public List<Entidades.ClsPerfil> ConsultaLista(String NumeroDePerfil,String Filtro){
        List<ClsPerfil> Perfiles = new ArrayList<ClsPerfil>();
        ClsPerfil Perfil = new ClsPerfil();
        ClsResultSet Rec = new ClsResultSet();
        NumeroDePerfil = "" + NumeroDePerfil;
        Filtro = "" + Filtro;
        String Sql = "";
        if (!NumeroDePerfil.equals("")){
            Sql += Sql.equals("") ? " " : " and ";
            Sql += ClsPerfil.RelacionesPerfil.NumeroDePerfil.Campo() + " = '" + NumeroDePerfil + "'";
        }
        if (!Filtro.equals("")){
            Sql += Sql.equals("") ? " " : " and ";
            Sql += Filtro + " ";
        }
        String FiltroEstatus = ClsPerfil.RelacionesPerfil.CveEstatus.Campo() + " = " + CveEstatus.Activo + " order by 1";
        Sql = "select * from " + ClsPerfil.RelacionesPerfil.Tabla.NombreVista() + " where " + (Sql.equals("") ? FiltroEstatus : Sql + " and " + FiltroEstatus);
        Rec = ClsConexionMySql.Consulta(Sql);
        while (Rec.Lee()){
            Perfil = new ClsPerfil(Rec,true);
            Perfiles.add(Perfil);
        }
        return Perfiles;
    }
}
