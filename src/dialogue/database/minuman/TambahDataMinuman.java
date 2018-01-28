/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dialogue.database.minuman;

import dialogue.database.orang.*;
import dialogue.sirkulasi.*;
import layout.MainFrame;
import static layout.MainFrame.formatter;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import layout.Database;
import layout.Sirkulasi;

/**
 *
 * @author GOODWARE1
 */
public class TambahDataMinuman extends java.awt.Dialog {

    /**
     * Creates new form
     */
    private static String mTitle;

    public TambahDataMinuman(java.awt.Frame parent, String title, boolean modal) {
        super(parent, title, modal);
        mTitle = title;
        initComponents();
        MainFrame.connect();
        getNamaSupplierToComboBox();
        fHarga.setText(" Rp  ");
        fHarga.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                fHarga.setText(formatter(EditDataMinuman.takeNominal(fHarga.getText())));

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
        fMerk = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        fStok = new javax.swing.JTextField();
        batal = new javax.swing.JButton();
        tambah = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        fHarga = new javax.swing.JTextField();
        comboUkuran = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        comboIsi = new javax.swing.JComboBox<>();
        fTanggal = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        comboDistributor = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(60, 63, 66));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        jLabel1.setForeground(new java.awt.Color(187, 187, 188));
        jLabel1.setText("Merk");

