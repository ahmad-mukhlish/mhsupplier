/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frame;

import dialogue.Tambah;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 *
 * @author GOODWARE1
 */
import miscellaneous.*;
import java.sql.*;
import javax.swing.JOptionPane;

public class MainFrame extends javax.swing.JFrame {

    public static Koneksi dbSetting;
    public static String driver, database, user, pass;

    private String[] mIncomeData = new String[3];
    private String[] mOutcomeData = new String[3];

    public MainFrame() {
        initComponents();
        dateAndTime();
        connect();
        TIncome.setModel(incomeTableModel);
        TOutcome.setModel(outcomeTableModel);
        setTableLoad();

    }

    public static void connect() {

        dbSetting = new Koneksi();
        driver = dbSetting.SettingPanel("DBDriver");
        database = dbSetting.SettingPanel("DBDatabase");
        user = dbSetting.SettingPanel("DBUsername");
        pass = dbSetting.SettingPanel("DBPassword");

    }

    public static javax.swing.table.DefaultTableModel incomeTableModel = mhSupplierTableModel();
    public static javax.swing.table.DefaultTableModel outcomeTableModel = mhSupplierTableModel();

    private static javax.swing.table.DefaultTableModel mhSupplierTableModel() {

        //membuat judul header
        return new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{"Nomor", "Nama", "Nominal"}
        ) //disable perubahan pada grid
        {
            boolean[] canEdit = new boolean[]{
                false, false, false

            };

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        };
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
                outcomeTableModel.addRow(mOutcomeData);

            }
            res.close();
            stt.close();

            kon.close();

        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            JOptionPane.showMessageDialog(null, ex.getMessage(), "error", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
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
        jPanel2 = new javax.swing.JPanel();
        Date = new javax.swing.JLabel();
        Clock = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(60, 63, 66));

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

        DeleteIncome.setText("Hapus");

        AddOutcome.setText("Tambah");
        AddOutcome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddOutcomeActionPerformed(evt);
            }
        });

        EditOutcome.setText("Edit");

        DeleteOutcome.setText("Hapus");

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(110, 110, 110))
            .addGroup(jPanel1Layout.createSequentialGroup()
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
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(income, javax.swing.GroupLayout.PREFERRED_SIZE, 443, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(outcome, javax.swing.GroupLayout.PREFERRED_SIZE, 443, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(total)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AddIncome)
                    .addComponent(EditIncome)
                    .addComponent(DeleteIncome)
                    .addComponent(AddOutcome)
                    .addComponent(EditOutcome)
                    .addComponent(DeleteOutcome))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(outcome, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(income, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jScrollPane2.setViewportView(jPanel1);

        jPanel2.setBackground(new java.awt.Color(60, 63, 66));

        Date.setForeground(new java.awt.Color(187, 187, 188));
        Date.setText("Kamis, 28 September 2020");

        Clock.setForeground(new java.awt.Color(187, 187, 188));
        Clock.setText("00:00:00");

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(187, 187, 188));
        jLabel1.setText("MH SUPPLIER ADMIN PROGRAM - PROTOTYPE VERSION");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Date)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Clock)
                .addGap(19, 19, 19))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Date)
                    .addComponent(Clock))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 950, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 399, Short.MAX_VALUE)
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

    private void AddOutcomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddOutcomeActionPerformed
        TOutcome.clearSelection();
        Tambah tambahOutcome = new Tambah(null, "Tambah Data Pengeluaran", true);
        tambahOutcome.setLocationRelativeTo(this);
        tambahOutcome.setVisible(true);
    }//GEN-LAST:event_AddOutcomeActionPerformed

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
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainFrame().setVisible(true);
            }
        });

    }

    private void dateAndTime() {
        DateFormat df
                = new SimpleDateFormat("EEEE, dd MMMM yyyy", new Locale("in", "ID"));

        ActionListener tickTock = (ActionEvent evt) -> {

            Calendar today = Calendar.getInstance();

            String zeroHour = "";
            String zeroMinute = "";
            String zeroSecond = "";

            int hour = today.get(Calendar.HOUR);
            int minute = today.get(Calendar.MINUTE);
            int second = today.get(Calendar.SECOND);

            if (hour <= 9) {
                zeroHour = "0";
            }

            if (minute <= 9) {
                zeroMinute = "0";
            }

            if (second <= 9) {
                zeroSecond = "0";
            }

            Clock.setText(zeroHour + hour + ":" + zeroMinute + minute + ":" + zeroSecond + second);
            Date.setText(df.format(today.getTime()));

        };

        new javax.swing.Timer(1000, tickTock).start();

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddIncome;
    private javax.swing.JButton AddOutcome;
    private javax.swing.JLabel Clock;
    private javax.swing.JLabel Date;
    private javax.swing.JButton DeleteIncome;
    private javax.swing.JButton DeleteOutcome;
    private javax.swing.JButton EditIncome;
    private javax.swing.JButton EditOutcome;
    private javax.swing.JTable TIncome;
    private javax.swing.JTable TOutcome;
    private javax.swing.JTextField income;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField outcome;
    private javax.swing.JTextField total;
    // End of variables declaration//GEN-END:variables
}