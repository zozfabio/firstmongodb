package br.com.mycompany.entity;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
/**
 * Entidade abstrata
 *
 * @author Fabio Zoz
 * @since 07/02/2013
 */
abstract class AbstractEntity {

    protected transient BasicDBObject dbObject = new BasicDBObject();

    public BasicDBObject getDbObject() {
        return dbObject;
    }

    public AbstractEntity setDbObject(BasicDBObject dbObject) {
        this.dbObject = dbObject;
        return this;
    }

    public AbstractEntity setDbObject(DBObject dbObject) {
        return setDbObject((BasicDBObject)dbObject);
    }
}