package APIFrame.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;



public class ApiConfigManager {

    private static Properties apiprop;

     
    public static Properties APIReadProperties() {
        try {
            InputStream input = new FileInputStream("src/test/resources/configuration.properties");
            apiprop = new Properties();
            apiprop.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return apiprop;
    }
}
