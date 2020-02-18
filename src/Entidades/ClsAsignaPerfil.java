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
import Interfaces.IAsignaPerfil;
import java.util.Map;

/**
 *
 * @author Freak
 */
public class ClsAsignaPerfil implements IAsignaPerfil {
    // <editor-fold defaultstate="collapsed" desc="Variables de la Clase">
    // Tabla
    private long _NumeroDePerfil;
    private long _NumeroDeUsuario;
    private int _CveEstatus;
    // Vista
    private String _NombreDePerfil;
    private String _NombreDeUsuario;
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
    public long NumeroDeUsuario() {
        return _NumeroDeUsuario;
    }

    @Override
    public void NumeroDeUsuario(long NumeroDeUsuario) {
        _NumeroDeUsuario = NumeroDeUsuario;
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
    public String NombreDePerfil() {
        return _NombreDePerfil;
    }

    @Override
    public void NombreDePerfil(String NombreDePerfil) {
        _NombreDePerfil = NombreDePerfil;
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
    public String TextoEstatus() {
        return _TextoEstatus;
    }

    @Override
    public void TextoEstatus(String TextoEstatus) {
        _TextoEstatus = TextoEstatus;
    }
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Constructor">
    public ClsAsignaPerfil() {
        
    }
    public ClsAsignaPerfil(long NumeroDePerfil, long NumeroDeUsuario, int CveEstatus) {
        _NumeroDePerfil = NumeroDePerfil;
        _NumeroDeUsuario = NumeroDeUsuario;
        _CveEstatus = CveEstatus;
    }
    public ClsAsignaPerfil(long NumeroDePerfil, long NumeroDeUsuario, int CveEstatus, String NombreDePerfil, String NombreDeUsuario, String TextoEstatus) {
        _NumeroDePerfil = NumeroDePerfil;
        _NumeroDeUsuario = NumeroDeUsuario;
        _CveEstatus = CveEstatus;
        _NombreDePerfil = NombreDePerfil;
        _NombreDeUsuario = NombreDeUsuario;
        _TextoEstatus = TextoEstatus;
    }
    public ClsAsignaPerfil(ClsResultSet Rec, boolean CamposVista){
        if(CamposVista){
            EstableceValores(
                    Long.parseLong(Rec.Campo(RelacionesAsignaPerfil.NumeroDePerfil.Campo()).toString()),
                    Long.parseLong(Rec.Campo(RelacionesAsignaPerfil.NumeroDeUsuario.Campo()).toString()),
                    Integer.parseInt(Rec.Campo(RelacionesAsignaPerfil.CveEstatus.Campo()).toString()),
                    (String) Rec.Campo(RelacionesAsignaPerfil.NombreDePerfil.Campo()),
                    (String) Rec.Campo(RelacionesAsignaPerfil.NombreDeUsuario.Campo()),
                    (String) Rec.Campo(RelacionesAsignaPerfil.TextoEstatus.Campo()));
        }else{
            EstableceValores(
                    Long.parseLong(Rec.Campo(RelacionesAsignaPerfil.NumeroDePerfil.Campo()).toString()),
                    Long.parseLong(Rec.Campo(RelacionesAsignaPerfil.NumeroDeUsuario.Campo()).toString()),
                    Integer.parseInt(Rec.Campo(RelacionesAsignaPerfil.CveEstatus.Campo()).toString()),
                    "",
                    "",
                    "");
        }
    }
    public void EstableceValores(long NumeroDePerfil, long NumeroDeUsuario, int CveEstatus, String NombreDePerfil, String NombreDeUsuario, String TextoEstatus) {
        _NumeroDePerfil = NumeroDePerfil;
        _NumeroDeUsuario = NumeroDeUsuario;
        _CveEstatus = CveEstatus;
        if (!NombreDePerfil.equals("") && !NombreDeUsuario.equals("") && !TextoEstatus.equals("")){
            _NombreDePerfil = NombreDePerfil;
            _NombreDeUsuario = NombreDeUsuario;
            _TextoEstatus = TextoEstatus;
        }
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
        sql = "delete from " + RelacionesAsignaPerfil.Tabla.NombreTabla() + " where "
                + RelacionesAsignaPerfil.NumeroDePerfil.Campo() + " = " + _NumeroDePerfil + " and "
                + RelacionesAsignaPerfil.NumeroDeUsuario.Campo() + " = " + _NumeroDeUsuario;
        return sql;
    }

    @Override
    public String ToInsert() {
        String sql = "";
        sql = "insert into " + RelacionesAsignaPerfil.Tabla.NombreTabla() + " ("
                + RelacionesAsignaPerfil.NumeroDePerfil.Campo() + ","
                + RelacionesAsignaPerfil.NumeroDeUsuario.Campo() + ","
                + RelacionesAsignaPerfil.CveEstatus.Campo()
                + ") values ("
                + _NumeroDePerfil + ","
                + _NumeroDeUsuario + ","
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
                sql = "update " + RelacionesAsignaPerfil.Tabla.NombreTabla() + " set " + sql + " where "
                        + RelacionesAsignaPerfil.NumeroDePerfil.Campo() + " = " + _NumeroDePerfil + " and "
                        + RelacionesAsignaPerfil.NumeroDeUsuario.Campo() + " = " + _NumeroDeUsuario;
            }
        }
        return sql;
    }
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Relaciones">
    public static class RelacionesAsignaPerfil {
        public static ClsRelacionTabla Tabla = new ClsRelacionTabla("AsignaPerfil","ViAsignaPerfil", "asp", "Tabla de Asigna Perfile");
        public static ClsRelacion NumeroDePerfil = new ClsRelacion("NumeroDePerfil", "asp_num_perfil", "Numero de Perfil","Numeric","4","0","NOT NULL","Indicador de numero de perfil");
        public static ClsRelacion NumeroDeUsuario = new ClsRelacion("NumeroDeUsuario", "asp_num_usuario", "Numero de Usuario","Numeric","4","0","NOT NULL","Indicador de numero de usuario");
        public static ClsRelacion CveEstatus = new ClsRelacion("CveEstatus", "asp_cve_estatus", "Estatus","Numeric","4","0","NOT NULL","Identificador de estatus de las claves");
        public static ClsRelacion NombreDePerfil = new ClsRelacion("NombreDePerfil", "asp_nom_perfil", "Nombre de Perfil","String","30","0","NULL","Nombre de Perfil");
        public static ClsRelacion NombreDeUsuario = new ClsRelacion("NombreDeUsuario", "asp_nom_usuario", "Nombre de Usuario","String","30","0","NULL","Nombre de Usuario");
        public static ClsRelacion TextoEstatus = new ClsRelacion("TextoEstatus", "asp_txt_estatus", "Estatus","String","30","0","NULL","Identificador de estatus de las claves");
        public static ClsRelacion[] Estructura = {NumeroDePerfil,NumeroDeUsuario,CveEstatus};
        public static String SqlVista = "CREATE VIEW " + Tabla.NombreVista() + " AS " +
                "SELECT " +
                NumeroDeUsuario.Campo() + "," +
                NumeroDePerfil.Campo() + "," +
                CveEstatus.Campo() + "," +
                ClsUsuario.RelacionesUsuario.NombreDeUsuario.Campo() + " AS " + NombreDeUsuario.Campo() + "," +
                ClsPerfil.RelacionesPerfil.NombreDePerfil.Campo() + " AS " + NombreDePerfil.Campo() + "," +
                "(SELECT " + ClsClave.RelacionesClave.NombreDeClave.Campo() + " FROM " + ClsClave.RelacionesClave.Tabla.NombreTabla() + " WHERE " + ClsClave.RelacionesClave.NumeroDeClave.Campo() + " = 1 AND " + ClsClave.RelacionesClave.SecuencialDeClave.Campo() + " = " + CveEstatus.Campo() + ") AS " + TextoEstatus.Campo() + " " +
                "FROM " + Tabla.NombreTabla() + " INNER JOIN " + ClsUsuario.RelacionesUsuario.Tabla.NombreTabla() + " ON (" + ClsUsuario.RelacionesUsuario.NumeroDeUsuario.Campo() + " = " + NumeroDeUsuario.Campo() + ") " +
                "INNER JOIN " + ClsPerfil.RelacionesPerfil.Tabla.NombreTabla() + " ON (" + ClsPerfil.RelacionesPerfil.NumeroDePerfil.Campo() + " = " + NumeroDePerfil.Campo() + ")";
        public static String Index = "CREATE UNIQUE INDEX PK_" +Tabla.NombreTabla() + " ON " 
                + Tabla.NombreTabla() + " (" + NumeroDeUsuario.Campo() 
                + "," + NumeroDePerfil.Campo() + ")";
    }
    // </editor-fold>
}
