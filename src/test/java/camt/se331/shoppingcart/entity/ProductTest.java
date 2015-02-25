package camt.se331.shoppingcart.entity;

import camt.se331.shoppingcart.dao.NewSimpleProductDao;
import camt.se331.shoppingcart.dao.ProductDao;
import org.hamcrest.MatcherAssert;
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
/**
 * Created by CAMT on 2/25/2015.
 */
public class ProductTest{

    ProductDao productDao;

    @Before
    public void setup(){
        productDao = new NewSimpleProductDao();
    }

    @Test
    public void testProductGetNetPrice(){
        VatEntity.getInstance().setVat(0.0);
        assertThat(productDao.getProduct(3l).getNetPrice(),is(2500.00));
        VatEntity.getInstance().setVat(1);
        assertThat(productDao.getProduct(4l).getNetPrice(),is(0.00));


    }


    @Test
    public void testProductGetVat() {
        VatEntity.getInstance().setVat(0.1);
        assertThat(productDao.getProduct(1l).getTax(), is(100.00));
        VatEntity.getInstance().setVat(0.05);
        assertThat(productDao.getProduct(2l).getTax(), is(100.00));
    }


    @Test
    public void testxxx(){
        VatEntity.getInstance().setVat(0.0);
        assertThat(productDao.getProduct(3l).getTax(),is(0.00));
        VatEntity.getInstance().setVat(1);
        assertThat(productDao.getProduct(4l).getTax(),is(20000.00));

    }

}
