package connection;

import java.util.ResourceBundle;

public class DatabaseResourceManager {
    private final static DatabaseResourceManager instance = new DatabaseResourceManager();
    private ResourceBundle bundle = ResourceBundle.getBundle("database");

    public static DatabaseResourceManager getInstance() {
        return instance;
    }

    public String getValue(String key){
        return bundle.getString(key);
    }
}
