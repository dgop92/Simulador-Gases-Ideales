package interfaces.mainmenu;

import inevaup.resources.AppResources;
import inevaup.resources.R;
import interfaces.control.ControlInterface;

public class Home extends javax.swing.JPanel {
    
    //800, 410
    private MenuActions menuActions;
    private AppResources appResources;

    public Home(MenuActions menuActions){
        appResources = AppResources.getResources();
        this.menuActions = menuActions;
        
        initComponents();
        initCustomResources();
        
    }
    
    private void initCustomResources(){
        home_content_layout.setBackground(appResources.getColor(R.colors.background_color));
        //Inheritance from parent layout?
        button_menu.setBackground(appResources.getColor(R.colors.background_color));

        start_button.setBackground(appResources.getColor(R.colors.primary));
        start_button_title.setForeground(appResources.getColor(R.colors.white_text));
        start_button_title.setFont(appResources.getFont(R.fonts.roboto_regular, 16));
        start_button_title.setIcon(appResources.getIcon(R.icons.menu_play));
        start_button_title.setText(appResources.getString(R.strings.menu_start_title));

        instructions_button.setBackground(appResources.getColor(R.colors.primary));
        instructions_button_title.setForeground(appResources.getColor(R.colors.white_text));
        instructions_button_title.setFont(appResources.getFont(R.fonts.roboto_regular, 16));
        instructions_button_title.setIcon(appResources.getIcon(R.icons.menu_instructions));
        instructions_button_title.setText(appResources.getString(R.strings.menu_instructions_title));

        settings_button.setBackground(appResources.getColor(R.colors.primary));
        settings_button_title.setForeground(appResources.getColor(R.colors.white_text));
        settings_button_title.setFont(appResources.getFont(R.fonts.roboto_regular, 16));
        settings_button_title.setIcon(appResources.getIcon(R.icons.menu_settings));
        settings_button_title.setText(appResources.getString(R.strings.menu_settings_title));

        about_us_button.setBackground(appResources.getColor(R.colors.primary));
        about_us_title.setForeground(appResources.getColor(R.colors.white_text));
        about_us_title.setFont(appResources.getFont(R.fonts.roboto_regular, 16));
        about_us_title.setIcon(appResources.getIcon(R.icons.menu_about));
        about_us_title.setText(appResources.getString(R.strings.menu_about_title));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        home_content_layout = new javax.swing.JPanel();
        button_menu = new javax.swing.JPanel();
        start_button = new javax.swing.JPanel();
        start_button_title = new javax.swing.JLabel();
        instructions_button = new javax.swing.JPanel();
        instructions_button_title = new javax.swing.JLabel();
        settings_button = new javax.swing.JPanel();
        settings_button_title = new javax.swing.JLabel();
        about_us_button = new javax.swing.JPanel();
        about_us_title = new javax.swing.JLabel();

        home_content_layout.setBackground(new java.awt.Color(248, 249, 250));

        button_menu.setBackground(new java.awt.Color(248, 249, 250));
        button_menu.setLayout(new java.awt.GridLayout(3, 1, 10, 15));

        start_button.setBackground(new java.awt.Color(1, 87, 155));
        start_button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        start_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                OnStartButton(evt);
            }
        });
        start_button.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 15, 10));

        start_button_title.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        start_button_title.setForeground(new java.awt.Color(255, 255, 255));
        start_button_title.setText("Empezar");
        start_button_title.setIconTextGap(10);
        start_button.add(start_button_title);

        button_menu.add(start_button);

        instructions_button.setBackground(new java.awt.Color(1, 87, 155));
        instructions_button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        instructions_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                OnInstructionsButton(evt);
            }
        });
        instructions_button.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 15, 10));

        instructions_button_title.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        instructions_button_title.setForeground(new java.awt.Color(255, 255, 255));
        instructions_button_title.setText("Instrucciones");
        instructions_button_title.setIconTextGap(10);
        instructions_button.add(instructions_button_title);

        button_menu.add(instructions_button);

        settings_button.setBackground(new java.awt.Color(1, 87, 155));
        settings_button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        settings_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                OnSettingsButton(evt);
            }
        });
        settings_button.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 15, 10));

        settings_button_title.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        settings_button_title.setForeground(new java.awt.Color(255, 255, 255));
        settings_button_title.setText("Configuraciones");
        settings_button_title.setIconTextGap(10);
        settings_button.add(settings_button_title);

        button_menu.add(settings_button);

        about_us_button.setBackground(new java.awt.Color(1, 87, 155));
        about_us_button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        about_us_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                onAboutUsButton(evt);
            }
        });
        about_us_button.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 15, 10));

        about_us_title.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        about_us_title.setForeground(new java.awt.Color(255, 255, 255));
        about_us_title.setText("Acerca de");
        about_us_title.setIconTextGap(10);
        about_us_button.add(about_us_title);

        javax.swing.GroupLayout home_content_layoutLayout = new javax.swing.GroupLayout(home_content_layout);
        home_content_layout.setLayout(home_content_layoutLayout);
        home_content_layoutLayout.setHorizontalGroup(
            home_content_layoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, home_content_layoutLayout.createSequentialGroup()
                .addContainerGap(520, Short.MAX_VALUE)
                .addComponent(button_menu, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69))
            .addGroup(home_content_layoutLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(about_us_button, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        home_content_layoutLayout.setVerticalGroup(
            home_content_layoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(home_content_layoutLayout.createSequentialGroup()
                .addGap(115, 115, 115)
                .addComponent(button_menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
                .addComponent(about_us_button, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(home_content_layout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(home_content_layout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void OnStartButton(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OnStartButton
        ControlInterface controlInterface = new ControlInterface();
        controlInterface.setVisible(true);
        menuActions.closeMainMenu();
    }//GEN-LAST:event_OnStartButton

    private void OnInstructionsButton(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OnInstructionsButton
        menuActions.setInstructionsView();
    }//GEN-LAST:event_OnInstructionsButton

    private void OnSettingsButton(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OnSettingsButton
        menuActions.setSettingView();
    }//GEN-LAST:event_OnSettingsButton

    private void onAboutUsButton(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_onAboutUsButton
        menuActions.setAboutView();
    }//GEN-LAST:event_onAboutUsButton


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel about_us_button;
    private javax.swing.JLabel about_us_title;
    private javax.swing.JPanel button_menu;
    private javax.swing.JPanel home_content_layout;
    private javax.swing.JPanel instructions_button;
    private javax.swing.JLabel instructions_button_title;
    private javax.swing.JPanel settings_button;
    private javax.swing.JLabel settings_button_title;
    private javax.swing.JPanel start_button;
    private javax.swing.JLabel start_button_title;
    // End of variables declaration//GEN-END:variables
}
