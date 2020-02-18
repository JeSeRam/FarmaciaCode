/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import java.util.Date;
import java.util.Map;

/**
 *
 * @author Freak
 */
public interface IUsuario {
    // <editor-fold defaultstate="collapsed" desc="Variables">
    // Tabla
    long NumeroDeUsuario();
    void NumeroDeUsuario(long NumeroDeUsuario);
    String NombreDeUsuario();
    void NombreDeUsuario(String NombreDeUsuario);
    String NombreDePersona();
    void NombreDePersona(String NombreDePersona);
    String ApellidoPaterno();
    void ApellidoPaterno(String ApellidoPaterno);
    String ApellidoMaterno();
    void ApellidoMaterno(String ApellidoMaterno);
    String ContraseñaDeUsuario();
    void ContraseñaDeUsuario(String ContraseñaDeUsuario);
    Date FechaDeCreacion();
    void FechaDeCreacion(Date FechaDeCreacion);
    int CveTipoDeUsuario();
    void CveTipoDeUsuario(int CveTipoDeUsuario);
    int CveEstatus();
    void CveEstatus(int CveEstatus);
    // Vista
    String TextoTipoDeUsuario();
    void TextoTipoDeUsuario(String TextoTipoDeUsuario);
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
