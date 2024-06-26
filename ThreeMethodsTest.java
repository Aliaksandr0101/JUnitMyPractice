import org.junit.Assert;
import org.junit.Test;

public class ThreeMethodsTest {

    @Test
    public void toStringTest() {
        Human human = new Human("Natasha", 23, Human.Gender.FEMALE);
        String s1 = "Human{name='Natasha', age=23, id=1, gender=FEMALE}";
        String s2 = "Human{" +
                "name='" + human.getName() + '\'' +
                ", age=" + human.getAge() +
                ", id=" + human.getId() +
                ", gender=" + human.getGender() +
                '}';
        Assert.assertEquals(s2, s1);
    }

    @Test
    public void equalsTest() {
        Human human1 = new Human("Natasha", 23, Human.Gender.FEMALE);
        Human human2 = new Human("Natasha", 23, Human.Gender.FEMALE);
        Assert.assertEquals(human1.getName(), human2.getName());
        Assert.assertEquals(human1.getAge(), human2.getAge());
        Assert.assertEquals(human1.getGender(), Human.Gender.FEMALE);
        Assert.assertEquals(human1.getId(), human2.getId());
    }

    @Test
    public void hashCodeTest() {
        Human human1 = new Human("Natasha", 23, Human.Gender.FEMALE);
        Human human2 = new Human("Natasha", 23, Human.Gender.FEMALE);
        int privateHashCodeHuman1 = human1.hashCode();
        int privateHashCodeHuman2 = human2.hashCode();
        Assert.assertEquals(privateHashCodeHuman1, privateHashCodeHuman1);
    }
}

