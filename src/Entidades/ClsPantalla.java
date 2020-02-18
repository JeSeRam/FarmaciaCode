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
import Interfaces.IPantalla;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Freak
 */
public final class ClsPantalla implements IPantalla{
    // <editor-fold defaultstate="collapsed" desc="Variables de la Clase">
    // Tabla
    private long _NumeroDePantalla;
    private long _NumeroDePantallaHija;
    private int _CveTipoDeMenu;
    private int _CveApareceEnMenu;
    private String _NombreDePantallaInterno;
    private String _NombreDePantallaMenu;
    private String _NombreDePantallaInternoHija;
    private String _NombreDePantallaMenuHija;
    private int _CveEstatus;
    // Vista
    private String _TextoTipoDeMenu;
    private String _TextoApareceEnMenu;
    private String _TextoEstatus;
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Get & Set">
    // Tabla
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
    public int CveTipoDeMenu(){
        return _CveTipoDeMenu;
    }
    
    @Override
    public void CveTipoDeMenu(int CveTipoDeMenu){
        _CveTipoDeMenu = CveTipoDeMenu;
    }
    
    @Override
    public int CveApareceEnMenu(){
        return _CveApareceEnMenu;
    }
    
    @Override
    public void CveApareceEnMenu(int CveApareceEnMenu){
        _CveApareceEnMenu = CveApareceEnMenu;
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
    public int CveEstatus() {
        return _CveEstatus;
    }

    @Override
    public void CveEstatus(int CveEstatus) {
        _CveEstatus = CveEstatus;
    }
    // Vista
    @Override
    public String TextoTipoDeMenu() {
        return _TextoTipoDeMenu;
    }

    @Override
    public void TextoTipoDeMenu(String TextoTipoDeMenu) {
        _TextoTipoDeMenu = TextoTipoDeMenu;
    }
    
    @Override
    public String TextoApareceEnMenu() {
        return _TextoApareceEnMenu;
    }

    @Override
    public void TextoApareceEnMenu(String TextoApareceEnMenu) {
        _TextoApareceEnMenu = TextoApareceEnMenu;
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
    public ClsPantalla() {

    }
    public ClsPantalla(long NumeroDePantalla,long NumeroDePantallaHija, int CveTipoDeMenu, int CveApareceEnMenu, String NombreDePantallaInterno, String NombreDePantallaMenu, String NombreDePantallaInternoHija, String NombreDePantallaMenuHija, int CveEstatus) {
        _NumeroDePantalla = NumeroDePantalla;
        _NumeroDePantallaHija = NumeroDePantallaHija;
        _CveTipoDeMenu = CveTipoDeMenu;
        _CveApareceEnMenu = CveApareceEnMenu;
        _NombreDePantallaInterno = NombreDePantallaInterno;
        _NombreDePantallaMenu = NombreDePantallaMenu;
        _NombreDePantallaInternoHija = NombreDePantallaInternoHija;
        _NombreDePantallaMenuHija = NombreDePantallaMenuHija;
        _CveEstatus = CveEstatus;
    }
    public ClsPantalla(long NumeroDePantalla,long NumeroDePantallaHija, int CveTipoDeMenu, int CveApareceEnMenu, String NombreDePantallaInterno, String NombreDePantallaMenu, String NombreDePantallaInternoHija, String NombreDePantallaMenuHija, int CveEstatus, String TextoTipoDeMenu, String TextoApareceEnMenu, String TextoEstatus) {
        // Tabla
        _NumeroDePantalla = NumeroDePantalla;
        _NumeroDePantallaHija = NumeroDePantallaHija;
        _CveTipoDeMenu = CveTipoDeMenu;
        _CveApareceEnMenu = CveApareceEnMenu;
        _NombreDePantallaInterno = NombreDePantallaInterno;
        _NombreDePantallaMenu = NombreDePantallaMenu;
        _NombreDePantallaInternoHija = NombreDePantallaInternoHija;
        _NombreDePantallaMenuHija = NombreDePantallaMenuHija;
        _CveEstatus = CveEstatus;
        // Vista
        _TextoTipoDeMenu = TextoTipoDeMenu;
        _TextoApareceEnMenu = TextoApareceEnMenu;
        _TextoEstatus = TextoEstatus;
    }
    public ClsPantalla(ClsResultSet Rec, boolean CamposVista){
        if(CamposVista){
            EstableceValores(
                    Long.parseLong(Rec.Campo(RelacionesPantalla.NumeroDePantalla.Campo()).toString()),
                    Long.parseLong(Rec.Campo(RelacionesPantalla.NumeroDePantallaHija.Campo()).toString()),
                    Integer.parseInt(Rec.Campo(RelacionesPantalla.CveTipoDeMenu.Campo()).toString()),
                    Integer.parseInt(Rec.Campo(RelacionesPantalla.CveApareceEnMenu.Campo()).toString()),
                    (String) Rec.Campo(RelacionesPantalla.NombreDePantallaInterno.Campo()),
                    (String) Rec.Campo(RelacionesPantalla.NombreDePantallaMenu.Campo()),
                    (String) Rec.Campo(RelacionesPantalla.NombreDePantallaInternoHija.Campo()),
                    (String) Rec.Campo(RelacionesPantalla.NombreDePantallaMenuHija.Campo()),
                    Integer.parseInt(Rec.Campo(RelacionesPantalla.CveEstatus.Campo()).toString()),
                    (String) Rec.Campo(RelacionesPantalla.TextoTipoDeMenu.Campo()),
                    (String) Rec.Campo(RelacionesPantalla.TextoApareceEnMenu.Campo()),
                    (String) Rec.Campo(RelacionesPantalla.TextoEstatus.Campo()));
        }else{
            EstableceValores(
                    Long.parseLong(Rec.Campo(RelacionesPantalla.NumeroDePantalla.Campo()).toString()),
                    Long.parseLong(Rec.Campo(RelacionesPantalla.NumeroDePantallaHija.Campo()).toString()),
                    Integer.parseInt(Rec.Campo(RelacionesPantalla.CveTipoDeMenu.Campo()).toString()),
                    Integer.parseInt(Rec.Campo(RelacionesPantalla.CveApareceEnMenu.Campo()).toString()),
                    (String) Rec.Campo(RelacionesPantalla.NombreDePantallaInterno.Campo()),
                    (String) Rec.Campo(RelacionesPantalla.NombreDePantallaMenu.Campo()),
                    (String) Rec.Campo(RelacionesPantalla.NombreDePantallaInternoHija.Campo()),
                    (String) Rec.Campo(RelacionesPantalla.NombreDePantallaMenuHija.Campo()),
                    Integer.parseInt(Rec.Campo(RelacionesPantalla.CveEstatus.Campo()).toString()),
                    "",
                    "",
                    "");
        }
    }
    public void EstableceValores(long NumeroDePantalla,long NumeroDePantallaHija, int CveTipoDeMenu, int CveApareceEnMenu, String NombreDePantallaInterno, String NombreDePantallaMenu, String NombreDePantallaInternoHija, String NombreDePantallaMenuHija, int CveEstatus, String TextoTipoDeMenu, String TextoApareceEnMenu, String TextoEstatus){
        if (!TextoTipoDeMenu.equals("") && !TextoEstatus.equals("") && !TextoApareceEnMenu.equals("")){
        // Vista
        _TextoTipoDeMenu = TextoTipoDeMenu;
        _TextoApareceEnMenu = TextoApareceEnMenu;
        _TextoEstatus = TextoEstatus;
        }
        // Tabla
        _NumeroDePantalla = NumeroDePantalla;
        _NumeroDePantallaHija = NumeroDePantallaHija;
        _CveTipoDeMenu = CveTipoDeMenu;
        _CveApareceEnMenu = CveApareceEnMenu;
        _NombreDePantallaInterno = NombreDePantallaInterno;
        _NombreDePantallaMenu = NombreDePantallaMenu;
        _NombreDePantallaInternoHija = NombreDePantallaInternoHija;
        _NombreDePantallaMenuHija = NombreDePantallaMenuHija;
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
        sql = "delete from " + RelacionesPantalla.Tabla.NombreTabla() + " where "
                + RelacionesPantalla.NumeroDePantalla.Campo() + " = " + _NumeroDePantalla + " and "
                + RelacionesPantalla.NumeroDePantallaHija.Campo() + " = " + _NumeroDePantallaHija + " and "
                + RelacionesPantalla.CveTipoDeMenu.Campo() + " = " + _CveTipoDeMenu;
        return sql;
    }

    @Override
    public String ToInsert() {
        String sql = "";
        sql = "insert into " + RelacionesPantalla.Tabla.NombreTabla() + " ("
                + RelacionesPantalla.NumeroDePantalla.Campo() + ","
                + RelacionesPantalla.NumeroDePantallaHija.Campo() + ","
                + RelacionesPantalla.CveTipoDeMenu.Campo() + ","
                + RelacionesPantalla.CveApareceEnMenu.Campo() + ","
                + RelacionesPantalla.NombreDePantallaInterno.Campo() + ","
                + RelacionesPantalla.NombreDePantallaMenu.Campo() + ","
                + RelacionesPantalla.NombreDePantallaInternoHija.Campo() + ","
                + RelacionesPantalla.NombreDePantallaMenuHija.Campo() + ","
                + RelacionesPantalla.CveEstatus.Campo()
                + ") values ("
                + _NumeroDePantalla + ","
                + _NumeroDePantallaHija + ","
                + _CveTipoDeMenu + ","
                + _CveApareceEnMenu + ","
                + _NombreDePantallaInterno + ","
                + _NombreDePantallaMenu + ","
                + _NombreDePantallaInternoHija + ","
                + _NombreDePantallaMenuHija + ","
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
                sql = "update " + RelacionesPantalla.Tabla.NombreTabla() + " set " + sql + " where "
                + RelacionesPantalla.NumeroDePantalla.Campo() + " = " + _NumeroDePantalla + " and "
                + RelacionesPantalla.NumeroDePantallaHija.Campo() + " = " + _NumeroDePantallaHija + " and "
                + RelacionesPantalla.CveTipoDeMenu.Campo() + " = " + _CveTipoDeMenu;
            }
        }
        return sql;
    }
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Relaciones">
    public static class RelacionesPantalla {
        public static ClsRelacionTabla Tabla = new ClsRelacionTabla("Pantalla","ViPantalla", "pan", "Tabla de Pantalla");
        public static ClsRelacion NumeroDePantalla = new ClsRelacion("NumeroDePantalla", "pan_num_pantalla", "Numero de Pantalla","Numeric","4","0","NOT NULL","Numero de Pantalla");
        public static ClsRelacion NumeroDePantallaHija = new ClsRelacion("NumeroDePantallaHija", "pan_num_pantalla_hija", "Numero de Pantalla Hija","Numeric","4","0","NOT NULL","Numero de Pantalla Hija");
        public static ClsRelacion CveTipoDeMenu = new ClsRelacion("CveTipoDeMenu", "pan_cve_tipo_menu", "Tipo de Menu a Mostrar","Numeric","4","0","NOT NULL","Tipo de Menu a Mostrar");
        public static ClsRelacion CveApareceEnMenu = new ClsRelacion("CveApareceEnMenu", "pan_cve_aparece_menu", "Aparece en Menu","Numeric","4","0","NOT NULL","Indica si la pantalla aparece en el menu");
        public static ClsRelacion NombreDePantallaInterno = new ClsRelacion("NombreDePantallaInterno","pan_nom_pantalla_int","Nombre de Pantalla Interno","String","50","0","NULL","Nombre de Pantalla en codigo");
        public static ClsRelacion NombreDePantallaMenu = new ClsRelacion("NombreDePantallaMenu","pan_nom_menu_pantalla","Nombre de Pantalla en Menu","String","50","0","NULL","Nombre de Pantalla en Menu");
        public static ClsRelacion NombreDePantallaInternoHija = new ClsRelacion("NombreDePantallaInternoHija","pan_nom_pantalla_int_hija","Nombre de Pantalla Hija Interno","String","50","0","NULL","Nombre de Pantalla Hija en codigo");
        public static ClsRelacion NombreDePantallaMenuHija = new ClsRelacion("NombreDePantallaMenuHija","pan_nom_menu_pantalla_hija","Nombre de Pantalla Hija en Menu","String","50","0","NULL","Nombre de Pantalla Hija en Menu");
        public static ClsRelacion CveEstatus = new ClsRelacion("CveEstatus", "pan_cve_estatus", "Estatus","Numeric","4","0","NOT NULL","Identificador de estatus de las claves");
        public static ClsRelacion TextoTipoDeMenu = new ClsRelacion("TextoTipoDeMenu", "pan_txt_tipo_menu", "Tipo de menu a mostrar","String","30","0","NULL","Identificador de Tipo de Menu a mostrar");
        public static ClsRelacion TextoApareceEnMenu = new ClsRelacion("TextoApareceEnMenu", "pan_txt_aparece_menu", "Aparece en Menu","String","30","0","NULL","Indica si la pantalla aparece en el menu");
        public static ClsRelacion TextoEstatus = new ClsRelacion("TextoEstatus", "pan_txt_estatus", "Estatus","String","30","0","NULL","Identificador de estatus de las claves");
        public static List<ClsRelacion> CamposQueSeMuestranEnTabla = Arrays.asList(NumeroDePantalla,NombreDePantallaMenu,NumeroDePantallaHija,NombreDePantallaMenuHija,TextoEstatus);
        public static ClsRelacion[] Estructura = {NumeroDePantalla,NumeroDePantallaHija,CveTipoDeMenu,CveApareceEnMenu,NombreDePantallaInterno,NombreDePantallaMenu,NombreDePantallaInternoHija,NombreDePantallaMenuHija,CveEstatus};
        public static String SqlVista = "CREATE VIEW " + Tabla.NombreVista() + " AS " +
                "SELECT " +
                NumeroDePantalla.Campo() + "," +
                NumeroDePantallaHija.Campo() + "," +
                CveTipoDeMenu.Campo() + "," +
                CveApareceEnMenu.Campo() + "," +
                NombreDePantallaInterno.Campo() + "," + 
                NombreDePantallaMenu.Campo() + "," + 
                NombreDePantallaInternoHija.Campo() + "," + 
                NombreDePantallaMenuHija.Campo() + "," + 
                CveEstatus.Campo() + "," +
                "(SELECT " + ClsClave.RelacionesClave.NombreDeClave.Campo() + " FROM " + ClsClave.RelacionesClave.Tabla.NombreTabla() + " WHERE " + ClsClave.RelacionesClave.NumeroDeClave.Campo() + " = 6 AND " + ClsClave.RelacionesClave.SecuencialDeClave.Campo() + " = " + CveTipoDeMenu.Campo() + ") AS " + TextoTipoDeMenu.Campo() + "," +
                "(SELECT " + ClsClave.RelacionesClave.NombreDeClave.Campo() + " FROM " + ClsClave.RelacionesClave.Tabla.NombreTabla() + " WHERE " + ClsClave.RelacionesClave.NumeroDeClave.Campo() + " = 7 AND " + ClsClave.RelacionesClave.SecuencialDeClave.Campo() + " = " + CveApareceEnMenu.Campo() + ") AS " + TextoApareceEnMenu.Campo() + "," +
                "(SELECT " + ClsClave.RelacionesClave.NombreDeClave.Campo() + " FROM " + ClsClave.RelacionesClave.Tabla.NombreTabla() + " WHERE " + ClsClave.RelacionesClave.NumeroDeClave.Campo() + " = 1 AND " + ClsClave.RelacionesClave.SecuencialDeClave.Campo() + " = " + CveEstatus.Campo() + ") AS " + TextoEstatus.Campo() + " " +
                "FROM " + Tabla.NombreTabla();
        public static String Index = "CREATE UNIQUE INDEX PK_" +Tabla.NombreTabla() + " ON " 
                + Tabla.NombreTabla() + " (" + NumeroDePantalla.Campo() + "," 
                + NumeroDePantallaHija.Campo() + "," 
                + CveTipoDeMenu.Campo() + ")";
    }
    // </editor-fold>
}
