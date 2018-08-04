package np.com.anilpaudel.agro;

//Base class to hold information about our property
public class Property1 {
    private String item_categories;
    private String pro_user_name;
    private String quantity_unit;
    private String item_name ;
    private String pro_price;
    private String pro_price_unit;
    private String quantity;
    private String pro_end_date;
    private String pro_address;
    private String pro_address_name;
    private String pro_address_latitude;
    private String pro_address_longitude;
    private String pro_description;
    private String pro_user_id;
    private String pro_occupation ;
    private String pro_email;
    private String pro_contact_no;
    private String product_timestamp;
    private String distance;


    //constructor
    public Property1(
            String item_categories,
            String pro_user_name,
            String quantity_unit,
            String item_name ,
            String pro_price,
            String pro_price_unit,
            String quantity,
            String pro_end_date,
            String pro_address,
            String pro_address_name,
            String pro_address_latitude,
            String pro_address_longitude,
            String pro_description,
            String pro_user_id,
            String pro_occupation ,
            String pro_email,
            String pro_contact_no,
            String product_timestamp,
            String distance)
    {
        this.item_categories=item_categories;
        this.pro_user_name=pro_user_name;
        this.quantity_unit=quantity_unit;
        this.item_name =item_name;
        this.pro_price=pro_price;
        this.pro_price_unit=pro_price_unit;
        this.quantity=quantity;
        this.pro_end_date=pro_end_date;
        this.pro_address=pro_address;
        this.pro_address_name=pro_address_name;
        this.pro_address_latitude=pro_address_latitude;
        this.pro_address_longitude=pro_address_longitude;
        this.pro_description=pro_description;
        this.pro_user_id=pro_user_id;
        this.pro_occupation =pro_occupation;
        this.pro_email=pro_email;
        this.pro_contact_no=pro_contact_no;
        this.product_timestamp=product_timestamp;
        this.distance=distance;

    }

    //getters

    public String getItem_categories() {return item_categories;}
    public String getPro_user_name() {return pro_user_name;}
    public String getQuantity_unit() {return quantity_unit;}
    public String getItem_name() {return item_name ;}
    public String getPro_price() {return pro_price;}
    public String getPro_price_unit() {return pro_price_unit;}
    public String getQuantity() {return quantity;}
    public String getPro_end_date() {return pro_end_date;}
    public String getPro_address() {return pro_address;}
    public String getPro_address_name() {return pro_address_name;}
    public String getPro_address_latitude() {return pro_address_latitude;}
    public String getPro_address_longitude() {return pro_address_longitude;}
    public String getPro_description() {return pro_description;}
    public String getPro_user_id() {return pro_user_id;}
    public String getPro_occupation() {return pro_occupation ;}
    public String getPro_email() {return pro_email;}
    public String getPro_contact_no() {return pro_contact_no;}
    public String getProduct_timestamp() {return product_timestamp;}
    public String getDistance() { return  distance;}
}