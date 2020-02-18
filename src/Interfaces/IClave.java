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
public interface IClave {
    // <editor-fold defaultstate="collapsed" desc="Variables">
    // Tabla
    long NumeroDeClave();
    void NumeroDeClave(long NumeroDeClave);
    int SecuencialDeClave();
    void SecuencialDeClave(int SecuencialDeClave);
    String NombreDeClave();
    void NombreDeClave(String NombreClave);
    String Descripcion();
    void Descripcion(String Descripcion);
    String DatoAdicional1();
    void DatoAdicional1(String DatoUno);
    String DatoAdicional2();
    void DatoAdicional2(String DatoDos);
    int CveEstatus();
    void CveEstatus(int ClaveEstatus);
    // Vista
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
