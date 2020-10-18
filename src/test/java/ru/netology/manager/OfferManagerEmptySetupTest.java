package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Offer;
import ru.netology.repository.OfferRepository;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class OfferManagerEmptySetupTest {

    private Offer offer = new Offer();
    private OfferRepository repository = new OfferRepository();
    private OfferManager manager = new OfferManager(repository);


    @Test
    void getAllNoMatches() {
        Offer[] expected = new Offer[]{};
        Offer[] actual = manager.getAll("SVO", "DME", Comparator.comparing(Offer::getFlightTIme));
        assertArrayEquals(expected, actual);
    }


}