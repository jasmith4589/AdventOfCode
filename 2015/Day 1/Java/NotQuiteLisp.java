import java.io.*;
import java.util.Scanner;
public class NotQuiteLisp{


    public static void main(String[] args){
        Scanner input = null;
        String data = null;
        int floor = 0;
        int basement = 0;
        File file = new File("input.txt");
        try
            {
            input = new Scanner(file);
            }
        catch (FileNotFoundException e)
            {
                System.out.println("An error occured.");
            }

        data = getText(input);   
        floor = calcFloor(data);
        basement = calcPositionOfBasement(data);
        System.out.println("The instructions take Santa to floor: " + floor);
        System.out.println("Following the instructions, we hit the basement at location: " + basement);
        input.close();
    }

    public static String getText(Scanner input){
        String dataReturned = null;
        while (input.hasNextLine())
        {
            dataReturned = input.nextLine();
        }
        return dataReturned;
    }

    
    public static int calcFloor(String data){
        int floor = 0;
        char[] array = data.toCharArray();
        for (int k=0; k<array.length; k++)
        {
            if (array[k] == '(' )
            {
                floor += 1;
            }
            else{
                floor -=1;
            }
        }
        return floor;
    }

    public static int calcPositionOfBasement(String data)
    {
        int floor = 0;
        int basement = 0;
        char[] array = data.toCharArray();
            for (int k=0; k<array.length && floor>=0; k++)
            {

                {
                    if (array[k] == '(' )
                    {
                        floor += 1;
                    }
                    else{
                        floor -=1;
                    }

                }
             basement = k;
            }
        return basement + 1;
    }
    


    
}