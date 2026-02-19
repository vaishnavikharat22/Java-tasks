import com.example.config.Appconfig;
import com.example.controller.UserController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args){
        ApplicationContext context = new AnnotationConfigApplicationContext(Appconfig.class);

        UserController controller = context.getBean(UserController.class);
        controller.createUser("Vaishnav");
        controller.createUser("Manodnya");
        controller.listUsers();
    }
}
