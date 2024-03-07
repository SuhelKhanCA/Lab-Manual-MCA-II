// package Week11;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class DataProcessor<T> { // Q2
    private List<T> elements;
    private List<T> arrayList;
    private Map<String, T> hashMap;

    public DataProcessor() {
        elements = new ArrayList<>();
        arrayList = new ArrayList<>();
        hashMap = new HashMap<>();
    }

    public void addElement(T element) {
        elements.add(element);
    }

    public void removeElement(T element) {
        elements.remove(element);
    }

    public void displayElements() {
        System.out.println("Elements in the collection:");
        for (T element : elements) {
            System.out.println(element);
        }
    }

    public void addElementToList(T element) {
        arrayList.add(element);
    }

    public void removeElementFromList(T element) {
        arrayList.remove(element);
    }

    public void displayListElements() {
        System.out.println("Elements in the ArrayList:");
        for (T element : arrayList) {
            System.out.println(element);
        }
    }

    public void addElementToHashMap(String key, T element) {
        hashMap.put(key, element);
    }

    public void removeElementFromHashMap(String key) {
        hashMap.remove(key);
    }

    public T getElementFromHashMap(String key) {
        return hashMap.get(key);
    }

    public void combineWithExistingCollection(List<? extends T> otherElements) {
        elements.addAll(otherElements);
    }
}
public class Q2{
    public static void main(String[] args) {
        // Example usage
        DataProcessor<Integer> intProcessor = new DataProcessor<>();
        intProcessor.addElement(10);
        intProcessor.addElement(20);
        intProcessor.displayElements();

        DataProcessor<String> stringProcessor = new DataProcessor<>();
        stringProcessor.addElement("Hello");
        stringProcessor.addElement("World");
        stringProcessor.displayElements();

        // Add elements to ArrayList
        intProcessor.addElementToList(30);
        intProcessor.addElementToList(40);
        intProcessor.displayListElements();

        // Add elements to HashMap
        stringProcessor.addElementToHashMap("key1", "Value1");
        stringProcessor.addElementToHashMap("key2", "Value2");
        System.out.println("Value for key1: " + stringProcessor.getElementFromHashMap("key1"));
    }
}
