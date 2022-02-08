package store.implementasi.unit.test.service;

public interface StoreService {
    void showStore();
    void addProduct(String name, Integer price, Integer total);
    void checkOut1(String name, Integer price);
    void checkOut2(String name, Integer total);
}
