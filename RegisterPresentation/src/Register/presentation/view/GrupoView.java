/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Register.presentation.view;

import Register.presentation.controller.GrupoController;
import Register.presentation.model.GrupoModel;

/**
 *
 * @author Fabio
 */
public class GrupoView extends javax.swing.JDialog implements java.util.Observer{
    GrupoController controller;
    GrupoModel model;
    /**
     * Creates new form GrupoView
     */
    public GrupoView(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    
    public void setController(GrupoController controller){
        this.controller=controller;
    }
    public void setModel(GrupoModel model){
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

        numeroLabel = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        horarioLabel = new javax.swing.JLabel();
        profeLabel = new javax.swing.JLabel();
        profesorFld = new javax.swing.JTextField();
        guardarBtn = new javax.swing.JButton();
        cancelarBtn = new javax.swing.JButton();
        diaFld1 = new javax.swing.JComboBox<>();
        diaFld2 = new javax.swing.JComboBox<>();
        inicioFld = new javax.swing.JComboBox<>();
        inicioLabel = new javax.swing.JLabel();
        finLabel = new javax.swing.JLabel();
        finFld = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        numeroLabel.setText("Numero:");

        jTextField1.setColumns(5);

        horarioLabel.setText("Dias:");

        profeLabel.setText("Profesor:");
        profeLabel.setName(""); // NOI18N

        profesorFld.setColumns(17);
        profesorFld.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profesorFldActionPerformed(evt);
            }
        });

        guardarBtn.setText("Guardar");

        cancelarBtn.setText("Cancelar");
        cancelarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarBtnActionPerformed(evt);
            }
        });

        diaFld1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-----", "Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado" }));

        diaFld2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-----", "Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado" }));

        inicioFld.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "07:00", "08:00", "09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00" }));

        inicioLabel.setText("Hora Inicio:");

        finLabel.setText("Hora Fin:");

        finFld.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "07:00", "08:00", "09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(finLabel)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(finFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(inicioLabel)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(inicioFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(numeroLabel)
                            .addComponent(horarioLabel))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(diaFld1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(diaFld2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(profeLabel)
                        .addGap(26, 26, 26)
                        .addComponent(profesorFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(58, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(guardarBtn)
                .addGap(18, 18, 18)
                .addComponent(cancelarBtn)
                .addGap(73, 73, 73))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numeroLabel)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(horarioLabel)
                    .addComponent(diaFld1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(diaFld2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inicioLabel)
                    .addComponent(inicioFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(finLabel)
                    .addComponent(finFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(profeLabel)
                    .addComponent(profesorFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(guardarBtn)
                    .addComponent(cancelarBtn))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void profesorFldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profesorFldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_profesorFldActionPerformed

    private void cancelarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cancelarBtnActionPerformed

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
            java.util.logging.Logger.getLogger(GrupoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GrupoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GrupoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GrupoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                GrupoView dialog = new GrupoView(new javax.swing.JFrame(), true);
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
    private javax.swing.JComboBox<String> diaFld1;
    private javax.swing.JComboBox<String> diaFld2;
    private javax.swing.JComboBox<String> finFld;
    private javax.swing.JLabel finLabel;
    private javax.swing.JButton guardarBtn;
    private javax.swing.JLabel horarioLabel;
    private javax.swing.JComboBox<String> inicioFld;
    private javax.swing.JLabel inicioLabel;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel numeroLabel;
    private javax.swing.JLabel profeLabel;
    private javax.swing.JTextField profesorFld;
    // End of variables declaration//GEN-END:variables
}
