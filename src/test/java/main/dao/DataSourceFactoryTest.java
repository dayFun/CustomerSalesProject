package main.dao;

import javax.sql.DataSource;

import main.dao.DataSourceFactory;

import org.junit.Test;

public class DataSourceFactoryTest {

	@Test
	public void testDataSourceFactoryReturnsConnection() throws Exception {
		DataSource mySqlDataSource = DataSourceFactory.getMySqlDataSource();
		mySqlDataSource.getConnection();
	}
}
