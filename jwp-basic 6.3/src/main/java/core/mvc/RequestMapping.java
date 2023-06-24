package core.mvc;

import controller.HomeController;
import controller.ListUserController;
import controller.LoginController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class RequestMapping {
    private static final Logger log = LoggerFactory.getLogger(DispatcherServlet.class);
    private Map<String, Controller> mappings = new HashMap<>();

    void initMapping() {
        mappings.put("/", new HomeController());
        mappings.put("/users/form", new ForwardController("/user/form.jsp"));
        mappings.put("/users/loginFrom", new ForwardController("/user/login.jsp"));


        mappings.put("/users", new ListUserController());
        mappings.put("/users/form", new LoginController());
        mappings.put("/users/form", new ForwardController("/user/form.jsp"));
        mappings.put("/users/form", new ForwardController("/user/form.jsp"));
        mappings.put("/users/form", new ForwardController("/user/form.jsp"));
        mappings.put("/users/form", new ForwardController("/user/form.jsp"));
        mappings.put("/users/form", new ForwardController("/user/form.jsp"));
    }


}
