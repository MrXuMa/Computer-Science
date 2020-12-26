import java.util.*;
public class Galf_Data
{
    public static void main (String[] args)
    {
        Scanner console = new Scanner (System.in);
        golfersList();
        System.out.println();
        System.out.print("Your answer: ");
        String favGolfer = console.nextLine();
        favGolfer = favGolfer.toLowerCase();
        int favNum = playerToNum(favGolfer);
        double[][] stats = stats();
        double[] favStats = favStats(stats,favNum);
        System.out.print("\n");
        String[] golferNames = golferNames();
        favStatsPrint(golferNames[favNum],favStats);
        printStats(stats);
        averageOfStat(stats,0,"The average drive of these golfers this season is ");
        averageOfStat(stats,8,"The average amount money these golfers made this season is $");
        averageOfStat(stats,3,"The average bridies a round for these golfers this season is ");
        averageOfStat(stats,6,"The average of total birdies this season for these golfers is ");
        averageOfStat(stats,2,"The average green in regulation percentage across these golfers this season is ");
        System.out.print("\n");
        stars(200);
        System.out.print("\n");
        System.out.print("\n");
        System.out.println("Type in two golfers you want to compare stats with");
        System.out.print("Golfer 1: ");
        String golfer1 = console.nextLine();
        System.out.print("Golfer 2: ");
        String golfer2 = console.nextLine();
        System.out.println();
        compare(stats,golfer1,golfer2);
    }

    public static void golfersList()
    {
        System.out.println("Hey Whats up man?");
        stars(200);
        System.out.println("\nTiger Woods \nBryson Dechambeau \nXander Schauffele \nPhil Mickelson \nRory Mcilroy \nBrooks Koepka \nDustin Johnson \nJon Rahm \nRickie Fowler\nJustin Thomas");
        stars(200);
        System.out.print("\n");
    }

    public static String[] golferNames()
    {
        String[] names = {"Tiger ", "Bryson","Xander","Phil  ","Rory  ","Brooks","Dustin","Jon   ","Rickie","Justin"};
        return names;
    }

    public static void averageOfStat(double[][] stats,int row,String message )
    {
        double sum = 0;
        for(int i = 0; i < stats.length; i++)
        {
            sum+=stats[i][row];
        }
        sum = sum/stats.length;
        if(row==2)
        {
            System.out.println(message+sum+"%");
        }
        else
        {
            System.out.println(message+sum);
        }
    }

    public static void printStats(double[][] stats)
    {
        System.out.println("\t   Average Drive    Diving Accuracy   Greens in Regulation  Average Birdies   Scoring Average    Offical Rank    Number of Birdies   Longest Drive       Money Made          Hole Outs");
        String[] names = golferNames();
        for(int i = 0; i < stats.length; i++)
        {
            System.out.print(" "+names[i]);
            for(int j = 0; j < stats[i].length; j++)
            {
                if(j == 1)
                    System.out.print("        "+stats[i][j]+"%     ");
                else if(j == 2)
                    System.out.print("        "+stats[i][j]+"%     ");
                else if(j == 8)
                    System.out.print("       $"+stats[i][j]+"      ");
                else
                    System.out.print("        "+stats[i][j]+"      ");
            }
            System.out.print("\n");
        }
        System.out.print("\n");
        stars(200);
        System.out.print("\n");
        System.out.print("\n");
    }

    public static void favStatsPrint(String name,double[] stats)
    {
        stars(200);
        System.out.println("\n");
        System.out.println("\t   Average Drive    Diving Accuracy   Greens in Regulation  Average Birdies   Scoring Average    Offical Rank    Number of Birdies   Longest Drive       Money Made          Hole Outs");
        System.out.print(" "+name);
        for(int i = 0; i < stats.length; i++)
        {
            if(i == 1)
                System.out.print("        "+stats[i]+"%     ");
            else if(i == 2)
                System.out.print("        "+stats[i]+"%     ");
            else if(i == 8)
                System.out.print("       $"+stats[i]+"      ");
            else
                System.out.print("        "+stats[i]+"      ");
        }
        System.out.println("\n");
        stars(200);
        System.out.println("\n");
    }
    
