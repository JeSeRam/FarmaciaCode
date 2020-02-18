/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import Clases.ClsRelacion;
import Clases.ClsRelacionTabla;
import ConexionMySql.ClsConexionMySql;
import java.util.Map;
import Interfaces.IDiasLaborales;

/**
 *
 * @author Freak
 */
public class ClsDiasLaborales implements IDiasLaborales {
    // <editor-fold defaultstate="collapsed" desc="Variables de la Clase">
    // Tabla
    private long _NumeroDeDia;
    private long _NumeroDeUsuario;
    private String _DiasLaborales;
    private int _CveEstatus;
    // Vista
    private String _NombreDeUsuario;
    private String _TextoEstatus;
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Get & Set">
    // Tabla
    @Override
    public long NumeroDeDia() {
        return _NumeroDeDia;
    }

    @Override
    public void NumeroDeDia(long NumeroDeDia) {
        _NumeroDeDia = NumeroDeDia;
    }

    @Override
    public long NumeroDeUsuario() {
        return _NumeroDeUsuario;
    }

    @Override
    public void NumeroDeUsuario(long NumeroDeUsuario) {
        _NumeroDeUsuario = NumeroDeUsuario;
    }
    
    @Override
    public String DiasLaborales(){
        return _DiasLaborales;
    }
    
    @Override
    public void DiasLaborales(String DiasLaborales){
        _DiasLaborales = DiasLaborales;
    }
    
    @Override
    public int CveEstatus() {
        return _CveEstatus;
    }

    @Override
    public void CveEstatus(int CveEstatus) {
        _CveEstatus = CveEstatus;
    }
    // Vista
    @Override
    public String NombreDeUsuario(){
        return _NombreDeUsuario;
    }
    
    @Override
    public void NombreDeUsuario(String NombreDeUsuario){
        _NombreDeUsuario = NombreDeUsuario;
    }
    
    @Override
    public String TextoEstatus() {
        return _TextoEstatus;
    }

