/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import ConexionMySql.ClsResultSet;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Freak
 */
public class ClsGenerica <T> {
    Object Clase = new Object();
    public ClsGenerica(T Entidad){
        Clase = Entidad;
    }
    public List<T> ParseaResulSetAList(ConexionMySql.ClsResultSet Rec,T Entidad2){
        List<T> Entidad = new ArrayList<T>();
        if (Rec.TieneRegistros()){
            while(Rec.Lee()){
               // Entidad.add(Entidad2(Rec,true));
            }
        }
        return Entidad;
    }
    public String GeneraCambiosUpdate(String CampoEntidad,Object Cambio){
        Method[] metodos = Clase.getClass().getMethods();
        for(Method c: metodos){
            if (c.getName().equals(CampoEntidad)){
                String er = c.getGenericReturnType().toString();
            }
        }
        return "";
    }
    public String CambioTipo(Object Cambio){
        if (Cambio.getClass() == String.class){
            return "'" + Cambio + "'";
        }
        return Cambio.toString();
    }
}
