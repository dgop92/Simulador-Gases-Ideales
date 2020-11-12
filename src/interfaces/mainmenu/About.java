package interfaces.mainmenu;

import inevaup.resources.AppResources;
import inevaup.resources.R;

public class About extends javax.swing.JPanel {

    private MenuActions menuActions;
    private AppResources appResources;

    public About(MenuActions menuActions){
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

        dev_title.setFont(AppResources.getAppResources().getFont(R.fonts.montserrat_bold, 16));
        dev_title.setForeground(appResources.getColor(R.colors.primary_text));
        dev_title.setText(appResources.getString(R.strings.menu_about_devs_title));

        dev_1_label.setFont(AppResources.getAppResources().getFont(R.fonts.roboto_regular, 16));
        dev_1_label.setForeground(appResources.getColor(R.colors.primary_text));
        dev_1_label.setText(appResources.getString(R.strings.menu_about_dev_1));

        dev_2_label.setFont(AppResources.getAppResources().getFont(R.fonts.roboto_regular, 16));
        dev_2_label.setForeground(appResources.getColor(R.colors.primary_text));
        dev_2_label.setText(appResources.getString(R.strings.menu_about_dev_2));

        dev_3_label.setFont(AppResources.getAppResources().getFont(R.fonts.roboto_regular, 16));
        dev_3_label.setForeground(appResources.getColor(R.colors.primary_text));
        dev_3_label.setText(appResources.getString(R.strings.menu_about_dev_3));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        about_content_layout = new javax.swing.JPanel();
        home_back_button = new javax.swing.JPanel();
        home_back_title = new javax.swing.JLabel();
        dev_title = new javax.swing.JLabel();
        devs_layout = new javax.swing.JPanel();
        dev_1_label = new javax.swing.JLabel();
        dev_2_label = new javax.swing.JLabel();
        dev_3_label = new javax.swing.JLabel();

        about_content_layout.setBackground(new java.awt.Color(248, 249, 250));

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

        dev_title.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        dev_title.setForeground(new java.awt.Color(49, 49, 49));
        dev_title.setText("Desarolladores");

        devs_layout.setBackground(new java.awt.Color(248, 249, 250));
        devs_layout.setLayout(new java.awt.GridLayout(3, 1, 0, 6));

        dev_1_label.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        dev_1_label.setForeground(new java.awt.Color(49, 49, 49));
        dev_1_label.setText("Diego Puche");
        dev_1_label.setPreferredSize(new java.awt.Dimension(130, 19));
        devs_layout.add(dev_1_label);

        dev_2_label.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        dev_2_label.setForeground(new java.awt.Color(49, 49, 49));
        dev_2_label.setText("Juan Anzola");
        dev_2_label.setPreferredSize(new java.awt.Dimension(130, 19));
        devs_layout.add(dev_2_label);

        dev_3_label.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        dev_3_label.setForeground(new java.awt.Color(49, 49, 49));
        dev_3_label.setText("Mateo Anaya");
        dev_3_label.setPreferredSize(new java.awt.Dimension(130, 19));
        devs_layout.add(dev_3_label);

        javax.swing.GroupLayout about_content_layoutLayout = new javax.swing.GroupLayout(about_content_layout);
        about_content_layout.setLayout(about_content_layoutLayout);
        about_content_layoutLayout.setHorizontalGroup(
            about_content_layoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(about_content_layoutLayout.createSequentialGroup()
                .addGroup(about_content_layoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(about_content_layoutLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(dev_title))
                    .addGroup(about_content_layoutLayout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(devs_layout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(about_content_layoutLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(home_back_button, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(615, Short.MAX_VALUE))
        );
        about_content_layoutLayout.setVerticalGroup(
            about_content_layoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(about_content_layoutLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(dev_title)
                .addGap(18, 18, 18)
                .addComponent(devs_layout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 212, Short.MAX_VALUE)
                .addComponent(home_back_button, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(about_content_layout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(about_content_layout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void OnBackHomeButton(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OnBackHomeButton
        menuActions.setHomeView();
    }//GEN-LAST:event_OnBackHomeButton


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel about_content_layout;
    private javax.swing.JLabel dev_1_label;
    private javax.swing.JLabel dev_2_label;
    private javax.swing.JLabel dev_3_label;
    private javax.swing.JLabel dev_title;
    private javax.swing.JPanel devs_layout;
    private javax.swing.JPanel home_back_button;
    private javax.swing.JLabel home_back_title;
    // End of variables declaration//GEN-END:variables
}
