import java.util.Random;
import java.util.Scanner;

public class Metode {
    static Scanner sc = new Scanner(System.in);
    static Random rnd = new Random();

    static String[] names = {"Luna", "Ava", "Thor", "Chile", "Adam", "Hero", "Pisa", "Pueblo", "Fernando", "Azurica", "Aiurel", "CJ", "Rider", "Marhelo", "Dinte", "Pacato", "Lada", "Daza", "Jojo", "Dio"};
    static String[] sexes = {"M", "F"};

    public static String GetInsertDataAnswer() {
        String insert_Data;
        System.out.println("----------------------------------------------------------");
        System.out.println("Would you like to insert data? (yes/no) - ");
        insert_Data = sc.next();
        return insert_Data;
    }

    public static Pet[] GetPets(){
        Pet pet_01 = new Pet("a","a","a",1,1,1,1,1 ,1);
        Pet pet_02 = new Pet("a","a","a",1,1,1,1,1 ,1);
        Pet pet_03 = new Pet("a","a","a",1,1,1,1,1 ,1);
        Pet pet_04 = new Pet("a","a","a",1,1,1,1,1 ,1);
        Pet pet_05 = new Pet("a","a","a",1,1,1,1,1 ,1);
        Pet[] my_Pets = {pet_01, pet_02, pet_03, pet_04, pet_05};
        return my_Pets;
    }

    public static Food[] GetDrinks(){
        Food Water = new Food ("Water", 50, 0, 10, 10);
        Food Milk = new Food ("Milk", 30, 0, 5, 5);
        Food[] drinks = {Water, Milk};
        return drinks;
    }

    public static Food[] GetFood(){
        Food Meal = new Food ("Meal", 25, 0, 10, 5);
        Food Fish = new Food ("Fish", 30, 0, 15, 5);
        Food Soup = new Food ("Soup", 20, 0, 10, 3);
        Food[] foods = {Meal, Fish, Soup};
        return foods;
    }

    public static int GetMoney(int money) {
        System.out.println("----------------------------------------------------------");
        money = rnd.nextInt(100);
        System.out.println("You have " + money + " money available!");
        return money;
    }

    public static int GetPetsNum() {
        int pets;
        System.out.println("----------------------------------------------------------");
        System.out.println("How many pets would you like to have? (max 5) - ");
        pets = sc.nextInt();
        return pets;
    }

    public static Pet[] GetPetsData(Pet[] my_Pets, int pets) {
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
        return my_Pets;
    }

    public static Pet[] GeneratePetsData(Pet[] my_Pets, int pets) {
        System.out.println("----------------------------------------------------------");
        System.out.println("Please insert pets informations ");

        System.out.println("----------------------------------------------------------");
        System.out.println("Your pets are: ");

        for (int i = 0; i < pets; ++i) {
            System.out.println("----------------------------------------------------------");
            int random_Names = rnd.nextInt(20);
            my_Pets[i].pet_Name = names[random_Names];
            System.out.println("Pet nr'" + (i + 1) + " name is: " + my_Pets[i].pet_Name);
            int random_Sex = rnd.nextInt(1);
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
        return my_Pets;
    }

    public static void DayConsole(int day) throws InterruptedException {
        System.out.println("----------------------------------------------------------");
        System.out.println("Day nr'" + day);
        System.out.print("Start simulating");
        for (int i = 0; i < 3; ++i) {
            java.util.concurrent.TimeUnit.SECONDS.sleep(1);
            System.out.print(".");
            //Thread.sleep(1000);
        }
        System.out.print("\n\n");
    }

    /*
    public static void (Pet my_Pets){
        for (int i = 0; i < pets; ++i) {
            my_Pets[i].setPet_Water(my_Pets[i].getPet_Water() - 25);
            my_Pets[i].setPet_Food(my_Pets[i].getPet_Food() - 25);
            my_Pets[i].setPet_Wealth(my_Pets[i].getPet_Wealth() - 10);
            if(my_Pets[i].getPet_Water() <= 0 && my_Pets[i].getPet_Food() <= 0) my_Pets[i].setPet_Wealth(my_Pets[i].getPet_Wealth() - 10);
        }
    }
    */






}
