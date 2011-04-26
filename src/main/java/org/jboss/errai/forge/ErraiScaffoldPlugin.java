package org.jboss.errai.forge;

import org.jboss.forge.scaffold.events.AdvertiseGenProfile;
import org.jboss.forge.shell.events.PostStartup;
import org.jboss.forge.shell.plugins.Plugin;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Event;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import java.net.URL;

/**
 * @author Mike Brock .
 */

@ApplicationScoped
public class ErraiScaffoldPlugin implements Plugin {
    @Inject
    private Event<AdvertiseGenProfile> event;

    public void init(@Observes PostStartup postStartup) {
        URL errai_cdi_fpk = getClass().getClassLoader()
                .getResource("org/jboss/errai/forge/templates/ErraiCDI.fpk");

        event.fire(new AdvertiseGenProfile("errai-cdi", errai_cdi_fpk));
    }
}
