package com.fcloud.core.repository.support;

import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.db.DatabaseTypeUtils;
import com.j256.ormlite.jdbc.JdbcDatabaseConnection;
import com.j256.ormlite.support.BaseConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.support.DatabaseConnection;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jdbc.datasource.DataSourceUtils;

import javax.sql.DataSource;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * ormlite中，DatabaseConnection相当于jdbc中的connection，ConnectionSource相当于jdbc中的DataSource
 *
 * @author Ruben Fu
 */
public class OrmliteDataSourceConnectionSource extends BaseConnectionSource implements ConnectionSource {

    private static final Log logger = LogFactory.getLog(OrmliteDataSourceConnectionSource.class);

    private DataSource dataSource;
    private DatabaseType databaseType;
    private String databaseUrl;
    private boolean initialized = false;

    public OrmliteDataSourceConnectionSource(String url, DataSource dataSource) throws SQLException {
        this.databaseUrl = url;
        this.dataSource = dataSource;
        initialize();
    }

    private void checkInitialize() throws SQLException {
        if (!initialized) {
            throw new SQLException(getClass().getSimpleName() + " was not initialized properly");
        }
    }

    public void initialize() throws SQLException {
        if (initialized) {
            return;
        }
        if (dataSource == null) {
            throw new IllegalStateException("dataSource was never set on " + getClass().getSimpleName());
        }
        if (databaseType == null) {
            if (databaseUrl == null) {
                throw new IllegalStateException("either the databaseUri or the databaseType must be set on "
                        + getClass().getSimpleName());
            }
            databaseType = DatabaseTypeUtils.createDatabaseType(databaseUrl);
        }
        databaseType.loadDriver();
        if (databaseUrl != null) {
            databaseType.setDriver(DriverManager.getDriver(databaseUrl));
        }
        initialized = true;
    }

    @Override
    public DatabaseConnection getReadOnlyConnection() throws SQLException {
        if (!initialized) {
            throw new SQLException(getClass().getSimpleName() + ".initialize() was not called");
        }
        return getReadWriteConnection();
    }

    /**
     * 相当于JdbcTemplate中的 Connection con = DataSourceUtils.getConnection(getDataSource());
     */
    @Override
    public DatabaseConnection getReadWriteConnection() throws SQLException {
        checkInitialize();

        DatabaseConnection saved = getSavedConnection();
        if (saved != null) {
            return saved;
        }
        return new JdbcDatabaseConnection(DataSourceUtils.getConnection(dataSource));
    }

    /**
     * 相当于JdbcTemplate中的 DataSourceUtils.releaseConnection(con, getDataSource());
     * @param connection ormlte数据库链接
     * @throws SQLException
     */
    @Override
    public void releaseConnection(DatabaseConnection connection) throws SQLException {
        checkInitialize();
        JdbcDatabaseConnection jdbcConnection = (JdbcDatabaseConnection) connection;
        DataSourceUtils.releaseConnection(jdbcConnection.getInternalConnection(), dataSource);
    }

    @Override
    public boolean saveSpecialConnection(DatabaseConnection connection) throws SQLException {
        checkInitialize();
        return true;
    }

    @Override
    public void clearSpecialConnection(DatabaseConnection connection) {
        try {
            checkInitialize();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void close() throws SQLException {
        checkInitialize();

    }

    @Override
    public void closeQuietly() {
        try {
            close();
        } catch (SQLException e) {
            logger.debug("close DatabaseConnection error", e);
        }
    }

    @Override
    public DatabaseType getDatabaseType() {
        return databaseType;
    }

    @Override
    public boolean isOpen() {
        return true;
    }
}