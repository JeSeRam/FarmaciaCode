/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import ConexionMySql.ClsResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Freak
 */
public class ClsGenerica <T>{
    public List<T> ParseaResulSetAList(ConexionMySql.ClsResultSet Rec,T Entidad2){
        List<T> Entidad = new ArrayList<T>();
        if (Rec.TieneRegistros()){
            while(Rec.Lee()){
               // Entidad.add(Entidad2(Rec,true));
            }
        }
        return Entidad;
    }
}
