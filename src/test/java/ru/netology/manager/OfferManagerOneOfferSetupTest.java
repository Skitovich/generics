package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Offer;
import ru.netology.repository.OfferRepository;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class OfferManagerOneOfferSetupTest {

    private Offer offer = new Offer();
    private OfferRepository repository = new OfferRepository();
    private OfferManager manager = new OfferManager(repository);


    private Offer first = new Offer(1, 100, "SVO", "SIP", 100);


    @BeforeEach
    public void setUp() {
        manager.add(first);
    }


    @Test
    void getAllIfOneMatch() {

        Offer[] expected = new Offer[]{first};
        Offer[] actual = manager.getAll("SVO", "SIP", Comparator.comparing(Offer::getFlightTIme));
        assertArrayEquals(expected, actual);
    }

}