package whatsfordinner.comp3717.bcit.ca.whatsfordinner;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import whatsfordinner.comp3717.bcit.ca.whatsfordinner.adaptor.MealArrayAdapter;

public class MealActivity extends ListActivity {

    static final String[] FoodList = new String[] { "Pizza", "Tortellini",
            "Spaghetti", "Cake"};
   // String food;
   // int foodNum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_meal);

        //setListAdapter(new ArrayAdapter<String>(this, R.layout.list_mobile,
        //		R.id.label, MOBILE_OS));

        // test test

        setListAdapter(new MealArrayAdapter(this, FoodList));
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        String food;
         int foodNum;

        //get selected items
        foodNum = position;
        food = (String) getListAdapter().getItem(position);
        Log.d("foodNum: ", String.valueOf(position));
        Log.d("foodName: ", food);
        Toast.makeText(this, food, Toast.LENGTH_LONG).show();

        Intent intent = new Intent(this, RecipeActivity.class);
        intent.putExtra("Food Name", foodNum);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void loadRecipe(final View view) {

    }
}

