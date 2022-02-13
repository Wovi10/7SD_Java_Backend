package SegmentDisplay;

import Exceptions.NoIntegerException;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import static java.lang.Integer.parseInt;

public class FullDisplayer {
    static SegmentDisplayer displayer = new SegmentDisplayer();

    public FullDisplayer() {
    }

    public void showNumber(String numberToShowString){
        try{
            Integer numberToShow = parseInt(numberToShowString);
            List<String> stringList = getNumber(numberToShow);
            printNumbers(stringList);
        }catch(NumberFormatException ignored){
            System.err.println("Only number are allowed");
        }
    }

    private void printNumbers(List<String> stringList) {
        ListIterator<String> listIterator = stringList.listIterator(stringList.size());
        while(listIterator.hasPrevious()){
            System.out.println(listIterator.previous());
        }
    }

    private List<String> getNumber(Integer numberToShow) {
        Integer numberToWorkWith;
        List<String> stringList = new ArrayList<>();

        do {
            numberToWorkWith = numberToShow % 10;
            numberToShow = deleteLastNumber(numberToShow, numberToWorkWith);

            stringList.add(displayer.displaySegments(numberToWorkWith));
        }while(numberToShow > 0);

        return stringList;
    }

    private Integer deleteLastNumber(Integer numberToShow, Integer num) {
        numberToShow -= num;
        numberToShow /= 10;
        return numberToShow;
    }
}
