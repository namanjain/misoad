package dal;

import common.Rental;
import org.hibernate.Session;
import utils.HibernateUtils;

public class RentalDal {

    HibernateDal hibernateDal = new HibernateDal();

    public Rental getRental(Integer rentalId) {
        Session session = null;
        try {
            session = HibernateUtils.getSession();
            return (Rental) session.get(Rental.class, rentalId);
        } finally {
            HibernateUtils.returnSession(session);
        }
    }

    public Integer insertRental(Rental rental) {
        return hibernateDal.insert(rental);
    }

    public void updateRental(Rental rental) {
        hibernateDal.update(rental);
    }

    public void deleteRental(Integer rentalId) {
        Rental rental = new Rental();
        rental.setRentalId(rentalId);
        hibernateDal.delete(rental);
    }
}
