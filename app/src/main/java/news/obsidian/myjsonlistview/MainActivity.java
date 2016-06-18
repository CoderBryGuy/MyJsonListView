package news.obsidian.myjsonlistview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    Button btn;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button)findViewById(R.id.btn);
        textView = (TextView)findViewById(R.id.textView);

        final JSONArray jsonExArr = createJsonExample();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
           // textView.setText(jsonExArr.toString());
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                intent.putExtra("JSON_ARRAY",jsonExArr.toString());
                startActivity(intent);
            }
        });
    }

    private JSONArray createJsonExample() {
       JSONArray jsonExArr = new JSONArray();

        JSONObject jsonEx = new JSONObject();



        try {
            jsonEx.put("firstName", "Bryan Dov");
            jsonEx.put("lastName", "Bergman");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        jsonExArr.put(jsonEx);

        JSONObject jsonOb1 = new JSONObject();
        try {
            jsonOb1.put("firstName", "Happy");
            jsonOb1.put("lastName", "Gilmore");

        } catch (JSONException e) {
            e.printStackTrace();
        }

        jsonExArr.put(jsonOb1);

        JSONObject jsonOb2 = new JSONObject();
        try {
            jsonOb2.put("firstName", "Billy");
            jsonOb2.put("lastName", "Madison");

        } catch (JSONException e) {
            e.printStackTrace();
        }

        jsonExArr.put(jsonOb2);
        return jsonExArr;
    }
}
