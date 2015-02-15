package initialize;

import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;
import config.HW1Configuration;
import web.resources.StaffResource;

import java.util.HashMap;

/**
 * Created by naman on 2/2/15.
 */
public class HW1Application extends Service<HW1Configuration> {

    public static void main(String[] args) throws Exception {
        new HW1Application().run(args);

//        System.out.println("Maven + Hibernate + MySQL");
//        Session session = HibernateUtil.getSessionFactory().openSession();

//        session.beginTransaction();

//        Staff staff = new Staff();
//        staff.setStaffId(4715);
//        staff.setFirstName("Naman");
//        staff.setLastName("Jain");

       /* Store store = new Store();
        store.setStoreId(1);
        store.setManagerId(4715);
        store.setAddress("Columbia University");

        Rental rental = new Rental();
        rental.setRentalId(4);
        rental.setRentalDate(new Date(2015, 2, 1));
        rental.setInventoryId(50);
        rental.setCustomerId(12);
        rental.setReturnDate(new Date(2015, 2, 3));
        rental.setStaffId(4715);

        Payment payment = new Payment();
        payment.setPaymentId(100);
        payment.setCustomerId(12);
        payment.setStaffId(4715);
        payment.setRentalId(4);
        payment.setAmount(1500.00);
        payment.setPaymentDate(new Date(2015, 2, 4));
*/
//        session.save(staff);
//        session.save(store);
//        session.save(rental);
//        session.save(payment);

//        session.getTransaction().commit();
        HashMap<String, String> map = new HashMap<String, String>();
        HashMap<String, String> map2 = new HashMap<String, String>();
        map.equals(map2);
    }

    @Override
    public void initialize(Bootstrap<HW1Configuration> hw1ConfigurationBootstrap) {

    }

    @Override
    public void run(HW1Configuration hw1Configuration, Environment environment) throws Exception {
        final StaffResource resource = new StaffResource();
        environment.addResource(resource);
    }
}
