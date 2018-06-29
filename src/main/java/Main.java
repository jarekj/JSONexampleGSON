import com.google.gson.Gson;

public class Main {
    public static void main(String[] args) {

        Person person1 = new Person("Jarek", "Browarek", 18, 196, new String[] {"Python", "Soccer", "Karate"});
        Person person11 = new Person("Jurek", "Baćko", 11, 145, new String[] {"Python", "Soccer", "Karate"});

        System.out.println(person1);
        System.out.println(person11);

        Gson gson = new Gson();
        String json1 = gson.toJson(person1);

        System.out.println(json1);

        Person person2 = gson.fromJson(json1, Person.class);

        System.out.println("------------------");
        System.out.println(person2);

        Gson gson2 = new Gson();
        GenericBox<Person> pBox1 = new GenericBox<Person>(person1);
        System.out.println(pBox1);
        String json2 = gson2.toJson(pBox1);

        GenericBox<Person> pBox2 = gson2.fromJson(json2, pBox1.getClass());





    }
}
