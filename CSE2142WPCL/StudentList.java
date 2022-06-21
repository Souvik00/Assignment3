import java.io.*;
import java.text.*;
import java.util.*;

public class StudentList {

    public static void main(String[] args) {
        if(args.length!=1){
            System.out.println(Constant.errorMsg);
            return;
        }
//		Check arguments
        if (args[0].equals(Constant.allCommand)) {
            System.out.println(Constant.loadingMessage);
            try {
                BufferedReader bufferedReader = getReader();
                String line = bufferedReader.readLine();
                String[] names = line.split(Constant.comma);
                for (String name : names) {
                    System.out.println(name.trim());
                }
            } catch (Exception e) {
            }
            System.out.println(Constant.loadedMessage);
        }
        else if (args[0].equals(Constant.randomCommand)) {
            System.out.println(Constant.loadingMessage);
            try {
                BufferedReader bufferedReader = getReader();
                String line = bufferedReader.readLine();
                String[] names = line.split(Constant.comma);

                int randomIndex = (int) ((Math.random() * ((names.length-1) - 0)));
                System.out.println(names[randomIndex].trim());
            } catch (Exception e) {
            }
            System.out.println(Constant.loadedMessage);
        } else if (args[0].contains(Constant.plusCommand)) {
            System.out.println(Constant.loadingMessage);
            try {
                BufferedWriter bufferedReader = getBufferedWriter();
                String subStringToAdd = args[0].substring(1);
                Date date = new Date();
                String timeFormat = Constant.dateformat;
                DateFormat dateFormat = new SimpleDateFormat(timeFormat);
                String formatedDate = dateFormat.format(date);
                bufferedReader.write(", " + subStringToAdd + Constant.dateUpdate + formatedDate);
                bufferedReader.close();
            } catch (Exception e) {
            }

            System.out.println(Constant.loadedMessage);
        }
        else if (args[0].contains(Constant.findCommand)) {
            System.out.println(Constant.loadingMessage);
            try {
                BufferedReader bufferedReader = getReader();

                String line = bufferedReader.readLine();
                String[] names = line.split(Constant.comma);
                boolean done = false;
                String subStringToAdd = args[0].substring(1);
                for (int id = 0; id < names.length && !done; id++) {
                    if (names[id].trim().equals(subStringToAdd)) {
                        System.out.println(Constant.foundMessage);
                        done = true;
                    }
                }
            } catch (Exception e) {
            }
            System.out.println(Constant.loadedMessage);
        }
        else if (args[0].contains(Constant.wordCountCommand)) {
            System.out.println(Constant.loadingMessage);
            try {
                BufferedReader bufferedReader = getReader();
                String line = bufferedReader.readLine();
                char[] alphabates = line.toCharArray();
                int count = 0;
                for (char space : alphabates) {
                    if (space == Constant.space) {
                        count++;
                    }
                }
                System.out.println(count+1 + Constant.totalWordForndMessage);
            } catch (Exception e) {
            }
            System.out.println(Constant.loadedMessage);
        }
        else {
            System.out.println(Constant.errorMsg);
            return;
        }
    }

    private static BufferedReader getReader() throws FileNotFoundException {
        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(Constant.studentList)));
        return bufferedReader;
    }

    private static BufferedWriter getBufferedWriter() throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(
                new FileWriter(Constant.studentList, true));
        return bufferedWriter;
    }

}
