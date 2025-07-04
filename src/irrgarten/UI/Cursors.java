/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package irrgarten.UI;
import irrgarten.Directions;

/**
 *
 * @author usuario
 */
public class Cursors extends javax.swing.JDialog {
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Cursors.class.getName());
    private Directions seleccionada;

    /**
     * Creates new form Cursors
     */
    public Cursors(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    
    public Directions getDirection() {
        setVisible(true);
        return seleccionada;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Izquierda = new javax.swing.JButton();
        Derecha = new javax.swing.JButton();
        Abajo = new javax.swing.JButton();
        Arriba = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        Izquierda.setText("IZQUIERDA");
        Izquierda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IzquierdaActionPerformed(evt);
            }
        });

        Derecha.setText("DERECHA");
        Derecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DerechaActionPerformed(evt);
            }
        });

        Abajo.setText("ABAJO");
        Abajo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AbajoActionPerformed(evt);
            }
        });

        Arriba.setText("ARRIBA");
        Arriba.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ArribaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(Izquierda, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 101, Short.MAX_VALUE)
                .addComponent(Derecha, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
            .addGroup(layout.createSequentialGroup()
                .addGap(122, 122, 122)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Arriba, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Abajo, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(Arriba)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Derecha)
                    .addComponent(Izquierda))
                .addGap(48, 48, 48)
                .addComponent(Abajo)
                .addGap(38, 38, 38))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void IzquierdaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IzquierdaActionPerformed
        this.seleccionada = Directions.LEFT;
        this.dispose();
    }//GEN-LAST:event_IzquierdaActionPerformed

    private void ArribaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ArribaActionPerformed
        this.seleccionada = Directions.UP;
        this.dispose();
    }//GEN-LAST:event_ArribaActionPerformed

    private void DerechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DerechaActionPerformed
        this.seleccionada = Directions.RIGHT;
        this.dispose();
    }//GEN-LAST:event_DerechaActionPerformed

    private void AbajoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AbajoActionPerformed
        this.seleccionada = Directions.DOWN;
        this.dispose();
    }//GEN-LAST:event_AbajoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Abajo;
    private javax.swing.JButton Arriba;
    private javax.swing.JButton Derecha;
    private javax.swing.JButton Izquierda;
    // End of variables declaration//GEN-END:variables
}
