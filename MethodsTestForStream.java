public class MethodsTestForStream {

   static void enterOnDisplay( Checker ch){

       System.out.println(ch.checkOnNumberOfLetter("Mountain"));
    }

    public static void main(String[] args) {
        enterOnDisplay((String anyString) -> {return anyString.length() < 3;});
        Checker newChecker = (String newString) -> {return newString.length() > 3;};
        boolean result = newChecker.checkOnNumberOfLetter("Hello");
        System.out.println(result);
    }

}
interface Checker{
    boolean checkOnNumberOfLetter(String newString);
}