package com.hascode.ejb;

import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.sql.DataSource;

import com.googlecode.flyway.core.Flyway;
import com.googlecode.flyway.core.api.MigrationInfo;

@Singleton
@Startup
public class JeeDbMigrator {
	private final Logger log = Logger.getLogger(JeeDbMigrator.class.getName());

	@Resource(name = "jdbc/__default")
	private DataSource dataSource;

	@PostConstruct
	private void onStartup() {
		Flyway flyway = new Flyway();
		flyway.setSchemas("book_database");
		flyway.setDataSource(dataSource);
		flyway.setInitOnMigrate(true);
		for (MigrationInfo i : flyway.info().all()) {
			log.info("migrate task: " + i.getVersion() + " : "
					+ i.getDescription() + " with query: " + i.getScript());
		}
	}
}
