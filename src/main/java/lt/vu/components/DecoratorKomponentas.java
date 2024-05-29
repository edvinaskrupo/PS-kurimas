package lt.vu.components;

import lt.vu.services.LabasService;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import java.io.Serializable;
import java.time.LocalDateTime;

@Decorator
@Dependent
public class DecoratorKomponentas implements LabasService, Serializable {

    @Inject
    @Delegate
    private LabasService delegate;

    @Override
    public String sakykLabas() {
        String originalGreeting = delegate.sakykLabas();
        return originalGreeting + " (This has been decorated!)";
    }
}
