package com.hascode.ejb;

import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.EJBException;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.sql.DataSource;

import com.googlecode.flyway.core.Flyway;
import com.googlecode.flyway.core.api.MigrationInfo;

@Singleton
@Startup
public class JeeDbMigrator {
	private final Logger log = Logger.getLogger(getClass().getName());

	@Resource(lookup = "jdbc/__default")
	private DataSource dataSource;

	@PostConstruct
	private void onStartup() {
		if (dataSource == null) {
			log.severe("no datasource found to execute the db migrations!");
			throw new EJBException("no datasource found to execute the db migrations!");
		}

		Flyway flyway = new Flyway();
		flyway.setInitOnMigrate(true);
		flyway.setDataSource(dataSource);
		for (MigrationInfo i : flyway.info().all()) {
			log.info("migrate task: " + i.getVersion() + " : " + i.getDescription() + " from file: " + i.getScript());
		}
		flyway.migrate();
	}
}
