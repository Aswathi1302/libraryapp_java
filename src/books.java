import java.sql.*;
import java.util.Scanner;

public class books {
    public static void main(String[] args) {
        int charge,copies,bookcode;
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
                    System.out.println("Enter bookcode");
                    bookcode=sc.nextInt();
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
                        String sql="INSERT INTO `library`(`bookcode`,`title`, `author`, `category`, `charge`, `copies`) VALUES  (?,?,?,?,?,?)";
                        PreparedStatement stmt=con.prepareStatement((sql));
                        stmt.setInt(1,bookcode);
                        stmt.setString(2,title);
                        stmt.setString(3,author);
                        stmt.setString(4,category);
                        stmt.setInt(5,charge);
                        stmt.setInt(6,copies);
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
                        String sql="SELECT `bookcode`,`title`, `author`, `category`, `charge`, `copies` FROM `library`";
                        Statement stmt=con.createStatement();
                        ResultSet rs=stmt.executeQuery(sql);


                        while ((rs.next())) {
                            String getbookcode = rs.getString(("bookcode"));
                            String gettitle = rs.getString(("title"));
                            String getauthor = rs.getString(("author"));
                            String getcategory = rs.getString(("category"));
                            String getcharge = rs.getString(("charge"));
                            String getcopies = rs.getString(("copies"));
                            System.out.println("Book code =" + getbookcode);
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
                    System.out.println("enter book code");
                    bookcode=sc.nextInt();
                    try{
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/librarydb","root","");
                        String sql="SELECT `title`, `author`, `category`, `charge`, `copies` FROM `library` WHERE `bookcode`="+String.valueOf(bookcode);
                        Statement stmt=con.createStatement();
                        ResultSet rs=stmt.executeQuery(sql);
                        while(rs.next()){
                            String gettitle = rs.getString(("title"));
                            String getauthor = rs.getString(("author"));
                            String getcategory = rs.getString(("category"));
                            String getcharge = rs.getString(("charge"));
                            String getcopies= rs.getString(("copies"));
                            System.out.println("Title=" + gettitle);
                            System.out.println("Author=" + getauthor);
                            System.out.println("Category=" + getcategory);
                            System.out.println("Charge=" + getcharge);
                            System.out.println("Copies=" + getcopies);
                        }



                    }
                    catch (Exception e){
                        System.out.println((e));
                    }

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
