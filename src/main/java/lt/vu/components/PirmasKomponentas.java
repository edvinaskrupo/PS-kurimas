package lt.vu.components;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.TransactionSynchronizationRegistry;
import javax.transaction.Transactional;
import java.util.Date;

@Named
@SessionScoped // @RequestScoped
public class PirmasKomponentas implements java.io.Serializable {
    // @Inject - Field injection
    private AntrasKomponentas antras;

    // Constructor injection
    @Inject
    public PirmasKomponentas(AntrasKomponentas antras) {
        this.antras = antras;
    }

    @Resource
    private TransactionSynchronizationRegistry tx;

    public String sakykLabas() {
        return "Labas " + new Date() + " " + toString();
    }

    @PostConstruct
    public void init() {
        System.out.println(toString() + " constructed.");
        System.out.println(antras.getClass().getName());
    }

    @PreDestroy
    public void aboutToDie() {
        System.out.println(toString() + " ready to die.");
    }

}