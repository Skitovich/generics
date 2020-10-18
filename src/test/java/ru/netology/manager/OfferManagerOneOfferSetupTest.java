package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Offer;
import ru.netology.repository.OfferRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class OfferManagerOneOfferSetupTest {


    private OfferRepository repository = new OfferRepository();
    private OfferManager manager = new OfferManager(repository);


    @Test
    void getAllIfNoMatches() {

        Offer[] expected = new Offer[]{};
        Offer[] actual = manager.getAll("VNK", "KRS");
        assertArrayEquals(expected, actual);
    }


}



