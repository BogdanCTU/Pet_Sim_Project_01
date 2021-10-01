public class Food {

    // variables
    public String food_Name;
    public int pet_Height;
    public int pet_Weight;
    private int food_Price;
    private int pet_Water;
    private int pet_Food;

    // constructor
    public Pet(String proprietar, String locatie, int area, int sold) {
        this.pet_Name = pet_Name;
        this.pet_Height = pet_Height;
        this.pet_Weight = pet_Weight;
        this.pet_Wealth = pet_Wealth;
        this.pet_Water = pet_Water;
        this.pet_Food = pet_Food;
    }

    // get / set
    public void setPet_Wealth (int Wealth) {this.pet_Wealth = Wealth; };
    public void setPet_Water (int Water) {this.pet_Water = Water; };
    public void setPet_Food (int Food) {this.pet_Food = Food; };

    public int getPet_Wealth () {return this.pet_Wealth; };
    public int getPet_Water () {return this.pet_Water; };
    public int getPet_Foodr () {return this.pet_Food; };

}
