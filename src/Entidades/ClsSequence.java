/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import Clases.ClsRelacion;
import Clases.ClsRelacionTabla;
import ConexionMySql.ClsConexionMySql;
import Interfaces.ISquence;

/**
 *
 * @author Freak
 */
public class ClsSequence implements ISquence{
    // <editor-fold defaultstate="collapsed" desc="Variables de la Clase">
    // Tabla
    private String _NombreDeSequencia;
    private long _Incrementar;
    private long _ValorMinimo;
    private long _ValorMaximo;
    private long _Valor;
    private boolean _Ciclo;
     // Vista
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Get & Set">
    // Tabla
    @Override
    public String NombreDeSequencia() {
        return _NombreDeSequencia;
    }

    @Override
    public void NombreDeSequencia(String NombreDeSequencia) {
        _NombreDeSequencia = NombreDeSequencia;
    }

    @Override
    public long Incrementar() {
        return _Incrementar;
    }

    @Override
    public void Incrementar(long Incrementar) {
        _Incrementar = Incrementar;
    }

    @Override
    public long ValorMinimo() {
        return _ValorMinimo;
    }

    @Override
    public void ValorMinimo(long ValorMinimo) {
        _ValorMinimo = ValorMinimo;
    }

    @Override
    public long ValorMaximo() {
        return _ValorMaximo;
    }

    @Override
    public void ValorMaximo(long ValorMaximo) {
        _ValorMaximo = ValorMaximo;
    }

    @Override
    public long Valor() {
        return _Valor;
    }

    @Override
    public void Valor(long Valor) {
        _Valor = Valor;
    }

    @Override
    public boolean Ciclo() {
        return _Ciclo;
    }

    @Override
    public void Ciclo(boolean Ciclo) {
        _Ciclo = Ciclo;
    }
    // Vista
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Funciones">
    @Override
    public boolean Insert() {
        String sql = ToInsert();
        if(ClsConexionMySql.Transaccion(sql)){
            return true;
        }
        return false;
    }
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Funciones constructores sql">
    @Override
    public String ToInsert() {
        String sql = "";
        sql = "insert into " + RelacionesSequence.Tabla.NombreTabla() + " ("
                + RelacionesSequence.NombreDeSequencia.Campo() + ","
                + RelacionesSequence.Incrementar.Campo() + ","
                + RelacionesSequence.ValorMinimo.Campo() + ","
                + RelacionesSequence.ValorMaximo.Campo() + ","
                + RelacionesSequence.Valor.Campo() + ","
                + RelacionesSequence.Ciclo.Campo()
                + ") values ("
                + _NombreDeSequencia + ","
                + _Incrementar + ","
                + _ValorMinimo + ","
                + _ValorMaximo
                + _Valor + ","
                + _Ciclo + ")";
        return sql;
    }
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Relaciones">
    public static class RelacionesSequence {
        public static ClsRelacionTabla Tabla = new ClsRelacionTabla("Sequence","NEXTVAL", "sqe", "Tabla de Sequencias");
        public static ClsRelacion NombreDeSequencia = new ClsRelacion("NombreDeSequencia", "sqe_nombre_sequence", "Nombre de Sequencia","String","100","0","NOT NULL","Nombre de Sequencia");
        public static ClsRelacion Incrementar = new ClsRelacion("Incrementar", "sqe_numero_incrementar", "Número a incrementar","Numeric","4","0","NOT NULL DEFAULT 1","Número a incrementar");
        public static ClsRelacion ValorMinimo = new ClsRelacion("ValorMinimo", "sqe_numero_min", "Número Minimo","Numeric","4","0","NOT NULL DEFAULT 1","Número Minimo");
        public static ClsRelacion ValorMaximo = new ClsRelacion("ValorMaximo", "sqe_numero_max", "Número Maximo","bigint","20","0","NOT NULL DEFAULT 9223372036854775807","Número Maximo");
        public static ClsRelacion Valor = new ClsRelacion("Valor", "sqe_val_inicial", "Valor Inicial","bigint","20","0","NOT NULL DEFAULT 1","Valor Inicial");
        public static ClsRelacion Ciclo = new ClsRelacion("Ciclo", "sqe_ciclo", "Ciclo","boolean","","","NOT NULL DEFAULT FALSE","Ciclo");
        public static ClsRelacion[] Estructura = {NombreDeSequencia,Incrementar,ValorMinimo,ValorMaximo,Valor,Ciclo};
        public static String SqlVista = "CREATE FUNCTION " + Tabla.NombreVista()+ " (F_" + NombreDeSequencia.Campo() + " varchar(" + NombreDeSequencia.Capacidad() + ")) " +
                "RETURNS bigint NOT DETERMINISTIC " +
                "BEGIN " +
                "DECLARE F_" + Valor.Campo() + " bigint; " +
                "SELECT " + Valor.Campo() + " INTO F_" + Valor.Campo() + " FROM " + Tabla.NombreTabla() + " " +
                "WHERE " + NombreDeSequencia.Campo() + " = F_" +NombreDeSequencia.Campo() + ";" +
                "IF F_" + Valor.Campo() + " IS NOT NULL THEN " +
                "UPDATE " + Tabla.NombreTabla() + " SET " +
                Valor.Campo() + " = IF ((" + Valor.Campo() + " + " + Incrementar.Campo() + ") > " + ValorMaximo.Campo() + " OR (" + Valor.Campo() + " + " + Incrementar.Campo() + ") < " + ValorMinimo.Campo() + "," +
                "IF (" + Ciclo.Campo() + " = TRUE, IF ((" + Valor.Campo() + " + " + Incrementar.Campo() + ") > " + ValorMaximo.Campo() + "," + ValorMinimo.Campo() + "," + ValorMaximo.Campo() + "),NULL)," +
                Valor.Campo() + " + " + Incrementar.Campo() + ") WHERE " + NombreDeSequencia.Campo() + " = F_" + NombreDeSequencia.Campo() + ";" +
                "END IF;" +
                "RETURN F_" + Valor.Campo() + ";" +
                "END;";
            public static String Index = "CREATE UNIQUE INDEX PK_" +Tabla.NombreTabla() + " ON " 
                + Tabla.NombreTabla() + " (" + NombreDeSequencia.Campo() + ")";
    }
    // </editor-fold>
}
