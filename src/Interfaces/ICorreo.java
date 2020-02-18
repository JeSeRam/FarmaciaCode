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
public interface ICorreo {
    // <editor-fold defaultstate="collapsed" desc="Variables">
    // Tabla
    long NumeroDeCorreo();
    void NumeroDeCorreo(long NumeroDeCorreo);
    int CveTipoDeCorreo();
    void CveTipoDeCorreo(int CveTipoDeCorreo);
    String Correo();
    void Correo(String Correo);
    int CveEstatus();
    void CveEstatus(int CveEstatus);
    // Vista
    String TextoTipoDeCorreo();
    void TextoTipoDeCorreo(String TextoTipoDeCorreo);
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
