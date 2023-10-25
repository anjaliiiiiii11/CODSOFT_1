package CODSOFT;
import java.util.Random;
import java.util.Scanner;

public class Game
{
    public static void main(String args[])
    {
    
        Scanner reader =new Scanner(System.in);
        String play ="yes";
        int score=0;
        while(play.equals("yes"))
        {
            Random rand=new Random();
            int randNum=rand.nextInt(101);
            int guess =-1;
            int tries =0;
            

            while(guess !=randNum)
            {
                System.out.println("Guess a number between 1-100:");
                guess=reader.nextInt();
                tries++;
                if (guess == randNum)
                {
                    System.out.println("Correct! You Win!");
                    System.out.println("It took you " + tries + " tries");
                    score+=10;
                    
                    System.out.println("Would you like to play again? yes or no:");
                    play=reader.next().toLowerCase();
                    break;
                }
                else if(randNum > guess)
                {
                    System.out.println("Nope! The number is higher. Guess again.");
                }
                else
                {
                    System.out.println("Nope! The number is lower. Guess again.");
                }

            

        }



 
    }
System.out.println("Your score is "+score+"!");
reader.close();
System.out.println("End");

}
}
