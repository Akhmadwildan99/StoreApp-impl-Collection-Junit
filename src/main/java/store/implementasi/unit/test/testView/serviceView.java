package store.implementasi.unit.test.testView;

import store.implementasi.unit.test.repository.StoreRepository;
import store.implementasi.unit.test.repository.StoreRepositoryImpl;
import store.implementasi.unit.test.service.StoreService;
import store.implementasi.unit.test.service.StoreServiceImpl;

public class serviceView {
    public static void main(String[] args) {
        testAddProduct();
    }

    public static void testAddProduct(){
        StoreRepository storeRepository = new StoreRepositoryImpl();
        StoreService storeService = new StoreServiceImpl(storeRepository);
        storeService.addProduct("Nescafe", 4000, 40);
        storeService.addProduct("Susu", 3000, 30);
        storeService.showStore();
        storeService.addProduct("Nescafe", 4000, 40);
        storeService.addProduct("Susu", 4000, 30);
        storeService.showStore();
        storeService.addProduct("Susu", 3000, 30);
        storeService.addProduct("Nescafe", 1000, 40);
        storeService.showStore();

    }
}
