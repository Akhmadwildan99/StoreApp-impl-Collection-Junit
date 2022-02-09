package store.implementasi.unit.test.mock.serviceTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import store.implementasi.unit.test.entity.Name;
import store.implementasi.unit.test.entity.Price;
import store.implementasi.unit.test.entity.Total;
import store.implementasi.unit.test.repository.StoreRepository;
import store.implementasi.unit.test.repository.StoreRepositoryImpl;

@DisplayName("Test Repository")
public class StoreRepositoryTest {
    @Mock
    private StoreRepository storeRepository;

    @BeforeEach
    void setUp() {
        storeRepository = new StoreRepositoryImpl();
    }

    @Test
    void testAddServiceSuccess() {
        storeRepository.add(new Name("Susu"), new Price(2000), new Total(40));
        Assertions.assertEquals("Susu", storeRepository.getAllProduct().get(0).getName());
        Assertions.assertEquals(2000, storeRepository.getAllPrice().get(new Name("Susu")).getPrice());
        Assertions.assertEquals(40, storeRepository.getAllTotal().get(new Name("Susu")).getTotal());
        storeRepository.add(new Name("Nescafe"), new Price(4000), new Total(50));
        Assertions.assertEquals("Nescafe", storeRepository.getAllProduct().get(1).getName());
        Assertions.assertEquals(4000, storeRepository.getAllPrice().get(new Name("Nescafe")).getPrice());
        Assertions.assertEquals(50, storeRepository.getAllTotal().get(new Name("Nescafe")).getTotal());
        storeRepository.add(new Name("Nescafe"), new Price(4000), new Total(50));
        Assertions.assertEquals("Nescafe", storeRepository.getAllProduct().get(1).getName());
        Assertions.assertEquals(4000, storeRepository.getAllPrice().get(new Name("Nescafe")).getPrice());
        Assertions.assertEquals(100, storeRepository.getAllTotal().get(new Name("Nescafe")).getTotal());
    }

    @Test
    void testOut1RepositorySuccess() {
        storeRepository.add(new Name("Nescafe"), new Price(4000), new Total(50));
        storeRepository.add(new Name("Kapalapi"), new Price(2000), new Total(40));
        storeRepository.add(new Name("Good Day"), new Price(1000), new Total(10));
        storeRepository.out(new Name("Nescafe"), new Price(50000));
        storeRepository.out(new Name("Kapalapi"), new Price(10000));
        storeRepository.out(new Name("Good Day"), new Price(10000));
        Assertions.assertEquals("Nescafe", storeRepository.getAllProduct().get(0).getName());
        Assertions.assertEquals(38, storeRepository.getAllTotal().get(new Name("Nescafe")).getTotal());
        Assertions.assertEquals("Kapalapi", storeRepository.getAllProduct().get(1).getName());
        Assertions.assertEquals(35, storeRepository.getAllTotal().get(new Name("Kapalapi")).getTotal());
        Assertions.assertEquals(2, storeRepository.getAllProduct().size());
        Assertions.assertEquals(2, storeRepository.getAllPrice().size());
        Assertions.assertEquals(2, storeRepository.getAllTotal().size());
    }
}
