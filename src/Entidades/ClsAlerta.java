/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import Clases.ClsRelacion;
import Clases.ClsRelacionTabla;
import ConexionMySql.ClsConexionMySql;
import Interfaces.IAlerta;
import java.util.Date;
import java.util.Map;

/**
 *
 * @author Freak
 */
public class ClsAlerta implements IAlerta {
    // <editor-fold defaultstate="collapsed" desc="Variables de la Clase">
    // Tabla
    private long _NumeroDeAlerta;
    private long _NumeroDeProducto;
    private long _NumeroDeUsuario;
    private Date _FechaDeAlerta;
    private int _CveEnviada;
    private int _CveEstatus;
     // Vista
    private String _NombreDeProducto;
    private String _NombreDeUsuario;
    private String _TextoEnviada;
    private String _TextoEstatus;
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Get & Set">
    // Tabla
    @Override
    public long NumeroDeAlerta() {
        return _NumeroDeAlerta;
    }

    @Override
    public void NumeroDeAlerta(long NumeroDeAlerta) {
        _NumeroDeAlerta = NumeroDeAlerta;
    }

    @Override
    public long NumeroDeProducto() {
        return _NumeroDeProducto;
    }

    @Override
    public void NumeroDeProducto(long NumeroDeProducto) {
        _NumeroDeProducto = NumeroDeProducto;
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
    public Date FechaDeAlerta() {
        return _FechaDeAlerta;
    }

    @Override
    public void FechaDeAlerta(Date FechaDeAlerta) {
        _FechaDeAlerta = FechaDeAlerta;
    }

    @Override
    public int CveEnviada() {
        return _CveEnviada; 
    }

    @Override
    public void CveEnviada(int CveEnviada) {
        _CveEnviada = CveEnviada;
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
    public String NombreDeProducto() {
        return _NombreDeProducto;
    }

    @Override
    public void NombreDeProducto(String NombreDeProducto) {
        _NombreDeProducto = NombreDeProducto;
    }

    @Override
    public String NombreDeUsuario() {
        return _NombreDeUsuario;
    }

    @Override
    public void NombreDeUsuario(String NombreDeUsuario) {
        _NombreDeUsuario = NombreDeUsuario;
    }

    @Override
    public String TextoEnviada() {
        return _TextoEnviada;
    }

    @Override
    public void TextoEnviada(String TextoEnviada) {
        _TextoEnviada = TextoEnviada;
    }

    @Override
    public String TextoEstatus() {
        return _TextoEstatus;
    }

    @Override
    public void TextoEstatus(String TextoEstatus) {
        _TextoEstatus = TextoEstatus;
    }
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Constructor">
    public void ClsAlerta() {
        
    }
    public void ClsAlerta(long NumeroDeAlerta, long NumeroDeProducto, long NumeroDeUsuario, Date FechaDeAlerta, int CveEnviada, int CveEstatus) {
        _NumeroDeAlerta = NumeroDeAlerta;
        _NumeroDeProducto = NumeroDeProducto;
        _NumeroDeUsuario = NumeroDeUsuario;
        _FechaDeAlerta = FechaDeAlerta;
        _CveEnviada = CveEnviada;
        _CveEstatus = CveEstatus;
    }
    public void ClsAlerta(long NumeroDeAlerta, long NumeroDeProducto, long NumeroDeUsuario, Date FechaDeAlerta, int CveEnviada, int CveEstatus, String NombreDeProducto, String NombreDeUsuario, String TextoEnviada, String TextoEstatus) {
        // Tabla
        _NumeroDeAlerta = NumeroDeAlerta;
        _NumeroDeProducto = NumeroDeProducto;
        _NumeroDeUsuario = NumeroDeUsuario;
        _FechaDeAlerta = FechaDeAlerta;
        _CveEnviada = CveEnviada;
        _CveEstatus = CveEstatus;
        // Vista
        _NombreDeProducto = NombreDeProducto;
        _NombreDeUsuario = NombreDeUsuario;
        _TextoEnviada = TextoEnviada;
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
    public String ToDelete() {
        String sql = "";
        sql = "delete from " + RelacionesAlerta.Tabla.NombreTabla() + " where "
                + RelacionesAlerta.NumeroDeAlerta.Campo() + " =  " + _NumeroDeAlerta + " and "
                + RelacionesAlerta.NumeroDeProducto.Campo() + " = " + _NumeroDeProducto;
        return sql;
    }

    @Override
    public String ToInsert() {
        String sql = "";
        sql = "insert into " + RelacionesAlerta.Tabla.NombreTabla() + " ("
                + RelacionesAlerta.NumeroDeAlerta.Campo() + ","
                + RelacionesAlerta.NumeroDeProducto.Campo() + ","
                + RelacionesAlerta.NumeroDeUsuario.Campo() + ","
                + RelacionesAlerta.FechaDeAlerta.Campo() + ","
                + RelacionesAlerta.CveEnviada.Campo() + ","
                + RelacionesAlerta.CveEstatus.Campo()
                + ") values ("
                + _NumeroDeAlerta + ","
                + _NumeroDeProducto + ","
                + _NumeroDeUsuario + ","
                + _FechaDeAlerta + ","
                + _CveEnviada + ","
                + _CveEstatus + ")";
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
                sql = "update " + RelacionesAlerta.Tabla.NombreTabla() + " set " + sql + " where "
                + RelacionesAlerta.NumeroDeAlerta.Campo() + " =  " + _NumeroDeAlerta + " and "
                + RelacionesAlerta.NumeroDeProducto.Campo() + " = " + _NumeroDeProducto;
            }
        }
        return sql;
    }
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Relaciones">
    public static class RelacionesAlerta {
        public static ClsRelacionTabla Tabla = new ClsRelacionTabla("Alerta","ViAlerta", "ale", "Tabla alertas de producto");
        public static ClsRelacion NumeroDeAlerta = new ClsRelacion("NumeroDeAlerta", "ale_num_alerta", "Número de Alerta","Numeric","4","0","NOT NULL","Indicador de número de alerta");
        public static ClsRelacion NumeroDeProducto = new ClsRelacion("NumeroDeProducto", "ale_num_producto", "Número de Producto","Numeric","4","0","NOT NULL","Indicador de número de producto");
        public static ClsRelacion NumeroDeUsuario = new ClsRelacion("NumeroDeUsuario", "ale_num_usuario", "Número de Usuario","Numeric","4","0","NOT NULL","Indicador de número de usuario");
        public static ClsRelacion FechaDeAlerta = new ClsRelacion("FechaDeAlerta", "ale_fecha_alerta", "Fecha de Alerta","DateTime","0","0","NOT NULL","Fecha de Alerta");
        public static ClsRelacion CveEnviada = new ClsRelacion("CveEnviada", "ale_cve_enviada", "Enviada","Numeric","4","0","NOT NULL","Enviada");
        public static ClsRelacion CveEstatus = new ClsRelacion("CveEstatus", "ale_cve_estatus", "Estatus","Numeric","4","0","NOT NULL","Estatus");
        public static ClsRelacion NombreDeProducto = new ClsRelacion("NombreDeProducto", "ale_nom_producto", "Nombre de Producto","String","30","0","NULL","Nombre de Producto");
        public static ClsRelacion NombreDeUsuario = new ClsRelacion("NombreDeUsuario", "ale_nom_usuario", "Nombre de Usuario","String","30","0","NULL","Nombre de Usuario");
        public static ClsRelacion TextoEnviada = new ClsRelacion("TextoEnviada", "ale_txt_enviada", "Enviada","String","30","0","NULL","Enviada");
        public static ClsRelacion TextoEstatus = new ClsRelacion("TextoEstatus", "ale_txt_estatus", "Estatus","String","30","0","NULL","Estatus");
        public static ClsRelacion[] Estructura = {NumeroDeAlerta,NumeroDeProducto,NumeroDeUsuario,FechaDeAlerta,CveEnviada,CveEstatus};    
        public static String SqlVista = "CREATE VIEW " + Tabla.NombreVista() + " AS " +
                "SELECT " +
                NumeroDeAlerta.Campo() + "," +
                NumeroDeProducto.Campo() + "," +
                NumeroDeUsuario.Campo() + "," +
                FechaDeAlerta.Campo() + "," +
                CveEnviada.Campo() + "," +
                CveEstatus.Campo() + "," +
                ClsProducto.RelacionesProducto.NombreDeProducto.Campo() + " AS " + NombreDeProducto.Campo() + "," +
                ClsUsuario.RelacionesUsuario.NombreDeUsuario.Campo() + " AS " + NombreDeUsuario.Campo() + "," +
                "(SELECT " + ClsClave.RelacionesClave.NombreDeClave.Campo() + " FROM " + ClsClave.RelacionesClave.Tabla.NombreTabla() + " WHERE " + ClsClave.RelacionesClave.NumeroDeClave.Campo() + " = 4 AND " + ClsClave.RelacionesClave.SecuencialDeClave.Campo() + " = " + CveEnviada.Campo() + ") AS " + TextoEnviada.Campo() + "," +
                "(SELECT " + ClsClave.RelacionesClave.NombreDeClave.Campo() + " FROM " + ClsClave.RelacionesClave.Tabla.NombreTabla() + " WHERE " + ClsClave.RelacionesClave.NumeroDeClave.Campo() + " = 1 AND " + ClsClave.RelacionesClave.SecuencialDeClave.Campo() + " = " + CveEstatus.Campo() + ") AS " + TextoEstatus.Campo() + " " +
                "FROM " + Tabla.NombreTabla() + " INNER JOIN " + ClsProducto.RelacionesProducto.Tabla.NombreTabla() + " ON (" + ClsProducto.RelacionesProducto.NumeroDeProducto.Campo() + " = " + NumeroDeProducto.Campo() + ") " +
                "INNER JOIN " + ClsUsuario.RelacionesUsuario.Tabla.NombreTabla() + " ON (" + ClsUsuario.RelacionesUsuario.NumeroDeUsuario.Campo() + " = " + NumeroDeUsuario.Campo() + ")";
        public static String Index = "CREATE UNIQUE INDEX PK_" +Tabla.NombreTabla() + " ON " 
                + Tabla.NombreTabla() + " (" + NumeroDeAlerta.Campo()
                + "," + NumeroDeProducto.Campo() + ")";
    }
    // </editor-fold>
}
