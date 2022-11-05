import java.sql.*;
import java.util.Scanner;

public class books {
    public static void main(String[] args) {
        int charge,copies;
        String title,author,category;

        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/librarydb","root","");
        }
        catch (Exception e){
            System.out.println((e));
        }
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
                    System.out.println("Enter book title");
                    title=sc.next();
                    System.out.println("Enter auther name");
                    author=sc.next();
                    System.out.println("Enter category");
                    category=sc.next();
                    System.out.println("Enter charge per day");
                    charge=sc.nextInt();
                    System.out.println("Ener number of copies");
                    copies=sc.nextInt();

                    try{
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/librarydb","root","");
                        String sql="INSERT INTO `library`(`title`, `author`, `category`, `charge`, `copies`) VALUES  (?,?,?,?,?)";
                        PreparedStatement stmt=con.prepareStatement((sql));
                        stmt.setString(1,title);
                        stmt.setString(2,author);
                        stmt.setString(3,category);
                        stmt.setInt(4,charge);
                        stmt.setInt(5,copies);
                        stmt.executeUpdate();
                        System.out.println("value inserted successfully.........!");
                    }
                    catch (Exception e){
                        System.out.println((e));
                    }

                    break;
                case 2:
                    try{
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/librarydb","root","");
                        String sql="SELECT `title`, `author`, `category`, `charge`, `copies` FROM `library`";
                        Statement stmt=con.createStatement();
                        ResultSet rs=stmt.executeQuery(sql);


                        while ((rs.next())) {
                            String gettitle = rs.getString(("title"));
                            String getauthor = rs.getString(("author"));
                            String getcategory = rs.getString(("category"));
                            String getcharge = rs.getString(("charge"));
                            String getcopies = rs.getString(("copies"));
                            System.out.println("Title =" + gettitle);
                            System.out.println("Author=" + getauthor);
                            System.out.println("Catagor=" + getcategory);
                            System.out.println("Charge per day=" + getcharge);
                            System.out.println("Copies=" + getcopies);
                            System.out.println("\n");
                        }
                        }
                    catch (Exception e){
                        System.out.println((e));
                    }
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
