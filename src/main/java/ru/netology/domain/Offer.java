package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Offer implements Comparable<Offer>{
    private int id;
    private int price;
    private String from;
    private String to;
    private int flightTIme;


    @Override
    public int compareTo(Offer o) {
        return price - o.price;
    }


}
