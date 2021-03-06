/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dialogue.sirkulasi;

import layout.MainFrame;
import static layout.MainFrame.formatter;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.*;
import javax.swing.JOptionPane;
import layout.Laporan;

/**
 *
 * @author GOODWARE1
 */
public class TambahSirkulasi extends java.awt.Dialog {

    /**
     * Creates new form 
     */
    private static String mTitle;

    public TambahSirkulasi(java.awt.Frame parent, String title, boolean modal) {
        super(parent, title, modal);
        mTitle = title;
        initComponents();
        MainFrame.connect();
        fNominal.setText(" Rp  ");
        fNominal.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
              
            }

            @Override
            public void keyReleased(KeyEvent e) {
              fNominal.setText(formatter(EditSirkulasi.takeNominal(fNominal.getText())));
//              fInfo.setText(formatter(Edit.takeNominal(fNominal.getText())));
                       
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
        fInfo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        fNominal = new javax.swing.JTextField();
        batal = new javax.swing.JButton();
        tambah = new javax.swing.JButton();

        setBackground(new java.awt.Color(60, 63, 66));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        jLabel1.setForeground(new java.awt.Color(187, 187, 188));
        jLabel1.setText("Keterangan");

        fInfo.setToolTipText("");
        fInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fInfoActionPerformed(evt);
            }
        });

        jLabel2.setForeground(new java.awt.Color(187, 187, 188));
        jLabel2.setText("Nominal");

        fNominal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fNominalActionPerformed(evt);
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fNominal, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tambah, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(batal, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(fInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(fNominal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
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
        if (fInfo.getText().isEmpty() || fNominal.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Data tidak boleh kosong, silakan coba lagi", "Peringatan", JOptionPane.WARNING_MESSAGE);
        } else {
            try {
                Class.forName(MainFrame.driver);
                Connection kon = DriverManager.getConnection(MainFrame.database, MainFrame.user, MainFrame.pass);
                Statement stt = kon.createStatement();
                String[] data = new String[3];

                data[1] = fInfo.getText();
                data[2] = EditSirkulasi.takeNominal(fNominal.getText());
                
                String table;

                if (mTitle.contains("Pemasukan")) {
                    table = "pemasukan";
                } else {
                    table = "pengeluaran";
                }

                String SQLInsert = "INSERT into " + table + "(Info,Uang) VALUES ('" + data[1] + "', '" + data[2] + "')";
                String SQLGetNomor = "SELECT Nomor FROM " + table + " WHERE Info='" + data[1] + "' ";

                stt.execute(SQLInsert);
                ResultSet res = stt.executeQuery(SQLGetNomor);

                while (res.next()) {
                    data[0] = res.getString(1);
                }

                if (table.equals("pemasukan")) {
                    Laporan.mTotalIncome += Long.parseLong(data[2]);
                    Laporan.income.setText("  Total Pemasukan : " + MainFrame.formatter("" + Laporan.mTotalIncome));
                } else {
                    Laporan.mTotalOutcome += Long.parseLong(data[2]);
                    Laporan.outcome.setText("  Total Pengeluaran : " + MainFrame.formatter("" + Laporan.mTotalOutcome));

                }

                data[2] = MainFrame.formatter(data[2]);

                if (table.equals("pemasukan")) {
                    Laporan.incomeTableModel.addRow(data);
                } else {
                    Laporan.outcomeTableModel.addRow(data);
                }

                Laporan.mGrandTotal = Laporan.mTotalIncome - Laporan.mTotalOutcome;
                Laporan.total.setText("  GRAND TOTAL : " + formatter("" + Laporan.mGrandTotal));

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

    private void fInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fInfoActionPerformed
        fNominal.requestFocus();
    }//GEN-LAST:event_fInfoActionPerformed

    private void fNominalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fNominalActionPerformed
         tambahActionPerformed(evt);
    }//GEN-LAST:event_fNominalActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TambahSirkulasi dialog = new TambahSirkulasi(new java.awt.Frame(), mTitle, true);
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
    private javax.swing.JTextField fInfo;
    private javax.swing.JTextField fNominal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton tambah;
    // End of variables declaration//GEN-END:variables
}
