package interfaces.mainmenu;

import inevaup.dialogs.InfoDialog;
import inevaup.dialogs.InfoDialog.TypeInfoDialog;
import inevaup.dialogs.WarningDialog;
import inevaup.preferences.AppSettings;
import inevaup.preferences.MySettings;
import inevaup.resources.AppResources;
import inevaup.resources.R;
import inevaup.resources.ResourcesPath;
import java.io.File;

public class Settings extends javax.swing.JPanel {
    
    private MenuActions menuActions;
    private AppResources appResources;
    
    public Settings(MenuActions menuActions){
        this.menuActions = menuActions;
        appResources = AppResources.getResources();  
        
        initComponents();
        initCustomResources();
        initGeneralSectionSettings();
        initDataSectionSettings();
        initSimulationSectionSettings();
    }

    private void initCustomResources(){
        
        home_back_button.setBackground(appResources.getColor(R.colors.primary));
        home_back_title.setForeground(appResources.getColor(R.colors.white_text));
        home_back_title.setFont(appResources.getFont(R.fonts.roboto_regular, 16));
        home_back_title.setIcon(appResources.getIcon(R.icons.menu_back_arrow));
        home_back_title.setText(appResources.getString(R.strings.menu_back_home_title));

        save_button.setBackground(appResources.getColor(R.colors.primary));
        save_button_title.setForeground(appResources.getColor(R.colors.white_text));
        save_button_title.setFont(appResources.getFont(R.fonts.roboto_regular, 16));
        save_button_title.setIcon(appResources.getIcon(R.icons.menu_save_settings));
        save_button_title.setText(appResources.getString(R.strings.menu_settings_save));
        
        general_label.setFont(appResources.getFont(R.fonts.montserrat_bold, 16));
        general_label.setText(appResources.getString(R.strings.general_settings_title));
        language_label.setFont(appResources.getFont(R.fonts.roboto_regular, 14));
        language_label.setText(appResources.getString(R.strings.general_settings_subtitle1));
        theme_label.setFont(appResources.getFont(R.fonts.roboto_regular, 14));
        theme_label.setText(appResources.getString(R.strings.general_settings_subtitle2));
        
        data_label.setFont(appResources.getFont(R.fonts.montserrat_bold, 16));
        data_label.setText(appResources.getString(R.strings.datos_settings_title));
        save_history_label.setFont(appResources.getFont(R.fonts.roboto_regular, 14));
        save_history_label.setText(appResources.getString(R.strings.datos_settings_subtitle1));
        save_data_label.setFont(appResources.getFont(R.fonts.roboto_regular, 14));
        save_data_label.setText(appResources.getString(R.strings.datos_settings_subtitle2));
        
        simulation_label.setFont(appResources.getFont(R.fonts.montserrat_bold, 16));
        simulation_label.setText(appResources.getString(R.strings.simulacion_settings_title));
        fps_label.setFont(appResources.getFont(R.fonts.roboto_regular, 14));
        fps_label.setText(appResources.getString(R.strings.fps_title));
        simulation_time_label.setFont(appResources.getFont(R.fonts.roboto_regular, 14));
        simulation_time_label.setText(appResources.getString(R.strings.simulacion_settings_subtitle2));
        collisions_label.setFont(appResources.getFont(R.fonts.roboto_regular, 14));
        collisions_label.setText(appResources.getString(R.strings.simulacion_settings_subtitle3));
        
        
        
    }
    
    private void initGeneralSectionSettings(){
        
        File[] languagesFiles = new File(ResourcesPath.getFullStringsPath()).listFiles();
        for (int i = 0; i < languagesFiles.length; i++) {
            File currentLanguageFile = languagesFiles[i];
            language_combobox.addItem(currentLanguageFile.getName());
            if (currentLanguageFile.getName().
                equals((String)AppSettings.getSettings().getSetting("language"))){
                
                language_combobox.setSelectedIndex(i);
            }
        }
        
        File[] themeFiles = new File(ResourcesPath.getFullThemesPath()).listFiles();
        for (int i = 0; i < themeFiles.length; i++) {
            File currentThemeFile = themeFiles[i];
            theme_combobox.addItem(currentThemeFile.getName());
            if (currentThemeFile.getName().
                equals((String)AppSettings.getSettings().getSetting("theme"))){
                
                theme_combobox.setSelectedIndex(i);
            }
        }
    }

    private void initDataSectionSettings(){
        save_data_checkbutton.setSelected(
            (boolean)AppSettings.getSettings().getSetting("save_data")
        );
        save_history_checkbutton.setSelected(
            (boolean)AppSettings.getSettings().getSetting("save_history_data")
        );
    }

