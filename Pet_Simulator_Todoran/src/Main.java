import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;
import java.util.Random;


public class Main {

    //main
    public static void main(String[] args) throws InterruptedException, IOException {
        Scanner sc = new Scanner(System.in);
        Random rnd = new Random();

        // Variables
        int day = 1, temp_Day = 1, money = 0, pets = 0, random_Names = 0, random_Sex = 0;
        boolean game_Over = false;
        String insert_Data = new String();

        // Objets
        Pet[] my_Pets = Metode.GetPets();

        // Foods
        Food[] drinks = Metode.GetDrinks();
        Food[] foods = Metode.GetFood();

        // Program critical point
        insert_Data = Metode.GetInsertDataAnswer();

        //compare string
        if ((Objects.equals(insert_Data, "yes"))) {
            // User Data
            Metode.GetMoney(money);
            pets = Metode.GetPetsNum();

            // Pets Data
            my_Pets = Metode.GetPetsData(my_Pets, pets);

            //simulator
            while (!game_Over) {
                // console clear command?!?!?

                // Console Simulator
                Metode.DayConsole(day);

                // Decrease Health Conditions
                Metode.DecreaseHealthConditions(my_Pets, pets);

                //simulating
                //Metode.SimulatePets(my_Pets, pets);

                for (int i = 0; i < pets; ++i) {
                    // Pet Water Need
                    Metode.PetWaterNeed(my_Pets, i);
                    Metode.PetWaterManual(money, drinks, my_Pets, i);

                    // Pet Food Need
                    Metode.PetFoodNeed(my_Pets, i);
                    Metode.PetFoodManual(money, foods, my_Pets, i);

                    //Pet Health Regen
                    Metode.PetHealthRegen(my_Pets, i);
                }

                //lose condition
                game_Over = Metode.LoseCondition(my_Pets, pets, game_Over);

                //Next Day
                System.out.println("You have " + money + " money left!");
                temp_Day++;
                day++;
                if (temp_Day == 7) {
                    temp_Day = 1;
                    money += 100;
                }
            }
        } else {
            Metode.GetMoney(money);
            System.out.println("----------------------------------------------------------");
            pets = rnd.nextInt(5);
            if (pets < 1) pets = 1;

            if (pets == 1) System.out.println("You have one pet!");
            else System.out.println("You have " + pets + " pets!");

            // Generate Pets Data
            Metode.GeneratePetsData(my_Pets, pets);

            // Simulator
            while (!game_Over) {
                // Console Simulator
                Metode.DayConsole(day);

                // Decrease Health Conditions
                Metode.DecreaseHealthConditions(my_Pets, pets);

                //simulating
                for (int i = 0; i < pets; ++i) {
                    // Pet Water Need
                    Metode.PetWaterNeed(my_Pets, i);
                    Metode.PetWaterProbability(money, drinks, my_Pets, i);

                    // Pet Food Need
                    Metode.PetFoodNeed(my_Pets, i);
                    Metode.PetFoodProbability(money, foods, my_Pets, i);

                    //Pet Health Regen
                    Metode.PetHealthRegen(my_Pets, i);
                }

                //lose condition
                game_Over = Metode.LoseCondition(my_Pets, pets, game_Over);

                System.out.println("You have " + money + " money left!");
                day++;
                temp_Day++;
                if (temp_Day == 7) {
                    temp_Day = 1;
                    money += rnd.nextInt(100);
                }
            }
        }

        //End Game
        Metode.YouLost(day);
    }
}
