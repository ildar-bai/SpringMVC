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
        people.add(new Person(++PEOPLECOUNT,"Vano"));
        people.add(new Person(++PEOPLECOUNT,"Masha"));
        people.add(new Person(++PEOPLECOUNT,"Dasha"));
        people.add(new Person(++PEOPLECOUNT,"Kostya"));
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
    }

    public void delete(int id){
        people.removeIf(p -> p.getId() == id);
    }
}
