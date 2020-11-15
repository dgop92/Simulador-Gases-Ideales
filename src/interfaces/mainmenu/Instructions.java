package interfaces.mainmenu;

import inevaup.resources.AppResources;
import inevaup.resources.R;

public class Instructions extends javax.swing.JPanel {

    private MenuActions menuActions;
    private AppResources appResources;

    public Instructions(MenuActions menuActions){
        this.menuActions = menuActions;
        appResources = AppResources.getResources();

        initComponents();
        initCustomResources();
    }

    private void initCustomResources(){

        home_back_button.setBackground(appResources.getColor(R.colors.primary));
        home_back_title.setForeground(appResources.getColor(R.colors.white_text));
        home_back_title.setFont(appResources.getFont(R.fonts.roboto_regular, 16));
        home_back_title.setIcon(appResources.getIcon(R.icons.menu_back_arrow));
        home_back_title.setText(appResources.getString(R.strings.menu_back_home_title));
        
        advice_label.setIcon(appResources.getIcon(R.icons.advice));
        advice_label.setForeground(appResources.getColor(R.colors.primary_text));
        advice_label.setFont(appResources.getFont(R.fonts.roboto_regular, 14));
        advice_label.setText(appResources.getString(R.strings.firt_advisor));
        
        part1_label.setForeground(appResources.getColor(R.colors.white_text));
        part1_label.setFont(appResources.getFont(R.fonts.roboto_regular, 14));
        
        part2_label.setForeground(appResources.getColor(R.colors.white_text));
        part2_label.setFont(appResources.getFont(R.fonts.roboto_regular, 14));
        
        image_label.setIcon(appResources.getImage(R.images.parte1));
        image_label2.setIcon(appResources.getImage(R.images.part2));
        
        text_label1.setIcon(appResources.getIcon(R.icons.advice));
        text_label1.setForeground(appResources.getColor(R.colors.primary_text));
        text_label1.setFont(appResources.getFont(R.fonts.roboto_regular, 14));
        text_label1.setText(appResources.getString(R.strings.second_adivisor));
        
        
        text_label2.setIcon(appResources.getIcon(R.icons.history_icon));
        text_label2.setForeground(appResources.getColor(R.colors.primary_text));
        text_label2.setFont(appResources.getFont(R.fonts.roboto_regular, 14));
        text_label2.setText(appResources.getString(R.strings.third_advisor));
        
        
        text_label3.setIcon(appResources.getIcon(R.icons.advice));
        text_label3.setForeground(appResources.getColor(R.colors.primary_text));
        text_label3.setFont(appResources.getFont(R.fonts.roboto_regular, 14));
        text_label3.setText(appResources.getString(R.strings.Four_advisor));
        
        text_label4.setIcon(appResources.getIcon(R.icons.control_play_pause));
        text_label4.setForeground(appResources.getColor(R.colors.primary_text));
        text_label4.setFont(appResources.getFont(R.fonts.roboto_regular, 14));
        text_label4.setText(appResources.getString(R.strings.fifth_advisor));
        
        text_label5.setIcon(appResources.getIcon(R.icons.control_reset));
        text_label5.setForeground(appResources.getColor(R.colors.primary_text));
        text_label5.setFont(appResources.getFont(R.fonts.roboto_regular, 14));
        text_label5.setText(appResources.getString(R.strings.six_advisor));
        
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        settings_content_layout = new javax.swing.JPanel();
        home_back_button = new javax.swing.JPanel();
        home_back_title = new javax.swing.JLabel();
        text_label1 = new javax.swing.JLabel();
        part1_panel = new javax.swing.JPanel();
        part1_label = new javax.swing.JLabel();
        text_label2 = new javax.swing.JLabel();
        image_label2 = new javax.swing.JLabel();
        part2_panel = new javax.swing.JPanel();
        part2_label = new javax.swing.JLabel();
        text_label3 = new javax.swing.JLabel();
        text_label5 = new javax.swing.JLabel();
        text_label4 = new javax.swing.JLabel();
        advice_label = new javax.swing.JLabel();
        image_label = new javax.swing.JLabel();

        settings_content_layout.setBackground(new java.awt.Color(255, 255, 255));

        home_back_button.setBackground(new java.awt.Color(1, 87, 155));
        home_back_button.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
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

        text_label1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        text_label1.setForeground(new java.awt.Color(1, 87, 155));
        text_label1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/data/icons/advice.png"))); // NOI18N
        text_label1.setText("En esta parte podras ingresar los datos iniciales y finales segun su rango.");

        part1_panel.setBackground(new java.awt.Color(1, 87, 155));

        part1_label.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        part1_label.setForeground(new java.awt.Color(255, 255, 255));
        part1_label.setText("1");
        part1_panel.add(part1_label);

        text_label2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        text_label2.setForeground(new java.awt.Color(1, 87, 155));
        text_label2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/data/icons/history_icon.png"))); // NOI18N
        text_label2.setText("Si haces click aqui puedes ver el historial de datos ingresados.");

        image_label2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/data/images/part2.png"))); // NOI18N

        part2_panel.setBackground(new java.awt.Color(1, 87, 155));

        part2_label.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        part2_label.setForeground(new java.awt.Color(255, 255, 255));
        part2_label.setText("2");
        part2_panel.add(part2_label);

        text_label3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        text_label3.setForeground(new java.awt.Color(1, 87, 155));
        text_label3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/data/icons/advice.png"))); // NOI18N
        text_label3.setText("En esta parte podras elegir el tipo de transformacion de su preferencia.");

        text_label5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        text_label5.setForeground(new java.awt.Color(1, 87, 155));
        text_label5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/data/icons/control-reset.png"))); // NOI18N
        text_label5.setText("Si haces click aqui podras reiniciar o comenzar la simulacion.");

        text_label4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        text_label4.setForeground(new java.awt.Color(1, 87, 155));
        text_label4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/data/icons/control-play-pause.png"))); // NOI18N
        text_label4.setText("Si haces click aqui podras pausar o resumir la simulacion.");

        advice_label.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        advice_label.setForeground(new java.awt.Color(1, 87, 155));
        advice_label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/data/icons/advice.png"))); // NOI18N
        advice_label.setText("Como podras ver mas adelante, la interfaz de control esta dividida en dos partes");

        image_label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/data/images/parte1.png"))); // NOI18N

        javax.swing.GroupLayout settings_content_layoutLayout = new javax.swing.GroupLayout(settings_content_layout);
        settings_content_layout.setLayout(settings_content_layoutLayout);
        settings_content_layoutLayout.setHorizontalGroup(
            settings_content_layoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(settings_content_layoutLayout.createSequentialGroup()
                .addGroup(settings_content_layoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(settings_content_layoutLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(settings_content_layoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(settings_content_layoutLayout.createSequentialGroup()
                                .addComponent(part1_panel, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(image_label))
                            .addGroup(settings_content_layoutLayout.createSequentialGroup()
                                .addComponent(part2_panel, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(image_label2)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(settings_content_layoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(text_label3)
                            .addComponent(text_label1)
                            .addComponent(text_label2)
                            .addComponent(text_label5)
                            .addComponent(text_label4)))
                    .addGroup(settings_content_layoutLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(advice_label))
                    .addGroup(settings_content_layoutLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(home_back_button, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        settings_content_layoutLayout.setVerticalGroup(
            settings_content_layoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(settings_content_layoutLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(advice_label)
                .addGroup(settings_content_layoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(settings_content_layoutLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(text_label1)
                        .addGap(18, 18, 18)
                        .addComponent(text_label2))
                    .addGroup(settings_content_layoutLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(image_label))
                    .addGroup(settings_content_layoutLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(part1_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(settings_content_layoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(part2_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(image_label2)
                    .addGroup(settings_content_layoutLayout.createSequentialGroup()
                        .addComponent(text_label3)
                        .addGap(10, 10, 10)
                        .addComponent(text_label4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(text_label5)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(home_back_button, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(settings_content_layout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(settings_content_layout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void OnBackHomeButton(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OnBackHomeButton
        menuActions.setHomeView();
    }//GEN-LAST:event_OnBackHomeButton


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel advice_label;
    private javax.swing.JPanel home_back_button;
    private javax.swing.JLabel home_back_title;
    private javax.swing.JLabel image_label;
    private javax.swing.JLabel image_label2;
    private javax.swing.JLabel part1_label;
    private javax.swing.JPanel part1_panel;
    private javax.swing.JLabel part2_label;
    private javax.swing.JPanel part2_panel;
    private javax.swing.JPanel settings_content_layout;
    private javax.swing.JLabel text_label1;
    private javax.swing.JLabel text_label2;
    private javax.swing.JLabel text_label3;
    private javax.swing.JLabel text_label4;
    private javax.swing.JLabel text_label5;
    // End of variables declaration//GEN-END:variables
}
