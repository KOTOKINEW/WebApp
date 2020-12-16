package by.kotoki.webapp.dao;

import by.kotoki.webapp.models.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class PersonDAO {
    private static int PEOPLE_COUNT = 0;
    private List<Person> people;

    {
        people = new ArrayList<>();

        people.add(new Person(++PEOPLE_COUNT, "Jhonny"));
        people.add(new Person(++PEOPLE_COUNT, "Ember"));
        people.add(new Person(++PEOPLE_COUNT, "Tony"));
        people.add(new Person(++PEOPLE_COUNT, "Gerold"));
        people.add(new Person(++PEOPLE_COUNT, "Kid"));
        people.add(new Person(++PEOPLE_COUNT, "Edvard"));
        people.add(new Person(++PEOPLE_COUNT, "Leo"));
    }
    public List<Person> index(){
        return people;
    }

    public Person show(int id){
        return people.stream().filter(person ->person.getId() == id).findAny().orElse(null);
    }

    public void save(Person person){
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }

    public void update(int id, Person updatedPerson){
        Person personToBeUpdated = show(id);
        personToBeUpdated.setName(updatedPerson.getName());
    }

    public void delete(int id){
        people.removeIf(p->p.getId() == id);
    }
}
