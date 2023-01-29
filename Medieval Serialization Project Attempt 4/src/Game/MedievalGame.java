package Game;

import ArmourFiles.*;
import Enemies.BossEnemy;
import Enemies.Enemy;
import Weapons.Weapon;

import java.util.Scanner;
import java.io.Serializable;
import java.io.*;
import java.io.IOException;
public class MedievalGame implements Serializable {

    private static final long serialVersionUID = 1L;

    /* Instance Variables */
    private Player player;

//    private Game.Player player;

    private Enemy enemy;

//    private String progress;

    private   String chest;
    private  String chestTwo;

    private String doorOne;
    private   String zombie;

    private String enemy2;

    private String enemy3;
    private  int zombieHealth = 4;
    private  int zombieDamage = 2;



    Enemy zombieKing = new Enemy("Zombie King", 20, 20);

    BossEnemy loki = new BossEnemy("Loki God Of Mischeif", 35,25, 4);





//    Level1 level1;
private static String progress = "level1";
    static boolean newGame = false;

    /* Main Method */
    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);
        MedievalGame game = new MedievalGame();

        game.player = game.start(console);

        if (newGame == true){
            game.newGame(game, console);
                    }

else {
            game.addDelay(1500);
            System.out.println("Loading character...");

            game.addDelay(2000);
            System.out.println("Now let's print out your character again to make sure everything loaded:");

            game.addDelay(500);
            System.out.println(game.player);
        }

