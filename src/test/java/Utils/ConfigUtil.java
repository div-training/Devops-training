package Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigUtil {
    public static String getValue(String name) throws IOException {
        Properties prop = new Properties();
        InputStream input = null;
        String propValue = "";
        try {
            input = new FileInputStream("src/test/resources/config.properties");
            prop.load(input);
            propValue = prop.getProperty(name);
        } catch (Exception e) {
            System.out.println("Exception" + e);
        } finally {
            input.close();
        }
        return propValue;
    }
}

