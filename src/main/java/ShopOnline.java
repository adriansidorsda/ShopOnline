public class ShopOnline {

    private PaymentService paymentService;

    public ShopOnline(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public String buyShoes(ClientBankAccount clientBankAccount, Shoes shoes) {
        if (shoes == null) {
            throw new IllegalArgumentException("Shoes cannot be null!");
        }

        boolean wasPaid = paymentService.pay(clientBankAccount.getBalance(), shoes.getPrice());

        if (wasPaid) {
            return "PAID";
        } else {
            return null;
        }
    }

}
