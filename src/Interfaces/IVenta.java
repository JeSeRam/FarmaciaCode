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
public interface IVenta {
    // <editor-fold defaultstate="collapsed" desc="Variables">
    // Tabla
    long NumeroDeVenta();
    void NumeroDeVenta(long NumeroDeVenta);
    long NumeroDeUsuario();
    void NumeroDeUsuario(long NumeroDeUsuario);
    long NumeroDeLote();
    void NumeroDeLote(long NumeroDeLote);
    long NumeroDeProducto();
    void NumeroDeProducto(long NumeroDeProducto);
    int Cantidad();
    void Cantidad(int Cantidad);
    double Precio();
    void Precio(double Precio);
    Date FechaDeVenta();
    void FechaDeVenta(Date FechaDeVenta);
    // Vista
    String NombreDeUsuario();
    void NombreDeUsuario(String NombreDeUsuario);
    String NombreDeProducto();
    void NombreDeProducto(String NombreDeProducto);
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
