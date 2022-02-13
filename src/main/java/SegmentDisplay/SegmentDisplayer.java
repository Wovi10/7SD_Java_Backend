package SegmentDisplay;

import java.util.Arrays;
import java.util.List;

public class SegmentDisplayer {
    static SD_Dictionary dictionary = new SD_Dictionary();

    protected SegmentDisplayer() {
        addNumbers();
    }

    private void addNumbers() {
        List<String> zero = Arrays.asList("A", "B", "C", "E", "F", "G");
        List<String> one = Arrays.asList("C", "F");
        List<String> two = Arrays.asList("A", "C", "D", "E", "G");
        List<String> three = Arrays.asList("A", "C", "D", "F", "G");
        List<String> four = Arrays.asList("B", "C", "D", "F");
        List<String> five = Arrays.asList("A", "B", "D", "F", "G");
        List<String> six = Arrays.asList("A", "B", "D", "E", "F", "G");
        List<String> seven = Arrays.asList("A", "C", "F");
        List<String> eight = Arrays.asList("A", "B", "C", "D", "E", "F", "G");
        List<String> nine = Arrays.asList("A", "B", "C", "D", "F", "G");
        addValueToShow(zero, 0);
        addValueToShow(one, 1);
        addValueToShow(two, 2);
        addValueToShow(three, 3);
        addValueToShow(four, 4);
        addValueToShow(five, 5);
        addValueToShow(six, 6);
        addValueToShow(seven, 7);
        addValueToShow(eight, 8);
        addValueToShow(nine, 9);
    }

    private void addValueToShow(List<String> nameList, Integer valueToShow) {
        dictionary.addValueToShow(nameList, valueToShow);
    }

    protected List<String> getSegmentsUsed(Integer neededNumber) {
        return dictionary.getSegmentsUsed(neededNumber);
    }

    protected String displaySegments(Integer neededNumber) {
        StringBuilder stringBuilder = new StringBuilder();
        List<String> segmentsToBeLit = getSegmentsUsed(neededNumber);
        buildString(segmentsToBeLit, stringBuilder);
        return stringBuilder.toString();
    }

    private void buildString(List<String> segmentsToBeLit, StringBuilder stringBuilder) {
        String previous = "";
        for (String segment : segmentsToBeLit) {
            if ((previous.equals("A") && segment.equals("C")) || (previous.equals("D") && segment.equals("F"))) {
//                System.out.print(" ");
                stringBuilder.append(" ");
            }
            if ((previous.equals("E") && segment.equals("G")) || (previous.equals("B") && segment.equals("D")))
                stringBuilder.append("\n");
            switch (segment) {
                case "A":
                case "D":
                case "G":
//                    System.out.println(" - ");
                    stringBuilder.append(" - \n");
                    break;
                case "B":
                case "E":
//                    System.out.print("|");
                    stringBuilder.append("|");
                    break;
                case "C":
                case "F":
//                    System.out.println(" |");
                    stringBuilder.append(" |\n");
                    break;
            }
            previous = segment;
        }
    }
}
