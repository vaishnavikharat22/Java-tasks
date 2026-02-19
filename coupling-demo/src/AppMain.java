import loose.EmailNotificationService;
import loose.NotificationService;
import loose.SMSNotificationService;
import tight.UserService;

public class AppMain {
    public static void main(String[] args) {
        //Tight
        UserService userService = new UserService();
        userService.notifyUser("Order Placed!");

        //loose
        NotificationService emailService = new EmailNotificationService();
        NotificationService smsService = new SMSNotificationService();
        loose.UserService userServiceLoose = new loose.UserService(smsService);
        userServiceLoose.notifyUser("Order Processed!");
    }
}
