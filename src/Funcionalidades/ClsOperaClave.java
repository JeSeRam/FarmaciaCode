/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Funcionalidades;

import ConexionMySql.ClsConexionMySql;
import ConexionMySql.ClsResultSet;
import Entidades.ClsClave;
import Interfaces.CveEstatus;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Freak
 */
public class ClsOperaClave {
    /**
     * Consulta por llaves de tabla 
     * @param NumeroDeClave
     * @param SecuencialDeClave
     * @return Regresa elemento de tipo Clave
     */
    public Entidades.ClsClave Consulta(String NumeroDeClave,String SecuencialDeClave){
        ClsClave Clave = new ClsClave();
        ClsResultSet Rec;
        NumeroDeClave = "" + NumeroDeClave;
        SecuencialDeClave = "" + SecuencialDeClave;
        String Sql = "";
        if (!NumeroDeClave.equals("")){
            Sql += Sql.equals("") ? " " : " and ";
            Sql += ClsClave.RelacionesClave.NumeroDeClave.Campo() + " = '" + NumeroDeClave + "'";
        }
        if (!SecuencialDeClave.equals("")){
            Sql += Sql.equals("") ? " " : " and ";
            Sql += ClsClave.RelacionesClave.SecuencialDeClave.Campo() + " = '" + SecuencialDeClave + "'";
        }
        String FiltroEstatus = ClsClave.RelacionesClave.CveEstatus.Campo() + " = " + CveEstatus.Activo;
        Sql = "select * from " + ClsClave.RelacionesClave.Tabla.NombreVista() + " where " + (Sql.equals("") ? FiltroEstatus : Sql + " and " + FiltroEstatus);
        Rec = ClsConexionMySql.Consulta(Sql);
        while (Rec.Lee()){
            Clave = new ClsClave(Rec,true);
        }
        return Clave;
    }
    /**
     * Consulta por llaves de tabla
     * @param NumeroDeClave
     * @param SecuencialDeClave
     * @param Filtro
     * @return Lista de tipo Clave
     */
    public List<Entidades.ClsClave> ConsultaLista(String NumeroDeClave,String SecuencialDeClave,String Filtro){
        List<ClsClave> Claves = new ArrayList<>();
        ClsClave Clave;
        ClsResultSet Rec;
        NumeroDeClave = "" + NumeroDeClave;
        SecuencialDeClave = "" + SecuencialDeClave;
        String Sql = "";
        if (!NumeroDeClave.equals("")){
            Sql += Sql.equals("") ? " " : " and ";
            Sql += ClsClave.RelacionesClave.NumeroDeClave.Campo() + " = '" + NumeroDeClave + "'";
        }
        if (!SecuencialDeClave.equals("")){
            Sql += Sql.equals("") ? " " : " and ";
            Sql += ClsClave.RelacionesClave.SecuencialDeClave.Campo() + " = '" + SecuencialDeClave + "'";
        }
        if (!Filtro.equals("")){
            Sql += Sql.equals("") ? " " : " and ";
            Sql += Filtro + " ";
        }
        String FiltroEstatus = ClsClave.RelacionesClave.CveEstatus.Campo() + " = " + CveEstatus.Activo + " order by 2";
        Sql = "select * from " + ClsClave.RelacionesClave.Tabla.NombreVista() + " where " + (Sql.equals("") ? FiltroEstatus : Sql + " and " + FiltroEstatus);
        Rec = ClsConexionMySql.Consulta(Sql);
        while (Rec.Lee()){
            Clave = new ClsClave(Rec,true);
            Claves.add(Clave);
        }
        return Claves;
    }
}
