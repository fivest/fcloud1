package com.fcloud.core.repository.support;

import com.j256.ormlite.support.DatabaseConnection;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.SimpleTransactionStatus;

import java.sql.Savepoint;

/**
 * @author Ruben Fu
 */
public class OrmliteTransactionStatus extends SimpleTransactionStatus implements TransactionStatus {

    private DatabaseConnection connection;

    private boolean hasSavePoint;

    private boolean autoCommitAtStart;

    private Savepoint savePoint = null;

    public OrmliteTransactionStatus() {
        super();
    }

    public OrmliteTransactionStatus(boolean newTransaction) {
        super(newTransaction);
    }

    @Override
    public boolean hasSavepoint() {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void setRollbackOnly() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean isRollbackOnly() {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void flush() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean isCompleted() {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Object createSavepoint() throws TransactionException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void rollbackToSavepoint(Object savepoint) throws TransactionException {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void releaseSavepoint(Object savepoint) throws TransactionException {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
