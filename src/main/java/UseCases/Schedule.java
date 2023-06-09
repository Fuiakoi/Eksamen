package UseCases;

import DBcontroller.DBSQL;
import org.springframework.stereotype.Service;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Service
public class Schedule {
    private final ScheduledExecutorService scheduler;
    public DBSQL dbController;

    public Schedule() {
       this.dbController = dbController;
        scheduler = Executors.newSingleThreadScheduledExecutor();
    }

    public void startScheduledDelete() {
        scheduler.scheduleAtFixedRate(() -> dbController.deleteBasedOnAge(), 0, 24, TimeUnit.HOURS);
    }

    public void stopScheduledDelete() {
        scheduler.shutdown();
    }
}
