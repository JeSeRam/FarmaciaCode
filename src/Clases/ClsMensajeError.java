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
public class ClsMensajeError {
    // <editor-fold defaultstate="collapsed" desc="Variables de la Clase">
    private boolean _Estatus;
    private int _NumeroDePantalla;
    private int _Funcionalidad;
    private int _CodigoDeError;
    private String _Mensaje;
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Get & Set">
    public boolean Estatus(){
        return _Estatus;
    }
    public void Estatus(boolean Estatus){
        _Estatus = Estatus;
    }
    public int NumeroDePantalla(){
        return _NumeroDePantalla;
    }
    public void NumeroDePantalla(int NumeroDePantalla){
        _NumeroDePantalla = NumeroDePantalla;
    }
    public int Funcionalidad(){
        return _Funcionalidad;
    }
    public void Funcionalidad(int Funcionalidad){
        _Funcionalidad = Funcionalidad;
    }
    public int CodigoDeError(){
        return _CodigoDeError;
    }
    public void CodigoDeError(int CodigoDeError){
        _CodigoDeError = CodigoDeError; 
    }
    public String Mensaje(){
        return _Mensaje;
    }
    public void Mensaje(String Mensaje){
        _Mensaje = Mensaje;
    }
    // </editor-fold>
    public void ClsMensajeError(){
        
    }
}
