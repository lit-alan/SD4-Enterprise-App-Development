package listeners;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebListener
public class SessionCounter implements HttpSessionListener {

    private AtomicInteger activeSessions = null;
    static final Logger LOGGER = Logger.getLogger("listeners.SessionCounter");

    public SessionCounter() {
        super();
        activeSessions = new AtomicInteger();
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        activeSessions.incrementAndGet();
        LOGGER.log(Level.WARNING, se.getClass().getName() + " activeSessions " + activeSessions);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        activeSessions.decrementAndGet();
        LOGGER.log(Level.WARNING, se.getClass().getName() + " activeSessions " + activeSessions);
    }
}
