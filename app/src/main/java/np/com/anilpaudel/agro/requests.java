package np.com.anilpaudel.agro;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
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
public class requests extends AppCompatActivity {

    private ArrayList<Property> rentalProperties = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_requests);
        final ArrayAdapter<Property> adapter = new propertyArrayAdapter(this, 0, rentalProperties);

        final RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        StringRequest stringRequest = new StringRequest(Request.Method.POST, "http://192.168.0.7/agro/request_list.php", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {

                //    Toast.makeText(getApplicationContext(), "toast no 1     "+response, Toast.LENGTH_SHORT).show();
                    JSONArray mainObject = new JSONArray(response);
                    for (int n = 0; n < mainObject.length(); n++) {
                        JSONObject result = mainObject.getJSONObject(n);

                        String item_categories= result.getString("item_categories");
                        String req_user_name= result.getString("req_user_name");

                        String quantity_unit= result.getString("quantity_unit");
                        String item_name= result.getString("item_name");
                        String req_price= result.getString("req_price");
                        String req_price_unit= result.getString("req_price_unit");
                        String quantity= result.getString("quantity");
                        String req_end_date= result.getString("req_end_date");
                        String req_address= result.getString("req_address");
                        String req_address_name= result.getString("req_address_name");
                        String req_address_latitude= result.getString("req_address_latitude");
                        String req_address_longitude= result.getString("req_address_longitude");
                        String req_description= result.getString("req_description");
                        String req_user_id= result.getString("req_user_id");
                        String req_occupation= result.getString("req_occupation");
                        String req_email= result.getString("req_email");
                        String req_contact_no= result.getString("req_contact_no");
                        //   Toast.makeText(getApplicationContext(), "toast no 5     ", Toast.LENGTH_SHORT).show();
                        String request_timestamp= result.getString("request_timestamp");
                        rentalProperties.add(new Property(item_categories,
                                req_user_name,
                                quantity_unit,
                                item_name ,
                                req_price,
                                req_price_unit,
                                quantity,
                                req_end_date,
                                req_address,
                                req_address_name,
                                req_address_latitude,
                                req_address_longitude,
                                req_description,
                                req_user_id,
                                req_occupation ,
                                req_email,
                                req_contact_no,
                                request_timestamp));
                    }

                    ListView listView = (ListView) findViewById(R.id.customListView);

                    listView.setAdapter(adapter);
                    AdapterView.OnItemClickListener adapterViewListener = new AdapterView.OnItemClickListener() {

                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                            Property property = rentalProperties.get(position);
                            Intent intent = new Intent(requests.this, DetailActivity.class);
                            intent.putExtra("item_categories", property.getItem_categories());
                            intent.putExtra("req_user_name", property.getReq_user_name());
                            intent.putExtra("quantity_unit", property.getQuantity_unit());
                            intent.putExtra("item_name ", property.getItem_name());
                            intent.putExtra("req_price", property.getReq_price());
                            intent.putExtra("req_price_unit", property.getReq_price_unit());
                            intent.putExtra("quantity", property.getQuantity());
                            intent.putExtra("req_end_date", property.getReq_end_date());
                            intent.putExtra("req_address", property.getReq_address());
                            intent.putExtra("req_address_name", property.getReq_address_name());
                            intent.putExtra("req_address_latitude", property.getReq_address_latitude());
                            intent.putExtra("req_address_longitude", property.getReq_address_longitude());
                            intent.putExtra("req_description", property.getReq_description());
                            intent.putExtra("req_user_id", property.getReq_user_id());
                            intent.putExtra("req_occupation ", property.getReq_occupation());
                            intent.putExtra("req_email", property.getReq_email());
                            intent.putExtra("req_contact_no", property.getReq_contact_no());
                            intent.putExtra("request_timestamp", property.getRequest_timestamp());
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
                Toast.makeText(requests.this, "You are not con" + error.getMessage(), Toast.LENGTH_LONG).show();
                error.printStackTrace();
                requestQueue.stop();

            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                       /* params.put("contact_no",numberPerson);
                        params.put("password",mpassword);
                        params.put("full_name",names);
                        params.put("blood_group",blood_group);
                        params.put("age",agePerson);
                        params.put("sex",sexPerson);
                        params.put("email",emailadd);
                        params.put("address",maddress);
                        params.put("address_latitude",Tlatit);
                        params.put("address_longitude",Tlongi);
                        */
                return params;
            }
        };

        requestQueue.add(stringRequest);


    }


    //custom ArrayAdapater
    class propertyArrayAdapter extends ArrayAdapter<Property> {

        private Context context;
        private List<Property> rentalProperties;

        //constructor, call on creation
        public propertyArrayAdapter(Context context, int resource, ArrayList<Property> objects) {
            super(context, resource, objects);

            this.context = context;
            this.rentalProperties = objects;
        }

        //called when rendering the list
        public View getView(int position, View convertView, ViewGroup parent) {

            //get the property we are displaying
            Property property = rentalProperties.get(position);

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

            //set address and description
            //     String completeAddress = property.getStreetNumber() + " " + property.getStreetName() + ", " + property.getSuburb() + ", " + property.getState();
            //  address.setText(completeAddress);

            //display trimmed excerpt for description
            //   int descriptionLength = property.getDescription().length();
            //  if(descriptionLength >= 100){
            //    String descriptionTrim = property.getDescription().substring(0, 100) + "...";
            //  description.setText(descriptionTrim);
            //  }else{
            //    description.setText(property.getDescription());
            // }

            //set price and rental attributes
            //
            category.setText( String.valueOf(property.getItem_categories()));
            view_time.setText(String.valueOf(property.getRequest_timestamp()));
            view_address.setText(String.valueOf(property.getReq_address_name()));
            view_name.setText( String.valueOf(property.getItem_name()));

            //get the image associated with this property
            String cate=String.valueOf(property.getItem_categories());
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

