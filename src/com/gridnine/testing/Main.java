package com.gridnine.testing;

import java.util.ArrayList;
import java.util.List;

public class Main {
            public static void main(String[] args) {
                List<Flight> flights = new ArrayList<>(FlightBuilder.createFlights());

                System.out.println("Список перелётов");
                flights.forEach(System.out::println);
                System.out.println("--------------------------------------");

                Filter filter = new FilterImpl(flights);

                List<Flight> beforeDepartureCurrent = filter.beforeCurrentTime();
                List<Flight> arrivalBeforeDeparture = filter.arrivalBeforeDeparture();
                List<Flight> differentLandTime = filter.differentLandTime();

                System.out.println("Исключены перелёты: вылеты до текущего момента времени");
                beforeDepartureCurrent.forEach(System.out::println);
                System.out.println("--------------------------------------");

                System.out.println("Исключены перелёты: с датой прилёта раньше даты вылета");
                arrivalBeforeDeparture.forEach(System.out::println);
                System.out.println("--------------------------------------");

                System.out.println("Исключены перелёты: общее время на земле превышает 2 часа");
                differentLandTime.forEach(System.out::println);
            }
        }

