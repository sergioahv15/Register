/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Register.presentation.view;

import Register.presentation.controller.ProfesorController;
import Register.presentation.model.ProfesorModel;

/**
 *
 * @author Fabio
 */
public class ProfesorView extends javax.swing.JDialog implements java.util.Observer{
    ProfesorController controller;
    ProfesorModel model;
    /**
     * Creates new form ProfesorView
     */
    public ProfesorView(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    
    public void setController(ProfesorController controller){
        this.controller=controller;
    }
    public void setModel(ProfesorModel model){
        this.model=model;
         model.addObserver(this);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nombreLabel = new javax.swing.JLabel();
        nombreFld = new javax.swing.JTextField();
        cedulaFld = new javax.swing.JTextField();
        cedulaLabel = new javax.swing.JLabel();
        telefonoFld = new javax.swing.JTextField();
        telefonoLabel = new javax.swing.JLabel();
        emailLabel = new javax.swing.JLabel();
        emailFld = new javax.swing.JTextField();
        guardarBtn = new javax.swing.JButton();
        cancelarBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        nombreLabel.setText("Nombre:");

        nombreFld.setColumns(20);
        nombreFld.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreFldActionPerformed(evt);
            }
        });

        cedulaFld.setColumns(20);
        cedulaFld.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cedulaFldActionPerformed(evt);
            }
        });

        cedulaLabel.setText("Cedula:");

        telefonoFld.setColumns(20);

        telefonoLabel.setText("Telefono:");

        emailLabel.setText("Email:");

        emailFld.setColumns(20);
        emailFld.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailFldActionPerformed(evt);
            }
        });

        guardarBtn.setText("Guardar");
        guardarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarBtnActionPerformed(evt);
            }
        });

        cancelarBtn.setText("Cancelar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(nombreLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(nombreFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(cedulaLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cedulaFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(telefonoLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(telefonoFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(emailLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(guardarBtn)
                                .addGap(18, 18, 18)
                                .addComponent(cancelarBtn))
                            .addComponent(emailFld, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(73, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombreLabel)
                    .addComponent(nombreFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cedulaLabel)
                    .addComponent(cedulaFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(telefonoLabel)
                    .addComponent(telefonoFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emailLabel)
                    .addComponent(emailFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(guardarBtn)
                    .addComponent(cancelarBtn))
                .addContainerGap(43, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nombreFldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreFldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombreFldActionPerformed

    private void cedulaFldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cedulaFldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cedulaFldActionPerformed

    private void guardarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_guardarBtnActionPerformed

    private void emailFldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailFldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailFldActionPerformed

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
            java.util.logging.Logger.getLogger(ProfesorView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProfesorView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProfesorView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProfesorView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ProfesorView dialog = new ProfesorView(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    public void update(java.util.Observable updatedModel,Object parametros){
       
        /*if (parametros != PersonaModel.PERSONA_CURRENT) return;
       
       Persona personaCurrent = model.getPersonaCurrent();
        
       this.idFld.setEnabled(model.getModo()==Application.MODO_AGREGAR);
       
       idFld.setText(personaCurrent.getId());
       if (model.getErrores().get("id")!=null){
            idLbl.setBorder(Application.BORDER_ERROR);
            idLbl.setToolTipText(model.getErrores().get("id"));
        }
        else{
            idLbl.setBorder(null);
            idLbl.setToolTipText("");
        }

        nombreFld.setText(personaCurrent.getNombre());
        if (model.getErrores().get("nombre")!=null){
            nombreLbl.setBorder(Application.BORDER_ERROR);
            nombreLbl.setToolTipText(model.getErrores().get("nombre"));
        }
        else{
           nombreLbl.setBorder(null);
           nombreLbl.setToolTipText("");
        }

        if (personaCurrent.getSexo()=='F'){
            sexoFldFem.setSelected(true);
        }
        else if(personaCurrent.getSexo()=='M'){
            sexoFldMasc.setSelected(true);  
        }
        else{
            this.sexoFld.clearSelection();
        }
        if (model.getErrores().get("sexo")!=null){
            sexoLbl.setBorder(Application.BORDER_ERROR);
            sexoLbl.setToolTipText(model.getErrores().get("sexo"));
        }
        else{
           sexoLbl.setBorder(null);
           sexoLbl.setToolTipText("");
         }
        estadoFld.setModel(model.getEstadosCiviles());
        estadoFld.setSelectedItem(personaCurrent.getEstadoCivil());
        pasatiempoFldMusica.setSelected(personaCurrent.isPasatiempoMusica());
        pasatiempoFldCine.setSelected(personaCurrent.isPasatiempoCine());
        pasatiempoFldDeporte.setSelected(personaCurrent.isPasatiempoDeporte());
        pasatiempoFldVideoJuegos.setSelected(personaCurrent.isPasatiempoVideoJuegos());
        pasatiempoFldCocina.setSelected(personaCurrent.isPasatiempoCocina());
        pasatiempoFldOtro.setSelected(personaCurrent.isPasatiempoOtro());
        if (personaCurrent.isPasatiempoOtro()){
            pasatiempoFldOtroDescripcion.setVisible(true);
            pasatiempoFldOtroDescripcion.setText(model.getPersonaCurrent().getPasatiempoOtroTexto());
            if (model.getErrores().get("pasatiempoOtroDescripcion")!=null){
                pasatiempoFldOtro.setBorder(Application.BORDER_ERROR);
                pasatiempoFldOtro.setBorderPainted(true); 
                pasatiempoFldOtro.setToolTipText(model.getErrores().get("pasatiempoOtroDescripcion"));
            }
            else{
                pasatiempoFldOtro.setBorder(null);
                pasatiempoFldOtro.setBorderPainted(false); 
                pasatiempoFldOtro.setToolTipText("");
            }
        }
        else{
            pasatiempoFldOtroDescripcion.setVisible(false);
        }
        this.validate();
        if (!model.getMensaje().equals("")){
            JOptionPane.showMessageDialog(this, model.getMensaje(), "",JOptionPane.INFORMATION_MESSAGE);
        }
    */
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelarBtn;
    private javax.swing.JTextField cedulaFld;
    private javax.swing.JLabel cedulaLabel;
    private javax.swing.JTextField emailFld;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JButton guardarBtn;
    private javax.swing.JTextField nombreFld;
    private javax.swing.JLabel nombreLabel;
    private javax.swing.JTextField telefonoFld;
    private javax.swing.JLabel telefonoLabel;
    // End of variables declaration//GEN-END:variables
}
