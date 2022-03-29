import java.util.Scanner;
public class Policy{
    //instance variable
    int policyNumber;
    String policyProvider;
    String firstName;
    String lastName;
    int age;
    boolean smoking;
    double height;
    double weight;


    //Constructor
    Policy(){
        this(0, "", "", "", 0, false, 0, 0);
    }

    Policy(int policyNumber,String policyProvider,String firstName,String lastName,int age,boolean smoking,double height,double weight){
        this.policyNumber = policyNumber;
        this.policyProvider = policyProvider;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age  = age;
        this.smoking = smoking;
        this.height = height;
        this.weight = weight;
    }


    //setters and getters
    public void setPolicyNumber(int policyNumber) {
        this.policyNumber = policyNumber;
    }

    public void setPolicyProvider(String policyProvider) {
        this.policyProvider = policyProvider;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public void setSmoking(boolean smoking) {
        this.smoking = smoking;
    }
    public void setHeight(double height) {
        this.height = height;
    }
    public void setWeight(double weight) {
        this.weight = weight;
    }
    public int getPolicyNumber() {
        return policyNumber;
    }
    public String getPolicyProvider() {
        return policyProvider;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public int getAge() {
        return age;
    }
    public double getHeight() {
        return height;
    }
    public double getWeight() {
        return weight;
    }

    public boolean getSmoking() {
        return smoking;
    }


    //get BMI
    public double getBMI(){
        return (weight * 703) /(height * height);
    }

    //get policy price
    public double policyPrice(){
        double base_price = 600;
        if(age>50){
            base_price +=75;
        }
        if(smoking == true){
            base_price +=100;
        }
        if(getBMI() > 35){
            base_price += (getBMI() - 35) * 20.0;
        }

        return base_price;
    }

    //get details of policy in string form
    public String toString(){
        String output="";
        output +="Policy Number: "+ policyNumber + "\n";
        output +="Provider Name: "+ policyProvider + "\n";
        output +="Policyholder's First Name: "+ firstName + "\n";
        output +="Policyholder's Last Name: "+ lastName + "\n";
        output +="Policyholder's age: "+ age + "\n";
        output +="Smoking Status: "+ (smoking==true?"smoker":"non-smoker") + "\n";
        output +="Policyholder's Height "+ height + "\n";
        output +="Policyholder's Weight "+ weight + "\n";
        output +="Policyholder's BMI "+ getBMI() + "\n";
        output +="Policy price $"+ policyPrice()+ "\n";

        return output;
    }

    public static void main(String[] args) {

        //make scanner object
        Scanner sc = new Scanner(System.in);

        //take user info
        System.out.print("Please enter the Policy Number: ");
        int policyNumber = sc.nextInt();
        System.out.print("Please enter the Provider Name: ");
        sc.nextLine(); //clear buffer
        String policyProvider = sc.nextLine();
        System.out.print("Please enter the Policyholder's First Name: ");
        String firstName = sc.nextLine();
        System.out.print("Please enter the Policyholder's Last Name: ");
        String lastName = sc.nextLine();
        System.out.print("Please enter the Policyholder's age: ");
        int age = sc.nextInt();
        System.out.print("Please enter the Policyholder's Smoking Status(smoker/non-smoker): ");
        sc.nextLine();
        String smoke = sc.nextLine();
        boolean smoker = (smoke.compareTo("smoker")==0)?true:false;
        System.out.print("Please enter the Policyholder's Height(in inches): ");
        double height = sc.nextDouble();
        System.out.print("Please enter the Policyholder's Weight(in inches): ");
        double weight = sc.nextDouble();

        //create policy object
        Policy p = new Policy(policyNumber,policyProvider,firstName,lastName,age,smoker,height,weight);

        //print policy info
        System.out.println(p);
        


    }

}