    public static void compare(double[][] stats, String golfer1, String golfer2)
    {
        int num1 = playerToNum(golfer1);
        int num2 = playerToNum(golfer2);
        String[] golferNames = golferNames();
        String[] dataPoints = dataPoints();
        for(int i = 0; i < stats.length; i++)
        {
            if(stats[num1][i] == stats[num2][i])
            {
                System.out.println(golferNames[num1] + " and " + golferNames[num2] + " " + dataPoints[i]+" is the same at "+ stats[num2][i]);
            }
            else if(i == 4 || i == 5)
            {
                if(stats[num1][i] > stats[num2][i])
                    System.out.println(golferNames[num2] + " has a better "+ dataPoints[i]+ " at " + stats[num2][i]);
                else
                    System.out.println(golferNames[num1] + " has a better "+ dataPoints[i]+ " at " + stats[num1][i]);
            }
            else
            {
                if(i == 8 || i == 9)
                {
                    if(stats[num1][i] > stats[num2][i])
                        System.out.println(golferNames[num1] + " has more "+ dataPoints[i]+ " at " + stats[num1][i]);
                    else
                        System.out.println(golferNames[num2] + " has more "+ dataPoints[i]+ " at " + stats[num2][i]);
                }
                else
                {
                    if(stats[num1][i] > stats[num2][i])
                        System.out.println(golferNames[num1] + " has a better "+ dataPoints[i]+ " at " + stats[num1][i]);
                    else
                        System.out.println(golferNames[num2] + " has a better "+ dataPoints[i]+ " at " + stats[num2][i]);
                }
            }
        }
    }
    
    
    public static String[] dataPoints()
    {
        String[] dataPoints = {"Driving Distance","Driving Accuracy Percentage","Greens in Regulation Percentage","Bridie Average","Scoring Average","Rank","Number of birdies","Longest Drive","Money Made","Hole Outs"};
        return dataPoints;
    }
    
    public static double[] favStats(double[][] arr, int num)
    {
        double[] favStats = new double[10];
        for(int i = 0; i < favStats.length; i++)
        {
            favStats[i] = arr[num][i];
        }
        return favStats;
    }

    public static int playerToNum(String player)
    {
        int returnVal = 0;
        switch(player)
        {
            case "tiger woods": case "tiger": returnVal = 0;
            break;
            case "bryson dechambeau": case "bryson": returnVal = 1;
            break;
            case "xander schauffele": case "xander": returnVal = 2;
            break;
            case "phil mickelson": case "phil": returnVal = 3;
            break;
            case "rory mcilroy": case "rory": returnVal = 4;
            break;
            case "brooks koepka": case "brooks": returnVal = 5;
            break;
            case "dustin johnson": case "dustin": case "dj": returnVal = 6;
            break;
            case "jon rahm": case "jon": returnVal = 7;
            break;
            case "rickie fowler": case "rickie": returnVal = 8;
            break;
            case "justin thomas": case "justin": returnVal = 9;
            break;
        }
        return returnVal;
    }

    public static void stars(int length)
    {
        for(int i = 1; i < length; i++)
        {
            System.out.print("*");
        }
    }

