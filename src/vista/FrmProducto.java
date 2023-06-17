package vista;

import entidades.Categorias;
import entidades.SubCategorias;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import negocio.ProductoControl;
import vista.utils.ImgProductsTable;

public class FrmProducto extends javax.swing.JInternalFrame {
    
    //Crear una variable para instanciar a la capa negocio o control
    private final ProductoControl CONTROL;
    private File archivoImagenProducto; //Guardar el nombre de Imagen de la Categoría
    private String accion;
    private String nombreAnt;
    private int descuento;
    private String tipoProducto;
    private Categorias categoriaSeleccionada;
    private SubCategorias subcategoriaSeleccionada;
    private Path imgTemp;
    private String imgName = null;
    
    public FrmProducto() {
        initComponents();
        
        descuento = 0;
        tipoProducto = "N";
        //Inicializar CONTROL
        CONTROL = new ProductoControl();
        //Mandar llamar listar
        listar("");
        tabGeneral.setEnabledAt(1, false);
        accion = "Guardar";
        
        //Ocultar variables
        txtId.setVisible(false);
        txtImg.setVisible(false);
        cargarCategorias();
        cargarSubCategorias();
        
        //Agregar los controles JRadioButton al grupo
        btnGpoDescuento.add(optDescuento1);
        btnGpoDescuento.add(optDescuento2);
        btnGpoDescuento.add(optDescuento3);
        
        btnGpoTipo.add(optTipo1);
        btnGpoTipo.add(optTipo2);
        btnGpoTipo.add(optTipo3);
    }
    
    //Método listar para que muestre las categorias
    private void listar(String texto) {
        //Llenar el modelo del JTable de nombre tabla Listado
        tablaListado.setModel(CONTROL.listar(texto, 10,1));
        
        tablaListado.getColumnModel().getColumn(1).setMaxWidth(0);
        tablaListado.getColumnModel().getColumn(1).setMinWidth(0);
        tablaListado.getColumnModel().getColumn(1).setPreferredWidth(0);
        
        tablaListado.getColumnModel().getColumn(3).setMaxWidth(0);
        tablaListado.getColumnModel().getColumn(3).setMinWidth(0);
        tablaListado.getColumnModel().getColumn(3).setPreferredWidth(0);
        
        tablaListado.setRowHeight(60);
        tablaListado.getColumnModel().getColumn(11).setCellRenderer(new ImgProductsTable());
        
        //Total de registros
        lblRegistros.setText("Registros mostrados: " + CONTROL.totalMostrados() + " de un total de " + Integer.toString(CONTROL.total()));
    }
    
    //Crear un método para limpiar los controles
    private void limpiar() {
        txtProducto.setText("");
        accion = "Guardar";
        txtPrecio.setText("");
        txtExistencia.setText("");
        btnGpoDescuento.clearSelection();
        btnGpoTipo.clearSelection();
        lblImagenProducto.setIcon(null);
    }
    
    //Método para cargar las categorías
    private void cargarCategorias() {
        DefaultComboBoxModel modeloCategorias = CONTROL.seleccionarCategorias();
        cmbCategoria.setModel(modeloCategorias);
    }
    
    //Método para cargar las Sub categorías
    private void cargarSubCategorias() {
        DefaultComboBoxModel modeloSubCategorias = CONTROL.seleccionarSubCategorias();
        cmbSubCategoria.setModel(modeloSubCategorias);
    }  
    
