/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package layout;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/**
 *
 * @author GOODWARE1
 */
import miscellaneous.*;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainFrame extends javax.swing.JFrame {

    public static Koneksi dbSetting;
    public static String driver, database, user, pass;

    public MainFrame() {
        initComponents();
        dateAndTime();
        initMenuDatabase();
        this.setIconImage((Toolkit.getDefaultToolkit().getImage(getClass().getResource("/resource/ic_launcher.png"))));
    }

    public static void connect() {

        dbSetting = new Koneksi();
        driver = dbSetting.SettingPanel("DBDriver");
        database = dbSetting.SettingPanel("DBDatabase");
        user = dbSetting.SettingPanel("DBUsername");
        pass = dbSetting.SettingPanel("DBPassword");

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        Date = new javax.swing.JLabel();
        Clock = new javax.swing.JLabel();
        menu = new javax.swing.JLabel();
        panelUtama = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        databaseMenu = new javax.swing.JMenu();
        penjualanMenu = new javax.swing.JMenu();
        pembelianMenu = new javax.swing.JMenu();
        laporanMenu = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(60, 63, 66));

        jPanel2.setBackground(new java.awt.Color(60, 63, 66));
        jPanel2.setForeground(new java.awt.Color(187, 187, 188));
        jPanel2.setMaximumSize(new java.awt.Dimension(238, 39));

        Date.setForeground(new java.awt.Color(187, 187, 188));
        Date.setText("Kamis, 28 September 2020");

        Clock.setForeground(new java.awt.Color(187, 187, 188));
        Clock.setText("00:00:00");

        menu.setForeground(new java.awt.Color(187, 187, 188));
        menu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        menu.setText("Menu Database");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 672, Short.MAX_VALUE)
                .addComponent(Date)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Clock)
                .addGap(19, 19, 19))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Date)
                    .addComponent(Clock)
                    .addComponent(menu))
                .addContainerGap())
        );

        panelUtama.setBackground(new java.awt.Color(60, 63, 66));

        javax.swing.GroupLayout panelUtamaLayout = new javax.swing.GroupLayout(panelUtama);
        panelUtama.setLayout(panelUtamaLayout);
        panelUtamaLayout.setHorizontalGroup(
            panelUtamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelUtamaLayout.setVerticalGroup(
            panelUtamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 519, Short.MAX_VALUE)
        );

        jMenuBar1.setBackground(new java.awt.Color(187, 187, 187));
        jMenuBar1.setForeground(new java.awt.Color(60, 63, 65));
        jMenuBar1.setMaximumSize(new java.awt.Dimension(150, 32769));
        jMenuBar1.setPreferredSize(new java.awt.Dimension(150, 79));

        databaseMenu.setBackground(new java.awt.Color(187, 187, 188));
        databaseMenu.setForeground(new java.awt.Color(255, 255, 255));
        databaseMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/database.png"))); // NOI18N
        databaseMenu.setText("Database");
        databaseMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        databaseMenu.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        databaseMenu.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        databaseMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                databaseMenuMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                databaseMenuMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                databaseMenuMousePressed(evt);
            }
        });
        jMenuBar1.add(databaseMenu);

        penjualanMenu.setBackground(new java.awt.Color(187, 187, 188));
        penjualanMenu.setForeground(new java.awt.Color(255, 255, 255));
        penjualanMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/cart.png"))); // NOI18N
        penjualanMenu.setText("Penjualan");
        penjualanMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        penjualanMenu.setHideActionText(true);
        penjualanMenu.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        penjualanMenu.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        penjualanMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                penjualanMenuMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                penjualanMenuMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                penjualanMenuMousePressed(evt);
            }
        });
        jMenuBar1.add(penjualanMenu);

        pembelianMenu.setBackground(new java.awt.Color(187, 187, 188));
        pembelianMenu.setForeground(new java.awt.Color(255, 255, 255));
        pembelianMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/box.png"))); // NOI18N
        pembelianMenu.setText("Pembelian");
        pembelianMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pembelianMenu.setHideActionText(true);
        pembelianMenu.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        pembelianMenu.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        pembelianMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pembelianMenuMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pembelianMenuMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pembelianMenuMousePressed(evt);
            }
        });
        jMenuBar1.add(pembelianMenu);

        laporanMenu.setBackground(new java.awt.Color(187, 187, 188));
        laporanMenu.setForeground(new java.awt.Color(255, 255, 255));
        laporanMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/laporan.png"))); // NOI18N
        laporanMenu.setText("Laporan");
        laporanMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        laporanMenu.setHideActionText(true);
        laporanMenu.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        laporanMenu.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        laporanMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                laporanMenuMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                laporanMenuMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                laporanMenuMousePressed(evt);
            }
        });
        jMenuBar1.add(laporanMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelUtama)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(panelUtama))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void databaseMenuMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_databaseMenuMousePressed

        initMenuDatabase();
    }//GEN-LAST:event_databaseMenuMousePressed

    private void databaseMenuMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_databaseMenuMouseEntered
        databaseMenu.setOpaque(true);
        databaseMenu.setBackground(javax.swing.UIManager.getDefaults().getColor("MenuItem.selectionBackground"));
        databaseMenu.setForeground(new Color(0, 0, 0));
    }//GEN-LAST:event_databaseMenuMouseEntered

    private void databaseMenuMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_databaseMenuMouseExited
        databaseMenu.setOpaque(true);
        databaseMenu.setBackground(new Color(187, 187, 187));
        databaseMenu.setForeground(new Color(255, 255, 255));
    }//GEN-LAST:event_databaseMenuMouseExited

    private void penjualanMenuMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_penjualanMenuMouseEntered
        penjualanMenu.setOpaque(true);
        penjualanMenu.setBackground(javax.swing.UIManager.getDefaults().getColor("MenuItem.selectionBackground"));
        penjualanMenu.setForeground(new Color(0, 0, 0));
    }//GEN-LAST:event_penjualanMenuMouseEntered

    private void penjualanMenuMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_penjualanMenuMouseExited
        penjualanMenu.setOpaque(true);
        penjualanMenu.setBackground(new Color(187, 187, 187));
        penjualanMenu.setForeground(new Color(255, 255, 255));
    }//GEN-LAST:event_penjualanMenuMouseExited

    private void penjualanMenuMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_penjualanMenuMousePressed
        Penjualan panelPenjualan = new Penjualan();
        panelUtama.removeAll();
        panelUtama.add(panelPenjualan);
        panelPenjualan.setVisible(true);
        menu.setText("Menu Penjualan");
        try {
            panelPenjualan.setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_penjualanMenuMousePressed

    private void pembelianMenuMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pembelianMenuMouseEntered
        pembelianMenu.setOpaque(true);
        pembelianMenu.setBackground(javax.swing.UIManager.getDefaults().getColor("MenuItem.selectionBackground"));
        pembelianMenu.setForeground(new Color(0, 0, 0));
    }//GEN-LAST:event_pembelianMenuMouseEntered

    private void pembelianMenuMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pembelianMenuMouseExited
        pembelianMenu.setOpaque(true);
        pembelianMenu.setBackground(new Color(187, 187, 187));
        pembelianMenu.setForeground(new Color(255, 255, 255));
    }//GEN-LAST:event_pembelianMenuMouseExited

    private void pembelianMenuMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pembelianMenuMousePressed
        Pembelian panelPembelian = new Pembelian();
        panelUtama.removeAll();
        panelUtama.add(panelPembelian);
        panelPembelian.setVisible(true);
        menu.setText("Menu Pembelian");
        try {
            panelPembelian.setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_pembelianMenuMousePressed

    private void laporanMenuMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_laporanMenuMouseEntered

        laporanMenu.setOpaque(true);
        laporanMenu.setBackground(javax.swing.UIManager.getDefaults().getColor("MenuItem.selectionBackground"));
        laporanMenu.setForeground(new Color(0, 0, 0));

    }//GEN-LAST:event_laporanMenuMouseEntered

    private void laporanMenuMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_laporanMenuMouseExited

        laporanMenu.setOpaque(true);
        laporanMenu.setBackground(new Color(187, 187, 187));
        laporanMenu.setForeground(new Color(255, 255, 255));

    }//GEN-LAST:event_laporanMenuMouseExited

    private void laporanMenuMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_laporanMenuMousePressed
        Laporan panelSirkulasi = new Laporan();
        panelUtama.removeAll();
        panelUtama.add(panelSirkulasi);
        panelSirkulasi.setVisible(true);
        menu.setText("Menu Pembelian");
        try {
            panelSirkulasi.setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_laporanMenuMousePressed

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

    public static String formatter(String input) {
        if (!input.isEmpty()) {
            DecimalFormatSymbols symbol = new DecimalFormatSymbols();
            symbol.setGroupingSeparator('.');

            DecimalFormat format = new DecimalFormat(" Rp ###,###");
            format.setDecimalFormatSymbols(symbol);

            return format.format(Double.parseDouble(input));
        } else {
            return "";
        }

    }

    private void initMenuDatabase() {
        Database database = new Database();
        panelUtama.removeAll();
        panelUtama.add(database);
        database.setVisible(true);
        menu.setText("Menu Database");
        try {
            database.setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Clock;
    private javax.swing.JLabel Date;
    private javax.swing.JMenu databaseMenu;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JMenu laporanMenu;
    private javax.swing.JLabel menu;
    private javax.swing.JDesktopPane panelUtama;
    private javax.swing.JMenu pembelianMenu;
    private javax.swing.JMenu penjualanMenu;
    // End of variables declaration//GEN-END:variables
}
