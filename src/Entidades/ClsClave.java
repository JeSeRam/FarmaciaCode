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
import Interfaces.IClave;
import java.util.Map;

/**
 *
 * @author Freak
 */
public class ClsClave implements IClave {
    // <editor-fold defaultstate="collapsed" desc="Variables de la Clase">
    // Tabla
    private long _NumeroDeClave;
    private int _SecuencialDeClave;
    private String _NombreDeClave;
    private String _Descripcion;
    private String _DatoAdicional1;
    private String _DatoAdicional2;
    private int _CveEstatus;
    // Vista
    private String _TextoEstatus;
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Get & Set">
    // Tabla
    @Override
    public long NumeroDeClave() {
        return _NumeroDeClave;
    }

    @Override
    public void NumeroDeClave(long NumeroDeClave) {
        _NumeroDeClave = NumeroDeClave;
    }

    @Override
    public int SecuencialDeClave() {
        return _SecuencialDeClave;
    }

    @Override
    public void SecuencialDeClave(int SecuencialDeClave) {
        _SecuencialDeClave = SecuencialDeClave;
    }

    @Override
    public String NombreDeClave() {
        return _NombreDeClave;
    }

    @Override
    public void NombreDeClave(String NombreDeClave) {
        _NombreDeClave = NombreDeClave;
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
    public String DatoAdicional1() {
        return _DatoAdicional1;
    }

    @Override
    public void DatoAdicional1(String DatoAdicional1) {
        _DatoAdicional1 = DatoAdicional1;
    }

    @Override
    public String DatoAdicional2() {
        return _DatoAdicional2;
    }

    @Override
    public void DatoAdicional2(String DatoAdicional2) {
        _DatoAdicional2 = DatoAdicional2;
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
    public String TextoEstatus() {
        return _TextoEstatus;
    }

    @Override
    public void TextoEstatus(String TextoEstatus) {
        _TextoEstatus = TextoEstatus;
    }
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Constructor">
    public ClsClave(){
        
    }
    public ClsClave(long NumeroDeClave,int SecuencialDeClave,String NombreDeClave, String Descripcion,String DatoAdicional1, String DatoAdicional2,int CveEstatus){
        _NumeroDeClave = NumeroDeClave;
        _SecuencialDeClave = SecuencialDeClave;
        _NombreDeClave = NombreDeClave;
        _Descripcion = Descripcion;
        _DatoAdicional1 = DatoAdicional1;
        _DatoAdicional2 = DatoAdicional2;
        _CveEstatus = CveEstatus;
    }
    public ClsClave(long NumeroDeClave,int SecuencialDeClave,String NombreDeClave, String Descripcion,String DatoAdicional1, String DatoAdicional2,int CveEstatus,String TextoEstatus){
        // Tabla
        _NumeroDeClave = NumeroDeClave;
        _SecuencialDeClave = SecuencialDeClave;
        _NombreDeClave = NombreDeClave;
        _Descripcion = Descripcion;
        _DatoAdicional1 = DatoAdicional1;
        _DatoAdicional2 = DatoAdicional2;
        _CveEstatus = CveEstatus;
        // Vista
        _TextoEstatus = TextoEstatus;
    }
    public ClsClave(ClsResultSet Rec, boolean CamposVista){
        if(CamposVista){
            EstableceValores(
                    Long.parseLong(Rec.Campo(RelacionesClave.NumeroDeClave.Campo()).toString()),
                    Integer.parseInt(Rec.Campo(RelacionesClave.SecuencialDeClave.Campo()).toString()),
                    (String) Rec.Campo(RelacionesClave.NombreDeClave.Campo()),
                    (String) Rec.Campo(RelacionesClave.Descripcion.Campo()),
                    (String) Rec.Campo(RelacionesClave.DatoAdicional1.Campo()),
                    (String) Rec.Campo(RelacionesClave.DatoAdicional2.Campo()),
                    Integer.parseInt(Rec.Campo(RelacionesClave.CveEstatus.Campo()).toString()),
                    (String) Rec.Campo(RelacionesClave.TextoEstatus.Campo()));
        }else{
            EstableceValores(
                    Long.parseLong(Rec.Campo(RelacionesClave.NumeroDeClave.Campo()).toString()),
                    Integer.parseInt(Rec.Campo(RelacionesClave.SecuencialDeClave.Campo()).toString()),
                    (String) Rec.Campo(RelacionesClave.NombreDeClave.Campo()),
                    (String) Rec.Campo(RelacionesClave.Descripcion.Campo()),
                    (String) Rec.Campo(RelacionesClave.DatoAdicional1.Campo()),
                    (String) Rec.Campo(RelacionesClave.DatoAdicional2.Campo()),
                    Integer.parseInt(Rec.Campo(RelacionesClave.CveEstatus.Campo()).toString()),
                    "");
        }
    }
    public void EstableceValores(long NumeroDeClave,int SecuencialDeClave,String NombreDeClave, String Descripcion,String DatoAdicional1, String DatoAdicional2,int CveEstatus,String TextoEstatus){
        if (!TextoEstatus.equals("")){
        // Vista
        _TextoEstatus = TextoEstatus;
        }
        // Tabla
        _NumeroDeClave = NumeroDeClave;
        _SecuencialDeClave = SecuencialDeClave;
        _NombreDeClave = NombreDeClave;
        _Descripcion = Descripcion;
        _DatoAdicional1 = DatoAdicional1;
        _DatoAdicional2 = DatoAdicional2;
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
    public String ToInsert() {
        String sql = "";
        sql = "insert into " + RelacionesClave.Tabla.NombreTabla() + " ("
                + RelacionesClave.NumeroDeClave.Campo() + ","
                + RelacionesClave.SecuencialDeClave.Campo() + ","
                + RelacionesClave.NombreDeClave.Campo() + ","
                + RelacionesClave.Descripcion.Campo() + ","
                + RelacionesClave.DatoAdicional1.Campo() + ","
                + RelacionesClave.DatoAdicional2.Campo() + ","
                + RelacionesClave.CveEstatus.Campo()
                + ") values ("
                + _NumeroDeClave + ","
                + _SecuencialDeClave + ","
                + _NombreDeClave + ","
                + _Descripcion + ","
                + _DatoAdicional1 + ","
                + _DatoAdicional2 + ","
                + _CveEstatus + ")";
        return sql;
    }

    @Override
    public String ToDelete() {
        String sql = "";
        sql = "delete from " + RelacionesClave.Tabla.NombreTabla() + " where "
                + RelacionesClave.NumeroDeClave.Campo() + " =  " + _NumeroDeClave + " and "
                + RelacionesClave.SecuencialDeClave.Campo() + " = " + _SecuencialDeClave;
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
                sql = "update " + RelacionesClave.Tabla.NombreTabla() + " set " + sql + " where "
                        + RelacionesClave.NumeroDeClave.Campo() + " = " + _NumeroDeClave + " and "
                        + RelacionesClave.SecuencialDeClave.Campo() + " = " + _SecuencialDeClave;
            }
        }
        return sql;
    }
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Relaciones">
    public static class RelacionesClave {
        public static ClsRelacionTabla Tabla = new ClsRelacionTabla("Clave","ViClave", "cve", "Tabla de claves");
        public static ClsRelacion NumeroDeClave = new ClsRelacion("NumeroDeClave", "cve_num_clave", "Numero de Clave","Numeric","4","0","NOT NULL","Identificador de numero de clave");
        public static ClsRelacion SecuencialDeClave = new ClsRelacion("SecuencialDeClave", "cve_sec_clave", "Numero secuencial de clave","Numeric","4","0","NOT NULL","Identificador de numero secuencial de clave");
        public static ClsRelacion NombreDeClave = new ClsRelacion("NombreDeClave", "cve_nom_clave", "Nombre de clave","String","150","0","NOT NULL","Nombre de clave");
        public static ClsRelacion Descripcion = new ClsRelacion("Descripcion", "cve_descipcion", "Descripcion","String","150","0","NOT NULL","Descripcion de clave");
        public static ClsRelacion DatoAdicional1 = new ClsRelacion("DatoAdicional1", "cve_dato_adic1", "Dato uno (opcional)","String","150","0","NULL","Dato adicional uno de claves");
        public static ClsRelacion DatoAdicional2 = new ClsRelacion("DatoAdicional2", "cve_dato_adic2", "Dato dos (opcional)","String","150","0","NULL","Dato adicional dos de claves");
        public static ClsRelacion CveEstatus = new ClsRelacion("CveEstatus", "cve_cve_estatus", "Estatus","Numeric","4","0","NOT NULL","Identificador de estatus de las claves");
        public static ClsRelacion TextoEstatus = new ClsRelacion("TextoEstatus", "cve_txt_estatus", "Estatus","String","30","0","NULL","Identificador de estatus de las claves");
        public static ClsRelacion[] Estructura = {NumeroDeClave,SecuencialDeClave,NombreDeClave,Descripcion,DatoAdicional1,DatoAdicional2,CveEstatus};
        public static String SqlVista = "CREATE VIEW " + Tabla.NombreVista() + " AS " +
                "SELECT " +
                NumeroDeClave.Campo() + "," +
                SecuencialDeClave.Campo() + "," +
                NombreDeClave.Campo() + "," +
                Descripcion.Campo() + "," +
                DatoAdicional1.Campo() + "," +
                DatoAdicional2.Campo() + "," +
                CveEstatus.Campo() + "," +
                "(SELECT " + ClsClave.RelacionesClave.NombreDeClave.Campo() + " FROM " + ClsClave.RelacionesClave.Tabla.NombreTabla() + " WHERE " + ClsClave.RelacionesClave.NumeroDeClave.Campo() + " = 1 AND " + ClsClave.RelacionesClave.SecuencialDeClave.Campo() + " = " + Tabla.Prefijo() + "." + CveEstatus.Campo() + ") AS " + TextoEstatus.Campo() + " " +
                "FROM " + Tabla.NombreTabla() + " " + Tabla.Prefijo();
        public static String Index = "CREATE UNIQUE INDEX PK_" +Tabla.NombreTabla() + " ON " 
                + Tabla.NombreTabla() + " (" + NumeroDeClave.Campo() + "," + SecuencialDeClave.Campo() + ")";
    }
    // </editor-fold>
}
