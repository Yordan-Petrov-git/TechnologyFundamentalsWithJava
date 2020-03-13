    package TextProcessingandRegularExpressions;

    import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;
    import java.util.LinkedList;
    import java.util.List;
    import java.util.regex.Matcher;
    import java.util.regex.Pattern;


    public class Main2 {
        public static BufferedReader reader =
                new BufferedReader(
                        new InputStreamReader(
                                System.in
                        )
                );

        public static void main(String[] args) throws IOException {
    //==============================================================
            //1.	Repeat strings
            // repeatStrings();

            //==============================================================
            // 2.	Substring
            //substring();

            //==============================================================
            //  3. reverseString();
            //reverseString();

            //==============================================================
            //4.	Text Filter

            //==============================================================
            //5.	Digits, Letters and Other

            //==============================================================

            //--------------------------------------------------------
            //  Regular Expressions
            //-----------------------------------------------------------

            //  6.	Match Full Name
            natchFullName();
            //==============================================================
            //7.	Match Phone Number
            //matchPhoneNumber();
            //==============================================================
            //8.	Match Dates
            // matchDates();
            //==============================================================
            // 9.	Match Numbers
    //==============================================================


        }

        private static void natchFullName() throws IOException {
            String input = reader.readLine();
            final String regex = "\\b[A-Z][a-z]{1,} {1}[A-Z][a-z]{1,}\\b";

            final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
            final Matcher matcher = pattern.matcher(input);


            while (matcher.find()){
                System.out.print(matcher.group() + " ");
            }
        }

        private static void matchPhoneNumber() throws IOException {

            String  string = reader.readLine();
            final String regex = "[+359]{4}(\\s|-{1})[2]{1}\\1[0-9]{3}\\1[0-9]{4}\\b";
            final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
            final Matcher matcher = pattern.matcher(string);
            List<String> matchedPhones = new LinkedList<>();
            while (matcher.find()){
                matchedPhones.add(matcher.group());
            }
            System.out.print(
                    String.join(", "
                            ,matchedPhones
                    ));
        }

        private static void reverseString() throws IOException {
            String input = "";
            while (!"end".equals(input)) {

                input = reader.readLine();

                String reverse = "";
                for (int i = input.length() - 1; i >= 0; i--) {
                    reverse += input.charAt(i);
                }

                if (!input.equals("end")) {
                    System.out.println(String.format("%s = %s", input, reverse));
                }

            }

        }

        private static void matchDates() throws IOException {
            String regexInput = reader.readLine();


            final String regex = "(?<day>[0-9]{2})(?<separator>\\/|\\.|\\-)(?<month>[A-z]{1}[a-z]{2})\\2(?<year>[0-9]{4})";
            final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
            final Matcher matcher = pattern.matcher(regexInput);


            while (matcher.find()) {

                String day = matcher.group("day");
                String month = matcher.group("month");
                String year = matcher.group("year");

                System.out.println(
                        String.format("Day: %s, Month: %s, Year: %s"
                                , day
                                , month
                                , year));
            }
        }

        private static void substring() throws IOException {
            String keyWord = reader.readLine();
            String lineSecond = reader.readLine();

            int index = lineSecond.indexOf(keyWord);


            while (index != -1) {
                lineSecond =
                        lineSecond.substring(0, index)
                                + lineSecond.substring(index + keyWord.length());

                index = lineSecond.indexOf(keyWord);
            }
            System.out.println(lineSecond);
        }


        private static void repeatStrings() throws IOException {
            String[] word = (reader.readLine().split("\\s+"));

            StringBuilder sb = new StringBuilder();

            for (String s : word) {
                for (int i = 0; i < s.length(); i++) {
                    sb.append(s);
                }
            }
            System.out.println(sb);
        }
    }
