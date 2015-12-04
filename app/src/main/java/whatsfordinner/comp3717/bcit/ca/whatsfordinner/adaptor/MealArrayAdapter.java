package whatsfordinner.comp3717.bcit.ca.whatsfordinner.adaptor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import whatsfordinner.comp3717.bcit.ca.whatsfordinner.R;

/**
 * Created by Byunghak on 11/20/2015.
 */

public class MealArrayAdapter extends ArrayAdapter<String> {
    private final Context context;
    private final String[] values;

    public MealArrayAdapter(Context context, String[] values) {
        super(context, R.layout.activity_meal, values);
        this.context = context;
        this.values = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.activity_meal, parent, false);
        TextView textView = (TextView) rowView.findViewById(R.id.label);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.logo);
        textView.setText(values[position]);

        // Change icon based on name
        String s = values[position];
        System.out.println(s);


        if (s.equals("Pizza")) {
            imageView.setImageResource(R.drawable.pizza);
        } else if (s.equals("Tortellini")) {
            imageView.setImageResource(R.drawable.tortellini);
        } else  if (s.equals("Spaghetti")) {
            imageView.setImageResource(R.drawable.spaghetti);
        } else if (s.equals("Cake")) {
            imageView.setImageResource(R.drawable.cake);
        }
        return rowView;
    }
}

