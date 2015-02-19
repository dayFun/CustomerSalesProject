package myProject.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javax.sql.DataSource;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class DataSourceFactory {

	public static DataSource getMySqlDataSource() {
		Properties properties = new Properties();
		FileInputStream fileInputStream = null;
		MysqlDataSource mySqlDataSource = null;

		try {
			fileInputStream = new FileInputStream("src/main/resources/db.properties");
			properties.load(fileInputStream);
			mySqlDataSource = new MysqlDataSource();
			mySqlDataSource.setURL(properties.getProperty("MYSQL_DB_URL"));
			mySqlDataSource.setUser(properties.getProperty("MYSQL_DB_USERNAME"));
			mySqlDataSource.setPassword(properties.getProperty("MYSQL_DB_PASSWORD"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return mySqlDataSource;
	}
}
