public class Food {

    // variables
    public String food_Name;
    public int food_Heal;
    private int food_Quantity;
    private int food_Price;
    private int food_ExpireDays;

    // constructor
    public Food (String food_Name, int food_Heal, int food_Quantity, int food_Price, int food_ExpireDays ) {
        this.food_Name = food_Name;
        this.food_Heal = food_Heal;
        this.food_Quantity = food_Quantity;
        this.food_Price = food_Price;
        this.food_ExpireDays = food_ExpireDays;

    }

    // get / set
    public void setfood_Quantity (int Quantity) {this.food_Quantity = Quantity; };
    public void setfood_Price (int Price) {this.food_Price = Price; };
    public void setfood_ExpireDays (int ExpireDays) {this.food_ExpireDays = ExpireDays; };

    public int getfood_Quantity () {return this.food_Quantity; };
    public int getfood_Price () {return this.food_Price; };
    public int getfood_ExpireDays () {return this.food_ExpireDays; };

}
