public class Main {
    public static void main(String[] args) {
        CreditUI creditUI = new CreditUI();
        creditUI.calculateCredit(new FarmingCreditManager());
        creditUI.calculateCredit(new SoldierCreditManager());
        creditUI.calculateCredit(new TeacherCreditManager());
    }
}
