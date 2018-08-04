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
public class agro extends AppCompatActivity {
    private final ArrayList<Property1> rentalProperties = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agro);
        final preferences_server_ip ip=new preferences_server_ip(getApplicationContext());
        final preferences_user_details user_details=new preferences_user_details(getApplicationContext());
        final ArrayAdapter<Property1> adapter = new property1ArrayAdapter(this, 0, rentalProperties);
        final RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        Toast.makeText(getApplicationContext(),user_details.contact_no,Toast.LENGTH_SHORT).show();
        StringRequest stringRequest = new StringRequest(Request.Method.POST, ip.ip_server+"product_list.php", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                   Toast.makeText(getApplicationContext(), "toast no 1     "+response, Toast.LENGTH_SHORT).show();
                    JSONArray mainObject = new JSONArray(response);
                    for (int n = 0; n < mainObject.length(); n++) {
                        JSONObject result = mainObject.getJSONObject(n);
                        String item_categories= result.getString("item_categories");
                        String pro_user_name= result.getString("pro_user_name");
                        String quantity_unit= result.getString("quantity_unit");
                        String item_name= result.getString("item_name");
                        String pro_price= result.getString("pro_price");
                        String pro_price_unit= result.getString("pro_price_unit");
                        String quantity= result.getString("quantity");
                        String pro_end_date= result.getString("pro_end_date");
                        String pro_address= result.getString("pro_address");
                        String pro_address_name= result.getString("pro_address_name");
                        String pro_address_latitude= result.getString("pro_address_latitude");
                        String pro_address_longitude= result.getString("pro_address_longitude");
                        String pro_description= result.getString("pro_description");
                        String pro_user_id= result.getString("pro_user_id");
                        String pro_occupation= result.getString("pro_occupation");
                        String pro_email= result.getString("pro_email");
                        String pro_contact_no= result.getString("pro_contact_no");
                        String product_timestamp= result.getString("product_timestamp");
                        String distance=result.getString("distance");
                        rentalProperties.add(new Property1(
                                item_categories,
                                pro_user_name,
                                quantity_unit,
                                item_name ,
                                pro_price,
                                pro_price_unit,
                                quantity,
                                pro_end_date,
                                pro_address,
                                pro_address_name,
                                pro_address_latitude,
                                pro_address_longitude,
                                pro_description,
                                pro_user_id,
                                pro_occupation ,
                                pro_email,
                                pro_contact_no,
                                product_timestamp,
                                distance));
                    }
                    Toast.makeText(getApplicationContext(), "toast no 5     ", Toast.LENGTH_SHORT).show();

                   // Toast.makeText(getApplicationContext(), "toast no 6     ", Toast.LENGTH_SHORT).show();
                    ListView listView = (ListView) findViewById(R.id.customListView);
Toast.makeText(getApplicationContext(),user_details.contact_no,Toast.LENGTH_SHORT).show();
                   // Toast.makeText(getApplicationContext(), "toast no 7     ", Toast.LENGTH_SHORT).show();
                    listView.setAdapter(adapter);
                    AdapterView.OnItemClickListener adapterViewListener = new AdapterView.OnItemClickListener() {

                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                            Property1 property1 = rentalProperties.get(position);

                            Intent intent = new Intent(agro.this, DetailActivity.class);
                            intent.putExtra("item_categories", property1.getItem_categories());
                            intent.putExtra("pro_user_name", property1.getPro_user_name());
                            intent.putExtra("quantity_unit", property1.getQuantity_unit());
                            intent.putExtra("item_name ", property1.getItem_name());
                            intent.putExtra("pro_price", property1.getPro_price());
                            intent.putExtra("pro_price_unit", property1.getPro_price_unit());
                            intent.putExtra("quantity", property1.getQuantity());
                            intent.putExtra("pro_end_date", property1.getPro_end_date());
                            intent.putExtra("pro_address", property1.getPro_address());
                            intent.putExtra("pro_address_name", property1.getPro_address_name());
                            intent.putExtra("pro_address_latitude", property1.getPro_address_latitude());
                            intent.putExtra("pro_address_longitude", property1.getPro_address_longitude());
                            intent.putExtra("pro_description", property1.getPro_description());
                            intent.putExtra("pro_user_id", property1.getPro_user_id());
                            intent.putExtra("pro_occupation ", property1.getPro_occupation());
                            intent.putExtra("pro_email", property1.getPro_email());
                            intent.putExtra("pro_contact_no", property1.getPro_contact_no());
                            intent.putExtra("product_timestamp", property1.getProduct_timestamp());
                            intent.putExtra("distance",property1.getDistance());
                            intent.putExtra("type","product");
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
                Toast.makeText(agro.this, "You are not con" + error.getMessage(), Toast.LENGTH_LONG).show();
                error.printStackTrace();
                requestQueue.stop();

            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                       params.put("id_user",user_details.id_user);
                       params.put("login_token",user_details.login_token);
                        /*
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
    class property1ArrayAdapter extends ArrayAdapter<Property1> {

        private Context context;
        private List<Property1> rentalProperties;

        //constructor, call on creation
        public property1ArrayAdapter(Context context, int resource, ArrayList<Property1> objects) {
            super(context, resource, objects);

            this.context = context;
            this.rentalProperties = objects;
        }

        //called when rendering the list
        public View getView(int position, View convertView, ViewGroup parent) {

            //get the property we are displaying
            Property1 property1 = rentalProperties.get(position);

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
            //     String completeAddress = property1.getStreetNumber() + " " + property1.getStreetName() + ", " + property1.getSuburb() + ", " + property1.getState();
            //  address.setText(completeAddress);

            //display trimmed excerpt for description
            //   int descriptionLength = property1.getDescription().length();
            //  if(descriptionLength >= 100){
            //    String descriptionTrim = property1.getDescription().substring(0, 100) + "...";
            //  description.setText(descriptionTrim);
            //  }else{
            //    description.setText(property1.getDescription());
            // }

            //set price and rental attributes
            //
            category.setText( String.valueOf(property1.getItem_categories()));
            view_time.setText(String.valueOf(property1.getProduct_timestamp()));
            view_address.setText(String.valueOf(property1.getPro_address_name()));
            view_name.setText( String.valueOf(property1.getItem_name()));

            //get the image associated with this property
            String cate=String.valueOf(property1.getItem_categories());
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
