/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import Clases.ClsRelacion;
import Clases.ClsRelacionTabla;
import ConexionMySql.ClsConexionMySql;
import java.util.Date;
import java.util.Map;
import Interfaces.IAcceso;
import java.sql.Time;

/**
 *
 * @author Freak
 */
public class ClsAcceso implements IAcceso {
    // <editor-fold defaultstate="collapsed" desc="Variables de la Clase">
    // Tabla
    private long _NumeroDeAcceso;
    private long _NumeroDePerfil;
    private long _NumeroDeUsuario;
    private Date _FechaDeAcceso;
    private Time _HoraDeAcceso;
    private Time _HoraDeSalida;
     // Vista
    private String _NombreDePerfil;
    private String _NombreDeUsuario;
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Get & Set">
    // Tabla
    @Override
    public long NumeroDeAcceso() {
        return _NumeroDeAcceso;
    }

    @Override
    public void NumeroDeAcceso(long NumeroDeAcceso) {
        _NumeroDeAcceso = NumeroDeAcceso;
    }

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
    public Date FechaDeAcceso() {
        return _FechaDeAcceso;
    }

    @Override
    public void FechaDeAcceso(Date FechaDeAcceso) {
        _FechaDeAcceso = FechaDeAcceso;
    }

    @Override
    public Time HoraDeAcceso() {
        return _HoraDeAcceso;
    }

    @Override
    public void HoraDeAcceso(Time HoraDeAcceso) {
        _HoraDeAcceso = HoraDeAcceso;
    }

    @Override
    public Time HoraDeSalida() {
        return _HoraDeSalida;
    }

