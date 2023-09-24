package oopWithNLayeredApp.dataAccsess;


import oopWithNLayeredApp.entities.Product;

// Dao = data access object
public class JdbcProductDao implements ProductDao{

    // sadece DB erişim kodları buraya yazılır

    public  void add(Product product){
        System.out.println(" Added to database with JDBC");
    }

    public void remove(){

    }

}

