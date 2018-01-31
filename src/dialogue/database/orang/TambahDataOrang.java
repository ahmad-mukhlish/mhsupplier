/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dialogue.database.orang;

import dialogue.sirkulasi.*;
import layout.MainFrame;
import static layout.MainFrame.formatter;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.*;
import javax.swing.JOptionPane;
import layout.Database;
import layout.Laporan;

/**
 *
 * @author GOODWARE1
 */
public class TambahDataOrang extends java.awt.Dialog {

    /**
     * Creates new form
     */
    private static String mTitle;

    public TambahDataOrang(java.awt.Frame parent, String title, boolean modal) {
        super(parent, title, modal);
        mTitle = title;
        initComponents();
        MainFrame.connect();
        fUtang.setText(" Rp  ");
        fUtang.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                fUtang.setText(formatter(EditDataOrang.takeNominal(fUtang.getText())));

            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        fNama = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        fNomor = new javax.swing.JTextField();
        batal = new javax.swing.JButton();
        tambah = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        fUtang = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        fAlamat = new javax.swing.JTextArea();

        setBackground(new java.awt.Color(60, 63, 66));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        jLabel1.setForeground(new java.awt.Color(187, 187, 188));
        jLabel1.setText("Nama");

        fNama.setToolTipText("");
        fNama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fNamaActionPerformed(evt);
            }
        });

        jLabel2.setForeground(new java.awt.Color(187, 187, 188));
        jLabel2.setText("Nomor Telepon");

        fNomor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fNomorActionPerformed(evt);
            }
        });

        batal.setText("Batal");
        batal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                batalActionPerformed(evt);
            }
        });

        tambah.setText("Tambah");
        tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahActionPerformed(evt);
            }
        });

        jLabel3.setForeground(new java.awt.Color(187, 187, 188));
        jLabel3.setText("Alamat");

        jLabel4.setForeground(new java.awt.Color(187, 187, 188));
        jLabel4.setText("Jumlah Utang");

        fUtang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fUtangActionPerformed(evt);
            }
        });

        fAlamat.setColumns(20);
        fAlamat.setRows(5);
        jScrollPane1.setViewportView(fAlamat);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tambah, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(batal, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61))
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(fNama, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
                        .addComponent(fUtang, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
                        .addComponent(jScrollPane1))
                    .addComponent(fNomor, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(fNomor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(fUtang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(batal)
                    .addComponent(tambah))
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Closes the dialog
     */
    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        setVisible(false);
        dispose();
    }//GEN-LAST:event_closeDialog

    private void tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahActionPerformed
        if (fNama.getText().isEmpty() || fNomor.getText().isEmpty()
                || fAlamat.getText().isEmpty() || fUtang.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Data tidak boleh kosong, silakan coba lagi", "Peringatan", JOptionPane.WARNING_MESSAGE);
        } else {
            try {
                Class.forName(MainFrame.driver);
                Connection kon = DriverManager.getConnection(MainFrame.database, MainFrame.user, MainFrame.pass);
                Statement stt = kon.createStatement();
                String[] data = new String[5];

                data[1] = fNama.getText();
                data[2] = fAlamat.getText();
                data[3] = fNomor.getText();
                data[4] = EditDataOrang.takeNominal(fUtang.getText());

                String table, kode, nama;

                if (mTitle.contains("Distributor")) {
                    table = "distributor";
                    kode = "kd_dis";
                    nama = "nama_dis";

                } else {
                    table = "pembeli";
                    kode = "kd_pbl";
                    nama = "nama_pbl";
                }

                String SQLInsert = "INSERT into " + table + " ( " + nama + ", alamat, no_telp, total_hutang) VALUES "
                        + "('" + data[1]
                        + "', '" + data[2]
                        + "', '" + data[3]
                        + "', '" + data[4] + "') ;";
                String SQLGetNomor = "SELECT " + kode + " FROM " + table + " WHERE " + nama + " = '" + data[1] + "' ";

                stt.execute(SQLInsert);
                ResultSet res = stt.executeQuery(SQLGetNomor);

                while (res.next()) {
                    data[0] = res.getString(1);
                }

                data[4] = MainFrame.formatter(data[4]);

                if (table.equals("distributor")) {
                    data[0] = Database.koder("DIS", Integer.parseInt(data[0]));
                    Database.distributorTableModel.addRow(data);
                } else {
                    data[0] = Database.koder("PBL", Integer.parseInt(data[0]));
                    Database.pembeliTableModel.addRow(data);
                }

                this.dispose();

            } catch (ClassNotFoundException | NumberFormatException | SQLException ex) {
                JOptionPane.showMessageDialog(this, "Terjadi kesalahan", "Peringatan", JOptionPane.WARNING_MESSAGE);
                System.out.println(ex.getMessage());
            }
        }
    }//GEN-LAST:event_tambahActionPerformed

    private void batalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_batalActionPerformed
        this.dispose();
    }//GEN-LAST:event_batalActionPerformed

    private void fNamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fNamaActionPerformed
        fAlamat.requestFocus();
    }//GEN-LAST:event_fNamaActionPerformed

    private void fNomorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fNomorActionPerformed
        fUtang.requestFocus();
    }//GEN-LAST:event_fNomorActionPerformed

    private void fUtangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fUtangActionPerformed
        tambahActionPerformed(evt);
    }//GEN-LAST:event_fUtangActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TambahDataOrang dialog = new TambahDataOrang(new java.awt.Frame(), mTitle, true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton batal;
    private javax.swing.JTextArea fAlamat;
    private javax.swing.JTextField fNama;
    private javax.swing.JTextField fNomor;
    private javax.swing.JTextField fUtang;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton tambah;
    // End of variables declaration//GEN-END:variables
}
