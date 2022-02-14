package store.implementasi.unit.test.mock.repositoryTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import store.implementasi.unit.test.entity.Name;
import store.implementasi.unit.test.entity.Price;
import store.implementasi.unit.test.entity.Total;
import store.implementasi.unit.test.repository.StoreRepository;
import store.implementasi.unit.test.repository.StoreRepositoryImpl;

@DisplayName("Test Repository")
@ExtendWith(MockitoExtension.class)
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

    @Test
    void testOut1RepositoryFailed() {
        storeRepository.add(new Name("Nescafe"), new Price(1000), new Total(50));
        boolean nescafe = storeRepository.out(new Name("Nescafe"), new Price(60000));
        Assertions.assertEquals("Nescafe", storeRepository.getAllProduct().get(0).getName());
        Assertions.assertEquals(false, nescafe);
        Assertions.assertEquals(50, storeRepository.getAllTotal().get(new Name("Nescafe")).getTotal());

    }

    @Test
    void testOut2RepositorySuccess() {
        storeRepository.add(new Name("Nescafe"), new Price(4000), new Total(50));
        storeRepository.add(new Name("Kapalapi"), new Price(2000), new Total(40));
        storeRepository.add(new Name("Good Day"), new Price(1000), new Total(10));
        boolean nescafe = storeRepository.out2(new Name("Nescafe"), new Total(40));
        boolean kapalapi = storeRepository.out2(new Name("Kapalapi"), new Total(30));
        boolean goodDay = storeRepository.out2(new Name("Good Day"), new Total(10));
        Assertions.assertEquals(true, nescafe);
        Assertions.assertEquals(10, storeRepository.getAllTotal().get(new Name("Nescafe")).getTotal());
        Assertions.assertEquals(true, kapalapi);
        Assertions.assertEquals(10, storeRepository.getAllTotal().get(new Name("Kapalapi")).getTotal());
        Assertions.assertEquals(true, goodDay);
        Assertions.assertEquals(2, storeRepository.getAllProduct().size());
    }

    @Test
    void testOut2RepositoryFailed() {
        storeRepository.add(new Name("Nescafe"), new Price(4000), new Total(50));
        storeRepository.add(new Name("Kapalapi"), new Price(2000), new Total(40));
        boolean nescafe = storeRepository.out2(new Name("Nescafe"), new Total(57));
        boolean kapalapi = storeRepository.out2(new Name("Kapalapi"), new Total(49));
        Assertions.assertEquals(false, nescafe);
        Assertions.assertEquals(50, storeRepository.getAllTotal().get(new Name("Nescafe")).getTotal());
        Assertions.assertEquals(false, kapalapi);
        Assertions.assertEquals(40, storeRepository.getAllTotal().get(new Name("Kapalapi")).getTotal());

    }


}
