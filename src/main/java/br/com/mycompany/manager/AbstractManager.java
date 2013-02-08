package br.com.mycompany.manager;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;
import java.net.UnknownHostException;

/**
 * Controller abstrato
 *
 * @author Fabio Zoz
 * @since 07/02/2013
 */
public class AbstractManager {

    private DB db = null;

    private DB getDatabase(String database) {
        if (db == null) {
            try {
                Mongo conn = new Mongo("127.0.0.1", 27017);
                db = conn.getDB(database);
            }
            catch(UnknownHostException ex) {
                System.out.println("Erro ao conectar com o MongoDB");
                ex.printStackTrace();
            }
        }
        return db;
    }

    protected DBCollection getCollection(String collection) {
        return getDatabase("firstnosql").getCollection(collection);
    }
}