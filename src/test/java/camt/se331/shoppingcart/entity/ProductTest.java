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
        VatEntity.getInstance().setVat(0.1);
        assertThat(productDao.getProduct(1l).getNetPrice(), is(900.00));
        VatEntity.getInstance().setVat(0.05);
        assertThat(productDao.getProduct(2l).getNetPrice(),is(1900.00));


    }

    @Test
    public void testProductGetVat(){
        VatEntity.getInstance().setVat(0.1);
        assertThat(productDao.getProduct(1l).getTax(), is(100.00));
        VatEntity.getInstance().setVat(0.05);
        assertThat(productDao.getProduct(2l).getTax(),is(100.00));


    }

}
