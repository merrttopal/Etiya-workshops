public class Product {
    public Product(int _id, String _name, String _description,double _price,int _stockAmount,String _color){

        this._id = _id;
        this._name =_name ;
        this._description =_description;
        this._price = _price;
        this._stockAmount =_stockAmount;
        this._color = _color;
    }
    public Product(){

    }


    //attribute | field
    private int _id;
    private String _name;
    private String _description;
    private double _price;
    private int _stockAmount;
    private String _color;
    private String code;


    public int get_id() {
        return _id;
    }

    public Product set_id(int _id) {
        this._id = _id;
        return this;
    }

    public String get_name() {
        return _name;
    }

    public Product set_name(String _name) {
        this._name = _name;
        return this;
    }

    public String get_description() {
        return _description;
    }

    public Product set_description(String _description) {
        this._description = _description;
        return this;
    }

    public double get_price() {
        return _price;
    }

    public Product set_price(double _price) {
        this._price = _price;
        return this;
    }

    public int get_stockAmount() {
        return _stockAmount;
    }

    public Product set_stockAmount(int _stockAmount) {
        this._stockAmount = _stockAmount;
        return this;
    }

    public String get_color() {
        return _color;
    }

    public Product set_color(String _color) {
        this._color = _color;
        return this;
    }

    public String getCode() {
        return code;
    }

    public Product setCode(String code) {
        this.code = code;
        return this;
    }
}
