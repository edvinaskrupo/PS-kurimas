package lt.vu.transactions;

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
public class TransakcijaPirmas {

    @Inject
    private TransakcijaAntras antras;

    @Inject
    private EntityManager entityManager;

    @Resource
    private TransactionSynchronizationRegistry tx;

    @Transactional
    public void performTransaction() {
        Car car = new Car();
        car.setId(0);
        car.setEngine("2JZ");
        // Perform transactional database operation
        entityManager.persist(car);
        entityManager.remove(car);

        String txId = tx.getTransactionKey().toString();
        System.out.println("TransakcijaPirmas Transaction ID: " + txId);

        // Call method from the second component
        antras.performTransaction();
    }
}