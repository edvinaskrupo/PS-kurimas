package lt.vu.components;

import lombok.Getter;
import lombok.Setter;
import lt.vu.services.LabasService;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.TransactionSynchronizationRegistry;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@Named
@SessionScoped // @RequestScoped
@Alternative
public class AlternativeKomponentas implements Serializable, LabasService {
    @Override
    public String sakykLabas() {
        return "Alternative Labas!"; // Different implementation
    }

}