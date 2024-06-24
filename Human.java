import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Human {
    public enum Gender {
        MALE, FEMALE
    }


    private final String name;
    private final int age;
    private final int id;
    private int counterOfHumans = 0;

    private final Gender gender;

    public Human(String name, int age, Gender gender) {
        this.name = name;
        this.age = age;
        this.id = ++counterOfHumans;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getId() {
        return id;
    }

    public Gender getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", id=" + id +
                ", gender=" + gender +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return age == human.age &&
                id == human.id &&
                Objects.equals(name, human.name) &&
                gender == human.gender;
    }

   /* @Override
    public int hashCode() {
        return Objects.hash(id);
    }*/

    @Override
    public int hashCode() {
        return Objects.hash(name, age, id, gender);
    }
}

 class HumanManager{
     private Human human;
     private  List<Human> people = new ArrayList<>();

     public HumanManager() {
     }

     public HumanManager(Human human) {
         this.human = human;
     }
        public int getTotalNumberOfPeople () {
        return people.size();
    }

        public void addHuman (Human human){
        people.add(human);
    }

        public int getNumberByGender (Human.Gender gender){
        return (int) people.stream().filter(human -> human.getGender() == gender).count();
    }
        public int getTotalAge () {
        return people.stream().mapToInt(Human::getAge).sum();
    }
        public int getAgeByGender (Human.Gender gender){
        return people.stream().filter(human -> human.getGender() == gender).mapToInt(Human::getAge).sum();
    }

        public double getTotalAverageAge () {
        return people.isEmpty() ? 0 : (double) getTotalAge() / people.size();
    }

        public double getAverageByGender (Human.Gender gender ){
        int count = getNumberByGender(gender);
        return count == 0 ? 0 : (double) getAgeByGender(gender) / count;
    }
        public List<Human> getUsersByGenderList (Human.Gender gender){
        return people.stream().filter(people -> people.getGender() == gender).collect(Collectors.toList());
    }
    }


class Check {
    public static void main(String[] args) {
        Human human1 = new Human("Sasha", 32, Human.Gender.MALE);
        Human human2 = new Human("Natasha", 23, Human.Gender.FEMALE);
        Human human3 = new Human("Marry", 15, Human.Gender.FEMALE);
        Human human4 = new Human("Petr", 33, Human.Gender.MALE);

        HumanManager humanManager = new HumanManager();
        humanManager.addHuman(human1);
        humanManager.addHuman(human2);
        humanManager.addHuman(human3);
        humanManager.addHuman(human4);

        System.out.println(humanManager.getTotalNumberOfPeople());




    }

}
