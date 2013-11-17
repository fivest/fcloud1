package com.fcloud.core.repository.support;

import com.j256.ormlite.support.ConnectionSource;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.TransactionStatus;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Ruben Fu
 */
public class OrmliteTransactionManager implements PlatformTransactionManager {

    private static Log logger = LogFactory.getLog(OrmliteTransactionManager.class);

    private static final String SAVE_POINT_PREFIX = "ORMLITE";

    private static AtomicInteger savePointCounter = new AtomicInteger();

    @Autowired
    private ConnectionSource connectionSource;

    @Override
    public TransactionStatus getTransaction(TransactionDefinition definition) throws TransactionException {
//        DatabaseConnection connection = connectionSource.getReadWriteConnection();
//        boolean saved = connectionSource.saveSpecialConnection(connection);
//        boolean autoCommitAtStart = false;
//        boolean hasSavePoint = false;
//        Savepoint savePoint = null;
//        DatabaseType databaseType = connectionSource.getDatabaseType()
//        if (saved || databaseType.isNestedSavePointsSupported()) {
//            if (connection.isAutoCommitSupported()) {
//                autoCommitAtStart = connection.isAutoCommit();
//                if (autoCommitAtStart) {
//                    // disable auto-commit mode if supported and enabled at start
//                    connection.setAutoCommit(false);
//                    logger.debug("had to set auto-commit to false");
//                }
//            }
//            savePoint = connection.setSavePoint(SAVE_POINT_PREFIX + savePointCounter.incrementAndGet());
//            if (savePoint == null) {
//                logger.debug("started savePoint transaction");
//            } else {
//                logger.debug("started savePoint transaction {}", savePoint.getSavepointName());
//            }
//            hasSavePoint = true;
//        }

        OrmliteTransactionStatus status = new OrmliteTransactionStatus();
        // set

        return status;
    }

    private void doFinally(OrmliteTransactionStatus status) {

    }

    @Override
    public void commit(TransactionStatus status) throws TransactionException {
        throw new UnsupportedOperationException("unsupport commit method to manager transaction ! ");
    }

    @Override
    public void rollback(TransactionStatus status) throws TransactionException {
        throw new UnsupportedOperationException("unsupport rollback method to manager transaction ! ");
    }
}
