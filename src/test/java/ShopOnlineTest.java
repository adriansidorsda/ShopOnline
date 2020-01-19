import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class ShopOnlineTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    private ShopOnline shopOnline;

    @Mock
    PaymentService paymentService;

    @Before
    public void setup() {
        shopOnline = new ShopOnline(paymentService);
    }
    @Test
    public  void testBuyShoesWhenShoesNull() {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Shoes cannot be null!");
        //given
        Shoes shoes = null;
        ClientBankAccount clientBankAccount = new ClientBankAccount(1,10);

        //when
        shopOnline.buyShoes(clientBankAccount, shoes);
    }

    @Test
    public void testBuyShoesRetunrPaidWhenWasPaid() {
        //given
        ClientBankAccount clientBankAccount =  new ClientBankAccount(1,10);
        Shoes shoes = new Shoes(1,1);
        when(paymentService.pay(anyInt(), anyInt())).thenReturn(true);

        //when
        String result = shopOnline.buyShoes(clientBankAccount, shoes);
        //then
        assertEquals("PAID", result);
    }

    @Test
    public void testBuyShoesReturnNullWhenNotPaid() {
        //given
        ClientBankAccount clientBankAccount =  new ClientBankAccount(1,10);
        Shoes shoes = new Shoes(1,1);
        when(paymentService.pay(anyInt(), anyInt())).thenReturn(false);

        //when
        String result = shopOnline.buyShoes(clientBankAccount, shoes);
        //then
        assertNull(result);
    }
}




