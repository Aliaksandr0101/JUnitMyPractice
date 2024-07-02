public class MethodsTestForStream {

   static void enterOnDisplay( Checker ch){

       System.out.println(ch.checkOnNumberOfLetter("Mountain"));
    }

    public static void main(String[] args) {
        enterOnDisplay((String anyString) -> {return anyString.length() < 3;});
        Checker newChecker = (String anyString2) -> {return anyString2.length() > 3;};
    }

}
interface Checker{
    boolean checkOnNumberOfLetter(String newString);
}