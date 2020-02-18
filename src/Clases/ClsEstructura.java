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
public class ClsEstructura {
    // <editor-fold defaultstate="collapsed" desc="Variables de la Clase">
    private final ClsRelacionTabla _Tabla;
    private final ClsRelacion[] _Estructura;
    private final String _Vista;
    private final String _Index;
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Get & Set">
    public ClsRelacionTabla Tabla(){
        return _Tabla;
    }
    public ClsRelacion[] Estructura (){
        return _Estructura;
    }
    public String Vista(){
        return _Vista;
    }
    public String Index(){
        return _Index;
    }
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Constructor">
    public ClsEstructura(ClsRelacionTabla Tabla,ClsRelacion[] Estructura,String Vista,String Index){
        _Tabla = Tabla;
        _Estructura = Estructura;
        _Vista = Vista;
        _Index = Index;
    }
    // </editor-fold>
}
