import java.util.*;  // Scanner class
import java.io.*;    // File i/o Class

class Payroll_Project_Arrays_And_Files_With_Methods 
{
   public static void main(String[] args) throws IOException
   {
      Scanner input = new Scanner (System.in);
      
      // Initializing all the Variables
      final int Size = 2;
      final double State_Tax = .07;
      final double Fed_Tax = .15;
      String[] Employee_First_Name = new String[Size];
      String[] Employee_Last_Name = new String[Size];
      String[] Employee_ID_Number = new String[Size];
      char[] Employee_Middle_Initial = new char[Size];
      double[] Empolyee_Rate_Per_Hour = new double[Size];
      double[] Empolyee_Hours_Worked = new double[Size];
      double[] Empolyee_Gross = new double[Size];
      double[] Empolyee_State_Tax = new double[Size];
      double[] Empolyee_Fed_Tax = new double[Size];
      double[] Empolyee_Net = new double[Size];
      double Total_Gross = 0;
      double Gross_Average = 0;
      int Output_Type = 1;
      String Output_File_Name = "";
      
      //String[] Employee_First_Name, String[] Employee_Last_Name, String[] Employee_ID_Number, char[] Employee_Middle_Initial, double[] Empolyee_Rate_Per_Hour, double[] Empolyee_Hours_Worked, double[] Empolyee_Gross, double[] Empolyee_State_Tax, double[] Empolyee_Fed_Tax, double[] Empolyee_Net, double Total_Gross, double Gross_Average
      
      // Asking the user for the file name
      Output_File_Name = Get_OutPut_File_Name(input);
      PrintWriter Output_File = new PrintWriter(Output_File_Name);
      
      // Populating the Array
      for(int i = 0; i < Size; i++)
      {
         // Asking the user for their first name
         System.out.print("Enter First Name           : ");
         Employee_First_Name[i] = Get_FLid_Name(input);
         
         // Asking the user for their Middle Initial
         System.out.print("Enter Middle Initial       : ");
         Employee_Middle_Initial[i] = Get_MI(input);
         
         // Asking the user for their last name
         System.out.print("Enter Last Name            : ");
         Employee_Last_Name[i] = Get_FLid_Name(input);
         
         // Asking the user for their ID number
         System.out.print("Enter ID Number            : ");
         Employee_ID_Number[i] = Get_FLid_Name(input);
         
         // Asking the user for Hours worked
         System.out.print("Enter Hours Worked         : ");
         Empolyee_Hours_Worked[i] = Get_Hours(input);
         
         // Asking the user for Rate Per Hour
         System.out.print("Enter Rate Per Hour        : ");
         Empolyee_Rate_Per_Hour[i] = Get_Pay(input);

         System.out.println("____________________________________________");
      }
      
      // This for loop Calculates
      // - Empolyee Gross
      // - Empolyee State Tax
      // - Empolyee Fed Tax
      // - Empolyee Net
      // - Total Gross
      for(int i = 0; i < Size; i++)
      {   
      
         Empolyee_Gross[i] = Get_Gross(Empolyee_Hours_Worked[i], Empolyee_Rate_Per_Hour[i]);
         Empolyee_State_Tax[i] = Get_State_Tax(Empolyee_Gross[i], State_Tax);
         Empolyee_Fed_Tax[i] = Get_Fed_Tax(Empolyee_Gross[i], Fed_Tax);
         Empolyee_Net[i] = Get_Net(Empolyee_Gross[i], Empolyee_State_Tax[i], Empolyee_Fed_Tax[i]);
         Total_Gross += Empolyee_Gross[i];
         
      }
      // Askes the user for a type of an output (Screen output, file output, or both)
      // Validation Check for the Output type
      Output_Type = Get_OutPut_Type(input);
      
      // Calculates Gross Average
      Gross_Average = Get_Gross_Average(Total_Gross, Size);
      
      switch(Output_Type)
      {
      // If user enters 1 for screen output, the user will get Screen Output
         case 1:
            OutPut_Type_1(Size, Employee_First_Name, Employee_Last_Name, Employee_ID_Number, Employee_Middle_Initial, Empolyee_Rate_Per_Hour, Empolyee_Hours_Worked, Empolyee_Gross, Empolyee_State_Tax, Empolyee_Fed_Tax, Empolyee_Net, Total_Gross, Gross_Average);
            break;
            
      // If user enters 2 for file output, the user will get file output
         case 2:
            OutPut_Type_2(Output_File_Name, Output_File, Size, Employee_First_Name, Employee_Last_Name, Employee_ID_Number, Employee_Middle_Initial, Empolyee_Rate_Per_Hour, Empolyee_Hours_Worked, Empolyee_Gross, Empolyee_State_Tax, Empolyee_Fed_Tax, Empolyee_Net, Total_Gross, Gross_Average);
            break;
            
      // If user enters 3 for both, the user will get screen and file output
         case 3:
            OutPut_Type_3(Output_File_Name, Output_File, Size, Employee_First_Name, Employee_Last_Name, Employee_ID_Number, Employee_Middle_Initial, Empolyee_Rate_Per_Hour, Empolyee_Hours_Worked, Empolyee_Gross, Empolyee_State_Tax, Empolyee_Fed_Tax, Empolyee_Net, Total_Gross, Gross_Average);
            break;
      }
      
      // Close the file
      Output_File.close();
            
   }  
   