    private void dibujarCcategoria(String ruta) {
        ImageIcon imagen = new ImageIcon(ruta);
        //Convertir la imagen a un icono
        Icon icono = new ImageIcon(imagen.getImage().getScaledInstance(lblImagenProducto.getWidth(), lblImagenProducto.getHeight(), Image.SCALE_SMOOTH));
        lblImagenProducto.setIcon(icono);
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

        btnGpoDescuento = new javax.swing.ButtonGroup();
        btnGpoTipo = new javax.swing.ButtonGroup();
        tabGeneral = new javax.swing.JTabbedPane();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaListado = new javax.swing.JTable();
        txtSearchProduct = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnActivar = new javax.swing.JButton();
        btnDesactivar = new javax.swing.JButton();
        lblRegistros = new javax.swing.JLabel();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        optDescuento1 = new javax.swing.JRadioButton();
        optDescuento2 = new javax.swing.JRadioButton();
        optDescuento3 = new javax.swing.JRadioButton();
        jPanel4 = new javax.swing.JPanel();
        optTipo1 = new javax.swing.JRadioButton();
        optTipo2 = new javax.swing.JRadioButton();
        optTipo3 = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        txtProducto = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btnCancerlar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        lblImagenProducto = new javax.swing.JLabel();
        btnCargarImg = new javax.swing.JButton();
        txtExistencia = new javax.swing.JFormattedTextField();
        txtId = new javax.swing.JTextField();
        txtImg = new javax.swing.JTextField();
        cmbSubCategoria = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        cmbCategoria = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        txtPrecio = new javax.swing.JFormattedTextField();
        jLabel9 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Productos");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        jPanel1.add(txtSearchProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 30, 310, -1));

        btnBuscar.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        btnBuscar.setForeground(new java.awt.Color(0, 51, 204));
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        jPanel1.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 30, 80, -1));

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

        lblRegistros.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jPanel1.add(lblRegistros, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 350, 410, 30));

        jTabbedPane2.addTab("", jPanel1);

        tabGeneral.addTab("Listado", jTabbedPane2);

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Descuento del Producto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Roboto", 0, 14))); // NOI18N
        jPanel3.setForeground(new java.awt.Color(255, 102, 102));
        jPanel3.setOpaque(false);
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        optDescuento1.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        optDescuento1.setText("5%");
        optDescuento1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optDescuento1ActionPerformed(evt);
            }
        });
        jPanel3.add(optDescuento1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        optDescuento2.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        optDescuento2.setText("10%");
        optDescuento2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optDescuento2ActionPerformed(evt);
            }
        });
        jPanel3.add(optDescuento2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, -1, -1));

        optDescuento3.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        optDescuento3.setText("15%");
        optDescuento3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optDescuento3ActionPerformed(evt);
            }
        });
        jPanel3.add(optDescuento3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, -1, -1));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 190, 60));

        jPanel4.setBackground(new java.awt.Color(0, 0, 0));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tipo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Roboto", 0, 14))); // NOI18N
        jPanel4.setForeground(new java.awt.Color(255, 102, 102));
        jPanel4.setOpaque(false);
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        optTipo1.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        optTipo1.setText("Nuevo");
        optTipo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optTipo1ActionPerformed(evt);
            }
        });
        jPanel4.add(optTipo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        optTipo2.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        optTipo2.setText("Oferta");
        optTipo2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optTipo2ActionPerformed(evt);
            }
        });
        jPanel4.add(optTipo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, -1, -1));

        optTipo3.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        optTipo3.setText("Más vendido");
        optTipo3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optTipo3ActionPerformed(evt);
            }
        });
        jPanel4.add(optTipo3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, -1, -1));

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 100, 260, 60));

        jLabel2.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel2.setText("Existencia (*)");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, -1, -1));

        txtProducto.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jPanel2.add(txtProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 50, 370, -1));

        jLabel4.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel4.setText("(*) Indica que el campo es obligatorio.");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, -1, -1));

        btnCancerlar.setText("Cancelar");
        btnCancerlar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancerlarActionPerformed(evt);
            }
        });
        jPanel2.add(btnCancerlar, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 360, -1, -1));

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel2.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 360, -1, -1));

        jLabel6.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel6.setText("Subcategoria (*)");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 10, -1, -1));
        jPanel2.add(lblImagenProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 110, 180, 180));

        btnCargarImg.setText("Cargar Imagen");
        btnCargarImg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargarImgActionPerformed(evt);
            }
        });
        jPanel2.add(btnCargarImg, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 310, -1, 30));

        txtExistencia.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        jPanel2.add(txtExistencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 180, 140, -1));
        jPanel2.add(txtId, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 210, 20, -1));
        jPanel2.add(txtImg, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 210, 20, -1));

        cmbSubCategoria.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jPanel2.add(cmbSubCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 10, 210, -1));

        jLabel7.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel7.setText("Categorías (*)");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        cmbCategoria.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jPanel2.add(cmbCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, 200, -1));

        jLabel8.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel8.setText("Nombre (*)");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, -1));

        txtPrecio.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        jPanel2.add(txtPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 50, 90, -1));

        jLabel9.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel9.setText("Precio (*)");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 50, -1, -1));

        jTabbedPane3.addTab("", jPanel2);

        tabGeneral.addTab("Mantenimiento", jTabbedPane3);

        getContentPane().add(tabGeneral, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 450));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed

        tabGeneral.setEnabledAt(0, false);
        tabGeneral.setEnabledAt(1, true);
        tabGeneral.setSelectedIndex(1);
        accion = "Guardar";
        btnGuardar.setText("Guardar");
        
        dibujarCcategoria("src/imagenes/productos/producto_default.jpg");
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
            archivoImagenProducto = file.getSelectedFile();
            
            String orig = archivoImagenProducto.getPath();
            imgTemp = Paths.get(orig);
            imgName = archivoImagenProducto.getName();
            
            //Dibujar la imagen de la categoría
            dibujarCcategoria(archivoImagenProducto.getAbsolutePath());
        }
    }//GEN-LAST:event_btnCargarImgActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        String resp;
        
        //1. Vvrificar que el control tenga un nombre de Producto
        if (txtProducto.getText().length() == 0 || txtProducto.getText().length()  > 99){
            mensajeError("Debe escribir un nombre de producto y no debe ser mayor a 99 carácteres.");
            txtProducto.requestFocus();
            return;
        }
        
        // Validar el precio del producto
        if (txtPrecio.getText().length() == 0) {
            mensajeError("El precío no debe estar vacío");
            txtProducto.requestFocus();
            return;
        }
        
        // Validar la existencia del producto
        if (txtExistencia.getText().length() == 0) {
            mensajeError("La existencia no debe estar vacía");
            txtExistencia.requestFocus();
            return;
        }
        
        //2. Verificar la variable acción
        if (accion.equals("Editar")){
            
            //Si se selecciono otra imagén
            if (imgName != null){
                
                categoriaSeleccionada = (Categorias)cmbCategoria.getSelectedItem();
                subcategoriaSeleccionada = (SubCategorias) cmbSubCategoria.getSelectedItem();
                
                resp = CONTROL.actualizar(
                    Integer.parseInt(txtId.getText()),
                    categoriaSeleccionada.getIdCategoria(),
                    categoriaSeleccionada.getNombreCategoria(),
                    subcategoriaSeleccionada.getIdSubCategoria(),
                    subcategoriaSeleccionada.getNombreSubCategoria(),
                    txtProducto.getText(),
                    nombreAnt,
                    Float.parseFloat(txtPrecio.getText()),
                    descuento,
                    Integer.parseInt(txtExistencia.getText()),
                    tipoProducto,
                    imgName,
                    "");
                
                    try{
                        String dest = System.getProperty("user.dir") + "/src/imagenes/productos/" + imgName;
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
                
                categoriaSeleccionada = (Categorias)cmbCategoria.getSelectedItem();
                subcategoriaSeleccionada = (SubCategorias) cmbSubCategoria.getSelectedItem();
                
                //Si no se cambio la imagen
                resp = CONTROL.actualizar(
                    Integer.parseInt(txtId.getText()),
                    categoriaSeleccionada.getIdCategoria(),
                    categoriaSeleccionada.getNombreCategoria(),
                    subcategoriaSeleccionada.getIdSubCategoria(),
                    subcategoriaSeleccionada.getNombreSubCategoria(),
                    txtProducto.getText(),
                    nombreAnt,
                    Float.parseFloat(txtPrecio.getText()),
                    descuento,
                    Integer.parseInt(txtExistencia.getText()),
                    tipoProducto,
                    txtImg.getText(),
                    ""
                );
                
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
            String img = "producto_default.jpg";
            
            if (imgName != null){
                 try{
                    String dest = System.getProperty("user.dir") + "/src/imagenes/productos/" + archivoImagenProducto.getName();
                    Path destino = Paths.get(dest);

                    Files.copy(imgTemp, destino, REPLACE_EXISTING);
                } catch (IOException ex) {
                    System.out.println("Error" + ex);
                }               
                img = archivoImagenProducto.getName();
            }
           
            //Vamos a colocar aquí el código
            categoriaSeleccionada = (Categorias)cmbCategoria.getSelectedItem();
            subcategoriaSeleccionada = (SubCategorias) cmbSubCategoria.getSelectedItem();
            
            resp = CONTROL.insertar(
                    categoriaSeleccionada.getIdCategoria(),
                    categoriaSeleccionada.getNombreCategoria(),
                    subcategoriaSeleccionada.getIdSubCategoria(),
                    subcategoriaSeleccionada.getNombreSubCategoria(),
                    txtProducto.getText(),
                    Float.parseFloat(txtPrecio.getText()),
                    descuento,
                    Integer.parseInt(txtExistencia.getText()),
                    tipoProducto,
                    img,
                    ""
                );
            
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
            String productoID = String.valueOf(tablaListado.getValueAt(tablaListado.getSelectedRow(), 0));
            String categoriaID = String.valueOf(tablaListado.getValueAt(tablaListado.getSelectedRow(), 1));
            String nombreCategoria = String.valueOf(tablaListado.getValueAt(tablaListado.getSelectedRow(), 2));
            String subCategoriaID = String.valueOf(tablaListado.getValueAt(tablaListado.getSelectedRow(), 3));
            String nombreSubCategoria = String.valueOf(tablaListado.getValueAt(tablaListado.getSelectedRow(), 4));
            String nombreProducto = String.valueOf(tablaListado.getValueAt(tablaListado.getSelectedRow(), 5));
            nombreAnt = String.valueOf(tablaListado.getValueAt(tablaListado.getSelectedRow(), 5));        
            String precioProducto = String.valueOf(tablaListado.getValueAt(tablaListado.getSelectedRow(), 6));
            int descuentoProducto = Integer.parseInt(String.valueOf(tablaListado.getValueAt(tablaListado.getSelectedRow(), 7)));
            String existenciaProducto = String.valueOf(tablaListado.getValueAt(tablaListado.getSelectedRow(), 8));
            String tipoDeProducto = String.valueOf(tablaListado.getValueAt(tablaListado.getSelectedRow(), 9));
            String img = String.valueOf(tablaListado.getValueAt(tablaListado.getSelectedRow(), 11));
            
            String ruta = System.getProperty("user.dir") + "/src/imagenes/productos/" + img;
            
            //3. Llenar los controles del formulario 
            txtId.setText(productoID);
            txtProducto.setText(nombreProducto);
            txtPrecio.setText(precioProducto);
            txtExistencia.setText(existenciaProducto);
            txtImg.setText(img);
            dibujarCcategoria(ruta);          
            descuento = descuentoProducto;
            tipoProducto = tipoDeProducto;
            
            //Mostrar las categorias y subcategorias en los combos
            categoriaSeleccionada = new Categorias(Integer.parseInt(categoriaID),nombreCategoria);
            cmbCategoria.setSelectedItem(categoriaSeleccionada);
            
            subcategoriaSeleccionada = new SubCategorias(Integer.parseInt(subCategoriaID),nombreSubCategoria);
            cmbSubCategoria.setSelectedItem(subcategoriaSeleccionada);
            
            //Validar los JRadio Buttons
            if (descuentoProducto == 5) {
                optDescuento1.setSelected(true);
            } else if (descuentoProducto == 10) {
                optDescuento2.setSelected(true);
            } else if (descuentoProducto == 15) {
                optDescuento3.setSelected(true);
            }
            
            if (tipoDeProducto.equals("N")) {
                optTipo1.setSelected(true);
            } else if (tipoDeProducto.equals("O")) {
                optTipo2.setSelected(true);    
            } else if (tipoDeProducto.equals("M")) {
                optTipo3.setSelected(true); 
            }
            
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
            //2. Obtener el ID y el nombre del producto
            String id = String.valueOf(tablaListado.getValueAt(tablaListado.getSelectedRow(), 0));
            String nombreProducto = String.valueOf(tablaListado.getValueAt(tablaListado.getSelectedRow(), 5));
            
            //3. Preguntar al usuario si realmente lo deasea Desactivar
            if (JOptionPane.showConfirmDialog(this, "Desea activar el producto: "+nombreProducto, "Activar", JOptionPane.YES_NO_OPTION) == 0){
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
            //2. Obtener el ID y el nombre del producto
            String id = String.valueOf(tablaListado.getValueAt(tablaListado.getSelectedRow(), 0));
            String nombreProducto = String.valueOf(tablaListado.getValueAt(tablaListado.getSelectedRow(), 5));
            
            //3. Preguntar al usuario si realmente lo deasea Desactivar
            if (JOptionPane.showConfirmDialog(this, "Desea desactivar el producto: "+nombreProducto, "Desactivar", JOptionPane.YES_NO_OPTION) == 0){
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

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        listar(txtSearchProduct.getText());
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void optDescuento1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optDescuento1ActionPerformed
        descuento = Integer.parseInt(optDescuento1.getText().split("%")[0]);
    }//GEN-LAST:event_optDescuento1ActionPerformed

    private void optDescuento2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optDescuento2ActionPerformed
        descuento = Integer.parseInt(optDescuento2.getText().split("%")[0]);
    }//GEN-LAST:event_optDescuento2ActionPerformed

    private void optDescuento3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optDescuento3ActionPerformed
        descuento = Integer.parseInt(optDescuento3.getText().split("%")[0]);
    }//GEN-LAST:event_optDescuento3ActionPerformed

    private void optTipo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optTipo1ActionPerformed
        tipoProducto = "N";
    }//GEN-LAST:event_optTipo1ActionPerformed

    private void optTipo2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optTipo2ActionPerformed
        tipoProducto = "O";
    }//GEN-LAST:event_optTipo2ActionPerformed

    private void optTipo3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optTipo3ActionPerformed
        tipoProducto = "M";
    }//GEN-LAST:event_optTipo3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActivar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancerlar;
    private javax.swing.JButton btnCargarImg;
    private javax.swing.JButton btnDesactivar;
    private javax.swing.JButton btnEditar;
    private javax.swing.ButtonGroup btnGpoDescuento;
    private javax.swing.ButtonGroup btnGpoTipo;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JComboBox cmbCategoria;
    private javax.swing.JComboBox cmbSubCategoria;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JLabel lblImagenProducto;
    private javax.swing.JLabel lblRegistros;
    private javax.swing.JRadioButton optDescuento1;
    private javax.swing.JRadioButton optDescuento2;
    private javax.swing.JRadioButton optDescuento3;
    private javax.swing.JRadioButton optTipo1;
    private javax.swing.JRadioButton optTipo2;
    private javax.swing.JRadioButton optTipo3;
    private javax.swing.JTabbedPane tabGeneral;
    private javax.swing.JTable tablaListado;
    private javax.swing.JFormattedTextField txtExistencia;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtImg;
    private javax.swing.JFormattedTextField txtPrecio;
    private javax.swing.JTextField txtProducto;
    private javax.swing.JTextField txtSearchProduct;
    // End of variables declaration//GEN-END:variables
}
