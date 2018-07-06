package RegisterPackage;

import ConnectionPackage.ConnectionClass;
import LoginPackage.LoginFrame;
import java.awt.HeadlessException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class RegisterFrame extends javax.swing.JFrame {

    public ConnectionClass con;
    
    public RegisterFrame() {
        initComponents();
        
        con = new ConnectionClass();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        RegisterLbl = new javax.swing.JLabel();
        UsernameLbl = new javax.swing.JLabel();
        PasswordLbl = new javax.swing.JLabel();
        UsernameTxt = new javax.swing.JTextField();
        PasswordTxt = new javax.swing.JPasswordField();
        RegisterBtn = new javax.swing.JButton();
        CancelBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Register");

        RegisterLbl.setFont(new java.awt.Font("SansSerif", 3, 36)); // NOI18N
        RegisterLbl.setForeground(new java.awt.Color(255, 0, 0));
        RegisterLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        RegisterLbl.setText("Register");

        UsernameLbl.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        UsernameLbl.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        UsernameLbl.setText("Username : ");

        PasswordLbl.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        PasswordLbl.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        PasswordLbl.setText("Password : ");

        RegisterBtn.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        RegisterBtn.setText("Register");
        RegisterBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegisterBtnActionPerformed(evt);
            }
        });

        CancelBtn.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        CancelBtn.setText("Cancel");
        CancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(PasswordLbl)
                        .addGap(18, 18, 18)
                        .addComponent(PasswordTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(CancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(RegisterBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(RegisterLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(UsernameLbl)
                                .addGap(18, 18, 18)
                                .addComponent(UsernameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(RegisterLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(UsernameLbl)
                    .addComponent(UsernameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PasswordLbl)
                    .addComponent(PasswordTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(RegisterBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void CancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelBtnActionPerformed
        LoginFrame log = new LoginFrame();
        log.setVisible(true);
        dispose();
    }//GEN-LAST:event_CancelBtnActionPerformed

    private void RegisterBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegisterBtnActionPerformed
        
        if(UsernameTxt.getText().equals("") || PasswordTxt.getPassword().equals("")){
            JOptionPane.showMessageDialog(rootPane, "Enter the details.");
        }else{
            registerValidate();
        }
    }//GEN-LAST:event_RegisterBtnActionPerformed

    private void registerValidate() throws HeadlessException {
        try {
            String Username = UsernameTxt.getText();
            
            char[] pass = PasswordTxt.getPassword();
            String Password = String.copyValueOf(pass);
            
            con.getCon();
            
            PreparedStatement pst = con.con.prepareStatement("insert into users (username, password) values (?,?)");
            
            pst.setString(1, Username);
            pst.setString(2, Password);
            
            pst.executeUpdate();
            
            JOptionPane.showMessageDialog(rootPane, "Thank you for registering.");
            
            
            pst.close();
            con.con.close();
            
            LoginFrame log = new LoginFrame();
            log.setVisible(true);
            dispose();
            
            
        } catch (SQLException ex) {
            Logger.getLogger(RegisterFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

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
            java.util.logging.Logger.getLogger(RegisterFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegisterFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegisterFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegisterFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new RegisterFrame().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CancelBtn;
    private javax.swing.JLabel PasswordLbl;
    private javax.swing.JPasswordField PasswordTxt;
    private javax.swing.JButton RegisterBtn;
    private javax.swing.JLabel RegisterLbl;
    private javax.swing.JLabel UsernameLbl;
    private javax.swing.JTextField UsernameTxt;
    // End of variables declaration//GEN-END:variables
}
