/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PROYECTO.INSTALACION;

import ConexionMySql.ClsConexionMySql;
import PROYECTO.LOGIN.FRMLogin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author Freak
 */
public class FRMInstalacion extends javax.swing.JFrame {

    /**
     * Creates new form FRMInstalacion
     */
    public FRMInstalacion() {
        Conexion = new ClsConexionMySql();
        //Conexion.CreaDB();
        Clases.ClsMensajeError RegEstatus = Conexion.RegresaEstatus();
        if(RegEstatus.Estatus()){
            if (!Conexion.Consulta("select * from " + Entidades.ClsClave.RelacionesClave.Tabla.NombreTabla()).TieneRegistros()){
                Registros = Conexion.CreaRegistros();
                initComponents();
                Tiempo = new Timer(500, new progreso());
                Tiempo.start();
            }else{
                Estatus = false;
                this.dispose();
                FRMLogin Login = new FRMLogin();
                Login.setVisible(true);
            }
        }else{
            JOptionPane.showMessageDialog(this, RegEstatus.Mensaje(),
                "Error en conexion", JOptionPane.ERROR_MESSAGE);
        }
    }
    public void actionPerformed(ActionEvent e) { 
        if(e.getSource() == Tiempo){ 
        dispose(); 
        } 
    } 
    public class progreso implements ActionListener{
        
        @Override
        public void actionPerformed(ActionEvent ae) {
            int n = pgbBaseDeDatos.getValue();
            if(n < Registros.size()){
                if (Conexion.Transaccion(Registros.get(n))){
                    n++;
                    pgbBaseDeDatos.setValue(n);
                }else{
                    Tiempo.stop();
                    JOptionPane.showMessageDialog(null, "Error de carga");
                }
            }else if (n >= Registros.size() && n < 100){
                n++;
                pgbBaseDeDatos.setValue(n);
            }else {
                Tiempo.stop();
                JOptionPane.showMessageDialog(null, "Cargado");
                btnSiguiente.setVisible(true);
            }
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

        pgbBaseDeDatos = new javax.swing.JProgressBar();
        txtTextoInformativo = new javax.swing.JLabel();
        txtLoginTitle = new javax.swing.JLabel();
        btnSiguiente = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pgbBaseDeDatos.setStringPainted(true);

        txtTextoInformativo.setText(Glosario.Glosario.FRMInstalacion_getCreaDB());

        txtLoginTitle.setFont(new java.awt.Font("Myriad CAD", 1, 24)); // NOI18N
        txtLoginTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtLoginTitle.setText(Glosario.Glosario.FRMInstalacion_getTitulo());
        txtLoginTitle.setToolTipText("");
        txtLoginTitle.setAlignmentX(100.0F);
        txtLoginTitle.setAlignmentY(100.0F);

        btnSiguiente.setVisible(false);
        btnSiguiente.setText(Glosario.Glosario.General_getSiguiente());
        btnSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pgbBaseDeDatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtTextoInformativo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtLoginTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnSiguiente)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtLoginTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTextoInformativo)
                .addGap(18, 18, 18)
                .addComponent(pgbBaseDeDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSiguiente)
                .addContainerGap(129, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteActionPerformed
        // TODO add your handling code here:
        this.dispose();
        PROYECTO.LOGIN.FRMLogin FRMLogin = new PROYECTO.LOGIN.FRMLogin();
        FRMLogin.setVisible(true);
    }//GEN-LAST:event_btnSiguienteActionPerformed

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
            java.util.logging.Logger.getLogger(FRMInstalacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FRMInstalacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FRMInstalacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FRMInstalacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        Conexion = new ClsConexionMySql();
        MensajeError = Conexion.RegresaEstatus();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FRMInstalacion().setVisible(Estatus);
            }
        });
    }

    public long NumeroDePantalla(){
        return NumeroDePantalla;
    }
    private long NumeroDePantalla = 0;
    private static Clases.ClsMensajeError  MensajeError = new Clases.ClsMensajeError();
    private static ClsConexionMySql Conexion = new ClsConexionMySql("root","123ser__","ADMON","sys");
    private Timer Tiempo;
    private static boolean Estatus = true;
    private List<String> Registros;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSiguiente;
    private javax.swing.JProgressBar pgbBaseDeDatos;
    private javax.swing.JLabel txtLoginTitle;
    private javax.swing.JLabel txtTextoInformativo;
    // End of variables declaration//GEN-END:variables
}