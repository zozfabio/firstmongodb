package br.com.mycompany.manager;

import br.com.mycompany.entity.CidadeEntity;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
/**
 * Controlador para cidades
 *
 * @author Fabio Zoz
 * @since 07/02/2013
 */
@Path("/cidade")
public class CidadeManager extends AbstractManager {

    private DBCollection coll;

    private List<CidadeEntity> cidades = new ArrayList();

    protected DBCollection getCollection() {
        return coll == null ? getCollection("cidade") : coll;
    }

    @GET
    @Path("/getall")
    @Produces(MediaType.APPLICATION_JSON)
    public List getAll() {
        DBCursor cur = getCollection().find();
        while (cur.hasNext()) {
            CidadeEntity cidade = new CidadeEntity();
            cidade.setDbObject(cur.next());
            cidades.add(cidade);
        }
        return cidades;
    }

    @POST
    @Path("/save")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public List save(CidadeEntity cidade) {
        CidadeEntity update = new CidadeEntity();
        update.setCodigo(cidade.getCodigo());
        BasicDBObject dbObject = (BasicDBObject) getCollection().findOne(update.getDbObject());
        if ((dbObject != null) && !dbObject.getString("_id").isEmpty()) {
            dbObject.put("nome", cidade.getNome());
        } else {
            dbObject = cidade.getDbObject();
        }
        getCollection().save(dbObject);
        return getAll();
    }

    @POST
    @Path("/remove/{codigo}")
    @Produces(MediaType.APPLICATION_JSON)
    public List remove(@PathParam("codigo") Integer codigo) {
        CidadeEntity remove = new CidadeEntity();
        remove.setCodigo(codigo);
        getCollection().remove(remove.getDbObject());
        return getAll();
    }
}