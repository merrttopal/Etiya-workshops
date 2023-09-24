
public class Main {
    public static void main(String[] args) {

        /*
        BaseLoggler[] loggers = new BaseLoggler[]{new FileLogger(),new EmailLogger(),new DatabaseLogger(),new ConsoleLogger()};

        for (BaseLoggler logger : loggers){
            logger.Log("Log message");
        }
         */

        CustomerManager customerManager = new CustomerManager(new DatabaseLogger());
        customerManager.Add();

    }

}
