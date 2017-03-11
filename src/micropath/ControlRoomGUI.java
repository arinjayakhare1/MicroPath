/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package micropath;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author ArinjayaKhare1
 */
public class ControlRoomGUI extends javax.swing.JFrame {

    /**
     * Creates new form ControlRoomGUI
     */
    String name;
    public ControlRoomGUI() {
        initComponents();
    }
    public ControlRoomGUI(String x) {
        this();
        name=x;
        ControlRoomName.setText("Welcome "+x);
        String trainNo="",Signals="";
        try
        {
            ResultSet rs;
            Class.forName("com.mysql.jdbc.Driver");  // MySQL database connection
            java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?" + "user=root&password=root");
            java.sql.PreparedStatement pst = conn.prepareStatement("Select * from train_data_control_room ");
            rs=pst.executeQuery();
            while(rs.next())
            {
                String r,q;
                r=rs.getString("train_no");
                q=rs.getString("signal");
                trainNo=trainNo+r+ " " + q+ "\n";
                
                
            }
            
        }
        catch(Exception e){
       e.printStackTrace();
       
        }  
        TrainTable.setText(trainNo);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        ControlRoomName = new javax.swing.JLabel();
        ExitButton = new javax.swing.JButton();
        LogoutButton = new javax.swing.JButton();
        AddTrain = new javax.swing.JButton();
        Emergency = new javax.swing.JButton();
        TrainTable = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Control Room Display");

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));

        ControlRoomName.setBackground(new java.awt.Color(0, 153, 153));
        ControlRoomName.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        ControlRoomName.setForeground(new java.awt.Color(0, 153, 0));
        ControlRoomName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        ExitButton.setText("Exit");
        ExitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitButtonActionPerformed(evt);
            }
        });

        LogoutButton.setText("Logout");
        LogoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogoutButtonActionPerformed(evt);
            }
        });

        AddTrain.setText("Add More Trains");
        AddTrain.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddTrainActionPerformed(evt);
            }
        });

        Emergency.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        Emergency.setForeground(new java.awt.Color(255, 0, 0));
        Emergency.setText("EMERGENCY STOP");
        Emergency.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EmergencyActionPerformed(evt);
            }
        });

        TrainTable.setEditable(false);
        TrainTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TrainTableActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(ControlRoomName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(AddTrain, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addComponent(Emergency, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 272, Short.MAX_VALUE)
                        .addComponent(LogoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(ExitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(TrainTable)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(ControlRoomName, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TrainTable, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ExitButton)
                    .addComponent(LogoutButton)
                    .addComponent(AddTrain, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Emergency, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ExitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitButtonActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_ExitButtonActionPerformed

    private void LogoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutButtonActionPerformed
        // TODO add your handling code here:
        microPathStarts micro=new microPathStarts();
        this.setVisible(false);
        micro.setVisible(true);
    }//GEN-LAST:event_LogoutButtonActionPerformed

    private void AddTrainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddTrainActionPerformed
        // TODO add your handling code here:
        AddTrains addt=new AddTrains(name);
        this.setVisible(false);
        addt.setVisible(true);
    }//GEN-LAST:event_AddTrainActionPerformed

    private void EmergencyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EmergencyActionPerformed
        // TODO add your handling code here:
        //TrainTable.setText("All Signals red Now");
        try
        {
            String new_train_number,new_train_signal;
            
            ResultSet rs;
            Class.forName("com.mysql.jdbc.Driver");  // MySQL database connection
            java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?" + "user=root&password=root");
            PreparedStatement ps = conn.prepareStatement("UPDATE `demo`.`train_data_control_room` SET `signal`='0' WHERE `signal`='1' ");
            ps.executeUpdate();
            ps.close();
            
            
        }
        catch(Exception e){
       e.printStackTrace();
       
        }  
        
    }//GEN-LAST:event_EmergencyActionPerformed

    private void TrainTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TrainTableActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TrainTableActionPerformed

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
            java.util.logging.Logger.getLogger(ControlRoomGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ControlRoomGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ControlRoomGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ControlRoomGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ControlRoomGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddTrain;
    private javax.swing.JLabel ControlRoomName;
    private javax.swing.JButton Emergency;
    private javax.swing.JButton ExitButton;
    private javax.swing.JButton LogoutButton;
    private javax.swing.JTextField TrainTable;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
