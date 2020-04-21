/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basico;

/**
 *
 * @author Alex
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

        pikachu = new javax.swing.JLabel();
        charizard = new javax.swing.JLabel();
        bluchar = new javax.swing.JButton();
        eGanador = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pikachu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Pikachu_GO.png"))); // NOI18N

        charizard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Charizard_GO.png"))); // NOI18N

        bluchar.setText("LUCHAR");
        bluchar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                blucharMouseClicked(evt);
            }
        });
        bluchar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                blucharActionPerformed(evt);
            }
        });

        eGanador.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        eGanador.setText("GANADOR");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(pikachu)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 117, Short.MAX_VALUE)
                .addComponent(charizard)
                .addGap(48, 48, 48))
            .addGroup(layout.createSequentialGroup()
                .addGap(156, 156, 156)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(eGanador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(bluchar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(bluchar)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pikachu)
                    .addComponent(charizard))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(eGanador)
                .addGap(35, 35, 35))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void blucharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_blucharActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_blucharActionPerformed

    private void blucharMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_blucharMouseClicked
        //Esto es lo que se va a ejecutar cuando el usuario haga click en el boton de luchar
        //Declaracion variables
        int turno,pVida,pAtaque,cVida,cAtaque;
        //Inicializacion de variables
        turno = 1;
        pVida = 20;
        pAtaque = 5;
        cVida = 20;
        cAtaque = 6;
        
        
        //Comienza el juego
        
        while(cVida>0 && pVida>0){
            if(turno==1){
                cVida=cVida-pAtaque;
                turno=2;
            } else {
                pVida=pVida-cAtaque;
                turno=1;
            }
        } //FIN WHILE
        if(cVida>0){
            eGanador.setText("GANADOR CHARIZARD!!");
        }else{eGanador.setText("GANADOR PIKACHU");}
        
        
        
    }//GEN-LAST:event_blucharMouseClicked

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
    private javax.swing.JButton bluchar;
    private javax.swing.JLabel charizard;
    private javax.swing.JLabel eGanador;
    private javax.swing.JLabel pikachu;
    // End of variables declaration//GEN-END:variables
}