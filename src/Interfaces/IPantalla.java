/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import java.util.Map;

/**
 *
 * @author Freak
 */
public interface IPantalla {
    // <editor-fold defaultstate="collapsed" desc="Variables">
    // Tabla
    long NumeroDePantalla();
    void NumeroDePantalla(long NumeroDePantalla);
    long NumeroDePantallaHija();
    void NumeroDePantallaHija(long NumeroDePantallaHija);
    int CveTipoDeMenu();
    void CveTipoDeMenu(int CveTipoDeMenu);
    int CveApareceEnMenu();
    void CveApareceEnMenu(int CveApareceEnMenu);
    String NombreDePantallaInterno();
    void NombreDePantallaInterno(String NombreDePantallaInterno);
    String NombreDePantallaMenu();
    void NombreDePantallaMenu(String NombreDePantallaMenu);
    String NombreDePantallaInternoHija();
    void NombreDePantallaInternoHija(String NombreDePantallaInternoHija);
    String NombreDePantallaMenuHija();
    void NombreDePantallaMenuHija(String NombreDePantallaMenuHija);
    int CveEstatus();
    void CveEstatus(int CveEstatus);
    // Vista
    String TextoTipoDeMenu();
    void TextoTipoDeMenu(String TextoTipoDeMenu);
    String TextoApareceEnMenu();
    void TextoApareceEnMenu(String TextoApareceEnMenu);
    String TextoEstatus();
    void TextoEstatus(String TextoEstatus);
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Funciones">
    boolean Insert();
    boolean Update(Map<String, Object> Cambios);
    boolean Delete();
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Funciones constructores sql">
    String ToDelete();
    String ToInsert();
    String ToUpdate(Map<String, Object> Cambios);
    // </editor-fold>
}
