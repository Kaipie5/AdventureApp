package com.stockcharts.training.javaadventureapp;

import java.util.*;

public class Game {

    public boolean firstTimeInCenter;
    public boolean firstTimeInShamanHut;
    public boolean giantAlive;
    public boolean dragonAlive;
    public boolean daGiantsAlive;
    public boolean undergroundDragonsAlive;
    public boolean west2PotionFound;
    public boolean shamanPotionFound;

    public Scanner console = new Scanner(System.in);
    
    public Game() {
        giantAlive = true;
        dragonAlive = true;
        daGiantsAlive = true;
        firstTimeInShamanHut = true;
        firstTimeInCenter = true;
        undergroundDragonsAlive = true;
        west2PotionFound = false;
        shamanPotionFound = false;
    }

    
    public void printIntroduction() {
        print("\n\n\t\t\tHills of Darkness for Java\n\n");
        print("\tYou awake from what appears to be a disturbing dream, knowing\n"
                + "\tneither where you've been nor how you got where you are now.\n"
                + "\tYou slowly rise to your feet, bewildered and almost oblivious\n"
                + "\tto the throbbing ache pulsating between your ringing ears.\n"
                + "\tYou find  yourself standing on a flowing grassy knoll amidst\n"
                + "\tthe dark green hills of medieval Scotland. In the skies above,\n"
                + "\tdark gray clouds are passing in billowing random patterns. It\n"
                + "\tappears a storm is approaching from the east. A few black ravens\n"
                + "\tfly over your head towards some unknown destination, a familiar\n"
                + "\tcaw, their cries echoing softly against the creeping shadows.\n");
        waitForKeypress();
    }


    public Location doCenter(Character player) {

        String nextAction = "#";
        Location location = Location.CENTER;

        if (firstTimeInCenter) {
            print("\n\n\t" + player.getName() + ", confused, you try to get your bearings.\n"
                    + "\tYou see nothing but large stone tablets and columns with\n"
                    + "\twhat appear to be odd and archaic symbols engraved upon them.\n");
            firstTimeInCenter = false;
        } else {
            print("\n\n\tYou return to the location where you first mysteriously appeared\n"
                    + "\tin this strange medieval world. You notice that the large stone\n"
                    + "\ttablets and columns have arranged themselves into arch and hinged\n"
                    + "\tgates. The symbols are constantly changing, disappearing and re-\n"
                    + "\tappearing at random intervals across the surface of the tablets.\n");
        }
        
        print("\tYou see that you can move to the north, south, east or west.\n"
                + "\tTo the NORTH, you see the ruins of an ancient castle spread\n"
                + "\tout across the horizon. To the EAST, you see the lapping waves\n"
                + "\tof the ocean against a sandy shore. To the south, you see a\n"
                + "\tsmall village with gray cobblestone houses and smoldering\n"
                + "\tchimneys. To the WEST, you see an abandoned farm house.\n");

        while (true) {
            print("\n\n\tWhere will you go (N,S,E,W)?  Or will you (T)ry the gates?\n"
                    + "\tOther: (O)ptions, (I)nventory, (D)isplay Stats, Use (H)ealing Potion  ");

            nextAction = readConsole();

            switch (nextAction) {
                case "n":
                    return Location.NORTH1;
                case "s":
                    return Location.SOUTH1;
                case "e":
                    return Location.EAST1;
                case "w":
                    return Location.WEST1;
                case "i":
                    player.showInventory();
                    break;
                case "d":
                    player.showStatistics();
                    break;
                case "h":
                    player.drinkHealingPotion();
                    break;
                case "t":
                    if (!firstTimeInCenter) {
                        return Location.GATEWAY;
                    }
                    break;
                default:
                    print("\n");
                    break;
            }
        }

    }


