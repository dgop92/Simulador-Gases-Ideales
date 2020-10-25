package inevaup.preferences;

public class MainSettingsTest {

    public static void main(String[] args) {

        AppSettings settings = AppSettings.getSettings();
        settings.loadSettings();
        System.out.println(settings.getErrorMessage());

        if (settings.isSettingsLoaded) {
            System.out.println(settings.getSetting("fps"));
            settings.updateSetting("fps", 60);
            System.out.println(settings.getSetting("fps"));
            try {
                settings.saveSettings();
            } catch (SaveException e) {
                e.printStackTrace();
            }
        }

    }
}
