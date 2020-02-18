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
public interface IPantallaPerfil {
    // <editor-fold defaultstate="collapsed" desc="Variables">
    // Tabla
    long NumeroDePerfil();
    void NumeroDePerfil(long NumeroDePerfil);
    int CveTipoDeMenu();
    void CveTipoDeMenu(int CveTipoDeMenu);
    long NumeroDePantalla();
    void NumeroDePantalla(long NumeroDePantalla);
    long NumeroDePantallaHija();
    void NumeroDePantallaHija(long NumeroDePantallaHija);
    int CveEstatus();
    void CveEstatus(int CveEstatus);
    // Vista
    String NombreDePerfil();
    void NombreDePerfil(String NombreDePerfil);
    String TextoTipoDeMenu();
    void TextoTipoDeMenu(String TextoTipoDeMenu);
    String NombreDePantallaInterno();
    void NombreDePantallaInterno(String NombreDePantallaInterno);
    String NombreDePantallaMenu();
    void NombreDePantallaMenu(String NombreDePantallaMenu);
    String NombreDePantallaInternoHija();
    void NombreDePantallaInternoHija(String NombreDePantallaInternoHija);
    String NombreDePantallaMenuHija();
    void NombreDePantallaMenuHija(String NombreDePantallaMenuHija);
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
