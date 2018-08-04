package np.com.anilpaudel.agro;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class server_set_up extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_server_set_up);
        SharedPreferences prefer = getApplicationContext().getSharedPreferences("server_set_up", 0); // 0 - for private mode
        final SharedPreferences.Editor editor_ip=prefer.edit();
        final EditText edit_server_ip=findViewById(R.id.edit_server_ip);
        edit_server_ip.setText(prefer.getString("server_ip",null));
        final EditText edit_node_mcu_ip=findViewById(R.id.edit_node_mcu_ip);
        edit_node_mcu_ip.setText(prefer.getString("node_mcu_ip",null));
        final EditText edit_flask_ip=findViewById(R.id.edit_flask_ip);
        edit_flask_ip.setText(prefer.getString("flask_ip",null));
        Button button_set_up_now=findViewById(R.id.button_set_up_now);
        button_set_up_now.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String server_ip=edit_server_ip.getText().toString();
                String node_mcu_ip=edit_node_mcu_ip.getText().toString();
                String flask_ip=edit_flask_ip.getText().toString();
                if(Patterns.WEB_URL.matcher(server_ip).matches() && Patterns.WEB_URL.matcher(node_mcu_ip).matches() &&
                Patterns.WEB_URL.matcher(flask_ip).matches()) {
                    editor_ip.putString("server_ip",server_ip);
                    editor_ip.putString("node_mcu_ip",node_mcu_ip);
                    editor_ip.putString("flask_ip", flask_ip);
                    editor_ip.apply();
                    Toast.makeText(getApplicationContext(),"The input is successful",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"The input is invalid.",Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}