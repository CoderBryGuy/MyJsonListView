package news.obsidian.myjsonlistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;

public class Main2Activity extends AppCompatActivity {

    final static String JSON_ARRAY = "json_array";
    ListView listView;
    JsonAdapter jsonAdapter;
    JSONArray jsonArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        String jsonString = (String)getIntent().getExtras().get(JSON_ARRAY);

        try {
            jsonArray = new JSONArray(jsonString);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        listView = (ListView)findViewById(R.id.listViewMain2Activity);
        jsonAdapter = new JsonAdapter(this, jsonArray);
        listView.setAdapter(jsonAdapter);
    }


}
