package np.com.anilpaudel.agro;


//Base class to hold information about our property
public class Property2 {
    private String item_categories;
    private String user_name;
    private String quantity_unit;
    private String item_name ;
    private String price;
    private String price_unit;
    private String quantity;
    private String end_date;
    private String address;
    private String address_name;
    private String address_latitude;
    private String address_longitude;
    private String description;
    private String user_id;
    private String occupation ;
    private String email;
    private String contact_no;
    private String timestamp;
    private String distance;
    private String agro_type;

    //constructor
    public Property2(
            String item_categories,
            String user_name,
            String quantity_unit,
            String item_name ,
            String price,
            String price_unit,
            String quantity,
            String end_date,
            String address,
            String address_name,
            String address_latitude,
            String address_longitude,
            String description,
            String user_id,
            String occupation ,
            String email,
            String contact_no,
            String timestamp,
            String distance,
            String agro_type)
    {
        this.item_categories=item_categories;
        this.user_name=user_name;
        this.quantity_unit=quantity_unit;
        this.item_name =item_name;
        this.price=price;
        this.price_unit=price_unit;
        this.quantity=quantity;
        this.end_date=end_date;
        this.address=address;
        this.address_name=address_name;
        this.address_latitude=address_latitude;
        this.address_longitude=address_longitude;
        this.description=description;
        this.user_id=user_id;
        this.occupation =occupation;
        this.email=email;
        this.contact_no=contact_no;
        this.timestamp=timestamp;
        this.distance=distance;
        this.agro_type=agro_type;
    }
    //getters

    public String getItem_categories() {return item_categories;}
    public String getUser_name() {return user_name;}
    public String getQuantity_unit() {return quantity_unit;}
    public String getItem_name() {return item_name ;}
    public String getPrice() {return price;}
    public String getPrice_unit() {return price_unit;}
    public String getQuantity() {return quantity;}
    public String getEnd_date() {return end_date;}
    public String getAddress() {return address;}
    public String getAddress_name() {return address_name;}
    public String getAddress_latitude() {return address_latitude;}
    public String getAddress_longitude() {return address_longitude;}
    public String getDescription() {return description;}
    public String getUser_id() {return user_id;}
    public String getOccupation() {return occupation ;}
    public String getEmail() {return email;}
    public String getContact_no() {return contact_no;}
    public String getTimestamp() {return timestamp;}
    public String getDistance() { return  distance;}
    public String getAgrotype(){ return agro_type;}
}