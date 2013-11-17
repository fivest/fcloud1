package com.fcloud.core.repository.support;

import org.springframework.transaction.TransactionException;

/**
 * @author Ruben Fu
 */
public class OrmliteTransactionException extends TransactionException {

    public OrmliteTransactionException(String msg) {
        super(msg);
    }

    public OrmliteTransactionException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
