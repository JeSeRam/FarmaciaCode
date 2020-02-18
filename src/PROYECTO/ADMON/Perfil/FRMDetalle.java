/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package PROYECTO.ADMON.Perfil;

import Clases.Sesion;
import ConexionMySql.ClsConexionMySql;
import ConexionMySql.ClsResultSet;
import Entidades.ClsAsignaPerfil;
import Entidades.ClsPantalla;
import Entidades.ClsPantallaPerfil;
import Entidades.ClsPerfil;
import Entidades.ClsUsuario;
import Funcionalidades.ClsOperaPantalla;
import Funcionalidades.ClsOperaUsuario;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Freak
 */
public class FRMDetalle extends javax.swing.JInternalFrame {

    /** Creates new form FRMDetalle
     * @param Perfil 
     */
    public FRMDetalle(ClsPerfil Perfil) {
        Registro = Perfil;
        initComponents();
        DefaultTableModel modelo = (DefaultTableModel) tblPantallaEmpleado.getModel();
        modelo.addTableModelListener(this::tableChangedEvent);
        DefaultTableModel modelo2 = (DefaultTableModel) tblPantallaAdmin.getModel();
        modelo2.addTableModelListener(this::tableChangedEvent);
    }
    private Object[][] CargaUsuariosEnTabla() {
        String Filtro = "";
        List<ClsUsuario> lstUsuario = (new ClsOperaUsuario()).ConsultaLista("", "", "", Filtro);
        Object Usuarios[][] = new Object[lstUsuario.size()][ClsUsuario.RelacionesUsuario.CamposQueSeMuestranEnTabla.size() + 1];
        String Sql = "select * from " + ClsAsignaPerfil.RelacionesAsignaPerfil.Tabla.NombreVista()
                + " where " + ClsAsignaPerfil.RelacionesAsignaPerfil.NumeroDePerfil.Campo() + " = " +Registro.NumeroDePerfil();
        ClsResultSet rec = ClsConexionMySql.Consulta(Sql);
        int Cont = 0 ;
        try{
            for (int x = 0; x < lstUsuario.size(); x++){
                Cont = 0 ;
                for (int y = 0; y < ClsUsuario.RelacionesUsuario.CamposQueSeMuestranEnTabla.size() + 1; y ++){
                    if( y == 0){
                        Usuarios[x][y] = false;
                    }else{
                        Method getElemento = lstUsuario.get(x).getClass().getMethod(ClsUsuario.RelacionesUsuario.CamposQueSeMuestranEnTabla.get(Cont).Entidad());
                        Usuarios[x][y] = getElemento.invoke(lstUsuario.get(x));
                        Cont++;
                    }
                }
            }
            while (rec.Lee()) {
                AsignaPerfilBase.add(new ClsAsignaPerfil(rec,true));
            }
            for (int x = 0; x < lstUsuario.size(); x++){
                for (ClsAsignaPerfil clsAsignaPerfil : AsignaPerfilBase){
                    if(Long.parseLong(Usuarios[x][1].toString()) == clsAsignaPerfil.NumeroDeUsuario()){
                        Usuarios[x][0] = true;
                    }
                }
            }
        }catch(IllegalAccessException | IllegalArgumentException | NoSuchMethodException | SecurityException | InvocationTargetException ex){
            System.out.println(ex.getMessage());
        }
        return Usuarios;
    }
    private Object[][] CargaPantallasEnTabla(int CveTipoMenu) {
        List<ClsPantalla> lstPantalla = (new ClsOperaPantalla()).ConsultaLista("", "",""+CveTipoMenu, "");
        Object Pantallas[][] = new Object[lstPantalla.size()][ClsPantalla.RelacionesPantalla.CamposQueSeMuestranEnTabla.size() + 1];
        String Sql = "select * from " + ClsPantallaPerfil.RelacionesPantallaPerfil.Tabla.NombreVista()
                + " where " + ClsPantallaPerfil.RelacionesPantallaPerfil.NumeroDePerfil.Campo() + " = " + Registro.NumeroDePerfil()
                + " and " + ClsPantallaPerfil.RelacionesPantallaPerfil.CveTipoDeMenu.Campo() + " = " + CveTipoMenu
                + " order by " +ClsPantallaPerfil.RelacionesPantallaPerfil.NumeroDePantalla.Campo() +","+ClsPantallaPerfil.RelacionesPantallaPerfil.NumeroDePantallaHija.Campo();
        ClsResultSet rec = ClsConexionMySql.Consulta(Sql);
        int Cont = 0 ;
        try{
            for (int x = 0; x < lstPantalla.size(); x++){
                Cont = 0 ;
                for (int y = 0; y < ClsPantalla.RelacionesPantalla.CamposQueSeMuestranEnTabla.size() + 1; y ++){
                    if( y == 0){
                        Pantallas[x][y] = false;
                    }else{
                        Method getElemento = lstPantalla.get(x).getClass().getMethod(ClsPantalla.RelacionesPantalla.CamposQueSeMuestranEnTabla.get(Cont).Entidad());
                        Pantallas[x][y] = getElemento.invoke(lstPantalla.get(x));
                        Cont++;
                    }
                }
            }
            while (rec.Lee()) {
                PantallaPerfilBase.add(new ClsPantallaPerfil(rec,true));
            }
            for (int x = 0; x < lstPantalla.size(); x++){
                for (ClsPantallaPerfil clsPantallaPerfil : PantallaPerfilBase) {
                    if(Long.parseLong(Pantallas[x][1].toString()) == clsPantallaPerfil.NumeroDePantalla() &&
                            Long.parseLong(Pantallas[x][3].toString()) == clsPantallaPerfil.NumeroDePantallaHija()){
                        Pantallas[x][0] = true;
                    }
                }
            }
        }catch(IllegalAccessException | IllegalArgumentException | NoSuchMethodException | SecurityException | InvocationTargetException ex){
            System.out.println(ex.getMessage());
        }
        return Pantallas;
    }
    private String[] Titulos(int TipoTabla){
        String Titulos[] = null;
        int Cont = 0 ;
        switch(TipoTabla){
            case 1:
                Titulos = new String[ClsUsuario.RelacionesUsuario.CamposQueSeMuestranEnTabla.size() + 1];
                Cont = 0 ;
                for (int i = 0; i < ClsUsuario.RelacionesUsuario.CamposQueSeMuestranEnTabla.size() + 1; i++){
                    if (i == 0){
                        Titulos[i] = "Asignar";
                    }else{
                        Titulos[i] = ClsUsuario.RelacionesUsuario.CamposQueSeMuestranEnTabla.get(Cont).Texto();
                        Cont++;
                    }
                }
                break;
            case 2:
                Titulos = new String[ClsPantalla.RelacionesPantalla.CamposQueSeMuestranEnTabla.size() + 1];
                Cont = 0 ;
                for (int i = 0; i < ClsPantalla.RelacionesPantalla.CamposQueSeMuestranEnTabla.size() + 1; i++){
                    if (i == 0){
                        Titulos[i] = "Asignar";
                    }else{
                        Titulos[i] = ClsPantalla.RelacionesPantalla.CamposQueSeMuestranEnTabla.get(Cont).Texto();
                        Cont++;
                    }
                }
                break;
        }
        return Titulos;
    }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jpnBase = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        txtNombreDePerfil = new javax.swing.JTextField(Registro.NombreDePerfil());
        lblNombreDePerfil = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblUsuarios = new javax.swing.JTable();
        btnRegresar = new javax.swing.JButton();
        lblUsuarios = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        lblPantallaEmpleado = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblPantallaEmpleado = new javax.swing.JTable();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblPantallaAdmin = new javax.swing.JTable();
        btnEdita = new javax.swing.JButton();
        btnBaja = new javax.swing.JButton();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Detalle");
        setAutoscrolls(true);
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosing(evt);
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        lblTitulo.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText(Glosario.Glosario.Perfil.FRMDetalle_getTitulo());

