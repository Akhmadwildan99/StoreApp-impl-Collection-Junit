package store.implementasi.unit.test;

import store.implementasi.unit.test.repository.StoreRepository;
import store.implementasi.unit.test.repository.StoreRepositoryImpl;
import store.implementasi.unit.test.service.StoreService;
import store.implementasi.unit.test.service.StoreServiceImpl;
import store.implementasi.unit.test.view.StoreView;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        StoreRepository storeRepository = new StoreRepositoryImpl();
        StoreService storeService = new StoreServiceImpl(storeRepository);
        StoreView storeView = new StoreView(storeService);

        storeView.showProduct();
    }
}
