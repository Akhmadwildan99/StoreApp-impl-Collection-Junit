package store.implementasi.unit.test.mock.serviceTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import store.implementasi.unit.test.entity.Name;
import store.implementasi.unit.test.repository.StoreRepository;
import store.implementasi.unit.test.repository.StoreRepositoryImpl;
import store.implementasi.unit.test.service.StoreService;
import store.implementasi.unit.test.service.StoreServiceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StoreServiceTest {
    @Mock
    private StoreService storeService;

    @Mock
    private StoreRepository repository;

    @BeforeEach
    void setUp() {
        repository = new StoreRepositoryImpl();
        storeService = new StoreServiceImpl(repository);
    }

    @Test
    void testAddProductSuccess() {
        storeService.addProduct("Nescafe", 4000, 40);
        assertEquals("Nescafe", repository.getAllProduct().get(0).getName());
        assertEquals(4000, repository.getAllPrice().get(new Name("Nescafe")).getPrice());
        assertEquals(40, repository.getAllTotal().get(new Name("Nescafe")).getTotal());

        storeService.addProduct("Nescafe", 4000, 40);
        assertEquals(80, repository.getAllTotal().get(new Name("Nescafe")).getTotal());

    }

    @Test
    void testCheckOut1Success() {
        storeService.addProduct("Nescafe", 4000, 40);
        storeService.addProduct("Kapalapi", 3000, 100);
        storeService.addProduct("Kopiko", 500, 1000);

        storeService.checkOut1("Kopiko", 400000);
        assertEquals(200, repository.getAllTotal().get(new Name("Kopiko")).getTotal());
        storeService.checkOut1("Nescafe", 30000);
        assertEquals(33, repository.getAllTotal().get(new Name("Nescafe")).getTotal());
        storeService.checkOut1("Kapalapi", 2000);
        assertEquals(100, repository.getAllTotal().get(new Name("Kapalapi")).getTotal());

    }

    @Test
    void testCheckOut2Success() {
        storeService.addProduct("Nescafe", 4000, 40);
        storeService.addProduct("Kapalapi", 3000, 100);
        storeService.addProduct("Kopiko", 500, 1000);

        storeService.checkOut2("Kopiko", 500);
        assertEquals(500, repository.getAllTotal().get(new Name("Kopiko")).getTotal());
        storeService.checkOut2("Nescafe", 30);
        assertEquals(10, repository.getAllTotal().get(new Name("Nescafe")).getTotal());
        storeService.checkOut2("Kapalapi", 109);
        assertEquals(100, repository.getAllTotal().get(new Name("Kapalapi")).getTotal());

    }
}
