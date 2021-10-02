public class Pet {

    // variables
    public String pet_Name;
    public String pet_Sex;
    public String pet_Species;
    public int pet_Life;
    public int pet_Height;
    public int pet_Weight;
    private int pet_Wealth;
    private int pet_Water;
    private int pet_Food;

    // constructor
    public Pet(String pet_Name, String pet_Sex,  String pet_Species, int pet_Wealth, int pet_Food, int pet_Weight, int pet_Height, int pet_Water) {
        this.pet_Name = pet_Name;
        this.pet_Sex = pet_Sex;
        this.pet_Species = pet_Species;
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
    public int getPet_Food () {return this.pet_Food; };

}