package vista;

import entidades.Cliente;
import java.awt.Font;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import negocio.VentaControl;
import negocio.ClienteControl;

public class FrmVenta extends javax.swing.JInternalFrame {

    //Crear una variable para instanciar a la capa negocio o control
    private final VentaControl CONTROL;
    private final ClienteControl CONTROLCLIENT;
    private String accion;
    private DefaultTableModel modeloDetalles;

    public FrmVenta() {
        initComponents();

        //Inicializar CONTROL
        CONTROL = new VentaControl();
        CONTROLCLIENT = new ClienteControl();
        //Mandar llamar listar
        listar("");
        tabGeneral.setEnabledAt(1, false);
        crearDetalles();
    }

    //Método listar para que muestre las categorias
    private void listar(String texto) {
        //Llenar el modelo del JTable de nombre tabla Listado
        tablaListado.setModel(CONTROL.listar(texto, 10, 1));
        darFormatoTabla();

        //Total de registros
        //lblRegistros.setText("Registros mostrados: " + CONTROL.totalMostrados() + " de un total de " + Integer.toString(CONTROL.total()));
    }

    // Formato a tablas
    public void darFormatoTabla() {
        // Formatear encabezado
        JTableHeader th;
        th = tablaListado.getTableHeader();
        Font fuente = new Font("Roboto", Font.BOLD, 13);
        th.setFont(fuente);

        // Centrar contenido
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(SwingConstants.CENTER);
        // Celda ID Venta
        tablaListado.getColumnModel().getColumn(0).setCellRenderer(tcr);
        // ID del cliente
        //tablaListado.getColumnModel().getColumn(1).setCellRenderer(tcr);
        // Nombre del Cliente
        //tablaListado.getColumnModel().getColumn(2).setCellRenderer(tcr);
        // Fecha
        tablaListado.getColumnModel().getColumn(3).setCellRenderer(tcr);
        // Total
        tablaListado.getColumnModel().getColumn(4).setCellRenderer(tcr);
        // IVA
        //tablaListado.getColumnModel().getColumn(5).setCellRenderer(tcr);
        // Estado
        //tablaListado.getColumnModel().getColumn(6).setCellRenderer(tcr);

        tablaListado.getColumnModel().getColumn(0).setMaxWidth(50);
        tablaListado.getColumnModel().getColumn(0).setMinWidth(50);
        tablaListado.getColumnModel().getColumn(0).setPreferredWidth(50);

        // Tamaño a columna:ID del cliente
        tablaListado.getColumnModel().getColumn(1).setMaxWidth(0);
        tablaListado.getColumnModel().getColumn(1).setMinWidth(0);
        tablaListado.getColumnModel().getColumn(1).setPreferredWidth(0);

        // Tamaño a columna: Nombre del Cliente
        tablaListado.getColumnModel().getColumn(2).setMaxWidth(200);
        tablaListado.getColumnModel().getColumn(2).setMinWidth(200);
        tablaListado.getColumnModel().getColumn(2).setPreferredWidth(200);

        // Tamaño a columna:Producto 5
        tablaListado.getColumnModel().getColumn(3).setMaxWidth(100);
        tablaListado.getColumnModel().getColumn(3).setMinWidth(100);
        tablaListado.getColumnModel().getColumn(3).setPreferredWidth(100);

        // Tamaño a columna: Precio 6
        tablaListado.getColumnModel().getColumn(4).setMaxWidth(100);
        tablaListado.getColumnModel().getColumn(4).setMinWidth(100);
        tablaListado.getColumnModel().getColumn(4).setPreferredWidth(100);

        // Tamaño a columna: Descuento 7
        tablaListado.getColumnModel().getColumn(5).setMaxWidth(100);
        tablaListado.getColumnModel().getColumn(5).setMinWidth(100);
        tablaListado.getColumnModel().getColumn(5).setPreferredWidth(100);

        // Tamaño a columna: Stock 8
        tablaListado.getColumnModel().getColumn(6).setMaxWidth(120);
        tablaListado.getColumnModel().getColumn(6).setMinWidth(120);
        tablaListado.getColumnModel().getColumn(6).setPreferredWidth(120);
    }
    
