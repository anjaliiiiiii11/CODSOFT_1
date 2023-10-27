import java.util.Scanner;

public class Grade
{
    public static void main(String args[])
    {
    Scanner sc=new Scanner(System.in);
    
    System.out.println("Enter the total no of Subjects:");
    int n=sc.nextInt();
    int arr[]=new int[n];
    
    for(int i=0;i<n;i++)
    {   System.out.println("Enter Name of Subject: ");
        String sub=sc.next();
        System.out.println("Enter marks in "+sub+" out of 100");
        arr[i]=sc.nextInt();
        
    }
    int total=0;
    for(int i=0;i<n;i++)
    {       
        total+=arr[i];   
    }
    int avg_p=(total/n);
    System.out.println("The total marks in all Subjects:"+total);
    System.out.println("The average percentage:"+avg_p+"%");
    if(avg_p>85)
    {
         System.out.println("The grade obtained is: A");
    }
    else if((avg_p<85)&(avg_p>75))
    {
        System.out.println("The grade obtained is: B");
    }
    else if((avg_p<75)&(avg_p>65))
    {
        System.out.println("The grade obtained is: C");
    }
    else if((avg_p<65)&(avg_p>55))
    {
        System.out.println("The grade obtained is: D");
    }
    else if((avg_p<55)&(avg_p>45))
    {
        System.out.println("The grade obtained is: E");
    }
    else
    {
        System.out.println("Fail");
    }   
}  
}
