package store.implementasi.unit.test.service;

import store.implementasi.unit.test.entity.Name;
import store.implementasi.unit.test.entity.Price;
import store.implementasi.unit.test.entity.Total;
import store.implementasi.unit.test.repository.StoreRepository;

import java.util.ArrayList;
import java.util.Map;
import java.util.SortedSet;

public class StoreServiceImpl implements StoreService{
    private StoreRepository storeRepository;

    public StoreServiceImpl(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    @Override
    public void showStore() {
        ArrayList<Name> productName = storeRepository.getAllProduct();
        Map<Name, Price> productPrice = storeRepository.getAllPrice();
        Map<Name, Total> productTotal = storeRepository.getAllTotal();

        for (int i = 0; i < productName.size(); i++) {
            var no = i + 1;
            var name = productName.get(i);
            var price = productPrice.get(name);
            var total = productTotal.get(name);
            System.out.println(no + ". " + name.getName() + " harga: " + price.getPrice() + " total: " + total.getTotal()
            );
        }
     }

    @Override
    public void addProduct() {

    }

    @Override
    public void checkOut1() {

    }

    @Override
    public void checkOut2() {

    }
}
