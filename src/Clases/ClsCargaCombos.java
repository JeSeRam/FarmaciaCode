/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import Entidades.ClsClave;
import Funcionalidades.ClsOperaClave;
import java.util.List;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Freak
 */
public class ClsCargaCombos {
    private int SecuencialDeClave;
    private String NombreDeClave;
    public ClsCargaCombos(){
        
    }
    public ClsCargaCombos(Object Combo){
        ClsCargaCombos CargaCombo = (ClsCargaCombos) Combo;
    }
    public ClsCargaCombos(int SecuencialDeClave,String NombreDeClave){
        this.SecuencialDeClave = SecuencialDeClave;
        this.NombreDeClave = NombreDeClave;
    }
    public int SecuencialDeClave(){
        return SecuencialDeClave;
    }
    public String NombreDeClave(){
        return NombreDeClave;
    }
            @Override
        public String toString() {
            return NombreDeClave;
        }
        @Override
        public int hashCode() {
            int hash = 5;
            return hash;
        }
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ClsCargaCombos other = (ClsCargaCombos) obj;
        if (this.SecuencialDeClave != other.SecuencialDeClave()) {
            return false;
        }
        return true;
    }
    public static int CambiaClave(String NumeroDeClave,String SecuencialDeClave,String TextoCve){
        List<ClsClave>  Claves = (new ClsOperaClave()).ConsultaLista(NumeroDeClave, SecuencialDeClave,"");
        for(ClsClave Clave:Claves){
            if (!Clave.equals(new ClsClave())){
                if(Clave.NombreDeClave().equals(TextoCve)){
                    return Clave.SecuencialDeClave();
                }
            }
        }
        return 0;
    }
    public static String[] CargaComboCveTipoCorreo(boolean OpSeleccionar,String TextoPorDefecto){
        String[] ArrCombo =  null;
        List<ClsClave> Clave = (new ClsOperaClave()).ConsultaLista("5", "", "");
        
        if (OpSeleccionar){ 
            ArrCombo = new String[Clave.size() + 1];
            int cont = 0;
            ArrCombo[cont] = TextoPorDefecto;
            cont++;
            for (ClsClave clave : Clave) {
                ArrCombo[cont] = clave.SecuencialDeClave() + " - " + clave.NombreDeClave();
                cont ++; 
            }
        }else{
            ArrCombo = new String[Clave.size()];
            int cont = 0;
            for (ClsClave clave : Clave) {
                ArrCombo[cont] = clave.SecuencialDeClave() + " - " + clave.NombreDeClave();
                cont ++; 
            }
        }
        return ArrCombo;
    }
    public static int SelectIndex(Object combo){
        try{
            return Integer.parseInt(combo.toString().split("-")[0].trim());
        }catch(Exception e){
            return 0;
        }
    }
    public static DefaultComboBoxModel CargaComboPorClave(String NumeroDeClave,String SecuencialDeClave,String TextoPorDefecto,boolean AgregaIndex){
        DefaultComboBoxModel Combo = new DefaultComboBoxModel();
        try{
            List<ClsClave>  Claves = (new ClsOperaClave()).ConsultaLista(NumeroDeClave, SecuencialDeClave,"");
            if(!TextoPorDefecto.equals("")){
                Combo.addElement(new ClsCargaCombos(0, TextoPorDefecto));
            }
            for (ClsClave clave : Claves) {
                if (!AgregaIndex){
                    Combo.addElement(new ClsCargaCombos(clave.SecuencialDeClave(),clave.NombreDeClave()));
                }else{
                    Combo.addElement(new ClsCargaCombos(clave.SecuencialDeClave(),clave.SecuencialDeClave() + " - " + clave.NombreDeClave()));
                }
            }
            return Combo;
        }catch(Exception ex){
            return new DefaultComboBoxModel();
        }
    }
}
