package jp.imanaga.sample.batch.service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Transactional
public class TestService {

	@Autowired
	private DataSource dataSource1;

	public void update(boolean flag) throws SQLException {

		try (Connection connection = this.dataSource1.getConnection()) {
			connection.createStatement().executeUpdate("insert into test values(1, 'test')");
			System.out.println("update");
		}

		if (flag) {
			System.err.println("error");
			throw new RuntimeException();
		}

	}
}