    public static double[][] stats()
    {
        double[][] stats  = new double[10][10];
        //#Tiger
        stats[0][0] = 290.3; //Drive distance
        stats[0][1] = 64.71; //Driving Accuracy Percentage
        stats[0][2] = 65.01; //Greens in reg Percentage
        stats[0][3] = 3.9; //Average birdies
        stats[0][4] = 72.79; //#Scoring average
        stats[0][5] = 36; //#Offical World Rank
        stats[0][6] = 39; //Number of birdies
        stats[0][7] = 372; //longest drive
        stats[0][8] = 64200; //money made
        stats[0][9] = 2; //hole outs
        //#Bryson
        stats[1][0] = 337.8; //Drive distance
        stats[1][1] = 58.33; //Driving Accuracy Percentage
        stats[1][2] = 68.06; //Greens in reg Percentage
        stats[1][3] = 4.4; //Average birdies
        stats[1][4] = 68.37; //Scoring average
        stats[1][5] = 5; //Offical World Rank
        stats[1][6] = 53; //Number of birdies
        stats[1][7] = 395; //longest drive
        stats[1][8] = 2502850; //money made
        stats[1][9] = 2; //hole outs
        //#Xander
        stats[2][0] = 303.7; //Drive distance
        stats[2][1] = 52.27; //Driving Accuracy Percentage
        stats[2][2] = 69.44; //Greens in reg Percentage
        stats[2][3] = 4.9; //Average birdies
        stats[2][4] = 69.14; //Scoring average
        stats[2][5] = 7; //Offical World Rank
        stats[2][6] = 79; //Number of birdies
        stats[2][7] = 362; //longest drive
        stats[2][8] = 1830101; //money made
        stats[2][9] = 3; //hole outs
        //#Phil
        stats[3][0] = 303.5; //Drive distance
        stats[3][1] = 44.95; //Driving Accuracy Percentage
        stats[3][2] = 62.85; //Greens in reg Percentage
        stats[3][3] = 3.8; //Average birdies
        stats[3][4] = 73.11; //Scoring average
        stats[3][5] = 64; //Offical World Rank
        stats[3][6] = 61; //Number of birdies
        stats[3][7] = 384; //longest drive
        stats[3][8] = 62570; //money made
        stats[3][9] = 1; //hole outs
        //#Rory
        stats[4][0] = 322.7; //Drive distance
        stats[4][1] = 63.18; //Driving Accuracy Percentage
        stats[4][2] = 64.58; //Greens in reg Percentage
        stats[4][3] = 5.1; //Average birdies
        stats[4][4] = 69.76; //Scoring average
        stats[4][5] = 4; //Offical World Rank
        stats[4][6] = 82; //Number of birdies
        stats[4][7] = 373; //longest drive
        stats[4][8] = 927050; //money made
        stats[4][9] = 0; //hole outs
        //#Brooks
        stats[5][0] = 307; //Drive distance
        stats[5][1] = 53.05; //Driving Accuracy Percentage
        stats[5][2] = 67.13; //Greens in reg Percentage
        stats[5][3] = 4.2; //Average birdies
        stats[5][4] = 69.49; //Scoring average
        stats[5][5] = 12; //Offical World Rank
        stats[5][6] = 50; //Number of birdies
        stats[5][7] = 360; //longest drive
        stats[5][8] = 6685927; //money made
        stats[5][9] = 1; //hole outs
        //#DJ
        stats[6][0] = 321.4; //Drive distance
        stats[6][1] = 62.81; //Driving Accuracy Percentage
        stats[6][2] = 73.61; //Greens in reg Percentage
        stats[6][3] = 4.0; //Average birdies
        stats[6][4] = 66.98; //Scoring average
        stats[6][5] = 1; //Offical World Rank
        stats[6][6] = 48; //Number of birdies
        stats[6][7] = 419; //longest drive
        stats[6][8] = 3117040; //money made
        stats[6][9] = 1; //hole outs
        //#Jon
        stats[7][0] = 313.2; //Drive distance
        stats[7][1] = 64.55; //Driving Accuracy Percentage
        stats[7][2] = 69.79; //Greens in reg Percentage
        stats[7][3] = 4; //Average birdies
        stats[7][4] = 69.57; //Scoring average
        stats[7][5] = 2; //Offical World Rank
        stats[7][6] = 64; //Number of birdies
        stats[7][7] = 391; //longest drive
        stats[7][8] = 1303249; //money made
        stats[7][9] = 0; //hole outs
        //#Rickie
        stats[8][0] = 304; //Drive distance
        stats[8][1] = 63.31; //Driving Accuracy Percentage
        stats[8][2] = 67.28; //Greens in reg Percentage
        stats[8][3] = 4.1; //Average birdies
        stats[8][4] = 71.72; //Scoring average
        stats[8][5] = 49; //Offical World Rank
        stats[8][6] = 74; //Number of birdies
        stats[8][7] = 357; //longest drive
        stats[8][8] = 157197; //money made
        stats[8][9] = 1; //hole outs
        //#Justin
        stats[9][0] = 300; //Drive distance
        stats[9][1] = 60.45; //Driving Accuracy Percentage
        stats[9][2] = 66.32; //Greens in reg Percentage
        stats[9][3] = 5; //Average birdies
        stats[9][4] = 69.13; //Scoring average
        stats[9][5] = 3; //Offical World Rank
        stats[9][6] = 80; //Number of birdies
        stats[9][7] = 377; //longest drive
        stats[9][8] = 1748556; //money made
        stats[9][9] = 1; //hole outs
        return stats;
    }
}
