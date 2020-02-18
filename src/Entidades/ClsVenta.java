/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import Clases.ClsRelacion;
import Clases.ClsRelacionTabla;
import ConexionMySql.ClsConexionMySql;
import Interfaces.IVenta;
import java.util.Date;
import java.util.Map;

/**
 *
 * @author Freak
 */
public class ClsVenta implements IVenta {
    // <editor-fold defaultstate="collapsed" desc="Variables de la Clase">
    // Tabla
    private long _NumeroDeVenta;
    private long _NumeroDeUsuario;
    private long _NumeroDeLote;
    private long _NumeroDeProducto;
    private int _Cantidad;
    private double _Precio;
    private Date _FechaDeVenta;
    // Vista
    private String _NombreDeUsuario;
    private String _NombreDeProducto;
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Get & Set">
    // Tabla
    @Override
    public long NumeroDeVenta() {
        return _NumeroDeVenta;
    }

    @Override
    public void NumeroDeVenta(long NumeroDeVenta) {
        _NumeroDeVenta = NumeroDeVenta;
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
    public long NumeroDeLote() {
        return _NumeroDeLote;
    }

    @Override
    public void NumeroDeLote(long NumeroDeLote) {
        _NumeroDeLote = NumeroDeLote;
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
    public int Cantidad() {
        return _Cantidad;
    }

    @Override
    public void Cantidad(int Cantidad) {
        _Cantidad = Cantidad;
    }

    @Override
    public double Precio() {
        return _Precio;
    }

    @Override
    public void Precio(double Precio) {
        _Precio = Precio;
    }

    @Override
    public Date FechaDeVenta() {
        return _FechaDeVenta;
    }

    @Override
    public void FechaDeVenta(Date FechaDeVenta) {
        _FechaDeVenta = FechaDeVenta;
    }
    // Vista
    @Override
    public String NombreDeUsuario() {
        return _NombreDeUsuario;
    }

    @Override
    public void NombreDeUsuario(String NombreDeUsuario) {
        _NombreDeUsuario = NombreDeUsuario;
    }

    @Override
    public String NombreDeProducto() {
        return _NombreDeProducto;
    }

    @Override
    public void NombreDeProducto(String NombreDeProducto) {
        _NombreDeProducto = NombreDeProducto;
    }
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Constructor">
    public void ClsVenta(){
        
    }
    public void ClsVenta(long NumeroDeVenta, long NumeroDeUsuario, long NumeroDeLote, long NumeroDeProducto, int Cantidad, double Precio, Date FechaDeVenta) {
        _NumeroDeVenta = NumeroDeVenta;
        _NumeroDeUsuario = NumeroDeUsuario;
        _NumeroDeLote = NumeroDeLote;
        _NumeroDeProducto = NumeroDeProducto;
        _Cantidad = Cantidad;
        _Precio = Precio;
        _FechaDeVenta = FechaDeVenta;
    }
    public void ClsVenta(long NumeroDeVenta, long NumeroDeUsuario, long NumeroDeLote, long NumeroDeProducto, int Cantidad, double Precio, Date FechaDeVenta, String NombreDeUsuario, String NombreDeProducto) {
        // Tabla
        _NumeroDeVenta = NumeroDeVenta;
        _NumeroDeUsuario = NumeroDeUsuario;
        _NumeroDeLote = NumeroDeLote;
        _NumeroDeProducto = NumeroDeProducto;
        _Cantidad = Cantidad;
        _Precio = Precio;
        _FechaDeVenta = FechaDeVenta;
        // Vista
        _NombreDeUsuario = NombreDeUsuario;
        _NombreDeProducto = NombreDeProducto;
    }
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Funciones">
    @Override
    public boolean Insert() {
        String sql = ToInsert();
        if(ClsConexionMySql.Transaccion(sql)){
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
    // <editor-fold defaultstate="collapsed" desc="Funciones constructores sql">
    @Override
    public String ToDelete() {
        String sql = "";
        sql = "delete from " + RelacionesVenta.Tabla.NombreTabla() + " where "
                + RelacionesVenta.NumeroDeVenta.Campo() + " = " + _NumeroDeVenta + " and "
                + RelacionesVenta.NumeroDeUsuario.Campo() + " = " + _NumeroDeUsuario + " and "
                + RelacionesVenta.NumeroDeLote.Campo() + " = " + _NumeroDeLote + " and "
                + RelacionesVenta.NumeroDeProducto.Campo() + " = " + _NumeroDeProducto;
        return sql;
    }

    @Override
    public String ToInsert() {
        String sql = "";
        sql = "insert into " + RelacionesVenta.Tabla.NombreTabla() + " ("
                + RelacionesVenta.NumeroDeVenta.Campo() + ","
                + RelacionesVenta.NumeroDeUsuario.Campo() + ","
                + RelacionesVenta.NumeroDeLote.Campo() + ","
                + RelacionesVenta.NumeroDeProducto.Campo() + ","
                + RelacionesVenta.Cantidad.Campo() + ","
                + RelacionesVenta.Precio.Campo() + ","
                + RelacionesVenta.FechaDeVenta.Campo() 
                + ") values ("
                + _NumeroDeVenta + ","
                + _NumeroDeUsuario + ","
                + _NumeroDeLote + ","
                + _NumeroDeProducto + ","
                + _Cantidad + ","
                + _Precio + ","
                + _FechaDeVenta + ")";
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
                sql = "update " + RelacionesVenta.Tabla.NombreTabla() + " set " + sql + " where "
                + RelacionesVenta.NumeroDeVenta.Campo() + " = " + _NumeroDeVenta + " and "
                + RelacionesVenta.NumeroDeUsuario.Campo() + " = " + _NumeroDeUsuario + " and "
                + RelacionesVenta.NumeroDeLote.Campo() + " = " + _NumeroDeLote + " and "
                + RelacionesVenta.NumeroDeProducto.Campo() + " = " + _NumeroDeProducto;
            }
        }
        return sql;
    }
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Relaciones">    
    public static class RelacionesVenta{
        public static ClsRelacionTabla Tabla = new ClsRelacionTabla("Venta","ViVenta","ven","Tabla de Ventas");
        public static ClsRelacion NumeroDeVenta = new ClsRelacion("NumeroDeVenta","ven_num_venta","Número de Venta","Numeric","4","0","NOT NULL","Número de la Venta");
        public static ClsRelacion NumeroDeUsuario = new ClsRelacion("NumeroDeUsuario","ven_num_usuario","Número de Usuario","Numeric","4","0","NOT NULL","Número de Usuario");
        public static ClsRelacion NumeroDeLote = new ClsRelacion("NumeroDeLote","ven_num_lote","Número de Lote","Numeric","4","0","NOT NULL","Número del Lote");
        public static ClsRelacion NumeroDeProducto = new ClsRelacion("NumeroDeProducto","ven_num_producto","Número de Producto","Numeric","4","0","NOT NULL","Número de Producto");
        public static ClsRelacion Cantidad = new ClsRelacion("Cantidad","ven_cantidad","Cantidad","Numeric","4","0","NOT NULL","Cantidad");
        public static ClsRelacion Precio = new ClsRelacion("Precio","ven_precio","Precio","Numeric","9","2","NOT NULL","Precio");
        public static ClsRelacion FechaDeVenta = new ClsRelacion("FechaDeVenta","ven_fecha_venta","Fecha de Venta","DateTime","0","0","NOT NULL","Fecha en que se realizo la venta");
        public static ClsRelacion NombreDeUsuario = new ClsRelacion("NombreDeUsuario","ven_nom_usuario","Nombre de Usuario","String","30","0","NULL","Nombre de Usuario");
        public static ClsRelacion NombreDeProducto = new ClsRelacion("NombreDeProducto","ven_nom_producto","Nombre de Producto","String","30","0","NULL","Nombre de Producto");
        public static ClsRelacion[] Estructura = {NumeroDeVenta,NumeroDeUsuario,NumeroDeLote,NumeroDeProducto,Cantidad,Precio,FechaDeVenta};
        public static String SqlVista = "CREATE VIEW " + Tabla.NombreVista() + " AS " +
                "SELECT " +
                NumeroDeVenta.Campo() + "," +
                NumeroDeUsuario.Campo() + "," +
                NumeroDeLote.Campo() + "," +
                NumeroDeProducto.Campo() + "," +
                Cantidad.Campo() + "," +
                Precio.Campo() + "," +
                FechaDeVenta.Campo() + "," +
                ClsUsuario.RelacionesUsuario.NombreDeUsuario.Campo() + " AS " + NombreDeUsuario.Campo() + "," +
                ClsProducto.RelacionesProducto.NombreDeProducto.Campo() + " AS " + NombreDeProducto.Campo() + " " +
                "FROM " + Tabla.NombreTabla() + " INNER JOIN " + ClsUsuario.RelacionesUsuario.Tabla.NombreTabla() + " ON (" + ClsUsuario.RelacionesUsuario.NumeroDeUsuario.Campo() + " = " + NumeroDeUsuario.Campo() + ") " +
                "INNER JOIN " + ClsProducto.RelacionesProducto.Tabla.NombreTabla() + " ON (" + ClsProducto.RelacionesProducto.NumeroDeProducto.Campo() + " = " + NumeroDeProducto.Campo() + ")";
        public static String Index = "CREATE UNIQUE INDEX PK_" +Tabla.NombreTabla() + " ON " 
                + Tabla.NombreTabla() + " (" + NumeroDeVenta.Campo()
                + "," + NumeroDeUsuario.Campo()
                + "," + NumeroDeLote.Campo()
                + "," + NumeroDeProducto.Campo() + ")";
    }
    // </editor-fold>
}
