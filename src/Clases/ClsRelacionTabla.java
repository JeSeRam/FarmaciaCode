/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author Freak
 */
public class ClsRelacionTabla {
    // <editor-fold defaultstate="collapsed" desc="Variables de la Clase">
    private final String _NombreTabla;
    private final String _NombreVista;
    private final String _Prefijo;
    private final String _Descipcion;
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Get & Set">
    public String NombreTabla(){
        return _NombreTabla;
    }
    public String NombreVista(){
        return _NombreVista;
    }
    public String Prefijo(){
        return _Prefijo;
    }
    public String Descripcion(){
        return _Descipcion;
    }
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Constructor">
    public ClsRelacionTabla(String NombreTabla,String NombreVista, String Prefijo, String Descripcion) {
        _NombreTabla = NombreTabla;
        _NombreVista = NombreVista;
        _Prefijo = Prefijo;
        _Descipcion = Descripcion;
    }
    // </editor-fold>
}