    Location doNorth1(Character player) {

        print("\n\n\tYou find yourself amidst the ruins of an ancient castle...\n\n");

        print("\tFurther to the NORTH, you see the delapidated entrance to the\n"
                + "\tabandoned castle. It is adjoined by crumbling towers, one at\n"
                + "\teach corner of the foundation. The entrance to the castle is a\n"
                + "\tfrail wooden door, looking as though it had been abandoned for\n"
                + "\tover a hundred years. It probably would not be too difficult to\n"
                + "\tforce the door open...\n\n"
                + "\tAt this point, you may explore the castle ruins, or go back to\n"
                + "\tthe SOUTH. You are surrounded by impassible castle walls to\n"
                + "\tthe EAST and the WEST.\n");

        while (true) {
            print("\n\n\tWhere will you go (N,S,E,W)?\n"
                    + "\tOther: (O)ptions, (I)nventory, (D)isplay Stats, Use (H)ealing Potion > ");

            String nextAction = readConsole();

            switch (nextAction) {
                case "n":
                    return Location.NORTH2;
                case "s":
                    return Location.CENTER;
                case "e":
                    print("\tYou fail to scale the east wall.\n");
                    break;
                case "w":
                    print("\tYou press against hard, cold stone.\n");
                    if (!player.hasChainMail()) {
                        print("\tYou find a suit of chain mail!\n");
                        player.addChainMail();
                        player.showInventory();
                    } else {
                        print("\tYou already have the chain mail!\n");
                    }
                    break;
                case "i":
                    player.showInventory();
                    break;
                case "d":
                    player.showStatistics();
                    break;
                case "h":
                    player.drinkHealingPotion();
                    break;
                default:
                    print("\n");
                    break;
            }
            
        }

    }


    Location doSouth1(Character player) {

        print("\n\n\tYou stumble into the gates of a rustic village. You see what\n"
                + "\tappears to be a tavern to the NORTH. Further south, you see a winding\n"
                + "\tdirt road that meanders towards the horizon. All around you are\n"
                + "\tpeasants buying and selling wares in an open market place. Near\n"
                + "\tthe center of the village several children are playing, and in the\n"
                + "\tmidst of them sits an elderly woman, looking very wise and thoughtful.\n");

        print("\tAt this point, you may only go back to the NORTH or further SOUTH.\n"
                + "\tif you so desire. You are surrounded by what seems impassible\n"
                + "\tterrain to the EAST and the WEST and several cottages. Towards the\n"
                + "\tcenter of the villiage, you notice a small though nicely maintained\n"
                + "\tShaman's lodge with smoke billowing from its roof.");

        while (true) {
            print("\n\n\tChoices: (N,S,E,W)  (G)o into the Shaman's Hut\n"
                    + "\tOther: (O)ptions, (I)nventory, (D)isplay Stats, Use (H)ealing Potion > ");

            String nextAction = readConsole();

            switch (nextAction) {
                case "n":
                    return Location.CENTER;
                case "s":
                    return Location.SOUTH2;
                case "e":
                    print("\tYou have no right to enter someone else's dwelling!\n");
                    break;
                case "w":
                    if (player.hasSword() == false) {
                        print("\nBonus!!!\n");
                        print("\tYou can not manage to ascend the gate in front of you.\n"
                            + "\tbut you do find a broad sword at the base of the wall!");
                        player.addSword();
                        player.showInventory();
                    }
                    break;
                case "g":
                    return Location.SHAMAN;
                case "i":
                    player.showInventory();
                    break;
                case "d":
                    player.showStatistics();
                    break;
                case "h":
                    player.drinkHealingPotion();
                    break;
                default:
                    print("\n");
                    break;
            }
        }

    }


    Location doEast1(Character player) {

        print("\n\n\tYou arrive at a sandy shore where green-blue translucent.\n"
                + "\twaves are crashing against rocky outcroppings. To the NORTH,\n");

        if (dragonAlive) {
            print("\ta magnificent red dragon folds its wings, smoke billowing\n"
                    + "\tfrom its nostrils.\n");
        } else {
            print("\ta slain dragon is being devoured by ravens...\n");
        }

        print("\n\n\tAt this point, you may only go back to the WEST. You are\n"
                + "\tsurrounded by turbulent water and razor sharp rocks to the\n"
                + "\tEAST and the south.\n");

        while (true) {
            print("\n\n\tWhere will you go? (N,S,E,W)\n"
                    + "\tOther: (O)ptions, (I)nventory, (D)isplay Stats, Use (H)ealing Potion > ");

            String nextAction = readConsole();

            switch (nextAction) {
                case "n":
                    if (dragonAlive) {
                        print("\n\n\tYou creep towards the Dragon. Startled, it climbs into the sky\n"
                                +" \tto defend itself!\n");
                        Dragon draco = new Dragon();
                        Location location = doCombat(player, draco, Location.EAST1);
                        dragonAlive = false;
                        return location;
                    } else {
                        print("\tYou see a noble red dragon, tragically and yet recently slain...\n");
                        break;
                    }
                case "s":
                    print("\n\tYou step on a jellyfish and it stings you with its tentacles!\n");
                    if (player.getHealth() > 1) {
                        player.damage(player.getHealth()-1);
                        player.showStatistics();
                    } else {
                        player.damage(player.getHealth());
                        print("\tHow pathetic! Slain by a jellyfish!\n");
                        waitForKeypress();
                        return Location.QUIT;
                    }
                    break;
                case "e":
                    print("\tYou jump into the water. It's freezing. You catch a cold.\n");
                    return Location.EAST2;
                case "w":
                    return Location.CENTER;
                case "i":
                    player.showInventory();
                    break;
                case "d":
                    player.showStatistics();
                    break;
                case "h":
                    player.drinkHealingPotion();
                    break;
                default:
                    print("\n");
                    break;
            }
        }

    }


