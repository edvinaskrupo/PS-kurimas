package lt.vu.components;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.Date;

@Named
@RequestScoped // @SessionScoped
public class PirmasKomponentas implements java.io.Serializable {

    private TreciasKomponentas trecias;

    //constructor injection
    @Inject
    public PirmasKomponentas(TreciasKomponentas trecias) {
        this.trecias = trecias;
    }

    public String sakykLabas() {
        System.out.println(antras.getClass().getName());
        System.out.println(trecias.getClass().getName());
        return "Labas " + new Date() + " " + toString();
    }

    @PostConstruct
    public void init() {
        System.out.println(toString() + " constructed.");
    }

    @PreDestroy
    public void aboutToDie() {
        System.out.println(toString() + " ready to die.");
    }

    //field injection
    @Inject
    private AntrasKomponentas antras;
}