        txtNombreDePerfil.setEnabled(false);

        lblNombreDePerfil.setText(Glosario.Glosario.Perfil.Perfil_NombreDePerfil());

        tblUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            CargaUsuariosEnTabla(),
            Titulos(1)
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.Long.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblUsuarios);

        btnRegresar.setText(Glosario.Glosario.General_getRegresar());
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        lblUsuarios.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblUsuarios.setText(Glosario.Glosario.Usuario.Usuario_getTitulo());

        lblPantallaEmpleado.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblPantallaEmpleado.setText(Glosario.Glosario.Pantalla.Pantalla_getTituloEmpleado());

        tblPantallaEmpleado.setModel(new javax.swing.table.DefaultTableModel(
            CargaPantallasEnTabla(1),
            Titulos(2)
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.Long.class, java.lang.String.class, java.lang.Long.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(tblPantallaEmpleado);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText(Glosario.Glosario.Pantalla.Pantalla_getTituloAdministrador());

        tblPantallaAdmin.setModel(new javax.swing.table.DefaultTableModel(
            CargaPantallasEnTabla(2),
            Titulos(2)
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.Long.class, java.lang.String.class, java.lang.Long.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(tblPantallaAdmin);

        btnEdita.setText(Glosario.Glosario.General_getEdita());
        btnEdita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditaActionPerformed(evt);
            }
        });

        btnBaja.setBackground(new java.awt.Color(255, 0, 0));
        btnBaja.setText(Glosario.Glosario.General_getBaja());

        javax.swing.GroupLayout jpnBaseLayout = new javax.swing.GroupLayout(jpnBase);
        jpnBase.setLayout(jpnBaseLayout);
        jpnBaseLayout.setHorizontalGroup(
            jpnBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnBaseLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jpnBaseLayout.createSequentialGroup()
                .addGap(280, 280, 280)
                .addComponent(lblNombreDePerfil)
                .addGap(107, 107, 107)
                .addComponent(txtNombreDePerfil, javax.swing.GroupLayout.DEFAULT_SIZE, 558, Short.MAX_VALUE)
                .addGap(288, 288, 288))
            .addGroup(jpnBaseLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(jpnBaseLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addGroup(jpnBaseLayout.createSequentialGroup()
                        .addGroup(jpnBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblUsuarios)
                            .addComponent(lblPantallaEmpleado)
                            .addComponent(jLabel1)
                            .addGroup(jpnBaseLayout.createSequentialGroup()
                                .addComponent(btnRegresar)
                                .addGap(18, 18, 18)
                                .addComponent(btnEdita)
                                .addGap(18, 18, 18)
                                .addComponent(btnBaja)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jpnBaseLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator2)
                .addContainerGap())
            .addGroup(jpnBaseLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4)
                .addContainerGap())
            .addGroup(jpnBaseLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator3)
                .addContainerGap())
            .addGroup(jpnBaseLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5)
                .addContainerGap())
        );
        jpnBaseLayout.setVerticalGroup(
            jpnBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnBaseLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpnBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombreDePerfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNombreDePerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblUsuarios)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblPantallaEmpleado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpnBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegresar)
                    .addComponent(btnEdita)
                    .addComponent(btnBaja))
                .addContainerGap())
        );

        jScrollPane2.setViewportView(jpnBase);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1299, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 992, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        // TODO add your handling code here:
        if (Sesion.CierreVentana(NumeroDePantalla)){
            this.dispose();
        }
    }//GEN-LAST:event_formInternalFrameClosing

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        // TODO add your handling code here:
        Class[] Tipos = new Class[0];
        Object[] Parametros = new Object[0];
        PROYECTO.DESKTOP.DesktopMain.AbrirPantalla("Perfil.FRMIndex", Tipos, Parametros, true);
        if (Sesion.CierreVentana(NumeroDePantalla)){
            this.dispose();
        }
