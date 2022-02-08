package store.implementasi.unit.test.mock;

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

import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

@DisplayName("Test repository")
public class StoreRepositoryTest {
    @Mock
    private StoreRepository storeRepository;

    @BeforeEach
    void setUp() {
        storeRepository = new StoreRepositoryImpl();
    }

    @Test
    void testAddRepository() {
        Name product = new Name("Nescafe");
        Price price = new Price(2000);
        Total total = new Total(30);


    }
}
