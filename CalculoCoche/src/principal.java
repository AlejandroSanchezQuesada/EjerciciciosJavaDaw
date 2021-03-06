
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author alexk
 */
public class principal extends javax.swing.JFrame {

    /**
     * Creates new form principal
     */
    public principal() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        cCoches = new javax.swing.JComboBox<>();
        bGasolina = new javax.swing.JRadioButton();
        bDiesel = new javax.swing.JRadioButton();
        bCalcula = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Calcula precio Coche");

        cCoches.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Citroen C4", "Renault Megane", "Seat Ibiza", "Nisan Quasqai" }));

        buttonGroup1.add(bGasolina);
        bGasolina.setText("Gasolina");

        buttonGroup1.add(bDiesel);
        bDiesel.setText("Diesel");

        bCalcula.setText("Calcula Precio");
        bCalcula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCalculaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(137, 137, 137)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bDiesel)
                    .addComponent(bGasolina)
                    .addComponent(cCoches, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(bCalcula))
                .addContainerGap(142, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(cCoches, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(bGasolina)
                .addGap(18, 18, 18)
                .addComponent(bDiesel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(bCalcula)
                .addGap(17, 17, 17))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private int Precio(String modelo) {
        int precio = 0;

        if (modelo.equals("Citroen C4")) {
            precio = 22500;
        } else if (modelo.equals("Renault Megane")) {
            precio = 21600;
        } else if (modelo.equals("Seat Ibiza")) {
            precio = 18900;
        } else if (modelo.equals("Nisan Quasqai")) {
            precio = 21900;
        }

        return precio;
    }

    private void precioFinal(int precio) {

        if (bGasolina.isSelected()) {
            JOptionPane.showMessageDialog(this, "El precio es " + precio + " €");
        } else if (bDiesel.isSelected()) {
            precio = precio + 1000;
            JOptionPane.showMessageDialog(this, "El precio por llevar diesel es " + precio + " €");
        }

    }


    private void bCalculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCalculaActionPerformed

        if (cCoches.getSelectedItem().equals("Citroen C4")) {
            precioFinal(Precio("Citroen C4"));
        } else if (cCoches.getSelectedItem().equals("Renault Megane")) {
            precioFinal(Precio("Renault Megane"));
        } else if (cCoches.getSelectedItem().equals("Seat Ibiza")) {
            precioFinal(Precio("Seat Ibiza"));
        } else if (cCoches.getSelectedItem().equals("Nisan Quasqai")) {
            precioFinal(Precio("Nisan Quasqai"));
        }


    }//GEN-LAST:event_bCalculaActionPerformed

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
            java.util.logging.Logger.getLogger(principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bCalcula;
    private javax.swing.JRadioButton bDiesel;
    private javax.swing.JRadioButton bGasolina;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cCoches;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
