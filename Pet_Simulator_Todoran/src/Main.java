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
        int day = 1, money = 0, pets = 0, random_Names = 0, random_Sex = 0;
        boolean game_Over = false;
        String insert_Data = new String();

        String[] names = {"Luna", "Ava", "Thor", "Chile", "Adam", "Hero", "Pisa", "Pueblo", "Fernando", "Azurica", "Aiurel", "CJ", "Rider", "Marhelo", "Dinte", "Pacato", "Lada", "Daza", "Jojo", "Dio"};
        String[] sexes = {"M", "F"};

        //objets
        Pet pet_01 = new Pet("a","F","a",1,1,1,1 ,1);
        Pet pet_02 = new Pet("a","F","a",1,1,1,1 ,1);
        Pet pet_03 = new Pet("a","F","a",1,1,1,1 ,1);
        Pet pet_04 = new Pet("a","F","a",1,1,1,1 ,1);
        Pet pet_05 = new Pet("a","F","a",1,1,1,1 ,1);
        Pet[] my_Pets = {pet_01, pet_02, pet_03, pet_04, pet_05};

        //foods
        Food Water = new Food ("Water", 50, 0, 5, 10);
        Food Meal = new Food ("Meal", 25, 0, 10, 5);
        Food Fish = new Food ("Fish", 30, 0, 15, 5);
        Food Soup = new Food ("Soup", 20, 0, 10, 3);

        System.out.println("----------------------------------------------------------");
        System.out.println("Would you like to insert data? (yes/no) - ");
        insert_Data = sc.next();

        //compare string
        if((Objects.equals(insert_Data, "yes"))){
            System.out.println("----------------------------------------------------------");
            System.out.println("How much money would you like to have? (max 100) - ");
            money = sc.nextInt();
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
        }
        else{
            System.out.println("----------------------------------------------------------");
            money = rnd.nextInt(500);
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
                System.out.print(".");
                //Thread.sleep(1000);
                java.util.concurrent.TimeUnit.SECONDS.sleep(1);
            }

            //decrease
            for (int i = 0; i < pets; ++i) {
                my_Pets[i].setPet_Water(my_Pets[i].getPet_Water() - 25);
                my_Pets[i].setPet_Food(my_Pets[i].getPet_Food() - 25);
                my_Pets[i].setPet_Wealth(my_Pets[i].getPet_Wealth() - 10);
            }




            day++;
            game_Over = true;
        }

    }


}
