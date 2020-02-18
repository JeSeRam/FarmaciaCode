/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import Clases.ClsRelacion;
import Clases.ClsRelacionTabla;
import ConexionMySql.ClsConexionMySql;
import Interfaces.IProductoSurtido;
import java.util.Date;
import java.util.Map;

/**
 *
 * @author Freak
 */
public class ClsProductoSurtido implements IProductoSurtido {
    // <editor-fold defaultstate="collapsed" desc="Variables de la Clase">
    // Tabla
    private long _NumeroDeProducto;
    private long _NumeroDeLote;
    private Date _FechaDeCaducidad;
    private int _NumeroDePiezas;
    private int _Entradas;
    private int _Salidas;
    private Date _FechaDeGeneracion;
    private int _Existentes;
    private int _CveEstatus;
    // Vista
    private String _NombreDeProducto;
    private String _TextoEstatus;
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Get & Set">
    // Tabla
    @Override
    public long NumeroDeProducto() {
        return _NumeroDeProducto;
    }

    @Override
    public void NumeroDeProducto(long NumeroDeProducto) {
        _NumeroDeProducto = NumeroDeProducto;
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
    public Date FechaDeCaducidad() {
        return _FechaDeCaducidad;
    }

    @Override
    public void FechaDeCaducidad(Date FechaDeCaducidad) {
        _FechaDeCaducidad = FechaDeCaducidad;
    }

    @Override
    public int NumeroDePiezas() {
        return _NumeroDePiezas;
    }

    @Override
    public void NumeroDePiezas(int NumeroDePiezas) {
        _NumeroDePiezas = NumeroDePiezas;
    }

    @Override
    public int Entradas() {
        return _Entradas;
    }

    @Override
    public void Entradas(int Entradas) {
        _Entradas = Entradas;
    }

    @Override
    public int Salidas() {
        return _Salidas;
    }

    @Override
    public void Salidas(int Salidas) {
        _Salidas = Salidas;
    }

    @Override
    public Date FechaDeGeneracion() {
        return _FechaDeGeneracion;
    }

    @Override
    public void FechaDeGeneracion(Date FechaDeGeneracion) {
        _FechaDeGeneracion = FechaDeGeneracion;
    }

    @Override
    public int Existentes() {
        return _Existentes;
    }

    @Override
    public void Existentes(int Existentes) {
        _Existentes = Existentes;
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
    public String TextoEstatus() {
        return _TextoEstatus;
    }

    @Override
    public void TextoEstatus(String TextoEstatus) {
        _TextoEstatus = TextoEstatus;
    }
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Constructor">
    public void ClsProductoSurtido(){
        
    }
    public void ClsProductoSuritdo(long NumeroDeProducto, long NumeroDeLote, Date FechaDeCaducidad, int NumeroDePiezas, int Entradas, int Salidas, Date FechaDeGeneracion, int Existentes, int CveEstatus) {
        _NumeroDeProducto = NumeroDeProducto;
        _NumeroDeLote = NumeroDeLote;
        _FechaDeCaducidad = FechaDeCaducidad;
        _NumeroDePiezas = NumeroDePiezas;
        _Entradas = Entradas;
        _Salidas = Salidas;
        _FechaDeGeneracion = FechaDeGeneracion;
        _Existentes = Existentes;
        _CveEstatus = CveEstatus;
    }
    public void ClsProductoSuritdo(long NumeroDeProducto, long NumeroDeLote, Date FechaDeCaducidad, int NumeroDePiezas, int Entradas, int Salidas, Date FechaDeGeneracion, int Existentes, int CveEstatus, String NombreDeProducto, String TextoEstatus) {
        _NumeroDeProducto = NumeroDeProducto;
        _NumeroDeLote = NumeroDeLote;
        _FechaDeCaducidad = FechaDeCaducidad;
        _NumeroDePiezas = NumeroDePiezas;
        _Entradas = Entradas;
        _Salidas = Salidas;
        _FechaDeGeneracion = FechaDeGeneracion;
        _Existentes = Existentes;
        _CveEstatus = CveEstatus;
        _NombreDeProducto = NombreDeProducto;
        _TextoEstatus = TextoEstatus;
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
        sql = "delete from " + RelacionesProcutoSurtido.Tabla.NombreTabla() + " where "
                + RelacionesProcutoSurtido.NumeroDeProducto.Campo() + " =  " + _NumeroDeProducto + " and "
                + RelacionesProcutoSurtido.NumeroDeLote.Campo() + " =  " + _NumeroDeLote;
        return sql;
    }

    @Override
    public String ToInsert() {   
        String sql = "";
        sql = "insert into " + RelacionesProcutoSurtido.Tabla.NombreTabla() + " ("
                + RelacionesProcutoSurtido.NumeroDeProducto.Campo() + ","
                + RelacionesProcutoSurtido.NumeroDeLote.Campo() + ","
                + RelacionesProcutoSurtido.FechaDeCaducidad.Campo() + ","
                + RelacionesProcutoSurtido.NumeroDePiezas.Campo() + ","
                + RelacionesProcutoSurtido.Entradas.Campo() + ","
                + RelacionesProcutoSurtido.Salidas.Campo() + ","
                + RelacionesProcutoSurtido.FechaDeGeneracion.Campo() + ","
                + RelacionesProcutoSurtido.Existentes.Campo() + ","
                + RelacionesProcutoSurtido.CveEstatus.Campo()
                + ") values ("
                + _NumeroDeProducto + ","
                + _NumeroDeLote + ","
                + _FechaDeCaducidad + ","
                + _NumeroDePiezas + ","
                + _Entradas + ","
                + _Salidas + ","
                + _FechaDeGeneracion + ","
                + _Existentes + ","
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
                sql = "update " + RelacionesProcutoSurtido.Tabla.NombreTabla() + " set " + sql + " where "
                + RelacionesProcutoSurtido.NumeroDeProducto.Campo() + " =  " + _NumeroDeProducto + " and "
                + RelacionesProcutoSurtido.NumeroDeLote.Campo() + " =  " + _NumeroDeLote;
            }
        }
        return sql;
    }
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Relaciones">
    public static class RelacionesProcutoSurtido {
        public static ClsRelacionTabla Tabla = new ClsRelacionTabla("ProductoSurtido","ViProductoSurtido", "prs", "Tabla de Surtido de Producto");
        public static ClsRelacion NumeroDeProducto = new ClsRelacion("NumeroDeProducto","prs_num_producto","Número de Producto","Numeric","4","0","NOT NULL","Número de producto");
        public static ClsRelacion NumeroDeLote = new ClsRelacion("NumeroDeLote","prs_num_lote","Número de Lote","Numeric","4","0","NOT NULL","Número de Lote");
        public static ClsRelacion FechaDeCaducidad = new ClsRelacion("FechaDeCaducidad","prs_fecha_caducidad","Fecha de Caducidad","DateTime","0","0","NOT NULL","Fecha de Caducidad del Producto");
        public static ClsRelacion NumeroDePiezas = new ClsRelacion("NumeroDePiezas","prs_num_piezas","Número de Piezas","Numeric","4","0","NOT NULL","Número de Piezas salientes");
        public static ClsRelacion Entradas = new ClsRelacion("Entradas","prs_entradas","Entradas","Numeric","4","0","NOT NULL","Entradas");
        public static ClsRelacion Salidas = new ClsRelacion("Salidas","prs_salidas","Salidas","Numeric","4","0","NOT NULL","Salidas");
        public static ClsRelacion FechaDeGeneracion = new ClsRelacion("FechaDeGeneracion","prs_fecha_generado","Fecha de Generacion","DateTime","0","0","NOT NULL","Fecha de Generacion del movimiento");
        public static ClsRelacion Existentes = new ClsRelacion("Existentes","prs_existentes","Existentes","Numeric","4","0","NOT NULL","Existentes");
        public static ClsRelacion CveEstatus = new ClsRelacion("CveEstatus","prs_cve_estatus","Estatus","Numeric","4","0","NOT NULL","Estatus");
        public static ClsRelacion NombreDeProducto = new ClsRelacion("NombreDeProducto","prs_nom_producto","Nombre de Producto","String","30","0","NULL","Nombre de producto");
        public static ClsRelacion TextoEstatus = new ClsRelacion("TextoEstatus","prs_txt_estatus","Estatus","String","30","0","NULL","Estatus");
        public static ClsRelacion[] Estructura = {NumeroDeProducto,NumeroDeLote,FechaDeCaducidad,NumeroDePiezas,Entradas,Salidas,FechaDeGeneracion,Existentes,CveEstatus};
        public static String SqlVista = "CREATE VIEW " + Tabla.NombreVista() + " AS " +
                "SELECT " +
                NumeroDeProducto.Campo() + "," +
                NumeroDeLote.Campo() + "," +
                FechaDeCaducidad.Campo() + "," +
                NumeroDePiezas.Campo() + "," +
                Entradas.Campo() + "," +
                Salidas.Campo() + "," +
                FechaDeGeneracion.Campo() + "," +
                Existentes.Campo() + "," +
                CveEstatus.Campo() + "," +
                ClsProducto.RelacionesProducto.NombreDeProducto.Campo() + " AS " + NombreDeProducto.Campo() + "," +
                "(SELECT " + ClsClave.RelacionesClave.NombreDeClave.Campo() + " FROM " + ClsClave.RelacionesClave.Tabla.NombreTabla() + " WHERE " + ClsClave.RelacionesClave.NumeroDeClave.Campo() + " = 1 AND " + ClsClave.RelacionesClave.SecuencialDeClave.Campo() + " = " + CveEstatus.Campo() + ") AS " + TextoEstatus.Campo() + " " +
                "FROM " + Tabla.NombreTabla() + " INNER JOIN " + ClsProducto.RelacionesProducto.Tabla.NombreTabla() + " ON (" + ClsProducto.RelacionesProducto.NumeroDeProducto.Campo() + " = " + NumeroDeProducto.Campo() + ")";
        public static String Index = "CREATE UNIQUE INDEX PK_" +Tabla.NombreTabla() + " ON " 
                + Tabla.NombreTabla() + " (" + NumeroDeProducto.Campo()
                + "," + NumeroDeLote.Campo() + ")";
    }
    // </editor-fold>
}
