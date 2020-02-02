import java.util.Scanner;

public class mainClass
{
    public static void swap(Student i, Student j)
    {
        String k = i.getfName();
        i.setfName(j.getfName());
        j.setfName(k);

        String z = i.getlName();
        i.setlName(j.getlName());
        j.setlName(z);

        int x = i.getAge();
        i.setAge(j.getAge());
        j.setAge(x);
    }

    public static void main(String args[])
    {
        Scanner scan = new Scanner(System.in);
        int a = 1, x;

        System.out.println("How many students do you have in the class ? ");
        System.out.print("Write here : ");
        int number = scan.nextInt();

        Student[] Stud = new Student[number+1];

        int option;

        do {
            System.out.println("1.Add student.");
            System.out.println("2.See all the students.");
            System.out.println("3.Delete student.");
            System.out.println("4.Exit.");
            System.out.print("Write here : ");
            option = scan.nextInt();

            switch(option)
            {
                case 1 :

                    if(a <= number)
                    {
                        System.out.print("First name : ");
                        String fName = scan.next();
                        System.out.print("Last name : ");
                        String lName = scan.next();
                        System.out.print("Age : ");
                        int age = scan.nextInt();
                        Stud[a] = new Student(fName, lName, age);

                        a++;

                        break;
                    }
                    else
                    {
                        System.out.println("Too many students");
                        break;
                    }

                case 2 :

                    if(a > 1)
                    {
                        for(int i = 1 ; i < a ; i++)
                        {
                            System.out.println(i+"." + Stud[i].getfName() + " " + Stud[i].getlName() + " " + Stud[i].getAge());
                        }
                        break;
                    }
                    else
                    {
                        System.out.println("No students.");
                        break;
                    }

                case 3 :

                    if(a > 1)
                    {
                        for(int i = 1 ; i < a ; i++)
                        {
                            System.out.println(i+"." + Stud[i].getfName() + " " + Stud[i].getlName() + " " + Stud[i].getAge());
                        }

                        System.out.println("What student do you want to delete?");
                        System.out.print("Write here : ");
                        x = scan.nextInt();

                        Stud[x].setAge(0);
                        Stud[x].setfName(" ");
                        Stud[x].setlName(" ");

                        for(int i = 1 ; i < a; i ++)
                        {
                            for(int j = i+1 ;j < a ; j++ )
                            {
                                if(Stud[i].getAge() == 0 && Stud[i].getfName() == " " && Stud[i].getlName() == " ")
                                {
                                    swap(Stud[i], Stud[j]);
                                }
                            }
                        }
                        Stud[a-1] = null;
                        a--;


                        break;
                    }
                    else
                    {
                        System.out.println("You have no students to delete");
                        break;
                    }


                case 4 :

                    break;

                default :

                    System.out.println("This option doesn't exist");

            }

                for(int i = 1 ; i < a; i++)
                {
                    for(int j = i + 1 ; j < a ; j++)
                    {
                        if(Stud[i].getfName().contentEquals(Stud[j].getfName()))
                        {
                            for(int k = 0 ; k < Stud[i].getlName().length() ; k++)
                            {
                                if(Stud[i].getlName().charAt(k) > Stud[j].getlName().charAt(k))
                                {
                                    swap(Stud[i], Stud[j]);
                                    break;
                                }
                                else if (Stud[i].getlName().charAt(k) < Stud[j].getlName().charAt(k)) break;
                            }
                        }
                        else if(!Stud[i].getfName().contentEquals(Stud[j].getfName()))
                        {
                            for(int k = 0 ; k < Stud[i].getfName().length() ; k++)
                            {
                                if(Stud[i].getfName().charAt(k) > Stud[j].getfName().charAt(k))
                                {
                                    swap(Stud[i], Stud[j]);
                                    break;
                                }
                                else if(Stud[i].getfName().charAt(k) < Stud[j].getfName().charAt(k)) break;
                            }
                        }
                    }
                }



        }while(option != 4);


    }
}