   public static String Get_OutPut_File_Name(Scanner input)
   {
      // Asking the user for the file name
      System.out.print("Enter the name of the file where you would like to get the output: ");
      String Output_File_Name = input.next();
      return Output_File_Name + ".txt";
   }
   
   public static String Get_FLid_Name(Scanner input)
   {
      String name = "";
      name = input.next();
      
      return name;
   }
   
   public static char Get_MI(Scanner input)
   {
      char MI;
      MI = input.next().charAt(0);
      
      return MI;
   }
   
   public static double Get_Hours(Scanner input)
   {
      double hours = 0;
      hours = input.nextDouble();
      hours = Val_Check_1(hours);
      return hours;
   }
   
   public static double Val_Check_1(double num)
   {
      Scanner input = new Scanner(System.in);
      double numCheck = num;
      while(numCheck < 0 || numCheck > 60)
      {
         System.out.print("(ERROR) Enter Hours Worked : ");
         numCheck = input.nextDouble();
      }
      return numCheck;
   }
   
   public static double Get_Pay(Scanner input)
   {
      double pay = 0;
      pay = input.nextDouble();
      pay = Val_Check_2(pay);
      return pay;
   }
   
   public static double Val_Check_2(double num)
   {
      Scanner input = new Scanner(System.in);
      double numCheck = num;
      while(numCheck < 15 || numCheck > 35)
      {
         System.out.print("(ERROR) Enter Rate Per Hour: ");
         numCheck = input.nextDouble();
      }
      return numCheck;
   }
   
   public static double Get_State_Tax(double num1, double num2)
   {
      double State_Tax = num1 * num2;
      return State_Tax;
   }
   
   public static double Get_Fed_Tax(double num1, double num2)
   {
      double Fed_Tax = num1 * num2;
      return Fed_Tax;
   }
   
   public static double Get_Gross(double hours, double pay)
   {
      double gross = 0;
      if(hours > 0 && hours <= 40)
      {
         gross = hours * pay;
      }
      else if(hours > 40 && hours <= 60)
      {
         gross = 40 * pay + (hours - 40) * (pay *1.5);
      }
      
      return gross;
   }
   
   public static double Get_Net(double gross, double StateTax, double FedTax)
   {
      double net = 0;
      net = gross - (StateTax + FedTax);
      
      return net;
   }
   
    public static int Get_OutPut_Type(Scanner input)
    {
      int Output_Type = 1;
      System.out.println("Enter 1 to print the out put on screen:");
      System.out.println("Enter 2 to get the output in a file:");
      System.out.println("Enter 3 to print output on screen and to get the output in a file:");
      System.out.print("Enter Here : ");
      Output_Type = input.nextInt();
      Output_Type = Val_Check_3(Output_Type);
      return Output_Type;
    }
    
    public static int Val_Check_3(int num)
    {
      Scanner input = new Scanner(System.in);
      int Output_Type = num;
      while(Output_Type < 1 || Output_Type > 3)
      {
         System.out.println("");
         System.out.println("|| ----------------------ERROR----------------------|| ");
         System.out.println("|| Invalide Entry Please Enter One Of The Following || ");
         System.out.println("|| ----------------------ERROR----------------------|| ");
         System.out.println("|| Enter 1 to print the out put on screen:          || ");
         System.out.println("|| Enter 2 to get the output in a file:             || ");
         System.out.println("|| Enter 3 to print output on screen and            || ");
         System.out.println("||         to get the output in a file:             || ");
         System.out.print("|| Enter Here : ");
         Output_Type = input.nextInt();
      }
      
      return Output_Type;
    }
    
    public static double Get_Gross_Average(double gross, int size)
    {
      double grossAve = 0;
      grossAve = gross / size;
      
      return grossAve;
    }
    
