package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        File file = new File("C:\\Users\\Slipeer\\Desktop\\Задача ВС Java Сбер.csv");
        List<City> cities = new ArrayList<>();
        try(Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                String[] stringCityFromFile = scanner.nextLine().split(";");
                City city = new City();
                List<String> cityResult = IntStream.range(0, 6)
                        .mapToObj(e-> stringCityFromFile.length > e ? stringCityFromFile[e] : "")
                        .collect(Collectors.toList());
                city.setId(Integer.parseInt(cityResult.get(0)));
                city.setName(cityResult.get(1));
                city.setRegion(cityResult.get(2));
                city.setDistrict(cityResult.get(3));
                city.setPopulation(Integer.parseInt(cityResult.get(4)));
                city.setFoundation(cityResult.get(5));
                cities.add(city);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Map<String, List<City>> groupingRegion = cities.stream().collect(Collectors.groupingBy(City::getRegion));
        Map<String, Integer> countRegion = groupingRegion.keySet().stream().collect(Collectors.toMap(e->e, e-> groupingRegion.get(e).size()));
        System.out.println(countRegion);

    }
}
