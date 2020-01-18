public class PaymentServiceImpl implements PaymentService {


    private PKOService pkoService;

    public PaymentServiceImpl(PKOService pkoService) {
        this.pkoService = pkoService;
    }

    public boolean pay(int clientBalance, int price) {
        if (clientBalance >= price) {
           return pkoService.transferMoney(clientBalance, price);
        } else {
            return false;
        }
    }
}
