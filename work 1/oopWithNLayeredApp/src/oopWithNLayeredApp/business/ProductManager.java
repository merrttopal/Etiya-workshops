package oopWithNLayeredApp.business;

import oopWithNLayeredApp.core.logging.Logger;
import oopWithNLayeredApp.dataAccsess.HibernateProductDao;
import oopWithNLayeredApp.dataAccsess.JdbcProductDao;
import oopWithNLayeredApp.dataAccsess.ProductDao;
import oopWithNLayeredApp.entities.Product;

import java.util.List;

public class ProductManager {

    private  ProductDao productDao;
    private List<Logger> loggers;

    public ProductManager(ProductDao productDao, Logger loggers) {
        this.productDao = productDao;
        this.loggers = (List<Logger>) loggers;
    }


    public void add(Product product) throws  Exception {
        //iş kuralları
        if (product.getUnitPrice() < 10) {
            throw new Exception("Unit price can be minimum 10");
        }

        productDao.add(product);

        for (Logger logger : loggers) {
            logger.log(product.getName());

        }
    }
}
