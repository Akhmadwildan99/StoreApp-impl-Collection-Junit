package store.implementasi.unit.test.view;

import store.implementasi.unit.test.service.StoreService;
import store.implementasi.unit.test.util.Input;

public class StoreView {
    private StoreService storeService;

    public StoreView(StoreService storeService) {
        this.storeService = storeService;
    }

    public void showProduct(){
        while (true){
            System.out.println("STOCK: ");
            storeService.showStore();
            System.out.println("");
            System.out.println("Menu:");
            System.out.println("1) TAMBAH PEODUK");
            System.out.println("2) CHECK OUT (dengan sejumlah uang)");
            System.out.println("3) CHECK OUT (dengan menyebutkan berapa total yang mau dibeli)");
            System.out.println("x) cancel");

            var input = Input.inputUtil("aksi: ");
            if (input.equals("1")){
                addProduct();
            } else if (input.equals("2")){
                checkoutWithPrice();
            } else if (input.equals("3")){
                checkoutWithTotal();
            } else if (input.equals("x")){
                break;
            } else {
                System.out.println("Pilihan tidak dimengerti!!");
            }

        }

    }

    public void addProduct(){
        System.out.println(" ");
        System.out.println("MENAMBAH PRODUCT!!");

        var inputProduct = Input.inputUtil("Masukan product (x jika batal): ");
        var inputPrice = Input.inputUtil("Masukan harga: ");
        var inputTotal = Input.inputUtil("masukan total: ");

        System.out.println(" ");

        if (inputProduct.equals("x") ){
            //false
        } else {
            storeService.addProduct(inputProduct.toLowerCase(), Integer.valueOf(inputPrice), Integer.valueOf(inputTotal));
        }
    }

    public void checkoutWithPrice(){
        System.out.println(" ");
        System.out.println("CHECK-OUT DENGAN JUMLAH UANG!!");
        var inputProduct = Input.inputUtil("Masukan product (x jika batal): ");
        var inputPrice = Input.inputUtil("Masukan jumlah uang: ");

        System.out.println(" ");

        if (inputProduct.equals("x") ){
            //false
        } else {
            storeService.checkOut1(inputProduct.toLowerCase(), Integer.valueOf(inputPrice));
        }
    }

    public void checkoutWithTotal(){
        System.out.println(" ");
        System.out.println("CHECK-OUT DENGAN JUMLAH YANG MAU ANDA BELI!!");
        var inputProduct = Input.inputUtil("Masukan product (x jika batal): ");
        var inputTotal = Input.inputUtil("masukan total beli: ");

        System.out.println(" ");

        if (inputProduct.equals("x") ){
            //false
        } else {
            storeService.checkOut2(inputProduct.toLowerCase(), Integer.valueOf(inputTotal));
        }
    }

}
