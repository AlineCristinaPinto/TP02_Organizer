package br.cefetmg.inf.util.db;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Eduardo Cotta
 */
public interface ConnectionFactory {
    public Connection getConnection() throws ClassNotFoundException, SQLException;
}
