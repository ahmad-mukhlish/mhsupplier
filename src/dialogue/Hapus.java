/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dialogue;

import layout.MainFrame;
import static layout.MainFrame.formatter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import layout.Sirkulasi;

/**
 *
 * @author GOODWARE1
 */
public class Hapus extends java.awt.Dialog {

    /**
     * Creates new form Edit
     */
    private static String mTitle;
    private static int mRow;
    private static String[] mDatas;

    public Hapus(java.awt.Frame parent, String title, boolean modal, String[] datas, int row) {
        super(parent, title, modal);
        mTitle = title;
        mRow = row;
        mDatas = datas;
        initComponents();
        Edit.showSelected(fInfo, fNominal, mDatas);
        layout.MainFrame.connect();
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
        hapus = new javax.swing.JButton();

        setBackground(new java.awt.Color(60, 63, 66));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        jLabel1.setForeground(new java.awt.Color(187, 187, 188));
        jLabel1.setText("Keterangan");

        fInfo.setEditable(false);
        fInfo.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        fInfo.setForeground(new java.awt.Color(153, 153, 153));
        fInfo.setToolTipText("");

        jLabel2.setForeground(new java.awt.Color(187, 187, 188));
        jLabel2.setText("Nominal");

        fNominal.setEditable(false);
        fNominal.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        fNominal.setForeground(new java.awt.Color(153, 153, 153));

        batal.setText("Batal");
        batal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                batalActionPerformed(evt);
            }
        });

        hapus.setText("Hapus");
        hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusActionPerformed(evt);
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
                .addComponent(hapus, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(hapus))
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

    private void hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusActionPerformed
        if (fInfo.getText().isEmpty() || fNominal.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Data tidak boleh kosong, silakan coba lagi", "Peringatan", JOptionPane.WARNING_MESSAGE);
        } else {
            try {
                Class.forName(MainFrame.driver);
                Connection kon = DriverManager.getConnection(MainFrame.database, MainFrame.user, MainFrame.pass);
                Statement stt = kon.createStatement();
                String[] data = new String[3];

                data[1] = fInfo.getText();
                data[2] = Edit.takeNominal(fNominal.getText());

                String table;

                if (mTitle.contains("Pemasukan")) {
                    table = "pemasukan";
                } else {
                    table = "pengeluaran";
                }

                String SQLUpdate = "DELETE FROM " + table + " "
                        + " WHERE Nomor = " + mDatas[0] + ";";
                String SQLGetNumber = "SELECT Nomor FROM " + table + " WHERE Info='" + data[1] + "' ";

                stt.execute(SQLUpdate);
                ResultSet res = stt.executeQuery(SQLGetNumber);

                while (res.next()) {
                    data[0] = res.getString(1);
                }

                if (table.equals("pemasukan")) {
                    Sirkulasi.mTotalIncome -= Long.parseLong(Edit.takeNominal(mDatas[2]));
                    Sirkulasi.income.setText("  Total Pemasukan : " + MainFrame.formatter("" + Sirkulasi.mTotalIncome));
                } else {
                    Sirkulasi.mTotalOutcome -= Long.parseLong(Edit.takeNominal(mDatas[2]));
                    Sirkulasi.outcome.setText("  Total Pengeluaran : " + MainFrame.formatter("" + Sirkulasi.mTotalOutcome));

                }

                data[2] = MainFrame.formatter(data[2]);

                if (table.equals("pemasukan")) {

                    Sirkulasi.incomeTableModel.removeRow(mRow);

                } else {

                    Sirkulasi.outcomeTableModel.removeRow(mRow);

                }

                Sirkulasi.mGrandTotal = Sirkulasi.mTotalIncome - Sirkulasi.mTotalOutcome;
                Sirkulasi.total.setText("  GRAND TOTAL : " + formatter("" + Sirkulasi.mGrandTotal));

                this.dispose();

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Terjadi kesalahan", "Peringatan", JOptionPane.WARNING_MESSAGE);
                System.out.println(ex.getMessage());
            }
        }
    }//GEN-LAST:event_hapusActionPerformed

    private void batalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_batalActionPerformed
        this.dispose();
    }//GEN-LAST:event_batalActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            Edit dialog = new Edit(new java.awt.Frame(), mTitle, true, mDatas, mRow);
            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    System.exit(0);
                }
            });
            dialog.setVisible(true);
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton batal;
    private javax.swing.JTextField fInfo;
    private javax.swing.JTextField fNominal;
    private javax.swing.JButton hapus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
