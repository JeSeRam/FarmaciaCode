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
public interface IProducto {
    // <editor-fold defaultstate="collapsed" desc="Variables">
    // Tabla
    long NumeroDeProducto();
    void NumeroDeProducto(long NumeroDeProducto);
    String NombreDeProducto();
    void NombreDeProducto(String NombreDeProducto);
    int CveUnidadDeMedida();
    void CveUnidadDeMedida(int CveUnidadDeMedida);
    String CantidadDeMedida();
    void CantidadDeMedida(String CantidadDeMedida);
    double PrecioUnitario();
    void PrecioUnitario(double PrecioUnitario);
    String Descripcion();
    void Descripcion(String Descripcion);
    int CveAlertar();
    void CveAlertar(int CveAlertar);
    int CantidadAAlertar();
    void CantidadAAlertar(int CantidadAAlertar);
    int CveEstatus();
    void CveEstatus(int CveEstatus);
    // Vista
    String TextoUnidadDeMedida();
    void TextoUnidadDeMedida(String TextoUnidadDeMedida);
    String TextoAlertar();
    void TextoAlertar(String TextoAlertar);
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
