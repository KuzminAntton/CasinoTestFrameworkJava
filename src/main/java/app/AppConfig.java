package app;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class AppConfig {

    private static final String PROPERTIES_FILE = "app_configs.properties";

    private static Properties properties;

    static {
        properties = new Properties();
        try (InputStream inputStream = AppConfig.class.getClassLoader().getResourceAsStream(PROPERTIES_FILE)) {
            if (inputStream != null) {
                properties.load(inputStream);
            } else {
                throw new RuntimeException("Unable to load properties file: " + PROPERTIES_FILE);
            }
        } catch (IOException e) {
            throw new RuntimeException("Error loading properties file: " + PROPERTIES_FILE, e);
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }

    //MGA configs
    public static final String casinoMGA_URL = getProperty("MGA_URL");
    public static final String MGA_login = getProperty("MGA_login");
    public static final String MGA_password = getProperty("MGA_password");

    public static final String ADMIN_URL = getProperty("ADMIN_URL");
    public static final String ADMIN_login = getProperty("ADMIN_login");
    public static final String ADMIN_password = getProperty("ADMIN_password");

}
