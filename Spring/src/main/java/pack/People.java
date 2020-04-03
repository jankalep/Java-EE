package pack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class People {
    int age;
    String name;
    String surname;
    Job job;

    @PostConstruct
    public void init(){
        System.out.println(" Somebody exists!!!");
    }

    public void setOccupation(String s){
        job.setOccupation(s);
    }

    public void setSalary(int s){
        job.setSalary(s);
    }

    @PreDestroy
    public void destroy() {
        System.out.println(" Destroy method was called. Show all:");
        System.out.println(getName()+" "+getSurname());
        System.out.println(getAge());
        System.out.println(job.getAddress()+" "+job.getOccupation()+" "+job.getSalary());
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Autowired
    @Required
    public void setJob(Job job) {
        this.job = job;
    }

    public Job getJob() {
        return job;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
