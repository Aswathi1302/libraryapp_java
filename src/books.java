import java.util.Scanner;

public class books {
    public static void main(String[] args) {
        int choice;
        while(true)
        {
            System.out.println("*******LIBRARY MANAGEMENT*******)");

            System.out.println("1.Add books");
            System.out.println("2.View books");
            System.out.println("3.Search books");
            System.out.println("4.Update books");
            System.out.println("5.delete books");
            System.out.println("6.Exit");
            System.out.println("*****************");
            System.out.println("ENTER YOUR CHOICE:--");
            Scanner sc=new Scanner(System.in);
            choice=sc.nextInt();
            switch (choice)
            {
                case 1:
                    System.out.println("add books");
                    break;
                case 2:
                    System.out.println("View books:--");
                    break;
                case 3:
                    System.out.println("Search books");
                    break;
                case 4:
                    System.out.println("Update books");
                    break;
                case 5:
                    System.out.println("Delete books");
                    break;
                case 6:
                    System.exit(0);
                    break;
            }
        }
    }
}
