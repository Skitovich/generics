package ru.netology.comparator;

import ru.netology.domain.Offer;

import java.util.Comparator;

public class TicketByPriceAscComparator implements Comparator<Offer> {
    @Override
    public int compare(Offer o1, Offer o2) {
        return o1.getFlightTIme() - o2.getFlightTIme();
    }
}
