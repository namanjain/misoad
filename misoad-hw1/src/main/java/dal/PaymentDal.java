package dal;

import common.Payment;
import org.hibernate.Session;
import utils.HibernateUtils;

public class PaymentDal {

    HibernateDal hibernateDal = new HibernateDal();

    public Payment getPayment(Integer paymentId) {
        Session session = null;
        try {
            session = HibernateUtils.getSession();
            return (Payment) session.get(Payment.class, paymentId);
        } finally {
            HibernateUtils.returnSession(session);
        }
    }

    public Integer insertPayment(Payment payment) {
        return hibernateDal.insert(payment);
    }

    public void updatePayment(Payment payment) {
        hibernateDal.update(payment);
    }

    public void deletePayment(Integer paymentId)  {
        Payment payment = new Payment();
        payment.setPaymentId(paymentId);
        hibernateDal.delete(payment);
    }
}