    //crear la estructura del modelo de la tabla
    private void crearDetalles() {
        //Id producto,pro,can,pre,des,subt
        modeloDetalles = new DefaultTableModel(){
        //regresa si la celda es editable
        @Override
        public boolean isCellEditable(int fila,int columna)
        {
            if(columna==2)
            {
                return true;
            }
            if(columna==3)
            {
                return true;
            }
            return false;
            //metodo para obtener valores de la celda
           
        }
         @Override
            public Object getValueAt(int row,int col)
            {
                if (col==5)
                {
                    Double cantD;
                    //obtener cantidad
                    try
                    {
                        cantD=Double.parseDouble(getValueAt(row, 2).toString());
                        
                    }
                    catch(Exception e)
                    {
                        cantD=1.0;
                    }
                    Double precioD;
                    precioD=Double.parseDouble(getValueAt(row, 3).toString());
                    if(cantD !=null && precioD!=null)
                    {
                        return String.format("%.2f", cantD*precioD);
                    }
                    else
                    {
                        return 0;
                    }
                }
               return super.getValueAt(row, col);
            }//establece un valor en la celda
            @Override
            
            public void setValueAt(Object aValue, int row,int col)
            {
                super.setValueAt(aValue, row, col);
                calcularTotales();
                
                fireTableDataChanged();
            }
        };
        //definir las colimnas del modelo
        modeloDetalles.setColumnIdentifiers(new Object[]{"ID producto","Producto","Cantidad","Precio","Descuento","Subtotal"});
        //etablecer el modelo
        tablaDetalles.setModel(modeloDetalles);
    }
    
    // Agregar el Producto que el cliente desea comprar
    public void agregarDetalles(String id, String producto, String precio, String descuento) {
        String idTemp;
        boolean existe = false;
        
        //Bucar en todos los productos que tiene el modelo
        for (int i = 0; i < modeloDetalles.getRowCount(); i++) {
            //Obtener ID producto que se encunetra en modelo Detalles
            idTemp = modeloDetalles.getValueAt(i, 0).toString();
            if (idTemp.equals(id)) {
                existe = true;
            }
        }
        if(existe) {
            mensajeError("El Producto ya ha sido agregado");
        } else {
            modeloDetalles.addRow(new Object[]{id, producto, "1", precio, descuento});
            calcularTotales();
        }
    }
    
    //metodo calcular totales,iva, gran total 
    private void calcularTotales() {
        double total = 0;
        double subTotal = 0;
        //Obtener el número de productos que lleva el cliente
        int items = modeloDetalles.getRowCount();
        if (items == 0) {
            total = 0;
        } else {
            //Recorrer la lista de productos para obetner el total
            for (int i = 0; i < items; i++) {
                total = total + Double.parseDouble(modeloDetalles.getValueAt(i, 5).toString());
            }           
        }
        subTotal = total/1.16;
        //Llenar los controles
        txtTotal.setText(String.format("%.2f", total));
        txtSubtotal.setText(String.format("%.2f", subTotal));
        txtIVA.setText(String.format("%.2f", total-subTotal));
    }

