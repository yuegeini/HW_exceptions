import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {
    //    Product[] products = new
    ShopRepository repo = new ShopRepository();

    @BeforeEach
    public void fill() {
        Product product1 = new Product(0, "f1", 100);
        Product product2 = new Product(1, "s2", 200);
        Product product4 = new Product(3, "f4", 400);
        repo.add(product1);
        repo.add(product2);
        repo.add(product4);
    }

    @Test
    public void shouldRemoveFirst() {
        ShopRepository expected = new ShopRepository();
        Product product2 = new Product(1, "s2", 200);
        Product product4 = new Product(3, "f4", 400);
        expected.add(product2);
        expected.add(product4);
        repo.remove(0);

        Assertions.assertArrayEquals(repo.findAll(), expected.findAll());
    }

    @Test
    public void shouldThrowException() {
        try {
            repo.remove(2);
        } catch (NotFoundException e) {
            System.out.println("All good");
        }
    }
}
