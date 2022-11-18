import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        List<List<String>> listOfLines = new ArrayList<>();
        File file = new File("C:\\Users\\Alexandra\\OneDrive\\Desktop\\3rd year\\Semester 1\\Formal Languages and Compiler Design\\rules.txt");    //creates a new file instance
        FileReader fr = new FileReader(file);   //reads the file
        BufferedReader br = new BufferedReader(fr);  //creates a buffering character input stream
        StringBuffer sb = new StringBuffer();    //constructs a string buffer with no characters
        String line;
        while ((line = br.readLine()) != null) {
            String[] splited = line.split(",");
            List<String> eachLine = new ArrayList<>();
            for (String s : splited) {
                eachLine.add(s);
            }
            listOfLines.add(eachLine);
            //System.out.println(eachLine);
        }

        String finalStates = "Final states: ";
        List<String> statesList = new ArrayList<>();
        List<String> alphabetList = new ArrayList<>();
        System.out.println("Transitions : ");


        for (List<String> elem : listOfLines) {
            for (String s : elem) {
                if (s.equals("final"))
                    finalStates = finalStates + " " + elem.get(0);
            }

            if (!statesList.contains(elem.get(0))) {
                statesList.add(elem.get(0));
            }
            if (!statesList.contains(elem.get(elem.size() - 1)) && statesList.size() >= 3) {
                statesList.add(elem.get(elem.size() - 1));
            }

            if (!alphabetList.contains(elem.get(1)) && elem.size() >= 3) {
                alphabetList.add(elem.get(1));
            }

            String transitions = "Transition ";

            if (elem.size() >= 3) {
                System.out.println(" ( " + elem.get(0) + " , " + elem.get(1) + " ) " + " = " + elem.get(2));
            }


        }
        System.out.println();
        String states = "States: ";
        for (String i : statesList)
            states = states + " " + i;
        System.out.println(states);

        System.out.println();

        System.out.println(finalStates);

        System.out.println();

        String alphabet = "Alphabet: ";
        for (String h : alphabetList)
            alphabet = alphabet + " " + h;
        System.out.println(alphabet);

    }
}