    @Override
    public void TextoEstatus(String TextoEstatus) {
        _TextoEstatus = TextoEstatus;
    }
    //  </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Constructor">
    public void ClsDiasLaborales(){
        
    }
    public void ClsDiasLaborales(long NumeroDeDia, long NumeroDeUsuario, String DiasLaborales, int CveEstatus) {
        _NumeroDeDia = NumeroDeDia;
        _NumeroDeUsuario = NumeroDeUsuario;
        _DiasLaborales = DiasLaborales;
        _CveEstatus = CveEstatus;
    }
    public void ClsDiasLaborales(long NumeroDeDia, long NumeroDeUsuario, String DiasLaborales, int CveEstatus, String NombreDeUsuario, String TextoEstatus) {
        // Tabla
        _NumeroDeDia = NumeroDeDia;
        _NumeroDeUsuario = NumeroDeUsuario;
        _DiasLaborales = DiasLaborales;
        _CveEstatus = CveEstatus;
        // Vista
        _NombreDeUsuario = NombreDeUsuario;
        _TextoEstatus = TextoEstatus;
    }
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Funciones">
    @Override
    public boolean Insert() {
        String sql = ToInsert();
        if (ClsConexionMySql.Transaccion(sql)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean Update(Map<String, Object> Cambios) {
        String sql = ToUpdate(Cambios);
        if (ClsConexionMySql.Transaccion(sql)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean Delete() {
        String sql = ToDelete();
        if (ClsConexionMySql.Transaccion(sql)) {
            return true;
        }
        return false;
    }
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Funciones construcotres sql">
    @Override
    public String ToInsert() {
        String sql = "";
        sql = "insert into " + RelacionesDiasLaborales.Tabla.NombreTabla() + " ("
                + RelacionesDiasLaborales.NumeroDeDia.Campo() + ","
                + RelacionesDiasLaborales.NumeroDeUsuario.Campo() + ","
                + RelacionesDiasLaborales.DiasLaborales.Campo() + ","
                + RelacionesDiasLaborales.CveEstatus.Campo()
                + ") values ("
                + _NumeroDeDia + ","
                + _NumeroDeUsuario + ","
                + _DiasLaborales + ","
                + _CveEstatus + ")";
        return sql;
    }

    @Override
    public String ToDelete() {
        String sql = "";
        sql = "delete from " + RelacionesDiasLaborales.Tabla.NombreTabla() + " where "
                + RelacionesDiasLaborales.NumeroDeDia.Campo() + " =  " + _NumeroDeDia + " and "
                + RelacionesDiasLaborales.NumeroDeUsuario.Campo() + " =  " + _NumeroDeUsuario;
        return sql;
    }

    @Override
    public String ToUpdate(Map<String, Object> Cambios) {
        String sql = "";
        if (!Cambios.isEmpty()) {
            for (Map.Entry<String, Object> Cambio : Cambios.entrySet()) {
                sql += (Cambio.getKey() + " = " + Cambio.getValue()).concat(",");
            }
            sql = sql.substring(0, sql.length() - 1);
            if (sql != null) {
                sql = "update " + RelacionesDiasLaborales.Tabla.NombreTabla() + " set " + sql + " where "
                + RelacionesDiasLaborales.NumeroDeDia.Campo() + " =  " + _NumeroDeDia + " and "
                + RelacionesDiasLaborales.NumeroDeUsuario.Campo() + " =  " + _NumeroDeUsuario;
            }
        }
        return sql;
    }
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Relaciones">
    public static class RelacionesDiasLaborales {
        public static ClsRelacionTabla Tabla = new ClsRelacionTabla("DiasLaborales","ViDiasLaborales", "dlb", "Tabla de dias laborales.");
        public static ClsRelacion NumeroDeDia = new ClsRelacion("NumeroDeDia", "dlb_num_dia", "Numero de dia","Numeric","4","0","NOT NULL","Identificador de número de dia");
        public static ClsRelacion NumeroDeUsuario = new ClsRelacion("NumeroDeUsuario", "dlb_num_usuario", "Nombre de Usuario","Numeric","4","0","NOT NULL","Nombre de Usuario");
        public static ClsRelacion DiasLaborales = new ClsRelacion("DiasLaborales","dlb_dias","Dias Laborales","String","150","0","NOT NULL","Dias Laborales");
        public static ClsRelacion CveEstatus = new ClsRelacion("CveEstatus", "dlb_cve_estatus", "Estatus","Numeric","4","0","NOT NULL","Indicador de estatus");
        public static ClsRelacion NombreDeUsuario = new ClsRelacion("NombreDeUsuario", "dlb_nom_usuario", "Nombre de Usuario","String","30","0","NUL","Nombre de Usuario");
        public static ClsRelacion TextoEstatus = new ClsRelacion("TextoEstatus", "dlb_txt_estatus", "Estatus","String","30","0","NULL","Indicador de estatus");
        public static ClsRelacion[] Estructura = {NumeroDeDia,NumeroDeUsuario,DiasLaborales,CveEstatus};
        public static String SqlVista = "CREATE VIEW " + Tabla.NombreVista() + " AS " +
                "SELECT " +
                NumeroDeDia.Campo() + "," +
                NumeroDeUsuario.Campo() + "," +
                DiasLaborales.Campo() + "," +
                CveEstatus.Campo() + "," +
                ClsUsuario.RelacionesUsuario.NombreDeUsuario.Campo() + " AS " + NombreDeUsuario.Campo() + "," +
                "(SELECT " + ClsClave.RelacionesClave.NombreDeClave.Campo() + " FROM " + ClsClave.RelacionesClave.Tabla.NombreTabla() + " WHERE " + ClsClave.RelacionesClave.NumeroDeClave.Campo() + " = 1 AND " + ClsClave.RelacionesClave.SecuencialDeClave.Campo() + " = " + CveEstatus.Campo() + ") AS " + TextoEstatus.Campo() + " " +
                "FROM " + Tabla.NombreTabla() + " INNER JOIN " + ClsUsuario.RelacionesUsuario.Tabla.NombreTabla() + " ON (" + ClsUsuario.RelacionesUsuario.NumeroDeUsuario.Campo() + " = " + NumeroDeUsuario.Campo() + ")";
        public static String Index = "CREATE UNIQUE INDEX PK_" +Tabla.NombreTabla() + " ON " 
                + Tabla.NombreTabla() + " (" + NumeroDeDia.Campo()
                + "," + NumeroDeUsuario.Campo() + ")";
    }
    // </editor-fold>
}
