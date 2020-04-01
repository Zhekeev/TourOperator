package connection;

import java.util.ResourceBundle;

public class DataBaseResourceManager {
    private final static DataBaseResourceManager instance = new DataBaseResourceManager();
    private ResourceBundle bundle = ResourceBundle.getBundle("database");

    public static DataBaseResourceManager getInstance() {
        return instance;
    }

    public String getValue(String key){
        return bundle.getString(key);
    }
}
