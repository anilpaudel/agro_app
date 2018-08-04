package np.com.anilpaudel.agro;

//Base class to hold information about our property
public class Property {
    private String item_categories;
    private String req_user_name;
    private String quantity_unit;
    private String item_name ;
    private String req_price;
    private String req_price_unit;
    private String quantity;
    private String req_end_date;
    private String req_address;
    private String req_address_name;
    private String req_address_latitude;
    private String req_address_longitude;
    private String req_description;
    private String req_user_id;
    private String req_occupation ;
    private String req_email;
    private String req_contact_no;
    private String request_timestamp;
    private String distance;


    //constructor
    public Property(
            String item_categories,
            String req_user_name,
            String quantity_unit,
            String item_name ,
            String req_price,
            String req_price_unit,
            String quantity,
            String req_end_date,
            String req_address,
            String req_address_name,
            String req_address_latitude,
            String req_address_longitude,
            String req_description,
            String req_user_id,
            String req_occupation ,
            String req_email,
            String req_contact_no,
            String request_timestamp,
            String distance)
    {
        this.item_categories=item_categories;
        this.req_user_name=req_user_name;
        this.quantity_unit=quantity_unit;
        this.item_name =item_name;
        this.req_price=req_price;
        this.req_price_unit=req_price_unit;
        this.quantity=quantity;
        this.req_end_date=req_end_date;
        this.req_address=req_address;
        this.req_address_name=req_address_name;
        this.req_address_latitude=req_address_latitude;
        this.req_address_longitude=req_address_longitude;
        this.req_description=req_description;
        this.req_user_id=req_user_id;
        this.req_occupation =req_occupation;
        this.req_email=req_email;
        this.req_contact_no=req_contact_no;
        this.request_timestamp=request_timestamp;
        this.distance=distance;

    }

    //getters

    public String getItem_categories() {return item_categories;}
    public String getReq_user_name() {return req_user_name;}
    public String getQuantity_unit() {return quantity_unit;}
    public String getItem_name() {return item_name ;}
    public String getReq_price() {return req_price;}
    public String getReq_price_unit() {return req_price_unit;}
    public String getQuantity() {return quantity;}
    public String getReq_end_date() {return req_end_date;}
    public String getReq_address() {return req_address;}
    public String getReq_address_name() {return req_address_name;}
    public String getReq_address_latitude() {return req_address_latitude;}
    public String getReq_address_longitude() {return req_address_longitude;}
    public String getReq_description() {return req_description;}
    public String getReq_user_id() {return req_user_id;}
    public String getReq_occupation() {return req_occupation ;}
    public String getReq_email() {return req_email;}
    public String getReq_contact_no() {return req_contact_no;}
    public String getRequest_timestamp() {return request_timestamp;}
    public String getDistance() { return  distance;}
}

