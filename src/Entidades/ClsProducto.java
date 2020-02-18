/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import Clases.ClsRelacion;
import Clases.ClsRelacionTabla;
import ConexionMySql.ClsConexionMySql;
import ConexionMySql.ClsResultSet;
import Interfaces.IProducto;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Freak
 */
public class ClsProducto implements IProducto {
    // <editor-fold defaultstate="collapsed" desc="Variables de la Clase">
    // Tabla
    private long _NumeroDeProducto;
    private String _NombreDeProducto;
    private int _CveUnidadDeMedida;
    private String _CantidadDeMedida;
    private double _PrecioUnitario;
    private String _Descripcion;
    private int _CveAlertar;
    private int _CantidadAAlertar;
    private int _CveEstatus;
    // Vista
    private String _TextoUnidadDeMedida;
    private String _TextoAlertar;
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
    public String NombreDeProducto() {
        return _NombreDeProducto;
    }

    @Override
    public void NombreDeProducto(String NombreDeProducto) {
        _NombreDeProducto = NombreDeProducto;
    }
    
    @Override
    public int CveUnidadDeMedida(){
        return _CveUnidadDeMedida;
    }
    
    @Override
    public void CveUnidadDeMedida(int CveUnidadDeMedida){
        _CveUnidadDeMedida = CveUnidadDeMedida;
    }
    
    @Override
    public String CantidadDeMedida(){
        return _CantidadDeMedida;
    }
    
    @Override
    public void CantidadDeMedida(String CantidadDeMedida){
        _CantidadDeMedida = CantidadDeMedida;
    }

    @Override
    public double PrecioUnitario() {
        return _PrecioUnitario;
    }

    @Override
    public void PrecioUnitario(double PrecioUnitario) {
        _PrecioUnitario = PrecioUnitario;
    }

    @Override
    public String Descripcion() {
        return _Descripcion;
    }

    @Override
    public void Descripcion(String Descripcion) {
        _Descripcion = Descripcion;
    }

    @Override
    public int CveAlertar() {
        return _CveAlertar;
    }

    @Override
    public void CveAlertar(int CveAlertar) {
        _CveAlertar = CveAlertar;
    }

    @Override
    public int CantidadAAlertar() {
        return _CantidadAAlertar;
    }

