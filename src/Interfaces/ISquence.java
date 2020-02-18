/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

/**
 *
 * @author Freak
 */
public interface ISquence {
    // <editor-fold defaultstate="collapsed" desc="Variables">
    // Tabla
    String NombreDeSequencia();
    void NombreDeSequencia(String NombreDeSequencia);
    long Incrementar();
    void Incrementar(long Incrementar);
    long ValorMinimo();
    void ValorMinimo(long ValorMinimo);
    long ValorMaximo();
    void ValorMaximo(long ValorMaximo);
    long Valor();
    void Valor(long Valor);
    boolean Ciclo();
    void Ciclo(boolean Ciclo);
    // Vista
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Funciones">
    boolean Insert();
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Funciones construcores sql">
    String ToInsert();
    // </editor-fold>
}