switch (progress) {

    case "level1" :
//        boolean level1InProgress = true;
        while(progress.equalsIgnoreCase("level1")) {
            progress = "level1";
            game.addDelay(2000);
            System.out.println("\nYou discover a chest. Would you like to open it? Type y for yes, n for no, s for save, x for exit.");
            String chest = console.next().toLowerCase();

            while (true) {
                if (chest.equalsIgnoreCase("y")) {
                    System.out.println("You open the chest to find a helmet. You put it on.");
//                ArmourFiles.Helmet helmet = new ArmourFiles.Helmet("none", 1, 0);
                    Helmet platedHelmet = new Helmet("Plated ArmourFiles.Helmet", 5, 8);
                    /* helmet = platedHelmet; */
                /* to use non-static methods from a static method (e.g. main) you must call the objects (e.g.game.player), then call the method (e.g. setHelmet)
                then call the argument for the method (e.g. platedHelmet which in this case is an object of the non-static ArmourFiles.Helmet class */
                    game.player.setHelmet(platedHelmet);
                    System.out.println(game.player);
                    game.addDelay(2000);
                    progress = "level2";
//                    level1InProgress = false;
//                    System.out.println("\nYou discover a Zombie. Would you like to attack it? Type y for yes, n for no, s for save, x for exit.");
//                    game.zombie = console.next().toLowerCase();
                    break;
                } else if (chest.equalsIgnoreCase("n")) {
                    System.out.println("You choose not to open the chest. An onlooker observes your honesty and gives you a pair of boots.");
                    Shoe leatherboots = new Shoe("Leather Boots", 10, 10);
                    game.player.setShoe(leatherboots);
                    System.out.println(game.player);
                    progress = "level2";
//                    level1InProgress = false;
//                    System.out.println("\nYou discover a Zombie. The Zombie has " + game.zombieHealth + " health and " + game.zombieDamage + " damage. Would you like to attack it? Type y for yes, n for no, s for save, x for exit.");
//                    game.zombie = console.next().toLowerCase();
                    break;

                } else if (chest.equalsIgnoreCase("s")) {
//                    progress = "level2";
                    System.out.println("Please enter your save game name.");
                    String savedFileName = console.nextLine();
                    game.save(console);
//                System.out.println("We just saved your game...");
                    break;
                } else if (chest.equalsIgnoreCase("x")) {
                    System.out.println("Goodbye Traveller, return soon to conquer to hordes of evil!");
                    System.exit(0);
                    break;
                } else {

                    System.out.println("Please try again, your options are y or n to open the chest.");
                    chest = console.next().toLowerCase();
                }
            }
        }
//            break;

    case "level2":
//        boolean level2InProgress = true;
        while(progress.equalsIgnoreCase("level2")) {
            System.out.println("\nYou discover a Zombie. The Zombie has " + game.zombieHealth + " health and " + game.zombieDamage + " damage. Would you like to attack it? Type y for yes, n for no, s for save, x for exit.");
            game.zombie = console.next().toLowerCase();
            while (true) {
                if (game.zombie.equalsIgnoreCase("y")) {
                    System.out.println("\nYou attack the zombie");

//                ArmourFiles.Helmet helmet = new ArmourFiles.Helmet("none", 1, 0);
//                ArmourFiles.Helmet platedHelmet = new ArmourFiles.Helmet("Plated ArmourFiles.Helmet", 5, 8);
                    /* helmet = platedHelmet; */
                /* to use non-static methods from a static method (e.g. main) you must call the objects (e.g.game.player), then call the method (e.g. setHelmet)
                then call the argument for the method (e.g. platedHelmet which in this case is an object of the non-static ArmourFiles.Helmet class */
                    int currentWeaponDamage = game.player.getCurrentWeaponDamage();
                    while (true) {
                        if (currentWeaponDamage >= game.zombieHealth) {
//                System.out.println(game.player);
                            game.addDelay(2000);
                            game.zombieHealth -= currentWeaponDamage;
                            System.out.println("You have killed the Zombie and taken no damage.");
                            Weapon longSword = new Weapon("Long Sword", 12);
                            game.player.setCurrentWeapon(longSword);
                            System.out.println("The Zombie was carrying a Long Sword which you claim as your own.");
                            System.out.println(game.player);

//                            String savedFileName = game.save(console);
                            progress = "level3";
                            System.out.println("Please enter your save game name.");
                            String savedFileName = console.nextLine();
                            game.save(console);
//                            System.out.println("\nYou discover a chest. Would you like to open it? Type y for yes, n for no, s for save, x for exit.");
//                            game.chestTwo = console.next().toLowerCase();
//                        zombie.equalsIgnoreCase("s");
//                        System.exit(1);
//                            level2InProgress = false;
                            break;
//                        System.out.println("\nYou discover a Door. Would you like to open it? Type y for yes, n for no, s for save, x for exit.");
//                String zombie = console.next().toLowerCase();
                        } else {
                            game.addDelay(2000);
                            System.out.println("\nYou have damaged the Zombie");
                            game.zombieHealth -= currentWeaponDamage;
                            System.out.println("The Zombie now has " + game.zombieHealth + " health.");
                            System.out.println("\nThe Zombie has attacked you with " + game.zombieDamage + " damage.");
                            game.player.takeDamage(game.zombieDamage);
//                        break;

                        }
//                    break;
                    }
                    break;
                } else if (game.zombie.equalsIgnoreCase("n")) {
                    System.out.println("You choose not to attack the Zombie. The Zombie attacks you in the back as you run away.");
                    game.player.takeDamage(game.zombieDamage * 1.5);
                    progress = "level3";
//                    level2InProgress = false;
//                    System.out.println("\nYou discover a chest. Would you like to open it? Type y for yes, n for no, s for save, x for exit.");
//                    game.chestTwo = console.next().toLowerCase();
                    break;

                } else if (game.zombie.equalsIgnoreCase("s")) {
//                    String savedFileName = game.save(console);
//                System.out.println("We just saved your game...");
                    System.out.println("Please enter your save game name.");
                    String savedFileName = console.nextLine();
                    game.save(console);
                    break;
                } else if (game.zombie.equalsIgnoreCase("x")) {
                    System.out.println("Goodbye Traveller, return soon to conquer to hordes of evil!");
                    System.exit(0);
                    break;
                } else {

                    System.out.println("Please try again, your options are y or n to attack the Zombie, s to Save or x to exit");
                    game.zombie = console.next().toLowerCase();
                }
            }
        }
//break;

    case "level3":
//        boolean level3InProgress = true;
        while(progress.equalsIgnoreCase("level3")) {
            System.out.println("\nYou discover a chest. Would you like to open it? Type y for yes, n for no, s for save, x for exit.");
            game.chestTwo = console.next().toLowerCase();
            while (true) {
                if (game.chestTwo.equalsIgnoreCase("y")) {
                    game.addDelay(2000);
                    System.out.println("You open the chest to find some chain mail. You put it on.");
//                ArmourFiles.Helmet helmet = new ArmourFiles.Helmet("none", 1, 0);
                    Armour chainMail = new Armour("Chain Mail", 10, 10);
                    /* helmet = platedHelmet; */
                /* to use non-static methods from a static method (e.g. main) you must call the objects (e.g.game.player), then call the method (e.g. setHelmet)
                then call the argument for the method (e.g. platedHelmet which in this case is an object of the non-static ArmourFiles.Helmet class */
                    game.player.setArmour(chainMail);
                    System.out.println(game.player);
                    game.addDelay(2000);
                    progress = "level4";
//                    level3InProgress = false;
//                    System.out.println("\nYou discover a " + game.zombieKing.getEnemyName() + " .The Zombie King has " + game.zombieKing.getEnemyHealth() + " health and " + game.zombieKing.getEnemyDamage() + " damage. Would you like to attack it? Type y for yes, n for no, s for save, x for exit.");
//                    game.enemy2 = console.next().toLowerCase();
                    break;
                } else if (game.chestTwo.equalsIgnoreCase("n")) {
                    System.out.println("You choose not to open the chest. An observer thinks it must be locked and bashes it with their mace. They discover some Chain Mail inside and leave their own armor behind.");
                    Armour platedArmor = new Armour("Plated Armor", 7, 6);
                    game.player.setArmour(platedArmor);
                    System.out.println(game.player);
                    progress = "level4";
//                    level3InProgress = false;
//                    System.out.println("\nYou discover a " + game.zombieKing.getEnemyName() + " .The Zombie King has " + game.zombieKing.getEnemyHealth() + " health and " + game.zombieKing.getEnemyDamage() + " damage. Would you like to attack it? Type y for yes, n for no, s for save, x for exit.");
//                    game.enemy2 = console.next().toLowerCase();
                    break;

                } else if (game.chestTwo.equalsIgnoreCase("s")) {
//                    String savedFileName = game.save(console);
//                System.out.println("We just saved your game...");
                    System.out.println("Please enter your save game name.");
                    String savedFileName = console.nextLine();
                    game.save(console);
                    break;
                } else if (game.chestTwo.equalsIgnoreCase("x")) {
                    System.out.println("Goodbye Traveller, return soon to conquer to hordes of evil!");
                    System.exit(0);
                    break;
                } else {

                    System.out.println("Please try again, your options are y or n to open the chest.");
                    game.chestTwo = console.next().toLowerCase();
                }
            }
        }
//break;

    case "level4":
//        boolean level4InProgress = true;
        while(progress.equalsIgnoreCase("level4")) {
            System.out.println("\nYou discover a " + game.zombieKing.getEnemyName() + " .The Zombie King has " + game.zombieKing.getEnemyHealth() + " health and " + game.zombieKing.getEnemyDamage() + " damage. Would you like to attack it? Type y for yes, n for no, s for save, x for exit.");
            game.enemy2 = console.next().toLowerCase();
            while (true) {
                if (game.enemy2.equalsIgnoreCase("y")) {
                    System.out.println("\nYou attack the " + game.zombieKing.getEnemyName());

//                ArmourFiles.Helmet helmet = new ArmourFiles.Helmet("none", 1, 0);
//                ArmourFiles.Helmet platedHelmet = new ArmourFiles.Helmet("Plated ArmourFiles.Helmet", 5, 8);
                    /* helmet = platedHelmet; */
                /* to use non-static methods from a static method (e.g. main) you must call the objects (e.g.game.player), then call the method (e.g. setHelmet)
                then call the argument for the method (e.g. platedHelmet which in this case is an object of the non-static ArmourFiles.Helmet class */
                    int currentWeaponDamage = game.player.getCurrentWeaponDamage();

                    int zombieKingHealth = game.zombieKing.getEnemyHealth();
                    while (true) {

                        if (currentWeaponDamage >= zombieKingHealth) {
//                System.out.println(game.player);
                            game.addDelay(2000);
                            zombieKingHealth -= currentWeaponDamage;
                            System.out.println("You have killed the " + game.zombieKing.getEnemyName() + " and taken no damage.");
                            System.out.println("The " + game.zombieKing.getEnemyName() + " drops a key. You use it to open a chest. Inside is a pair of chain mail trousers.");
                            Trouser chainMailTrousers = new Trouser("Chain Mail Trousers", 10, 10);
                            game.player.setTrouser(chainMailTrousers);
                            System.out.println(game.player);
                            progress = "level5";
//                            String savedFileName = game.save(console);
                            System.out.println("Please enter your save game name.");
                            String savedFileName = console.nextLine();
                            game.save(console);

                            progress = "level5";
//                            level4InProgress = false;
//                            System.out.println("\nYou discover a door. Would you like to open it? Type y for yes, n for no, s for save, x for exit.");
//                            game.doorOne = console.next().toLowerCase();
//                        zombie.equalsIgnoreCase("s");
//                        System.exit(1);
                            break;
//                        System.out.println("\nYou discover a Door. Would you like to open it? Type y for yes, n for no, s for save, x for exit.");
//                String zombie = console.next().toLowerCase();
                        } else {
                            game.addDelay(2000);
                            System.out.println("\nYou have damaged the " + game.zombieKing.getEnemyName());
                            zombieKingHealth -= currentWeaponDamage;
                            System.out.println("The " + game.zombieKing.getEnemyName() + " now has " + zombieKingHealth + " health.");
                            System.out.println("\nThe Zombie has attacked you with " + game.zombieKing.getEnemyDamage() + " damage.");
                            game.player.takeDamage(game.zombieKing.getEnemyDamage());
//                        break;

                        }
//                    break;
                    }
                    break;
                } else if (game.enemy2.equalsIgnoreCase("n")) {
                    System.out.println("You choose not to attack the Zombie. The Zombie attacks you in the back as you run away.");
                    game.player.takeDamage(game.zombieKing.getEnemyDamage() / 2);
                    progress = "level5";
//                    level4InProgress = false;
//                    System.out.println("\nYou discover a chest. Would you like to open it? Type y for yes, n for no, s for save, x for exit.");
//                    game.doorOne = console.next().toLowerCase();
                    break;

                } else if (game.enemy2.equalsIgnoreCase("s")) {
 //                   progress = "level5";
//                    String savedFileName = game.save(console);
//                System.out.println("We just saved your game...");
                    System.out.println("Please enter your save game name.");
                    String savedFileName = console.nextLine();
                    game.save(console);
                    break;

                } else if (game.enemy2.equalsIgnoreCase("x")) {
                    System.out.println("Goodbye Traveller, return soon to conquer to hordes of evil!");
                    System.exit(0);
                    break;
                } else {

                    System.out.println("Please try again, your options are y or n to attack the Zombie, s to Save or x to exit");
                    game.enemy2 = console.next().toLowerCase();
                }
            }
        }
//            break;

    case "level5":
//        boolean level5InProgress = true;
        while(progress.equalsIgnoreCase("level5")) {
            System.out.println("\nYou discover a door. Would you like to open it? Type y for yes, n for no, s for save, x for exit.");
            game.doorOne = console.next().toLowerCase();
            while (true) {
                if (game.doorOne.equalsIgnoreCase("y")) {
                    game.addDelay(2000);
                    System.out.println("You open the door to find some a leather jacket. You put it on.");
//                ArmourFiles.Helmet helmet = new ArmourFiles.Helmet("none", 1, 0);
                    Shirt leatherJacket = new Shirt("Leather Jacket", 3, 3);
                    /* helmet = platedHelmet; */
                /* to use non-static methods from a static method (e.g. main) you must call the objects (e.g.game.player), then call the method (e.g. setHelmet)
                then call the argument for the method (e.g. platedHelmet which in this case is an object of the non-static ArmourFiles.Helmet class */
                    game.player.setShirt(leatherJacket);
                    System.out.println(game.player);
                    game.addDelay(2000);
                    progress = "level6";
 //                   level5InProgress = false;
//                    System.out.println("\nYou discover " + game.loki.getEnemyName() + " .He has " + game.loki.getEnemyHealth() + " health and " + game.loki.getEnemyDamage() + " damage. Would you like to attack it? Type y for yes, n for no, s for save, x for exit.");
//                    game.enemy3 = console.next().toLowerCase();
                    break;
                } else if (game.doorOne.equalsIgnoreCase("n")) {
                    System.out.println("You choose not to open the door. An observer thinks it must be locked and bashes it with their mace. They discover some Chain Mail inside and leave their own armor behind.");
                    Armour platedArmor = new Armour("Plated Armor", 7, 6);
                    game.player.setArmour(platedArmor);
                    System.out.println(game.player);
                    progress = "level6";
//                    level5InProgress = false;
//                    System.out.println("\nYou discover " + game.loki.getEnemyName() + " . He has " + game.loki.getEnemyHealth() + " health and " + game.loki.getEnemyDamage() + " damage. Would you like to attack it? Type y for yes, n for no, s for save, x for exit.");
//                    game.enemy3 = console.next().toLowerCase();
                    break;

                } else if (game.doorOne.equalsIgnoreCase("s")) {
//                    progress = "level6";
//                    String savedFileName = game.save(console);
//                System.out.println("We just saved your game...");
                    System.out.println("Please enter your save game name.");
                    String savedFileName = console.nextLine();
                    game.save(console);
                    break;
                } else if (game.doorOne.equalsIgnoreCase("x")) {
                    System.out.println("Goodbye Traveller, return soon to conquer to hordes of evil!");
                    System.exit(0);
                    break;
                } else {
                    System.out.println("Please try again, your options are y or n to open the chest.");
                    game.doorOne = console.next().toLowerCase();
                }
            }
        }
//            break;

    case "level6":
//        boolean level6InProgress = true;
        while(progress.equalsIgnoreCase("level6")) {
            System.out.println("\nYou discover " + game.loki.getEnemyName() + " .He has " + game.loki.getEnemyHealth() + " health and " + game.loki.getEnemyDamage() + " damage. Would you like to attack it? Type y for yes, n for no, s for save, x for exit.");
            game.enemy3 = console.next().toLowerCase();

            while (true) {
                if (game.enemy3.equalsIgnoreCase("y")) {
                    System.out.println("\nYou attack " + game.loki.getEnemyName());

//                ArmourFiles.Helmet helmet = new ArmourFiles.Helmet("none", 1, 0);
//                ArmourFiles.Helmet platedHelmet = new ArmourFiles.Helmet("Plated ArmourFiles.Helmet", 5, 8);
                    /* helmet = platedHelmet; */
                /* to use non-static methods from a static method (e.g. main) you must call the objects (e.g.game.player), then call the method (e.g. setHelmet)
                then call the argument for the method (e.g. platedHelmet which in this case is an object of the non-static ArmourFiles.Helmet class */
                    int currentWeaponDamage = game.player.getCurrentWeaponDamage();

                    int lokiHealth = game.loki.getEnemyHealth();
                    while (true) {

                        if (currentWeaponDamage >= lokiHealth) {
//                System.out.println(game.player);
                            game.addDelay(2000);
                            lokiHealth -= currentWeaponDamage;
                            System.out.println("You have killed " + game.loki.getEnemyName() + " and taken no damage.");
                            Trouser chainMailTrousers = new Trouser("Chain Mail Trousers", 10, 10);
                            Weapon flamingSword = new Weapon("Flaming Sword", 24);
                            System.out.println(game.loki.getEnemyName() + " drops a key. You use it to open a chest. Inside is a pair of " + chainMailTrousers.getArmourName() + " and a " + flamingSword.getName() + ".");
                            game.player.setCurrentWeapon(flamingSword);
                            game.player.setTrouser(chainMailTrousers);
                            System.out.println(game.player);

//                            String savedFileName = game.save(console);
//                        System.out.println("\nYou discover a chest. Would you like to open it? Type y for yes, n for no, s for save, x for exit.");
//                        game.chestThree = console.next().toLowerCase();
//                        zombie.equalsIgnoreCase("s");
                            System.out.println("Please enter your save game name.");
                            String savedFileName = console.nextLine();
                            game.save(console);
                            System.out.println("Congratulations you have defeated the boss and completed the game. Well done!");
                            progress = "level7";
//                            level6InProgress = false;
                            System.exit(1);
                            break;
//                        System.out.println("\nYou discover a Door. Would you like to open it? Type y for yes, n for no, s for save, x for exit.");
//                String zombie = console.next().toLowerCase();
                        } else {
                            game.addDelay(2000);
                            System.out.println("\nYou have damaged the " + game.loki.getEnemyName());
                            lokiHealth -= currentWeaponDamage;
                            System.out.println("The " + game.loki.getEnemyName() + " now has " + lokiHealth + " health.");
                            System.out.println("\n" + game.loki.getEnemyName() + "has attacked you with " + game.loki.getEnemyDamage() + " damage.");
                            game.player.getArmour().reduceDurability(game.loki.getReduceDurability());
                            game.player.getShirt().reduceDurability(game.loki.getReduceDurability());
                            game.player.getShoe().reduceDurability(game.loki.getReduceDurability());
                            game.player.getHelmet().reduceDurability(game.loki.getReduceDurability());
                            game.player.getTrouser().reduceDurability(game.loki.getReduceDurability());
                            System.out.println(game.player);
                            game.player.takeDamage(game.loki.getEnemyDamage());
//                        break;

                        }
//                    break;
                    }
                    break;
                } else if (game.enemy3.equalsIgnoreCase("n")) {
                    System.out.println("You choose not to attack. " + game.loki.getEnemyName() + " attacks you in the back as you run away.");
                    game.player.takeDamage(game.loki.getEnemyDamage() / 2);
                    progress = "level7";
//                    level6InProgress = false;
//                    System.out.println("\nYou discover a chest. Would you like to open it? Type y for yes, n for no, s for save, x for exit.");
//                    game.doorOne = console.next().toLowerCase();
                    System.out.println("Your cowardly actions have not gone unnoticed, the King has thrown you in jail and you journey is at an end. Better luck next time.");
                    System.exit(0);
                    break;

                } else if (game.enemy3.equalsIgnoreCase("s")) {
//                    progress = "level7";
//                    String savedFileName = game.save(console);
//                System.out.println("We just saved your game...");
                    System.out.println("Please enter your save game name.");
                    String savedFileName = console.nextLine();
                    game.save(console);
                    break;
                } else if (game.enemy3.equalsIgnoreCase("x")) {
                    System.out.println("Goodbye Traveller, return soon to conquer to hordes of evil!");
                    System.exit(0);
                    break;
                } else {
//                    progress = "level7";
                    System.out.println("Please try again, your options are y or n to attack the Zombie, s to Save or x to exit");
                    game.enemy2 = console.next().toLowerCase();
                }
            }
        }
            break;















/*        game.addDelay(500);
        System.out.println("\nLet's take a quick look at you to make sure you're ready to head out the door.");
        System.out.println(game.player);

        game.addDelay(1000);
        System.out.println("\nWell, you're off to a good start, let's get your game saved so we don't lose it. Please enter your save game name.");
String savedFileName = game.save(console);


        game.addDelay(2000);
        System.out.println("We just saved your game...");
        System.out.println("Now we are going to try to load your character to make sure the save worked...");

        game.addDelay(1000);
        System.out.println("Deleting character...");
//        String saveName = savedFileName;
        game.player = null;

        game.addDelay(1500);
        game.player = game.load(savedFileName, console);
        System.out.println("Loading character...");

        game.addDelay(2000);
        System.out.println("Now let's print out your character again to make sure everything loaded:");

        game.addDelay(500);
        System.out.println(game.player);




 */

        }


    } // End of main

    /* Instance Methods */
    private Player start(Scanner console) {
        // Add start functionality here
Player player;
Art.homeScreen();
System.out.println("Welcome Traveller");
System.out.println("Would you like to start a new game? Y for yes, or N for No to load a previous game.");

String answer = console.nextLine();
String yes = "Y";
String no = "N";
if (answer.equalsIgnoreCase(yes)){
    newGame = true;
    System.out.println("What would you like your adventurer to be named?");
    String desiredPlayerName = console.nextLine();
    player = new Player(desiredPlayerName);
    return player;
} else if (answer.equalsIgnoreCase(no)) {
    System.out.println("What is the name of your save file?");
    String loadFileName = console.nextLine()+".svr";
    player = load(loadFileName, console);
    return player;

} else {
    newGame = true;
    System.out.println ("Sorry that input was not valid, we have created a new player for you with a great generic name ;)");
player = new Player("Generic Knight");
return player;
}
    } // End of start

    private String save(Scanner console) {
        // Add save functionality here
//        String fileName = player.getName() + ".svr";
        String chosenName = console.nextLine();
        String fileName = chosenName+".svr";
        try {

            FileOutputStream userSaveFile = new FileOutputStream(fileName);
            ObjectOutputStream playerSaver = new ObjectOutputStream(userSaveFile);
            playerSaver.writeObject(player);
            playerSaver.writeObject(progress);
            System.out.println("We've just saved your game with file name " + chosenName);

return fileName;
        } catch (IOException e) {
            System.out.println("Cannot Save");
String cannotSave = "Cannot Save";
return cannotSave;
        }
        // End of save
        // would be preferable to save as a console given name so different saves can be made and loaded when needed.
    }

    private Player load(String playerName, Scanner console) {
        // Add load functionality here

        Player loadedPlayer;

        try {

            FileInputStream loadedSaveFile = new FileInputStream(playerName);
            ObjectInputStream loadedObjectFile = new ObjectInputStream(loadedSaveFile);
           loadedPlayer = (Player) loadedObjectFile.readObject();
           this.progress = (String) loadedObjectFile.readObject();


            return loadedPlayer;
        } catch (IOException | ClassNotFoundException e) {

addDelay(2000);
            System.out.println("Unable to load file. We have created a new player with the name you have entered " + playerName + ".");
            addDelay(4000);

            loadedPlayer = new Player(playerName);

            return loadedPlayer;
            // End of load
        }

    }

    public void newGame(MedievalGame game, Scanner console) {
        game.addDelay(500);
        System.out.println("\nLet's take a quick look at you to make sure you're ready to head out the door.");
        System.out.println(game.player);

        game.addDelay(1000);
        System.out.println("\nWell, you're off to a good start, let's get your game saved so we don't lose it. Please enter your save game name.");
        String savedFileName = game.save(console);


        game.addDelay(2000);
//        System.out.println("We just saved your game...");
        System.out.println("Now we are going to try to load your character to make sure the save worked...");

        game.addDelay(1000);
        System.out.println("Deleting character...");
//        String saveName = savedFileName;
        game.player = null;

        game.addDelay(1500);
        game.player = game.load(savedFileName, console);
        System.out.println("Loading character...");

        game.addDelay(2000);
        System.out.println("Now let's print out your character again to make sure everything loaded:");

        game.addDelay(500);
        System.out.println(game.player);
    }



    // Adds a delay to the console so it seems like the computer is "thinking"
    // or "responding" like a human, not instantly like a computer.
    private void addDelay(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}