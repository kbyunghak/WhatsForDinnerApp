package whatsfordinner.comp3717.bcit.ca.whatsfordinner;

/**
 *
 */
public class FoodItem {

    String name;
    int value;                // 0 = checkbox disabled, 1 = checkbox enabled

    FoodItem(String name, int value){
        this.name = name;
        this.value = value;
    }
    public String getName(){
        return this.name;
    }
    public int getValue(){
        return this.value;
    }


}
