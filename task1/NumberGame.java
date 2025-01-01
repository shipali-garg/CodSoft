package task1;
import java.util.*;

public class NumberGame {
	public static void main(String arg[])
	  {
		Scanner sc = new Scanner(System.in);
	      int i, num;
	      int round_=0,score=0;
	      String ch;
	      do{
	          round_++;
	          System.out.println("Round : " + round_);
	          System.out.println("You are given only five chances");
	          int random_ = 1 + (int)(100 * Math.random());
		    int k = 5;
	          for(i = 0; i < k; i++) {
	              System.out.print("Guess the number : ");
	              num = sc.nextInt();
	        
	              if (random_ == num) {
			     System.out.println("Congratulations! Your guess is correct.");
	                   score+=20;
			     break;
		        }
		        else if (random_ > num) {
			     System.out.println("The number is "+ "greater than " + num);
	              }  
		        else if (random_ < num) {
			     System.out.println("The number is " + "lesser than " + num);
		        }
		    }
	          if (i == k) {
		        System.out.println("Oops! You lose the game.");
	              System.out.println("The number was " + random_);
		    }
	        
	          System.out.print("Do you want to try again(Press Y for \'Yes\') : ");
	          ch=sc.next();
	      }while(ch.equalsIgnoreCase("Y"));

	      System.out.println("Your Score is : "+score);
	  }

}



