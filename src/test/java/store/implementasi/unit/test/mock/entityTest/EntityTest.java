package store.implementasi.unit.test.mock.entityTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import store.implementasi.unit.test.entity.Name;
import store.implementasi.unit.test.entity.Price;
import store.implementasi.unit.test.entity.Total;

public class EntityTest {
    @Test
    @DisplayName("Test entity name")
    void TestName() {
        Name name = new Name("nescafe");
        Assertions.assertEquals("nescafe", name.getName());
    }

    @Test
    @DisplayName("Test entity price")
    void TestPrice() {
        Price price = new Price(2000);
        Assertions.assertEquals(2000, price.getPrice());
    }

    @Test
    @DisplayName("Test entity total")
    void TestTotal() {
        Total total = new Total(20);
        Assertions.assertEquals(20, total.getTotal());
    }
}