//        int seleccion = tblUsuarios.getRowCount();
//        int columnas = tblUsuarios.getColumnCount();
//        for (int row = 0;row < seleccion;row++){
//            if ((boolean) (tblUsuarios.getValueAt(row, 0)) == true){
//                for (int col = 0; col < columnas; col++){
//                    System.out.print(" | " + tblUsuarios.getValueAt(row, col));
//                }
//                DefaultTableModel modelo = (DefaultTableModel) tblUsuarios.getModel();
//                modelo.removeRow(row);
//            }
//            System.out.print(" | ");
//            System.out.println();
//        }
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnEditaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditaActionPerformed
        // TODO add your handling code here:
        Class[] Tipos = {ClsPerfil.class};
        Object[] Parametros = {Registro};
        PROYECTO.DESKTOP.DesktopMain.AbrirPantalla("Perfil.FRMEdita", Tipos, Parametros, true);
        if (Sesion.CierreVentana(NumeroDePantalla)){
            this.dispose();
        }
    }//GEN-LAST:event_btnEditaActionPerformed
    private void tableChangedEvent(javax.swing.event.TableModelEvent tme) {
        int row = tme.getFirstRow();
        int column = tme.getColumn();
        TableModel model = (TableModel) tme.getSource();
        Boolean checked = (Boolean) model.getValueAt(row, column);
        if (checked) {
            long NumeroDePantalla = (long) model.getValueAt(row, 1);
            long NumeroDePantallaHija = (long) model.getValueAt(row, 3);
            if(NumeroDePantallaHija != 0){
                for(int i = 0; i < model.getRowCount();i++){
                    if((long) model.getValueAt(i, 1) == NumeroDePantalla && (long) model.getValueAt(i, 3) == 0){
                        model.setValueAt(true, i, 0);
                    }
                }
            }else{
            }
        }else{
            boolean Asignar = (boolean) model.getValueAt(row,column);
            if (!Asignar){
                List<Integer> Posicion = new ArrayList<>();
                long NumeroDePantalla = (long) model.getValueAt(row, 1);
                long NumeroDePantallaHija = (long) model.getValueAt(row, 3);
                if (NumeroDePantallaHija == 0){
                    for(int i = 0; i < model.getRowCount();i++){
                        if((long) model.getValueAt(i, 1) == NumeroDePantalla && (long) model.getValueAt(i, 3) != 0 && (boolean) model.getValueAt(i, 0) == true){
                            Posicion.add(i);
                        }
                    }
                    if (!Posicion.isEmpty()){
                        int respuesta=JOptionPane.showConfirmDialog(null, "Si se quita este elemento serán removidas las pantallas dependientes ¿Desea continuar?");
                        if(JOptionPane.OK_OPTION==respuesta){
                            for(int i = 0; i < Posicion.size();i++){
                                model.setValueAt(false, Posicion.get(i), 0);
                            } 
                        }else{
                            for(int i = 0; i < Posicion.size();i++){
                                model.setValueAt(true, Posicion.get(i), 0);
                            }
                        }
                    }
                }else{
                    boolean Estatus = false;
                    for(int i = 0; i < model.getRowCount();i++){
                        if((long) model.getValueAt(i, 1) == NumeroDePantalla && (long) model.getValueAt(i, 3) == 0 && (boolean) model.getValueAt(i, 0) == false){
                            Estatus = true;
                            break;
                        }
                    }
                    if (Estatus){
                        for(int i = 0; i < model.getRowCount();i++){
                            if((long) model.getValueAt(i, 1) == NumeroDePantalla && (long) model.getValueAt(i, 3) != 0 && (boolean) model.getValueAt(i, 0) == true){
                                Posicion.add(i);
                            }
                        }
                        if (!Posicion.isEmpty()){
                            for(int i = 0; i < Posicion.size();i++){
                                model.setValueAt(false, Posicion.get(i), 0);
                            }
                        }
                    }
                }
            }
        }
    }
    public long NumeroDePantalla(){
        return NumeroDePantalla;
    }
    private final long NumeroDePantalla = 5;
    private ClsPerfil Registro = new ClsPerfil();
    private final List<ClsAsignaPerfil> AsignaPerfilBase = new ArrayList<>();
    private final List<ClsPantallaPerfil> PantallaPerfilBase = new ArrayList<>();
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBaja;
    private javax.swing.JButton btnEdita;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JPanel jpnBase;
    private javax.swing.JLabel lblNombreDePerfil;
    private javax.swing.JLabel lblPantallaEmpleado;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblUsuarios;
    private javax.swing.JTable tblPantallaAdmin;
    private javax.swing.JTable tblPantallaEmpleado;
    private javax.swing.JTable tblUsuarios;
    private javax.swing.JTextField txtNombreDePerfil;
    // End of variables declaration//GEN-END:variables

}