    @Override
    public void CantidadAAlertar(int CantidadAAlertar) {
        _CantidadAAlertar = CantidadAAlertar;
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
    public String TextoUnidadDeMedida(){
        return _TextoUnidadDeMedida;
    }
    
    @Override
    public void TextoUnidadDeMedida(String TextoUnidadDeMedida){
        _TextoUnidadDeMedida = TextoUnidadDeMedida;
    }
    
    @Override
    public String TextoAlertar() {
        return _TextoAlertar;
    }

    @Override
    public void TextoAlertar(String TextoAlertar) {
        _TextoAlertar = TextoAlertar;
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
    public ClsProducto(){
        
    }
    public ClsProducto(long NumeroDeProducto, String NombreDeProducto,int CveUnidadDeMedida,String CantidadDeMedida, double PrecioUnitario, String Descripcion, int CveAlertar, int CantidadAAlertar, int CveEstatus) {
        _NumeroDeProducto = NumeroDeProducto;
        _NombreDeProducto = NombreDeProducto;
        _CveUnidadDeMedida = CveUnidadDeMedida;
        _CantidadDeMedida = CantidadDeMedida;
        _PrecioUnitario = PrecioUnitario;
        _Descripcion = Descripcion;
        _CveAlertar = CveAlertar;
        _CantidadAAlertar = CantidadAAlertar;
        _CveEstatus = CveEstatus;
    }
    public ClsProducto(long NumeroDeProducto, String NombreDeProducto,int CveUnidadDeMedida,String CantidadDeMedida, double PrecioUnitario, String Descripcion, int CveAlertar, int CantidadAAlertar, int CveEstatus,String TextoUnidadDeMedida, String TextoAlertar, String TextoEstatus) {
        // Tabla
        _NumeroDeProducto = NumeroDeProducto;
        _NombreDeProducto = NombreDeProducto;
        _CveUnidadDeMedida = CveUnidadDeMedida;
        _CantidadDeMedida = CantidadDeMedida;
        _PrecioUnitario = PrecioUnitario;
        _Descripcion = Descripcion;
        _CveAlertar = CveAlertar;
        _CantidadAAlertar = CantidadAAlertar;
        _CveEstatus = CveEstatus;
        // Vista
        _TextoUnidadDeMedida = TextoUnidadDeMedida;
        _TextoAlertar = TextoAlertar;
        _TextoEstatus = TextoEstatus;
    }
    public ClsProducto(ClsResultSet Rec, boolean CamposVista){
        if(CamposVista){
            EstableceValores(
                    Long.parseLong(Rec.Campo(RelacionesProducto.NumeroDeProducto.Campo()).toString()),
                    "" + Rec.Campo(RelacionesProducto.NombreDeProducto.Campo()),
                    Integer.parseInt(Rec.Campo(RelacionesProducto.CveUnidadDeMedida.Campo()).toString()),
                    "" + Rec.Campo(RelacionesProducto.CantidadDeMedida.Campo()),
                    Double.parseDouble(Rec.Campo(RelacionesProducto.PrecioUnitario.Campo()).toString()),
                    "" + Rec.Campo(RelacionesProducto.Descripcion.Campo()),
                    Integer.parseInt(Rec.Campo(RelacionesProducto.CveAlertar.Campo()).toString()),
                    Integer.parseInt(Rec.Campo(RelacionesProducto.CantidadAAlertar.Campo()).toString()),
                    Integer.parseInt(Rec.Campo(RelacionesProducto.CveEstatus.Campo()).toString()),
                    "" + Rec.Campo(RelacionesProducto.TextoUnidadDeMedida.Campo()),
                    "" + Rec.Campo(RelacionesProducto.TextoAlertar.Campo()),
                    "" + Rec.Campo(RelacionesProducto.TextoEstatus.Campo()));
        }else{
            EstableceValores(
                    Long.parseLong(Rec.Campo(RelacionesProducto.NumeroDeProducto.Campo()).toString()),
                    "" + Rec.Campo(RelacionesProducto.NombreDeProducto.Campo()),
                    Integer.parseInt(Rec.Campo(RelacionesProducto.CveUnidadDeMedida.Campo()).toString()),
                    "" + Rec.Campo(RelacionesProducto.CantidadDeMedida.Campo()),
                    Double.parseDouble(Rec.Campo(RelacionesProducto.PrecioUnitario.Campo()).toString()),
                    "" + Rec.Campo(RelacionesProducto.Descripcion.Campo()),
                    Integer.parseInt(Rec.Campo(RelacionesProducto.CveAlertar.Campo()).toString()),
                    Integer.parseInt(Rec.Campo(RelacionesProducto.CantidadAAlertar.Campo()).toString()),
                    Integer.parseInt(Rec.Campo(RelacionesProducto.CveEstatus.Campo()).toString()),
                    "",
                    "",
                    "");
        }
    }
    public void EstableceValores(long NumeroDeProducto, String NombreDeProducto,int CveUnidadDeMedida,String CantidadDeMedida, double PrecioUnitario, String Descripcion, int CveAlertar, int CantidadAAlertar, int CveEstatus,String TextoUnidadDeMedida, String TextoAlertar, String TextoEstatus){
        if (!TextoAlertar.equals("") && !TextoEstatus.equals("") && !TextoUnidadDeMedida.equals("")){
        // Vista
        _TextoUnidadDeMedida = TextoUnidadDeMedida; 
        _TextoAlertar = TextoAlertar;
        _TextoEstatus = TextoEstatus;
        }
        // Tabla
        _NumeroDeProducto = NumeroDeProducto;
        _NombreDeProducto = NombreDeProducto;
        _CveUnidadDeMedida = CveUnidadDeMedida;
        _CantidadDeMedida = CantidadDeMedida;
        _PrecioUnitario = PrecioUnitario;
        _Descripcion = Descripcion;
        _CveAlertar = CveAlertar;
        _CantidadAAlertar = CantidadAAlertar;
        _CveEstatus = CveEstatus;
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
        sql = "delete from " + RelacionesProducto.Tabla.NombreTabla() + " where "
                + RelacionesProducto.NumeroDeProducto.Campo() + " =  " + _NumeroDeProducto;
        return sql;
    }

    @Override
    public String ToInsert() {        
        String sql = "";
        sql = "insert into " + RelacionesProducto.Tabla.NombreTabla() + " ("
                + RelacionesProducto.NumeroDeProducto.Campo() + ","
                + RelacionesProducto.NombreDeProducto.Campo() + ","
                + RelacionesProducto.CveUnidadDeMedida.Campo() + ","
                + RelacionesProducto.CantidadDeMedida.Campo() + ","
                + RelacionesProducto.PrecioUnitario.Campo() + ","
                + RelacionesProducto.Descripcion.Campo() + ","
                + RelacionesProducto.CveAlertar.Campo() + ","
                + RelacionesProducto.CantidadAAlertar.Campo() + ","
                + RelacionesProducto.CveEstatus.Campo()
                + ") values ("
                + _NumeroDeProducto + ","
                + "'" + _NombreDeProducto + "',"
                + _CveUnidadDeMedida + ","
                + "'" + _CantidadDeMedida + "',"
                + _PrecioUnitario + ","
                + "'" + _Descripcion + "',"
                + _CveAlertar + ","
                + _CantidadAAlertar + ","
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
                sql = "update " + RelacionesProducto.Tabla.NombreTabla() + " set " + sql + " where "
                        + RelacionesProducto.NumeroDeProducto.Campo() + " = " + _NumeroDeProducto;
            }
        }
        return sql;
    }
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Relaciones">
    public static class RelacionesProducto {
        public static ClsRelacionTabla Tabla = new ClsRelacionTabla("Producto","ViProducto", "pro", "Tabla de Productos");
        public static ClsRelacion NumeroDeProducto = new ClsRelacion("NumeroDeProducto", "pro_num_producto", "Codigo de Barras / Numero de Producto","Numeric","4","0","NOT NULL","Numero de Producto");
        public static ClsRelacion NombreDeProducto = new ClsRelacion("NombreDeProducto", "pro_nom_producto", "Nombre de Producto","String","30","0","NOT NULL","Nombre de Producto");
        public static ClsRelacion CveUnidadDeMedida = new ClsRelacion("CveUnidadDeMedida","pro_unidad_medida","Cantidad de Medida","Numeric","4","0","NOT NULL","Identificador de Unidad de Medida");
        public static ClsRelacion CantidadDeMedida = new ClsRelacion("CantidadDeMedida","pro_cantidad_medida"," Número de Cantidad de Medida","String","50","0","NOT NULL","Identificador de Unidad de Medida");
        public static ClsRelacion PrecioUnitario = new ClsRelacion("PrecioUnitario","pro_precio_unitario","Precio Unitario","Numeric","9","2","NOT NULL","Precio Unitario");
        public static ClsRelacion Descripcion = new ClsRelacion("Descripcion", "pro_descipcion", "Descripción","Numeric","4","0","NOT NULL","Descripción");
        public static ClsRelacion CveAlertar = new ClsRelacion("CveAlertar", "pro_cve_alertar", "Alertar","Numeric","4","0","NOT NULL","Alertar");
        public static ClsRelacion CantidadAAlertar = new ClsRelacion("CantidadAAlertar", "pro_cantidad_alertar", "Cantidad a Alertar","Numeric","4","0","NOT NULL","Cantidad a Alertar");
        public static ClsRelacion CveEstatus = new ClsRelacion("CveEstatus", "pro_cve_estatus", "Estatus","Numeric","4","0","NOT NULL","Identificador de estatus de las claves");
        public static ClsRelacion TextoUnidadDeMedida = new ClsRelacion("TextoUnidadDeMedida","pro_txt_unidad_medida","Cantidad de Medida","String","30","0","NOT NULL","Identificador de Unidad de Medida");
        public static ClsRelacion TextoAlertar = new ClsRelacion("TextoAlertar", "pro_txt_alertar", "Alertar","String","30","0","NULL","Identificador de alertar o no");
        public static ClsRelacion TextoEstatus = new ClsRelacion("TextoEstatus", "pro_txt_estatus", "Estatus","String","30","0","NULL","Identificador de estatus de las claves");
        public static List<ClsRelacion> CamposQueSeMuestranEnTabla = Arrays.asList(NumeroDeProducto,NombreDeProducto,Descripcion,PrecioUnitario,CantidadAAlertar,TextoAlertar,TextoEstatus);
        public static ClsRelacion[] Estructura = {NumeroDeProducto,NombreDeProducto,CveUnidadDeMedida,CantidadDeMedida,PrecioUnitario,Descripcion,CveAlertar,CantidadAAlertar,CveEstatus};
        public static String SqlVista = "CREATE VIEW " + Tabla.NombreVista() + " AS " +
                "SELECT " +
                NumeroDeProducto.Campo() + "," +
                NombreDeProducto.Campo() + "," +
                CveUnidadDeMedida.Campo() + "," +
                CantidadDeMedida.Campo() + "," +
                PrecioUnitario.Campo() + "," +
                Descripcion.Campo() + "," +
                CveAlertar.Campo() + "," +
                CantidadAAlertar.Campo() + "," +
                CveEstatus.Campo() + "," +
                "(SELECT " + ClsClave.RelacionesClave.NombreDeClave.Campo() + " FROM " + ClsClave.RelacionesClave.Tabla.NombreTabla() + " WHERE " + ClsClave.RelacionesClave.NumeroDeClave.Campo() + " = 7 AND " + ClsClave.RelacionesClave.SecuencialDeClave.Campo() + " = " + CveUnidadDeMedida.Campo() + ") AS " + TextoUnidadDeMedida.Campo() + "," +
                "(SELECT " + ClsClave.RelacionesClave.NombreDeClave.Campo() + " FROM " + ClsClave.RelacionesClave.Tabla.NombreTabla() + " WHERE " + ClsClave.RelacionesClave.NumeroDeClave.Campo() + " = 3 AND " + ClsClave.RelacionesClave.SecuencialDeClave.Campo() + " = " + CveAlertar.Campo() + ") AS " + TextoAlertar.Campo() + "," +
                "(SELECT " + ClsClave.RelacionesClave.NombreDeClave.Campo() + " FROM " + ClsClave.RelacionesClave.Tabla.NombreTabla() + " WHERE " + ClsClave.RelacionesClave.NumeroDeClave.Campo() + " = 1 AND " + ClsClave.RelacionesClave.SecuencialDeClave.Campo() + " = " + CveEstatus.Campo() + ") AS " + TextoEstatus.Campo() + " " +
                "FROM " + Tabla.NombreTabla();
        public static String Index = "CREATE UNIQUE INDEX PK_" +Tabla.NombreTabla() + " ON " 
                + Tabla.NombreTabla() + " (" + NumeroDeProducto.Campo() + ")";
    }
    // </editor-fold>
}
