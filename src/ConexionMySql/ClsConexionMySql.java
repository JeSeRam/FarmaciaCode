/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConexionMySql;

import Clases.ClsEstructura;
import Clases.ClsRelacion;
import static PROYECTO.FuncionesParalelas.Contraseña.decrypt;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Freak
 * @version Beta
 */
public final class ClsConexionMySql {
    // <editor-fold defaultstate="collapsed" desc="Constructor">
    public ClsConexionMySql(String Servidor,String NombreDeUsuario,String Contraseña,String NombreDeBase,String NombreDeBasePrebia){
        _Servidor = Servidor;
        _NombreDeUsuario = NombreDeUsuario;
        _Contraseña = Contraseña;
        _NombreDeBase = NombreDeBase;
        _NombreDeBasePrebia = NombreDeBasePrebia;
    }
    public ClsConexionMySql() {
        try {
            this.CargaVariablesDeConexion();
            Class.forName("com.mysql.jdbc.Driver");
            _Conexion = DriverManager.getConnection("jdbc:mysql://" + _Servidor + "/" + _NombreDeBase + "?useSSL=false", _NombreDeUsuario, decrypt(_Contraseña));
            MensajeError.Estatus(true);
            MensajeError.NumeroDePantalla(1);
            MensajeError.Funcionalidad(1);
            MensajeError.CodigoDeError(0);
            MensajeError.Mensaje("Conectado");
        } catch (ClassNotFoundException cnfe) {
            MensajeError.Estatus(false);
            MensajeError.NumeroDePantalla(1);
            MensajeError.Funcionalidad(1);
            MensajeError.CodigoDeError(1);
            MensajeError.Mensaje(cnfe.getMessage());
        } catch (SQLException sqle) {
            MensajeError.Estatus(false);
            MensajeError.NumeroDePantalla(1);
            MensajeError.Funcionalidad(1);
            MensajeError.CodigoDeError(sqle.getErrorCode());
            MensajeError.Mensaje(sqle.getMessage());
        } catch (Exception e) {
            MensajeError.Estatus(false);
            MensajeError.NumeroDePantalla(1);
            MensajeError.Funcionalidad(1);
            MensajeError.CodigoDeError(3);
            MensajeError.Mensaje(e.getMessage());
        }
    }
    public ClsConexionMySql(boolean CreaBase) {
        try {
            this.CargaVariablesDeConexion();
            Class.forName("com.mysql.jdbc.Driver");
            _Conexion = DriverManager.getConnection("jdbc:mysql://" + _Servidor + "/" + _NombreDeBasePrebia + "?useSSL=false", _NombreDeUsuario, decrypt(_Contraseña));
            MensajeError.Estatus(true);
            MensajeError.NumeroDePantalla(1);
            MensajeError.Funcionalidad(1);
            MensajeError.CodigoDeError(0);
            MensajeError.Mensaje("Conectado");
        } catch (ClassNotFoundException cnfe) {
            MensajeError.Estatus(false);
            MensajeError.NumeroDePantalla(1);
            MensajeError.Funcionalidad(1);
            MensajeError.CodigoDeError(1);
            MensajeError.Mensaje(cnfe.getMessage());
        } catch (SQLException sqle) {
            MensajeError.Estatus(false);
            MensajeError.NumeroDePantalla(1);
            MensajeError.Funcionalidad(1);
            MensajeError.CodigoDeError(sqle.getErrorCode());
            MensajeError.Mensaje(sqle.getMessage());
        } catch (Exception e) {
            MensajeError.Estatus(false);
            MensajeError.NumeroDePantalla(1);
            MensajeError.Funcionalidad(1);
            MensajeError.CodigoDeError(3);
            MensajeError.Mensaje(e.getMessage());
        }
        
    }// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Crea DataBase">
    public List<String> CreaRegistros() {
        Date d = new Date();  
        SimpleDateFormat plantilla = new SimpleDateFormat("yy/MM/dd HH:mm:ss");
        String tiempo = plantilla.format(d);
        List<String>Registros = new ArrayList<String>();
        Registros.add("insert into clave values (1,1,'Activo','Estatus de los registros',null,null,1)");
        Registros.add("insert into clave values (1,2,'Baja','Estatus de los registros',null,null,1)");
        Registros.add("insert into clave values (1,3,'Pendiente de Surtir','Estatus de los registros',null,null,1)");
        Registros.add("insert into clave values (2,1,'Administrador','Tipo de usuario',null,null,1)");
        Registros.add("insert into clave values (2,2,'Empleado','Estatus de los registros',null,null,1)");
        Registros.add("insert into clave values (2,3,'Empleado / Administrador','Estatus de los registros',null,null,1)");
        Registros.add("insert into clave values (3,1,'SI','Alertar para surtir',null,null,1)");
        Registros.add("insert into clave values (3,2,'NO','Alertar para surtir',null,null,1)");
        Registros.add("insert into clave values (4,1,'Enviada','Estatus de envio de alerta',null,null,1)");
        Registros.add("insert into clave values (4,2,'Sin Enviar','Estatus de envio de alerta',null,null,1)");
        Registros.add("insert into clave values (5,1,'Alertas','Tipo de Correo',null,null,1)");
        Registros.add("insert into clave values (5,2,'Reporteria','Tipo de Correo',null,null,1)");
        Registros.add("insert into clave values (5,3,'Bugs','Tipo de Correo',null,null,2)");
        Registros.add("insert into clave values (6,1,'EMPLEADO','Tipo de Menu',null,null,1)");
        Registros.add("insert into clave values (6,2,'ADMINISTRADOR','Tipo de Menu',null,null,1)");
        Registros.add("insert into clave values (7,1,'SI','Si y No generico',null,null,1)");
        Registros.add("insert into clave values (7,2,'NO','Si y No generico',null,null,1)");
        Registros.add("insert into clave values (1000,1,'true','mail.smtp.auth',null,null,1)");
        Registros.add("insert into clave values (1000,2,'true','mail.smtp.starttls.enable',null,null,1)");
        Registros.add("insert into clave values (1000,3,'smtp.gmail.com','mail.smtp.host',null,null,1)");
        Registros.add("insert into clave values (1000,4,'true','mail.smtp.debug',null,null,1)");
        Registros.add("insert into clave values (1000,5,'587','mail.smtp.port',null,null,1)");
        Registros.add("insert into clave values (1000,6,'no.reply.servicehm@gmail.com','CorreoServidor',null,null,1)");
        Registros.add("insert into clave values (1000,7,'HM535342','ContraseñaServidor',null,null,1)");
        // Sequences
        Registros.add("insert into sequence values ('correo_seq',1,1,99999999999999,1,false)");
        // Usuario y Perfil
        Registros.add("insert into usuario values (1,'admin','','','','admin','" + tiempo +"',1,1)");
        Registros.add("insert into perfil values (1,'ADMINISTRADOR',1)");
        Registros.add("insert into asignaperfil values (1,1,1)");
        // Pantalla Perfil
        Registros.add("insert into pantallaperfil values (1,1,1,0,1)");
        Registros.add("insert into pantallaperfil values (1,2,2,0,1)");
        Registros.add("insert into pantallaperfil values (1,2,3,0,1)");
        Registros.add("insert into pantallaperfil values (1,2,3,1,1)");
        Registros.add("insert into pantallaperfil values (1,2,3,2,1)");
        Registros.add("insert into pantallaperfil values (1,2,3,3,1)");
        Registros.add("insert into pantallaperfil values (1,2,4,0,1)");
        Registros.add("insert into pantallaperfil values (1,2,4,4,1)");
        Registros.add("insert into pantallaperfil values (1,2,4,5,1)");
        Registros.add("insert into pantallaperfil values (1,2,4,6,1)");
        Registros.add("insert into pantallaperfil values (1,2,4,7,1)");
        Registros.add("insert into pantallaperfil values (1,2,5,0,1)");
        Registros.add("insert into pantallaperfil values (1,2,5,8,1)");
        Registros.add("insert into pantallaperfil values (1,2,5,9,1)");
        Registros.add("insert into pantallaperfil values (1,2,5,10,1)");
        Registros.add("insert into pantallaperfil values (1,2,5,11,1)");
        Registros.add("insert into pantallaperfil values (1,2,5,12,1)");
        Registros.add("insert into pantallaperfil values (1,1,6,0,1)");
        Registros.add("insert into pantallaperfil values (1,1,6,13,1)");
        Registros.add("insert into pantallaperfil values (1,1,6,14,1)");
        Registros.add("insert into pantallaperfil values (1,1,7,0,1)");
        Registros.add("insert into pantallaperfil values (1,1,7,15,1)");
        Registros.add("insert into pantallaperfil values (1,1,7,16,1)");
        Registros.add("insert into pantallaperfil values (1,1,7,17,1)");
        Registros.add("insert into pantallaperfil values (1,1,7,18,1)");
        Registros.add("insert into pantallaperfil values (1,1,7,19,1)");
        // Pantallas
        Registros.add("insert into pantalla values (0,0,1,1,'FRMInstalacion','Instalacion del sistema','','',1)");
        Registros.add("insert into pantalla values (1,0,1,1,'FRMLogin','Login','','',1)");
        Registros.add("insert into pantalla values (2,0,2,1,'FRMRegistrar','Login de Administrador','','',1)");
        Registros.add("insert into pantalla values (3,0,2,1,'FRMUsuario','Usuarios','','',1)");
        Registros.add("insert into pantalla values (3,1,2,1,'FRMUsuario','Usuarios','Usuario.FRMAlta','Alta',1)");
        Registros.add("insert into pantalla values (3,2,2,1,'FRMUsuario','Usuarios','Usuario.FRMBaja','Baja',1)");
        Registros.add("insert into pantalla values (3,3,2,1,'FRMUsuario','Usuarios','Usuario.FRMEdita','Edita',1)");
        Registros.add("insert into pantalla values (4,0,2,1,'FRMPerfil','Perfiles','','',1)");
        Registros.add("insert into pantalla values (4,4,2,1,'FRMPerfil','Perfiles','Perfil.FRMIndex','Perfiles',1)");
        Registros.add("insert into pantalla values (4,5,2,2,'FRMPerfil','Perfiles','Perfil.FRMDetalle','Detalle',1)");
        Registros.add("insert into pantalla values (4,6,2,2,'FRMPerfil','Perfiles','Perfil.FRMAlta','Alta',1)");
        Registros.add("insert into pantalla values (4,7,2,2,'FRMPerfil','Perfiles','Perfil.FRMEdita','Edita',1)");
        Registros.add("insert into pantalla values (5,0,2,1,'FRMCorreo','Correos','','',1)");
        Registros.add("insert into pantalla values (5,8,2,1,'FRMCorreo','Correos','Correo.FRMIndex','Correos',1)");
        Registros.add("insert into pantalla values (5,9,2,2,'FRMCorreo','Correos','Correo.FRMDetalle','Detalle',1)");
        Registros.add("insert into pantalla values (5,10,2,2,'FRMCorreo','Correos','Correo.FRMAlta','Alta',1)");
        Registros.add("insert into pantalla values (5,11,2,2,'FRMCorreo','Correos','Correo.FRMEdita','Edita',1)");
        Registros.add("insert into pantalla values (5,12,2,2,'FRMCorreo','Correos','Correo.FRMConfigurar','Configuración',1)");
        Registros.add("insert into pantalla values (6,0,1,1,'FRMVenta','Ventas','','',1)");
        Registros.add("insert into pantalla values (6,13,1,1,'FRMVenta','Ventas','Venta.FRMAlta','Alta',1)");
        Registros.add("insert into pantalla values (6,14,1,1,'FRMVenta','Ventas','Venta.FRMConsulta','Ventas',1)");
        Registros.add("insert into pantalla values (7,0,1,1,'FRMProducto','Productos','','',1)");
        Registros.add("insert into pantalla values (7,15,1,1,'FRMProducto','Productos','Producto.FRMIndex','Productos',1)");
        Registros.add("insert into pantalla values (7,16,1,2,'FRMProducto','Productos','Producto.FRMDetalle','Detalle',1)");
        Registros.add("insert into pantalla values (7,17,1,2,'FRMProducto','Productos','Producto.FRMAlta','Alta',1)");
        Registros.add("insert into pantalla values (7,18,1,2,'FRMProducto','Productos','Producto.FRMEdita','Edita',1)");
        Registros.add("insert into pantalla values (7,19,1,1,'FRMProducto','Productos','Producto.FRMSurtir','Surtir Producto',1)");
        return Registros;
    }
    public List<String> CreaEstructuraDB() {
        try {
            List<ClsEstructura> ArregloRelaciones = CreaListaDeTablas();
            ClsRelacion[] Estructura;
            List<String>CreaBase = new ArrayList<String>();
            // Crea Base de datos y la usa
            CreaBase.add("CREATE DATABASE " + _NombreDeBase);
            CreaBase.add("USE " + _NombreDeBase);
            // Crea Tablas
            for (ClsEstructura Relaciones: ArregloRelaciones){
                Estructura = Relaciones.Estructura();
                String Tabla = "CREATE TABLE " + Relaciones.Tabla().NombreTabla() + " (";
                for (int i = 0;i < Estructura.length; i++){
                    Tabla += Estructura[i].Campo().toUpperCase();
                    Tabla += " " + ConvierteTipoDeDatoBase(Estructura[i].TipoDeDato().toUpperCase());
                    Tabla += LongitudDeCampos(Estructura[i].TipoDeDato().toUpperCase(),Estructura[i].Capacidad(),Estructura[i].Decimales());
                    Tabla += " " + Estructura[i].IsNull().toUpperCase() + ",";
                }
                Tabla = Tabla.substring(0, Tabla.length() - 1) + ")";
                CreaBase.add(Tabla);
            }
            // Crea Vistas
            
            for (ClsEstructura Relaciones: ArregloRelaciones){
                CreaBase.add(Relaciones.Index());
            }
            for (ClsEstructura Relaciones: ArregloRelaciones){
                CreaBase.add(Relaciones.Vista());
            }
            return CreaBase;
        } catch (Exception e) {
            MensajeError.Estatus(false);
            MensajeError.NumeroDePantalla(1);
            MensajeError.Funcionalidad(2);
            MensajeError.CodigoDeError(3);
            MensajeError.Mensaje(e.getMessage());
        }
        return new ArrayList<String>();
    }
    public boolean CreaDB(String Sql){
        boolean estatus = true;
        try{
            // Inserta todo
            IniciaTrnsaccion();
            if (!Transaccion(Sql)) {
                    estatus = false;
                }
            if (estatus) {
                MensajeError.Estatus(true);
                MensajeError.Mensaje("Se Cargo completamente la base de datos.");
                MensajeError.CodigoDeError(0);
                Commit();
            } else {
                MensajeError.Estatus(false);
                MensajeError.Mensaje("Error al crear base de datos.");
                MensajeError.CodigoDeError(4);
                Rollback();
            }    
        }catch(Exception e){
            estatus = false;
            MensajeError.Estatus(false);
            MensajeError.NumeroDePantalla(1);
            MensajeError.Funcionalidad(2);
            MensajeError.CodigoDeError(3);
            MensajeError.Mensaje(e.getMessage());
            Rollback();
        }
        return estatus;
    }
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Consulta">
    public static ClsResultSet Consulta(String Sql) {
        ClsResultSet clsResultSet = new ClsResultSet();
        ResultSet rec = null;
        try {
            rec = _Conexion.createStatement().executeQuery(Sql);
            clsResultSet.AsignaRsultSet(rec);
            System.out.println(Formato.format(Fecha) + " | " + Sql);
        } catch (SQLException sqle) {
            return clsResultSet;
        }
        return clsResultSet;
    }// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Transaccion">

