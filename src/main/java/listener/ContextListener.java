package listener;

import connection.ConnectionPoolException;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.List;

public class ContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        LanguageDaoImpl languageDao=new LanguageDaoImpl();
        List<Language>list= null;
        try {
            list = languageDao.getAll();
        } catch (ConnectionPoolException e) {
            e.printStackTrace();
        }
        servletContextEvent.getServletContext().setAttribute("languages",list);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
