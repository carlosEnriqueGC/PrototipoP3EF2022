/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seguridad.vista;


import seguridad.modelo.daoProveedor;
import seguridad.controlador.clsProveedor;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import java.io.File;

/**
 *
 * @author visitante
 */
public class frmMantenimientoProveedores extends javax.swing.JInternalFrame {


    public void estados() {    
        cbox_estado.addItem("seleccione: "); 
        cbox_estado.addItem("activo");
        cbox_estado.addItem("inactivo");
        cbox_estado.addItem("suspendido");
    }
 
    

    public void llenadoDeTablas() {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("codigo");
        modelo.addColumn("nombre");
        modelo.addColumn("direccion");
        modelo.addColumn("telefono");
        modelo.addColumn("nit");
        modelo.addColumn("estado");
        daoProveedor mDAO = new daoProveedor();
        List<clsProveedor> m = mDAO.select();
        tablaVendedores.setModel(modelo);
        String[] dato = new String[10];
        for (int i = 0; i < m.size(); i++) {
            dato[0] = Integer.toString(m.get(i).getidp());
            dato[1] = m.get(i).getnombrep();
            dato[2] = m.get(i).getdireccionp();
            dato[3] = m.get(i).gettelefonop();
            dato[4] = m.get(i).getnitp();
            dato[5] = m.get(i).getestadop();

            modelo.addRow(dato);
        }
    }

    public void buscarCliente() {
        clsProveedor cAConsultar = new clsProveedor();
        daoProveedor cDAO = new daoProveedor();
        cAConsultar.setidp(Integer.parseInt(txtbuscado.getText()));
        cAConsultar = cDAO.query(cAConsultar);
        txtNombre.setText(cAConsultar.getnombrep());
        txtDireccion.setText(cAConsultar.getdireccionp());
        txtTelefono.setText(cAConsultar.gettelefonop());
        txtNit.setText(cAConsultar.getnitp());
        cbox_estado.setSelectedItem(cAConsultar.getestadop());
    }

    public frmMantenimientoProveedores() {
        initComponents();
        llenadoDeTablas();
        estados();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lb2 = new javax.swing.JLabel();
        lbusu = new javax.swing.JLabel();
        btnEliminar = new javax.swing.JButton();
        btnRegistrar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        label1 = new javax.swing.JLabel();
        btnModificar = new javax.swing.JButton();
        label3 = new javax.swing.JLabel();
        txtbuscado = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaVendedores = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        label6 = new javax.swing.JLabel();
        btnLimpiar = new javax.swing.JButton();
        cbox_estado = new javax.swing.JComboBox<>();
        label4 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        label5 = new javax.swing.JLabel();
        txtNit = new javax.swing.JTextField();
        label7 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();

        lb2.setForeground(new java.awt.Color(204, 204, 204));
        lb2.setText(".");

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Mantenimiento Clientes");
        setVisible(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        getContentPane().add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, 90, -1));

        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        getContentPane().add(btnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 360, 95, -1));

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        getContentPane().add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 410, 95, -1));

        label1.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label1.setText("datos");
        getContentPane().add(label1, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 0, -1, -1));

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        getContentPane().add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 360, 95, -1));

        label3.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label3.setText("Nombre");
        getContentPane().add(label3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 65, -1, -1));
        getContentPane().add(txtbuscado, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 410, 102, -1));

        txtNombre.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtNombre.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        txtNombre.setOpaque(false);
        getContentPane().add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, 150, -1));

        tablaVendedores.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        tablaVendedores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "codigo ", "nombre", "direccion", "telefono", "nit", "estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaVendedores);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(384, 30, 640, 303));

        jButton1.setText("jButton1");
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(469, 34, -1, -1));

        jButton2.setText("Ayuda");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 380, -1, -1));

        label6.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label6.setText("estado");
        getContentPane().add(label6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, -1, 20));

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });
        getContentPane().add(btnLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 410, 90, -1));

        cbox_estado.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        cbox_estado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbox_estadoActionPerformed(evt);
            }
        });
        getContentPane().add(cbox_estado, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 230, 150, 20));

        label4.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label4.setText("Direccion");
        getContentPane().add(label4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, -1));

        txtDireccion.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtDireccion.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        txtDireccion.setOpaque(false);
        getContentPane().add(txtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 110, 150, -1));

        label5.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label5.setText("Nit");
        getContentPane().add(label5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, -1, -1));

        txtNit.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtNit.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        txtNit.setOpaque(false);
        getContentPane().add(txtNit, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 190, 150, -1));

        label7.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label7.setText("telefono");
        getContentPane().add(label7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, -1, -1));

        txtTelefono.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtTelefono.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        txtTelefono.setOpaque(false);
        getContentPane().add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 150, 150, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        
        daoProveedor eDAO = new daoProveedor();
        clsProveedor eAEliminar = new clsProveedor();
        eAEliminar.setidp(Integer.parseInt(txtbuscado.getText()));
        eDAO.delete(eAEliminar);
        llenadoDeTablas();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        daoProveedor eDAO = new daoProveedor();
        clsProveedor eAInsertar = new clsProveedor();
        eAInsertar.setnombrep(txtNombre.getText());
        eAInsertar.setdireccionp(txtDireccion.getText());
        eAInsertar.settelefonop(txtTelefono.getText());
        eAInsertar.setnitp(txtNit.getText());
        eAInsertar.setestadop(cbox_estado.getSelectedItem().toString());
       
        eDAO.insert(eAInsertar);
        llenadoDeTablas();
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
        buscarCliente();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
//        // TODO add your handling code here:
        daoProveedor eDAO = new daoProveedor();
        clsProveedor eAActualizar = new clsProveedor();
        eAActualizar.setidp(Integer.parseInt(txtbuscado.getText()));
        eAActualizar.setnombrep(txtNombre.getText());
        eAActualizar.setdireccionp(txtDireccion.getText());
        eAActualizar.settelefonop(txtTelefono.getText());
        eAActualizar.setnitp(txtNit.getText());
        eAActualizar.setestadop(cbox_estado.getSelectedItem().toString());
        eDAO.update(eAActualizar);
        llenadoDeTablas();
    }//GEN-LAST:event_btnModificarActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        try {
            if ((new File("src\\main\\java\\ayudas\\ProcesoMayor.chm")).exists()) {
                Process p = Runtime
                        .getRuntime()
                        .exec("rundll32 url.dll,FileProtocolHandler src\\main\\java\\ayudas\\ProcesoMayor.chm");
                p.waitFor();
            } else {
                System.out.println("La ayuda no Fue encontrada");
            }
            System.out.println("Correcto");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed


        txtNombre.setText("");
        txtDireccion.setText("");
        txtNit.setText("");
        txtTelefono.setText("");
        
        cbox_estado.setSelectedIndex(0);
        txtbuscado.setText("");
        btnRegistrar.setEnabled(true);
        btnModificar.setEnabled(true);
        btnEliminar.setEnabled(true);

        // TODO add your handling code here:
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void cbox_estadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbox_estadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbox_estadoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JComboBox<String> cbox_estado;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label1;
    private javax.swing.JLabel label3;
    private javax.swing.JLabel label4;
    private javax.swing.JLabel label5;
    private javax.swing.JLabel label6;
    private javax.swing.JLabel label7;
    private javax.swing.JLabel lb2;
    private javax.swing.JLabel lbusu;
    private javax.swing.JTable tablaVendedores;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtNit;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JTextField txtbuscado;
    // End of variables declaration//GEN-END:variables
}
