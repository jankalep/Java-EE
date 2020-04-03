package pack;

import org.springframework.stereotype.Component;

@Component
public class Job {
    String address="Minsk, Dziarzynskaha 57";
    String occupation;
    int salary;

    public int getSalary() {
        return salary;
    }

    public String getAddress() {
        return address;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

}
