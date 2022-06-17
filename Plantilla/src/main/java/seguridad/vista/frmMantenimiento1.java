/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seguridad.vista;


import seguridad.modelo.daoMantenimiento1;
import seguridad.controlador.clsMantenimiento1;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import java.io.File;

/**
 *
 * @author visitante
 */
public class frmMantenimiento1 extends javax.swing.JInternalFrame {


    public void estados() {    
        cbox_estado.addItem("seleccione: "); 
        cbox_estado.addItem("activo");
        cbox_estado.addItem("inactivo");
    }
 
    

    public void llenadoDeTablas() {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("codigo");
        modelo.addColumn("nombre");
        modelo.addColumn("estado");
        daoMantenimiento1 mDAO = new daoMantenimiento1();
        List<clsMantenimiento1> m = mDAO.select();
        tablaVendedores.setModel(modelo);
        String[] dato = new String[10];
        for (int i = 0; i < m.size(); i++) {
            dato[0] = Integer.toString(m.get(i).getid1());
            dato[1] = m.get(i).getnombre1();
            dato[2] = m.get(i).getestado1();

            modelo.addRow(dato);
        }
    }

    public void buscarCursos() {
        clsMantenimiento1 cAConsultar = new clsMantenimiento1();
        daoMantenimiento1 cDAO = new daoMantenimiento1();
        cAConsultar.setid1(Integer.parseInt(txtbuscado.getText()));
        cAConsultar = cDAO.query(cAConsultar);
        txtNombre.setText(cAConsultar.getnombre1());
        cbox_estado.setSelectedItem(cAConsultar.getestado1());
    }

    public frmMantenimiento1() {
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

        lb2.setForeground(new java.awt.Color(204, 204, 204));
        lb2.setText(".");

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Mantenimiento 1");
        setVisible(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        getContentPane().add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 95, -1));

        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        getContentPane().add(btnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(142, 259, 95, -1));

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        getContentPane().add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(142, 300, 95, -1));

        label1.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label1.setText("datos");
        getContentPane().add(label1, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 0, -1, -1));

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        getContentPane().add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(255, 259, 95, -1));

        label3.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label3.setText("Nombre");
        getContentPane().add(label3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 65, -1, -1));
        getContentPane().add(txtbuscado, new org.netbeans.lib.awtextra.AbsoluteConstraints(247, 301, 102, -1));

        txtNombre.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtNombre.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        txtNombre.setOpaque(false);
        getContentPane().add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, 150, -1));

        tablaVendedores.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        tablaVendedores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "codigo ", "nombre", "estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaVendedores);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(448, 20, 574, 303));

        jButton1.setText("jButton1");
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(469, 34, -1, -1));

        jButton2.setText("Ayuda");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 330, -1, -1));

        label6.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label6.setText("estado");
        getContentPane().add(label6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, 20));

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });
        getContentPane().add(btnLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 90, -1));

        cbox_estado.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        cbox_estado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbox_estadoActionPerformed(evt);
            }
        });
        getContentPane().add(cbox_estado, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 110, 150, 20));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        
        daoMantenimiento1 eDAO = new daoMantenimiento1();
        clsMantenimiento1 eAEliminar = new clsMantenimiento1();
        eAEliminar.setid1(Integer.parseInt(txtbuscado.getText()));
        eDAO.delete(eAEliminar);
        llenadoDeTablas();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        daoMantenimiento1 eDAO = new daoMantenimiento1();
        clsMantenimiento1 eAInsertar = new clsMantenimiento1();
        eAInsertar.setnombre1(txtNombre.getText());
        eAInsertar.setestado1(cbox_estado.getSelectedItem().toString());
       
        eDAO.insert(eAInsertar);
        llenadoDeTablas();
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
        buscarCursos();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
//        // TODO add your handling code here:
        daoMantenimiento1 eDAO = new daoMantenimiento1();
        clsMantenimiento1 eAActualizar = new clsMantenimiento1();
        eAActualizar.setid1(Integer.parseInt(txtbuscado.getText()));
        eAActualizar.setnombre1(txtNombre.getText());
        eAActualizar.setestado1(cbox_estado.getSelectedItem().toString());
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
    private javax.swing.JLabel label6;
    private javax.swing.JLabel lb2;
    private javax.swing.JLabel lbusu;
    private javax.swing.JTable tablaVendedores;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtbuscado;
    // End of variables declaration//GEN-END:variables
}
