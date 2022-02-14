package store.implementasi.unit.test.service;

import store.implementasi.unit.test.entity.Name;
import store.implementasi.unit.test.entity.Price;
import store.implementasi.unit.test.entity.Total;
import store.implementasi.unit.test.repository.StoreRepository;

import java.util.ArrayList;
import java.util.Map;

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
            System.out.println(no + ". " + name.getName() + " || harga: " + price.getPrice() + " || total: " + total.getTotal()
            );
        }
     }

    @Override
    public void addProduct(String name, Integer price, Integer total) {
        Name productName = new Name(name);
        Price productPrice = new Price(price);
        Total productTotal = new Total(total);

        storeRepository.add(productName, productPrice, productTotal);

    }

    @Override
    public void checkOut1(String name, Integer price) {
        Name product = new Name(name);
        Price price1 = new Price(price);
        boolean out = storeRepository.out(product, price1);
        if (out){
            System.out.println("PROSES BERHASIL");
        } else {
            System.out.println("PROSES GAGAL");
        }
    }

    @Override
    public void checkOut2(String name, Integer total) {
        Name product = new Name(name);
        Total toral1 = new Total(total);
        boolean out2 = storeRepository.out2(product, toral1);
        if (out2){
            System.out.println("PROSES BERHASIL");
        } else {
            System.out.println("PROSES GAGAL");
        }
    }

}
