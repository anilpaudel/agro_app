package np.com.anilpaudel.agro;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;


public class my_DetailActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_detail);
        Intent intent=getIntent();
        String type=intent.getStringExtra("agro_type");
        if(type.equals("request")) {
            String item_categories = intent.getStringExtra("item_categories");
            String user_name = intent.getStringExtra("user_name");
            String quantity_unit = intent.getStringExtra("quantity_unit");
            String item_name = intent.getStringExtra("item_name ");
            String price = intent.getStringExtra("price");
            String price_unit = intent.getStringExtra("price_unit");
            String quantity = intent.getStringExtra("quantity");
            String end_date = intent.getStringExtra("end_date");
            String address = intent.getStringExtra("address");
            String distance = intent.getStringExtra("distance");
            String address_name = intent.getStringExtra("address_name");
            String address_latitude = intent.getStringExtra("address_latitude");
            String address_longitude = intent.getStringExtra("address_longitude");
            String description = intent.getStringExtra("description");
            String user_id = intent.getStringExtra("user_id");
            String occupation = intent.getStringExtra("occupation ");
            String email = intent.getStringExtra("email");
            String contact_no = intent.getStringExtra("contact_no");
            String request_timestamp = intent.getStringExtra("timestamp");
      /*  Toast.makeText(getApplicationContext(),"the datas are"+item_categories+
                user_name+
                quantity_unit+
                item_name +
                price+
                price_unit+
                quantity+
                end_date+
                address+
                address_name+
                address_latitude+
                address_longitude+
                description+
                user_id+
                occupation +
                email+
                contact_no+
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
            view_price.setText("Price:" + price + "per" + price_unit);
            TextView view_name = (TextView) findViewById(R.id.view_name);
            view_name.setText("Person Name:" + user_name);
            TextView view_address = (TextView) findViewById(R.id.view_address);
            view_address.setText("Location:" + address);
            TextView view_distance = (TextView) findViewById(R.id.view_distance);
            view_distance.setText("Distance:" +distance+" m" );
            TextView view_contact_no = (TextView) findViewById(R.id.view_contact_no);
            view_contact_no.setText("Contact No:" + contact_no);
            TextView view_email = (TextView) findViewById(R.id.view_email);
            view_email.setText("Email:" + email);
        }
        else
        {
            String item_categories = intent.getStringExtra("item_categories");
            String user_name = intent.getStringExtra("user_name");
            String quantity_unit = intent.getStringExtra("quantity_unit");
            String item_name = intent.getStringExtra("item_name ");
            String price = intent.getStringExtra("price");
            String price_unit = intent.getStringExtra("price_unit");
            String quantity = intent.getStringExtra("quantity");
            String end_date = intent.getStringExtra("end_date");
            String address = intent.getStringExtra("address");
            String address_name = intent.getStringExtra("address_name");
            String address_latitude = intent.getStringExtra("address_latitude");
            String address_longitude = intent.getStringExtra("address_longitude");
            String description = intent.getStringExtra("description");
            String user_id = intent.getStringExtra("user_id");
            String occupation = intent.getStringExtra("occupation ");
            String email = intent.getStringExtra("email");
            String contact_no = intent.getStringExtra("contact_no");
            String product_timestamp = intent.getStringExtra("timestamp");
            String distance = intent.getStringExtra("distance");
      /*  Toast.makeText(getApplicationContext(),"the datas are"+item_categories+
                user_name+
                quantity_unit+
                item_name +
                price+
                price_unit+
                quantity+
                end_date+
                address+
                address_name+
                address_latitude+
                address_longitude+
                description+
                user_id+
                occupation +
                email+
                contact_no+
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
            view_price.setText("Price:" + price + "per" + price_unit);
            TextView view_name = (TextView) findViewById(R.id.view_name);
            view_name.setText("Person Name:" + user_name);
            TextView view_address = (TextView) findViewById(R.id.view_address);
            view_address.setText("Location:" + address);
            TextView view_distance = (TextView) findViewById(R.id.view_distance);
            view_distance.setText("Distance:" +distance+" m" );
            TextView view_contact_no = (TextView) findViewById(R.id.view_contact_no);
            view_contact_no.setText("Contact No:" + contact_no);
            TextView view_email = (TextView) findViewById(R.id.view_email);
            view_email.setText("Email:" + email);
        }
    }
}