    Location doWest1(Character player) {

        print("\n\n\tYou arrive at an abandoned farm house. You see a picket fence,\n"
                + "\ta rustic delapidated barn, and a decaying hovel that used to be \n"
                + "\tsomeone's residence. There are chickens walking around the.\n"
                + "\tpremesis. To the south, you see ");

        if (giantAlive) {
            print("a Giant wearing old, brown\n"
                    + "\tsackcloth. He is taunting you with offensive gestures and lewd comments.\n");
        } else {
            print("barbed wire, blood, sackcloth and carnage...\n");
        }

        print("\n\n\tAt this point, you may go NORTH or back EAST.\n"
                + "\tYou see only thick undergrowth and brush\n"
                + "\tto the WEST. To the SOUTH is that brutish giant.\n"
                + "\twith a foul mouth and a nasty disposition.\n");

        while (true) {
            print("\n\n\tWhere will you go? (N,S,E,W)\n"
                    + "\tOther: (O)ptions, (I)nventory, (D)isplay Stats, Use (H)ealing Potion > ");

            String nextAction = readConsole();

            switch (nextAction) {
                case "n":
                    print("\tYou are attacked by a vicious chicken! You can not pass.\n");
                    if (!player.hasDagger()) {
                        print("\tBut lying on the ground, you find a bronze dagger!");
                        player.addDagger();
                        player.showInventory();
                    } else {
                        print("\tYou already found the dagger!\n");
                    }
                    break;
                case "s":
                    if (giantAlive) {
                        print("\n\n\tYou walk towards the Giant and he charges you!");
                        Giant Bubba = new Giant();
                        Location location = Combat(player, Bubba, Location.WEST1);
                        giantAlive = false;
                        return location;
                    } else {
                        print("\tYou stumble over the corpse of a dead giant!\n");
                    }
                    break;
                case "e":
                    return Location.CENTER;
                case "w":
                    return Location.WEST2;
                case "i":
                    player.showInventory();
                    break;
                case "d":
                    player.showStatistics();
                    break;
                case "h":
                    player.drinkHealingPotion();
                    break;
                default:
                    print("\n");
                    break;
            }
        }

    }


    Location doNorth2(Character player) {

        print("\n\n\tYou walk inside the castle. It is dark and musty, but\n"
            + "\tenough daylight is leaking through the cracks in between\n"
            + "\tstones and mortar that you can ascertain your surroundings\n"
            + "\tin a dim, colorless twilight. Against the wall to the EAST\n"
            + "\tyou see a long wooden box, about the size of a coffin. You\n"
            + "\tcan see a table, chairs and several candle stands to the WEST\n"
            + "\tof the room. To the NORTH and the south the walls are adorned\n"
            + "\twith dusty, thread-bare tapestries. You notice stairs descending\n"
            + "\tdeep underground to some unknown passage to your right.\n");

        while (true) {
            print("\n\n\tChoices: (N,S,E,W) (U)nderground passage\n"
                    + "\tOther: (O)ptions, (I)nventory, (D)isplay Stats, Use (H)ealing Potion > ");

            String nextAction = readConsole();

            switch (nextAction) {
                case "n":
                    print("\tThe tapestries look very dry and dusty.\n");
                    break;
                case "s":
                    return Location.NORTH1;
                case "e":
                    print("\tYou approach the box and cautiously open it...\n");
                    if (!player.hasFullBodyArmor()) {
                        print("\tYou find a well preserved suit of full body armor!\n");
                        player.addFullBodyArmor();
                        player.showInventory();
                    } else {
                        print("\tThe box is empty - you already took the armor.\n");
                    }
                    break;
                case "w":
                    print("\tYou press against the wall but find nothing.\n");
                    break;
                case "u":
                    return Location.UNDERGROUND;
                case "i":
                    player.showInventory();
                    break;
                case "d":
                    player.showStatistics();
                    break;
                case "h":
                    player.drinkHealingPotion();
                    break;
                default:
                    print("\n");
                    break;
            }
        }

    }


