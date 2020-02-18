/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PROYECTO.DESKTOP;

import Clases.Sesion;
import Entidades.ClsPantallaPerfil;
import Funcionalidades.ClsOperaPantallaPerfil;
import PROYECTO.LOGIN.FRMLogin;
import PROYECTO.LOGIN.FRMRegistrar;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Box;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

/**
 *
 * @author Freak
 */
public class DesktopMain extends javax.swing.JFrame {

    /**
     * Creates new form DesktopMain
     */
    public DesktopMain() {
        initComponents();
        cargaMenuPorPerfil();
        setExtendedState(MAXIMIZED_BOTH);
    }
    /**
     * Carga Menu por numero de Perfil
     */
    private void cargaMenuPorPerfil(){
        try{
        List<ClsPantallaPerfil> Pantallas = new ArrayList();
        Pantallas.addAll((new ClsOperaPantallaPerfil()).Consulta(Sesion.NumeroDePerfil(), Sesion.CveTipoDeMenu(),0, "", true));
        int Contador = 0;
        JMenu Elementos[] = new JMenu[(int) Sesion.CuentaPantallas()];
        for(ClsPantallaPerfil Pantalla : Pantallas){
            if (Pantalla.NumeroDePantallaHija() != 0){
                JMenuItem subMenu = new  JMenuItem(Pantalla.NombreDePantallaMenuHija());
                subMenu.addActionListener((ActionEvent ev) -> {
                    if (!Sesion.PantallasAbiertas().stream().anyMatch((Entidades.ClsPantallaPerfil x1) -> (""+Pantalla.NumeroDePantallaHija()).equals("" + x1.NumeroDePantallaHija()))) {
                        try{
                            String ClaseName ="PROYECTO.ADMON."+Pantalla.NombreDePantallaInternoHija();
                            Class<?> ClsObjeto = Class.forName(ClaseName);
                            Object Cls = ClsObjeto.newInstance();
                            Method Metodo = Cls.getClass().getMethod("show");
                            DesktopPane.add((Component) Cls);
                            Method MetodoMax;
                            switch(Pantalla.NombreDePantallaInternoHija()){
                                case "Perfil.FRMIndex":
                                    MetodoMax = Cls.getClass().getMethod("setMaximum", boolean.class);
                                    MetodoMax.invoke(Cls, true);
                                    break;
                                case "Correo.FRMIndex":
                                    MetodoMax = Cls.getClass().getMethod("setMaximum", boolean.class);
                                    MetodoMax.invoke(Cls, true);
                                    break;
                                case "Producto.FRMIndex":
                                    MetodoMax = Cls.getClass().getMethod("setMaximum", boolean.class);
                                    MetodoMax.invoke(Cls, true);
                                    break;
                            }
                            Metodo.invoke(Cls);
                            Sesion.PantallasAbiertas(Pantalla);
                        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | NoSuchMethodException | SecurityException | IllegalArgumentException ex) {
                            Logger.getLogger(DesktopMain.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (InvocationTargetException ex) {
                            Logger.getLogger(DesktopMain.class.getName()).log(Level.SEVERE, null, ex);
                            System.out.println(ex.getMessage());
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, String.format("Ya se encuentra abierta la pantalla %1$s",Pantalla.NombreDePantallaMenuHija()), "Escritorio", JOptionPane.INFORMATION_MESSAGE);
                    }
                });
                for(JMenu ElementosMenu : Elementos){
                    if(ElementosMenu.getText().equals(Pantalla.NombreDePantallaMenu())){
                        ElementosMenu.add(subMenu);
                        break;
                    }
                }
            }else{
                Elementos[Contador] = new JMenu();
                Elementos[Contador].setText(Pantalla.NombreDePantallaMenu());
                MenuBar.add(Elementos[Contador]);
                Contador++;
            }
        }
                
                JMenu CierreSesion = new JMenu();
                MenuBar.add(Box.createHorizontalGlue ());
                CierreSesion.setText("Sesion");
                CierreSesion.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
                CierreSesion.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
                
                JMenuItem subMenu = new  JMenuItem("Cerrar Sesion");
                subMenu.addActionListener((ActionEvent ev) -> {
                    this.dispose();
                    int CveTipoMenu = Sesion.CveTipoDeMenu();
                    Sesion.LimpiaSesion();
                    if (CveTipoMenu == 2){
                        FRMRegistrar frmRegistrar=new FRMRegistrar();
                        frmRegistrar.setVisible(true);
                    }else{
                        FRMLogin frmRegistrar=new FRMLogin();
                        frmRegistrar.setVisible(true);
                    }
                });
                CierreSesion.add(subMenu);
                
                MenuBar.add(CierreSesion);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    /**
     * Abre una Pantalla mediante el nombre de esta.
     * @param NombreDePantalla
     * @param Tipos
     * @param Parametros
     * @param Max 
     * @return True si abre la pantalla y false si no fue abierta.
     */
    public static boolean AbrirPantalla(String NombreDePantalla,Class[] Tipos,Object[] Parametros,boolean Max){
        String ClaseName = "PROYECTO.ADMON." + NombreDePantalla;
        Class<?> ClsObjeto;
        Constructor<?> ClsObjetoConstructor;
        Object Cls;
        try {
            ClsObjeto = Class.forName(ClaseName);
            if (Parametros.length > 0 && Tipos.length > 0){
                ClsObjetoConstructor = ClsObjeto.getConstructor(Tipos);
                Cls = ClsObjetoConstructor.newInstance(Parametros);
            }else{
                Cls = ClsObjeto.newInstance();
            }
            Method Metodo4 = Cls.getClass().getMethod("NumeroDePantalla");
            long NumeroDePAntallaHija = Long.parseLong(Metodo4.invoke(Cls).toString());
            ClsPantallaPerfil Pantalla = new ClsPantallaPerfil(Sesion.NumeroDePerfil(), Sesion.CveTipoDeMenu(),0 , NumeroDePAntallaHija, 1);
            if (!Sesion.PantallasAbiertas().stream().anyMatch(x -> ("" + Pantalla.NumeroDePantallaHija()).equals("" + x.NumeroDePantallaHija()))){
                DesktopPane.add((Component) Cls);
                if (Max){
                Method Metodo3 = Cls.getClass().getMethod("setMaximum", boolean.class);
                Metodo3.invoke(Cls,true);
                }
                Method Metodo2 = Cls.getClass().getMethod("toFront");
                Metodo2.invoke(Cls);
                Method Metodo = Cls.getClass().getMethod("show");
                Metodo.invoke(Cls);
                Sesion.PantallasAbiertas(Pantalla);
                return true;
            }else{
                JOptionPane.showMessageDialog(null, String.format("Ya se encuentra abierta la pantalla %1$s", Pantalla.NombreDePantallaMenuHija()), "Escritorio", JOptionPane.INFORMATION_MESSAGE);
                return false;
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DesktopMain.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(DesktopMain.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex) {
            Logger.getLogger(DesktopMain.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(DesktopMain.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(DesktopMain.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(DesktopMain.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(DesktopMain.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        DesktopPane = new javax.swing.JDesktopPane();
        jPanel2 = new javax.swing.JPanel();
        lblVersionado = new javax.swing.JLabel();
        MenuBar = new javax.swing.JMenuBar();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("PUNTO DE VENTA");

        DesktopPane.setBackground(new java.awt.Color(204, 204, 204));
        DesktopPane.setForeground(new java.awt.Color(204, 204, 204));
        DesktopPane.setToolTipText("");
        DesktopPane.setAutoscrolls(true);

        javax.swing.GroupLayout DesktopPaneLayout = new javax.swing.GroupLayout(DesktopPane);
        DesktopPane.setLayout(DesktopPaneLayout);
        DesktopPaneLayout.setHorizontalGroup(
            DesktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 328, Short.MAX_VALUE)
        );
        DesktopPaneLayout.setVerticalGroup(
            DesktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 291, Short.MAX_VALUE)
        );

        lblVersionado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblVersionado.setText(Clases.ClsControlVersion.Version());

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblVersionado, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblVersionado, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        setJMenuBar(MenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(DesktopPane)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(DesktopPane)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(DesktopMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DesktopMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DesktopMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DesktopMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DesktopMain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JDesktopPane DesktopPane;
    private javax.swing.JMenuBar MenuBar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblVersionado;
    // End of variables declaration//GEN-END:variables
}
