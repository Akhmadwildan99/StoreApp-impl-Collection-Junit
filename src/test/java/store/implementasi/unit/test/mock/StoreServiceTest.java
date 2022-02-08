package store.implementasi.unit.test.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import store.implementasi.unit.test.entity.Name;
import store.implementasi.unit.test.entity.Price;
import store.implementasi.unit.test.entity.Total;
import store.implementasi.unit.test.repository.StoreRepository;
import store.implementasi.unit.test.repository.StoreRepositoryImpl;
import store.implementasi.unit.test.service.StoreService;
import store.implementasi.unit.test.service.StoreServiceImpl;

@DisplayName("Test service")
public class StoreServiceTest {
    @Mock
    private StoreService storeService;

    @BeforeEach
    void setUp() {
        StoreRepository storeRepository = new StoreRepositoryImpl();
        storeService = new StoreServiceImpl(storeRepository);
    }

    @Test
    void testAddService() {
    }
}
