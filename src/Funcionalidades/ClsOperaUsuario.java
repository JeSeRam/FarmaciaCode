package Funcionalidades;


import ConexionMySql.ClsConexionMySql;
import ConexionMySql.ClsResultSet;
import Entidades.ClsUsuario;
import Interfaces.CveEstatus;
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Freak
 */
public class ClsOperaUsuario {
    public Entidades.ClsUsuario Consulta(String NumeroDeUsuario,String NombreDeUsuario,String ContraseñaDeUsuario){
        ClsUsuario Usuario = new ClsUsuario();
        ClsResultSet Rec = new ClsResultSet();
        NumeroDeUsuario = "" + NumeroDeUsuario;
        NombreDeUsuario = "" + NombreDeUsuario;
        ContraseñaDeUsuario = "" + ContraseñaDeUsuario;
        String Sql = "";
        if (!NumeroDeUsuario.equals("")){
            Sql += Sql.equals("") ? " " : " and ";
            Sql += ClsUsuario.RelacionesUsuario.NumeroDeUsuario.Campo() + " = '" + NumeroDeUsuario + "'";
        }
        if (!NombreDeUsuario.equals("")){
            Sql += Sql.equals("") ? " " : " and ";
            Sql += ClsUsuario.RelacionesUsuario.NombreDeUsuario.Campo() + " = '" + NombreDeUsuario + "'";
        }
        if (!ContraseñaDeUsuario.equals("")){
            Sql += Sql.equals("") ? " " : " and ";
            Sql += ClsUsuario.RelacionesUsuario.ContraseñaDeUsuario.Campo() + " = '" + ContraseñaDeUsuario + "'";
        }
        String FiltroEstatus = ClsUsuario.RelacionesUsuario.CveEstatus.Campo() + " = " + CveEstatus.Activo;
        Sql = "select * from " + ClsUsuario.RelacionesUsuario.Tabla.NombreVista() + " where " + (Sql.equals("") ? FiltroEstatus : Sql + " and " + FiltroEstatus);
        Rec = ClsConexionMySql.Consulta(Sql);
        while (Rec.Lee()){
            Usuario = new ClsUsuario(Rec,true);
        }
        return Usuario;
    }
    public List<Entidades.ClsUsuario> ConsultaLista(String NumeroDeUsuario,String NombreDeUsuario,String ContraseñaDeUsuario,String Filtro){
        List<ClsUsuario> Usuarios = new ArrayList<ClsUsuario>();
        ClsUsuario Usuario = new ClsUsuario();
        ClsResultSet Rec = new ClsResultSet();
        NumeroDeUsuario = "" + NumeroDeUsuario;
        NombreDeUsuario = "" + NombreDeUsuario;
        ContraseñaDeUsuario = "" + ContraseñaDeUsuario;
        String Sql = "";
        if (!NumeroDeUsuario.equals("")){
            Sql += Sql.equals("") ? " " : " and ";
            Sql += ClsUsuario.RelacionesUsuario.NumeroDeUsuario.Campo() + " = '" + NumeroDeUsuario + "'";
        }
        if (!NombreDeUsuario.equals("")){
            Sql += Sql.equals("") ? " " : " and ";
            Sql += ClsUsuario.RelacionesUsuario.NombreDeUsuario.Campo() + " = '" + NombreDeUsuario + "'";
        }
        if (!ContraseñaDeUsuario.equals("")){
            Sql += Sql.equals("") ? " " : " and ";
            Sql += ClsUsuario.RelacionesUsuario.ContraseñaDeUsuario.Campo() + " = '" + ContraseñaDeUsuario + "'";
        }
        if (!Filtro.equals("")){
            Sql += Sql.equals("") ? " " : " and ";
            Sql += Filtro + " ";
        }
        String FiltroEstatus = ClsUsuario.RelacionesUsuario.CveEstatus.Campo() + " = " + CveEstatus.Activo;
        Sql = "select * from " + ClsUsuario.RelacionesUsuario.Tabla.NombreVista() + " where " + (Sql.equals("") ? FiltroEstatus : Sql + " and " + FiltroEstatus);
        Rec = ClsConexionMySql.Consulta(Sql);
        while (Rec.Lee()){
            Usuario = new ClsUsuario(Rec,true);
            Usuarios.add(Usuario);
        }
        return Usuarios;
    }
}
