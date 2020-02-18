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
import Interfaces.IUsuario;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Freak
 */
public class ClsUsuario implements IUsuario {
    // <editor-fold defaultstate="collapsed" desc="Variables de la Clase">
    // Tabla
    private long _NumeroDeUsuario;
    private String _NombreDeUsuario;
    private String _NombreDePersona;
    private String _ApellidoPaterno;
    private String _ApellidoMaterno;
    private String _ContraseñaDeUsuario;
    private Date _FechaDeCreacion;
    private int _CveTipoDeUsuario;
    private int _CveEstatus;
    // Vista
    private String _TextoTipoDeUsuario;
    private String _TextoEstatus;
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Get & Set">
    // Tabla
    @Override
    public long NumeroDeUsuario() {
        return _NumeroDeUsuario;
    }

    @Override
    public void NumeroDeUsuario(long NumeroDeUsuario) {
        _NumeroDeUsuario = NumeroDeUsuario;
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
    public String NombreDePersona() {
        return _NombreDePersona;
    }

    @Override
    public void NombreDePersona(String NombreDePersona) {
        _NombreDePersona = NombreDePersona;
    }

    @Override
    public String ApellidoPaterno() {
        return _ApellidoPaterno;
    }

    @Override
    public void ApellidoPaterno(String ApellidoPaterno) {
        _ApellidoPaterno = ApellidoPaterno;
    }

    @Override
    public String ApellidoMaterno() {
        return _ApellidoMaterno;
    }

    @Override
    public void ApellidoMaterno(String ApellidoMaterno) {
        _ApellidoMaterno = ApellidoMaterno;
    }

    @Override
    public String ContraseñaDeUsuario() {
        return _ContraseñaDeUsuario;
    }

    @Override
    public void ContraseñaDeUsuario(String ContraseñaDeUsuario) {
        _ContraseñaDeUsuario = ContraseñaDeUsuario;
    }

    @Override
    public Date FechaDeCreacion() {
        return _FechaDeCreacion;
    }

    @Override
    public void FechaDeCreacion(Date FechaDeCreacion) {
        _FechaDeCreacion = FechaDeCreacion;
    }

    @Override
    public int CveTipoDeUsuario() {
        return _CveTipoDeUsuario;
    }

    @Override
    public void CveTipoDeUsuario(int CveTipoDeUsuario) {
        _CveTipoDeUsuario = CveTipoDeUsuario;
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
    public String TextoTipoDeUsuario() {
        return _TextoTipoDeUsuario;
    }

    @Override
    public void TextoTipoDeUsuario(String TextoTipoDeUsuario) {
        _TextoTipoDeUsuario = TextoTipoDeUsuario;
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
    public ClsUsuario(){
        
    }
    public ClsUsuario(long NumeroDeUsuario, String NombreDeUsuario, String NombreDePersona, String ApellidoPaterno, String ApellidoMaterno, String ContraseñaDeUsuario, Date FechaDeCreacion, int CveTipoDeUsuario, int CveEstatus) {
        _NumeroDeUsuario = NumeroDeUsuario;
        _NombreDeUsuario = NombreDeUsuario;
        _NombreDePersona = NombreDePersona;
        _ApellidoPaterno = ApellidoPaterno;
        _ApellidoMaterno = ApellidoMaterno;
        _ContraseñaDeUsuario = ContraseñaDeUsuario;
        _FechaDeCreacion = FechaDeCreacion;
        _CveTipoDeUsuario = CveTipoDeUsuario;
        _CveEstatus = CveEstatus;
    }
    public ClsUsuario(long NumeroDeUsuario, String NombreDeUsuario, String NombreDePersona, String ApellidoPaterno, String ApellidoMaterno, String ContraseñaDeUsuario, Date FechaDeCreacion, int CveTipoDeUsuario, int CveEstatus, String TextoTipoDeUsuario, String TextoEstatus) {
        // Tabla
        _NumeroDeUsuario = NumeroDeUsuario;
        _NombreDeUsuario = NombreDeUsuario;
        _NombreDePersona = NombreDePersona;
        _ApellidoPaterno = ApellidoPaterno;
        _ApellidoMaterno = ApellidoMaterno;
        _ContraseñaDeUsuario = ContraseñaDeUsuario;
        _FechaDeCreacion = FechaDeCreacion;
        _CveTipoDeUsuario = CveTipoDeUsuario;
        _CveEstatus = CveEstatus;
        // Vista
        _TextoTipoDeUsuario = TextoTipoDeUsuario;
        _TextoEstatus = TextoEstatus;
    }
    public ClsUsuario(ClsResultSet Rec, boolean CamposVista){
        if(CamposVista){
            EstableceValores(
                    Long.parseLong(Rec.Campo(RelacionesUsuario.NumeroDeUsuario.Campo()).toString()),
                    (String) Rec.Campo(RelacionesUsuario.NombreDeUsuario.Campo()),
                    (String) Rec.Campo(RelacionesUsuario.NombreDePersona.Campo()),
                    (String) Rec.Campo(RelacionesUsuario.ApellidoPaterno.Campo()),
                    (String) Rec.Campo(RelacionesUsuario.ApellidoMaterno.Campo()),
                    (String) Rec.Campo(RelacionesUsuario.ContraseñaDeUsuario.Campo()),
                    (Date) Rec.Campo(RelacionesUsuario.FechaDeCreacion.Campo()),
                    Integer.parseInt(Rec.Campo(RelacionesUsuario.CveTipoDeUsuario.Campo()).toString()),
                    Integer.parseInt(Rec.Campo(RelacionesUsuario.CveEstatus.Campo()).toString()),
                    (String) Rec.Campo(RelacionesUsuario.TextoTipoDeUsuario.Campo()),
                    (String) Rec.Campo(RelacionesUsuario.TextoEstatus.Campo()));
        }else{
            EstableceValores(
                    Long.parseLong(Rec.Campo(RelacionesUsuario.NumeroDeUsuario.Campo()).toString()),
                    (String) Rec.Campo(RelacionesUsuario.NombreDeUsuario.Campo()),
                    (String) Rec.Campo(RelacionesUsuario.NombreDePersona.Campo()),
                    (String) Rec.Campo(RelacionesUsuario.ApellidoPaterno.Campo()),
                    (String) Rec.Campo(RelacionesUsuario.ApellidoMaterno.Campo()),
                    (String) Rec.Campo(RelacionesUsuario.ContraseñaDeUsuario.Campo()),
                    (Date) Rec.Campo(RelacionesUsuario.FechaDeCreacion.Campo()),
                    Integer.parseInt(Rec.Campo(RelacionesUsuario.CveTipoDeUsuario.Campo()).toString()),
                    Integer.parseInt(Rec.Campo(RelacionesUsuario.CveEstatus.Campo()).toString()),
                    "",
                    "");
        }
    }
    public void EstableceValores(long NumeroDeUsuario, String NombreDeUsuario, String NombreDePersona, String ApellidoPaterno, String ApellidoMaterno, String ContraseñaDeUsuario, Date FechaDeCreacion, int CveTipoDeUsuario, int CveEstatus, String TextoTipoDeUsuario, String TextoEstatus){
        if (!TextoTipoDeUsuario.equals("") && !TextoEstatus.equals("")){
        // Vista
        _TextoTipoDeUsuario = TextoTipoDeUsuario;
        _TextoEstatus = TextoEstatus;
        }
        // Tabla
        _NumeroDeUsuario = NumeroDeUsuario;
        _NombreDeUsuario = NombreDeUsuario;
        _NombreDePersona = NombreDePersona;
        _ApellidoPaterno = ApellidoPaterno;
        _ApellidoMaterno = ApellidoMaterno;
        _ContraseñaDeUsuario = ContraseñaDeUsuario;
        _FechaDeCreacion = FechaDeCreacion;
        _CveTipoDeUsuario = CveTipoDeUsuario;
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
        sql = "delete from " + RelacionesUsuario.Tabla.NombreTabla() + " where "
                + RelacionesUsuario.NumeroDeUsuario.Campo() + " =  " + _NumeroDeUsuario;
        return sql;
    }

    @Override
    public String ToInsert() {
        String sql = "";
        sql = "insert into " + RelacionesUsuario.Tabla.NombreTabla() + " ("
                + RelacionesUsuario.NumeroDeUsuario.Campo() + ","
                + RelacionesUsuario.NombreDeUsuario.Campo() + ","
                + RelacionesUsuario.NombreDePersona.Campo() + ","
                + RelacionesUsuario.ApellidoPaterno.Campo() + ","
                + RelacionesUsuario.ApellidoMaterno.Campo() + ","
                + RelacionesUsuario.ContraseñaDeUsuario.Campo() + ","
                + RelacionesUsuario.FechaDeCreacion.Campo() + ","
                + RelacionesUsuario.CveTipoDeUsuario.Campo() + ","
                + RelacionesUsuario.CveEstatus.Campo()
                + ") values ("
                + _NumeroDeUsuario + ","
                + _NombreDeUsuario + ","
                + _NombreDePersona + ","
                + _ApellidoPaterno + ","
                + _ApellidoMaterno + ","
                + _ContraseñaDeUsuario + ","
                + _FechaDeCreacion + ","
                + _CveTipoDeUsuario + ","
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
                sql = "update " + RelacionesUsuario.Tabla.NombreTabla() + " set " + sql + " where "
                        + RelacionesUsuario.NumeroDeUsuario.Campo() + " = " + _NumeroDeUsuario;
            }
        }
        return sql;
    }
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Relaciones">
    public static class RelacionesUsuario {
        public static ClsRelacionTabla Tabla = new ClsRelacionTabla("Usuario","ViUsuario","usu","Tabla de Usuario"); 
        public static ClsRelacion NumeroDeUsuario = new ClsRelacion("NumeroDeUsuario","usu_num_usuario","Número de Usuario","Numeric","4","0","NOT NULL","Nímero de Usuario");
        public static ClsRelacion NombreDeUsuario = new ClsRelacion("NombreDeUsuario","usu_nom_usuario","Usuario","String","30","0","NOT NULL","Nombre de Usuario");
        public static ClsRelacion NombreDePersona = new ClsRelacion("NombreDePersona","usu_nom_persona","Nombre","String","30","0","NOT NULL","Nombre de la Persona");
        public static ClsRelacion ApellidoPaterno = new ClsRelacion("ApellidoPaterno","usu_app_usuario","Apellido Paterno","String","30","0","NOT NULL","Apellido Paterno");
        public static ClsRelacion ApellidoMaterno = new ClsRelacion("ApellidoMaterno","usu_apm_usuario","Apellido Materno","String","30","0","NOT NULL","Apellido Materno");
        public static ClsRelacion ContraseñaDeUsuario = new ClsRelacion("ContraseñaDeUsuario","usu_contraseña","Contraseña","String","250","0","NOT NULL","Contraseña de Usuario");
        public static ClsRelacion FechaDeCreacion = new ClsRelacion("FechaDeCreacion","usu_fecha_creacion","Fecha de Creación","DateTime","0","0","NOT NULL","Fecha de Creacion del Usuario");
        public static ClsRelacion CveTipoDeUsuario = new ClsRelacion("CveTipoDeUsuario","usu_cve_tipo_usuario","Tipo de Usuario","Numeric","4","0","NOT NULL","Tipo de Usuario");
        public static ClsRelacion CveEstatus = new ClsRelacion("CveEstatus","usu_cve_estatus","Estatus","Numeric","4","0","NOT NULL","Identificador del estatus de usuario");
        public static ClsRelacion TextoTipoDeUsuario = new ClsRelacion("TextoTipoDeUsuario","usu_txt_tipo_usuario","Tipo de Usuario","String","30","0","NULL","Tipo de Usuario");
        public static ClsRelacion TextoEstatus = new ClsRelacion("TextoEstatus","usu_txt_estatus","Estatus","String","30","0","NULL","Estatus de usuario");
        public static List<ClsRelacion> CamposQueSeMuestranEnTabla = Arrays.asList(NumeroDeUsuario,NombreDeUsuario,NombreDePersona,ApellidoPaterno,ApellidoMaterno,TextoTipoDeUsuario,TextoEstatus);
        public static ClsRelacion[] Estructura = {NumeroDeUsuario,NombreDeUsuario,NombreDePersona,ApellidoPaterno,ApellidoMaterno,ContraseñaDeUsuario,FechaDeCreacion,CveTipoDeUsuario,CveEstatus};
        public static String SqlVista = "CREATE VIEW " + Tabla.NombreVista() + " AS " +
                "SELECT " +
                NumeroDeUsuario.Campo() + "," +
                NombreDeUsuario.Campo() + "," +
                NombreDePersona.Campo() + "," +
                ApellidoPaterno.Campo() + "," +
                ApellidoMaterno.Campo() + "," +
                ContraseñaDeUsuario.Campo() + "," +
                FechaDeCreacion.Campo() + "," +
                CveTipoDeUsuario.Campo() + "," +
                CveEstatus.Campo() + "," +
                "(SELECT " + ClsClave.RelacionesClave.NombreDeClave.Campo() + " FROM " + ClsClave.RelacionesClave.Tabla.NombreTabla() + " WHERE " + ClsClave.RelacionesClave.NumeroDeClave.Campo() + " = 2 AND " + ClsClave.RelacionesClave.SecuencialDeClave.Campo() + " = " + CveTipoDeUsuario.Campo() + ") AS " + TextoTipoDeUsuario.Campo() + "," +
                "(SELECT " + ClsClave.RelacionesClave.NombreDeClave.Campo() + " FROM " + ClsClave.RelacionesClave.Tabla.NombreTabla() + " WHERE " + ClsClave.RelacionesClave.NumeroDeClave.Campo() + " = 1 AND " + ClsClave.RelacionesClave.SecuencialDeClave.Campo() + " = " + CveEstatus.Campo() + ") AS " + TextoEstatus.Campo() + " " +
                "FROM " + Tabla.NombreTabla();
        public static String Index = "CREATE UNIQUE INDEX PK_" +Tabla.NombreTabla() + " ON " 
                + Tabla.NombreTabla() + " (" + NumeroDeUsuario.Campo() + ")";
    }
    // </editor-fold>
}
