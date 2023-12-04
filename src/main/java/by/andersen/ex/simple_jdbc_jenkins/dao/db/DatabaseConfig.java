package by.andersen.ex.simple_jdbc_jenkins.dao.db;

import java.util.Properties;

public class DatabaseConfig {
    private static final Properties properties = new Properties();

    static {
        try {
            loadConfig();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(5);
        }
    }

    private static void loadConfig() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");

        properties.setProperty("db.url","jdbc:mysql://192.168.0.109:3306/users");
        properties.setProperty("db.username", "tomcat");
        properties.setProperty("db.password", "A!MpELmhW0Ve");

//       // String url = System.getenv("JENKINS_FIRST_JDBC_DB_URL");
//        String url = System.getProperty("DB_URL");
//     //   String username = System.getenv("JENKINS_FIRST_JDBC_DB_USERNAME");
//        String username = System.getProperty("DB_USERNAME");
//      //  String password = System.getenv("JENKINS_FIRST_JDBC_DB_PASSWORD");
//        String password;
//System.out.println(url + " " + username +" " + password);
//        if (url != null && username != null && password != null) {
//            properties.setProperty("db.url", url);
//            properties.setProperty("db.username", username);
//            properties.setProperty("db.password", password);
//        } else {
//       //     throw new Exception("Database configuration not found in environment variables!");
//
//            //TODO
//
//            //TODO
//
//        }
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

