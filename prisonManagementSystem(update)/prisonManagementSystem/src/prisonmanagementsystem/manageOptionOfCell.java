/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prisonmanagementsystem;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author al-sany
 */
public class manageOptionOfCell extends javax.swing.JFrame {

    /**
     * Creates new form manageOptionOfCell
     */
    String cellno;
    int cell;
    String AId;
    DBConnect dbc=new DBConnect();
    ResultSet res;
    int p1;
    int p2;
    
    public manageOptionOfCell() {
        initComponents();
    }
    
    public manageOptionOfCell(String cno,String AId){
        initComponents();
        this.cellno=cno;
        this.cell=Integer.parseInt(cno);
        this.AId=AId;
        jLabel2.setText(cno);        
    }

    public void prisonerID(){
        try {
            CallableStatement cst=dbc.connection().prepareCall("{CALL hr.prisonerOfCell(?,?,?)}");
            cst.registerOutParameter("p1", Types.INTEGER);
            cst.registerOutParameter("p2", Types.INTEGER);
            cst.setInt("cell", cell);
            cst.execute();
            this.p1=cst.getInt("p1");
            this.p2=cst.getInt("p2");
        } catch (SQLException ex) {
            Logger.getLogger(manageOptionOfCell.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
        public boolean checkSuper(String id){
        try {
            CallableStatement cst=dbc.connection().prepareCall("{CALL hr.super(?)}");
            int ID=Integer.parseInt(AId);
            cst.setInt(1,ID);
            cst.execute();
        } catch (SQLException ex) {
            Logger.getLogger(userInfo.class.getName()).log(Level.SEVERE, null, ex);
            return false;  
        }
        return true;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("San Francisco Display", 1, 24)); // NOI18N
        jLabel1.setText("Cell No:");

        jLabel2.setFont(new java.awt.Font("San Francisco Display", 0, 24)); // NOI18N
        jLabel2.setText("jLabel2");

        jButton1.setFont(new java.awt.Font("San Francisco Display", 0, 24)); // NOI18N
        jButton1.setText("MARK FOR RAPAIR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("San Francisco Display", 0, 24)); // NOI18N
        jButton2.setText("MAKE ROOM");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("San Francisco Display", 0, 24)); // NOI18N
        jButton3.setText("FILL IN");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton5.setText("Cancel");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(472, 472, 472)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 339, Short.MAX_VALUE)
                .addComponent(jButton5)
                .addGap(34, 34, 34))
            .addGroup(layout.createSequentialGroup()
                .addGap(125, 125, 125)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(110, 110, 110)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(123, 123, 123)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton5)))
                .addGap(65, 65, 65)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addContainerGap(90, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        prisonerID();
        if(p1==0&&p2==0) 
            JOptionPane.showMessageDialog(rootPane, "The Cell is already empty.");
        else{
            makeRoom mR=new makeRoom(cellno,p1,p2);
            mR.setVisible(true);
        } 
            
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        prisonerID();
        if(p1!=0&&p2!=0){
            JOptionPane.showMessageDialog(rootPane, "The cell is already full.");
        }
        else{
            fillIn fi=new fillIn(cellno);
            fi.setVisible(true);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        boolean chk=checkSuper(AId);
        String nop = null;
        if(chk==true){
            ResultSet res=dbc.getResultSet("select no_of_prisoners from hr.cell where cellno="+cellno);
            try {
                int Nop = 0;
                while(res.next()){
                    nop=res.getString("no_of_prisoners");
                    Nop=Integer.parseInt(nop);
                    System.out.println(nop);
                }
                if(Nop!=0){
                    JOptionPane.showMessageDialog(rootPane, "The cell must be empty.");
                }
                else{
                    int dialogButton = JOptionPane.YES_NO_OPTION;
                    int dialogResult = JOptionPane.showConfirmDialog(this, "Are you sure to mark the cell for repair?", "Confirmation", dialogButton);
                    if(dialogResult == JOptionPane.YES_OPTION) { 
                    String query="insert into hr.needrepair values("+cellno+")";
                    dbc.insertUpdate(query);
                    JOptionPane.showMessageDialog(rootPane, "The cell has been marked for repair.");
                    this.dispose();
            } 
                }
            } catch (SQLException ex) {
                Logger.getLogger(manageOptionOfCell.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        }
        else{
            JOptionPane.showMessageDialog(rootPane, "Not enough privilege.");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(manageOptionOfCell.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(manageOptionOfCell.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(manageOptionOfCell.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(manageOptionOfCell.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new manageOptionOfCell().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
