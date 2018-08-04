package np.com.anilpaudel.agro;

import android.content.Context;
import android.content.SharedPreferences;

public class preferences_user_details {

    String id_user,
    address,
    address_name,
    age,
    contact_no,
    email,
    full_name,
    gender,
    id,
    login_status,
    login_token;

    public  preferences_user_details(Context a)
    {
        SharedPreferences pref = a.getSharedPreferences("user_details", 0); // 0 - for private mode
        this.id_user=pref.getString("p_l_id", null); // getting String
        this.address=pref.getString("p_l_address", null); // getting String
        this.address_name=pref.getString("p_l_address_name", null); // getting String
        this.age=pref.getString("p_l_age", null); // getting String
        this.contact_no=pref.getString("p_l_contact_no", null); // getting String
        this.email=pref.getString("p_l_email", null); // getting String
        this.full_name=pref.getString("p_l_full_name", null); // getting String
        this.gender=pref.getString("p_l_gender", null); // getting String
        this.id=pref.getString("p_l_id", null); // getting String
        this.login_status=pref.getString("p_l_login_status", null); // getting String
        this.login_token=pref.getString("p_l_login_token", null); // getting String
    }
}
