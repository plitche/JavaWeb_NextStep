package next.support.context;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

import core.jdbc.ConnectionManager;

@WebListener
public class ContextLoaderListener implements ServletContextListener {
    private static final Logger logger = LoggerFactory.getLogger(ContextLoaderListener.class);

    // contextInitialized()
    // 톰캣 서버가 시작할때 메소드를 호출함으로써 초기화 작업 가능
    // ServletContextListener 인테페이스 구현체 중 @WebListener 어노테이션을 사용하기 때문
    // @WebListener 어노테이션이 설정되어 있으면 서블릿 컨테이너를 시작하는 과정에서 contextInitialized() 메소드를 호출한다.
    // 이 초기화는 서블릿 초기화보다 먼저 실행된다.
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
        populator.addScript(new ClassPathResource("jwp.sql"));
        DatabasePopulatorUtils.execute(populator, ConnectionManager.getDataSource());

        logger.info("Completed Load ServletContext!");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }
}
