public class MethodsTestForStream {

   static void enterOnDisplay( Checker ch){

       System.out.println(ch.checkOnNumberOfLetter("Mountain"));
    }

    public static void main(String[] args) {
        enterOnDisplay((String anyString) -> {return anyString.length() < 3;});
        Checker newChecker =  newString -> newString.length() < 1;
        boolean result = newChecker.checkOnNumberOfLetter("Hello");
        System.out.println(result);
    }

}
interface Checker{
    boolean checkOnNumberOfLetter(String newString);
}