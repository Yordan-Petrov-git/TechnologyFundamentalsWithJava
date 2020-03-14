    package TextProcessingRegExExercise;

    import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;
    import java.util.Map;

    public class Main3 {
        public static BufferedReader reader =
                new BufferedReader(
                        new InputStreamReader(
                                System.in
                        )
                );

        public static void main(String[] args) throws IOException {

    //=======================================================
           // 1.	Valid Usernames
           // validateUsers();
            //=======================================================
//2.	Character Multiplier
//            String text = reader.readLine();
//            String  firstWord = text.substring(0,text.indexOf(' '));
//            String  secondWord = text.substring(text.lastIndexOf(' ')+1);
//            System.out.println(multiplyChars(firstWord, secondWord));
            //=======================================================
           // 3.	Extract File
            //=======================================================

            //=======================================================

            //=======================================================

            //=======================================================

            //=======================================================

            //=======================================================

            //=======================================================

            //=======================================================

            //=======================================================

            //=======================================================

            //=======================================================

            //=======================================================



        }

        private static int multiplyChars(String first , String second){

                int minLength = Math.min(first.length(),second.length());

                int sum = 0;

            for (int i = 0; i <minLength ; i++) {
                sum += first.charAt(i) * second.charAt(i);
            }


            String maxLength = first.length() < second.length() ? second : first;

            for (int i = minLength; i <maxLength.length() ; i++) {
                sum += maxLength.charAt(i);
            }
            return sum;
        }

        private static void validateUsers() throws IOException {
            String[] input = reader.readLine().split(", ");

            for (String s : input) {
                if (validatorNameLength(s)&&validatorNameContent(s)){
                    System.out.println(s);
                }
            }
        }

        public static boolean validatorNameLength(String nameCheck) {
            int minRange = 3;
            int maxRange = 16;
            if (nameCheck.length() < minRange || nameCheck.length() > maxRange) {
                return false;
            }
            return true;
        }

        public static boolean validatorNameContent(String nameCheck) {

            String validate = "_-";

            for (int i = 0; i < nameCheck.length(); i++) {

                if (!Character.isLetterOrDigit(nameCheck.charAt(i))
                        && nameCheck.charAt(i) != '-'
                        && nameCheck.charAt(i) != '_') {

                    return false;
                }
            }
            return true;
        }

    }
