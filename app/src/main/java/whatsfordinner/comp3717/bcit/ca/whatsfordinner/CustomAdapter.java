package whatsfordinner.comp3717.bcit.ca.whatsfordinner;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import whatsfordinner.comp3717.bcit.ca.whatsfordinner.R;

/**
 * Created by Sliver of Light on 2015-11-26.
 */
public class CustomAdapter extends ArrayAdapter<FoodItem> {

    FoodItem[] items = null;
    Context context;

    public CustomAdapter(Context context, FoodItem[] resource) {
        super(context, R.layout.custom_row, resource);
        this.context = context;
        this.items = resource;
    }
    @Override
    public View getView(int position, View customView, ViewGroup parent) {
        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
        customView              = inflater.inflate(R.layout.custom_row, parent, false);
        TextView name           = (TextView) customView.findViewById(R.id.item);
        CheckBox cb             = (CheckBox) customView.findViewById(R.id.checkbox);

        name.setText(items[position].getName());

        if(items[position].getValue() == 1)
            cb.setChecked(true);
        else
            cb.setChecked(false);

        return customView;
    }
}
