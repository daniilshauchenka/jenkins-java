package by.andersen.ex.simple_jdbc_jenkins.dao.db;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class DatabaseConfigProperties {
    private static final Properties properties = new Properties();

    static {
        try {
            loadConfig();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void loadConfig() throws IOException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");


        try (InputStream input = DatabaseConfigProperties.class.getClassLoader().getResourceAsStream("db.properties")) {

            if (input != null) {
                System.out.println("db prop connected");
                properties.load(input);
            } else {
                throw new IOException("Database configuration not found!");
            }
        }
    }


    public static String getUrl() {
        return properties.getProperty("db.url");
    }

    public static String getUsername() {
        return properties.getProperty("db.username");
    }

    public static String getPassword() {
        return properties.getProperty("db.password");
    }
}
