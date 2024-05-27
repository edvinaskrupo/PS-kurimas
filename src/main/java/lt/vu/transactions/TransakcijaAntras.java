package lt.vu.transactions;

import lt.vu.entities.Car;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.transaction.TransactionSynchronizationRegistry;
import javax.transaction.Transactional;
import lt.vu.entities.Car;

@Named
@RequestScoped
public class TransakcijaAntras {

    @Resource
    private TransactionSynchronizationRegistry tx;

    @PostConstruct
    public void init() {
        performTransaction();
    }

    @Inject
    private EntityManager entityManager;

    @Transactional // @Transactional(Transactional.TxType.REQUIRES_NEW) - doesn't work by design
    public void performTransaction() {
        Car car = new Car();
        car.setId(0);
        car.setEngine("LS");
        // Perform transactional database operation
        entityManager.persist(car);
        entityManager.remove(car);

        String txId = tx.getTransactionKey().toString();
        System.out.println("TransakcijaAntras Transaction ID: " + txId);
    }
}