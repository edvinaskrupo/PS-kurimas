package lt.vu.components;

import lt.vu.services.LabasService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class LabasController {

    @Inject
    private LabasService greetingService;

    public String sakykLabas() {
        return greetingService.sakykLabas();
    }
}