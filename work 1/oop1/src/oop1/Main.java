package oop1;

public class Main {
    public static void main(String[] args) {
        String message = "asdasd";


        Product product1 = new Product();
                        //set value
        product1.setName("Delonghi Kahve Makinesi");
        product1.setUnitPrice(9831) ;
        product1.setDiscount(25) ;
        product1.setUnitsInStock(111111);
        product1.setImageUrl("bilmemne1.jpg");

        Product product2 = new Product();
        product2.setName("Smac Kahve Makinesi");
        product2.setUnitPrice(9831) ;
        product2.setDiscount(25) ;
        product2.setUnitsInStock(111111);
        product2.setImageUrl("bilmemne2.jpg");

        Product product3 = new Product();
        product3.setName("Kitchen Kahve Makinesi");
        product3.setUnitPrice(9831) ;
        product3.setDiscount(25) ;
        product3.setUnitsInStock(111111);
        product3.setImageUrl("bilmemne3.jpg");
        Product[] product ={product1,product2,product3};

        for (Product product0 : product) {
            System.out.println(product0.getName());
        }

        IndividualCustomer individualCustomer = new IndividualCustomer();
        individualCustomer.setId(1);
        individualCustomer.setPhoneNumber("056354354");
        individualCustomer.setCustomerNumber("123");
        individualCustomer.setFirstName("Mert");
        individualCustomer.setLastName("Topal");


        CorporateCustomer corporateCustomer = new CorporateCustomer();
        corporateCustomer.setId(2);
        corporateCustomer.setComponyName("kodlamamrt");
        corporateCustomer.setPhoneNumber("053333");
        corporateCustomer.setTaxNumber("1234567891");
        corporateCustomer.setCustomerNumber("321");

        Customer[] customers = {individualCustomer,corporateCustomer};









        //get value
        //System.out.println(product.name);








    }
}
