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
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;

/**
 *
 * @author ArinjayaKhare1
 */
public class ControlRoomGUI extends javax.swing.JFrame  {

    /**
     * Creates new form ControlRoomGUI
     */
    
    DefaultListModel<CustomTrainArrayList> trainList= new DefaultListModel<CustomTrainArrayList>();
    String name;
    int count;
    public ControlRoomGUI() {
        count=0;
        initComponents();
        
    }
    String query2;
    String query;
    java.sql.Connection conn;
    public ControlRoomGUI(String x) {
        this();
        name=x;
        ControlRoomName.setText("Welcome Employees of "+x.toUpperCase()+" Control Room");
        query="Select * from "+name;
        query2="UPDATE "+name+" SET `signal`='0' WHERE `signal`='1' ";
        String trainNo="",Signals="";
        
                
        try
        {   
           
            ResultSet rs;
            Class.forName("com.mysql.jdbc.Driver");  // MySQL database connection
            conn = DriverManager.getConnection("jdbc:mysql://sql12.freesqldatabase.com:3306/sql12169908?","sql12169908","4sBAijYEGl");
            java.sql.PreparedStatement pst = conn.prepareStatement(query);
           
            rs=pst.executeQuery();
            while(rs.next())
            {
                String r,q,s;
                r=rs.getString("train_no");
                q=rs.getString("signal");
                int t=rs.getInt("speed_limit");
                String T;
                if(t<100)
                    T="0"+Integer.toString(t);
                else
                    T=Integer.toString(t);
                if(q.compareTo("0")==0)
                {
                    s="RED";
                }
                else
                {
                    s="GREEN";
                }
                trainNo=trainNo+r+"+" + q+"+"+T+ " ";
                count++;
                trainList.addElement(new CustomTrainArrayList(r,s));
                /*
                //Just to see if data is fine
                System.out.println(trainList.size());
                CustomTrainArrayList cst=trainList.get(trainList.size()-1);
                System.out.println("Data::"+cst.getSignal()+" "+cst.getTrainNo());
                */
            }
            
        }
        catch(Exception e){
       e.printStackTrace();
       
        }  
        JList<CustomTrainArrayList> TrainTableData = new JList<CustomTrainArrayList>(trainList);
        
       jScrollPane1.setViewportView(TrainTableData);
       TrainTableData.setCellRenderer(new TrainDataRenderer(name));
       if(count < 10)
           trainNo= "0"+Integer.toString(count)+"+"+trainNo;
       else
            trainNo= Integer.toString(count)+"+"+trainNo;
       Send_signal send = new Send_signal(trainNo);//Use count
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
        updateSignalButton = new javax.swing.JButton();
        removeTrainButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();

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
        Emergency.setText("Emergency Stop");
        Emergency.setMaximumSize(new java.awt.Dimension(127, 25));
        Emergency.setMinimumSize(new java.awt.Dimension(127, 25));
        Emergency.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EmergencyActionPerformed(evt);
            }
        });

        updateSignalButton.setText("Update Signal");
        updateSignalButton.setMaximumSize(new java.awt.Dimension(127, 25));
        updateSignalButton.setMinimumSize(new java.awt.Dimension(127, 25));
        updateSignalButton.setPreferredSize(new java.awt.Dimension(127, 25));
        updateSignalButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateSignalButtonActionPerformed(evt);
            }
        });

        removeTrainButton.setText("Remove Train ");
        removeTrainButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeTrainButtonActionPerformed(evt);
            }
        });

        jScrollPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPane1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(106, 106, 106)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(229, 229, 229)
                                .addComponent(LogoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(ExitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(86, 86, 86)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(Emergency, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(updateSignalButton, javax.swing.GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE)
                                        .addComponent(AddTrain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(removeTrainButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGap(47, 47, 47))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(ControlRoomName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(ControlRoomName, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(AddTrain, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addComponent(updateSignalButton, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addComponent(removeTrainButton, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59)
                        .addComponent(Emergency, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ExitButton)
                            .addComponent(LogoutButton))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 453, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(26, Short.MAX_VALUE))))
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
            //Class.forName("com.mysql.jdbc.Driver");  // MySQL database connection
            //java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://sql12.freesqldatabase.com:3306/sql12169348?","sql12169348","G6xuvh91we");
            PreparedStatement ps = conn.prepareStatement(query2);
            ps.executeUpdate();
            ps.close();
            ControlRoomGUI crg=new ControlRoomGUI(name);
            this.setVisible(false);
            crg.setVisible(true);
            
        }
        catch(Exception e){
       e.printStackTrace();
       
        }  
        
    }//GEN-LAST:event_EmergencyActionPerformed

    private void updateSignalButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateSignalButtonActionPerformed
        // TODO add your handling code here:
        ControlRoomGUI controlrg=new ControlRoomGUI(name);
                this.setVisible(false);
                controlrg.setVisible(true);
        /*AddTrains addt=new AddTrains(name,1);
        this.setVisible(false);
        addt.setVisible(true);*/
        
    }//GEN-LAST:event_updateSignalButtonActionPerformed

    private void removeTrainButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeTrainButtonActionPerformed
        // TODO add your handling code here:
        DeleteTrains del=new DeleteTrains(name);
        this.setVisible(false);
        del.setVisible(true);
    }//GEN-LAST:event_removeTrainButtonActionPerformed

    private void jScrollPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jScrollPane1MouseClicked

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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton removeTrainButton;
    private javax.swing.JButton updateSignalButton;
    // End of variables declaration//GEN-END:variables
}
