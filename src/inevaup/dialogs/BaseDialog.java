package inevaup.dialogs;

import java.awt.Dimension;
import java.awt.Toolkit;
/**
*Genera la estructura principal de los diálogos y su composición, además de determinar el diseño gráfico de estos, y heredar las características a las subclases.    
 */
public class BaseDialog extends javax.swing.JDialog {
    
    private DialogActions dialogActions;
    /**
     * Inicializa los componentes y los recursos y ordena la visualización de los diálogos. 
     */
    public BaseDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
                
        initComponents();
        centerDialogOnScreen();
        setBaseResources();

    }
  
    private void setBaseResources(){
        parent_layout.setBackground(DialogConstantData.BACKGROUND_COLOR);
        content_panel.setBackground(DialogConstantData.BACKGROUND_COLOR);
        button_panel.setBackground(DialogConstantData.BACKGROUND_COLOR);
        
        title_label.setForeground(DialogConstantData.FOREGROUND_COLOR_2);
        
        message_label.setForeground(DialogConstantData.FOREGROUND_COLOR);
        cancel_button.setForeground(DialogConstantData.FOREGROUND_COLOR);
        ok_button.setForeground(DialogConstantData.FOREGROUND_COLOR);
    }
    
    protected void setActionInterface(DialogActions dialogActions){
        this.dialogActions = dialogActions;
    }
 
    protected void setDialogIcon(String path){
        title_label.setIcon(new javax.swing.ImageIcon(
                getClass().getResource(path)));
    }
  
    protected void setDialogTitle(String title){
        title_label.setText(title);
    }
  
    protected void setDialogHeaderColor(java.awt.Color color){
        title_layout.setBackground(color);
    }
  
    protected void setDialogMessage(String message){
        setNewHeight(message);
        message_label.setText("<html>" + message + "</html>");
        
    }

    private void setNewHeight(String message){
        
        int maxChar = 43;
        int pixelPerLine = 17;
        
        int currChar = message.length();
        int extaSize = (currChar / maxChar) * pixelPerLine;
        
        this.setSize(this.getWidth(), this.getHeight() + extaSize);
        
        System.out.println(extaSize+"  ");
        
        Dimension contentSize = content_panel.getPreferredSize();
        contentSize.height = contentSize.height + extaSize;
        content_panel.setPreferredSize(contentSize);
        content_panel.updateUI();
        
        Dimension messageSize = message_label.getPreferredSize();
        messageSize.height = messageSize.height + extaSize;
        message_label.setPreferredSize(messageSize);
        message_label.updateUI();
               
    }
    
    protected void setCancelButtonVisibility(boolean isVisible){
        cancel_button.setVisible(isVisible);
    }
    
    private void centerDialogOnScreen() {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - this.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - this.getHeight()) / 2);
        this.setLocation(x, y-25);
    }
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    
    private void initComponents() {

        parent_layout = new javax.swing.JPanel();
        title_layout = new javax.swing.JPanel();
        title_label = new javax.swing.JLabel();
        content_panel = new javax.swing.JPanel();
        message_label = new javax.swing.JLabel();
        button_panel = new javax.swing.JPanel();
        cancel_button = new javax.swing.JLabel();
        ok_button = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        parent_layout.setBackground(new java.awt.Color(247, 249, 249));

        title_layout.setBackground(new java.awt.Color(51, 51, 51));

        title_label.setBackground(new java.awt.Color(55, 71, 79));
        title_label.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        title_label.setForeground(new java.awt.Color(255, 255, 255));
        title_label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-ok-24.png"))); // NOI18N
        title_label.setText("Title");
        title_label.setIconTextGap(15);

        javax.swing.GroupLayout title_layoutLayout = new javax.swing.GroupLayout(title_layout);
        title_layout.setLayout(title_layoutLayout);
        title_layoutLayout.setHorizontalGroup(
            title_layoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(title_layoutLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(title_label)
                .addContainerGap(290, Short.MAX_VALUE))
        );
        title_layoutLayout.setVerticalGroup(
            title_layoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(title_layoutLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(title_label)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        content_panel.setBackground(new java.awt.Color(247, 249, 249));
        content_panel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 30, 20));

        message_label.setBackground(new java.awt.Color(255, 51, 51));
        message_label.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        message_label.setForeground(new java.awt.Color(33, 33, 33));
        message_label.setText("Display your message here");
        message_label.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        message_label.setPreferredSize(new java.awt.Dimension(310, 17));
        content_panel.add(message_label);

        button_panel.setBackground(new java.awt.Color(247, 249, 249));
        button_panel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT, 20, 0));

        cancel_button.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cancel_button.setForeground(new java.awt.Color(51, 51, 51));
        cancel_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-ok-nowhite-24.png"))); // NOI18N
        cancel_button.setText("Cancelar");
        cancel_button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cancel_button.setIconTextGap(15);
        cancel_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cancel_buttonMouseClicked(evt);
            }
        });
        button_panel.add(cancel_button);

        ok_button.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ok_button.setForeground(new java.awt.Color(51, 51, 51));
        ok_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-cancel-24.png"))); // NOI18N
        ok_button.setText("Aceptar");
        ok_button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ok_button.setIconTextGap(15);
        ok_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ok_buttonMouseClicked(evt);
            }
        });
        button_panel.add(ok_button);

        javax.swing.GroupLayout parent_layoutLayout = new javax.swing.GroupLayout(parent_layout);
        parent_layout.setLayout(parent_layoutLayout);
        parent_layoutLayout.setHorizontalGroup(
            parent_layoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(title_layout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(content_panel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 387, Short.MAX_VALUE)
            .addComponent(button_panel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        parent_layoutLayout.setVerticalGroup(
            parent_layoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(parent_layoutLayout.createSequentialGroup()
                .addComponent(title_layout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(content_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(button_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(12, 12, 12))
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

    private void ok_buttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ok_buttonMouseClicked
        dialogActions.onAcceptAction();
    }//GEN-LAST:event_ok_buttonMouseClicked

    private void cancel_buttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancel_buttonMouseClicked
        dialogActions.onCacelAction();
    }//GEN-LAST:event_cancel_buttonMouseClicked
        
 
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
            java.util.logging.Logger.getLogger(BaseDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BaseDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BaseDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BaseDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            /**
             * Hace visible la ventana de diálogos. 
             */
            public void run() {
                BaseDialog dialog = new BaseDialog(new javax.swing.JFrame(), true);
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
    private javax.swing.JPanel button_panel;
    private javax.swing.JLabel cancel_button;
    private javax.swing.JPanel content_panel;
    private javax.swing.JLabel message_label;
    private javax.swing.JLabel ok_button;
    private javax.swing.JPanel parent_layout;
    private javax.swing.JLabel title_label;
    private javax.swing.JPanel title_layout;
    // End of variables declaration//GEN-END:variables
    
}
