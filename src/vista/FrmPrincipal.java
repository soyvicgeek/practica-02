package vista;

public class FrmPrincipal extends javax.swing.JFrame {

    public FrmPrincipal() {
        initComponents();
        
        // maximizar la ventana
        this.setExtendedState(MAXIMIZED_BOTH);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        escritorio = new javax.swing.JDesktopPane();
        menuBar = new javax.swing.JMenuBar();
        mnuAlmacen = new javax.swing.JMenu();
        mnuCaregorias = new javax.swing.JMenuItem();
        mnuArticulos = new javax.swing.JMenuItem();
        mnuCompras = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        mnuVentas = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        mnuAcceso = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        mnuConsultas = new javax.swing.JMenu();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        mnuSalir = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mnuAlmacen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/almacen.png"))); // NOI18N
        mnuAlmacen.setText("Almacen");

        mnuCaregorias.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_MASK));
        mnuCaregorias.setText("Categorías");
        mnuCaregorias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuCaregoriasActionPerformed(evt);
            }
        });
        mnuAlmacen.add(mnuCaregorias);

        mnuArticulos.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.ALT_MASK));
        mnuArticulos.setText("Artículos");
        mnuArticulos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuArticulosActionPerformed(evt);
            }
        });
        mnuAlmacen.add(mnuArticulos);

        menuBar.add(mnuAlmacen);

        mnuCompras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/compras.png"))); // NOI18N
        mnuCompras.setText("Compras");

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem3.setText("Proveedores");
        mnuCompras.add(jMenuItem3);

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem4.setText("Ingresos");
        mnuCompras.add(jMenuItem4);

        menuBar.add(mnuCompras);

        mnuVentas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ventas.png"))); // NOI18N
        mnuVentas.setText("Ventas");

        jMenuItem5.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem5.setText("Clientes");
        mnuVentas.add(jMenuItem5);

        jMenuItem6.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem6.setText("Ventas");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        mnuVentas.add(jMenuItem6);

        menuBar.add(mnuVentas);

        mnuAcceso.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/acceso.png"))); // NOI18N
        mnuAcceso.setText("Acceso");

        jMenuItem7.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem7.setText("Roles");
        mnuAcceso.add(jMenuItem7);

        jMenuItem8.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem8.setText("Usuarios");
        mnuAcceso.add(jMenuItem8);

        menuBar.add(mnuAcceso);

        mnuConsultas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/consultas.png"))); // NOI18N
        mnuConsultas.setText("Consultas");

        jMenuItem9.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem9.setText("Compras");
        mnuConsultas.add(jMenuItem9);

        jMenuItem10.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem10.setText("Ventas");
        mnuConsultas.add(jMenuItem10);

        menuBar.add(mnuConsultas);

        mnuSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/salir.png"))); // NOI18N
        mnuSalir.setText("Salir");
        mnuSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mnuSalirMouseClicked(evt);
            }
        });
        menuBar.add(mnuSalir);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(escritorio, javax.swing.GroupLayout.PREFERRED_SIZE, 513, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mnuSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnuSalirMouseClicked
        //if (JOptionPane.showMessageDialog(this, "", "Saliendo", JOptionPane.QUESTION_MESSAGE)){
        //}
        System.exit(0);
    }//GEN-LAST:event_mnuSalirMouseClicked

    private void mnuCaregoriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuCaregoriasActionPerformed
        FrmCategoria frmCategoria = new FrmCategoria();
        escritorio.add(frmCategoria);
        frmCategoria.setVisible(true);
    }//GEN-LAST:event_mnuCaregoriasActionPerformed

    private void mnuArticulosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuArticulosActionPerformed
        FrmProducto frmProducto = new FrmProducto();
        escritorio.add(frmProducto);
        
        frmProducto.setVisible(true);
    }//GEN-LAST:event_mnuArticulosActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        FrmVenta frmVenta = new FrmVenta();   
        escritorio.add(frmVenta);
        
        frmVenta.setVisible(true);
    }//GEN-LAST:event_jMenuItem6ActionPerformed

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
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane escritorio;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu mnuAcceso;
    private javax.swing.JMenu mnuAlmacen;
    private javax.swing.JMenuItem mnuArticulos;
    private javax.swing.JMenuItem mnuCaregorias;
    private javax.swing.JMenu mnuCompras;
    private javax.swing.JMenu mnuConsultas;
    private javax.swing.JMenu mnuSalir;
    private javax.swing.JMenu mnuVentas;
    // End of variables declaration//GEN-END:variables

}
