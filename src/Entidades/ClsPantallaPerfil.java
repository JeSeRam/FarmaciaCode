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
import Interfaces.IPantallaPerfil;
import java.util.Map;

/**
 *
 * @author Freak
 */
public class ClsPantallaPerfil implements IPantallaPerfil {
    // <editor-fold defaultstate="collapsed" desc="Variables de la Clase">
    // Tabla
    private long _NumeroDePerfil;
    private int _CveTipoDeMenu;
    private long _NumeroDePantalla;
    private long _NumeroDePantallaHija;
    private int _CveEstatus;
    // Vista
    private String _NombreDePerfil;
    private String _TextoTipoDeMenu;
    private String _NombreDePantallaInterno;
    private String _NombreDePantallaMenu;
    private String _NombreDePantallaInternoHija;
    private String _NombreDePantallaMenuHija;
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
    public int CveTipoDeMenu(){
        return _CveTipoDeMenu;
    }
    
    @Override
    public void CveTipoDeMenu(int CveTipoDeMenu){
        _CveTipoDeMenu = CveTipoDeMenu;
    }
    @Override
    public long NumeroDePantalla() {
        return _NumeroDePantalla;
    }

    @Override
    public void NumeroDePantalla(long NumeroDePantalla) {
        _NumeroDePantalla = NumeroDePantalla;
    }
    
        @Override
    public long NumeroDePantallaHija() {
        return _NumeroDePantallaHija;
    }

    @Override
    public void NumeroDePantallaHija(long NumeroDePantallaHija) {
        _NumeroDePantallaHija = NumeroDePantallaHija;
    }

    @Override
    public int CveEstatus() {
        return _CveEstatus;
    }

