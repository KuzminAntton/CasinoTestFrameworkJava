package helpers;

public class TestConfig {

    public static String browser = "chrome";

    public static String platform = "mac";
    public static String headless = "0";

    public static String remote = "0";

    public static void initConfig() {
        browser = System.getProperty("browser") == null ? "chrome" : System.getProperty("browser");
        platform = System.getProperty("platform") == null ? "mac" : System.getProperty("platform");
        headless = System.getProperty("headless") == null ? "0" : System.getProperty("headless");
        remote = System.getProperty("remote") == null ? "0" : System.getProperty("remote");
    }

    public static boolean isHeadless() {
        return headless.contains("1");
    }

    public static boolean isRemote() {
        return remote.contains("1");
    }
}
