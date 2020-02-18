/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Funcionalidades;

import ConexionMySql.ClsConexionMySql;
import ConexionMySql.ClsResultSet;
import Entidades.ClsProducto;
import Interfaces.CveEstatus;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Freak
 */
public class ClsOperaProducto {
    
    /**
     * Consulta por llaves de tabla 
     * @param NumeroDeProducto
     * @return Regresa elemento de tipo Producto
     */
    public Entidades.ClsProducto Consulta(String NumeroDeProducto,String CveEstatusL){
        ClsProducto Producto = new ClsProducto();
        ClsResultSet Rec = new ClsResultSet();
        NumeroDeProducto = "" + NumeroDeProducto;
        String Sql = "";
        if (!NumeroDeProducto.equals("")){
            Sql += Sql.equals("") ? " " : " and ";
            Sql += ClsProducto.RelacionesProducto.NumeroDeProducto.Campo() + " = '" + NumeroDeProducto + "'";
        }
        String FiltroEstatus = "";
        if (!CveEstatusL.equals("")){
            FiltroEstatus = ClsProducto.RelacionesProducto.CveEstatus.Campo() + " = " + CveEstatusL;
        }else{
            FiltroEstatus = ClsProducto.RelacionesProducto.CveEstatus.Campo() + " = " + CveEstatus.Activo;
        }
        Sql = "select * from " + ClsProducto.RelacionesProducto.Tabla.NombreVista() + " where " + (Sql.equals("") ? FiltroEstatus : Sql + " and " + FiltroEstatus);
        Rec = ClsConexionMySql.Consulta(Sql);
        while (Rec.Lee()){
            Producto = new ClsProducto(Rec,true);
        }
        return Producto;
    }
    /**
     * Consulta por llaves de tabla
     * @param NumeroDeProducto
     * @param Filtro
     * @return Lista de tipo Perfil
     */
    public List<Entidades.ClsProducto> ConsultaLista(String NumeroDeProducto,String Filtro){
        List<ClsProducto> Productos = new ArrayList<ClsProducto>();
        ClsProducto Producto = new ClsProducto();
        ClsResultSet Rec = new ClsResultSet();
        NumeroDeProducto = "" + NumeroDeProducto;
        Filtro = "" + Filtro;
        String Sql = "";
        if (!NumeroDeProducto.equals("")){
            Sql += Sql.equals("") ? " " : " and ";
            Sql += ClsProducto.RelacionesProducto.NumeroDeProducto.Campo() + " = '" + NumeroDeProducto + "'";
        }
        if (!Filtro.equals("")){
            Sql += Sql.equals("") ? " " : " and ";
            Sql += Filtro + " ";
        }
        String FiltroEstatus = ClsProducto.RelacionesProducto.CveEstatus.Campo() + " = " + CveEstatus.Activo + " order by 1";
        Sql = "select * from " + ClsProducto.RelacionesProducto.Tabla.NombreVista() + " where " + (Sql.equals("") ? FiltroEstatus : Sql + " and " + FiltroEstatus);
        Rec = ClsConexionMySql.Consulta(Sql);
        while (Rec.Lee()){
            Producto = new ClsProducto(Rec,true);
            Productos.add(Producto);
        }
        return Productos;
    }
}
