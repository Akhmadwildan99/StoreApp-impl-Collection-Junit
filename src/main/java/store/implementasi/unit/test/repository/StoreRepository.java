package store.implementasi.unit.test.repository;

import store.implementasi.unit.test.entity.Name;
import store.implementasi.unit.test.entity.Price;
import store.implementasi.unit.test.entity.Total;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;

public interface StoreRepository {
    ArrayList<Name> getAllProduct();
    Map<Name, Price> getAllPrice();
    Map<Name, Total> getAllTotal();

    void add(Name name, Price price, Total total);
    boolean out(Name name, Price price);
    boolean out2(Name name, Total total);
}
