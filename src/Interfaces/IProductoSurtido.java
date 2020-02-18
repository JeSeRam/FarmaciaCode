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
public interface IProductoSurtido {
    // <editor-fold defaultstate="collapsed" desc="Variables">
    // Tabla
    long NumeroDeProducto();
    void NumeroDeProducto(long NumeroDeProducto);
    long NumeroDeLote();
    void NumeroDeLote(long NumeroDeLote);
    Date FechaDeCaducidad();
    void FechaDeCaducidad(Date FechaDeCaducidad);
    int NumeroDePiezas();
    void NumeroDePiezas(int NumeroDePiezas);
    int Entradas();
    void Entradas(int Entradas);
    int Salidas();
    void Salidas(int Salidas);
    Date FechaDeGeneracion();
    void FechaDeGeneracion(Date FechaDeGeneracion);
    int Existentes();
    void Existentes(int Existentes);
    int CveEstatus();
    void CveEstatus(int CveEstatus);
    // Vista
    String NombreDeProducto();
    void NombreDeProducto(String NombreDeProducto);
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
