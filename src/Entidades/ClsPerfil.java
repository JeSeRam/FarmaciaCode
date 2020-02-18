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
import Interfaces.IPerfil;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Freak
 */
public class ClsPerfil implements IPerfil {
    // <editor-fold defaultstate="collapsed" desc="Variables de la Clase">
    // Tabla
    private long _NumeroDePerfil;
    private String _NombreDePerfil;
    private int _CveEstatus;
    // Vista
    private String _TextoEstatus;
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Get & Set">
    // Tabla
    @Override
    public long NumeroDePerfil() {
        return _NumeroDePerfil;
    }

    @Override
    public void NumeroDePerfil(long NumeroDePerfil) {
        _NumeroDePerfil = NumeroDePerfil;
    }

    @Override
    public String NombreDePerfil() {
        return _NombreDePerfil;
    }

    @Override
    public void NombreDePerfil(String NombreDePerfil) {
        _NombreDePerfil = NombreDePerfil;
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
    public ClsPerfil() {
        
    }
    public ClsPerfil(long NumeroDePerfil, String NombreDePerfil, int CveEstatus) {
        _NumeroDePerfil = NumeroDePerfil;
        _NombreDePerfil = NombreDePerfil;
        _CveEstatus = CveEstatus;
    }
    public ClsPerfil(long NumeroDePerfil, String NombreDePerfil, int CveEstatus, String TextoEstatus) {
        // Tabla
        _NumeroDePerfil = NumeroDePerfil;
        _NombreDePerfil = NombreDePerfil;
        _CveEstatus = CveEstatus;
        // Vista
        _TextoEstatus = TextoEstatus;
    }
    public ClsPerfil(ClsResultSet Rec, boolean CamposVista){
        if(CamposVista){
            EstableceValores(
                    Long.parseLong(Rec.Campo(RelacionesPerfil.NumeroDePerfil.Campo()).toString()),
                    (String) Rec.Campo(RelacionesPerfil.NombreDePerfil.Campo()),
                    Integer.parseInt(Rec.Campo(RelacionesPerfil.CveEstatus.Campo()).toString()),
                    (String) Rec.Campo(RelacionesPerfil.TextoEstatus.Campo()));
        }else{
            EstableceValores(
                    Long.parseLong(Rec.Campo(RelacionesPerfil.NumeroDePerfil.Campo()).toString()),
                    (String) Rec.Campo(RelacionesPerfil.NombreDePerfil.Campo()),
                    Integer.parseInt(Rec.Campo(RelacionesPerfil.CveEstatus.Campo()).toString()),
                    "");
        }
    }
    public void EstableceValores(long NumeroDePerfil, String NombreDePerfil, int CveEstatus, String TextoEstatus){
        if (!TextoEstatus.equals("")){
        // Vista
        _TextoEstatus = TextoEstatus;
        }
        // Tabla
        _NumeroDePerfil = NumeroDePerfil;
        _NombreDePerfil = NombreDePerfil;
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
        sql = "delete from " + RelacionesPerfil.Tabla.NombreTabla() + " where "
                + RelacionesPerfil.NumeroDePerfil.Campo() + " =  " + _NumeroDePerfil;
        return sql;
    }

    @Override
    public String ToInsert() {
        String sql = "";
        sql = "insert into " + RelacionesPerfil.Tabla.NombreTabla() + " ("
                + RelacionesPerfil.NumeroDePerfil.Campo() + ","
                + RelacionesPerfil.NombreDePerfil.Campo() + ","
                + RelacionesPerfil.CveEstatus.Campo()
                + ") values ("
                + _NumeroDePerfil + ","
                + _NombreDePerfil + ","
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
                sql = "update " + RelacionesPerfil.Tabla.NombreTabla() + " set " + sql + " where "
                        + RelacionesPerfil.NumeroDePerfil.Campo() + " = " + _NumeroDePerfil;
            }
        }
        return sql;
    }
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Relaciones">
    public static class RelacionesPerfil {
        public static ClsRelacionTabla Tabla = new ClsRelacionTabla("Perfil","ViPerfil", "per", "Tabla de Perfiles");
        public static ClsRelacion NumeroDePerfil = new ClsRelacion("NumeroDePerfil", "per_num_perfil", "Numero de Perfil","Numeric","4","0","NOT NULL","Numero de Perfil");
        public static ClsRelacion NombreDePerfil = new ClsRelacion("NombreDePerfil", "per_nom_perfil", "Nombre de Perfil","String","30","0","NOT NULL","Nombre de Perfil");
        public static ClsRelacion CveEstatus = new ClsRelacion("CveEstatus", "per_cve_estatus", "Estatus","Numeric","4","0","NOT NULL","Identificador de estatus de las claves");
        public static ClsRelacion TextoEstatus = new ClsRelacion("TextoEstatus", "per_txt_estatus", "Estatus","String","30","0","NULL","Identificador de estatus de las claves");
        public static List<ClsRelacion> CamposQueSeMuestranEnTabla = Arrays.asList(NumeroDePerfil,NombreDePerfil,TextoEstatus);
        public static ClsRelacion[] Estructura = {NumeroDePerfil,NombreDePerfil,CveEstatus};
        public static String SqlVista = "CREATE VIEW " + Tabla.NombreVista() + " AS " +
                "SELECT " +
                NumeroDePerfil.Campo() + "," +
                NombreDePerfil.Campo() + "," +
                CveEstatus.Campo() + "," +
                "(SELECT " + ClsClave.RelacionesClave.NombreDeClave.Campo() + " FROM " + ClsClave.RelacionesClave.Tabla.NombreTabla() + " WHERE " + ClsClave.RelacionesClave.NumeroDeClave.Campo() + " = 1 AND " + ClsClave.RelacionesClave.SecuencialDeClave.Campo() + " = " + CveEstatus.Campo() + ") AS " + TextoEstatus.Campo() + " " +
                "FROM " + Tabla.NombreTabla();
        public static String Index = "CREATE UNIQUE INDEX PK_" +Tabla.NombreTabla() + " ON " 
                + Tabla.NombreTabla() + " (" + NumeroDePerfil.Campo() + ")";
    }
    // </editor-fold>
}