    @Override
    public void CveEstatus(int CveEstatus) {
        _CveEstatus = CveEstatus;
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
    public String TextoTipoDeMenu(){
        return _TextoTipoDeMenu;
    }
    
    @Override
    public void TextoTipoDeMenu(String TextoTipoDeMenu){
        _TextoTipoDeMenu = TextoTipoDeMenu;
    }

    @Override
    public String NombreDePantallaInterno() {
        return _NombreDePantallaInterno;
    }

    @Override
    public void NombreDePantallaInterno(String NombreDePantallaInterno) {
        _NombreDePantallaInterno = NombreDePantallaInterno;
    }

    @Override
    public String NombreDePantallaMenu() {
        return _NombreDePantallaMenu;
    }

    @Override
    public void NombreDePantallaMenu(String NombreDePantallaMenu) {
        _NombreDePantallaMenu = NombreDePantallaMenu;
    }

    @Override
    public String NombreDePantallaInternoHija() {
        return _NombreDePantallaInternoHija;
    }

    @Override
    public void NombreDePantallaInternoHija(String NombreDePantallaInternoHija) {
        _NombreDePantallaInternoHija = NombreDePantallaInternoHija;
    }

    @Override
    public String NombreDePantallaMenuHija() {
        return _NombreDePantallaMenuHija;
    }

    @Override
    public void NombreDePantallaMenuHija(String NombreDePantallaMenuHija) {
        _NombreDePantallaMenuHija = NombreDePantallaMenuHija;
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
    public ClsPantallaPerfil() {

    }
    public ClsPantallaPerfil(long NumeroDePerfil,int CveTipoDeMenu, long NumeroDePantalla,long NumeroDePantallaHija, int CveEstatus) {
        _NumeroDePerfil = NumeroDePerfil;
        _CveTipoDeMenu = CveTipoDeMenu;
        _NumeroDePantalla = NumeroDePantalla;
        _NumeroDePantallaHija = NumeroDePantallaHija;
        _CveEstatus = CveEstatus;
    }
    public ClsPantallaPerfil(long NumeroDePerfil,int CveTipoDeMenu, long NumeroDePantalla,long NumeroDePantallaHija, int CveEstatus, String NombreDePerfil, String TextoTipoDeMenu, String NombreDePantallaInterno, String NombreDePantallaMenu,String NombreDePantallaInternoHija, String NombreDePantallaMenuHija, String TextoEstatus) {
        // Tabla
        _NumeroDePerfil = NumeroDePerfil;
        _CveTipoDeMenu = CveTipoDeMenu;
        _NumeroDePantalla = NumeroDePantalla;
        _NumeroDePantallaHija = NumeroDePantallaHija;
        _CveEstatus = CveEstatus;
        // Vista
        _NombreDePerfil = NombreDePerfil;
        _TextoTipoDeMenu = TextoTipoDeMenu;
        _NombreDePantallaInterno = NombreDePantallaInterno;
        _NombreDePantallaMenu = NombreDePantallaMenu;
        _NombreDePantallaInternoHija = NombreDePantallaInternoHija;
        _NombreDePantallaMenuHija = NombreDePantallaMenuHija;
        _TextoEstatus = TextoEstatus;
    }
        public ClsPantallaPerfil(ClsResultSet Rec, boolean CamposVista){
        if(CamposVista){
            EstableceValores(
                    Long.parseLong(Rec.Campo(RelacionesPantallaPerfil.NumeroDePerfil.Campo()).toString()),
                    Integer.parseInt(Rec.Campo(RelacionesPantallaPerfil.CveTipoDeMenu.Campo()).toString()),
                    Long.parseLong(Rec.Campo(RelacionesPantallaPerfil.NumeroDePantalla.Campo()).toString()),
                    Long.parseLong(Rec.Campo(RelacionesPantallaPerfil.NumeroDePantallaHija.Campo()).toString()),
                    Integer.parseInt(Rec.Campo(RelacionesPantallaPerfil.CveEstatus.Campo()).toString()),
                    (String) Rec.Campo(RelacionesPantallaPerfil.NombreDePerfil.Campo()),
                    (String) Rec.Campo(RelacionesPantallaPerfil.TextoTipoDeMenu.Campo()),
                    (String) Rec.Campo(RelacionesPantallaPerfil.NombreDePantallaInterno.Campo()),
                    (String) Rec.Campo(RelacionesPantallaPerfil.NombreDePantallaMenu.Campo()),
                    (String) Rec.Campo(RelacionesPantallaPerfil.NombreDePantallaInternoHija.Campo()),
                    (String) Rec.Campo(RelacionesPantallaPerfil.NombreDePantallaMenuHija.Campo()),
                    (String) Rec.Campo(RelacionesPantallaPerfil.TextoEstatus.Campo()));
        }else{
            EstableceValores(
                    Long.parseLong(Rec.Campo(RelacionesPantallaPerfil.NumeroDePerfil.Campo()).toString()),
                    Integer.parseInt(Rec.Campo(RelacionesPantallaPerfil.CveTipoDeMenu.Campo()).toString()),
                    Long.parseLong(Rec.Campo(RelacionesPantallaPerfil.NumeroDePantalla.Campo()).toString()),
                    Long.parseLong(Rec.Campo(RelacionesPantallaPerfil.NumeroDePantallaHija.Campo()).toString()),
                    Integer.parseInt(Rec.Campo(RelacionesPantallaPerfil.CveEstatus.Campo()).toString()),
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "");
        }
    }
    public void EstableceValores(long NumeroDePerfil,int CveTipoDeMenu, long NumeroDePantalla, long NumeroDePantallaHija, int CveEstatus, String NombreDePerfil, String TextoTipoDeMenu, String NombreDePantallaInterno, String NombreDePantallaMenu,String NombreDePantallaInternoHija, String NombreDePantallaMenuHija, String TextoEstatus){
        if (!NombreDePerfil.equals("") && !TextoTipoDeMenu.equals("") && 
                !NombreDePantallaInterno.equals("") && !NombreDePantallaMenu.equals("") && 
                !TextoEstatus.equals("")){
        // Vista
        _NombreDePerfil = NombreDePerfil;
        _TextoTipoDeMenu = TextoTipoDeMenu;
        _NombreDePantallaInterno = NombreDePantallaInterno;
        _NombreDePantallaMenu = NombreDePantallaMenu;
        _NombreDePantallaInternoHija = NombreDePantallaInternoHija;
        _NombreDePantallaMenuHija = NombreDePantallaMenuHija;
        _TextoEstatus = TextoEstatus;
        }
        // Tabla
        _NumeroDePerfil = NumeroDePerfil;
        _CveTipoDeMenu = CveTipoDeMenu;
        _NumeroDePantalla = NumeroDePantalla;
        _NumeroDePantallaHija = NumeroDePantallaHija;
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
        sql = "delete from " + RelacionesPantallaPerfil.Tabla.NombreTabla() + " where "
                + RelacionesPantallaPerfil.NumeroDePerfil.Campo() + " =  " + _NumeroDePerfil + " AND "
                + RelacionesPantallaPerfil.CveTipoDeMenu.Campo() + " =  " + _CveTipoDeMenu + " AND "
                + RelacionesPantallaPerfil.NumeroDePantalla.Campo() + " = " + _NumeroDePantalla + " AND "
                + RelacionesPantallaPerfil.NumeroDePantallaHija.Campo() + " = " + _NumeroDePantallaHija;
        return sql;
    }

    @Override
    public String ToInsert() {
        String sql = "";
        sql = "insert into " + RelacionesPantallaPerfil.Tabla.NombreTabla() + " ("
                + RelacionesPantallaPerfil.NumeroDePerfil.Campo() + ","
                + RelacionesPantallaPerfil.CveTipoDeMenu.Campo() + ","
                + RelacionesPantallaPerfil.NumeroDePantalla.Campo() + ","
                + RelacionesPantallaPerfil.NumeroDePantallaHija.Campo() + ","
                + RelacionesPantallaPerfil.CveEstatus.Campo()
                + ") values ("
                + _NumeroDePerfil + ","
                + _CveTipoDeMenu + ","
                + _NumeroDePantalla + ","
                + _NumeroDePantallaHija + ","
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
                sql = "update " + RelacionesPantallaPerfil.Tabla.NombreTabla() + " set " + sql + " where "
                + RelacionesPantallaPerfil.NumeroDePerfil.Campo() + " =  " + _NumeroDePerfil + " AND "
                + RelacionesPantallaPerfil.CveTipoDeMenu.Campo() + " =  " + _CveTipoDeMenu + " AND "
                + RelacionesPantallaPerfil.NumeroDePantalla.Campo() + " = " + _NumeroDePantalla + " AND "
                + RelacionesPantallaPerfil.NumeroDePantallaHija.Campo() + " = " + _NumeroDePantallaHija;
            }
        }
        return sql;
    }
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Relaciones">
    public static class RelacionesPantallaPerfil {
        public static ClsRelacionTabla Tabla = new ClsRelacionTabla("PantallaPerfil","ViPantallaPerfil", "pap", "Tabla de Pantalla Perfil");
        public static ClsRelacion NumeroDePerfil = new ClsRelacion("NumeroDePerfil", "pap_num_perfil", "Numero de Perfil","Numeric","4","0","NOT NULL","Numero de Perfil");
        public static ClsRelacion CveTipoDeMenu = new ClsRelacion("CveTipoDeMenu", "pap_cve_tipo_menu", "Tipo de Menu a Mostrar","Numeric","4","0","NOT NULL","Tipo de Menu a Mostrar");
        public static ClsRelacion NumeroDePantalla = new ClsRelacion("NumeroDePantalla", "pap_num_pantalla", "Numero de Pantalla","Numeric","4","0","NOT NULL","Numero de Pantalla");
        public static ClsRelacion NumeroDePantallaHija = new ClsRelacion("NumeroDePantallaHija", "pap_num_pantalla_hija", "Numero de Pantalla Hija","Numeric","4","0","NOT NULL","Numero de Pantalla Hija");
        public static ClsRelacion CveEstatus = new ClsRelacion("CveEstatus", "pap_cve_estatus", "Estatus","Numeric","4","0","NOT NULL","Identificador de estatus de las claves");
        public static ClsRelacion NombreDePerfil = new ClsRelacion("NombreDePerfil", "pap_nom_perfil", "Nombre de Perfil","String","30","0","NOT NULL","Nombre de Perfil");
        public static ClsRelacion TextoTipoDeMenu = new ClsRelacion("TextoTipoDeMenu", "pap_txt_tipo_menu", "Tipo de menu a mostrar","String","30","0","NULL","Identificador de Tipo de Menu a mostrar");
        public static ClsRelacion NombreDePantallaInterno = new ClsRelacion("NombreDePantallaInterno","pap_nom_pantalla_int","Nombre de Pantalla Interno","String","50","0","NULL","Nombre de Pantalla en codigo");
        public static ClsRelacion NombreDePantallaMenu = new ClsRelacion("NombreDePantallaMenu","pap_nom_menu_pantalla","Nombre de Pantalla en Menu","String","50","0","NULL","Nombre de Pantalla en Menu");
        public static ClsRelacion NombreDePantallaInternoHija = new ClsRelacion("NombreDePantallaInternoHija","pap_nom_pantalla_int_hija","Nombre de Pantalla Hija Interno","String","50","0","NULL","Nombre de Pantalla Hija en codigo");
        public static ClsRelacion NombreDePantallaMenuHija = new ClsRelacion("NombreDePantallaMenuHija","pap_nom_menu_pantalla_hija","Nombre de Pantalla Hija en Menu","String","50","0","NULL","Nombre de Pantalla Hija en Menu");
        public static ClsRelacion TextoEstatus = new ClsRelacion("TextoEstatus", "pan_txt_estatus", "Estatus","String","30","0","NULL","Identificador de estatus de las claves");
        public static ClsRelacion[] Estructura = {NumeroDePerfil,CveTipoDeMenu,NumeroDePantalla,NumeroDePantallaHija,CveEstatus};
        public static String SqlVista = "CREATE VIEW " + Tabla.NombreVista() + " AS " +
                "SELECT " +
                NumeroDePerfil.Campo() + "," +
                CveTipoDeMenu.Campo() + "," +
                NumeroDePantalla.Campo() + "," +
                NumeroDePantallaHija.Campo() + "," +
                CveEstatus.Campo() + "," +
                ClsPerfil.RelacionesPerfil.NombreDePerfil.Campo() + " AS " + NombreDePerfil.Campo() + "," +
                ClsPantalla.RelacionesPantalla.TextoTipoDeMenu.Campo() + " AS " + TextoTipoDeMenu.Campo() + "," +
                ClsPantalla.RelacionesPantalla.NombreDePantallaInterno.Campo() + " AS " + NombreDePantallaInterno.Campo() + "," +
                ClsPantalla.RelacionesPantalla.NombreDePantallaMenu.Campo() + " AS " + NombreDePantallaMenu.Campo() + "," +
                ClsPantalla.RelacionesPantalla.NombreDePantallaInternoHija.Campo() + " AS " + NombreDePantallaInternoHija.Campo() + "," +
                ClsPantalla.RelacionesPantalla.NombreDePantallaMenuHija.Campo() + " AS " + NombreDePantallaMenuHija.Campo() + "," +
                "(SELECT " + ClsClave.RelacionesClave.NombreDeClave.Campo() + " FROM " + ClsClave.RelacionesClave.Tabla.NombreTabla() + " WHERE " + ClsClave.RelacionesClave.NumeroDeClave.Campo() + " = 1 AND " + ClsClave.RelacionesClave.SecuencialDeClave.Campo() + " = " + CveEstatus.Campo() + ") AS " + TextoEstatus.Campo() + " " +
                "FROM " + Tabla.NombreTabla() + " " +
                "INNER JOIN " + ClsPantalla.RelacionesPantalla.Tabla.NombreVista() + " on (" +
                ClsPantalla.RelacionesPantalla.CveTipoDeMenu.Campo() + " = " + CveTipoDeMenu.Campo() + " and " +
                ClsPantalla.RelacionesPantalla.NumeroDePantalla.Campo() + " = " + NumeroDePantalla.Campo() + " and " +
                ClsPantalla.RelacionesPantalla.NumeroDePantallaHija.Campo() + " = " + NumeroDePantallaHija.Campo() + ") " +
                "INNER JOIN " + ClsPerfil.RelacionesPerfil.Tabla.NombreVista() + " on (" + 
                ClsPerfil.RelacionesPerfil.NumeroDePerfil.Campo() + " = " + NumeroDePerfil.Campo() + ")";
        public static String Index = "CREATE UNIQUE INDEX PK_" +Tabla.NombreTabla() + " ON " 
                + Tabla.NombreTabla() + " (" + NumeroDePerfil.Campo() + ","
                + CveTipoDeMenu.Campo() + ","
                + NumeroDePantalla.Campo() + ","
                + NumeroDePantallaHija.Campo() + ")";
    }
    // </editor-fold>
}