    private void initSimulationSectionSettings(){
        collisions_checkbutton.setSelected(
            (boolean) AppSettings.getSettings().getSetting("collisions")
        );

        String[] fpsOptions = MySettings.OPTIONS_FPS;
        for (int i = 0; i < fpsOptions.length; i++) {
            String item = fpsOptions[i];
            if (item.equals("0")){
                fps_combobox.addItem("Automatico");
            }else{
                fps_combobox.addItem(item);
            }

            if (item.equals((String)AppSettings.getSettings().getSetting("fps"))){
                fps_combobox.setSelectedIndex(i);
            }
        }

        String[] simulationTimeOptions = MySettings.OPTIONS_SIMULATION_TIME;
        for (int i = 0; i < simulationTimeOptions.length; i++) {
            String item = simulationTimeOptions[i];
            simulation_time_combobox.addItem(item);

            if (item.equals(
                (String)AppSettings.getSettings().getSetting("simulation_time"))){
                
                simulation_time_combobox.setSelectedIndex(i);
            }
        }
    }

    private void saveSettings(){
        AppSettings.getSettings().
            updateSetting(
                "language", 
                (String)language_combobox.getSelectedItem()
            );

        AppSettings.getSettings().
            updateSetting(
                "theme", 
                (String)theme_combobox.getSelectedItem()
            );
        
        AppSettings.getSettings().
            updateSetting(
                "save_data", 
                (boolean)save_data_checkbutton.isSelected()
            );

        AppSettings.getSettings().
            updateSetting(
                "save_history_data", 
                (boolean)save_history_checkbutton.isSelected()
            );

        AppSettings.getSettings().
            updateSetting(
                "collisions", 
                (boolean)collisions_checkbutton.isSelected()
            );

        String fpsValue = (String) fps_combobox.getSelectedItem();
        AppSettings.getSettings().
            updateSetting(
                "fps", 
                fpsValue.equals("Automatico") ? "0" : fpsValue
            );

        AppSettings.getSettings().
            updateSetting(
                "simulation_time", 
                (String)simulation_time_combobox.getSelectedItem()
            );
        
        if(!AppSettings.getSettings().saveSettings()){
            InfoDialog errDialog = new InfoDialog(
                null, 
                appResources.getString(R.strings.error_settings_title), 
                appResources.getString(R.strings.error_settings_message), 
                TypeInfoDialog.ERROR_DIALOG);
            errDialog.setVisible(true);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        settings_content_layout = new javax.swing.JPanel();
        save_button = new javax.swing.JPanel();
        save_button_title = new javax.swing.JLabel();
        general_label = new javax.swing.JLabel();
        general_settings_layout = new javax.swing.JPanel();
        language_layout = new javax.swing.JPanel();
        language_label = new javax.swing.JLabel();
        language_combobox = new javax.swing.JComboBox<>();
        theme_layout = new javax.swing.JPanel();
        theme_label = new javax.swing.JLabel();
        theme_combobox = new javax.swing.JComboBox<>();
        data_label = new javax.swing.JLabel();
        data_settings_layout = new javax.swing.JPanel();
        save_history_layout = new javax.swing.JPanel();
        save_history_label = new javax.swing.JLabel();
        save_history_checkbutton = new javax.swing.JCheckBox();
        save_data_layout = new javax.swing.JPanel();
        save_data_label = new javax.swing.JLabel();
        save_data_checkbutton = new javax.swing.JCheckBox();
        simulation_label = new javax.swing.JLabel();
        simulation_settings_layout = new javax.swing.JPanel();
        fps_layout = new javax.swing.JPanel();
        fps_label = new javax.swing.JLabel();
        fps_combobox = new javax.swing.JComboBox<>();
        simulation_time_layout = new javax.swing.JPanel();
        simulation_time_label = new javax.swing.JLabel();
        simulation_time_combobox = new javax.swing.JComboBox<>();
        collisions_layout = new javax.swing.JPanel();
        collisions_label = new javax.swing.JLabel();
        collisions_checkbutton = new javax.swing.JCheckBox();
        home_back_button = new javax.swing.JPanel();
        home_back_title = new javax.swing.JLabel();

        settings_content_layout.setBackground(new java.awt.Color(248, 249, 250));

        save_button.setBackground(new java.awt.Color(1, 87, 155));
        save_button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        save_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                OnSaveButton(evt);
            }
        });
        save_button.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 15, 10));

        save_button_title.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        save_button_title.setForeground(new java.awt.Color(255, 255, 255));
        save_button_title.setText("Guardar");
        save_button_title.setIconTextGap(10);
        save_button.add(save_button_title);

        general_label.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        general_label.setForeground(new java.awt.Color(49, 49, 49));
        general_label.setText("Generales");

        general_settings_layout.setBackground(new java.awt.Color(248, 249, 250));
        general_settings_layout.setLayout(new java.awt.GridLayout(2, 1, 0, 5));

        language_layout.setBackground(new java.awt.Color(248, 249, 250));
        language_layout.setLayout(new java.awt.GridLayout(1, 2));

        language_label.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        language_label.setForeground(new java.awt.Color(49, 49, 49));
        language_label.setText("Lenguaje:");
        language_label.setPreferredSize(new java.awt.Dimension(130, 19));
        language_layout.add(language_label);

        language_combobox.setBackground(new java.awt.Color(248, 249, 250));
        language_combobox.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        language_combobox.setForeground(new java.awt.Color(49, 49, 49));
        language_layout.add(language_combobox);

        general_settings_layout.add(language_layout);

        theme_layout.setBackground(new java.awt.Color(248, 249, 250));
        theme_layout.setLayout(new java.awt.GridLayout(1, 2));

        theme_label.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        theme_label.setForeground(new java.awt.Color(49, 49, 49));
        theme_label.setText("Tema:");
        theme_label.setPreferredSize(new java.awt.Dimension(130, 19));
        theme_layout.add(theme_label);

        theme_combobox.setBackground(new java.awt.Color(248, 249, 250));
        theme_combobox.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        theme_combobox.setForeground(new java.awt.Color(49, 49, 49));
        theme_layout.add(theme_combobox);

        general_settings_layout.add(theme_layout);

        data_label.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        data_label.setForeground(new java.awt.Color(49, 49, 49));
        data_label.setText("Datos");

        data_settings_layout.setBackground(new java.awt.Color(248, 249, 250));
        data_settings_layout.setLayout(new java.awt.GridLayout(2, 1, 0, 5));

        save_history_layout.setBackground(new java.awt.Color(248, 249, 250));
        save_history_layout.setLayout(new java.awt.GridLayout(1, 2));

        save_history_label.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        save_history_label.setForeground(new java.awt.Color(49, 49, 49));
        save_history_label.setText("Guardar Historial:");
        save_history_label.setPreferredSize(new java.awt.Dimension(170, 19));
        save_history_layout.add(save_history_label);

        data_settings_layout.add(save_history_layout);

        save_history_checkbutton.setBackground(new java.awt.Color(248, 249, 250));
        data_settings_layout.add(save_history_checkbutton);

        save_data_layout.setBackground(new java.awt.Color(248, 249, 250));
        save_data_layout.setLayout(new java.awt.GridLayout(1, 2));

        save_data_label.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        save_data_label.setForeground(new java.awt.Color(49, 49, 49));
        save_data_label.setText("Guardar datos csv:");
        save_data_label.setPreferredSize(new java.awt.Dimension(170, 19));
        save_data_layout.add(save_data_label);

        data_settings_layout.add(save_data_layout);

        save_data_checkbutton.setBackground(new java.awt.Color(248, 249, 250));
        data_settings_layout.add(save_data_checkbutton);

        simulation_label.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        simulation_label.setForeground(new java.awt.Color(49, 49, 49));
        simulation_label.setText("Simulacion");

        simulation_settings_layout.setBackground(new java.awt.Color(248, 249, 250));
        simulation_settings_layout.setLayout(new java.awt.GridLayout(3, 1, 0, 5));

        fps_layout.setBackground(new java.awt.Color(248, 249, 250));
        fps_layout.setLayout(new java.awt.GridLayout(1, 2));

        fps_label.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        fps_label.setForeground(new java.awt.Color(49, 49, 49));
        fps_label.setText("FPS:");
        fps_label.setPreferredSize(new java.awt.Dimension(170, 19));
        fps_layout.add(fps_label);

        fps_combobox.setBackground(new java.awt.Color(248, 249, 250));
        fps_combobox.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        fps_combobox.setForeground(new java.awt.Color(49, 49, 49));
        fps_layout.add(fps_combobox);

        simulation_settings_layout.add(fps_layout);

        simulation_time_layout.setBackground(new java.awt.Color(248, 249, 250));
        simulation_time_layout.setLayout(new java.awt.GridLayout(1, 2));

        simulation_time_label.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        simulation_time_label.setForeground(new java.awt.Color(49, 49, 49));
        simulation_time_label.setText("Tiempo de simulacion:");
        simulation_time_label.setPreferredSize(new java.awt.Dimension(130, 19));
        simulation_time_layout.add(simulation_time_label);

        simulation_time_combobox.setBackground(new java.awt.Color(248, 249, 250));
        simulation_time_combobox.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        simulation_time_combobox.setForeground(new java.awt.Color(49, 49, 49));
        simulation_time_layout.add(simulation_time_combobox);

        simulation_settings_layout.add(simulation_time_layout);

        collisions_layout.setBackground(new java.awt.Color(248, 249, 250));
        collisions_layout.setLayout(new java.awt.GridLayout(1, 2));

        collisions_label.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        collisions_label.setForeground(new java.awt.Color(49, 49, 49));
        collisions_label.setText("Colisiones:");
        collisions_label.setPreferredSize(new java.awt.Dimension(170, 19));
        collisions_layout.add(collisions_label);

        collisions_checkbutton.setBackground(new java.awt.Color(248, 249, 250));
        collisions_layout.add(collisions_checkbutton);

        simulation_settings_layout.add(collisions_layout);

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
                .addGap(24, 24, 24)
                .addGroup(settings_content_layoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(settings_content_layoutLayout.createSequentialGroup()
                        .addGroup(settings_content_layoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(data_label)
                            .addComponent(data_settings_layout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(general_settings_layout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(general_label))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                        .addGroup(settings_content_layoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(simulation_settings_layout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(simulation_label))
                        .addGap(61, 61, 61))
                    .addGroup(settings_content_layoutLayout.createSequentialGroup()
                        .addComponent(home_back_button, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(save_button, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29))))
        );
        settings_content_layoutLayout.setVerticalGroup(
            settings_content_layoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(settings_content_layoutLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(settings_content_layoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(settings_content_layoutLayout.createSequentialGroup()
                        .addComponent(simulation_label)
                        .addGap(18, 18, 18)
                        .addComponent(simulation_settings_layout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(settings_content_layoutLayout.createSequentialGroup()
                        .addComponent(general_label)
                        .addGap(18, 18, 18)
                        .addComponent(general_settings_layout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(data_label)
                        .addGap(18, 18, 18)
                        .addComponent(data_settings_layout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 94, Short.MAX_VALUE)
                .addGroup(settings_content_layoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(home_back_button, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(save_button, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33))
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

    private void OnSaveButton(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OnSaveButton
        WarningDialog warnDialog = new WarningDialog(
                null, 
                appResources.getString(R.strings.warn_title_interface), 
                appResources.getString(R.strings.warn_settings_save_message)

            );
        warnDialog.setFont(appResources.getFont(R.fonts.roboto_regular, 16));
        warnDialog.setVisible(true);
        
        if(warnDialog.IsWarningAccepted()){
            saveSettings();
        }
    }//GEN-LAST:event_OnSaveButton

    private void OnBackHomeButton(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OnBackHomeButton
        menuActions.setHomeView();
    }//GEN-LAST:event_OnBackHomeButton


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox collisions_checkbutton;
    private javax.swing.JLabel collisions_label;
    private javax.swing.JPanel collisions_layout;
    private javax.swing.JLabel data_label;
    private javax.swing.JPanel data_settings_layout;
    private javax.swing.JComboBox<String> fps_combobox;
    private javax.swing.JLabel fps_label;
    private javax.swing.JPanel fps_layout;
    private javax.swing.JLabel general_label;
    private javax.swing.JPanel general_settings_layout;
    private javax.swing.JPanel home_back_button;
    private javax.swing.JLabel home_back_title;
    private javax.swing.JComboBox<String> language_combobox;
    private javax.swing.JLabel language_label;
    private javax.swing.JPanel language_layout;
    private javax.swing.JPanel save_button;
    private javax.swing.JLabel save_button_title;
    private javax.swing.JCheckBox save_data_checkbutton;
    private javax.swing.JLabel save_data_label;
    private javax.swing.JPanel save_data_layout;
    private javax.swing.JCheckBox save_history_checkbutton;
    private javax.swing.JLabel save_history_label;
    private javax.swing.JPanel save_history_layout;
    private javax.swing.JPanel settings_content_layout;
    private javax.swing.JLabel simulation_label;
    private javax.swing.JPanel simulation_settings_layout;
    private javax.swing.JComboBox<String> simulation_time_combobox;
    private javax.swing.JLabel simulation_time_label;
    private javax.swing.JPanel simulation_time_layout;
    private javax.swing.JComboBox<String> theme_combobox;
    private javax.swing.JLabel theme_label;
    private javax.swing.JPanel theme_layout;
    // End of variables declaration//GEN-END:variables
}
