import org.junit.Assert;
import org.junit.Test;
import org.unosquare.shopping.ShoppingList;

public class UnitTest {
    static final String PRODUCT_NAME = "rIcE";
    static final int PRODUCT_QUANTITY = 1;
    static final String PRODUCT_NAME_UPPERCASE = "RICE";
    @Test
    public void doesHashMapExist() {
        ShoppingList myList = new ShoppingList();
        Assert.assertTrue(myList!=null);
    };

    @Test
    public void canWeAddAProduct(){
        String productNameUpperCase = "RICE";
        ShoppingList myList = new ShoppingList();
        myList.addProduct(PRODUCT_NAME,PRODUCT_QUANTITY);
        Assert.assertTrue(myList.productAlreadyExists(PRODUCT_NAME_UPPERCASE));
    };

    @Test
    public void doesTheNameIsStoredInUpperCase(){
        ShoppingList myList = new ShoppingList();
        myList.addProduct(PRODUCT_NAME,PRODUCT_QUANTITY);
        Assert.assertTrue(myList.productAlreadyExists(PRODUCT_NAME_UPPERCASE));
    };
}
