package whatsfordinner.comp3717.bcit.ca.whatsfordinner;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
/**
 * Created by Soran on 12/3/2015.
 */

public class RecipeActivity extends AppCompatActivity {
    StringBuilder sb = new StringBuilder();
    String[] PizzaItem = {"Chicken", "corn"};
    String[] TortelliniItem = {"Chicken", "corn", "pasta"};
    String[] SpaghettiItem = {"Chicken", "tomato", "pasta"};
    String[] CakeItem = {"carrot", "flour"};
    String[] URL ={"http://www.jamieoliver.com/recipes/vegetables-recipes/gennaro-s-mini-pizzas-with-hidden-veg-sauce/#7yrA2z4MGYRlQvmg.97",
            "http://www.gimmesomeoven.com/5-ingredient-easy-tortellini-soup-recipe/",
            "http://allrecipes.com/recipe/233348/wedding-gift-spaghetti-sauce/",
            "http://allrecipes.com/recipe/81201/a-plus-carrot-cake/?internalSource=rotd&referringId=276&referringContentType=recipe%20hub"};

    static final String[] MealList = new String[] { "Pizza", "Tortellini",
            "Spaghetti", "Cake"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final Intent intent;
        final int str;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);
        TextView txtView = (TextView) findViewById(R.id.foodName);
        intent = getIntent();
        str = intent.getIntExtra("Food Name", 0);
        Log.d("recipeFood: ", String.valueOf(str));
        TextView txtView2 = (TextView) findViewById(R.id.ingredientsName);
        ImageButton recipeLinkButton = (ImageButton) findViewById(R.id.recipeLinkButton);
        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) recipeLinkButton.getLayoutParams();
        params.height = 800;
        params.width = 900;
        recipeLinkButton.setLayoutParams(params);
        recipeLinkButton.setScaleType(ImageView.ScaleType.FIT_XY);
        if(str == 0) {
            txtView.setText("Food Name: "+ MealList[0]);
            for(int i = 0; i < PizzaItem.length; i++)
                sb.append(PizzaItem[i] + ", ");
            recipeLinkButton.setImageResource(R.drawable.pizza);
        }
        if(str == 1) {
            txtView.setText("Food Name: "+ MealList[1]);
            for(int i = 0; i < TortelliniItem.length; i++)
                sb.append(TortelliniItem[i] + ", ");
            recipeLinkButton.setImageResource(R.drawable.tortellini);
        }
        if(str == 2) {
            txtView.setText("Food Name: "+MealList[2]);
            for(int i = 0; i < SpaghettiItem.length; i++)
                sb.append(SpaghettiItem[i] + ", ");
            recipeLinkButton.setImageResource(R.drawable.spaghetti);
        }
        if(str == 3) {
            txtView.setText("Food Name: "+ MealList[3]);
            for(int i = 0; i < CakeItem.length; i++)
                sb.append(CakeItem[i] + ", ");
            recipeLinkButton.setImageResource(R.drawable.cake);
        }
        txtView2.setText(sb.toString());
        recipeLinkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(URL[str]));
                startActivity(browserIntent);
            }
        });

    }
    public void loadMain(final View view) {

        Intent intent = new Intent(this, MainActivity.class);
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
}
