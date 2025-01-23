package Assignment_3_2;

public class Programmer {
    private int Salary = 1000;

    public Programmer(){

    }
    public int getSalary(int i){
        return Salary;
    }

    public void setSalary(int updtSalary) {
        if(updtSalary > Salary){
            Salary = updtSalary;
        }

    }

    public static void main(String[] args) {
        Programmer programmer = new Programmer();

        System.out.println(programmer.Salary);
        programmer.setSalary(1500);
        System.out.println(programmer.Salary);
        programmer.setSalary(800);
        System.out.println(programmer.Salary);
    }
}
