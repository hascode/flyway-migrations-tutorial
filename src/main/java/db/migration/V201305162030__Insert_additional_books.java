package db.migration;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.googlecode.flyway.core.api.migration.jdbc.JdbcMigration;

public class V201305162030__Insert_additional_books implements JdbcMigration {

	@Override
	public void migrate(final Connection con) throws Exception {
		PreparedStatement statement = con
				.prepareStatement("INSERT INTO Book (id, title) VALUES (4, 'You wont believe it - the fourth book')");
		statement.execute();
	}

}
