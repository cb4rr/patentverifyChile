package Interfaz;

import DigitoVerificador.Metodos;

import javax.swing.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pipe
 */
public class DigitoPatenteFrame extends javax.swing.JFrame {

    /**
     * Creates new form DigitoPatenteFrame
     */
    public DigitoPatenteFrame() {
        initComponents();
        setTitle("Digito verificador de Patente");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void initComponents() {

        JLabel jLabel1 = new JLabel();
        JLabel jLabel2 = new JLabel();
        JLabel jLabel3 = new JLabel();
        JSeparator jSeparator1 = new JSeparator();
        // Variables declaration - do not modify//GEN-BEGIN:variables
        JButton jButton1 = new JButton();
        JButton jButton2 = new JButton();
        JLabel jLabel4 = new JLabel();
        txtPatenteValue = new javax.swing.JTextField();
        txtTipoPatente = new javax.swing.JTextField();
        txtDigitoVerificador = new javax.swing.JTextField();
        txtResultadoPatente = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Patente:");

        jLabel2.setText("Tipo de Patente:");

        jLabel3.setText("Digito Verificador:");

        jButton1.setText("Limpiar");
        jButton1.addActionListener(this::jButton1ActionPerformed);

        jButton2.setText("Calcular");
        jButton2.addActionListener(this::jButton2ActionPerformed);

        jLabel4.setText("Resultado:");

        txtTipoPatente.setEnabled(false);
        txtTipoPatente.addActionListener(this::txtTipoPatenteActionPerformed);

        txtDigitoVerificador.setEnabled(false);

        txtResultadoPatente.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(98, 98, 98)
                                .addComponent(txtPatenteValue, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addGap(48, 48, 48)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jButton1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton2))
                                    .addComponent(txtTipoPatente)
                                    .addComponent(txtDigitoVerificador)
                                    .addComponent(txtResultadoPatente))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtPatenteValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtTipoPatente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtDigitoVerificador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(txtResultadoPatente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(81, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
        String DVInterfaz;
        
        DVInterfaz = txtPatenteValue.getText();
        txtDigitoVerificador.setText("");
        txtTipoPatente.setText("");
        txtResultadoPatente.setText("");

        
        try {
            Metodos.getPatente(DVInterfaz);
        } catch (IOException ex) {
            Logger.getLogger(DigitoPatenteFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        txtDigitoVerificador.setText(Metodos.DVFinal);
        txtTipoPatente.setText(Metodos.tipoVehiculo);
        txtResultadoPatente.setText(Metodos.PatenteFinal);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        txtDigitoVerificador.setText("");
        txtTipoPatente.setText("");
        txtResultadoPatente.setText("");
        txtPatenteValue.setText("");
        Metodos.DVFinal = "";
        Metodos.tipoVehiculo = "";
        Metodos.PatenteFinal = "";
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtTipoPatenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTipoPatenteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTipoPatenteActionPerformed

    /**
     */
    public static void iniciar() {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException |
                 UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DigitoPatenteFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new DigitoPatenteFrame().setVisible(true));
    }

    private javax.swing.JTextField txtDigitoVerificador;
    private javax.swing.JTextField txtPatenteValue;
    private javax.swing.JTextField txtResultadoPatente;
    private javax.swing.JTextField txtTipoPatente;
    // End of variables declaration//GEN-END:variables
}
