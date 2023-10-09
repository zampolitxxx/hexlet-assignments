package exercise;

import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

// BEGIN
public class App {
    public static void main(String[] args) {
        List<Home> apartments = new ArrayList<>(List.of(
                new Flat(41, 3, 10),
                new Cottage(125.5, 2),
                new Flat(80, 10, 2),
                new Cottage(150, 3)
        ));

        List<String> result = App.buildApartmentsList(apartments, 3);
        System.out.println(result);
    }

    public static List<String> buildApartmentsList(List<Home> list, int numbers) {
        List<String> sortedList = list.stream()
                .sorted(Comparator.comparingDouble(Home::getArea))
                .map(String::valueOf)
                .collect(Collectors.toList());
        List<String> result = new ArrayList<>();
        if (numbers > sortedList.size()) {
            return sortedList;
        }
        for (int i = 0; i < numbers; i++) {
            result.add(sortedList.get(i));
        }
        return result;
    }

}
// END
