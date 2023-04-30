package vista;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import negocio.CategoriaControl;

public class FrmCategoria extends javax.swing.JInternalFrame {
    
    //Crear una variable para instanciar a la capa negocio o control
    private final CategoriaControl CONTROL;
    private File archivoImagenCategoria; //Guardar el nombre de Imagen de la Categoría
    private String accion;
    private String nombreAnt;
    private Path imgTemp;
    private String imgName = null;
    
    public FrmCategoria() {
        initComponents();
        //Inicializar CONTROL
        CONTROL = new CategoriaControl();
        //Mandar llamar listar
        listar("");
        tabGeneral.setEnabledAt(1, false);
        accion = "Guardar";
        
        //Ocultar variables
        txtId.setVisible(false);
        txtImg.setVisible(false);
    }
    
    //Método listar para que muestre las categorias
    private void listar(String texto) {
        //Llenar el modelo del JTable de nombre tabla Listado
        tablaListado.setModel(CONTROL.listar(texto));
        tablaListado.setRowHeight(60);
        tablaListado.getColumnModel().getColumn(4).setCellRenderer(new ImgTabla());
    }
    
    //Crear un método para limpiar los controles
    private void limpiar() {
        txtDescripcion.setText("");
        txtNombreCategoria.setText("");
        txtObservaciones.setText("");
        accion = "Guardar";
        
        lblImagenCategoria.setIcon(null);
    }
    
    private void dibujarCcategoria(String ruta) {
        ImageIcon imagen = new ImageIcon(ruta);
        //Convertir la imagen a un icono
        Icon icono = new ImageIcon(imagen.getImage().getScaledInstance(lblImagenCategoria.getWidth(), lblImagenCategoria.getHeight(), Image.SCALE_SMOOTH));
        lblImagenCategoria.setIcon(icono);
    }
    
    // Método para mostrar Mensajes de error
    private void mensajeError(String msg) {
        JOptionPane.showMessageDialog(this, msg, "Sistema de Ventas y Compras", JOptionPane.ERROR_MESSAGE);
    }
    
    // Método para mostrar Mensajes de OK
    private void mensajeOK(String msg) {
        JOptionPane.showMessageDialog(this, msg, "Sistema de Ventas y Compras", JOptionPane.INFORMATION_MESSAGE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabGeneral = new javax.swing.JTabbedPane();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaListado = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnActivar = new javax.swing.JButton();
        btnDesactivar = new javax.swing.JButton();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtNombreCategoria = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtObservaciones = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        btnCancerlar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        lblImagenCategoria = new javax.swing.JLabel();
        btnCargarImg = new javax.swing.JButton();
        txtId = new javax.swing.JTextField();
        txtImg = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Categorias");

        tabGeneral.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel1.setText("Nombre:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, -1));

        tablaListado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablaListado);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 100, 670, 240));

