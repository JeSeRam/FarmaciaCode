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
public interface IAlerta {
    // <editor-fold defaultstate="collapsed" desc="Variables">
    // Tabla
    long NumeroDeAlerta();
    void NumeroDeAlerta(long NumeroDeAlerta);
    long NumeroDeProducto();
    void NumeroDeProducto(long NumeroDeProducto);
    long NumeroDeUsuario();
    void NumeroDeUsuario(long NumeroDeUsuario);
    Date FechaDeAlerta();
    void FechaDeAlerta(Date FechaDeAlerta);
    int CveEnviada();
    void CveEnviada(int CveEnviada);
    int CveEstatus();
    void CveEstatus(int CveEstatus);
    // Vista
    String NombreDeProducto();
    void NombreDeProducto(String NombreDeProducto);
    String NombreDeUsuario();
    void NombreDeUsuario(String NombreDeUsuario);
    String TextoEnviada();
    void TextoEnviada(String TextoEnviada);
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