    Location doSouth2(Character player) {

        print("\n\n\tYou wander through the village further to the south.\n");

        print("\n\tYou notice several of the villagers are staring at you\n"
                + "\tstrangely as you walk by. You come to the southern gate\n"
                + "\tthat guards the entrance to the village and pass through its\n"
                + "\topen doors. You follow a meandering dirt path towards the\n"
                + "\tedge of a dense hardwood forest. As you walk along the road,\n"
                + "\tyou pass several merchants hauling their wares by horse and\n"
                + "\tcart. Continuing south, you see a group of three giants \n"
                + "\tresting with their backs against the trees.\n");

        while (true) {
            print("\n\n\tWhere will you go (N,S,E,W)?\n"
                    + "\tOther: (I)nventory, (D)isplay Stats, Use (H)ealing Potion > ");

            String nextAction = readConsole();

            switch (nextAction) {
                case "n":
                    return Location.SOUTH1;
                case "s":
                    Location location = Location.SOUTH2;
                    if (daGiantsAlive) {
                        print("\tYou're either really brave or really stupid.\n");
                        print("\tAre you sure you want to fight 3 giants at the same time? (y/n) ");

                        String crazy = readConsole();

                        if (crazy.equals("y")) {
                            Giant[] daGiants = new Giant[3];
                            print("\tAll three giants charge you at once!\n");
                            for (int i = 0; i < 3; i++) {
                                daGiants[i] = new Giant();
                                location = Combat(player, daGiants[i], Location.SOUTH2);
                            }
                            daGiantsAlive = false;
                        } else {
                            print("\tIntelligently, you decide to walk away...\n");
                        }
                    } else {
                        print("\tYou see three dead giants.\n");
                    }
                    return location;
                case "e":
                    print("\tYou see a lake, covered with lily pads and algae, blocking your way.\n");
                    break;
                case "w":
                    print("\tYou see cat tails and dragon flies skimming across the water, blocking your way.\n");
                    break;
                case "i":
                    player.showInventory();
                    break;
                case "d":
                    player.showStatistics();
                    break;
                case "h":
                    player.drinkHealingPotion();
                    break;
                default:
                    print("\n");
                    break;
            }
        }

    }


    Location doEast2(Character player) {

        print("\n\n\tYou swim out to the sand bars hundreds of feet beyond the shore.\n"
                + "\tIn every direction, you see dolphins and sharks swimming around you.\n");

        while (true) {
            print("\n\n\tWhere will you go? (N,S,E,W)\n"
                    + "\tOther: (O)ptions, (I)nventory, (D)isplay Stats, Use (H)ealing Potion > ");

            String nextAction = readConsole();

            switch (nextAction) {
                case "n":
                    print("\n\tYou see dolphins and sharks.\n");
                    break;
                case "s":
                    print("\n\tYou see dolphins and sharks.\n");
                    if (!player.hasFishKey()) {
                        print("\n\tYou notice something metalic shining in the sand\n"
                                + "\tbeneath your feet. You dig into the sand and find\n"
                                + "\ta bronze key with a Fish engraved upon it.\n");
                        player.addFishKey();
                    } else {
                        print("\n\tHey, this is the same place you found that Fish key!\n");
                    }
                    break;
                case "e":
                    print("\n\tYou see dolphins and sharks.\n");
                    break;
                case "w":
                    return Location.EAST1;
                case "i":
                    player.showInventory();
                    break;
                case "d":
                    player.showStatistics();
                    break;
                case "h":
                    player.drinkHealingPotion();
                    break;
                default:
                    print("\n");
                    break;
            }
        }

    }
    
    
    Location doWest2(Character player) {

        print("\n\n\tYou find yourself walking in golden fields of wheat.\n");

        while (true) {
            print("\n\n\tWhere will you go (N,S,E,W)?\n"
                    + "\tOther: (O)ptions, (I)nventory, (D)isplay Stats, Use (H)ealing Potion > ");

            String nextAction = readConsole();

            switch (nextAction) {
                case "n":
                    if (!player.hasLongbow()) {
                        print("\tYou find a well-stringed long bow and arrows!\n");
                        player.addLongBow();
                        player.showInventory();
                    } else {
                        print("\tYou already found the long bow.\n");
                    }
                    break;
                case "s":
                    print("\tYou see... WHEAT!\n");
                    if (!west2PotionFound) {
                        print("\tBuried under a mound among the wheat, you find a healing potion!\n");
                        player.addHealingPotion();
                        west2PotionFound = true;
                        player.showInventory();
                    } else {
                        print("\tYou already found the healing potion!\n");
                    }
                    break;
                case "e":
                    return Location.WEST1;
                case "w":
                    print("\tYou see various feed crops planted in rows, blocking your way.\n");
                    break;
                case "i":
                    player.showInventory();
                    break;
                case "d":
                    player.showStatistics();
                    break;
                case "h":
                    player.drinkHealingPotion();
                    break;
                default:
                    print("\n");
                    break;
            }
        }

    }