    public static boolean Transaccion(String Sql) {
        Statement st = null;
        try {
            st = _Conexion.createStatement();
            st.execute(Sql);
            return true;
        } catch (SQLException sqle) {
            return false;
        } finally {
            System.out.println(Formato.format(Fecha) + " | " + Sql);
            try {
                if (st != null) {
                    st.close();
                }
            } catch (SQLException sqle) {
                return false;
            }
        }
    }// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="IniciaTransaccion">

    public static void IniciaTrnsaccion() {
        try {
            _Conexion.setAutoCommit(false);
        } catch (SQLException sqle) {

        }
    }// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Commit">

    public static void Commit() {
        try {
            _Conexion.commit();
            _Conexion.setAutoCommit(true);
        } catch (SQLException sqle) {

        }
    }// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Rollback">

    public static void Rollback() {
        try {
            _Conexion.rollback();
            _Conexion.setAutoCommit(true);
        } catch (SQLException sqle) {

        }
    }// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Crea lista para DataBase">
    private List<ClsEstructura> CreaListaDeTablas (){
        List<ClsEstructura> ArregloRelaciones = new ArrayList<ClsEstructura>();
        ArregloRelaciones.add(new ClsEstructura(Entidades.ClsAcceso.RelacionesAcceso.Tabla, Entidades.ClsAcceso.RelacionesAcceso.Estructura, Entidades.ClsAcceso.RelacionesAcceso.SqlVista, Entidades.ClsAcceso.RelacionesAcceso.Index));
        ArregloRelaciones.add(new ClsEstructura(Entidades.ClsAlerta.RelacionesAlerta.Tabla, Entidades.ClsAlerta.RelacionesAlerta.Estructura, Entidades.ClsAlerta.RelacionesAlerta.SqlVista, Entidades.ClsAlerta.RelacionesAlerta.Index));
        ArregloRelaciones.add(new ClsEstructura(Entidades.ClsAsignaPerfil.RelacionesAsignaPerfil.Tabla, Entidades.ClsAsignaPerfil.RelacionesAsignaPerfil.Estructura, Entidades.ClsAsignaPerfil.RelacionesAsignaPerfil.SqlVista, Entidades.ClsAsignaPerfil.RelacionesAsignaPerfil.Index));
        ArregloRelaciones.add(new ClsEstructura(Entidades.ClsClave.RelacionesClave.Tabla, Entidades.ClsClave.RelacionesClave.Estructura, Entidades.ClsClave.RelacionesClave.SqlVista, Entidades.ClsClave.RelacionesClave.Index));
        ArregloRelaciones.add(new ClsEstructura(Entidades.ClsCorreo.RelacionesCorreo.Tabla , Entidades.ClsCorreo.RelacionesCorreo.Estructura, Entidades.ClsCorreo.RelacionesCorreo.SqlVista, Entidades.ClsCorreo.RelacionesCorreo.Index));
        ArregloRelaciones.add(new ClsEstructura(Entidades.ClsDiasLaborales.RelacionesDiasLaborales.Tabla, Entidades.ClsDiasLaborales.RelacionesDiasLaborales.Estructura, Entidades.ClsDiasLaborales.RelacionesDiasLaborales.SqlVista, Entidades.ClsDiasLaborales.RelacionesDiasLaborales.Index));
        ArregloRelaciones.add(new ClsEstructura(Entidades.ClsPantalla.RelacionesPantalla.Tabla, Entidades.ClsPantalla.RelacionesPantalla.Estructura, Entidades.ClsPantalla.RelacionesPantalla.SqlVista, Entidades.ClsPantalla.RelacionesPantalla.Index));
        ArregloRelaciones.add(new ClsEstructura(Entidades.ClsPerfil.RelacionesPerfil.Tabla, Entidades.ClsPerfil.RelacionesPerfil.Estructura , Entidades.ClsPerfil.RelacionesPerfil.SqlVista, Entidades.ClsPerfil.RelacionesPerfil.Index));
        ArregloRelaciones.add(new ClsEstructura(Entidades.ClsPantallaPerfil.RelacionesPantallaPerfil.Tabla, Entidades.ClsPantallaPerfil.RelacionesPantallaPerfil.Estructura, Entidades.ClsPantallaPerfil.RelacionesPantallaPerfil.SqlVista, Entidades.ClsPantallaPerfil.RelacionesPantallaPerfil.Index));
        ArregloRelaciones.add(new ClsEstructura(Entidades.ClsProducto.RelacionesProducto.Tabla, Entidades.ClsProducto.RelacionesProducto.Estructura, Entidades.ClsProducto.RelacionesProducto.SqlVista, Entidades.ClsProducto.RelacionesProducto.Index));
        ArregloRelaciones.add(new ClsEstructura(Entidades.ClsProductoSurtido.RelacionesProcutoSurtido.Tabla, Entidades.ClsProductoSurtido.RelacionesProcutoSurtido.Estructura, Entidades.ClsProductoSurtido.RelacionesProcutoSurtido.SqlVista, Entidades.ClsProductoSurtido.RelacionesProcutoSurtido.Index));
        ArregloRelaciones.add(new ClsEstructura(Entidades.ClsUsuario.RelacionesUsuario.Tabla, Entidades.ClsUsuario.RelacionesUsuario.Estructura, Entidades.ClsUsuario.RelacionesUsuario.SqlVista, Entidades.ClsUsuario.RelacionesUsuario.Index));
        ArregloRelaciones.add(new ClsEstructura(Entidades.ClsVenta.RelacionesVenta.Tabla, Entidades.ClsVenta.RelacionesVenta.Estructura, Entidades.ClsVenta.RelacionesVenta.SqlVista, Entidades.ClsVenta.RelacionesVenta.Index));
        ArregloRelaciones.add(new ClsEstructura(Entidades.ClsSequence.RelacionesSequence.Tabla, Entidades.ClsSequence.RelacionesSequence.Estructura, Entidades.ClsSequence.RelacionesSequence.SqlVista, Entidades.ClsSequence.RelacionesSequence.Index));
        return ArregloRelaciones;
    }
    private String ConvierteTipoDeDatoBase(String TipoDato){
        String TipoDeDatoBase = "";
        switch(TipoDato){
            case "STRING":
                TipoDeDatoBase = "VARCHAR";
                break;
            default:
                TipoDeDatoBase = TipoDato;
                break;
        }
        return TipoDeDatoBase;
    }
    private String LongitudDeCampos(String TipoDeDato,String Enteros,String Decimales){
        String Dimencion = "";
        switch(TipoDeDato){
            case "STRING":
                Dimencion = " (" + Enteros + ")";
                break;
            case "NUMERIC":
                Dimencion = " (" + Enteros + "," +Decimales +")";
                break;
            case "DATETIME":
                Dimencion = "";
                break;
            case "BOOLEAN":
                Dimencion = "";
                break;
            case "INT":
                Dimencion = " (" + Enteros + ")";
                break;
            case "BIGINT":
                Dimencion = " (" + Enteros + ")";
                break;
            default:
                if (Enteros.length() != 0){
                    Dimencion = " (" + Enteros;
                    if (Decimales.length() != 0){
                        Dimencion += "," + Decimales + ")"; 
                    }
                }else{
                    Dimencion = "";
                }
                break;
        }
        return Dimencion;
    }
    public Clases.ClsMensajeError RegresaEstatus(){
        return MensajeError;
    }
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Lecctuara de Archivo Conexion">
    public void CargaVariablesDeConexion() {
        String Configuracion = Clases.ClsManejadorDeArchivos.LeerArchivo(System.getProperty("user.dir") + "/src/Content/AppData/Key.lbl", false);
        String[] Valores = Configuracion.split(";");
        for (String CamposValor: Valores){
            String[] CampoValor = CamposValor.split(":");
            if (CampoValor.length == 2){
                if(null != CampoValor[0])switch (CampoValor[0]) {
                    case "Servidor":
                        _Servidor = CampoValor[1];
                        break;
                    case "NombreDeUsuario":
                        _NombreDeUsuario = CampoValor[1];
                        break;
                    case "Contraseña":
                        _Contraseña = CampoValor[1];
                        break;
                    case "NombreDeBase":
                        _NombreDeBase = CampoValor[1];
                        break;
                    case "NombreDeBasePrebia":
                        _NombreDeBasePrebia = CampoValor[1];
                        break;
                    default:
                        break;
                }
            }
        }
    }
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Declaracion de variables">
    private static Connection _Conexion = null;
    private String _Servidor = "JeSeRamCorp";
    private String _NombreDeUsuario = "Aplicativo";
    private String _Contraseña = "12345";
    private String _NombreDeBase = "ADMON";
    private String _NombreDeBasePrebia = "sys";
    private Clases.ClsMensajeError MensajeError = new Clases.ClsMensajeError();
    private static Date Fecha = new Date();
    private static SimpleDateFormat Formato = new SimpleDateFormat("dd-MM-YYYY HH:mm:ss");
    // </editor-fold>
}
