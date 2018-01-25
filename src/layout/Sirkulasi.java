/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package layout;

import dialogue.sirkulasi.Edit;
import dialogue.sirkulasi.Hapus;
import dialogue.sirkulasi.Tambah;
import java.io.InputStream;
import static layout.MainFrame.database;
import static layout.MainFrame.driver;
import static layout.MainFrame.pass;
import static layout.MainFrame.user;
import java.util.HashMap;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author GOODWARE1
 */
public class Sirkulasi extends javax.swing.JInternalFrame {

    /**
     * Creates new form Panel
     */
    public Sirkulasi() {
        initComponents();
        hideTitleBar();
        MainFrame.connect();
        TIncome.setModel(incomeTableModel);
        TOutcome.setModel(outcomeTableModel);
        getDatums();
        backToStart();
        setTableLoad();
    }

    private void backToStart() {
        incomeTableModel.getDataVector().removeAllElements();
        outcomeTableModel.getDataVector().removeAllElements();
        mTotalIncome = 0L;
        mTotalOutcome = 0L;
        mGrandTotal = 0L;
    }

    private void hideTitleBar() {
        setRootPaneCheckingEnabled(false);
        javax.swing.plaf.InternalFrameUI hide = this.getUI();
        ((javax.swing.plaf.basic.BasicInternalFrameUI) hide).setNorthPane(null);
    }

    private String[] mIncomeData = new String[3];
    private String[] mOutcomeData = new String[3];

    private int IncomeRow = -1, OutcomeRow = -1;
    public static long mTotalIncome, mTotalOutcome, mGrandTotal;

    public static javax.swing.table.DefaultTableModel incomeTableModel = mhSupplierTableModel();
    public static javax.swing.table.DefaultTableModel outcomeTableModel = mhSupplierTableModel();

    private static javax.swing.table.DefaultTableModel mhSupplierTableModel() {

        return new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{"Nomor", "Keterangan", "Nominal"}
        ) {
            boolean[] canEdit = new boolean[]{
                false, false, false

            };

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        };
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        panelku = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        TOutcome = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        TIncome = new javax.swing.JTable();
        AddIncome = new javax.swing.JButton();
        EditIncome = new javax.swing.JButton();
        DeleteIncome = new javax.swing.JButton();
        AddOutcome = new javax.swing.JButton();
        EditOutcome = new javax.swing.JButton();
        DeleteOutcome = new javax.swing.JButton();
        outcome = new javax.swing.JTextField();
        income = new javax.swing.JTextField();
        total = new javax.swing.JTextField();
        report = new javax.swing.JButton();

        setBackground(new java.awt.Color(60, 63, 66));

        jDesktopPane1.setBackground(new java.awt.Color(60, 63, 66));

        panelku.setBackground(new java.awt.Color(60, 63, 66));

        jTextField1.setEditable(false);
        jTextField1.setBackground(new java.awt.Color(60, 63, 66));
        jTextField1.setForeground(new java.awt.Color(187, 187, 188));
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.setText("Pemasukan");

        jTextField2.setEditable(false);
        jTextField2.setBackground(new java.awt.Color(60, 63, 66));
        jTextField2.setForeground(new java.awt.Color(187, 187, 188));
        jTextField2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField2.setText("Pengeluaran");

        TOutcome.setBackground(new java.awt.Color(60, 63, 66));
        TOutcome.setForeground(new java.awt.Color(187, 187, 188));
        TOutcome.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(TOutcome);

        TIncome.setBackground(new java.awt.Color(60, 63, 66));
        TIncome.setForeground(new java.awt.Color(187, 187, 188));
        TIncome.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        TIncome.setGridColor(new java.awt.Color(44, 44, 45));
        TIncome.setSelectionBackground(new java.awt.Color(75, 110, 176));
        TIncome.setSelectionForeground(new java.awt.Color(187, 187, 188));
        jScrollPane3.setViewportView(TIncome);

