package np.com.anilpaudel.agro;

import android.content.Context;
import android.content.SharedPreferences;

public class preferences_server_ip {

    String ip_server,
            ip_flask,
            ip_node_mcu;
    public preferences_server_ip(Context a)
    {
        SharedPreferences pref = a.getSharedPreferences("server_set_up", 0); // 0 - for private mode
        this.ip_server=pref.getString("server_ip", null); // getting String
        this.ip_flask=pref.getString("flask_ip", null); // getting String
        this.ip_node_mcu=pref.getString("node_mcu_ip", null); // getting String
    }
}
