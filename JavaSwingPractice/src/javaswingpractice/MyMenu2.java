 import java.util.Scanner;
public class MyMenu2 {
    public static void main(String[] args) 
    {    
        String username="username",password="password",usn,pass,ans; 
        boolean bool=true;
       
        Scanner sc = new Scanner(System.in);
        
        while(bool)
        {    
            System.out.print("Are you a service crew of this restaurant?:");
            ans=sc.next();
        
            if(ans.equalsIgnoreCase("Yes")||ans.equalsIgnoreCase("Y"))
            {
                    bool=false;
                    System.out.println();
                    System.out.print("Enter your username:");
                    usn=sc.next();
                System.out.println();
                System.out.print("Enter your password:");
                pass=sc.next();
              
                if(username.equals(usn)&&password.equals(pass))
                {
                  
                    System.out.println("You can access the NON-GUI point of sale system!");
                    System.out.println();
                    do
                    {
                        System.out.println("Below are the only ones we have.But we will add more soon!");
                        System.out.println("A. Whopper");
                        System.out.println("B. Specialty Burger");
                        System.out.println("C. Chicken Royalty");
                        System.out.println("D. Sides");
                        System.out.println("E. Desserts");
                        System.out.println("F. Drinks");
                        System.out.println();
        
                        System.out.print("What is your order?:");
                        String choice=sc.next();
                            if(!(choice.equalsIgnoreCase("A")||choice.equalsIgnoreCase("B")||choice.equalsIgnoreCase("C")||choice.equalsIgnoreCase("D")||choice.equalsIgnoreCase("E")||choice.equalsIgnoreCase("F")))
                            {
                                System.out.println("Sorry we have only 6 choices!");
                            }
                            else if(choice.equalsIgnoreCase("A"))
                            {
                                GetWhoppers();
                            }//closing for Whoppers Method
                            else if(choice.equalsIgnoreCase("B"))
                            {
                                GetSpecialtyBurger();
                            }//closing for Specialty Burger
                            else if(choice.equalsIgnoreCase("C"))
                            {
                                GetChickenRoyalty();
                            }
                            else if(choice.equalsIgnoreCase("D"))
                            {
                                GetSides();
                            }
                            else if (choice.equalsIgnoreCase("E"))
                            {
                                GetDESSERTS();
                            }
                            else if(choice.equalsIgnoreCase("F"))
                            {
                                GetDRINKS();
                            }
                           System.out.println("Finished ordering?:");
                          ans=sc.next();
                    }//do-while
                     while(!(ans.equalsIgnoreCase("Yes")||ans.equalsIgnoreCase("Y")));
                }//username and password
        else
        {
                System.out.println("Incorrect username and password");        
        }
            }//yes statement
          else if(ans.equalsIgnoreCase("No")||ans.equalsIgnoreCase("N"))
          {
            System.out.println("You cannnot access the NON-GUI menu system ");
        bool=false;    
          }//no
        }//bool=true while loop
       
    }//main method
    public static void GetWhoppers()
    {
        String order;
        int customer;
        Scanner scan = new Scanner(System.in);
        System.out.println();
        System.out.print("How many are you,sir/mam?:");
        customer=scan.nextInt(); 
        System.out.println();
        System.out.println("Okay we have:"+" "+customer+" "+"customers");
        System.out.println();
        System.out.println("A. WHOPPER JR.");
        System.out.println("B. WHOPPER "   );
        System.out.println("C. 3-MEAT WHOPPER");  
        System.out.println("D. 4-CHEESE WHOPPER");
        System.out.println();
        System.out.print("Choose what you like:");
        order=scan.next();
            if(!(order.equalsIgnoreCase("A")||order.equalsIgnoreCase("B")||order.equalsIgnoreCase("C")||order.equalsIgnoreCase("D")))
            {        
               System.out.println("Sorry, we only have 4 available whoppers!");
            }//closing for other selection
            if(order.equalsIgnoreCase("A"))
            {
                int price=119;
                System.out.print("How many do you want?:");
                int count=scan.nextInt();
                 price=price*count;
                  System.out.println("The  total price of Whopper Jr. is:"+ " "+price);
                  System.out.println("Input how much the total price costs:");
                  int amount=scan.nextInt();
                  if(amount<price)
                  {
                      System.out.println("The amount you've entered is insufficient!");
                  }
                  else
                  {
                  int change=0;
                  change=amount-price;
                  System.out.println();
                  System.out.println("Your change is:"+" "+ change);
                  }  
            }//closing for choice A
                if(order.equalsIgnoreCase("B"))
                {
                    int price=179;
                    System.out.print("How many do you want?:");
                    int count=scan.nextInt();
                    price=price*count;
                    System.out.println("The  total price of Whopper is:"+ " "+price);
                    System.out.println("Input how much the total price costs:");
                    int amount=scan.nextInt();
                    if(amount<price)
                    {
                      System.out.println("The amount you've entered is insufficient!");  
                    }
                  else
                    {
                  int change=0;
                  change=amount-price;
                  System.out.println();
                  System.out.println("Your change is:"+" "+ change);
                    }
                }//closing for choice B
                if(order.equalsIgnoreCase("C"))
                {
                    int price=219;
                    System.out.print("How many do you want?:");
                    int count=scan.nextInt();
                    price=price*count;
                    System.out.println("The  total price of 3-Meat Whopper. is:"+ " "+price);
                    System.out.println("Input how much the total price costs:");
                    int amount=scan.nextInt();
                    if(amount<price)
                    {
                      System.out.println("The amount you've entered is insufficient!");
                    }
                  else
                    {
                  int change=0;
                  change=amount-price;
                  System.out.println();
                  System.out.println("Your change is:"+" "+ change);
                    }
                }//closing for choice C
                if(order.equalsIgnoreCase("D"))
              {
                    int price=99;
                    System.out.print("How many do you want?:");
                    int count=scan.nextInt();
                    price=price*count;
                    System.out.println("The  total price of 4-CHEESE WHOPPER is:"+ " "+price);
                    System.out.println("Input how much the total price costs:");
                    int amount=scan.nextInt();
                    if(amount<price)
                    {
                      System.out.println("The amount you've entered is insufficient!");
                    }
                  else
                    {
                  int change=0;
                  change=amount-price;
                  System.out.println();
                  System.out.println("Your change is:"+" "+ change);
                    }
              }//closing for choice D
        
    }//closing for Whoppers method
    public static void GetSpecialtyBurger()
    {
            String choice;
            int customer;
            Scanner scan = new Scanner(System.in);
            System.out.println();
            System.out.print("How many are you,sir/mam?:");
            customer=scan.nextInt();
            System.out.println();
            System.out.println("Okay we have:"+" "+customer+" "+"customers");
            System.out.println();
            System.out.println("A. Classic Angus Steakhouse Burger");
            System.out.println("B. Bacon Angus Steakhouse Burger  ");
            System.out.println("C. Bacon Cheese");  
            System.out.println("D. Mushroom Swiss");
            System.out.println();
            System.out.print("Choose what you like:");
            choice=scan.next();
        if(!(choice.equalsIgnoreCase("A")||choice.equalsIgnoreCase("B")||choice.equalsIgnoreCase("C")||choice.equalsIgnoreCase("D")))
        {        
            System.out.println("Sorry, we only have 4 available special  burgers!");
        }//closing for other selection
        if(choice.equalsIgnoreCase("A"))
        {
               int price=219;
               System.out.print("How many do you want?:");
               int count=scan.nextInt();
               price=price*count;
               System.out.println("The  total price of Classic Angus Steakhouse Burger is:"+ " "+price);
               System.out.println("Input how much the total price costs:");
               int amount=scan.nextInt();
                  if(amount<price)
                  {
                      System.out.println("The amount you've entered is insufficient!");    
                  }
                  else
                  {
                  int change=0;
                  change=amount-price;
                  System.out.println();
                  System.out.println("Your change is:"+" "+ change);
                  }    
        }//closing for choice A
           if(choice.equalsIgnoreCase("B"))
           {
                int price=240;
                System.out.print("How many do you want?:");
                int count=scan.nextInt();
                price=price*count;
                System.out.println("The  total price of Bacon Angus Steakhouse Burger is:"+ " "+price);
                System.out.println("Input how much the total price costs:");
                int amount=scan.nextInt();
                  if(amount<price)
                  {
                      System.out.println("The amount you've entered is insufficient!");    
                  }
                  else
                  {
                  int change=0;
                  change=amount-price;
                  System.out.println();
                  System.out.println("Your change is:"+" "+ change);
                  }
           }//closing for choice B
              if(choice.equalsIgnoreCase("C"))
              {
                    int price=199;
                    System.out.print("How many do you want?:");
                    int count=scan.nextInt();
                    price=price*count;
                    System.out.println("The  total price of Bacon Cheese is:"+ " "+price);
                    System.out.println("Input how much the total price costs:");
                    int amount=scan.nextInt();
                  if(amount<price)
                  {
                      System.out.println("The amount you've entered is insufficient!");    
                  }
                  else
                  {
                  int change=0;
                  change=amount-price;
                  System.out.println();
                  System.out.println("Your change is:"+" "+ change);
                  }
              }//closing for choice C
                if(choice.equalsIgnoreCase("D"))
            {
                int price=199;
                System.out.print("How many do you want?:");
                int count=scan.nextInt();
                price=price*count;
                System.out.println("The  total price of Mushroom Swiss is:"+ " "+price);
                System.out.println("Input how much the total price costs:");
                int amount=scan.nextInt();
                  if(amount<price)
                  {
                      System.out.println("The amount you've entered is insufficient!");    
                  }
                  else
                  {
                  int change=0;
                  change=amount-price;
                  System.out.println();
                  System.out.println("Your change is:"+" "+ change);
                  }
              }//choice D
       
    }//closing for Specialty Burger
     public static void GetChickenRoyalty()
    {
            String sel;
            int customer;
            Scanner scan = new Scanner(System.in);
            System.out.println();
            System.out.print("How many are you,sir/mam?:");
            customer=scan.nextInt();
            System.out.println();
            System.out.println("Okay we have:"+" "+customer+" "+"customers");
            System.out.println();
            System.out.println("A. X-tra Long Chicken");
            System.out.println("B. Chicken Crisp Fillet ");
            System.out.println("C. King's Crunchy Chicken");  
            System.out.println("D. Meaty Chicken Fillet");
            System.out.println();
            System.out.print("Choose what you like:");
            sel=scan.next();
        if(!(sel.equalsIgnoreCase("A")||sel.equalsIgnoreCase("B")||sel.equalsIgnoreCase("C")||sel.equalsIgnoreCase("D")))
        {        
               System.out.println("Sorry, we only have 4 available chicken!");
        }//closing for other selection
        if(sel.equalsIgnoreCase("A"))
        {
            int price=170;
            System.out.print("How many do you want?:");
            int count=scan.nextInt();
            price=price*count;
            System.out.println("The  total price of X-tra Long Chicken is:"+ " "+price);
            System.out.println("Input how much the total price costs:");
            int amount=scan.nextInt();
            if(amount<price)
            {
                      System.out.println("The amount you've entered is insufficient!");     
            }
            else
            {
                  int change=0;
                  change=amount-price;
                  System.out.println();
                  System.out.println("Your change is:"+" "+ change);
            }
        }//closing for choice A        
         if(sel.equalsIgnoreCase("B"))
        {
            int price=109;
            System.out.print("How many do you want?:");
            int count=scan.nextInt();
            price=price*count;
            System.out.println("The  total price of Chicken Crisp Fillet is:"+ " "+price);
            System.out.println("Input how much the total price costs:");
            int amount=scan.nextInt();
                  if(amount<price)
                  {
                      System.out.println("The amount you've entered is insufficient!");    
                  }
                  else
                  {
                  int change=0;
                  change=amount-price;
                  System.out.println();
                  System.out.println("Your change is:"+" "+ change);
                  }
        }//closing for choice B
             if(sel.equalsIgnoreCase("C"))
            {
                int piecemeal1=105,piecemeal2=165;
                System.out.println("A.1-pc.Meal");
                System.out.println("B.2-pc.Meal");
                System.out.println();
                System.out.print("Choose what you want:");
                String choice=scan.next();
                  if(!(choice.equalsIgnoreCase("A")||choice.equalsIgnoreCase("B")))
                  {
                    System.out.println("Sorry, we only have 2  meals for this chicken royalty!");
                  }//closing for other selection
                  else if(choice.equalsIgnoreCase("A"))
                {
                    System.out.print("How many do you want?:");
                    int counts=scan.nextInt();
                    piecemeal1=piecemeal1*counts;
                    System.out.println("The  total price of  1 piece of King's Crunchy Chicken is:"+ " "+piecemeal1);
                    System.out.println("Input how much the total price costs:");
                    int bill=scan.nextInt();
                        if(bill<piecemeal1)
                        {
                            System.out.println("The amount you've entered is insufficient!");
                        }
                        else
                        {
                            int change=0;
                            change=bill-piecemeal1;
                            System.out.println();
                            System.out.println("Your change is:"+" "+ change);
                        } 
                }//choice A
                  else if(choice.equalsIgnoreCase("B"))
                  {
                    System.out.print("How many do you want?:");
                    int counts=scan.nextInt();
                    piecemeal2=piecemeal2*counts;
                    System.out.println("The  total price of 2 piece of King's Crunchy Chicken is:"+ " "+piecemeal2);
                    System.out.println("Input how much the total price costs:");
                    int bill=scan.nextInt();
                        if(bill<piecemeal2)
                        {
                          System.out.println("The amount you've entered is insufficient!");
                        }
                        else
                        {
                            int change=0;
                            change=bill-piecemeal2;
                            System.out.println();
                            System.out.println("Your change is:"+" "+ change);
                        }
                  }
            }
             if(sel.equalsIgnoreCase("D"))
            {
                int price=89;
                System.out.print("How many do you want?:");
                int count=scan.nextInt();
                price=price*count;
                System.out.println("The  total price of Meaty Chicken Fillet is:"+ " "+price);
                System.out.println("Input how much the total price costs:");
                int amount=scan.nextInt();
                  if(amount<price)
                  {
                      System.out.println("The amount you've entered is insufficient!");
                  }
                  else
                  {
                  int change=0;
                  change=amount-price;
                  System.out.println();
                  System.out.println("Your change is:"+" "+ change);
                  }
            
            }//choice D
    }//Chicken Royalty
     public static void GetSides()
    {
        String option;
        int customer;
        Scanner scan = new Scanner(System.in);
        System.out.println("1. Onion Rings");
        System.out.println("2. Fries ");
        System.out.println();
        System.out.print("Choose what you like:");
        option=scan.next();
            if(!(option.equals("1")||option.equals("2")))
            {
                System.out.println("Sorry, we have only two side orders");
            }
            if(option.equals("1"))
            {
                String selection;
                int customers;
                Scanner sc= new Scanner(System.in);
                System.out.println();
                System.out.print("How many are you,sir/mam?:");
                customers=scan.nextInt();
                System.out.println();
                System.out.println("Okay we have:"+" "+customers+" "+"customers");
                System.out.println();
                System.out.println("1. Regular");
                System.out.println("2. Medium ");
                System.out.println("3. Large");
                System.out.println();
                System.out.print("Choose what you like:");
                option=scan.next();
            if(!(option.equals("1")||option.equals("2")||option.equals("3")))
            {
                System.out.println("Sorry, we have only 3 available sizes");
            }   
            if(option.equals("1"))
            {
                int price=29;
                System.out.print("How many do you want?:");
                int count=scan.nextInt();
                price=price*count;
                System.out.println("The  total price of regular onion rings is:"+ " "+price);
                System.out.println("Input how much the total price costs:");
                int amount=scan.nextInt();
                  if(amount<price)
                  {
                      System.out.println("The amount you've entered is insufficient!");
                  }
                  else
                  {
                  int change=0;
                  change=amount-price;
                  System.out.println();
                  System.out.println("Your change is:"+" "+ change);
                  }                   
            }//option A
                if(option.equals("2"))
            {
                int price=49;
                System.out.print("How many do you want?:");
                int count=scan.nextInt();
                price=price*count;
                System.out.println("The  total price of medium onion rings is:"+ " "+price);
                System.out.println("Input how much the total price costs:");
                int amount=scan.nextInt();
                  if(amount<price)
                  {
                      System.out.println("The amount you've entered is insufficient!");  
                  }
                  else
                  {
                  int change=0;
                  change=amount-price;
                  System.out.println();
                  System.out.println("Your change is:"+" "+ change);
                  }
            }//option B
            if(option.equals("3"))
            {
                int price=59;
                System.out.print("How many do you want?:");
                int count=scan.nextInt();
                
                price=price*count;
                System.out.println("The  total price of Large onion rings is:"+ " "+price);
                System.out.println("Input how much the total price costs:");
                int amount=scan.nextInt();
                    if(amount<price)
                    {
                      System.out.println("The amount you've entered is insufficient!");   
                    }
                  else
                    {
                        int change=0;
                        change=amount-price;
                        System.out.println();
                        System.out.println("Your change is:"+" "+ change);
                    }
            }//option C
           
        }//option A
         if(option.equals("2"))
        {
            String selection;
            int customers;
            Scanner sc= new Scanner(System.in);
            System.out.println();
            System.out.print("How many are you,sir/mam?:");
            customers=scan.nextInt();
            System.out.println();
            System.out.println("Okay we have:"+" "+customers+" "+"customers");
            System.out.println();
            System.out.println("4. Regular");
            System.out.println("5. Medium ");
            System.out.println("6. Large");
            System.out.println();
            System.out.print("Choose what you like:");
            option=scan.next();
                if(!(option.equals("4")||option.equals("5")||option.equals("6")))
                {
                    System.out.println("Sorry, we have only 3 available sizes");
                }
                if(option.equals("4"))
                {
                    int price=29;
                    System.out.print("How many do you want?:");
                    int count=scan.nextInt();
                    price=price*count;
                    System.out.println("The  total price of regular fries is:"+ " "+price);
                    System.out.println("Input how much the total price costs:");
                    int amount=scan.nextInt();
                    if(amount<price)
                    {
                    System.out.println("The amount you've entered is insufficient!");
                    }
                    else
                    {
                    int change=0;
                    change=amount-price;
                    System.out.println();
                    System.out.println("Your change is:"+" "+ change);
                    }
                    
                }//option A
            if(option.equals("5"))
            {
                int price=49;
                System.out.print("How many do you want?:");
                int count=scan.nextInt();
                price=price*count;
                System.out.println("The  total price of medium fries is:"+ " "+price);
                System.out.println("Input how much the total price costs:");
                int amount=scan.nextInt();
                if(amount<price)
                {
                      System.out.println("The amount you've entered is insufficient!");      
                }
                  else
                {
                  int change=0;
                  change=amount-price;
                  System.out.println();
                  System.out.println("Your change is:"+" "+ change);
                }
            }//B option
            if(option.equals("6"))
            {
                int price=59;
                System.out.print("How many do you want?:");
                int count=scan.nextInt();
                price=price*count;
                System.out.println("The  total price of large fries is:"+ " "+price);
                System.out.println("Input how much the total price costs:");
                int amount=scan.nextInt();
                  if(amount<price)
                  {
                      System.out.println("The amount you've entered is insufficient!");   
                  }
                  else
                  {
                  int change=0;
                  change=amount-price;
                  System.out.println();
                  System.out.println("Your change is:"+" "+ change);
                  }
            }//C option
        }//Fries 
    }//SIDES method
     public static void GetDESSERTS()
{
        String option;
        int customer;
        Scanner scan = new Scanner(System.in);
        System.out.println();
        System.out.print("How many are you,sir/mam?:");
        customer=scan.nextInt();
        System.out.println();
        System.out.println("Okay we have:"+" "+customer+" "+"customers");
        System.out.println();
        System.out.println("A. Hershey's Sundae Pie");
        System.out.println("B. Espresso Sundae");
        System.out.println("C. Sundaes  ");
        System.out.println();
        System.out.print("Choose what you like:");
        option=scan.next();
        if(!(option.equalsIgnoreCase("A")||option.equalsIgnoreCase("B")||option.equalsIgnoreCase("C")))
        {
            System.out.println("Sorry, we have only 3 available desserts");
        }
        if(option.equalsIgnoreCase("A"))
        {
            int price=95;
            System.out.print("How many do you want?:");
            int count=scan.nextInt();
            price=price*count;
            System.out.println("The  total price of Hershey's Sundae pie is:"+ " "+price);
            System.out.println("Input how much the total price costs:");
            int amount=scan.nextInt();
            if(amount<price)
            {
                System.out.println("The amount you've entered is insufficient!");   
            }
            else
            {
                int change=0;
                change=amount-price;
                System.out.println();
                System.out.println("Your change is:"+" "+ change);
            }
        }//A option
     if(option.equalsIgnoreCase("B"))
    {
         int price=49;
         System.out.print("How many do you want?:");
         int count=scan.nextInt();
         price=price*count;
         System.out.println("The  total price of Espresso Sundae is:"+ " "+price);
         System.out.println("Input how much the total price costs:");
         int amount=scan.nextInt();
                  if(amount<price)
                  {
                      System.out.println("The amount you've entered is insufficient!");   
                  }
                  else
                  {
                  int change=0;
                  change=amount-price;
                  System.out.println();
                  System.out.println("Your change is:"+" "+ change);
                  }
    }//B option
     if(option.equalsIgnoreCase("C"))
     {
         int price=29;
         System.out.print("How many do you want?:");
         int count=scan.nextInt();
         price=price*count;
         System.out.println("The  total price of Sundaes is:"+ " "+price);
         System.out.println("Input how much the total price costs:");
         int amount=scan.nextInt();
            if(amount<price)
            {
                      System.out.println("The amount you've entered is insufficient!");   
            }
            else
            {
                  int change=0;
                  change=amount-price;
                  System.out.println();
                  System.out.println("Your change is:"+" "+ change);
            }
    }//A option
}//Dessert Method
       public static void GetDRINKS(){
     String option;
        int customer;
        Scanner scan = new Scanner(System.in);
        System.out.println();
        System.out.print("How many are you,sir/mam?:");
        customer=scan.nextInt();
        System.out.println();
        System.out.println("Okay we have:"+" "+customer+" "+"customers");
        System.out.println();
        System.out.println("A. Coke 1.5L");
        System.out.println("B. Coke in Can");
        System.out.println("C. Bottled Water  ");
        System.out.println();
        System.out.print("Choose what you like:");
        option=scan.next();
        if(!(option.equalsIgnoreCase("A")||option.equalsIgnoreCase("B")||option.equalsIgnoreCase("C"))){
            System.out.println("Sorry, we have only 3 available drinks");
        }
     if(option.equalsIgnoreCase("A")){
         int price=65;
         System.out.print("How many do you want?:");
                    int count=scan.nextInt();
                      price=price*count;
                     System.out.println("The  total price of Coke 1.5 liters is:"+ " "+price);
                     System.out.println("Input how much the total price costs:");
                    int amount=scan.nextInt();
                  if(amount<price){
                      System.out.println("The amount you've entered is insufficient!");   
                  }
                  else{
                  int change=0;
                  change=amount-price;
                  System.out.println();
                  System.out.println("Your change is:"+" "+ change);
                  }
          }//A option
     if(option.equalsIgnoreCase("B")){
         int price=35;
         System.out.print("How many do you want?:");
                    int count=scan.nextInt();
                      price=price*count;
                     System.out.println("The  total price of Coke in Can is:"+ " "+price);
                     System.out.println("Input how much the total price costs:");
                    int amount=scan.nextInt();
                  if(amount<price){
                      System.out.println("The amount you've entered is insufficient!");   
                  }
                  else{
                  int change=0;
                  change=amount-price;
                  System.out.println();
                  System.out.println("Your change is:"+" "+ change);
                  }
          }//B option
     if(option.equalsIgnoreCase("C"))
     {
                     int price=35;
                     System.out.print("How many do you want?:");
                        int count=scan.nextInt();
                        price=price*count;
                      System.out.println("The  total price of Bottled Water is:"+ " "+price);
                      System.out.println("Input how much the total price costs:");
                        int amount=scan.nextInt();
                  if(amount<price)
                  {
                      System.out.println("The amount you've entered is insufficient!");   
                  }
                  else
                  {
                    int change=0;
                    change=amount-price;
                      System.out.println();
                      System.out.println("Your change is:"+" "+ change);
                  }
          }//A option
     }//Drinks Method

}//closing public class