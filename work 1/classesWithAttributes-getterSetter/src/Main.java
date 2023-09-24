public class Main {

    public static void main(String[] args) {
	    Product product = new Product(1,"shoe","adidas",300,2,"black");

        Product product1 = new Product();
//        product.set_name("shoe");
//        product.set_id(123);
//        product.set_description("orthopaedic") ;
//        product.set_price(550) ;
//        product.set_stockAmount(6);
//        product.set_color("black");


        ProductManager productManager = new ProductManager();
        productManager.add(product);


        System.out.println(product);

    }
}
