package store.implementasi.unit.test.repository;

import store.implementasi.unit.test.entity.Name;
import store.implementasi.unit.test.entity.Price;
import store.implementasi.unit.test.entity.Total;

import java.util.*;

public class StoreRepositoryImpl implements StoreRepository{
    ArrayList<Name> productName = new ArrayList<>();
    Map<Name, Price> productPrice = new HashMap<>();
    Map<Name, Total> productTotal = new HashMap<>();
    @Override
    public ArrayList<Name> getAllProduct() {
        return productName;
    }

    @Override
    public Map<Name, Price> getAllPrice() {
        return productPrice;
    }

    @Override
    public Map<Name, Total> getAllTotal() {
        return productTotal;
    }

    @Override
    public void add(Name name, Price price, Total total) {
        if (name != null && price != null && total != null){
            updateTotal(name, price, total);
            if (!productName.contains(name)){
                productName.add(name);
                productPrice.put(name, price);
                productTotal.put(name, total);
            }
        }
    }

    public void updateTotal(Name name, Price price, Total total) {
        var priceCurrent = productPrice.get(name);
        if (productName.contains(name) && price.equals(priceCurrent)){
            Total current = productTotal.get(name);
            Integer currentTotal = current.getTotal();
            Integer secondTotal = total.getTotal();
            Integer last = currentTotal + secondTotal;
            Total lastTotal = new Total(last);
            productTotal.replace(name, current, lastTotal);
            System.out.println("Total "+ name.getName() + " diupdate jadi " + lastTotal.getTotal());
        }
    }

    @Override
    public boolean out(Name name, Price price) {
        return false;
    }

    @Override
    public boolean out2(Name name, Total total) {
        return false;
    }
}