        AddIncome.setText("Tambah");
        AddIncome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddIncomeActionPerformed(evt);
            }
        });

        EditIncome.setText("Edit");
        EditIncome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditIncomeActionPerformed(evt);
            }
        });

        DeleteIncome.setText("Hapus");
        DeleteIncome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteIncomeActionPerformed(evt);
            }
        });

        AddOutcome.setText("Tambah");
        AddOutcome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddOutcomeActionPerformed(evt);
            }
        });

        EditOutcome.setText("Edit");
        EditOutcome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditOutcomeActionPerformed(evt);
            }
        });

        DeleteOutcome.setText("Hapus");
        DeleteOutcome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteOutcomeActionPerformed(evt);
            }
        });

        outcome.setEditable(false);
        outcome.setBackground(new java.awt.Color(69, 73, 75));
        outcome.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        outcome.setForeground(new java.awt.Color(187, 187, 188));
        outcome.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        outcome.setText("  TOTAL PENGELUARAN :");

        income.setEditable(false);
        income.setBackground(new java.awt.Color(69, 73, 75));
        income.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        income.setForeground(new java.awt.Color(187, 187, 188));
        income.setText("   TOTAL PEMASUKAN :");

        total.setEditable(false);
        total.setBackground(new java.awt.Color(69, 73, 75));
        total.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        total.setForeground(new java.awt.Color(187, 187, 188));
        total.setText("  GRAND TOTAL :");

        report.setText("Lihat Contoh Laporan");
        report.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reportActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelkuLayout = new javax.swing.GroupLayout(panelku);
        panelku.setLayout(panelkuLayout);
        panelkuLayout.setHorizontalGroup(
            panelkuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelkuLayout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(110, 110, 110))
            .addGroup(panelkuLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(AddIncome)
                .addGap(57, 57, 57)
                .addComponent(EditIncome, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addComponent(DeleteIncome, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(AddOutcome, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addComponent(EditOutcome, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(DeleteOutcome, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58))
            .addGroup(panelkuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 122, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelkuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(income, javax.swing.GroupLayout.PREFERRED_SIZE, 443, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(outcome, javax.swing.GroupLayout.PREFERRED_SIZE, 443, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelkuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(total)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelkuLayout.createSequentialGroup()
                .addContainerGap(813, Short.MAX_VALUE)
                .addComponent(report, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
        );
        panelkuLayout.setVerticalGroup(
            panelkuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelkuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelkuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(panelkuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelkuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AddIncome)
                    .addComponent(EditIncome)
                    .addComponent(DeleteIncome)
                    .addComponent(AddOutcome)
                    .addComponent(EditOutcome)
                    .addComponent(DeleteOutcome))
                .addGap(28, 28, 28)
                .addGroup(panelkuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(outcome, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(income, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addComponent(report)
                .addContainerGap())
        );

        jDesktopPane1.setLayer(panelku, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1052, Short.MAX_VALUE)
            .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jDesktopPane1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(panelku, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 519, Short.MAX_VALUE)
            .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jDesktopPane1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(panelku, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jDesktopPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AddIncomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddIncomeActionPerformed
        TIncome.clearSelection();
        Tambah tambahIncome = new Tambah(null, "Tambah Data Pemasukan", true);
        tambahIncome.setLocationRelativeTo(this);
        tambahIncome.setVisible(true);
    }//GEN-LAST:event_AddIncomeActionPerformed

    private void EditIncomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditIncomeActionPerformed
        if (IncomeRow != -1) {
            Edit editIncome = new Edit(null, "Edit Data Pemasukan", true, mIncomeData, IncomeRow);
            editIncome.setLocationRelativeTo(this);
            editIncome.setVisible(true);
            TIncome.clearSelection();

        } else {
            JOptionPane.showMessageDialog(this, "Silakan pilih data yang ingin diedit terlebih dahulu", "Peringatan", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_EditIncomeActionPerformed

    private void DeleteIncomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteIncomeActionPerformed
        if (IncomeRow != -1) {
            Hapus hapusIncome = new Hapus(null, "Hapus Data Pemasukan", true, mIncomeData, IncomeRow);
            hapusIncome.setLocationRelativeTo(this);
            hapusIncome.setVisible(true);
            TIncome.clearSelection();

        } else {
            JOptionPane.showMessageDialog(this, "Silakan pilih data yang ingin dihapus terlebih dahulu", "Peringatan", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_DeleteIncomeActionPerformed

    private void AddOutcomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddOutcomeActionPerformed
        TOutcome.clearSelection();
        Tambah tambahOutcome = new Tambah(null, "Tambah Data Pengeluaran", true);
        tambahOutcome.setLocationRelativeTo(this);
        tambahOutcome.setVisible(true);
    }//GEN-LAST:event_AddOutcomeActionPerformed

    private void EditOutcomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditOutcomeActionPerformed
        if (OutcomeRow != -1) {
            Edit editOutcome = new Edit(null, "Edit Data Pengeluaran", true, mOutcomeData, OutcomeRow);
            editOutcome.setLocationRelativeTo(this);
            editOutcome.setVisible(true);
            TOutcome.clearSelection();

        } else {
            JOptionPane.showMessageDialog(this, "Silakan pilih data yang ingin diedit terlebih dahulu", "Peringatan", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_EditOutcomeActionPerformed

    private void DeleteOutcomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteOutcomeActionPerformed
        if (OutcomeRow != -1) {
            Hapus hapusOutcome = new Hapus(null, "Hapus Data Pengeluaran", true, mOutcomeData, OutcomeRow);
            hapusOutcome.setLocationRelativeTo(this);
            hapusOutcome.setVisible(true);
            TOutcome.clearSelection();

        } else {
            JOptionPane.showMessageDialog(this, "Silakan pilih data yang ingin dihapus terlebih dahulu", "Peringatan", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_DeleteOutcomeActionPerformed

    private void reportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reportActionPerformed
        // TODO add your handling code here:

        try {
            // TODO add your handling code here:
            Class.forName(driver);
            Connection kon = DriverManager.getConnection(database, user, pass);

            //File file = new File("src/laporan/laporan_obat.jrxml");
            InputStream file = getClass().getResourceAsStream("/report/Prototype.jrxml");
            JasperDesign jd = JRXmlLoader.load(file);
            JasperReport rep = JasperCompileManager.compileReport(jd);
            JasperPrint jp = JasperFillManager.fillReport(rep, new HashMap<String, Object>(), kon);
            JasperViewer.viewReport(jp, false);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_reportActionPerformed

    public void getDatums() {

        TIncome.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                IncomeRow = TIncome.getSelectedRow();
                if (IncomeRow != -1) {
                    mIncomeData[0] = TIncome.getValueAt(IncomeRow, 0).toString();
                    mIncomeData[1] = TIncome.getValueAt(IncomeRow, 1).toString();
                    mIncomeData[2] = TIncome.getValueAt(IncomeRow, 2).toString();
                }
            }
        });

        TOutcome.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                OutcomeRow = TOutcome.getSelectedRow();
                if (OutcomeRow != -1) {
                    mOutcomeData[0] = TOutcome.getValueAt(OutcomeRow, 0).toString();
                    mOutcomeData[1] = TOutcome.getValueAt(OutcomeRow, 1).toString();
                    mOutcomeData[2] = TOutcome.getValueAt(OutcomeRow, 2).toString();
                }
            }
        });

    }

    private void setTableLoad() {
        try {

            Class.forName(driver);
            Connection kon = DriverManager.getConnection(database, user, pass);

            Statement stt1 = kon.createStatement();
            String SQL1 = "select * from pemasukan";
            ResultSet res1 = stt1.executeQuery(SQL1);

            while (res1.next()) {
                mIncomeData[0] = res1.getString(1);
                mIncomeData[1] = res1.getString(2);
                mIncomeData[2] = res1.getString(3);

                mTotalIncome += Long.parseLong(mIncomeData[2]);
                income.setText("  Total Pemasukan : " + MainFrame.formatter("" + mTotalIncome));

                mIncomeData[2] = MainFrame.formatter(mIncomeData[2]);
                incomeTableModel.addRow(mIncomeData);

            }

            res1.close();
            stt1.close();

            Statement stt = kon.createStatement();
            String SQL = "select * from pengeluaran";
            ResultSet res = stt.executeQuery(SQL);

            while (res.next()) {
                mOutcomeData[0] = res.getString(1);
                mOutcomeData[1] = res.getString(2);
                mOutcomeData[2] = res.getString(3);

                mTotalOutcome += Long.parseLong(mOutcomeData[2]);
                outcome.setText("  Total Pengeluaran : " + MainFrame.formatter("" + mTotalOutcome));

                mOutcomeData[2] = MainFrame.formatter(mOutcomeData[2]);
                outcomeTableModel.addRow(mOutcomeData);

            }
            res.close();
            stt.close();

            kon.close();

            mGrandTotal = mTotalIncome - mTotalOutcome;
            total.setText("  GRAND TOTAL : " + MainFrame.formatter("" + mGrandTotal));

        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            JOptionPane.showMessageDialog(null, ex.getMessage(), "error", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddIncome;
    private javax.swing.JButton AddOutcome;
    private javax.swing.JButton DeleteIncome;
    private javax.swing.JButton DeleteOutcome;
    private javax.swing.JButton EditIncome;
    private javax.swing.JButton EditOutcome;
    private javax.swing.JTable TIncome;
    private javax.swing.JTable TOutcome;
    public static javax.swing.JTextField income;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    public static javax.swing.JTextField outcome;
    private javax.swing.JPanel panelku;
    private javax.swing.JButton report;
    public static javax.swing.JTextField total;
    // End of variables declaration//GEN-END:variables
}
