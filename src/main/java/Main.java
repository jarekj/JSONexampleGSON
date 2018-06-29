import com.google.gson.Gson;

public class Main {
    public static void main(String[] args) {

        Person person1 = new Person("Jarek", "Browarek", 18, 196, new String[] {"Python", "Soccer", "Karate"});
        Person person11 = new Person("Jurek", "Baćko", 11, 145, new String[] {"Python", "Soccer", "Karate"});

        System.out.println(person1);
        System.out.println(person11);

        Gson gson = new Gson();
        String json = gson.toJson(person1);

        System.out.println(json);

        Person person2 = gson.fromJson(json, Person.class);

        System.out.println("------------------");
        System.out.println(person2);



    }
}
