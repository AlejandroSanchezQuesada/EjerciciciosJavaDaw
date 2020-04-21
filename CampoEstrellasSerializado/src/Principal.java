
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Timer;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Profesor
 */
public class Principal extends javax.swing.JFrame {

    ArrayList<Estrella> listaEstrellas;

    static int ancho;
    static int alto;
    Graphics g;
    
    public Principal() {
        initComponents();
        g=panel.getGraphics();
        listaEstrellas=new ArrayList();
                  //  leerEstrellasDeFichero();
                    Timer timer = new Timer (100, new ActionListener ()
                    {
                        public void actionPerformed(ActionEvent e){
                           repaint();                           
                        }                                                
                    });
                    timer.start();
                      
    }

    public void paint(Graphics g){
        super.paint(g);
         ancho=panel.getWidth();
                            alto=panel.getHeight();

 
                            g.clearRect(0, 0, ancho, alto);
                            for (Estrella es:listaEstrellas){
                                es.mover();                  
                                g.setColor(es.getColor());
                                g.fillOval(es.getX(), es.getY(), es.getRadio(), es.getRadio());
                            }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        menosVelocidad = new javax.swing.JButton();
        masVelocidad = new javax.swing.JButton();
        masEstrellas = new javax.swing.JButton();
        menosEstrellas = new javax.swing.JButton();
        guardar = new javax.swing.JButton();
        BAbrir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Campo de Estrellas");

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 322, Short.MAX_VALUE)
        );

        menosVelocidad.setText("- Velocidad");
        menosVelocidad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menosVelocidadMouseClicked(evt);
            }
        });

        masVelocidad.setText("+ Velocidad");
        masVelocidad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                masVelocidadMouseClicked(evt);
            }
        });

        masEstrellas.setText("+ Estrellas");
        masEstrellas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                masEstrellasMouseClicked(evt);
            }
        });
        masEstrellas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                masEstrellasActionPerformed(evt);
            }
        });

        menosEstrellas.setText("- Estrellas");
        menosEstrellas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menosEstrellasMouseClicked(evt);
            }
        });

        guardar.setText("Guardar");
        guardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                guardarMouseClicked(evt);
            }
        });
        guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarActionPerformed(evt);
            }
        });

        BAbrir.setText("Abrir");
        BAbrir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BAbrirMouseClicked(evt);
            }
        });
        BAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BAbrirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(masVelocidad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(menosVelocidad, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(menosEstrellas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(masEstrellas, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 175, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(guardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BAbrir, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(150, 150, 150))
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(masEstrellas)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(menosEstrellas))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(BAbrir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(guardar))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(masVelocidad)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(menosVelocidad))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menosVelocidadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menosVelocidadMouseClicked
        // TODO add your handling code here:
        for (Estrella es:listaEstrellas)
        es.menosVelocidad();
    }//GEN-LAST:event_menosVelocidadMouseClicked

    private void masVelocidadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_masVelocidadMouseClicked
        // TODO add your handling code here:
        for (Estrella es:listaEstrellas)
        es.masVelocidad();
    }//GEN-LAST:event_masVelocidadMouseClicked

    private void masEstrellasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_masEstrellasMouseClicked
        // TODO add your handling code here:
        Estrella e=new Estrella();
        listaEstrellas.add(e);
    }//GEN-LAST:event_masEstrellasMouseClicked

    private void menosEstrellasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menosEstrellasMouseClicked
        // TODO add your handling code here:
        if (listaEstrellas.size()>0)
        listaEstrellas.remove(0);
    }//GEN-LAST:event_menosEstrellasMouseClicked

    private void guardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_guardarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_guardarMouseClicked

    private void BAbrirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BAbrirMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_BAbrirMouseClicked

    private void BAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BAbrirActionPerformed
        
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        
        try {
            fis = new FileInputStream("Estrellas.dat");
            ois = new ObjectInputStream(fis);
            
            listaEstrellas = (ArrayList) ois.readObject();
            
           
            
            
            
        }  catch (IOException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                if (ois !=null) {
                    ois.close();
                }
            } catch (Exception e) {
            }
        
        
        }
        
        
        
        
        
        
    }//GEN-LAST:event_BAbrirActionPerformed

    private void guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarActionPerformed
        
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        
        try {
            fos = new FileOutputStream(new File("Estrellas.dat"));
            oos = new ObjectOutputStream(fos);
            
            oos.writeObject(listaEstrellas);
            
            
            
            
            
        }  catch (IOException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        
        
        
        
        
    }//GEN-LAST:event_guardarActionPerformed

    private void masEstrellasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_masEstrellasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_masEstrellasActionPerformed

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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BAbrir;
    private javax.swing.JButton guardar;
    private javax.swing.JButton masEstrellas;
    private javax.swing.JButton masVelocidad;
    private javax.swing.JButton menosEstrellas;
    private javax.swing.JButton menosVelocidad;
    private javax.swing.JPanel panel;
    // End of variables declaration//GEN-END:variables
}