    //Crear un método para limpiar los controles
    private void limpiar() {
        accion = "Guardar";
        btnGpoDescuento.clearSelection();
        btnGpoTipo.clearSelection();
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
        btnCancelarVenta = new javax.swing.JButton();
        lblRegistros = new javax.swing.JLabel();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        lblRFC = new javax.swing.JLabel();
        txtIdCliente = new javax.swing.JTextField();
        btnBuscarCliente = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtIdProducto = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        btnVer = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaDetalles = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        txtSubtotal = new javax.swing.JTextField();
        txtIVA = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnCancerlar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        lblRFC1 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        txtRFC = new javax.swing.JTextField();
        btnQuitar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Venta de Productos");
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

        btnCancelarVenta.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        btnCancelarVenta.setText("Cancelar");
        btnCancelarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarVentaActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancelarVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, 120, -1));

        lblRegistros.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jPanel1.add(lblRegistros, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 350, 410, 30));

        jTabbedPane2.addTab("", jPanel1);

        tabGeneral.addTab("Listado", jTabbedPane2);

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblRFC.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        lblRFC.setText("Direccion:");
        jPanel3.add(lblRFC, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 70, 20));

        txtIdCliente.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jPanel3.add(txtIdCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, 70, -1));

        btnBuscarCliente.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        btnBuscarCliente.setText("Buscar Cliente");
        btnBuscarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarClienteActionPerformed(evt);
            }
        });
        jPanel3.add(btnBuscarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 60, 110, -1));

        jLabel3.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel3.setText("Código del Producto");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 140, 20));

        txtIdProducto.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txtIdProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtIdProductoKeyReleased(evt);
            }
        });
        jPanel3.add(txtIdProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, 100, -1));

        jLabel4.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel4.setText("Cliente:");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 50, 20));

        txtNombre.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txtNombre.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtNombre.setText("Nombre");
        txtNombre.setEnabled(false);
        jPanel3.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 60, 200, -1));

        btnVer.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        btnVer.setText("Ver");
        jPanel3.add(btnVer, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 130, -1, -1));

        tablaDetalles.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tablaDetalles);

        jPanel3.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 670, 190));

        jLabel2.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel2.setText("Total:");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 420, -1, -1));

        txtTotal.setBackground(new java.awt.Color(51, 204, 0));
        txtTotal.setEnabled(false);
        jPanel3.add(txtTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 420, 70, -1));

        txtSubtotal.setEnabled(false);
        jPanel3.add(txtSubtotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 360, 70, -1));

        txtIVA.setEnabled(false);
        jPanel3.add(txtIVA, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 390, 70, -1));

        jLabel5.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel5.setText("SubTotal:");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 360, -1, -1));

        jLabel6.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel6.setText("IVA:");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 390, -1, -1));

        btnCancerlar.setText("Cancelar");
        btnCancerlar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancerlarActionPerformed(evt);
            }
        });
        jPanel3.add(btnCancerlar, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 390, -1, -1));

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel3.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 390, -1, -1));

        lblRFC1.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        lblRFC1.setText("RFC:");
        jPanel3.add(lblRFC1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 60, 30, 20));

        txtDireccion.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txtDireccion.setEnabled(false);
        jPanel3.add(txtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 100, 590, -1));

        txtRFC.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txtRFC.setEnabled(false);
        jPanel3.add(txtRFC, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 60, 160, -1));

        btnQuitar.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        btnQuitar.setText("Quitar");
        btnQuitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarActionPerformed(evt);
            }
        });
        jPanel3.add(btnQuitar, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 130, -1, -1));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 670, 460));

        jTabbedPane3.addTab("", jPanel2);

        tabGeneral.addTab("Mantenimiento", jTabbedPane3);

        getContentPane().add(tabGeneral, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 520));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        String resp = "";
        
        //Verificar que se haya escrito el ID del cliente
        if(txtIdCliente.getText().length() == 0){
            mensajeError("Debes escribir un número de cliente");
            return;
        }
        
        if(modeloDetalles.getRowCount() == 0){
            mensajeError("Debe agregar al menos un producto");
            return;
        }
        
        resp = CONTROL.insertar(
                100,
                Double.parseDouble(txtTotal.getText()),
                Double.parseDouble(txtIVA.getText()),
                modeloDetalles);
        
        if (resp.equals("OK")) {
            mensajeOK("Registro insertado correctamente");
            limpiar();
            listar("");
        } else {
            mensajeError(resp);
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancerlarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancerlarActionPerformed
        tabGeneral.setEnabledAt(0, true);
        tabGeneral.setEnabledAt(1, false);
        tabGeneral.setSelectedIndex(0);

        this.limpiar();
    }//GEN-LAST:event_btnCancerlarActionPerformed

    private void btnCancelarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarVentaActionPerformed
        // 1. Verificar que el usuario hay seleccionado registros
        if (tablaListado.getSelectedRowCount() == 1) {
            //2. Obtener el ID y el nombre del producto
            String id = String.valueOf(tablaListado.getValueAt(tablaListado.getSelectedRow(), 0));

            //3. Preguntar al usuario si realmente lo deasea Desactivar
            if (JOptionPane.showConfirmDialog(this, "Deseas cancelar la venta: " +id, "Cancelar Venta", JOptionPane.YES_NO_OPTION) == 0){
                //4. Ddesactivar el registro
                String resp = CONTROL.cancelarVenta(Integer.parseInt(id));
                //5. Verificar respuesta
                if (resp.equals("OK")){
                    mensajeOK("Venta Cancelada");
                    //Mostar la tabla actualizada
                    listar("");
                } else {
                    mensajeError(resp);
                }
            }
        } else {
            mensajeError("Debes seleccionar el registro a desactivar");
        }
    }//GEN-LAST:event_btnCancelarVentaActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed

        tabGeneral.setEnabledAt(0, false);
        tabGeneral.setEnabledAt(1, true);
        tabGeneral.setSelectedIndex(1);
        accion = "Guardar";
        btnGuardar.setText("Guardar");
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed

    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnBuscarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarClienteActionPerformed

        if(txtIdCliente.getText().equals("")){
            mensajeError("Debe Ingresar un ID Cliente");
            return;
        }
        
        Cliente result = CONTROLCLIENT.Buscar(Integer.parseInt(txtIdCliente.getText()));     
        if(result == null){
            mensajeError("El cliente no existe");
            return;
        }
        
        txtRFC.setText(result.getRfc());
        txtNombre.setText(result.getNombre() + " " + result.getApellidos());
        txtDireccion.setText(result.getDireccion() + " " + result.getCiudad() + " " + result.getEstado());
    }//GEN-LAST:event_btnBuscarClienteActionPerformed

    private void txtIdProductoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdProductoKeyReleased
        //Verificar que no este vacío el control
        if(txtIdProducto.getText().length()>0) {
            //Verificar que se preesiono la tecla Enter
            if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                entidades.Productos prod;
                prod = CONTROL.obtenerProducto(Integer.parseInt(txtIdProducto.getText()));
                //Verificar si se encontro el producto
                if(prod == null) {
                    mensajeError("No se encontro el Producto: " + txtIdProducto.getText());
                    txtIdProducto.requestFocus();
                    return;
                } else {
                    //Agregar el producto al modelo
                    agregarDetalles(String.valueOf(prod.getIdProducto()), prod.getNombreProducto(), String.valueOf(prod.getPrecioProducto()), String.valueOf(prod.getDescuentoProducto()));
                    //modeloDetalles.addRow(new Object[]{prod.getIdProducto(), prod.getNombreProducto(), "1", prod.getPrecioProducto(), prod.getDescuentoProducto(), prod.getPrecioProducto()});
                }
            }
        } else {
            mensajeError("Debe escribir el código del Producto");
        }
    }//GEN-LAST:event_txtIdProductoKeyReleased

    private void btnQuitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarActionPerformed
        //Verificar que el usuario haya seleccionado un producto
        if (tablaDetalles.getSelectedRowCount() == 1) {
            modeloDetalles.removeRow(tablaDetalles.getSelectedRow());
            calcularTotales();
        } else {
            mensajeError("Debe Seleccionar un producto");
        }
    }//GEN-LAST:event_btnQuitarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnBuscarCliente;
    private javax.swing.JButton btnCancelarVenta;
    private javax.swing.JButton btnCancerlar;
    private javax.swing.ButtonGroup btnGpoDescuento;
    private javax.swing.ButtonGroup btnGpoTipo;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnQuitar;
    private javax.swing.JButton btnVer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JLabel lblRFC;
    private javax.swing.JLabel lblRFC1;
    private javax.swing.JLabel lblRegistros;
    private javax.swing.JTabbedPane tabGeneral;
    private javax.swing.JTable tablaDetalles;
    private javax.swing.JTable tablaListado;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtIVA;
    private javax.swing.JTextField txtIdCliente;
    private javax.swing.JTextField txtIdProducto;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtRFC;
    private javax.swing.JTextField txtSearchProduct;
    private javax.swing.JTextField txtSubtotal;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