    public static void OutPut_Type_1(int Size, String[] Employee_First_Name, String[] Employee_Last_Name, String[] Employee_ID_Number, char[] Employee_Middle_Initial, double[] Empolyee_Rate_Per_Hour, double[] Empolyee_Hours_Worked, double[] Empolyee_Gross, double[] Empolyee_State_Tax, double[] Empolyee_Fed_Tax, double[] Empolyee_Net, double Total_Gross, double Gross_Average)
    {
      System.out.printf("%-12s%-12s%-8s%-12s%-18s%-14s%-14s%-12s%-12s%-12s", "Last Name", "First Name", "MI", "ID#", "Rate Per Hour", "Hours Worked", "State Tax", "Fed Tax", "Gross", "Net");
      System.out.println("");
      for(int i = 0; i < Size; i++)
      {
         System.out.printf("%-12s%-12s%-8c%-12s%-18.2f%-14.2f%-14.2f%-12.2f%-12.2f%-12.2f", Employee_Last_Name[i], Employee_First_Name[i], Employee_Middle_Initial[i], Employee_ID_Number[i], Empolyee_Rate_Per_Hour[i], Empolyee_Hours_Worked[i], Empolyee_State_Tax[i], Empolyee_Fed_Tax[i], Empolyee_Gross[i], Empolyee_Net[i]);
         System.out.println("");
      }
      System.out.printf("Total Gross =%6.2f\n", Total_Gross);
      System.out.printf("Gross_Average = %2.2f\n", Gross_Average);
    }
    
    public static void OutPut_Type_2(String Output_File_Name, PrintWriter Output_File, int Size, String[] Employee_First_Name, String[] Employee_Last_Name, String[] Employee_ID_Number, char[] Employee_Middle_Initial, double[] Empolyee_Rate_Per_Hour, double[] Empolyee_Hours_Worked, double[] Empolyee_Gross, double[] Empolyee_State_Tax, double[] Empolyee_Fed_Tax, double[] Empolyee_Net, double Total_Gross, double Gross_Average)
    {
      Output_File.printf("%-12s%-12s%-8s%-12s%-18s%-14s%-14s%-12s%-12s%-12s\n", "Last Name", "First Name", "MI", "ID#", "Rate Per Hour", "Hours Worked", "State Tax", "Fed Tax", "Gross", "Net");
      for(int i = 0; i < Size; i++)
      {
         Output_File.printf("%-12s%-12s%-8c%-12s%-18.2f%-14.2f%-14.2f%-12.2f%-12.2f%-12.2f\n", Employee_Last_Name[i], Employee_First_Name[i], Employee_Middle_Initial[i], Employee_ID_Number[i], Empolyee_Rate_Per_Hour[i], Empolyee_Hours_Worked[i], Empolyee_State_Tax[i], Empolyee_Fed_Tax[i], Empolyee_Gross[i], Empolyee_Net[i]);
      }
      Output_File.printf("\nTotal Gross = %.2f\n", Total_Gross);
      Output_File.printf("Gross_Average = %.2f\n", Gross_Average);
    }
    
    public static void OutPut_Type_3(String Output_File_Name, PrintWriter Output_File, int Size, String[] Employee_First_Name, String[] Employee_Last_Name, String[] Employee_ID_Number, char[] Employee_Middle_Initial, double[] Empolyee_Rate_Per_Hour, double[] Empolyee_Hours_Worked, double[] Empolyee_Gross, double[] Empolyee_State_Tax, double[] Empolyee_Fed_Tax, double[] Empolyee_Net, double Total_Gross, double Gross_Average)
    {
      System.out.printf("%-12s%-12s%-8s%-12s%-18s%-14s%-14s%-12s%-12s%-12s", "Last Name", "First Name", "MI", "ID#", "Rate Per Hour", "Hours Worked", "State Tax", "Fed Tax", "Gross", "Net");
      System.out.println("");
      for(int i = 0; i < Size; i++)
      {
         System.out.printf("%-12s%-12s%-8c%-12s%-18.2f%-14.2f%-14.2f%-12.2f%-12.2f%-12.2f", Employee_Last_Name[i], Employee_First_Name[i], Employee_Middle_Initial[i], Employee_ID_Number[i], Empolyee_Rate_Per_Hour[i], Empolyee_Hours_Worked[i], Empolyee_State_Tax[i], Empolyee_Fed_Tax[i], Empolyee_Gross[i], Empolyee_Net[i]);
         System.out.println("");
      }
      Output_File.printf("%-12s%-12s%-8s%-12s%-18s%-14s%-14s%-12s%-12s%-12s\n", "Last Name", "First Name", "MI", "ID#", "Rate Per Hour", "Hours Worked", "State Tax", "Fed Tax", "Gross", "Net");
      for(int i = 0; i < Size; i++)
      {
         Output_File.printf("%-12s%-12s%-8c%-12s%-18.2f%-14.2f%-14.2f%-12.2f%-12.2f%-12.2f\n", Employee_Last_Name[i], Employee_First_Name[i], Employee_Middle_Initial[i], Employee_ID_Number[i], Empolyee_Rate_Per_Hour[i], Empolyee_Hours_Worked[i], Empolyee_State_Tax[i], Empolyee_Fed_Tax[i], Empolyee_Gross[i], Empolyee_Net[i]);
      }
      System.out.printf("\nTotal Gross = %.2f\n", Total_Gross);
      System.out.printf("Gross_Average = %.2f\n", Gross_Average);
      Output_File.printf("\nTotal Gross = %.2f\n", Total_Gross);
      Output_File.printf("Gross_Average = %.2f\n", Gross_Average);
    }
}  
