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
        var priceContains = productPrice.get(name).getPrice();
        var priceCurrent = price.getPrice();
        var totalCurrentInteger = productTotal.get(name).getTotal();
        var totalCurrent = productTotal.get(name);
        if (productName.contains(name) && priceCurrent >= priceContains){
            Integer checkOutProduct = 0;
            while (priceCurrent >= priceContains){
                checkOutProduct += 1;
                priceCurrent-= priceContains;
            }
            Integer lastTotal = totalCurrentInteger - checkOutProduct;
            Total total = new Total(lastTotal);
            if (total.getTotal().equals(0)){
                productName.remove(name);
                productPrice.remove(name);
                productTotal.remove(name);
            } else {
                productTotal.replace(name, totalCurrent, total);
                System.out.println("Kembalian anda " + priceCurrent);
                System.out.println("Total diupdate menjadi " + productTotal.get(name).getTotal());
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean out2(Name name, Total total) {
        return false;
    }
}
