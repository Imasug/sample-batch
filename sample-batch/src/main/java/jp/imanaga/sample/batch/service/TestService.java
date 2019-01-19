package jp.imanaga.sample.batch.service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

public class TestService {

	private DataSource dataSource1;

	public void setDataSource1(DataSource dataSource) {
		this.dataSource1 = dataSource;
	}

	public void update() throws SQLException {

		try (Connection connection = this.dataSource1.getConnection()) {
			connection.createStatement().executeUpdate("insert into test values(1, 'test')");
			System.out.println("test");
		}

	}
}
