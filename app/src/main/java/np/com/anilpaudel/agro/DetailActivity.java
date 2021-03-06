package np.com.anilpaudel.agro;

        import android.content.Intent;
        import android.graphics.Typeface;
        import android.os.Bundle;
        import android.os.PersistableBundle;
        import android.support.v7.app.AppCompatActivity;
        import android.widget.ImageView;
        import android.widget.TextView;
        import android.widget.Toast;

public class DetailActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Intent intent=getIntent();
        String type=intent.getStringExtra("type");
        if(type.equals("request")) {
            String item_categories = intent.getStringExtra("item_categories");
            String req_user_name = intent.getStringExtra("req_user_name");
            String quantity_unit = intent.getStringExtra("quantity_unit");
            String item_name = intent.getStringExtra("item_name ");
            String req_price = intent.getStringExtra("req_price");
            String req_price_unit = intent.getStringExtra("req_price_unit");
            String quantity = intent.getStringExtra("quantity");
            String req_end_date = intent.getStringExtra("req_end_date");
            String req_address = intent.getStringExtra("req_address");
            String distance = intent.getStringExtra("distance");
            String req_address_name = intent.getStringExtra("req_address_name");
            String req_address_latitude = intent.getStringExtra("req_address_latitude");
            String req_address_longitude = intent.getStringExtra("req_address_longitude");
            String req_description = intent.getStringExtra("req_description");
            String req_user_id = intent.getStringExtra("req_user_id");
            String req_occupation = intent.getStringExtra("req_occupation ");
            String req_email = intent.getStringExtra("req_email");
            String req_contact_no = intent.getStringExtra("req_contact_no");
            String request_timestamp = intent.getStringExtra("request_timestamp");
      /*  Toast.makeText(getApplicationContext(),"the datas are"+item_categories+
                req_user_name+
                quantity_unit+
                item_name +
                req_price+
                req_price_unit+
                quantity+
                req_end_date+
                req_address+
                req_address_name+
                req_address_latitude+
                req_address_longitude+
                req_description+
                req_user_id+
                req_occupation +
                req_email+
                req_contact_no+
                request_timestamp,Toast.LENGTH_SHORT).show();
*/
            ImageView image = (ImageView) findViewById(R.id.image_category);
            switch (item_categories) {
                case "fruits": {
                    image.setImageResource(R.drawable.img_fruits);
                    break;
                }
                case "vegetable": {
                    image.setImageResource(R.drawable.img_vegetables);
                    break;
                }
                case "crops": {
                    image.setImageResource(R.drawable.img_crops);
                    break;
                }
                case "others": {
                    image.setImageResource(R.drawable.img_agro);
                    break;
                }
                default: {
                    image.setImageResource(R.drawable.img_agro);
                    break;
                }
            }
            TextView view_agro_category = (TextView) findViewById(R.id.view_agro_category);
            view_agro_category.setText("Request Details:");
            view_agro_category.setTypeface(null, Typeface.BOLD);
            TextView view_item_names = (TextView) findViewById(R.id.view_item_name);
            view_item_names.setText("Product Name:" + item_name);
            TextView view_issue_date = (TextView) findViewById(R.id.view_issue_date);
            view_issue_date.setText("Issue Date: " + request_timestamp);
            TextView view_quantity = (TextView) findViewById(R.id.view_quantity);
            view_quantity.setText("Quantity:" + quantity + " " + quantity_unit);
            TextView view_price = (TextView) findViewById(R.id.view_price);
            view_price.setText("Price:" + req_price + "per" + req_price_unit);
            TextView view_name = (TextView) findViewById(R.id.view_name);
            view_name.setText("Person Name:" + req_user_name);
            TextView view_address = (TextView) findViewById(R.id.view_address);
            view_address.setText("Location:" + req_address);
            TextView view_distance = (TextView) findViewById(R.id.view_distance);
            view_distance.setText("Distance:" +distance+" m" );
            TextView view_contact_no = (TextView) findViewById(R.id.view_contact_no);
            view_contact_no.setText("Contact No:" + req_contact_no);
            TextView view_email = (TextView) findViewById(R.id.view_email);
            view_email.setText("Email:" + req_email);
        }
        else
        {
            String item_categories = intent.getStringExtra("item_categories");
            String pro_user_name = intent.getStringExtra("pro_user_name");
            String quantity_unit = intent.getStringExtra("quantity_unit");
            String item_name = intent.getStringExtra("item_name ");
            String pro_price = intent.getStringExtra("pro_price");
            String pro_price_unit = intent.getStringExtra("pro_price_unit");
            String quantity = intent.getStringExtra("quantity");
            String pro_end_date = intent.getStringExtra("pro_end_date");
            String pro_address = intent.getStringExtra("pro_address");
            String pro_address_name = intent.getStringExtra("pro_address_name");
            String pro_address_latitude = intent.getStringExtra("pro_address_latitude");
            String pro_address_longitude = intent.getStringExtra("pro_address_longitude");
            String pro_description = intent.getStringExtra("pro_description");
            String pro_user_id = intent.getStringExtra("pro_user_id");
            String pro_occupation = intent.getStringExtra("pro_occupation ");
            String pro_email = intent.getStringExtra("pro_email");
            String pro_contact_no = intent.getStringExtra("pro_contact_no");
            String product_timestamp = intent.getStringExtra("product_timestamp");
            String distance = intent.getStringExtra("distance");
      /*  Toast.makeText(getApplicationContext(),"the datas are"+item_categories+
                pro_user_name+
                quantity_unit+
                item_name +
                pro_price+
                pro_price_unit+
                quantity+
                pro_end_date+
                pro_address+
                pro_address_name+
                pro_address_latitude+
                pro_address_longitude+
                pro_description+
                pro_user_id+
                pro_occupation +
                pro_email+
                pro_contact_no+
                product_timestamp,Toast.LENGTH_SHORT).show();
*/
            ImageView image = (ImageView) findViewById(R.id.image_category);
            switch (item_categories) {
                case "fruits": {
                    image.setImageResource(R.drawable.img_fruits);
                    break;
                }
                case "vegetable": {
                    image.setImageResource(R.drawable.img_vegetables);
                    break;
                }
                case "crops": {
                    image.setImageResource(R.drawable.img_crops);
                    break;
                }
                case "others": {
                    image.setImageResource(R.drawable.img_agro);
                    break;
                }
                default: {
                    image.setImageResource(R.drawable.img_agro);
                    break;
                }
            }

            TextView view_agro_category = (TextView) findViewById(R.id.view_agro_category);
            view_agro_category.setText("Product Details:");
            view_agro_category.setTypeface(null, Typeface.BOLD);
            TextView view_item_names = (TextView) findViewById(R.id.view_item_name);
            view_item_names.setText("Product Name:" + item_name);
            TextView view_issue_date = (TextView) findViewById(R.id.view_issue_date);
            view_issue_date.setText("Issue Date: " + product_timestamp);
            TextView view_quantity = (TextView) findViewById(R.id.view_quantity);
            view_quantity.setText("Quantity:" + quantity + " " + quantity_unit);
            TextView view_price = (TextView) findViewById(R.id.view_price);
            view_price.setText("Price:" + pro_price + "per" + pro_price_unit);
            TextView view_name = (TextView) findViewById(R.id.view_name);
            view_name.setText("Person Name:" + pro_user_name);
            TextView view_address = (TextView) findViewById(R.id.view_address);
            view_address.setText("Location:" + pro_address);
            TextView view_distance = (TextView) findViewById(R.id.view_distance);
            view_distance.setText("Distance:" +distance+" m" );
            TextView view_contact_no = (TextView) findViewById(R.id.view_contact_no);
            view_contact_no.setText("Contact No:" + pro_contact_no);
            TextView view_email = (TextView) findViewById(R.id.view_email);
            view_email.setText("Email:" + pro_email);
        }
    }
}
