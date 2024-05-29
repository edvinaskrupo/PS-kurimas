package lt.vu.components;

import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.TransactionSynchronizationRegistry;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.Date;
import lt.vu.services.LabasService;

@Getter
@Setter
@Named
@SessionScoped // @RequestScoped
public class PirmasKomponentas implements Serializable, LabasService {
    @Inject
    private AntrasKomponentas antras;

    private String name;

    /* Constructor injection
    @Inject
    public PirmasKomponentas(AntrasKomponentas antras) {
        this.antras = antras;
    }*/

    @Resource
    private TransactionSynchronizationRegistry tx;

    @Override
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

    public void printName(String name) {
        System.out.println("Your name is: " + name);
    }

}