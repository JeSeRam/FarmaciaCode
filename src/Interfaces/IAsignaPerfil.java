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
public interface IAsignaPerfil {
    // <editor-fold defaultstate="collapsed" desc="Variables">
    // Tabla
    long NumeroDePerfil();
    void NumeroDePerfil(long NumeroDePerfil);
    long NumeroDeUsuario();
    void NumeroDeUsuario(long NumeroDeUsuario);
    int CveEstatus();
    void CveEstatus(int CveEstatus);
    // Vista
    String NombreDePerfil();
    void NombreDePerfil(String NombreDePerfil);
    String NombreDeUsuario();
    void NombreDeUsuario(String NombreDeUsuario);
    String TextoEstatus();
    void TextoEstatus(String TextoEstatus);
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Funciones">
    boolean Insert();
    boolean Update(Map<String, Object> Cambios);
    boolean Delete();
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Funciones construcores sql">
    String ToDelete();
    String ToInsert();
    String ToUpdate(Map<String, Object> Cambios);
    // </editor-fold>
}