    Location doShamanHut(Character player, Shaman theShaminator) {

        if (firstTimeInShamanHut) {
            print("\n\n\tYou duck down and enter into the Shaman's hut. Towards the center\n"
                    + "\tof the mud dwelling, beneath an overhanging shelf descending from the\n"
                    + "\tthatched roof, sits an elderly priestess. Unphased by your presence,\n"
                    + "\tshe continues to stare into the flames of a small fire burning within\n"
                    + "\ta set of blackened stone rings in the center of the hut. Directly over\n"
                    + "\ther head, an opening in the ceiling allows the smoke to escape. She\n"
                    + "\tgazes at you and cackles. \"Not expecting an old temple preistess, \n"
                    + "\twere you? Well, in this village, I'm the \"Shamanator\"!\n");
            firstTimeInShamanHut = false;
        } else {
            print("\n\n\tYou re-enter the Shaman's hut. She turns her head in a peculiar\n"
                    + "\tfashion and remarks, \"Back so soon, traveler?\" She offers you a cup\n"
                    + "\tof freshly brewed tea, which you gladly accept to quench your thirst.\n");

            if (!shamanPotionFound) {
                print("\tShe opens her medicine bag and begins creating an acrid mixture of\n"
                        + "\therbs. She pours it into a vial and places it in your hand, saying\n"
                        + "\t\"Drink this if you become wounded, my friend. It may restore\n"
                        + "\tyou to a measure of your former health and constitution.\"\n\n\n\n");

                player.addHealingPotion();
                shamanPotionFound = true;
                waitForKeypress();
                player.showInventory();
                waitForKeypress();
            } else {
                print("\tYou feel a sense of debt and gratitiude towards this\n"
                        + "\tkind old woman, remembering the healing elixir she gave\n"
                        + "\tyou on your last visit.\n");
            }
        }

        print("\n\n\tAt this point, you may (L)eave the Shaman's hut,\n"
                + "\t(T)alk with her if you so desire, or try to (S)teal\n"
                + "\ther medicine bag and staff for what wonders they may\n"
                + "\tcontain.\n");

        while (true) {
            print("\n\n\tYou may: (L)eave, (T)alk, or (S)teal things\n"
                    + "\tOther: (O)ptions, (I)nventory, (D)isplay Stats, Use (H)ealing Potion > ");

            String nextAction = readConsole();

            switch (nextAction) {
                case "n":
                case "e":
                case "w":
                    print("\tYou run into a straw-mud wall.\n");
                    break;
                case "l":
                    return Location.SOUTH1;
                case "s":
                    print("\tYou get the uneasy feeling that you are going\n"
                            + "\tto reap serious bad karma for this unwise action.\n");

                    try { Thread.sleep(3000); } catch (Exception e) {}

                    print("\tBellowing thunder cracks and the clouds darken as the deity\n"
                            + "\tof the temple preistess fills with indignation and anger!\n");

                    try { Thread.sleep(3000); } catch (Exception e) {}

                    print("\tIn an instant, lighting from the heavens strikes you\n"
                            + "\tdown!\n");

                    try { Thread.sleep(3000); } catch (Exception e) {}

                    print("\tYou go into the afterlife a loser, ashamed\n"
                            + "\tfor the despicable deeds you have done. The warriors\n"
                            + "\twho have gone on before you, the great warriors of\n"
                            + "\treknown and the kings of the past will ridicule you\n"
                            + "\tfor all of eternity for dieing without honor.\n");

                    waitForKeypress();
                    player.damage(player.getHealth());
                    player.showStatistics();
                    return Location.QUIT;
                case "t":
                    print("\tYou talk with The Shaminator...\n");
                    theShaminator.talk();
                    break;
                case "i":
                    player.showInventory();
                    break;
                case "d":
                    player.showStatistics();
                    break;
                case "h":
                    player.drinkHealingPotion();
                    break;
                default:
                    print("\n");
                    break;
            }
        }

    }


