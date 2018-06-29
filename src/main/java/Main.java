import com.google.gson.Gson;

public class Main {
    public static void main(String[] args) {

        Person person1 = new Person();
        person1.setFirstName("Jarek");
        person1.setLastName("Browarek");
        person1.setAge(18);
        person1.setHeight(177);
        person1.setHobby(new String[] {"Java", "Tennis", "Swimming"});

        System.out.println(person1);

        Gson gson = new Gson();
        String json = gson.toJson(person1);

        System.out.println(json);

        Person person2 = gson.fromJson(json, Person.class);

        System.out.println("------------------");
        System.out.println(person2);

    }
}
