/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import controllers.ClientesJpaController;
import entities.Clientes;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author alexk
 */
public class ClientesForm extends javax.swing.JFrame {

    private static final EntityManagerFactory EMF = Persistence.createEntityManagerFactory("neptunoJPAPU");
    private static final ClientesJpaController CLIENTES_CONTROLADOR = new ClientesJpaController(EMF);
    private List<Clientes> clientes;
    
    
    
    /**
     * Creates new form ClientesForm
     */
    public ClientesForm() {
        initComponents();
        clientes = CLIENTES_CONTROLADOR.findClientesEntities();
        clientesComboBox.setModel(new DefaultComboBoxModel(clientes.toArray()));
        
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        clientesComboBox = new javax.swing.JComboBox<>();
        nombreContactoTextField = new javax.swing.JTextField();
        telefonoTextField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        clientesComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        clientesComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                clientesComboBoxItemStateChanged(evt);
            }
        });

        nombreContactoTextField.setText("Nombre de Contacto");

        telefonoTextField.setText("Telefono");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(clientesComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nombreContactoTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
                    .addComponent(telefonoTextField))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(clientesComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(nombreContactoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(telefonoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(172, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void clientesComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_clientesComboBoxItemStateChanged
        
       Clientes cienteSeleccionado = clientes.get(clientesComboBox.getSelectedIndex());
       nombreContactoTextField.setText(cienteSeleccionado.getNombreContacto());
       telefonoTextField.setText(cienteSeleccionado.getTelefono());
        
    }//GEN-LAST:event_clientesComboBoxItemStateChanged

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> clientesComboBox;
    private javax.swing.JTextField nombreContactoTextField;
    private javax.swing.JTextField telefonoTextField;
    // End of variables declaration//GEN-END:variables
}