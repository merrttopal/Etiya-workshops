public class CustomerManager {

    private BaseLoggler logger;


    public CustomerManager(BaseLoggler loggler){
        this.logger = loggler;

    }
    public void Add(){
        System.out.println("Customer added");
        logger.log("Log message");
    }

}
