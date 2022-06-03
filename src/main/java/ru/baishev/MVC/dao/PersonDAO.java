package ru.baishev.MVC.dao;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import ru.baishev.MVC.models.Person;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
        private List<Person> people;
        private static int PEOPLECOUNT;

    {
        people = new ArrayList<>();
        people.add(new Person(++PEOPLECOUNT,"Vano", 23, "asdfsd@sdgsd.ru"));
        people.add(new Person(++PEOPLECOUNT,"Masha", 56, "aaaa@bbbb.com"));
        people.add(new Person(++PEOPLECOUNT,"Dasha", 23, "sd@ppdpdp.ru"));
        people.add(new Person(++PEOPLECOUNT,"Kostya", 98, "dsfs@sfsd.ff"));
    }

    public List<Person> index(){
        return people;
    }

    public Person show(int id){
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }

    public void save(Person person){
        person.setId(++PEOPLECOUNT);
        people.add(person);
    }

    public void update(int id, Person person){
        Person personToBeUpdated = show(id);
        personToBeUpdated.setName(person.getName());
        personToBeUpdated.setAge(person.getAge());
        personToBeUpdated.setEmail(person.getEmail());
    }

    public void delete(int id){
        people.removeIf(p -> p.getId() == id);
    }
}
