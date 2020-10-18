package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Offer;
import ru.netology.repository.OfferRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class OfferManagerEmptySetupTest {


    private OfferRepository repository = new OfferRepository();
    private OfferManager manager = new OfferManager(repository);


    private Offer first = new Offer(1, 100, "SVO", "SIP", 120);


    @BeforeEach
    public void setUp() {
        manager.add(first);
    }

    @Test
    void getAllIfNoMatches() {

        Offer[] expected = new Offer[]{};
        Offer[] actual = manager.getAll("VNK", "KRS");
        assertArrayEquals(expected, actual);
    }

    @Test
    void getAllIfOneMatch() {

        Offer[] expected = new Offer[]{first};
        Offer[] actual = manager.getAll("SVO", "SIP");
        assertArrayEquals(expected, actual);
    }

}