    Location doGateway(Character player) {

        if (player.hasFishKey()) {
            print("\n\n\tFumbling around the gate, you find a slot to insert the\n"
                    + "\tFish Key. The tablets and columns begin to rumble and shake.\n"
                    + "\tLarge stones rise, levitating off the ground, rearranging themselves.");
        } else {
            print("\n\n\tYou look around, trying every nook and crevice, but can not\n"
                    + "\tseem to find the means to open the gate, nor alter anything else\n"
                    + "\taround it. You see what appears to be a key hole to one side.\n");

            return Location.CENTER;
        }

        if (player.hasFishKey() && player.getScore() < 50) {
            print("\n\n\tIt appears that, although you have the key, you lack enough\n"
                    + "\texperience with the ways of this world to cause the gate to\n"
                    + "\tfunction in any useful manner. Go fight more shit.\n");

            return Location.CENTER;
        }

        if (player.hasFishKey() && player.getScore() >= 50) {
            print("\n\n\tWith the experience you have gained since entering this\n"
                    + "\tstrange world, you manage to figure out the correct sequence of\n"
                    + "\tactions to perform while turning the Fish key within the gate.\n"
                    + "\tYou hear a loud hiss followed by a dull hum as cascading beams of\n"
                    + "\tlight blind you from the opening dimensional portal.\n");

            print("\n\n\tYou feel as though you have won a series of battles in a\n"
                    + "\tlong campaign, but that the war is far from being over.\n"
                    + "\n\tHaving made several new friends and vanquished many foes as\n"
                    + "\ta soujourner in a strange land, you step through the gates,\n"
                    + "\tuncertain yet hopeful that this may bring you one step closer\n"
                    + "\tto home...\n");

            waitForKeypress();
            print("\tYou win this campaign and end the game with:\n");
            player.showStatistics();
            player.showInventory();
            print("\n\tCombat Experience Score: " + player.getScore() + ".\n");
            return Location.QUIT;
        }

        waitForKeypress();
        return Location.GATEWAY;
    }


    Location doUndergroundPassage(Character player) {

        Location location = Location.UNDERGROUND;

        print("\tYou descend into the darkness underground...\n");

        if (undergroundDragonsAlive) {
            print("\tPeeking around a corner, you see a family of red dragons\n"
                    + "\tbreathing fire! Think about whether you want to fight or flee.\n"
                    + "\tAre you sure you want to fight 5 dragons at the same time? (y,n)");

            String isNuts = readConsole();

            if (isNuts.equals("y")) {
                Dragon[] daDragons = new Dragon[5];
                for (int i = 0; i < 5; i++) {
                    daDragons[i] = new Dragon();
                    location = doCombat(player, daDragons[i], Location.UNDERGROUND);
                }
                undergroundDragonsAlive = false;
            } else {
                print("\tIntelligently, you decide to run back up the stairs...\n");
                return Location.NORTH2;
            }
        } else {
            print("\tYou see a family of dead red dragons and the carnal aftermath.\n"
                    + "\tof your last great battle with these fierce and worthy opponents.\n");
            return Location.NORTH2;
        }

        waitForKeypress();
        return location;
    }


