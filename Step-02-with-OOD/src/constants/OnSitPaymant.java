public class OnSitePayment implements PaymentMethod {
    @Override
    public void pay(double amount) {
        System.out.println("Paid onsite: " + amount);
    }
}
