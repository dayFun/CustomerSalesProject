package myProject.dao;

import java.util.prefs.Preferences;

import javax.sql.DataSource;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class DataSourceFactory {


    public static DataSource getMySqlDataSource() {
        Preferences prefs = Preferences.userRoot();
        prefs = prefs.node("myProject/dao/preferences");

        MysqlDataSource mySqlDataSource = new MysqlDataSource();
        mySqlDataSource.setURL(prefs.get("url", ""));
        mySqlDataSource.setUser(prefs.get("user", ""));
        mySqlDataSource.setPassword(prefs.get("password", ""));

        return mySqlDataSource;
    }

}
