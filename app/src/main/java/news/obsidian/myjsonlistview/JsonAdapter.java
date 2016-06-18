package news.obsidian.myjsonlistview;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;

/**
 * Created by Bryan on 6/18/2016.
 */
public class JsonAdapter extends ArrayAdapter<JSONArray>{

    Activity activity;

    public JsonAdapter(Activity activity, JSONArray jsonArr) {
        super(activity, R.layout.json_item);
        this.activity = activity;
    }

    static class ViewContainer{
        TextView firstName;
        TextView lastName;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewContainer vc = new ViewContainer();
        View rowView = convertView;
        if(rowView != null){
            LayoutInflater inflater = activity.getLayoutInflater();
            rowView = inflater.inflate(R.layout.json_item, parent, false);
            vc.firstName = (TextView)rowView.findViewById(R.id.firstNameJsonItem);
            vc.lastName =(TextView)rowView.findViewById(R.id.lastNameJsonItem);
            rowView.setTag(vc);
        }
        else{
            vc = (ViewContainer)rowView.getTag();
        }

        return rowView;
    }
}
