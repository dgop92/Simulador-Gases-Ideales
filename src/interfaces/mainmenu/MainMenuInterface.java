package interfaces.mainmenu;

import java.awt.CardLayout;
import inevaup.resources.AppResources;
import inevaup.resources.R;
import java.awt.Dimension;
import java.awt.Toolkit;

public class MainMenuInterface extends javax.swing.JFrame implements MenuActions{
    
    private CardLayout contentCardLayout;
    private Home homeView;
    private Instructions instructionsView;
    private Settings settingsView;
    private About aboutUsView;
    
    private AppResources appResources;
  
    public MainMenuInterface() {
        appResources = AppResources.getAppResources();
        
        initComponents();
        initCustomResources();
        initCardLayout();

        centreWindow();
    }

    private void centreWindow() {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - this.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - this.getHeight()) / 2);
        this.setLocation(x, y - 25);
    }
    
    private void initCustomResources(){
        card_content_layout.setBackground(appResources.getColor(R.colors.background_color));

        header.setBackground(appResources.getColor(R.colors.dark));
        header_title.setForeground(appResources.getColor(R.colors.white_text));
        header_title.setFont(appResources.getFont(R.fonts.montserrat_bold, 18));
        header_title.setIcon(appResources.getIcon(R.icons.menu_header_home));
        header_title.setText(appResources.getString(R.strings.app_name));

    }
    
    private void initCardLayout(){
        homeView = new Home(this);
        instructionsView = new Instructions(this);
        settingsView = new Settings(this);
        aboutUsView = new About(this);
        
        contentCardLayout = (CardLayout) (card_content_layout.getLayout());
        
        card_content_layout.add(homeView, "homeview");
        card_content_layout.add(instructionsView, "instructionsView");
        card_content_layout.add(settingsView, "settingsView");
        card_content_layout.add(aboutUsView, "aboutUsView");
        
        //The home view is the first view to be render
        contentCardLayout.show(card_content_layout, "homeview");
    }
    
    @Override
    public void setHomeView() {
        contentCardLayout.show(card_content_layout, "homeview");
        header_title.setIcon(appResources.getIcon(R.icons.menu_header_home));
        header_title.setText(appResources.getString(R.strings.app_name));
    }

    @Override
    public void setSettingView() {
        contentCardLayout.show(card_content_layout, "settingsView");
        header_title.setIcon(appResources.getIcon(R.icons.menu_header_settings));
        header_title.setText(appResources.getString(R.strings.menu_settings_title));
    }

    @Override
    public void setInstructionsView() {
        contentCardLayout.show(card_content_layout, "instructionsView");
        header_title.setIcon(appResources.getIcon(R.icons.menu_header_instructions));
        header_title.setText(appResources.getString(R.strings.menu_instructions_title));
    }

    @Override
    public void setAboutView() {
        contentCardLayout.show(card_content_layout, "aboutUsView");
        header_title.setIcon(appResources.getIcon(R.icons.menu_header_instructions));
        header_title.setText("Acerca de");
    }

    @Override
    public void closeMainMenu() {
        this.dispose();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        parent_layout = new javax.swing.JPanel();
        header = new javax.swing.JPanel();
        header_title = new javax.swing.JLabel();
        card_content_layout = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        parent_layout.setBackground(new java.awt.Color(248, 249, 250));

        header.setBackground(new java.awt.Color(0, 47, 108));
        header.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 25, 24));

        header_title.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        header_title.setForeground(new java.awt.Color(255, 255, 255));
        header_title.setIcon(new javax.swing.ImageIcon(getClass().getResource("/data/icons/menu_header_home.png"))); // NOI18N
        header_title.setText("Simulador de Gases Ideales");
        header_title.setIconTextGap(10);
        header.add(header_title);

        card_content_layout.setBackground(new java.awt.Color(248, 249, 250));
        card_content_layout.setLayout(new java.awt.CardLayout());

        javax.swing.GroupLayout parent_layoutLayout = new javax.swing.GroupLayout(parent_layout);
        parent_layout.setLayout(parent_layoutLayout);
        parent_layoutLayout.setHorizontalGroup(
            parent_layoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(header, javax.swing.GroupLayout.DEFAULT_SIZE, 798, Short.MAX_VALUE)
            .addComponent(card_content_layout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        parent_layoutLayout.setVerticalGroup(
            parent_layoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(parent_layoutLayout.createSequentialGroup()
                .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(card_content_layout, javax.swing.GroupLayout.DEFAULT_SIZE, 407, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(parent_layout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(parent_layout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(MainMenuInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainMenuInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainMenuInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainMenuInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainMenuInterface().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel card_content_layout;
    private javax.swing.JPanel header;
    private javax.swing.JLabel header_title;
    private javax.swing.JPanel parent_layout;
    // End of variables declaration//GEN-END:variables
}
