package np.com.anilpaudel.agro;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class my_activity extends AppCompatActivity {


    private ArrayList<Property2> rentalProperties = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_activity);
        final ArrayAdapter<Property2> adapter = new Property2ArrayAdapter(this, 0, rentalProperties);
        final preferences_server_ip ip=new preferences_server_ip(getApplicationContext());
        final preferences_user_details user_details=new preferences_user_details(getApplicationContext());

        final RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        StringRequest stringRequest = new StringRequest(Request.Method.POST, ip.ip_server+"my_agro_activity.php" , new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {

//                    Toast.makeText(getApplicationContext(), "toast no 1     "+response, Toast.LENGTH_SHORT).show();
                    JSONArray mainObject = new JSONArray(response);
                    for (int n = 0; n < mainObject.length(); n++) {
                        JSONObject result = mainObject.getJSONObject(n);
                        String item_categories= result.getString("item_categories");
                        String user_name= result.getString("user_name");
                        Toast.makeText(getApplicationContext(), "toast no 5     ", Toast.LENGTH_SHORT).show();
                        String quantity_unit= result.getString("quantity_unit");
                        String item_name= result.getString("item_name");
                        String price= result.getString("price");
                        String price_unit= result.getString("price_unit");
                        Toast.makeText(getApplicationContext(), "toast no 6     ", Toast.LENGTH_SHORT).show();
                        String quantity= result.getString("quantity");
                        String end_date= result.getString("end_date");
                        String address= result.getString("address");
                        String address_name= result.getString("address_name");
                        String address_latitude= result.getString("address_latitude");
                        String address_longitude= result.getString("address_longitude");
                        String description= result.getString("description");
                        Toast.makeText(getApplicationContext(), "toast no 7     ", Toast.LENGTH_SHORT).show();
                        String user_id= result.getString("user_id");
                        String occupation= result.getString("occupation");
                        String email= result.getString("email");
                        String contact_no= result.getString("contact_no");
                        Toast.makeText(getApplicationContext(), "toast no 8     ", Toast.LENGTH_SHORT).show();
                        String distance= result.getString("distance");
                        String agro_type= result.getString("type");
                           Toast.makeText(getApplicationContext(), "toast no 9     ", Toast.LENGTH_SHORT).show();
                        String timestamp= result.getString("timestamp");
                        rentalProperties.add(new Property2(item_categories,
                                user_name,
                                quantity_unit,
                                item_name ,
                                price,
                                price_unit,
                                quantity,
                                end_date,
                                address,
                                address_name,
                                address_latitude,
                                address_longitude,
                                description,
                                user_id,
                                occupation ,
                                email,
                                contact_no,
                                timestamp,
                                distance,
                                agro_type));
                    }
                    Toast.makeText(getApplicationContext(), "toast no 10     ", Toast.LENGTH_SHORT).show();
                    ListView listView = (ListView) findViewById(R.id.customListView);
                    Toast.makeText(getApplicationContext(), "toast no 11     ", Toast.LENGTH_SHORT).show();
                    listView.setAdapter(adapter);
                    AdapterView.OnItemClickListener adapterViewListener = new AdapterView.OnItemClickListener() {

                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                            Property2 property2 = rentalProperties.get(position);
                            Intent intent = new Intent(my_activity.this, my_DetailActivity.class);
                            intent.putExtra("item_categories", property2.getItem_categories());
                            intent.putExtra("user_name", property2.getUser_name());
                            intent.putExtra("quantity_unit", property2.getQuantity_unit());
                            intent.putExtra("item_name ", property2.getItem_name());
                            intent.putExtra("price", property2.getPrice());
                            intent.putExtra("price_unit", property2.getPrice_unit());
                            intent.putExtra("quantity", property2.getQuantity());
                            intent.putExtra("end_date", property2.getEnd_date());
                            intent.putExtra("address", property2.getAddress());
                            intent.putExtra("address_name", property2.getAddress_name());
                            intent.putExtra("address_latitude", property2.getAddress_latitude());
                            intent.putExtra("address_longitude", property2.getAddress_longitude());
                            intent.putExtra("description", property2.getDescription());
                            intent.putExtra("user_id", property2.getUser_id());
                            intent.putExtra("occupation ", property2.getOccupation());
                            intent.putExtra("email", property2.getEmail());
                            intent.putExtra("contact_no", property2.getContact_no());
                            intent.putExtra("timestamp", property2.getTimestamp());
                            intent.putExtra("agro_type",property2.getAgrotype());
                            intent.putExtra("distance",property2.getDistance());
                            startActivity(intent);
                        }
                    };
                    //set the listener to the list view
                    listView.setOnItemClickListener(adapterViewListener);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
                requestQueue.stop();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(my_activity.this, "You are not con" + error.getMessage(), Toast.LENGTH_LONG).show();
                error.printStackTrace();
                requestQueue.stop();

            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("id_user",user_details.id_user);
                params.put("login_token",user_details.login_token);
                return params;
            }
        };

        requestQueue.add(stringRequest);


    }


    //custom ArrayAdapater
    class Property2ArrayAdapter extends ArrayAdapter<Property2> {

        private Context context;
        private List<Property2> rentalProperties;

        //constructor, call on creation
        public Property2ArrayAdapter(Context context, int resource, ArrayList<Property2> objects) {
            super(context, resource, objects);

            this.context = context;
            this.rentalProperties = objects;
        }

        //called when rendering the list
        public View getView(int position, View convertView, ViewGroup parent) {

            //get the Property2 we are displaying
            Property2 property2 = rentalProperties.get(position);

            //get the inflater and inflate the XML layout for each item
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

            //conditionally inflate either standard or special template
            View view;

            view = inflater.inflate(R.layout.property_layout_alt, null);

                TextView category = (TextView) view.findViewById(R.id.category);
                TextView view_time = (TextView) view.findViewById(R.id.view_time);
                TextView view_address = (TextView) view.findViewById(R.id.view_address);
                TextView view_name = (TextView) view.findViewById(R.id.view_name);
                ImageView image = (ImageView) view.findViewById(R.id.image_category);
            if(property2.getAgrotype()=="request") {
                category.setBackgroundColor(Color.parseColor("#ff0000"));
                view_time.setBackgroundColor(Color.parseColor("#ff0000"));
                view_address.setBackgroundColor(Color.parseColor("#ff0000"));
                view_name.setBackgroundColor(Color.parseColor("#ff0000"));
            }

            //set address and description
            //     String completeAddress = Property2.getStreetNumber() + " " + Property2.getStreetName() + ", " + Property2.getSuburb() + ", " + Property2.getState();
            //  address.setText(completeAddress);

            //display trimmed excerpt for description
            //   int descriptionLength = Property2.getDescription().length();
            //  if(descriptionLength >= 100){
            //    String descriptionTrim = Property2.getDescription().substring(0, 100) + "...";
            //  description.setText(descriptionTrim);
            //  }else{
            //    description.setText(Property2.getDescription());
            // }

            //set price and rental attributes
            //
            category.setText( String.valueOf(property2.getItem_categories()));
            view_time.setText(String.valueOf(property2.getTimestamp()));
            view_address.setText(String.valueOf(property2.getAddress_name()));
            view_name.setText( String.valueOf(property2.getItem_name()));

            //get the image associated with this Property2
            String cate=String.valueOf(property2.getItem_categories());
            String imgsrc="";
            switch (cate)
            {
                case "crops":
                {
                    imgsrc="img_crops";
                    break;
                }
                case "vegetable":
                {
                    imgsrc="img_vegetables";
                    break;
                }
                case "fruits":
                {
                    imgsrc="img_fruits";
                    break;
                }
                case "others":
                {
                    imgsrc="img_agro";
                    break;
                }
                default:
                {
                    imgsrc="img_agro";
                }
            }
            int imageID = context.getResources().getIdentifier(imgsrc, "drawable", context.getPackageName());
            image.setImageResource(imageID);

            return view;
        }
    }
}