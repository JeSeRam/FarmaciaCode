/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConexionMySql;

import java.util.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

/**
 *
 * @author Freak
 */
public class ClsResultSet {

    public ClsResultSet() {
        
    }
    public void AsignaRsultSet (ResultSet Rec){
        _Rec = Rec;
    }
    public boolean Lee(){
        boolean estatus=true;
        try{
            if (!_Rec.next()){
                estatus = false;
            }
        }catch(SQLException sqle){
            
        }
        return estatus;
    }
    public boolean TieneRegistros(){
        boolean estatus = true;
        try{
            if(!_Rec.next()){
                estatus = false;
            }
        }catch(SQLException sqle){
            
        }
        return estatus;
    }
    public Object Campo(int NumeroDeCampo){
        Object Rec="";
        try{
            if(_Rec.getObject(NumeroDeCampo) != null){
                Rec = _Rec.getObject(NumeroDeCampo);
            }
        }catch(SQLException sqle){
            
        }
        return Rec;
    }
    public Object Campo(String NombreDelCampo){
        Object Rec="";
        try{
            if(_Rec.getObject(NombreDelCampo) != null){
                Rec = _Rec.getObject(NombreDelCampo);
            }
        }catch(SQLException sqle){
            
        }
        return Rec;
    }
    public Object CampoNumerico(int NumeroDeCampo){
        Object Rec=0;
        try{
            if(_Rec.getObject(NumeroDeCampo) != null){
                Rec = _Rec.getObject(NumeroDeCampo);
            }
        }catch(SQLException sqle){
            
        }
        return Rec;
    }
    public Object CampoNumerico(String NombreDelCampo){
        Object Rec=0;
        try{
            if(_Rec.getObject(NombreDelCampo) != null){
                Rec = _Rec.getObject(NombreDelCampo);
            }
        }catch(SQLException sqle){
            
        }
        return Rec;
    }
    public Object CampoFecha(int NumeroDeCampo){
        Object Rec= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(1999, 1, 1, 0, 0, 0));
        try{
            if(_Rec.getObject(NumeroDeCampo) != null){
                Rec = _Rec.getObject(NumeroDeCampo);
            }
        }catch(SQLException sqle){
            
        }
        return Rec;
    }
    public Object CampoFecha(String NombreDelCampo){
        Object Rec= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(1999, 1, 1, 0, 0, 0));
        try{
            if(_Rec.getObject(NombreDelCampo) != null){
                Rec = _Rec.getObject(NombreDelCampo);
            }
        }catch(SQLException sqle){
            
        }
        return Rec;
    }
    private ResultSet _Rec;
}