        jTextField1.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jTextField1.setText("Registros");
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 360, -1, -1));
        jPanel1.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 30, 310, -1));

        jButton1.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 51, 204));
        jButton1.setText("Buscar");
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 30, 80, -1));

        btnNuevo.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        jPanel1.add(btnNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 30, 80, -1));

        btnEditar.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 30, 80, -1));

        btnActivar.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        btnActivar.setText("Activar");
        btnActivar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActivarActionPerformed(evt);
            }
        });
        jPanel1.add(btnActivar, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 350, 80, -1));

        btnDesactivar.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        btnDesactivar.setText("Desactivar");
        btnDesactivar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivarActionPerformed(evt);
            }
        });
        jPanel1.add(btnDesactivar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, 120, -1));

        jTabbedPane2.addTab("", jPanel1);

        tabGeneral.addTab("Listado", jTabbedPane2);

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel2.setText("Categoría");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 20, -1, -1));
        jPanel2.add(txtNombreCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 412, -1));

        jLabel3.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel3.setText("Observaciones:");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, -1, -1));

        txtObservaciones.setColumns(20);
        txtObservaciones.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        txtObservaciones.setRows(5);
        jScrollPane2.setViewportView(txtObservaciones);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 410, 126));

        jLabel4.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel4.setText("(*) Indica que el campo es obligatorio.");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 380, -1, -1));

        btnCancerlar.setText("Cancelar");
        btnCancerlar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancerlarActionPerformed(evt);
            }
        });
        jPanel2.add(btnCancerlar, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 330, -1, -1));

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel2.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 330, -1, -1));

        jLabel5.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel5.setText("Descripción:");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        txtDescripcion.setColumns(20);
        txtDescripcion.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        txtDescripcion.setRows(5);
        jScrollPane3.setViewportView(txtDescripcion);

        jPanel2.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 410, 126));

        jLabel6.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel6.setText("Nombre de la Categoría (*)");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 12, -1, -1));
        jPanel2.add(lblImagenCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(454, 54, 190, 210));

        btnCargarImg.setText("Cargar Imagen");
        btnCargarImg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargarImgActionPerformed(evt);
            }
        });
        jPanel2.add(btnCargarImg, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 280, -1, 30));
        jPanel2.add(txtId, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 40, 20, -1));
        jPanel2.add(txtImg, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 70, 20, -1));

        jTabbedPane3.addTab("", jPanel2);

        tabGeneral.addTab("Mantenimiento", jTabbedPane3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabGeneral)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(tabGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed

        tabGeneral.setEnabledAt(0, false);
        tabGeneral.setEnabledAt(1, true);
        tabGeneral.setSelectedIndex(1);
        accion = "Guardar";
        btnGuardar.setText("Guardar");
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnCancerlarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancerlarActionPerformed
        tabGeneral.setEnabledAt(0, true);
        tabGeneral.setEnabledAt(1, false);
        tabGeneral.setSelectedIndex(0);
        
        this.limpiar();
    }//GEN-LAST:event_btnCancerlarActionPerformed

    private void btnCargarImgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarImgActionPerformed
        //Crear un componente JFileChoose sirve para abrir archivos o carpetas
        JFileChooser file = new JFileChooser();
        //Abrir la ventana de dialogo
        int opcion = file.showOpenDialog(this);
        //Verificar que el usuario presiono el botón aceptar
        if (opcion == JFileChooser.APPROVE_OPTION) {
            archivoImagenCategoria = file.getSelectedFile();
            
            String orig = archivoImagenCategoria.getPath();
            imgTemp = Paths.get(orig);
            imgName = archivoImagenCategoria.getName();
            
            //Dibujar la imagen de la categoría
            dibujarCcategoria(archivoImagenCategoria.getAbsolutePath());
        }
    }//GEN-LAST:event_btnCargarImgActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        String resp;
        
        //1. Vvrificar que el control tenga un nombre de categoría
        if (txtNombreCategoria.getText().length() == 0 || txtNombreCategoria.getText().length()  > 30){
            mensajeError("Debe escribir un nombre de categoría");
            txtNombreCategoria.requestFocus();
            return;
        }
        
        //2. Verificar la variable acción
        if (accion.equals("Editar")){
            
            //Si se selecciono otra imagén
            if (imgName != null){          
                resp = CONTROL.actualizar(
                    Integer.parseInt(txtId.getText()),
                    txtNombreCategoria.getText(),
                    nombreAnt,
                    txtDescripcion.getText(),
                    txtObservaciones.getText(),
                    imgName);
                
                    try{
                        String dest = System.getProperty("user.dir") + "/src/imagenes/categorias/" + imgName;
                        Path destino = Paths.get(dest);
                        Files.copy(imgTemp, destino, REPLACE_EXISTING);
                    } catch (IOException ex) {
                        System.out.println("Error" + ex);
                    }
                
                if(resp.equals("OK")){
                    mensajeOK("Registro actualizado correctamente");
                    limpiar();
                    listar("");

                    //Mover de ventana al usuario
                    tabGeneral.setEnabledAt(1, false);
                    tabGeneral.setEnabledAt(0, true);
                    tabGeneral.setSelectedIndex(0);
                } else {
                    mensajeError(resp);
                }
                
            } else {
                
                //Si no se cambio la imagen
                resp = CONTROL.actualizar(
                    Integer.parseInt(txtId.getText()),
                    txtNombreCategoria.getText(),
                    nombreAnt,
                    txtDescripcion.getText(),
                    txtObservaciones.getText(),
                    txtImg.getText());
                
                if(resp.equals("OK")){
                    mensajeOK("Registro actualizado correctamente");
                    limpiar();
                    listar("");

                    //Mover de ventana al usuario
                    tabGeneral.setEnabledAt(1, false);
                    tabGeneral.setEnabledAt(0, true);
                    tabGeneral.setSelectedIndex(0);
                } else {
                    mensajeError(resp);
                }
            
            }
            
        } else {
            try{
                String dest = System.getProperty("user.dir") + "/src/imagenes/categorias/" + archivoImagenCategoria.getName();
                Path destino = Paths.get(dest);

                Files.copy(imgTemp, destino, REPLACE_EXISTING);
            } catch (IOException ex) {
                System.out.println("Error" + ex);
            }
            //Vamos a colocar aquí el código
            resp = CONTROL.insertar(txtNombreCategoria.getText(), archivoImagenCategoria.getName(), txtDescripcion.getText(), txtObservaciones.getText());
            
            if(resp.equals("OK")){
                mensajeOK("Registro insertado correctamente");
                limpiar();
                listar("");
                
                //Mover de ventana al usuario
                tabGeneral.setEnabledAt(1, false);
                tabGeneral.setEnabledAt(0, true);
                tabGeneral.setSelectedIndex(0);
            } else {
                mensajeError(resp);
            }
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        //1. Verificar que exista un registro seleccionado
        if (tablaListado.getSelectedRowCount() == 1) {
            //2. Objetener del registro seleccionado los datos a variables temporales
            String id = String.valueOf(tablaListado.getValueAt(tablaListado.getSelectedRow(), 0));
            String categoria = String.valueOf(tablaListado.getValueAt(tablaListado.getSelectedRow(), 1));
            nombreAnt = String.valueOf(tablaListado.getValueAt(tablaListado.getSelectedRow(), 1));
            String descripcion = String.valueOf(tablaListado.getValueAt(tablaListado.getSelectedRow(), 2));
            String obs = String.valueOf(tablaListado.getValueAt(tablaListado.getSelectedRow(), 3));
            String img = String.valueOf(tablaListado.getValueAt(tablaListado.getSelectedRow(), 4));
            //String estado = String.valueOf(tablaListado.getValueAt(tablaListado.getSelectedRow(), 3));
            
            String ruta = System.getProperty("user.dir") + "/src/imagenes/categorias/" + img;
            
            //3. Llenar los controles del formulario 
            txtId.setText(id);
            txtNombreCategoria.setText(categoria);
            txtDescripcion.setText(descripcion);
            txtObservaciones.setText(obs);
            txtImg.setText(img);
            dibujarCcategoria(ruta);
            
            //4. Activar el TAB o la vista de mantenimiento al usuario
            tabGeneral.setEnabledAt(0, false);
            tabGeneral.setEnabledAt(1, true);
            tabGeneral.setSelectedIndex(1);
            
            //4. Asignaer el valor de "Editar" a la variable acción
            accion="Editar";
            btnGuardar.setText("Editar");
        } else {
            mensajeError("Debes seleccionar una categoría");
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnActivarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActivarActionPerformed
        // 1. Verificar que el usuario hay seleccionado registros
        if (tablaListado.getSelectedRowCount() == 1) {
            //2. Obtener el ID y el nombre de la categoría
            String id = String.valueOf(tablaListado.getValueAt(tablaListado.getSelectedRow(), 0));
            String categoria = String.valueOf(tablaListado.getValueAt(tablaListado.getSelectedRow(), 1));
            
            //3. Preguntar al usuario si realmente lo deasea Desactivar
            if (JOptionPane.showConfirmDialog(this, "Desea activar la categoria: "+categoria, "Activar", JOptionPane.YES_NO_OPTION) == 0){
                //4. Ddesactivar el registro
                String resp = CONTROL.activar(Integer.parseInt(id));
                //5. Verificar respuesta
                if (resp.equals("OK")){
                    mensajeOK("Registro Activado");
                    
                    //Mostar la tabla actualizada
                    listar("");
                } else {
                    mensajeError(resp);
                }
            }
        } else {
            mensajeError("Debes seleccionar el registro a activar");
        }
    }//GEN-LAST:event_btnActivarActionPerformed

    private void btnDesactivarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivarActionPerformed
        // 1. Verificar que el usuario hay seleccionado registros
        if (tablaListado.getSelectedRowCount() == 1) {
            //2. Obtener el ID y el nombre de la categoría
            String id = String.valueOf(tablaListado.getValueAt(tablaListado.getSelectedRow(), 0));
            String categoria = String.valueOf(tablaListado.getValueAt(tablaListado.getSelectedRow(), 1));
            
            //3. Preguntar al usuario si realmente lo deasea Desactivar
            if (JOptionPane.showConfirmDialog(this, "Desea desactivar la categoria: "+categoria, "Desactivar", JOptionPane.YES_NO_OPTION) == 0){
                //4. Ddesactivar el registro
                String resp = CONTROL.desactivar(Integer.parseInt(id));
                //5. Verificar respuesta
                if (resp.equals("OK")){
                    mensajeOK("Registro desactivado");
                    
                    //Mostar la tabla actualizada
                    listar("");
                } else {
                    mensajeError(resp);
                }
            }
        } else {
            mensajeError("Debes seleccionar el registro a desactivar");
        }
    }//GEN-LAST:event_btnDesactivarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActivar;
    private javax.swing.JButton btnCancerlar;
    private javax.swing.JButton btnCargarImg;
    private javax.swing.JButton btnDesactivar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JLabel lblImagenCategoria;
    private javax.swing.JTabbedPane tabGeneral;
    private javax.swing.JTable tablaListado;
    private javax.swing.JTextArea txtDescripcion;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtImg;
    private javax.swing.JTextField txtNombreCategoria;
    private javax.swing.JTextArea txtObservaciones;
    // End of variables declaration//GEN-END:variables
}
