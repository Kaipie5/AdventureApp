package com.stockcharts.training.javaadventureapp;

public class JavaAdventureApp {

    public static void main(String[] args) {

        Game game = new Game();
        Character player = new Character();
        player.askPlayerForName();

        Shaman theShamanator = new Shaman();
        Location location = Location.CENTER;

        game.printIntroduction();
        
        boolean finished = false;
        while (!finished) {

            switch (location) {

                case NORTH1:
                    location = game.doNorth1(player);
                    break;

                case SOUTH1:
                    location = game.doSouth1(player);
                    break;

                case EAST1:
                    location = game.doEast1(player);
                    break;

                case WEST1:
                    location = game.doWest1(player);
                    break;

                case CENTER:
                    location = game.doCenter(player);
                    break;

                case NORTH2:
                    location = game.doNorth2(player);
                    break;

                case SOUTH2:
                    location = game.doSouth2(player);
                    break;

                case EAST2:
                    location = game.doEast2(player);
                    break;

                case WEST2:
                    location = game.doWest2(player);
                    break;

                case UNDERGROUND:
                    location = game.doUndergroundPassage(player);
                    break;

                case GATEWAY:
                    location = game.doGateway(player);
                    break;

                case SHAMAN:
                    location = game.doShamanHut(player, theShamanator);
                    break;

                case QUIT:
                    finished = true;
                    break;

                default:
                    System.out.print("Not a valid option. Please try again.");
                    break;

            }

        }
        
        System.out.print("\n\tExiting Hills of Darkness for Java");

    }

}
