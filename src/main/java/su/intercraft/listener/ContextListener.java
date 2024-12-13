package su.intercraft.listener;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import org.flywaydb.core.Flyway;

@WebListener
public class ContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        try {
            Class.forName("org.postgresql.Driver");

            Flyway flyway = Flyway.configure()
                    .dataSource("jdbc:postgresql://localhost:5432/sport", "postgres", "root")
                    .load();

            // Запуск миграций
            flyway.migrate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        System.out.println("Контекст сервлета инициализирован.");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("Контекст сервлета уничтожен.");
    }
}