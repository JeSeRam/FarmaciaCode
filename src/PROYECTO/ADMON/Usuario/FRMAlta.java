/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PROYECTO.ADMON.Usuario;

import Clases.Sesion;
import static PROYECTO.FuncionesParalelas.Contraseña.Desifrado;
import static PROYECTO.FuncionesParalelas.Iconos.getRutaIconoIncorrecto;
import static PROYECTO.FuncionesParalelas.Iconos.ColocaIcono;
import static PROYECTO.FuncionesParalelas.Iconos.getRutaIconoCorrecto;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Freak
 */
public class FRMAlta extends javax.swing.JInternalFrame {

    /**
     * Creates new form Alta
     */
    public FRMAlta() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlBase = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        lblNombreDeUsuario = new javax.swing.JLabel();
        lblNombreDePersona = new javax.swing.JLabel();
        lblApellidoPaterno = new javax.swing.JLabel();
        lblApellidoMaterno = new javax.swing.JLabel();
        lblContraseñaDeUsuario = new javax.swing.JLabel();
        lblFechaDeCreacion = new javax.swing.JLabel();
        lblCveTipoDeUsuario = new javax.swing.JLabel();
        txtNombreDeUsuario = new javax.swing.JTextField();
        txtNombreDePersona = new javax.swing.JTextField();
        txtApellidoPaterno = new javax.swing.JTextField();
        txtApellidoMaterno = new javax.swing.JTextField();
        txtFechaDeCreacion = new javax.swing.JTextField();
        cmbCveTipoDeUsuario = new javax.swing.JComboBox<>();
        pswContraseñaDeUsuario = new javax.swing.JPasswordField();
        pswContraseñaDeUsuarioDoble = new javax.swing.JPasswordField();
        lblContraseñaDeUsuarioDoble = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        lblPwd1 = new javax.swing.JLabel();
        lblPwd2 = new javax.swing.JLabel();
        lblDiasLaborales = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jCheckBox4 = new javax.swing.JCheckBox();
        jCheckBox5 = new javax.swing.JCheckBox();
        jCheckBox6 = new javax.swing.JCheckBox();
        jCheckBox7 = new javax.swing.JCheckBox();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setIconifiable(true);
        setTitle("Alta de Usuario");
        setAutoscrolls(true);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(500, 34));
        setName(""); // NOI18N
        setNextFocusableComponent(lblNombreDeUsuario);
        setPreferredSize(new java.awt.Dimension(500, 620));
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

        pnlBase.setAutoscrolls(true);

        lblTitulo.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText(Glosario.Glosario.Usuario.FRMAlta_getTitulo());

        lblNombreDeUsuario.setText(Glosario.Glosario.Usuario.Usuario_NumeroDeUsuario());

        lblNombreDePersona.setText(Glosario.Glosario.Usuario.Usuario_NombreDePersona());

        lblApellidoPaterno.setText(Glosario.Glosario.Usuario.Usuario_ApellidoPaterno());

        lblApellidoMaterno.setText(Glosario.Glosario.Usuario.Usuario_ApellidoMaterno());

        lblContraseñaDeUsuario.setText(Glosario.Glosario.Usuario.Usuario_ContraseñaDeUsuario());

        lblFechaDeCreacion.setText(Glosario.Glosario.Usuario.Usuario_FechaDeCreacion());

        lblCveTipoDeUsuario.setText(Glosario.Glosario.Usuario.Usuario_CveTipoDeUsuario());

        txtFechaDeCreacion.setText((new SimpleDateFormat("yyyy-MM-dd").format(new Date())));
        txtFechaDeCreacion.setEditable(false);

        cmbCveTipoDeUsuario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        pswContraseñaDeUsuario.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                pswContraseñaDeUsuarioFocusLost(evt);
            }
        });

        pswContraseñaDeUsuarioDoble.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                pswContraseñaDeUsuarioDobleFocusLost(evt);
            }
        });

        lblContraseñaDeUsuarioDoble.setText(Glosario.Glosario.Usuario.Usuario_ContraseñaDeUsuario2());

        jButton1.setText(Glosario.Glosario.getGuardar());
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        lblPwd1.setVisible(false);

        lblPwd2.setVisible(false);

        lblDiasLaborales.setText(Glosario.Glosario.DiasLaborales.DiasLaborales_DiasLaborales());

        jCheckBox1.setText(Glosario.Glosario.DiasLaborales.getLunes());

        jCheckBox2.setText(Glosario.Glosario.DiasLaborales.getMartes());

        jCheckBox3.setText(Glosario.Glosario.DiasLaborales.getMiercoles());

        jCheckBox4.setText(Glosario.Glosario.DiasLaborales.getJueves());

        jCheckBox5.setText(Glosario.Glosario.DiasLaborales.getViernes());

        jCheckBox6.setText(Glosario.Glosario.DiasLaborales.getSabado());

        jCheckBox7.setText(Glosario.Glosario.DiasLaborales.getDomingo());

        javax.swing.GroupLayout pnlBaseLayout = new javax.swing.GroupLayout(pnlBase);
        pnlBase.setLayout(pnlBaseLayout);
        pnlBaseLayout.setHorizontalGroup(
            pnlBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBaseLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBaseLayout.createSequentialGroup()
                        .addGroup(pnlBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblFechaDeCreacion)
                            .addGroup(pnlBaseLayout.createSequentialGroup()
                                .addGroup(pnlBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnlBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblNombreDeUsuario)
                                            .addComponent(lblNombreDePersona)
                                            .addComponent(lblApellidoPaterno)
                                            .addComponent(lblApellidoMaterno)
                                            .addComponent(lblContraseñaDeUsuario))
                                        .addComponent(lblCveTipoDeUsuario))
                                    .addComponent(lblContraseñaDeUsuarioDoble))
                                .addGap(45, 45, 45)
                                .addGroup(pnlBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblPwd2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblPwd1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(lblDiasLaborales))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
                        .addGroup(pnlBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pswContraseñaDeUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                            .addComponent(txtApellidoMaterno, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                            .addComponent(txtApellidoPaterno, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                            .addComponent(txtNombreDePersona, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                            .addComponent(txtNombreDeUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                            .addComponent(txtFechaDeCreacion, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                            .addComponent(cmbCveTipoDeUsuario, 0, 240, Short.MAX_VALUE)
                            .addComponent(pswContraseñaDeUsuarioDoble)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBaseLayout.createSequentialGroup()
                                .addGroup(pnlBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(pnlBaseLayout.createSequentialGroup()
                                        .addComponent(jCheckBox1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                                        .addComponent(jCheckBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(pnlBaseLayout.createSequentialGroup()
                                        .addComponent(jCheckBox5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jCheckBox6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(pnlBaseLayout.createSequentialGroup()
                                        .addComponent(jCheckBox3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jCheckBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(1, 1, 1)))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBaseLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jCheckBox7)
                .addGap(82, 82, 82))
        );
        pnlBaseLayout.setVerticalGroup(
            pnlBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBaseLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombreDeUsuario)
                    .addComponent(txtNombreDeUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombreDePersona)
                    .addComponent(txtNombreDePersona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblApellidoPaterno)
                    .addComponent(txtApellidoPaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblApellidoMaterno)
                    .addComponent(txtApellidoMaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPwd1, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
                    .addGroup(pnlBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblContraseñaDeUsuario)
                        .addComponent(pswContraseñaDeUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(pnlBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pswContraseñaDeUsuarioDoble, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblContraseñaDeUsuarioDoble)
                    .addComponent(lblPwd2, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(pnlBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFechaDeCreacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFechaDeCreacion))
                .addGap(18, 18, 18)
                .addGroup(pnlBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbCveTipoDeUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCveTipoDeUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(pnlBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDiasLaborales)
                    .addComponent(jCheckBox1)
                    .addComponent(jCheckBox2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox3)
                    .addComponent(jCheckBox4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox5)
                    .addComponent(jCheckBox6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCheckBox7)
                .addGap(14, 14, 14)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBase, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlBase, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pswContraseñaDeUsuarioDobleFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_pswContraseñaDeUsuarioDobleFocusLost
        // TODO add your handling code here:
        if(pswContraseñaDeUsuario.getPassword().length != 0){
            if(pswContraseñaDeUsuarioDoble.getPassword().length != 0){
                String ContraseñaDeUsuario = Desifrado(pswContraseñaDeUsuario.getPassword());
                String ContraseñaDeUsuarioDoble = Desifrado(pswContraseñaDeUsuarioDoble.getPassword());
                if (ContraseñaDeUsuario.equals(ContraseñaDeUsuarioDoble)){
                    lblPwd2.setIcon(ColocaIcono(getRutaIconoCorrecto(),30,30,(int) CENTER_ALIGNMENT));
                    lblPwd2.setVisible(true);
                }else{
                    lblPwd2.setIcon(ColocaIcono(getRutaIconoIncorrecto(),30,30,(int) CENTER_ALIGNMENT));
                    lblPwd2.setVisible(true);
                }
            }else{
                lblPwd2.setIcon(ColocaIcono(getRutaIconoIncorrecto(),30,30,(int) CENTER_ALIGNMENT));
                lblPwd2.setVisible(true);
            }
        }else{
            lblPwd2.setIcon(ColocaIcono(getRutaIconoIncorrecto(),30,30,(int) CENTER_ALIGNMENT));
            lblPwd2.setVisible(true);
        }
    }//GEN-LAST:event_pswContraseñaDeUsuarioDobleFocusLost

    private void pswContraseñaDeUsuarioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_pswContraseñaDeUsuarioFocusLost
        // TODO add your handling code here:
        if(pswContraseñaDeUsuario.getPassword().length != 0){
            if(pswContraseñaDeUsuarioDoble.getPassword().length != 0){
                String ContraseñaDeUsuario = Desifrado(pswContraseñaDeUsuario.getPassword());
                String ContraseñaDeUsuarioDoble = Desifrado(pswContraseñaDeUsuarioDoble.getPassword());
                if (ContraseñaDeUsuario.equals(ContraseñaDeUsuarioDoble)){
                    lblPwd1.setIcon(ColocaIcono(getRutaIconoCorrecto(),30,30,(int) CENTER_ALIGNMENT));
                    lblPwd1.setVisible(true);
                    lblPwd2.setIcon(ColocaIcono(getRutaIconoCorrecto(),30,30,(int) CENTER_ALIGNMENT));
                    lblPwd2.setVisible(true);
                }else{
                    lblPwd1.setIcon(ColocaIcono(getRutaIconoIncorrecto(),30,30,(int) CENTER_ALIGNMENT));
                    lblPwd1.setVisible(true);
                    lblPwd2.setIcon(ColocaIcono(getRutaIconoIncorrecto(),30,30,(int) CENTER_ALIGNMENT));
                    lblPwd2.setVisible(true);
                }
            }
        }else{
            lblPwd1.setIcon(ColocaIcono(getRutaIconoIncorrecto(),30,30,(int) CENTER_ALIGNMENT));
            lblPwd1.setVisible(true);
        }
    }//GEN-LAST:event_pswContraseñaDeUsuarioFocusLost

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        // TODO add your handling code here:
        if (Sesion.CierreVentana(NumeroDePantalla)){
            this.dispose();
        }
    }//GEN-LAST:event_formInternalFrameClosing

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed
    public long NumeroDePantalla(){
        return NumeroDePantalla;
    }
    private long NumeroDePantalla = 1;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmbCveTipoDeUsuario;
    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JCheckBox jCheckBox5;
    private javax.swing.JCheckBox jCheckBox6;
    private javax.swing.JCheckBox jCheckBox7;
    private javax.swing.JLabel lblApellidoMaterno;
    private javax.swing.JLabel lblApellidoPaterno;
    private javax.swing.JLabel lblContraseñaDeUsuario;
    private javax.swing.JLabel lblContraseñaDeUsuarioDoble;
    private javax.swing.JLabel lblCveTipoDeUsuario;
    private javax.swing.JLabel lblDiasLaborales;
    private javax.swing.JLabel lblFechaDeCreacion;
    private javax.swing.JLabel lblNombreDePersona;
    private javax.swing.JLabel lblNombreDeUsuario;
    private javax.swing.JLabel lblPwd1;
    private javax.swing.JLabel lblPwd2;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel pnlBase;
    private javax.swing.JPasswordField pswContraseñaDeUsuario;
    private javax.swing.JPasswordField pswContraseñaDeUsuarioDoble;
    private javax.swing.JTextField txtApellidoMaterno;
    private javax.swing.JTextField txtApellidoPaterno;
    private javax.swing.JTextField txtFechaDeCreacion;
    private javax.swing.JTextField txtNombreDePersona;
    private javax.swing.JTextField txtNombreDeUsuario;
    // End of variables declaration//GEN-END:variables
}
