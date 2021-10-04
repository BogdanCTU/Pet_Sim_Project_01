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
        if((Objects.equals(insert_Data, "yes"))){
            // User Data
            Metode.GetMoney(money);
            pets = Metode.GetPetsNum();

            // Pets Data
            my_Pets = Metode.GetPetsData(my_Pets, pets);

            //simulator
            while(!game_Over){
                // console clear command?!?!?

                // Console Simulator
                Metode.DayConsole(day);

                //decrease health conditions
                for (int i = 0; i < pets; ++i) {
                    my_Pets[i].setPet_Water(my_Pets[i].getPet_Water() - 25);
                    my_Pets[i].setPet_Food(my_Pets[i].getPet_Food() - 25);
                    my_Pets[i].setPet_Wealth(my_Pets[i].getPet_Wealth() - 10);
                    if(my_Pets[i].getPet_Water() <= 0 && my_Pets[i].getPet_Food() <= 0) my_Pets[i].setPet_Wealth(my_Pets[i].getPet_Wealth() - 10);
                }

                //simulating
                for (int i = 0; i < pets; ++i) {
                    if (my_Pets[i].getPet_Water() >= 25 && my_Pets[i].getPet_Water() <= 50 && my_Pets[i].pet_Life == 1)
                        System.out.println(my_Pets[i].pet_Name + " needs some water!");
                    else if (my_Pets[i].getPet_Water() <= 0 && my_Pets[i].getPet_Water() < 25 && my_Pets[i].pet_Life == 1)
                        System.out.println(my_Pets[i].pet_Name + " is thirsty!!!");
                    if (my_Pets[i].getPet_Water() <= 50) {
                        if (money >= 0) {
                            String answer_Water;
                            System.out.print("Would you like to buy " + my_Pets[i].pet_Name + " some water? (yes / no) - ");
                            answer_Water = sc.next();
                            if ((Objects.equals(answer_Water, "yes"))) {
                                int answer_Water_nr;
                                System.out.print("You can buy : \n 1 - Water \n 2 - Milk \n Wich one would you like to buy? ( 1 / 2 ) - ");
                                answer_Water_nr = sc.nextInt();
                                answer_Water_nr--;
                                drinks[answer_Water_nr].setfood_Quantity(drinks[answer_Water_nr].getfood_Quantity() + 1);
                                money -= drinks[answer_Water_nr].getfood_Price();
                                my_Pets[i].setPet_Water(my_Pets[i].getPet_Water() + drinks[answer_Water_nr].food_Heal);
                                System.out.println(my_Pets[i].pet_Name + " just drinked some " + drinks[answer_Water_nr].food_Name);
                            }
                        }
                    }
                    if(my_Pets[i].getPet_Food() >= 25 && my_Pets[i].getPet_Food() <= 50 && my_Pets[i].pet_Life == 1)
                        System.out.println(my_Pets[i].pet_Name + " needs some food!");
                    else if(my_Pets[i].getPet_Food() <= 0 && my_Pets[i].getPet_Food() < 25 && my_Pets[i].pet_Life == 1)
                        System.out.println(my_Pets[i].pet_Name + " is hungry!!!");
                    if (my_Pets[i].getPet_Food() <= 50) {
                        if (money >= 0) {
                            String answer_Food;
                            System.out.print("Would you like to buy " + my_Pets[i].pet_Name + " some food? (yes / no) - ");
                            answer_Food = sc.next();
                            if ((Objects.equals(answer_Food, "yes"))) {
                                int answer_food_nr;
                                System.out.print("You can buy : \n 1 - Meal \n 2 - Fish \n 3 - Soup \n Wich one would you like to buy? ( 1 / 2 / 3 ) - ");
                                answer_food_nr = sc.nextInt();
                                answer_food_nr--;
                                foods[answer_food_nr].setfood_Quantity(foods[answer_food_nr].getfood_Quantity() + 1);
                                money -= foods[answer_food_nr].getfood_Price();
                                my_Pets[i].setPet_Water(my_Pets[i].getPet_Water() + foods[answer_food_nr].food_Heal);
                                System.out.println(my_Pets[i].pet_Name + " just eated some " + foods[answer_food_nr].food_Name);
                            }
                        }
                    }
                    if (my_Pets[i].getPet_Food() >= 25 && my_Pets[i].getPet_Water() >= 25)
                        my_Pets[i].setPet_Wealth(my_Pets[i].getPet_Wealth() + 20);

                }

                //lose condition
                int temp = 0;
                for (int i = 0; i < pets; ++i) {
                    if(my_Pets[i].getPet_Wealth() <= 0) {
                        my_Pets[i].setPet_Water(0);
                        if(my_Pets[i].pet_Life == 1) System.out.println(my_Pets[i].pet_Name + " just died!!!");
                        my_Pets[i].pet_Life = 0;
                        temp++;
                    }
                }
                if (temp == pets) game_Over = true;

                //next day starter
                System.out.println("You have " + money + " money left!");
                temp_Day++;
                day++;
                if(temp_Day == 7){
                    temp_Day = 1;
                    money += 100;
                }
            }
        }
        else{
            Metode.GetMoney(money);
            System.out.println("----------------------------------------------------------");
            pets = rnd.nextInt(5);
            if(pets < 1) pets = 1;

            if(pets == 1) System.out.println("You have one pet!");
            else System.out.println("You have " + pets + " pets!");

            // Generate Pets Data
            my_Pets = Metode.GeneratePetsData(my_Pets, pets);

            //simulator
            while(!game_Over){
                /*
                System.out.print("\033[H\033[2J");
                System.out.flush();
                getConsoleView().clear();
                console.clear();
                verify(consoleView).clear();
                */
                System.out.println("----------------------------------------------------------");
                System.out.println("Day nr'" + day);
                System.out.print("Start simulating");
                for(int i = 0; i < 3; ++i) {
                    java.util.concurrent.TimeUnit.SECONDS.sleep(1);
                    System.out.print(".");
                    //Thread.sleep(1000);
                }
                System.out.print("\n\n");

                //decrease health conditions
                for (int i = 0; i < pets; ++i) {
                    my_Pets[i].setPet_Water(my_Pets[i].getPet_Water() - 25);
                    my_Pets[i].setPet_Food(my_Pets[i].getPet_Food() - 25);
                    my_Pets[i].setPet_Wealth(my_Pets[i].getPet_Wealth() - 10);
                    if(my_Pets[i].getPet_Water() <= 0 && my_Pets[i].getPet_Food() <= 0) my_Pets[i].setPet_Wealth(my_Pets[i].getPet_Wealth() - 10);
                }

                //simulating
                for (int i = 0; i < pets; ++i) {
                    if(my_Pets[i].getPet_Water() >= 25 && my_Pets[i].getPet_Water() <= 50 && my_Pets[i].pet_Life == 1) System.out.println(my_Pets[i].pet_Name + " needs some water!");
                    else if(my_Pets[i].getPet_Water() <= 0 && my_Pets[i].getPet_Water() < 25 && my_Pets[i].pet_Life == 1) System.out.println(my_Pets[i].pet_Name + " is thirsty!!!");
                    if (my_Pets[i].getPet_Water() <= 50) {
                        if (money >= 0) {
                            int prob = rnd.nextInt(99);
                            if (prob <= 75) {
                                int temp = rnd.nextInt(1);
                                drinks[temp].setfood_Quantity(drinks[temp].getfood_Quantity() + 1);
                                money -= drinks[temp].getfood_Price();
                                my_Pets[i].setPet_Water(my_Pets[i].getPet_Water() + drinks[temp].food_Heal);
                                System.out.println(my_Pets[i].pet_Name + " just drinked some " + drinks[temp].food_Name);
                            }
                        }
                    }
                    if(my_Pets[i].getPet_Food() >= 25 && my_Pets[i].getPet_Food() <= 50 && my_Pets[i].pet_Life == 1) System.out.println(my_Pets[i].pet_Name + " needs some food!");
                    else if(my_Pets[i].getPet_Food() <= 0 && my_Pets[i].getPet_Food() < 25 && my_Pets[i].pet_Life == 1) System.out.println(my_Pets[i].pet_Name + " is hungry!!!");
                    if (my_Pets[i].getPet_Food() <= 50) {
                        if (money >= 0) {
                            int prob = rnd.nextInt(99);
                            if (prob <= 50) {
                                int temp = rnd.nextInt(2);
                                foods[temp].setfood_Quantity(drinks[temp].getfood_Quantity() + 1);
                                money -= foods[temp].getfood_Price();
                                my_Pets[i].setPet_Food(my_Pets[i].getPet_Food() + foods[temp].food_Heal);
                                System.out.println(my_Pets[i].pet_Name + " just eated some " + foods[temp].food_Name);
                            }
                        }
                    }
                    if (my_Pets[i].getPet_Food() >= 25 && my_Pets[i].getPet_Water() >= 25)
                        my_Pets[i].setPet_Wealth(my_Pets[i].getPet_Wealth() + 20);
                }

                //lose condition
                int temp = 0;

                for (int i = 0; i < pets; ++i) {
                    if(my_Pets[i].getPet_Wealth() <= 0) {
                        my_Pets[i].setPet_Water(0);
                        if(my_Pets[i].pet_Life == 1) System.out.println(my_Pets[i].pet_Name + " just died!!!");
                        my_Pets[i].pet_Life = 0;
                        temp++;
                    }
                }
                if (temp == pets) game_Over = true;

                System.out.println("You have " + money + " money left!");
                day++;
                temp_Day++;
                if(temp_Day == 7){
                    temp_Day = 1;
                    money += rnd.nextInt(100);
                }
            }
        }

        System.out.println("----------------------------------------------------------");
        System.out.println("Your pets survived " + (day - 1) + " days!");

        String lost[] = {"Y","o","u"," ","l","o","s","t","!"};
        for(int i = 0; i < 9; ++i) {
            Thread.sleep(300);
            System.out.print(lost[i]);
        }
    }

}
