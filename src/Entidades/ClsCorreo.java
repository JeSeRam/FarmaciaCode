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
import Interfaces.ICorreo;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Freak
 */
public final class ClsCorreo implements ICorreo {
    // <editor-fold defaultstate="collapsed" desc="Variables de la Clase">
    // Tabla
    private long _NumeroDeCorreo;
    private int _CveTipoDeCorreo;
    private String _Correo;
    private int _CveEstatus;
    // Vista
    private String _TextoTipoDeCorreo;
    private String _TextoEstatus;
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Get & Set">
    // Tabla
    @Override
    public long NumeroDeCorreo() {
        return _NumeroDeCorreo;
    }

    @Override
    public void NumeroDeCorreo(long NumeroDeCorreo) {
        _NumeroDeCorreo = NumeroDeCorreo;
    }

    @Override
    public int CveTipoDeCorreo() {
        return _CveTipoDeCorreo;
    }

    @Override
    public void CveTipoDeCorreo(int CveTipoDeCorreo) {
        _CveTipoDeCorreo = CveTipoDeCorreo;
    }

    @Override
    public String Correo() {
        return _Correo;
    }

    @Override
    public void Correo(String Correo) {
        _Correo = Correo;
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
    public String TextoTipoDeCorreo() {
        return _TextoTipoDeCorreo;
    }

    @Override
    public void TextoTipoDeCorreo(String TextoTipoDeCorreo) {
        _TextoTipoDeCorreo = TextoTipoDeCorreo;
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
    public ClsCorreo(){
        
    }
    public ClsCorreo(long NumeroDeCorreo, int CveTipoDeCorreo, String Correo, int CveEstatus) {
        _NumeroDeCorreo = NumeroDeCorreo;
        _CveTipoDeCorreo = CveTipoDeCorreo;
        _Correo = Correo;
        _CveEstatus = CveEstatus;
    }
    public ClsCorreo(long NumeroDeCorreo, int CveTipoDeCorreo, String Correo, int CveEstatus, String TextoTipoDeCorreo, String TextoEstatus) {
        _NumeroDeCorreo = NumeroDeCorreo;
        _CveTipoDeCorreo = CveTipoDeCorreo;
        _Correo = Correo;
        _CveEstatus = CveEstatus;
        _TextoTipoDeCorreo = TextoTipoDeCorreo;
        _TextoEstatus = TextoEstatus;
    }
    public ClsCorreo(ClsResultSet Rec, boolean CamposVista){
        if(CamposVista){
            EstableceValores(
                    Long.parseLong(Rec.Campo(RelacionesCorreo.NumeroDeCorreo.Campo()).toString()),
                    Integer.parseInt(Rec.Campo(RelacionesCorreo.CveTipoDeCorreo.Campo()).toString()),
                    (String) Rec.Campo(RelacionesCorreo.Correo.Campo()),
                    Integer.parseInt(Rec.Campo(RelacionesCorreo.CveEstatus.Campo()).toString()),
                    (String) Rec.Campo(RelacionesCorreo.TextoTipoDeCorreo.Campo()),
                    (String) Rec.Campo(RelacionesCorreo.TextoEstatus.Campo()));
        }else{
            EstableceValores(
                    Long.parseLong(Rec.Campo(RelacionesCorreo.NumeroDeCorreo.Campo()).toString()),
                    Integer.parseInt(Rec.Campo(RelacionesCorreo.CveTipoDeCorreo.Campo()).toString()),
                    (String) Rec.Campo(RelacionesCorreo.Correo.Campo()),
                    Integer.parseInt(Rec.Campo(RelacionesCorreo.CveEstatus.Campo()).toString()),
                    "",
                    "");
        }
    }
    public void EstableceValores(long NumeroDeCorreo, int CveTipoDeCorreo, String Correo, int CveEstatus, String TextoTipoDeCorreo, String TextoEstatus){
        if (!TextoTipoDeCorreo.equals("") && !TextoEstatus.equals("")){
        // Vista
        _TextoTipoDeCorreo = TextoTipoDeCorreo;
        _TextoEstatus = TextoEstatus;
        }
        // Tabla
        _NumeroDeCorreo = NumeroDeCorreo;
        _CveTipoDeCorreo = CveTipoDeCorreo;
        _Correo = Correo;
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
    // <editor-fold defaultstate="collapsed" desc="Funciones construcotres sql">
    @Override
    public String ToDelete() {
        String sql = "";
        sql = "delete from " + RelacionesCorreo.Tabla.NombreTabla() + " where "
                + RelacionesCorreo.NumeroDeCorreo.Campo() + " =  " + _NumeroDeCorreo + " and "
                + RelacionesCorreo.CveTipoDeCorreo.Campo() + " = " + _CveTipoDeCorreo;
        return sql;
    }

    @Override
    public String ToInsert() {
        String sql = "";
        sql = "insert into " + RelacionesCorreo.Tabla.NombreTabla() + " ("
                + RelacionesCorreo.NumeroDeCorreo.Campo() + ","
                + RelacionesCorreo.CveTipoDeCorreo.Campo() + ","
                + RelacionesCorreo.Correo.Campo() + ","
                + RelacionesCorreo.CveEstatus.Campo()
                + ") values ("
                + _NumeroDeCorreo + ","
                + _CveTipoDeCorreo + ","
                + "'" + _Correo + "',"
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
                sql = "update " + RelacionesCorreo.Tabla.NombreTabla() + " set " + sql + " where "
                + RelacionesCorreo.NumeroDeCorreo.Campo() + " =  " + _NumeroDeCorreo + " and "
                + RelacionesCorreo.CveTipoDeCorreo.Campo() + " = " + _CveTipoDeCorreo;
            }
        }
        return sql;
    }
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Relaciones">
    public static class RelacionesCorreo {
        public static ClsRelacionTabla Tabla = new ClsRelacionTabla("Correo","ViCorreo", "cor", "Tabla de correo");
        public static ClsRelacion NumeroDeCorreo = new ClsRelacion("NumeroDeCorreo", "cor_num_correo", "Número de Correo","Numeric","4","0","NOT NULL","Identificador de número de correo");
        public static ClsRelacion CveTipoDeCorreo = new ClsRelacion("CveTipoDeCorreo", "cor_cve_tipo_correo", "Tipo de correo","Numeric","4","0","NOT NULL","Tipo de correo");
        public static ClsRelacion Correo = new ClsRelacion("Correo", "cor_correo", "Correo","String","250","0","NOT NULL","Correo");
        public static ClsRelacion CveEstatus = new ClsRelacion("CveEstatus", "cor_cve_estatus", "Estatus","Numeric","4","0","NOT NULL","Identificador de estatus de las claves");
        public static ClsRelacion TextoTipoDeCorreo = new ClsRelacion("TextoTipoDeCorreo", "cor_txt_tipo_correo", "Tipo de correo","String","30","0","NULL","Tipo de correo");
        public static ClsRelacion TextoEstatus = new ClsRelacion("TextoEstatus", "cor_txt_estatus", "Estatus","String","30","0","NULL","Identificador de estatus de las claves");
        public static List<ClsRelacion> CamposQueSeMuestranEnTabla = Arrays.asList(NumeroDeCorreo,TextoTipoDeCorreo,Correo,TextoEstatus);
        public static ClsRelacion[] Estructura = {NumeroDeCorreo,CveTipoDeCorreo,Correo,CveEstatus};
        public static String SqlVista = "CREATE VIEW " + Tabla.NombreVista() + " AS " +
                "SELECT " +
                NumeroDeCorreo.Campo() + "," +
                CveTipoDeCorreo.Campo() + "," +
                Correo.Campo() + "," +
                CveEstatus.Campo() + "," +
                "(SELECT " + ClsClave.RelacionesClave.NombreDeClave.Campo() + " FROM " + ClsClave.RelacionesClave.Tabla.NombreTabla() + " WHERE " + ClsClave.RelacionesClave.NumeroDeClave.Campo() + " = 5 AND " + ClsClave.RelacionesClave.SecuencialDeClave.Campo() + " = " + CveTipoDeCorreo.Campo() + ") AS " + TextoTipoDeCorreo.Campo() + "," +
                "(SELECT " + ClsClave.RelacionesClave.NombreDeClave.Campo() + " FROM " + ClsClave.RelacionesClave.Tabla.NombreTabla() + " WHERE " + ClsClave.RelacionesClave.NumeroDeClave.Campo() + " = 1 AND " + ClsClave.RelacionesClave.SecuencialDeClave.Campo() + " = " + CveEstatus.Campo() + ") AS " + TextoEstatus.Campo() + " " +
                "FROM " + Tabla.NombreTabla();
        public static String Index = "CREATE UNIQUE INDEX PK_" +Tabla.NombreTabla() + " ON " 
                + Tabla.NombreTabla() + " (" + CveTipoDeCorreo.Campo() + "," + Correo.Campo() + ")";
    }
    // </editor-fold>
}
