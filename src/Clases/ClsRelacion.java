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
public class ClsRelacion {
    // <editor-fold defaultstate="collapsed" desc="Variables de la Clase">
    private final String _Entidad;
    private final String _Campo;
    private final String _Texto;
    private final String _TipoDeDato;
    private final String _Capacidad;
    private final String _Decimales;
    private final String _IsNull;
    private final String _Descripcion;
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Get & Set">
    public String Entidad (){
        return _Entidad;
    }
    public String Campo(){
        return _Campo;
    }
    public String Texto(){
        return _Texto;
    }
    public String TipoDeDato(){
        return _TipoDeDato;
    }
    public String Capacidad(){
        return _Capacidad;
    }
    public String Decimales(){
        return _Decimales;
    }
    public String IsNull(){
        return _IsNull;
    }
    public String Descripcion(){
        return _Descripcion;
    }
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Constructor">
    public ClsRelacion (String Entidad,String Campo,String Texto,String TipoDeDato,String Capacidad,String Decimales,String IsNull,String Descripcion){
        _Entidad = Entidad;
        _Campo = Campo;
        _Texto = Texto;
        _TipoDeDato = TipoDeDato;
        _Capacidad = Capacidad;
        _Decimales = Decimales;
        _IsNull = IsNull;
        _Descripcion = Descripcion;
    }
    // </editor-fold>
}
