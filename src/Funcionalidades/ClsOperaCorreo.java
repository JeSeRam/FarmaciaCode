/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Funcionalidades;

import ConexionMySql.ClsConexionMySql;
import ConexionMySql.ClsResultSet;
import Entidades.ClsCorreo;
import Interfaces.CveEstatus;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Freak
 */
public class ClsOperaCorreo {
    /**
     * Consulta por llaves de tabla 
     * @param NumeroDeCorreo
     * @param CveTipoDeCorreo
     * @return Regresa elemento de tipo Pantalla
     */
    public Entidades.ClsCorreo Consulta(String NumeroDeCorreo,String CveTipoDeCorreo){
        ClsCorreo Correo = new ClsCorreo();
        ClsResultSet Rec;
        NumeroDeCorreo = "" + NumeroDeCorreo;
        CveTipoDeCorreo = "" + CveTipoDeCorreo;
        String Sql = "";
        if (!NumeroDeCorreo.equals("")){
            Sql += Sql.equals("") ? " " : " and ";
            Sql += ClsCorreo.RelacionesCorreo.NumeroDeCorreo.Campo() + " = '" + NumeroDeCorreo + "'";
        }
        if (!CveTipoDeCorreo.equals("")){
            Sql += Sql.equals("") ? " " : " and ";
            Sql += ClsCorreo.RelacionesCorreo.CveTipoDeCorreo.Campo() + " = '" + CveTipoDeCorreo + "'";
        }
        String FiltroEstatus = ClsCorreo.RelacionesCorreo.CveEstatus.Campo() + " = " + CveEstatus.Activo;
        Sql = "select * from " + ClsCorreo.RelacionesCorreo.Tabla.NombreVista() + " where " + (Sql.equals("") ? FiltroEstatus : Sql + " and " + FiltroEstatus);
        Rec = ClsConexionMySql.Consulta(Sql);
        while (Rec.Lee()){
            Correo = new ClsCorreo(Rec,true);
        }
        return Correo;
    }
    /**
     * Consulta por llaves de tabla
     * @param NumeroDeCorreo
     * @param CveTipoDeCorreo
     * @param Filtro
     * @return Lista de tipo Pantalla
     */
    public List<Entidades.ClsCorreo> ConsultaLista(String NumeroDeCorreo,String CveTipoDeCorreo,String Filtro){
        List<ClsCorreo> Correos = new ArrayList<>();
        ClsCorreo Correo;
        ClsResultSet Rec;
        NumeroDeCorreo = "" + NumeroDeCorreo;
        CveTipoDeCorreo = "" + CveTipoDeCorreo;
        String Sql = "";
        if (!NumeroDeCorreo.equals("")){
            Sql += Sql.equals("") ? " " : " and ";
            Sql += ClsCorreo.RelacionesCorreo.NumeroDeCorreo.Campo() + " = '" + NumeroDeCorreo + "'";
        }
        if (!CveTipoDeCorreo.equals("")){
            Sql += Sql.equals("") ? " " : " and ";
            Sql += ClsCorreo.RelacionesCorreo.CveTipoDeCorreo.Campo() + " = '" + CveTipoDeCorreo + "'";
        }
        if (!Filtro.equals("")){
            Sql += Sql.equals("") ? " " : " and ";
            Sql += Filtro + " ";
        }
        String FiltroEstatus = ClsCorreo.RelacionesCorreo.CveEstatus.Campo() + " = " + CveEstatus.Activo;
        Sql = "select * from " + ClsCorreo.RelacionesCorreo.Tabla.NombreVista() + " where " + (Sql.equals("") ? FiltroEstatus : Sql + " and " + FiltroEstatus);
        Rec = ClsConexionMySql.Consulta(Sql);
        while (Rec.Lee()){
            Correo = new ClsCorreo(Rec,true);
            Correos.add(Correo);
        }
        return Correos;
    }
    public boolean ValidaCorreo(String Correo){
        boolean Estatus = false;
        Pattern pat = null;
        Matcher mat = null;
        pat = Pattern.compile("^[\\w\\-\\_\\+]+(\\.[\\w\\-\\_]+)*@([A-Za-z0-9-]+\\.)+[A-Za-z]{2,4}$");
        mat = pat.matcher(Correo);
        if(mat.find()){
            Estatus = true;
        }
        return Estatus;
    }
}
