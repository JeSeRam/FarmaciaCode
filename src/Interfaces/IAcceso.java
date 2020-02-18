/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import java.sql.Time;
import java.util.Date;
import java.util.Map;

/**
 *
 * @author Freak
 */
public interface IAcceso {
    // <editor-fold defaultstate="collapsed" desc="Variables">
    // Tabla
    long NumeroDeAcceso();
    void NumeroDeAcceso(long NumeroDeAcceso);
    long NumeroDePerfil();
    void NumeroDePerfil(long NumeroDePerfil);
    long NumeroDeUsuario();
    void NumeroDeUsuario(long NumeroDeUsuario);
    Date FechaDeAcceso();
    void FechaDeAcceso(Date FechaDeAcceso);
    Time HoraDeAcceso();
    void HoraDeAcceso(Time HoraDeAcceso);
    Time HoraDeSalida();
    void HoraDeSalida(Time FechaDeSalida);
    // Vista
    String NombreDePerfil();
    void NombreDePerfil(String NombreDePerfil);
    String NombreDeUsuario();
    void NombreDeUsuario(String NombreDeUsuario);
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
