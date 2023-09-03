import java.util.*;

public class RandomPasswordGenerator {
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int length, cap, small, special, num, flag = 0;
      length = 8;
      cap = small = special = num = 0;
      char tmp;
      System.out.println("-----------Password Generator-----------");
      while (true) {
         System.out.println("Please Choose from Below Options:");
         System.out.println("1. Generate New Password. \n2. Update Preferences. \n3. Exit.");
         int ch = sc.nextInt();
         switch (ch) {
            case 1:
               if (flag == 0) {
                  flag++;
                  System.out.print("\tEnter Length: ");
                  length = sc.nextInt();
                  System.out.print("\tInclude UpperCase Letters?(y/n): ");
                  tmp = sc.next().charAt(0);
                  if (tmp == 'y')
                     cap = 1;
                  else if (tmp == 'n')
                     cap = 0;

                  System.out.print("\tInclude LowerCase Letters?(y/n): ");
                  tmp = sc.next().charAt(0);
                  if (tmp == 'y')
                     small = 1;
                  else if (tmp == 'n')
                     small = 0;

                  System.out.print("\tInclude Special Characters?(y/n): ");
                  tmp = sc.next().charAt(0);
                  if (tmp == 'y')
                     special = 1;
                  else if (tmp == 'n')
                     special = 0;

                  System.out.print("\tInclude Numbers?(y/n): ");
                  tmp = sc.next().charAt(0);
                  if (tmp == 'y')
                     num = 1;
                  else if (tmp == 'n')
                     num = 0;
               }

               System.out.println();
               System.out.println("----------------------------------------");
               System.out.print("Your Password:  ");
               System.out.println(generatePassword(length, cap, small, special, num));
               System.out.println("----------------------------------------");
               System.out.println();
               break;
            case 2:
               if (flag == 0)
                  flag++;
               System.out.print("\tEnter Length: ");
               length = sc.nextInt();
               System.out.print("\tInclude UpperCase Letters?(y/n): ");
               tmp = sc.next().charAt(0);
               if (tmp == 'y')
                  cap = 1;
               else if (tmp == 'n')
                  cap = 0;

               System.out.print("\tInclude LowerCase Letters?(y/n): ");
               tmp = sc.next().charAt(0);
               if (tmp == 'y')
                  small = 1;
               else if (tmp == 'n')
                  small = 0;

               System.out.print("\tInclude Special Characters?(y/n): ");
               tmp = sc.next().charAt(0);
               if (tmp == 'y')
                  special = 1;
               else if (tmp == 'n')
                  special = 0;

               System.out.print("\tInclude Numbers?(y/n): ");
               tmp = sc.next().charAt(0);
               if (tmp == 'y')
                  num = 1;
               else if (tmp == 'n')
                  num = 0;
               break;
            case 3:
               System.exit(0);
               break;
            default:
               break;
         }
      }
   }

   private static char[] generatePassword(int length, int cap, int small, int special, int num) {
      String upperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
      String lowerCase = "abcdefghijklmnopqrstuvwxyz";
      String specialChars = "~!@#$%^&*+_;?";
      String numbers = "0123456789";

      Random random = new Random();
      char[] temp = new char[cap + small + special + num];
      char[] password = new char[length];
      int j = 0;

      if (small == 1)
         password[j++] = lowerCase.charAt(random.nextInt(lowerCase.length()));
      if (cap == 1)
         password[j++] = upperCase.charAt(random.nextInt(upperCase.length()));
      if (special == 1)
         password[j++] = specialChars.charAt(random.nextInt(specialChars.length()));
      if (num == 1)
         password[j++] = numbers.charAt(random.nextInt(numbers.length()));

      for (int i = j; i < length; i++) {
         j = 0;
         if (cap == 1)
            temp[j++] = upperCase.charAt(random.nextInt(upperCase.length()));
         if (small == 1)
            temp[j++] = lowerCase.charAt(random.nextInt(lowerCase.length()));
         if (special == 1)
            temp[j++] = specialChars.charAt(random.nextInt(specialChars.length()));
         if (num == 1)
            temp[j++] = numbers.charAt(random.nextInt(numbers.length()));

         password[i] = temp[(int) (Math.random() * temp.length)];
      }
      return password;
   }
}