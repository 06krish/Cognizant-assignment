
import java.util.*;
public class FinancialForcasting {
    public static double forecast(double amount,double rate,int years){
        if(years == 0){
            return amount;
        }
        return amount + forecast(amount,rate,years-1)*(rate+1);
    }
    public static void main(String[]args){
        Scanner sc  = new Scanner(System.in);
        System.out.println("Enter the initial amount:");
        double amount = sc.nextDouble();
        System.out.println("Enter the interest rate (in decimal):");
        double rate = sc.nextDouble();
        System.out.println("Enter the number of years:");
        int years  = sc.nextInt();
        double futureval = forecast(amount,rate,years);
        System.out.println("The future value after "+years+" years is: "+futureval);
    }
}