    @Override
    public void HoraDeSalida(Time HoraDeSalida) {
        _HoraDeSalida = HoraDeSalida;
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
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Constructor">
    public void ClsAcceso() {
        
    }
    public void ClsAcceso(long NumeroDeAcceso, long NumeroDePerfil, long NumeroDeUsuario, Date FechaDeAcceso, Time HoraDeAcceso, Time HoraDeSalida) {
        _NumeroDeAcceso = NumeroDeAcceso;
        _NumeroDePerfil = NumeroDePerfil;
        _NumeroDeUsuario = NumeroDeUsuario;
        _FechaDeAcceso = FechaDeAcceso;
        _HoraDeAcceso = HoraDeAcceso;
        _HoraDeSalida = HoraDeSalida;
    }
    public void ClsAcceso(long NumeroDeAcceso, long NumeroDePerfil, long NumeroDeUsuario, Date FechaDeAcceso, Time HoraDeAcceso, Time HoraDeSalida, String NombreDePerfil, String NombreDeUsuario) {
        // Tabla
        _NumeroDeAcceso = NumeroDeAcceso;
        _NumeroDePerfil = NumeroDePerfil;
        _NumeroDeUsuario = NumeroDeUsuario;
        _FechaDeAcceso = FechaDeAcceso;
        _HoraDeAcceso = HoraDeAcceso;
        _HoraDeSalida = HoraDeSalida;
        // Vista
        _NombreDePerfil = NombreDePerfil;
        _NombreDeUsuario = NombreDeUsuario;
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
        sql = "delete from " + RelacionesAcceso.Tabla.NombreTabla() + " where "
                + RelacionesAcceso.NumeroDeAcceso.Campo() + " =  " + _NumeroDeAcceso + " and "
                + RelacionesAcceso.NumeroDePerfil.Campo() + " = " + _NumeroDePerfil + " and "
                + RelacionesAcceso.NumeroDeUsuario.Campo() + " = " + _NumeroDeUsuario + " and "
                + RelacionesAcceso.FechaDeAcceso.Campo() + " = " + _FechaDeAcceso;
        return sql;
    }

    @Override
    public String ToInsert() {
        String sql = "";
        sql = "insert into " + RelacionesAcceso.Tabla.NombreTabla() + " ("
                + RelacionesAcceso.NumeroDeAcceso.Campo() + ","
                + RelacionesAcceso.NumeroDePerfil.Campo() + ","
                + RelacionesAcceso.NumeroDeUsuario.Campo() + ","
                + RelacionesAcceso.FechaDeAcceso.Campo() + ","
                + RelacionesAcceso.HoraDeAcceso.Campo() + ","
                + RelacionesAcceso.HoraDeAcceso.Campo()
                + ") values ("
                + _NumeroDeAcceso + ","
                + _NumeroDePerfil + ","
                + _NumeroDeUsuario + ","
                + _FechaDeAcceso + ","
                + _HoraDeAcceso + ","
                + _HoraDeAcceso + ")";
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
                sql = "update " + RelacionesAcceso.Tabla.NombreTabla() + " set " + sql + " where "
                        + RelacionesAcceso.NumeroDeAcceso.Campo() + " =  " + _NumeroDeAcceso + " and "
                        + RelacionesAcceso.NumeroDePerfil.Campo() + " = " + _NumeroDePerfil + " and "
                        + RelacionesAcceso.NumeroDeUsuario.Campo() + " = " + _NumeroDeUsuario + " and "
                        + RelacionesAcceso.FechaDeAcceso.Campo() + " = " + _FechaDeAcceso;
            }
        }
        return sql;
    }
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Relaciones">
    public static class RelacionesAcceso {
        public static ClsRelacionTabla Tabla = new ClsRelacionTabla("Acceso","ViAcceso", "acc", "Tabla acceso por día");
        public static ClsRelacion NumeroDeAcceso = new ClsRelacion("NumeroDeAcceso", "acc_num_acceso", "Numero de Acceso","Numeric","4","0","NOT NULL","Indicador de numero de acceso");
        public static ClsRelacion NumeroDePerfil = new ClsRelacion("NumeroDePerfil", "acc_num_perfil", "Numero de Perfil","Numeric","4","0","NOT NULL","Indicador de numero de perfil");
        public static ClsRelacion NumeroDeUsuario = new ClsRelacion("NumeroDeUsuario", "acc_num_usuario", "Numero de Usuario","Numeric","4","0","NOT NULL","Indicador de numero de usuario");
        public static ClsRelacion FechaDeAcceso = new ClsRelacion("FechaDeAcceso", "acc_fecha_acceso", "Fecha de Acceso","DateTime","0","0","NOT NULL","Fecha de Acceso");
        public static ClsRelacion HoraDeAcceso = new ClsRelacion("HoraDeAcceso", "acc_hora_acceso", "Fecha de entrada","DateTime","0","0","NOT NULL","Fecha de entrada del usuario");
        public static ClsRelacion HoraDeSalida = new ClsRelacion("HoraDeSalida", "acc_hora_fin_acceso", "Fecha de salida","DateTime","0","0","NULL","Fecha de salida del usuario");
        public static ClsRelacion NombreDePerfil = new ClsRelacion("NombreDePerfil", "acc_nom_perfil", "Nombre de Perfil","varchar","30","0","NULL","Nombre de Perfil");
        public static ClsRelacion NombreDeUsuario = new ClsRelacion("NombreDeUsuario", "acc_nom_usuario", "Nombre de Usuario","varchar","30","0","NULL","Nombre de Usuario");
        public static ClsRelacion[] Estructura = {NumeroDeAcceso,NumeroDePerfil,NumeroDeUsuario,FechaDeAcceso,HoraDeAcceso,HoraDeSalida};
        public static String SqlVista = "CREATE VIEW " + Tabla.NombreVista()+ " AS " + 
                "SELECT " +
                NumeroDeAcceso.Campo() + "," +
                NumeroDePerfil.Campo() + "," +
                NumeroDeUsuario.Campo() + "," +
                FechaDeAcceso.Campo() + "," +
                HoraDeAcceso.Campo() + "," +
                HoraDeSalida.Campo() + "," +
                ClsPerfil.RelacionesPerfil.NombreDePerfil.Campo() + " AS " + NombreDePerfil.Campo() + "," +
                ClsUsuario.RelacionesUsuario.NombreDeUsuario.Campo() + " AS " + NombreDeUsuario.Campo() + " " +
                "FROM " + Tabla.NombreTabla() + " INNER JOIN " + ClsPerfil.RelacionesPerfil.Tabla.NombreTabla() + " ON (" + ClsPerfil.RelacionesPerfil.NumeroDePerfil.Campo() + " = " + NumeroDePerfil.Campo() + ") " +
                "INNER JOIN " + ClsUsuario.RelacionesUsuario.Tabla.NombreTabla() + " ON (" + ClsUsuario.RelacionesUsuario.NumeroDeUsuario.Campo() + " = " + NumeroDeUsuario.Campo() + ")";
            public static String Index = "CREATE UNIQUE INDEX PK_" +Tabla.NombreTabla() + " ON " 
                + Tabla.NombreTabla() + " (" + NumeroDeAcceso.Campo() 
                    + "," + NumeroDePerfil.Campo() 
                    + "," + NumeroDeUsuario.Campo()
                    + "," + FechaDeAcceso.Campo() + ")";
    }
    // </editor-fold>
}
