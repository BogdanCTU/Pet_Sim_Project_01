import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;
import java.util.Random;


public class Main {

    //metode
    public int next_Day(int day) {
        return day++;
    }
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    //main
    public static void main(String[] args) throws InterruptedException, IOException {
        Scanner sc = new Scanner(System.in);
        Random rnd = new Random();

        //variables
        int day = 1, temp_Day = 1, money = 0, pets = 0, random_Names = 0, random_Sex = 0;
        boolean game_Over = false;
        String insert_Data = new String();

        String[] names = {"Luna", "Ava", "Thor", "Chile", "Adam", "Hero", "Pisa", "Pueblo", "Fernando", "Azurica", "Aiurel", "CJ", "Rider", "Marhelo", "Dinte", "Pacato", "Lada", "Daza", "Jojo", "Dio"};
        String[] sexes = {"M", "F"};

        //objets
        Pet pet_01 = new Pet("a","a","a",1,1,1,1,1 ,1);
        Pet pet_02 = new Pet("a","a","a",1,1,1,1,1 ,1);
        Pet pet_03 = new Pet("a","a","a",1,1,1,1,1 ,1);
        Pet pet_04 = new Pet("a","a","a",1,1,1,1,1 ,1);
        Pet pet_05 = new Pet("a","a","a",1,1,1,1,1 ,1);
        Pet[] my_Pets = {pet_01, pet_02, pet_03, pet_04, pet_05};

        //foods
        Food Water = new Food ("Water", 50, 0, 10, 10);
        Food Milk = new Food ("Milk", 30, 0, 5, 5);
        Food[] drinks = {Water, Milk};
        Food Meal = new Food ("Meal", 25, 0, 10, 5);
        Food Fish = new Food ("Fish", 30, 0, 15, 5);
        Food Soup = new Food ("Soup", 20, 0, 10, 3);
        Food[] foods = {Meal, Fish, Soup};


        System.out.println("----------------------------------------------------------");
        System.out.println("Would you like to insert data? (yes/no) - ");
        insert_Data = sc.next();

        //compare string
        if((Objects.equals(insert_Data, "yes"))){
            System.out.println("----------------------------------------------------------");
            System.out.println("How much money would you like to have? (max 100) - ");
            money = sc.nextInt();
            if(money > 100) money = 100; //money = money<=100?money:100;
            System.out.println("----------------------------------------------------------");
            System.out.println("How many pets would you like to have? (max 5) - ");
            pets = sc.nextInt();

            //pets data
            System.out.println("----------------------------------------------------------");
            System.out.println("Please insert pets informations ");

            for (int i = 0; i < pets; ++i) {
                System.out.println("----------------------------------------------------------");
                System.out.println("Please insert pet nr'" + (i + 1) + " name: ");
                my_Pets[i].pet_Name = sc.next();
                System.out.println("Please insert pet nr'" + (i + 1) + " sex: ");
                my_Pets[i].pet_Sex = sc.next();
                System.out.println("Please insert pet nr'" + (i + 1) + " height: ");
                my_Pets[i].pet_Height = sc.nextInt();
                System.out.println("Please insert pet nr'" + (i + 1) + " weight: ");
                my_Pets[i].pet_Weight = sc.nextInt();
                my_Pets[i].setPet_Water(100);
                my_Pets[i].setPet_Food(100);
                my_Pets[i].setPet_Wealth(100);
            }

            //simulator
            while(!game_Over){
                //clear console?!?!?
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
                    if (my_Pets[i].getPet_Water() >= 25 && my_Pets[i].getPet_Water() <= 50 && my_Pets[i].pet_Life == 1)
                        System.out.println(my_Pets[i].pet_Name + " needs some water!");
                    else if (my_Pets[i].getPet_Water() <= 0 && my_Pets[i].getPet_Water() < 25 && my_Pets[i].pet_Life == 1)
                        System.out.println(my_Pets[i].pet_Name + " is thirsty!!!");
                    if (my_Pets[i].getPet_Water() <= 50) {
                        if (money >= 0) {
                            String answer_Water;
                            System.out.print("Would you like to buy " + my_Pets[i].pet_Name + " some water? (yes / no) - ");
                            answer_Water = sc.next();
                            if ((Objects.equals(insert_Data, "yes") == true)) {
                                int answer_Water_nr;
                                System.out.print("You can buy : \n 1 - Water \n 2 - Milk \n Wich one would you like to buy? ( 1 / 2 ) - ");
                                answer_Water_nr = sc.nextInt();
                                answer_Water_nr--;
                                drinks[answer_Water_nr].setfood_Quantity(drinks[answer_Water_nr].getfood_Quantity() + 1);
                                money -= drinks[answer_Water_nr].getfood_Price();
                                my_Pets[i].setPet_Water(my_Pets[i].getPet_Water() + drinks[answer_Water_nr].food_Heal);
                                System.out.println(my_Pets[i].pet_Name + "just drinked some " + drinks[answer_Water_nr].food_Name);
                            }
                        }
                    }
                    if(my_Pets[i].getPet_Food() >= 25 && my_Pets[i].getPet_Food() <= 50 && my_Pets[i].pet_Life == 1)
                        System.out.println(my_Pets[i].pet_Name + " needs some food!");
                    else if(my_Pets[i].getPet_Food() <= 0 && my_Pets[i].getPet_Food() < 25 && my_Pets[i].pet_Life == 1)
                        System.out.println(my_Pets[i].pet_Name + " is hungry!!!");
                    if (my_Pets[i].getPet_Food() <= 50) {
                        if (money >= 0) {
                            String answer_Water;
                            System.out.print("Would you like to buy " + my_Pets[i].pet_Name + " some food? (yes / no) - ");
                            answer_Water = sc.next();
                            if ((Objects.equals(insert_Data, "yes") == true)) {
                                int answer_food_nr;
                                System.out.print("You can buy : \n 1 - Meal \n 2 - Fish \n 3 - Soup \n Wich one would you like to buy? ( 1 / 2 / 3 ) - ");
                                answer_food_nr = sc.nextInt();
                                answer_food_nr--;
                                foods[answer_food_nr].setfood_Quantity(foods[answer_food_nr].getfood_Quantity() + 1);
                                money -= foods[answer_food_nr].getfood_Price();
                                my_Pets[i].setPet_Water(my_Pets[i].getPet_Water() + foods[answer_food_nr].food_Heal);
                                System.out.println(my_Pets[i].pet_Name + "just eated some " + foods[answer_food_nr].food_Name);
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
            System.out.println("----------------------------------------------------------");
            money = rnd.nextInt(100);
            System.out.println("You have " + money + " money available!");
            System.out.println("----------------------------------------------------------");
            pets = rnd.nextInt(5);
            if(pets < 1) pets = 1;

            if(pets == 1) System.out.println("You have one pet!");
            else System.out.println("You have " + pets + " pets!");

            //pets data
            System.out.println("----------------------------------------------------------");
            System.out.println("Your pets are: ");

            for (int i = 0; i < pets; ++i) {
                System.out.println("----------------------------------------------------------");
                random_Names = rnd.nextInt(20);
                my_Pets[i].pet_Name = names[random_Names];
                System.out.println("Pet nr'" + (i + 1) + " name is: " + my_Pets[i].pet_Name);
                random_Sex = rnd.nextInt(1);
                my_Pets[i].pet_Sex = sexes[random_Sex];
                System.out.println(my_Pets[i].pet_Name + " sex is: " + my_Pets[i].pet_Sex);
                my_Pets[i].pet_Height = rnd.nextInt(40, 100)%50 + 50;
                System.out.println(my_Pets[i].pet_Name + " height is: " + my_Pets[i].pet_Height);
                my_Pets[i].pet_Weight = rnd.nextInt(30);
                System.out.println(my_Pets[i].pet_Name + " weight is: " + my_Pets[i].pet_Weight);
                my_Pets[i].setPet_Water(100);
                my_Pets[i].setPet_Food(100);
                my_Pets[i].setPet_Wealth(100);
            }

            //simulator
            while(!game_Over){
                //clearScreen();
                //System.out.print("\033[H\033[2J");
                //System.out.flush();
                //getConsoleView().clear();
                //console.clear();
                //verify(consoleView).clear();
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
                                System.out.println(my_Pets[i].pet_Name + "just drinked some " + drinks[temp].food_Name);
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
                                System.out.println(my_Pets[i].pet_Name + "just eated some " + foods[temp].food_Name);
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
                if(temp_Day == 7){
                    temp_Day = 1;
                    money += 100;
                }
            }
        }

        System.out.println("----------------------------------------------------------");
        System.out.println("Your pets survived " + day + " days!");

        String lost[] = {"Y","o","u"," ","l","o","s","t","!"};
        for(int i = 0; i < 9; ++i) {
            Thread.sleep(300);
            System.out.print(lost[i]);
        }
    }

}
