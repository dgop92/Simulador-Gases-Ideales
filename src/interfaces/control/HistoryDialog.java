package interfaces.control;

import idealgas.datarecorder.HistoryItem;
import inevaup.dialogs.InfoDialog;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.DefaultListModel;


public class HistoryDialog extends javax.swing.JDialog {

    private DefaultListModel<HistoryItem> historyModel;
    public boolean isItemSelected;
    
    public HistoryDialog(java.awt.Frame parent, boolean modal, 
            DefaultListModel<HistoryItem> historyModel) {
        super(parent, modal);
        
        this.historyModel = historyModel;
        isItemSelected = false;
        
        initComponents();
        centreWindow();
    }
    
    private void centreWindow() {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - this.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - this.getHeight()) / 2);
        this.setLocation(x, y - 25);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        parent_layout = new javax.swing.JPanel();
        header_layout = new javax.swing.JPanel();
        header_title = new javax.swing.JLabel();
        scroll_history_panel = new javax.swing.JScrollPane();
        history_list = new javax.swing.JList<>();
        accept_button = new javax.swing.JPanel();
        accept_button_title = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        parent_layout.setBackground(new java.awt.Color(248, 249, 250));

        header_layout.setBackground(new java.awt.Color(0, 47, 108));

        header_title.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        header_title.setForeground(new java.awt.Color(255, 255, 255));
        header_title.setText("Historial");

        javax.swing.GroupLayout header_layoutLayout = new javax.swing.GroupLayout(header_layout);
        header_layout.setLayout(header_layoutLayout);
        header_layoutLayout.setHorizontalGroup(
            header_layoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(header_layoutLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(header_title)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        header_layoutLayout.setVerticalGroup(
            header_layoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(header_layoutLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(header_title)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        history_list.setBackground(new java.awt.Color(248, 249, 250));
        history_list.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        history_list.setModel(historyModel);
        history_list.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        scroll_history_panel.setViewportView(history_list);

        accept_button.setBackground(new java.awt.Color(1, 87, 155));
        accept_button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        accept_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                onAcceptHistory(evt);
            }
        });
        accept_button.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 15, 10));

        accept_button_title.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        accept_button_title.setForeground(new java.awt.Color(255, 255, 255));
        accept_button_title.setText("Aceptar");
        accept_button_title.setIconTextGap(10);
        accept_button.add(accept_button_title);

        javax.swing.GroupLayout parent_layoutLayout = new javax.swing.GroupLayout(parent_layout);
        parent_layout.setLayout(parent_layoutLayout);
        parent_layoutLayout.setHorizontalGroup(
            parent_layoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(header_layout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(parent_layoutLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(scroll_history_panel, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, parent_layoutLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(accept_button, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );
        parent_layoutLayout.setVerticalGroup(
            parent_layoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(parent_layoutLayout.createSequentialGroup()
                .addComponent(header_layout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(scroll_history_panel, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(accept_button, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(parent_layout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(parent_layout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void onAcceptHistory(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_onAcceptHistory
        
        int selectedIndex = history_list.getSelectedIndex(); 
        if (selectedIndex == -1){
            InfoDialog noSelectedItemErrorDialog = new
                InfoDialog(null, "Error", "Debes seleccionar un item", 
                InfoDialog.TypeInfoDialog.ERROR_DIALOG);
            noSelectedItemErrorDialog.setVisible(true);
            isItemSelected = false;
        }else{
            isItemSelected = true;
            this.dispose();
        }
    
    }//GEN-LAST:event_onAcceptHistory
    
    public HistoryItem getSelectedHistoryItem(){
        
        int selectedIndex = history_list.getSelectedIndex();
        return historyModel.get(selectedIndex);
        
    }
    
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
            java.util.logging.Logger.getLogger(HistoryDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HistoryDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HistoryDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HistoryDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                HistoryDialog dialog = new HistoryDialog(new javax.swing.JFrame(), true, null);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel accept_button;
    private javax.swing.JLabel accept_button_title;
    private javax.swing.JPanel header_layout;
    private javax.swing.JLabel header_title;
    private javax.swing.JList<HistoryItem> history_list;
    private javax.swing.JPanel parent_layout;
    private javax.swing.JScrollPane scroll_history_panel;
    // End of variables declaration//GEN-END:variables
}
