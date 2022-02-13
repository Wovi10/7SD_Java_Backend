package SegmentDisplay;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SD_Dictionary {
    private static Map<String, Integer> dictionary = new HashMap<>();

    protected SD_Dictionary() {
        setDefaultPairs();
    }

    private void setDefaultPairs(){
        addKeyValuePair("A");
        addKeyValuePair("B");
        addKeyValuePair("C");
        addKeyValuePair("D");
        addKeyValuePair("E");
        addKeyValuePair("F");
        addKeyValuePair("G");
    }

    private void addKeyValuePair(String nameToAdd){
        if (!dictionary.containsKey(nameToAdd))
            dictionary.put(nameToAdd, 0);
    }

    protected Integer getValue(String Name){
        return dictionary.get(Name);
    }

    protected void addValueToShow(List<String> stringList, Integer valueToShow) {
        for (String name : stringList) {
            if (!nameInDictionary(name))
                addKeyValuePair(name);
            Integer valueToAdd = bitShiftLeft(valueToShow);
            addValueToPair(name, valueToAdd);
        }
    }

    private void addValueToPair(String name, Integer valueToAdd){
        dictionary.put(name, dictionary.get(name) + valueToAdd);
    }

    private Integer bitShiftLeft(Integer placesToShift) {
        return 1 << placesToShift;
    }

    private boolean nameInDictionary(String nameToCheck){
        return getValue(nameToCheck) != null;
    }

    protected List<String> getSegmentsUsed(Integer neededNumber) {
        List<String> segmentsToBeLit = new ArrayList<>();
        for (String segment : dictionary.keySet()) {
            Integer value = dictionary.get(segment);
            value = bitShiftRight(value, neededNumber);

            if ((value % 2) > 0){
                segmentsToBeLit.add(segment);
            }
        }
        return segmentsToBeLit;
    }

    private Integer bitShiftRight(Integer valueToShift, Integer placesToShift) {
        return valueToShift >> placesToShift;
    }

}
