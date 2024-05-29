package lt.vu.components;

import lt.vu.interceptors.LoggedInvocation;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Specializes;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.TransactionSynchronizationRegistry;
import java.util.Date;

@LoggedInvocation
@SessionScoped
@Specializes
public class SpecializedKomponentas extends PirmasKomponentas {

    @Override
    public String sakykLabas() {
        // Customized behavior
        return "Special Labas " + new Date() + " " + toString();
    }
}