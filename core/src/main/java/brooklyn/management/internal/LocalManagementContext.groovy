package brooklyn.management.internal;

import java.util.Collection
import java.util.Set

import org.slf4j.Logger
import org.slf4j.LoggerFactory

import brooklyn.entity.Application
import brooklyn.entity.Entity
import brooklyn.management.ExecutionContext
import brooklyn.management.ExecutionManager
import brooklyn.management.ManagementContext
import brooklyn.management.SubscriptionContext
import brooklyn.management.SubscriptionManager
import brooklyn.util.task.BasicExecutionContext
import brooklyn.util.task.BasicExecutionManager

/**
 * A local implementation of the {@link ManagementContext} API.
 */
public class LocalManagementContext extends AbstractManagementContext {
    private static final Logger log = LoggerFactory.getLogger(LocalManagementContext.class)

    private ExecutionManager execution
    private SubscriptionManager subscriptions
    
    Set<Application> apps = []
 
    //completely unacceptable!! :
    //public static ManagementContext getContext() { return new LocalManagementContext() }
    
    @Override
    public void registerApplication(Application app) {
        apps.add(app);
    }
    
    @Override
    public Collection<Application> getApplications() {
        return apps
    }
    
    public synchronized  SubscriptionManager getSubscriptionManager() {
        if (subscriptions) return subscriptions
        subscriptions = new LocalSubscriptionManager(executionManager)
    }

    public synchronized ExecutionManager getExecutionManager() {
        if (execution) return execution
        execution = new BasicExecutionManager()
    }
}
