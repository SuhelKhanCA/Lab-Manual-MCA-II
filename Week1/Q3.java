import java.util.Scanner;
class Q3{
    public static void main(String[] args){
        System.out.print("Enter two numbers:");

        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        int sum = a+b;

        System.out.println("Sum of two numbers:"+ sum);
    }
}