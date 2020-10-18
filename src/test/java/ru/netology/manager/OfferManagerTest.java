package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Offer;
import ru.netology.repository.OfferRepository;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class OfferManagerTest {

    private final OfferRepository repository = new OfferRepository();
    private final OfferManager manager = new OfferManager(repository);


    private final Offer first = new Offer(1, 100, "SVO", "SIP", 100);
    private final Offer second = new Offer(2, 500, "DME", "KRS", 110);
    private final Offer third = new Offer(3, 400, "KRS", "DME", 120);
    private final Offer forth = new Offer(4, 450, "DME", "KRS", 130);


    @BeforeEach
    public void setUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(forth);
        repository.findAll();
    }

    @Test
    void getAllTwoOfferMatches() {

        Offer[] expected = new Offer[]{second, forth};
        Offer[] actual = manager.getAll("DME", "KRS", Comparator.comparing(Offer::getFlightTIme));

        assertArrayEquals(expected, actual);
    }

    @Test
    void getAllIfNoMatches() {
        Offer[] expected = new Offer[]{};
        Offer[] actual = manager.getAll("VNK", "KRS", Comparator.comparing(Offer::getFlightTIme));
        assertArrayEquals(expected, actual);
    }

    @Test
    void getAllIfOneOfAirportMatches() {
        Offer[] expected = new Offer[]{};
        Offer[] actual = manager.getAll("SVO", "DME", Comparator.comparing(Offer::getFlightTIme));
        assertArrayEquals(expected, actual);
    }

    @Test
    void getAllIfOneOfferMatches() {
        Offer[] expected = new Offer[]{first};
        Offer[] actual = manager.getAll("SVO", "SIP", Comparator.comparing(Offer::getFlightTIme));
        assertArrayEquals(expected, actual);
    }

}