        fMerk.setToolTipText("");
        fMerk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fMerkActionPerformed(evt);
            }
        });

        jLabel2.setForeground(new java.awt.Color(187, 187, 188));
        jLabel2.setText("Stok");

        fStok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fStokActionPerformed(evt);
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
        jLabel3.setText("Ukuran");

        jLabel4.setForeground(new java.awt.Color(187, 187, 188));
        jLabel4.setText("Harga Barang");

        fHarga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fHargaActionPerformed(evt);
            }
        });

        comboUkuran.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih Ukuran", "1500", "1200", "660", "Cup" }));
        comboUkuran.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboUkuranActionPerformed(evt);
            }
        });

        jLabel5.setForeground(new java.awt.Color(187, 187, 188));
        jLabel5.setText("Isi");

        comboIsi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih Isi Perdus", "12", "24", "48" }));
        comboIsi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboIsiActionPerformed(evt);
            }
        });

        fTanggal.setDateFormatString("dd-MM-yyyy");

        jLabel6.setForeground(new java.awt.Color(187, 187, 188));
        jLabel6.setText("Tanggal Masuk");

        jLabel7.setForeground(new java.awt.Color(187, 187, 188));
        jLabel7.setText("Distributor");

        comboDistributor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih Distributor" }));

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
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(comboDistributor, 0, 229, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(fMerk, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
                        .addComponent(fHarga, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
                        .addComponent(fStok, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
                        .addComponent(fTanggal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(comboIsi, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(comboUkuran, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(41, 41, 41))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fMerk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(comboUkuran, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(comboIsi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(fStok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(fHarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(fTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(comboDistributor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tambah)
                    .addComponent(batal))
                .addContainerGap())
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
        if (fMerk.getText().isEmpty()
                || comboUkuran.getSelectedIndex() == 0
                || comboIsi.getSelectedIndex() == 0
                || fStok.getText().isEmpty()
                || fTanggal.getDate() == null
                || fHarga.getText().isEmpty()
                || comboDistributor.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Data tidak boleh kosong, silakan coba lagi", "Peringatan", JOptionPane.WARNING_MESSAGE);
        } else {
            try {
                Class.forName(MainFrame.driver);
                Connection kon = DriverManager.getConnection(MainFrame.database, MainFrame.user, MainFrame.pass);
                Statement stt = kon.createStatement();
                String[] data = new String[8];

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

                data[0] = generateKodeMinuman(fMerk.getText(), comboUkuran.getSelectedIndex(), fTanggal.getDate());
                data[1] = fMerk.getText();
                data[2] = comboUkuran.getSelectedItem().toString();
                data[3] = comboIsi.getSelectedItem().toString();
                data[4] = fStok.getText();
                data[5] = EditDataOrang.takeNominal(fHarga.getText());
                data[6] = sdf.format(fTanggal.getDate());
                data[7] = comboDistributor.getSelectedIndex() + "";

                for (int k = 0; k > data.length; k++) {

                    System.out.println(data[k]);

                }

                String SQLInsert = "INSERT into  minuman (kd_min , nama_min, ukuran, isi, stok, harga_beli, tgl_masuk, kd_dis) VALUES "
                        + "('" + data[0]
                        + "', '" + data[1]
                        + "', '" + data[2]
                        + "', '" + data[3]
                        + "', '" + data[4]
                        + "', '" + data[5]
                        + "', '" + data[6]
                        + "', '" + data[7] + "') ;";
                stt.execute(SQLInsert);

                //reformat data to frontend
                data[0] = data[0].substring(0, 3) + "-"
                        + data[0].substring(3, 7) + "-" + data[0].substring(7, 13);

                data[2] = data[2] + " ml";

                data[5] = MainFrame.formatter(data[5]);

                DateFormat df
                        = new SimpleDateFormat("dd MMMM yyyy", new Locale("in", "ID"));

                DateFormat sqlDateFormat
                        = new SimpleDateFormat("yyyy-MM-dd");

                data[6] = df.format(sqlDateFormat.parse(data[6]));
                
                data[7] = comboDistributor.getSelectedItem().toString() ;

                Database.minumanTableModel.addRow(data);

                this.dispose();

            } catch (ClassNotFoundException | NumberFormatException | SQLException ex) {
                JOptionPane.showMessageDialog(this, "Terjadi kesalahan", "Peringatan", JOptionPane.WARNING_MESSAGE);
                System.out.println(ex.getMessage());

            } catch (ParseException ex) {
                Logger.getLogger(TambahDataMinuman.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_tambahActionPerformed

    private void batalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_batalActionPerformed
        this.dispose();
    }//GEN-LAST:event_batalActionPerformed

    private void fMerkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fMerkActionPerformed
        comboUkuran.requestFocus();
    }//GEN-LAST:event_fMerkActionPerformed

    private void fStokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fStokActionPerformed
        fHarga.requestFocus();
    }//GEN-LAST:event_fStokActionPerformed

    private void fHargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fHargaActionPerformed
        tambahActionPerformed(evt);
    }//GEN-LAST:event_fHargaActionPerformed

    private void comboIsiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboIsiActionPerformed
        fStok.requestFocus();
    }//GEN-LAST:event_comboIsiActionPerformed

    private void comboUkuranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboUkuranActionPerformed
        comboIsi.requestFocus();
    }//GEN-LAST:event_comboUkuranActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TambahDataMinuman dialog = new TambahDataMinuman(new java.awt.Frame(), mTitle, true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    private String generateKodeMinuman(String merk, int indexUkuran, java.util.Date tanggal) {

        String hasil = merk.substring(0, 3).toUpperCase();

        switch (indexUkuran) {

            case 1: {
                hasil += "1500";
                break;
            }

            case 2: {
                hasil += "1200";
                break;
            }

            case 3: {
                hasil += "0660";
                break;
            }

            case 4: {
                hasil += "9999";
                break;
            }

            default: {
                break;
            }

        }

        SimpleDateFormat sdf = new SimpleDateFormat("ddMMyy");

        hasil += sdf.format(tanggal);

        return hasil;
    }

    private void getNamaSupplierToComboBox() {
        try {
            Class.forName(MainFrame.driver);
            Connection kon = DriverManager.getConnection(MainFrame.database, MainFrame.user, MainFrame.pass);
            Statement stt = kon.createStatement();

            String SQL = "select * from distributor";
            ResultSet res = stt.executeQuery(SQL);

            while (res.next()) {
                comboDistributor.addItem(res.getString(2));

            }
            res.close();
            stt.close();
            kon.close();

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(TambahDataMinuman.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton batal;
    private javax.swing.JComboBox<String> comboDistributor;
    private javax.swing.JComboBox<String> comboIsi;
    private javax.swing.JComboBox<String> comboUkuran;
    private javax.swing.JTextField fHarga;
    private javax.swing.JTextField fMerk;
    private javax.swing.JTextField fStok;
    private com.toedter.calendar.JDateChooser fTanggal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JButton tambah;
    // End of variables declaration//GEN-END:variables
}