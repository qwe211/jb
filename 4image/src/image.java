
import java.awt.HeadlessException;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author amndw
 */
public class image extends javax.swing.JFrame {

    /**
     * Creates new form image
     */
    public image() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbldisplay = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        id = new javax.swing.JTextField();
        name = new javax.swing.JTextField();
        btn_browse = new javax.swing.JButton();
        btn_db = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setText("id");

        jLabel3.setText("name");

        btn_browse.setText("browse");
        btn_browse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_browseActionPerformed(evt);
            }
        });

        btn_db.setText("insert to db");
        btn_db.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_dbActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbldisplay, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(34, 34, 34)
                        .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btn_browse))
                .addGap(68, 68, 68)
                .addComponent(jLabel3)
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_db)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(name, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lbldisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_browse)
                    .addComponent(btn_db))
                .addGap(0, 17, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    String s;
    private void btn_browseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_browseActionPerformed
        // TODO add your handling code here:
        JFileChooser fc = new JFileChooser();
        FileNameExtensionFilter ff = new FileNameExtensionFilter(".jpg","jpeg",".img",".png");
        fc.addChoosableFileFilter(ff);
        int res = fc.showSaveDialog(null);
        if(res == JFileChooser.APPROVE_OPTION)
        {
            File sf = fc.getSelectedFile();
            String path = sf.getAbsolutePath();
            ImageIcon imgicon = new ImageIcon(path);
            Image img = imgicon.getImage();
            Image newimg = img.getScaledInstance(lbldisplay.getWidth(), lbldisplay.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon newimgicon = new ImageIcon(newimg);
            lbldisplay.setIcon(newimgicon);    
            s = path;
        }
        else if(res == JFileChooser.CANCEL_OPTION)
        {
            JOptionPane.showMessageDialog(null, "No Data");
        }                                

    }//GEN-LAST:event_btn_browseActionPerformed

    private void btn_dbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_dbActionPerformed
        // TODO add your handling code here:
        try
        {
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/addimage","root","Amaan#46");
            PreparedStatement ps = con.prepareStatement("insert into image values(?,?,?)");
            InputStream is = new FileInputStream(new File(s));
            ps.setString(1,id.getText());
	    ps.setString(2,name.getText());
            ps.setBlob(3, is);
            int rs = ps.executeUpdate();
            if(rs == 1)
            {
                JOptionPane.showMessageDialog(null, "Image Uploaded.");
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Image not Uploaded.");
            }
        }
        catch(SQLException | FileNotFoundException | HeadlessException ex)
        {
            System.out.println(ex);
        }
    }//GEN-LAST:event_btn_dbActionPerformed

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(image.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new image().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_browse;
    private javax.swing.JButton btn_db;
    private javax.swing.JTextField id;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lbldisplay;
    private javax.swing.JTextField name;
    // End of variables declaration//GEN-END:variables
    private ImageIcon ResizeImage(String imgPath) {
        ImageIcon MyImage = new ImageIcon(imgPath);
        Image img = MyImage.getImage();
        Image newImage = img.getScaledInstance(lbldisplay.getWidth(),lbldisplay.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImage); 
        return image;
        
    }
}
