import com.wll.test.PaymentCalculator;
import com.wll.test.garden.Masters;
import com.wll.test.garden.Servants;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;

/**
 * Created by wll on 8/27/16.
 */
public class PaymentTest {

    @Test
    public void test(){
        Assert.assertThat(PaymentCalculator.pay(10, Servants.QingWen, Masters.JiaZheng), is(4200));
    }
}

