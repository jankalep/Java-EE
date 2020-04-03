package start;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pack.People;

public class Main {

    public static void main(String[] args){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        People man=context.getBean(People.class);
        man.setName("Octavian");
        man.setSurname("August");
        man.setAge(26);
        man.setOccupation("Programmer");
        man.setSalary(3000);
        context.close();

    }
}
