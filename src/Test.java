import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by niko on 05/11/15.
 */
public class Test {
    public static void main(String[] args) {
        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("NewPersistenceUnit");
        EntityManager entitymanager = emfactory.createEntityManager();
        String login = "pupsik";
        Query query = entitymanager.createQuery("select u.id from Users u where login = :login");
        query.setParameter("login",login);
        List<Integer> result = query.getResultList();
        for(Integer u : result) {
            System.out.println(u);
        }
    }
}
