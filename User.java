
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

class User {
    private static int counter = 0;
    private final int id;
    private final String name;
    private final int age;
    private final Gender gender;

    public User(String name, int age, Gender gender) {
        this.id = ++counter;
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Gender getGender() {
        return gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                '}';
    }

    public enum Gender {
        MALE, FEMALE
    }
}

class UserManager {
    private final List<User> users = new ArrayList<>();

    public void addUser(String name, int age, User.Gender gender) {
        User user = new User(name, age, gender);
        users.add(user);
    }

    public int getTotalUsers() {
        return users.size();
    }

    public int getUsersByGender(User.Gender gender) {
        return (int) users.stream().filter(user -> user.getGender() == gender).count();
    }

    public int getTotalAge() {
        return users.stream().mapToInt(User::getAge).sum();
    }

    public int getTotalAgeByGender(User.Gender gender) {
        return users.stream().filter(user -> user.getGender() == gender).mapToInt(User::getAge).sum();
    }

    public double getAverageAge() {
        return users.isEmpty() ? 0 : (double) getTotalAge() / users.size();
    }

    public double getAverageAgeByGender(User.Gender gender) {
        int count = getUsersByGender(gender);
        return count == 0 ? 0 : (double) getTotalAgeByGender(gender) / count;
    }

    public List<User> getUsersByGenderList(User.Gender gender) {
        return users.stream().filter(user -> user.getGender() == gender).collect(Collectors.toList());
    }
}

// Пример использования
class Main {
    public static void main(String[] args) {
        UserManager userManager = new UserManager();
        userManager.addUser("Alice", 25, User.Gender.FEMALE);
        userManager.addUser("Bob", 30, User.Gender.MALE);
        userManager.addUser("Charlie", 35, User.Gender.MALE);

        System.out.println("Total users: " + userManager.getTotalUsers());
        System.out.println("Total male users: " + userManager.getUsersByGender(User.Gender.MALE));
        System.out.println("Total female users: " + userManager.getUsersByGender(User.Gender.FEMALE));

        System.out.println("Total age of all users: " + userManager.getTotalAge());
        System.out.println("Total age of male users: " + userManager.getTotalAgeByGender(User.Gender.MALE));
        System.out.println("Total age of female users: " + userManager.getTotalAgeByGender(User.Gender.FEMALE));

        System.out.println("Average age of all users: " + userManager.getAverageAge());
        System.out.println("Average age of male users: " + userManager.getAverageAgeByGender(User.Gender.MALE));
        System.out.println("Average age of female users: " + userManager.getAverageAgeByGender(User.Gender.FEMALE));

        System.out.println("List of male users: " + userManager.getUsersByGenderList(User.Gender.MALE));
        System.out.println("List of female users: " + userManager.getUsersByGenderList(User.Gender.FEMALE));
    }
}