    Location doCombat(Character player, Dragon monster, Location currentLocation) {

        print("\n\tMortal Combat!!!\n");

        boolean equipped = false;
        while (!equipped) {
            print("\tYou currently have:\n");
            player.showInventory();
            print("\tWhat weapon will you wage this battle with?\n"
                    + "\t(D)agger, (S)word, (L)ongbow, or (H)and-to-Hand combat > ");

            String nextAction = readConsole();

            switch (nextAction) {
                case "d":
                    if (player.hasDagger()) {
                        player.equipDagger();
                        equipped = true;
                    } else {
                        print("\n\tYou don't have the dagger!\n");
                    }
                    break;
                case "s":
                    if (player.hasSword()) {
                        player.equipSword();
                        equipped = true;
                    } else {
                        print("\n\tYou don't have the sword!\n");
                    }
                    break;
                case "l":
                    if (player.hasLongbow()) {
                        player.equipLongBow();
                        equipped = true;
                    } else {
                        print("\n\tYou don't have the long bow!\n");
                    }
                    break;
                case "h":
                    print("\n\tHand to hand it is...\n");
                    equipped = true;
                    break;
                default:
                    print("\n");
                    break;
            }
        }

        while (player.getHealth() > 0 && monster.getHealth() > 0) {
            if (player.getHealth() > 0) {
                player.Attack(monster);
            }
            if (monster.getHealth() > 0) {
                monster.Attack(player);
            }
        }

        if (player.getHealth() <= 0) {
            
            print("\tYou die, most tragically!\n");
            print("\tThe Dragon wins the battle, having " + monster.getHealth() + " hitpoints left.\n");

            waitForKeypress();
            return Location.QUIT;

        } else {

            print("\n\n\tYou vanquish your foe most valiantly!\n");
            print("\tThe Dragon died, now having " + monster.getHealth() + " hitpoints.\n");
            print("\t" + player.getName() + " has " + player.getHealth() + " hitpoints left.\n");
            print("\tAdd 1 to your attack and 1 to your defense as a result of\n"
                + "\tcombat experience acquired defeating this foe.\n");

            player.setScore((player.getScore() + 10));
            print("\n\t" + player.getName() + "'s Current Score: " + player.getScore() + "\n");
            player.incrementAttackPower();
            player.incrementDefense();
            player.showStatistics();

            waitForKeypress();
            return currentLocation;

        }
    }


    Location Combat(Character player, Giant monster, Location currentLocation) {

        print("\n\tMortal Combat!!!\n");

        boolean equipped = false;
        while (!equipped) {
            print("\tYou currently have:\n");
            player.showInventory();
            print("\tWhat weapon will you choose to wage this battle with?\n"
                + "\t(D)agger, (S)word, (L)ongbow, (H)and to Hand combat > ");

            String nextAction = readConsole();

            switch (nextAction) {
                case "d":
                    if (player.hasDagger()) {
                        player.equipDagger();
                        equipped = true;
                    } else {
                        print("\n\tYou don't have the dagger!\n");
                    }
                    break;
                case "s":
                    if (player.hasSword()) {
                        player.equipSword();
                        equipped = true;
                    } else {
                        print("\n\tYou don't have the sword!\n");
                    }
                    break;
                case "l":
                    if (player.hasLongbow()) {
                        player.equipLongBow();
                        equipped = true;
                    } else {
                        print("\n\tYou don't have the long bow!\n");
                    }
                    break;
                case "h":
                    print("\n\tHand to hand it is...\n");
                    player.equipHandToHand();
                    equipped = true;
                    break;
                default:
                    print("\n");
                    break;
            }
        }

        while (player.getHealth() > 0 && monster.getHealth() > 0) {
            if (player.getHealth() > 0) {
                player.Attack(monster);
            }
            if (monster.getHealth() > 0) {
                monster.Attack(player);
            }
        }

        if (player.getHealth() <= 0) {
            print("\tYou die, most tragically!\n");
            print("\tThe Giant wins the battle, having " + monster.getHealth() + " hitpoints left.\n");
            print("\t");
            waitForKeypress();
            return Location.QUIT;
        } else {
            print("\n\tYou vanquish your foe most valiantly!\n");
            print("\tThe Giant died, now having " + monster.getHealth() + " hitpoints.\n");

            print("\t" + player.getName() + " has " + player.getHealth() + " hitpoints left.\n");

            print("\tAdd 1 to your attack and 1 to your defense as a result of\n"
                + "\tcombat experience acquired defeating this foe.\n");

            player.setScore((player.getScore() + 10));
            print("\n\t" + player.getName() + "'s Current Score: " + player.getScore() + "\n");

            player.incrementAttackPower();
            player.incrementDefense();
            player.showStatistics();
            waitForKeypress();

            return currentLocation;
        }
    }

    // =========================================================================

    private void print(String s) {
        System.out.print(s);
    }
    
    private void waitForKeypress() {
        print("\n\tPress ENTER to continue.");
        console.nextLine();
    }

    private String readConsole() {
        String choice = console.nextLine().toLowerCase();
        String s = (choice.isEmpty()) ? "#" : choice.substring(0,1);
        return s;
    }

}
