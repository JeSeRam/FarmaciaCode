/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Glosario;

/**
 *
 * @author Freak
 * @version Beta
 */
public class Glosario {
    public static String getLoginEmpleado(){
        return "LOGIN";
    }
    public static String getLoginAdmin(){
        return "LOGIN ADMINISTRADOR";
    }
    public static String getLoginUsuario(){
        return "USUARIO";
    }
    public static String getLoginContraseña(){
        return "CONTRASEÑA";
    }
    public static String getEntrar(){
        return "ENTRAR";
    }
    public static String getRegistrar(){
        return "REGISTRAR";
    }
    public static String getGuardar(){
        return "GUARDAR";
    }
    public static String getCancelar(){
        return "CANCELAR";
    }
    public static String getAdministrador(){
        return "ADMINISTRADOR";
    }
    public static String getServidor(){
        return "SERVIDOR";
    }
    public static String getNombreDeBaseDeDatos(){
        return "BASE DE DATOS";
    }
    public static String getCrearBaseDeDatos(){
        return "CONTINUAR INSTALACIÓN";
    }
    public static String getBaseDeDatosExistente(){
        return "CONECTAR A UNA BASE EXISTENTE";
    }
    public static String FRMInstalacion_getCreaDB(){
        return "Creando Base de Datos para el sistema, esto puede tardar unos minutos.";
    }
    public static String FRMInstalacion_getTitulo(){
        return "INSTALACIÓN";
    }
    public static String General_getSiguiente(){
        return "SIGUIENTE";
    }
    public static String General_getRegresar(){
        return "REGRESAR";
    }
    public static String General_getAlta(){
        return "ALTA";
    }
    public static String General_getEdita(){
        return "EDITAR";
    }
    public static String General_getBaja(){
        return "BAJA";
    }
    /**
     * Glosario
     * @return CONFIGURAR
     */
    public static String General_getConfigurar(){
        return "CONFIGURAR";
    }
    /**
     * Glosario
     * @return PROBAR
     */
    public static String General_getProbar(){
        return "PROBAR";
    }
    /**
     * Clase de Glosario Usuario
     */
    public static class Usuario{
        /**
         * Glosario
         * @return Alta de Usuario
         */
        public static String FRMAlta_getTitulo(){
            return "Alta de Usuario";
        }
        /**
         * Glosario
         * @return Baja de Usuario 
         */
        public static String FRMBaja_getTitulo(){
            return "Baja de Usuario";
        }
        /**
         * Glosario
         * @return Edición de Usuario
         */
        public static String FRMEdita_getTitulo(){
            return "Edición de Usuario";
        }
        public static String Usuario_getTitulo(){
            return "USUARIOS";
        }
        public static String Usuario_NumeroDeUsuario(){
            return "Número de Usuario";
        }
        public static String Usuario_NombreDeUsuario(){
            return "Nombre de Usuario";
        }
        public static String Usuario_NombreDePersona(){
            return "Nombre de la Persona";
        }
        public static String Usuario_ApellidoPaterno(){
            return "Apellido Paterno";
        }
        public static String Usuario_ApellidoMaterno(){
            return "Apellido Materno";
        }
        public static String Usuario_ContraseñaDeUsuario(){
            return "Contraseña";
        }
        public static String Usuario_ContraseñaDeUsuario2(){
            return "Repetir Contraseña";
        }
        public static String Usuario_FechaDeCreacion(){
            return "Fecha de Creación";
        }
        public static String Usuario_CveTipoDeUsuario(){
            return "Tipo de Usuario";
        }
        public static String Usuario_CveEstatus(){
            return "Estatus";
        }
    }
    /**
     * Clase de Glosario Perfil
     */
    public static class Perfil{
        public static String FRMIndex_getTitulo(){
            return "Consulta Perfiles";
        }
        public static String FRMDetalle_getTitulo(){
            return "Detalle de Perfil";
        }
        public static String FRMAlta_getTitulo(){
            return "Alta de Perfil";
        }
        public static String FRMBaja_getTitulo(){
            return "Baja de Perfil";
        }
        public static String FRMEdita_getTitulo(){
            return "Edición de Perfil";
        }
        public static String Perfil_NumeroDePerfil(){
            return "Número de Perfil";
        }
        public static String Perfil_NombreDePerfil(){
            return "Nombre de Perfil";
        }
        public static String Perfil_CveEstatus(){
            return "Estatus";
        }
    }
    public static class Pantalla{
        public static String FRMAlta_getTitulo(){
            return "Alta de Perfil";
        }
        public static String FRMBaja_getTitulo(){
            return "Baja de Perfil";
        }
        public static String FRMEdita_getTitulo(){
            return "Edición de Perfil";
        }
        public static String Pantalla_getTituloEmpleado(){
            return "PANTALLAS EMPLEADO";
        }
        public static String Pantalla_getTituloAdministrador(){
            return "PANTALLAS ADMINISTRADOR";
        }
    }
    public static class DiasLaborales{
        public static String DiasLaborales_DiasLaborales(){
            return "Dias Laborales";
        }
        public static String getLunes(){
            return "Lunes";
        }
        public static String getMartes(){
            return "Martes";
        }
        public static String getMiercoles(){
            return "Miércoles";
        }
        public static String getJueves(){
            return "Jueves";
        }
        public static String getViernes(){
            return "Viernes";
        }
        public static String getSabado(){
            return "Sabado";
        }
        public static String getDomingo(){
            return "Domingo";
        }
    }
    /**
     * Clase de Glosario Correo
     */
    public static class Correo{
        /**
         * Glosario
         * @return Consulta de Correos
         */
        public static String FRMIndex_getTitulo(){
            return "Consulta Correos";
        }
        /**
         * Glosario
         * @return Alta de Correo
         */
        public static String FRMAlta_getTitulo(){
            return "Alta de Correo";
        }
        /**
         * Glosario
         * @return Edición de Correo
         */
        public static String FRMEdita_getTitulo(){
            return "Edición de Correo";
        }
        /**
         * Glosario
         * @return Detalle de Correo
         */
        public static String FRMDetalle_getTitulo(){
            return "Detalle de Correo";
        }
        /**
         * Glosario
         * @return Parametros de Correo
         */
        public static String FRMConfigurar_getTitulo(){
            return "Parametros de Correo";
        }
        public static String Correo_CveTipoDeCorreo(){
            return "Tipo de Correo";
        }
        public static String Correo_Correo(){
            return "Correo";
        }
        public static String Correo_CorreoConfig(){
            return "Correo Servidor";
        }
        public static String Correo_ContraseñaConfig(){
            return "Contraseña";
        }
        public static String Correo_PuertoConfig(){
            return "Puerto";
        }
        public static String Correo_ServidorConfig(){
            return "Servidor";
        }
        public static String Correo_ParaConfig(){
            return "Para";
        }
        public static String Correo_AsuntoConfig(){
            return "Asunto";
        }
        public static String Correo_MensajeConfig(){
            return "Mensaje";
        }
    }
    /**
     * Clase de Glosario Producto
     */
    public static class Producto{
        public static String FRMIndex_getTitulo(){
            return "Consulta de Productos";
        }
        public static String FRMAlta_getTitulo(){
            return "Alta de Producto";
        }
        public static String Producto_NumeroDeProducto(){
            return "Número de Producto / Codigo";
        }
        public static String Producto_NombreDeProducto(){
            return "Nombre de Producto";
        }
        public static String Producto_CveUnidadDeMedida(){
            return "Unidad de Media";
        }
        public static String Producto_CantidadDeMedida(){
            return "Valor de Medida";
        }
        public static String Producto_PrecioUnitario(){
            return "Precio Unitario";
        }
        public static String Producto_Descripcion(){
            return "Descripcion";
        }
        public static String Producto_CveAlertar(){
            return "Alertar Surtido";
        }
        public static String Producto_CantidadAAlertar(){
            return "Cantidad a Alertar";
        }
    }
}
