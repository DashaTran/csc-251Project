import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class PolicyDemo
{   
        public static void main(String[] args)
        {
                //declare variables

                ArrayList<Policy> policyList=new ArrayList<Policy>();

                //The demo program should display the number of Policyholders that are smokers and the number of Policyholders that are non-smokers.

                String policyNumber;
                String providerName;
                String firstName;
                String lastName;
                int age;
                String smokingStatus;
                double height;
                double weight;
                Scanner file;
                try {
                        file = new Scanner(new File("PolicyInformation.txt"));
                        while(file.hasNext())
                        {
                                policyNumber=file.nextLine();
                                providerName=file.nextLine();
                                firstName=file.nextLine();
                                lastName=file.nextLine();
                                age=Integer.parseInt(file.nextLine());
                                smokingStatus=file.nextLine();
                                height=Double.parseDouble(file.nextLine());
                                weight=Double.parseDouble(file.nextLine());
                                if(file.hasNext())
                                {
                                file.nextLine();
                                }
                                //create a Policy object
                                Policy policy = new Policy(policyNumber, providerName, firstName, lastName, age, smokingStatus, height, weight);
                                policyList.add(policy);
                        }


                        System.out.println("Policy Information:\n");
                        for(Policy policy:policyList)
                        {

                                //display information about the Policy
                                System.out.println("Policy Number: " + policy.getPolicyNumber());
                                System.out.println("Provider Name: " + policy.getProviderName());
                                System.out.println("Policyholder's First Name: " + policy.getFirstName());
                                System.out.println("Policyholder's Last Name: " + policy.getLastName());
                                System.out.println("Policyholder's Age: " + policy.getAge());
                                System.out.println("Policyholder's Smoking Status: " + policy.getSmokingStatus());
                                System.out.println("Policyholder's Height: " + policy.getHeight() + " inches");
                                System.out.println("Policyholder's Weight: " + policy.getWeight() + " pounds");
                                System.out.printf("Policyholder's BMI: %.2f\n", policy.getBMI());
                                System.out.println();
                        }
                } catch (FileNotFoundException e) {
                        System.out.println("File not found!");
                }

                }
                
        }
