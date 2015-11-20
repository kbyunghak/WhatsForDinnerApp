package whatsfordinner.comp3717.bcit.ca.whatsfordinner;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;

public class IngredientsActivity extends AppCompatActivity {

    private ListView lv_veggies;
    private ListView lv_fruits;
    private ListView lv_meat;
    private ListView lv_dairy;
    private ListView lv_grains;

    private boolean expandVeggies = true;
    private boolean expandFruits = false;
    private boolean expandMeats = false;
    private boolean expandDairy = false;
    private boolean expandGrains = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingredients);

        Button btn_veggies;
        Button btn_fruits;
        Button btn_meat;
        Button btn_dairy;
        Button btn_grains;
        ImageButton arrow_veggies;
        ImageButton arrow_fruits;
        ImageButton arrow_meat;
        ImageButton arrow_dairy;
        ImageButton arrow_grains;

        // hard coded data to display
        String[] vegetables = {"onions", "mushrooms", "spinach", "potato"};
        String[] meat = {"chicken", "beef", "bacon", "sausages", "ham"};
        String[] dairy = {"milk", "cream", "cheese", "yogurt", "butter"};
        String[] fruits = {"apple", "orange", "grapes", "banana", "strawberries"};
        String[] grains = {"bread", "rice", "beans", "pasta"};

        // set listviews,adapters, and listeners
        //ListAdapter veggiesListAdapter = new CustomAdapter(getActivity().getBaseContext(), vegetables);
        ArrayAdapter<String> veggiesListAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, vegetables);
        lv_veggies = (ListView) findViewById(R.id.veggies_listview);
        lv_veggies.setAdapter(veggiesListAdapter);
        lv_veggies.setOnItemClickListener(new loadDetails());

        //ListAdapter meatListAdapter = new CustomAdapter(getActivity().getBaseContext(), meat);
        ArrayAdapter<String> meatListAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, meat);
        lv_meat = (ListView) findViewById(R.id.meat_listview);
        lv_meat.setAdapter(meatListAdapter);
        lv_meat.setOnItemClickListener(new loadDetails());
        lv_meat.setVisibility(View.GONE);

        //ListAdapter dairyListAdapter = new CustomAdapter(getActivity().getBaseContext(), dairy);
        ArrayAdapter<String> dairyListAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, dairy);
        lv_dairy = (ListView) findViewById(R.id.dairy_listview);
        lv_dairy.setAdapter(dairyListAdapter);
        lv_dairy.setOnItemClickListener(new loadDetails());
        lv_dairy.setVisibility(View.GONE);

        //ListAdapter fruitsListAdapter = new CustomAdapter(getActivity().getBaseContext(), fruits);
        ArrayAdapter<String> fruitsListAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, fruits);
        lv_fruits = (ListView) findViewById(R.id.fruits_listview);
        lv_fruits.setAdapter(fruitsListAdapter);
        lv_fruits.setOnItemClickListener(new loadDetails());
        lv_fruits.setVisibility(View.GONE);

        //ListAdapter grainsListAdapter = new CustomAdapter(getActivity().getBaseContext(), grains);
        ArrayAdapter<String> grainsListAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, grains);
        lv_grains = (ListView) findViewById(R.id.grains_listview);
        lv_grains.setAdapter(grainsListAdapter);
        lv_grains.setOnItemClickListener(new loadDetails());
        lv_grains.setVisibility(View.GONE);

        // sets listeners for header sections to toggle open/close
        btn_veggies = (Button) findViewById(R.id.btn_veggies);
        btn_meat = (Button) findViewById(R.id.btn_meat);
        btn_dairy = (Button) findViewById(R.id.btn_dairy);
        btn_fruits = (Button) findViewById(R.id.btn_fruits);
        btn_grains = (Button) findViewById(R.id.btn_grains);
        btn_veggies.setOnClickListener(new toggleVeggiesList());
        btn_meat.setOnClickListener(new toggleMeatsList());
        btn_dairy.setOnClickListener(new toggleDairyList());
        btn_fruits.setOnClickListener(new toggleDairyList());
        btn_grains.setOnClickListener(new toggleDairyList());

        arrow_veggies = (ImageButton) findViewById(R.id.arrow_veggies);
        arrow_meat = (ImageButton) findViewById(R.id.arrow_meat);
        arrow_dairy = (ImageButton) findViewById(R.id.arrow_dairy);
        arrow_fruits = (ImageButton) findViewById(R.id.arrow_fruits);
        arrow_grains = (ImageButton) findViewById(R.id.arrow_grains);
        arrow_veggies.setOnClickListener(new toggleVeggiesList());
        arrow_meat.setOnClickListener(new toggleMeatsList());
        arrow_dairy.setOnClickListener(new toggleDairyList());
        arrow_fruits.setOnClickListener(new toggleFruitsList());
        arrow_grains.setOnClickListener(new toggleGrainsList());
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

    /**
     *  An onClick handler for the "What's for Dinner?" button to
     *  load the MealActivity page.
     */
    public void loadMealOptions(final View view) {
        Intent intent = new Intent(this, MealActivity.class);
        startActivity(intent);
    }

    /**
     * Listener for OnItemClick events on the listview items.
     * Hardcoded to load the same 'Acct Detail Activity' regardless of what item is clicked.
     */
    public class loadDetails implements AdapterView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> adapter, View view, int position, long id) {
/*
            DecimalFormat fmt = new DecimalFormat("$ #,###.00");
            String cat_name = String.valueOf(adapter.getItemAtPosition(position));
            Toast.makeText(getActivity().getBaseContext(), "Mock data for Chequing Account", Toast.LENGTH_SHORT).show();

            TextView listText = (TextView) view.findViewById(R.id.bankingType);
            String acctType = listText.getText().toString();
            String acctTotal = fmt.format(AcctSummaryFragment.acctTotals.get(cat_name));
            Intent intent = new Intent(getActivity().getBaseContext(), AcctDetailActivity.class);
            intent.putExtra("acctType", acctType);
            intent.putExtra("acctTotal", acctTotal);
            startActivity(intent);
            */
        }
    }

    /**
     * Handles toggling open and close the Veggies ListView
     */
    public class toggleVeggiesList implements Button.OnClickListener {

        @Override
        public void onClick(View view) {
            ImageButton arrow = (ImageButton) findViewById(R.id.arrow_veggies);

            if (expandVeggies) {
                lv_veggies.setVisibility(View.GONE);
                expandVeggies = false;
                arrow.setImageResource(R.drawable.ic_keyboard_arrow_down_white_36dp);
            } else {
                lv_veggies.setVisibility(View.VISIBLE);
                expandVeggies = true;
                arrow.setImageResource(R.drawable.ic_keyboard_arrow_up_white_36dp);
            }
        }
    }

    /**
     * Handles toggling open and close the Meats ListView
     */
    public class toggleMeatsList implements Button.OnClickListener {

        @Override
        public void onClick(View view) {
            ImageButton arrow = (ImageButton) findViewById(R.id.arrow_meat);

            if (expandMeats) {
                lv_meat.setVisibility(View.GONE);
                expandMeats = false;
                arrow.setImageResource(R.drawable.ic_keyboard_arrow_down_white_36dp);
            } else {
                lv_meat.setVisibility(View.VISIBLE);
                expandMeats = true;
                arrow.setImageResource(R.drawable.ic_keyboard_arrow_up_white_36dp);
            }
        }
    }

    /**
     * Handles toggling open and close the Dairy ListView
     */
    public class toggleDairyList implements Button.OnClickListener {

        @Override
        public void onClick(View view) {
            ImageButton arrow = (ImageButton) findViewById(R.id.arrow_dairy);

            if (expandDairy) {
                lv_dairy.setVisibility(View.GONE);
                expandDairy = false;
                arrow.setImageResource(R.drawable.ic_keyboard_arrow_down_white_36dp);
            } else {
                lv_dairy.setVisibility(View.VISIBLE);
                expandDairy = true;
                arrow.setImageResource(R.drawable.ic_keyboard_arrow_up_white_36dp);
            }
        }
    }

    /**
     * Handles toggling open and close the Fruits ListView
     */
    public class toggleFruitsList implements Button.OnClickListener {

        @Override
        public void onClick(View view) {
            ImageButton arrow = (ImageButton) findViewById(R.id.arrow_fruits);

            if (expandFruits) {
                lv_fruits.setVisibility(View.GONE);
                expandFruits = false;
                arrow.setImageResource(R.drawable.ic_keyboard_arrow_down_white_36dp);
            } else {
                lv_fruits.setVisibility(View.VISIBLE);
                expandFruits = true;
                arrow.setImageResource(R.drawable.ic_keyboard_arrow_up_white_36dp);
            }
        }
    }

    /**
     * Handles toggling open and close the Grains ListView
     */
    public class toggleGrainsList implements Button.OnClickListener {

        @Override
        public void onClick(View view) {
            ImageButton arrow = (ImageButton) findViewById(R.id.arrow_grains);

            if (expandGrains) {
                lv_grains.setVisibility(View.GONE);
                expandGrains = false;
                arrow.setImageResource(R.drawable.ic_keyboard_arrow_down_white_36dp);
            } else {
                lv_grains.setVisibility(View.VISIBLE);
                expandGrains = true;
                arrow.setImageResource(R.drawable.ic_keyboard_arrow_up_white_36dp);
            }
        }
    }




}