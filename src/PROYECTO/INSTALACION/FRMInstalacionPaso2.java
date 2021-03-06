/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PROYECTO.INSTALACION;

import ConexionMySql.ClsConexionMySql;
import Funcionalidades.ClsOperaUsuario;
import static PROYECTO.FuncionesParalelas.Contraseña.Desifrado;
import static PROYECTO.FuncionesParalelas.Contraseña.encrypt;
import static PROYECTO.FuncionesParalelas.Iconos.ColocaIcono;
import static PROYECTO.FuncionesParalelas.Iconos.getRutaIconoCorrecto;
import static PROYECTO.FuncionesParalelas.Iconos.getRutaIconoIncorrecto;
import static java.awt.Component.CENTER_ALIGNMENT;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author Freak
 */
public class FRMInstalacionPaso2 extends javax.swing.JFrame {

    /**
     * Creates new form FRMInstalacion
     */
    public FRMInstalacionPaso2() {
        if (!Clases.ClsManejadorDeArchivos.ExisteArchivo(Archivos.AppDataKey())){
            JOptionPane.showMessageDialog(this, "El archivo de conexión no fue creado correctamente",
                    "Error en conexion", JOptionPane.ERROR_MESSAGE);
        } else {
            Conexion = new ClsConexionMySql();
            MensajeError = Conexion.RegresaEstatus();
            if(MensajeError.Estatus()){
                initComponents();
            }else{
                JOptionPane.showMessageDialog(this, MensajeError.Mensaje(),
                        "Error en conexion", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    public void actionPerformed(ActionEvent e) { 
        if(e.getSource() == Tiempo){ 
            dispose(); 
        } 
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTextoInformativo = new javax.swing.JLabel();
        txtLoginTitle = new javax.swing.JLabel();
        btnSiguiente = new javax.swing.JButton();
        lblUsuario = new javax.swing.JLabel();
        lblContraseña = new javax.swing.JLabel();
        lblContraseña2 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        pwdContraseña = new javax.swing.JPasswordField();
        pwdContraseña2 = new javax.swing.JPasswordField();
        lblContraseñaC = new javax.swing.JLabel();
        lblContraseñaC2 = new javax.swing.JLabel();
        lblUsuarioC = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTextoInformativo.setText(Glosario.Glosario.FRMInstalacion_getCreaDB());

        txtLoginTitle.setFont(new java.awt.Font("Myriad CAD", 1, 24)); // NOI18N
        txtLoginTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtLoginTitle.setText(Glosario.Glosario.FRMInstalacion_getTitulo());
        txtLoginTitle.setToolTipText("");
        txtLoginTitle.setAlignmentX(100.0F);
        txtLoginTitle.setAlignmentY(100.0F);

        btnSiguiente.setVisible(true);
        btnSiguiente.setText(Glosario.Glosario.General_getSiguiente());
        btnSiguiente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguienteActionPerformed(evt);
            }
        });

        lblUsuario.setText(Glosario.Glosario.getLoginUsuario());

        lblContraseña.setText(Glosario.Glosario.Usuario.Usuario_ContraseñaDeUsuario().toUpperCase());

        lblContraseña2.setText(Glosario.Glosario.Usuario.Usuario_ContraseñaDeUsuario2().toUpperCase());

        lblContraseñaC.setVisible(false);

        lblContraseñaC.setVisible(false);

        lblContraseñaC.setVisible(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtLoginTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnSiguiente)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lblContraseña, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                            .addComponent(lblUsuario, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblContraseña2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblContraseñaC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblContraseñaC2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblUsuarioC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                            .addComponent(pwdContraseña)
                            .addComponent(pwdContraseña2)))
                    .addComponent(lblTextoInformativo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtLoginTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTextoInformativo)
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblUsuario))
                    .addComponent(lblUsuarioC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblContraseña)
                        .addComponent(pwdContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblContraseñaC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblContraseña2)
                        .addComponent(pwdContraseña2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblContraseñaC2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSiguiente)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteActionPerformed
        // TODO add your handling code here:
        if (ValidaCamposRequeridos()){
            if (Desifrado(pwdContraseña.getPassword()).equals(Desifrado(pwdContraseña2.getPassword()))){
                Entidades.ClsUsuario Registro = (new ClsOperaUsuario()).Consulta("1", "", "");
                Map<String, Object> Cambios = new HashMap<String, Object>();
                Cambios.put(Entidades.ClsUsuario.RelacionesUsuario.NombreDeUsuario.Campo(), txtUsuario.getText());
                Cambios.put(Entidades.ClsUsuario.RelacionesUsuario.ContraseñaDeUsuario.Campo(), encrypt(Desifrado(pwdContraseña.getPassword())));
                if (Registro.Update(Cambios)){
                    this.dispose();
                    PROYECTO.LOGIN.FRMLogin FRMLogin = new PROYECTO.LOGIN.FRMLogin();
                    FRMLogin.setVisible(true);
                }
            }else{
                JOptionPane.showMessageDialog(this, "Las Contraseñas no coinciden", 
                        "Error en Instalación", JOptionPane.ERROR_MESSAGE);
                ValidaContraseña(true);
                ValidaContraseña2(true);
            }
        }
    }//GEN-LAST:event_btnSiguienteActionPerformed
    private String ValidaUsuario(boolean Incorrecto){
        if (txtUsuario.getText().trim().equals("") || Incorrecto){
            lblUsuarioC.setIcon(ColocaIcono(getRutaIconoIncorrecto(),30,30,(int) CENTER_ALIGNMENT));
            lblUsuarioC.setVisible(true);
            return "El Campo Usuario es un Campo requerido";
        } else {
            lblUsuarioC.setIcon(ColocaIcono(getRutaIconoCorrecto(),30,30,(int) CENTER_ALIGNMENT));
            lblUsuarioC.setVisible(true);
            return "";
        }
    }
    private String ValidaContraseña(boolean Incorrecto){
        if (Desifrado(pwdContraseña.getPassword()).trim().equals("") || Incorrecto){
            lblContraseñaC.setIcon(ColocaIcono(getRutaIconoIncorrecto(),30,30,(int) CENTER_ALIGNMENT));
            lblContraseñaC.setVisible(true);
            return "El Campo Contraseña es un Campo requerido";
        } else {
            lblContraseñaC.setIcon(ColocaIcono(getRutaIconoCorrecto(),30,30,(int) CENTER_ALIGNMENT));
            lblContraseñaC.setVisible(true);
            return "";
        }
    }
    private String ValidaContraseña2(boolean Incorrecto){
        if (Desifrado(pwdContraseña2.getPassword()).trim().equals("") || Incorrecto){
            lblContraseñaC2.setIcon(ColocaIcono(getRutaIconoIncorrecto(),30,30,(int) CENTER_ALIGNMENT));
            lblContraseñaC2.setVisible(true);
            return "El Campo Contraseña es un Campo requerido";
        } else {
            lblContraseñaC2.setIcon(ColocaIcono(getRutaIconoCorrecto(),30,30,(int) CENTER_ALIGNMENT));
            lblContraseñaC2.setVisible(true);
            return "";
        }
    }
    private boolean ValidaCamposRequeridos(){
        List<String> Mensajes = new ArrayList<String>();
        Mensajes.add(ValidaUsuario(false));
        Mensajes.add(ValidaContraseña(false));
        Mensajes.add(ValidaContraseña2(false));
        List<String> Remueve = new ArrayList<String>();
        Remueve.add("");
        Mensajes.removeAll(Remueve);
        if (!String.join("\n", Mensajes).equals("")){
            JOptionPane.showMessageDialog(this, String.join("\n", Mensajes),
                        "Error en Instalación", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FRMInstalacionPaso2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FRMInstalacionPaso2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FRMInstalacionPaso2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FRMInstalacionPaso2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FRMInstalacionPaso2().setVisible(Estatus);
            }
        });
    }

    public long NumeroDePantalla(){
        return NumeroDePantalla;
    }
    private long NumeroDePantalla = 0;
    private static Clases.ClsMensajeError  MensajeError = new Clases.ClsMensajeError();
    private static ClsConexionMySql Conexion = null;
    private Timer Tiempo;
    private static boolean Estatus = true;
    private Clases.ClsManejadorDeArchivos Archivos = new Clases.ClsManejadorDeArchivos();
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSiguiente;
    private javax.swing.JLabel lblContraseña;
    private javax.swing.JLabel lblContraseña2;
    private javax.swing.JLabel lblContraseñaC;
    private javax.swing.JLabel lblContraseñaC2;
    private javax.swing.JLabel lblTextoInformativo;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JLabel lblUsuarioC;
    private javax.swing.JPasswordField pwdContraseña;
    private javax.swing.JPasswordField pwdContraseña2;
    private javax.swing.JLabel txtLoginTitle;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
