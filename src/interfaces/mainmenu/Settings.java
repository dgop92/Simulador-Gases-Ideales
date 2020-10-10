package interfaces.mainmenu;

import inevaup.resources.AppResources;
import inevaup.resources.R;

public class Settings extends javax.swing.JPanel {
    
    private MenuActions menuActions;
    private AppResources appResources;
    
    public Settings(MenuActions menuActions){
        this.menuActions = menuActions;
        appResources = AppResources.getAppResources();  
        
        initComponents();
        initCustomResources();
    }

    private void initCustomResources(){

        home_back_button.setBackground(appResources.getColor(R.colors.primary));
        home_back_title.setForeground(appResources.getColor(R.colors.white_text));
        home_back_title.setFont(appResources.getFont(R.fonts.roboto_regular, 16));
        home_back_title.setIcon(appResources.getIcon(R.icons.menu_back_arrow));
        home_back_title.setText(appResources.getString(R.strings.menu_back_home_title));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        settings_content_layout = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        home_back_button = new javax.swing.JPanel();
        home_back_title = new javax.swing.JLabel();

        settings_content_layout.setBackground(new java.awt.Color(248, 249, 250));

        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Es settings");

        home_back_button.setBackground(new java.awt.Color(1, 87, 155));
        home_back_button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        home_back_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                OnBackHomeButton(evt);
            }
        });
        home_back_button.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 15, 10));

        home_back_title.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        home_back_title.setForeground(new java.awt.Color(255, 255, 255));
        home_back_title.setText("Regresar");
        home_back_title.setIconTextGap(10);
        home_back_button.add(home_back_title);

        javax.swing.GroupLayout settings_content_layoutLayout = new javax.swing.GroupLayout(settings_content_layout);
        settings_content_layout.setLayout(settings_content_layoutLayout);
        settings_content_layoutLayout.setHorizontalGroup(
            settings_content_layoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(settings_content_layoutLayout.createSequentialGroup()
                .addGroup(settings_content_layoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(settings_content_layoutLayout.createSequentialGroup()
                        .addGap(327, 327, 327)
                        .addComponent(jLabel1))
                    .addGroup(settings_content_layoutLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(home_back_button, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(399, Short.MAX_VALUE))
        );
        settings_content_layoutLayout.setVerticalGroup(
            settings_content_layoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(settings_content_layoutLayout.createSequentialGroup()
                .addGap(175, 175, 175)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 161, Short.MAX_VALUE)
                .addComponent(home_back_button, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(settings_content_layout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(settings_content_layout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void OnBackHomeButton(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OnBackHomeButton
        menuActions.setHomeView();
    }//GEN-LAST:event_OnBackHomeButton


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel home_back_button;
    private javax.swing.JLabel home_back_title;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel settings_content_layout;
    // End of variables declaration//GEN-END:variables
}
