/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agendatelefonicaconbdinterface;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nocturno
 */
public class IGAgendaBDD extends javax.swing.JFrame {
    private AgendaTelefonica agenda;
    /**
     * Creates new form IGAgendaBDD
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
     */
    public IGAgendaBDD() throws SQLException, ClassNotFoundException {
        
        agenda = new AgendaTelefonica("agendaTel","agenda");
        
        initComponents();
        this.setLocationRelativeTo(null);
        listadoJTextArea.setText(agenda.listado());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nombreJTextField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        telefonoJTextField2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        borrarJButton = new javax.swing.JButton();
        buscarJButton = new javax.swing.JButton();
        agregarjButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listadoJTextArea = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                formFocusGained(evt);
            }
        });
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        nombreJTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreJTextFieldActionPerformed(evt);
            }
        });

        jLabel1.setText("Nombre");

        jLabel2.setText("Tel??fono");

        telefonoJTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                telefonoJTextField2ActionPerformed(evt);
            }
        });

        jLabel3.setText("Listado Agenda");

        borrarJButton.setText("Borrar");
        borrarJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                borrarJButtonActionPerformed(evt);
            }
        });

        buscarJButton.setText("Buscar");
        buscarJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarJButtonActionPerformed(evt);
            }
        });

        agregarjButton1.setText("Agregar Nuevo Contacto");
        agregarjButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarjButton1ActionPerformed(evt);
            }
        });

        listadoJTextArea.setEditable(false);
        listadoJTextArea.setColumns(20);
        listadoJTextArea.setRows(5);
        listadoJTextArea.setMargin(new java.awt.Insets(5, 5, 2, 2));
        jScrollPane1.setViewportView(listadoJTextArea);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel4.setText("Agenda Telef??inica");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1)
                                .addComponent(jLabel2))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(nombreJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(telefonoJTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(buscarJButton)
                            .addGap(18, 18, 18)
                            .addComponent(borrarJButton)))
                    .addComponent(agregarjButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36))
            .addGroup(layout.createSequentialGroup()
                .addGap(140, 140, 140)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nombreJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(telefonoJTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(borrarJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buscarJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(68, 68, 68)
                        .addComponent(agregarjButton1))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nombreJTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreJTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombreJTextFieldActionPerformed

    private void telefonoJTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_telefonoJTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_telefonoJTextField2ActionPerformed

    private void borrarJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_borrarJButtonActionPerformed
        // TODO add your handling code here:
        nombreJTextField.setText("");
        telefonoJTextField2.setText("");
        
    }//GEN-LAST:event_borrarJButtonActionPerformed

    private void buscarJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarJButtonActionPerformed
        Contacto contacto = null;
        boolean esNombreValido = true, esTelefonoValido = true;
        
        if (nombreJTextField.getText().length() == 0 && telefonoJTextField2.getText().length() == 0) {
            javax.swing.JOptionPane.showMessageDialog(rootPane, "Error. No ha introducido ning??n valor a buscar");
        }else if (nombreJTextField.getText().length() != 0 && telefonoJTextField2.getText().length() != 0) {
            javax.swing.JOptionPane.showMessageDialog(rootPane, "Error. No se puede buscar por ambos datos a la vez, "
                    + "borre o bien el nombre o bien el telefono");
        }else if (nombreJTextField.getText().length() != 0) {
            
            for (int i = 0; i < nombreJTextField.getText().length(); i++) {
                if(!FuncionesSobreCaracteres.esCaracterAlfabetico(nombreJTextField.getText().charAt(i))){
                    esNombreValido=false;
                }                
            }
            if (esNombreValido) {
                try {
                contacto = agenda.buscarPorNombre(nombreJTextField.getText().toLowerCase());
            } catch (SQLException ex) {
                Logger.getLogger(IGAgendaBDD.class.getName()).log(Level.SEVERE, null, ex);
            }
            javax.swing.JOptionPane.showMessageDialog(rootPane, "Contacto encontrado: \n" + contacto);
            
            }else{
                javax.swing.JOptionPane.showMessageDialog(rootPane, "Error ha usado car??cteres no v??lidos en el campo NOMBRE");
            }
            
        }else if (telefonoJTextField2.getText().length() != 9 ) {
            javax.swing.JOptionPane.showMessageDialog(rootPane, "Error, el te??fono ha de formarse por 9 d??gitos. Ni m??s, ni menos");
        
        }else if (telefonoJTextField2.getText().length() != 0) {
            
            for (int i = 0; i < telefonoJTextField2.getText().length(); i++) {
                if(!FuncionesSobreCaracteres.esNumeroValido(telefonoJTextField2.getText().charAt(i))){
                    esTelefonoValido=false;
                }                
            }
            if (esTelefonoValido) {
                try {
                contacto = agenda.buscarPorTelefono(telefonoJTextField2.getText().toLowerCase());
            } catch (SQLException ex) {
                Logger.getLogger(IGAgendaBDD.class.getName()).log(Level.SEVERE, null, ex);
            }
            javax.swing.JOptionPane.showMessageDialog(rootPane, "Contacto encontrado: \n" + contacto);
            
            }else{
                javax.swing.JOptionPane.showMessageDialog(rootPane, "Error ha usado car??cteres no v??lidos en el campo TEL??FONO");
            }
        }
    }//GEN-LAST:event_buscarJButtonActionPerformed

        
    private void agregarjButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarjButton1ActionPerformed
        // TODO add your handling code here:
        NuevoContactoJDialog agregarContacto= null;
        try {
            agregarContacto = new NuevoContactoJDialog(this, rootPaneCheckingEnabled);
        } catch (SQLException ex) {
            Logger.getLogger(IGAgendaBDD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(IGAgendaBDD.class.getName()).log(Level.SEVERE, null, ex);
        }
        agregarContacto.setVisible(true);
        
        
    }//GEN-LAST:event_agregarjButton1ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        
        try {
            agenda.cerrar();
        } catch (SQLException ex) {
            Logger.getLogger(IGAgendaBDD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_formWindowClosing

    private void formFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusGained
       
    }//GEN-LAST:event_formFocusGained

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        try {
            // TODO add your handling code here:
            listadoJTextArea.setText(agenda.listado());
        } catch (SQLException ex) {
            Logger.getLogger(IGAgendaBDD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formWindowGainedFocus

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
            java.util.logging.Logger.getLogger(IGAgendaBDD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IGAgendaBDD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IGAgendaBDD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IGAgendaBDD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new IGAgendaBDD().setVisible(true);
                } catch (SQLException | ClassNotFoundException ex) {
                    Logger.getLogger(IGAgendaBDD.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregarjButton1;
    private javax.swing.JButton borrarJButton;
    private javax.swing.JButton buscarJButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea listadoJTextArea;
    private javax.swing.JTextField nombreJTextField;
    private javax.swing.JTextField telefonoJTextField2;
    // End of variables declaration//GEN-END:variables
}
