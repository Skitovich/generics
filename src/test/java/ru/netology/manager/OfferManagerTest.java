package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Offer;
import ru.netology.repository.OfferRepository;
import static org.junit.jupiter.api.Assertions.*;



class OfferManagerTest {

    private Offer offer = new Offer();
    private OfferRepository repository = new OfferRepository();
    private OfferManager manager = new OfferManager(repository);


    private Offer first = new Offer(1,100,"SVO","SIP",120);
    private Offer second = new Offer(2,400,"DME","KRS",120);
    private Offer third = new Offer(3,400,"KRS","DME",120);
    private Offer forth = new Offer (4,350,"DME","KRS",120);


    @BeforeEach
    public void setUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(forth);
        repository.findAll();
    }

    @Test
    void getAll() {

        Offer[] expected = new Offer[]{forth,second};
        Offer[] actual = manager.getAll("DME","KRS");
        assertArrayEquals(expected, actual);
    }
    @Test
    void getAllIfNoMatches() {

        Offer[] expected = new Offer[]{};
        Offer[] actual = manager.getAll("VNK","KRS");
        assertArrayEquals(expected, actual);
    }

    @Test
    void getAllIfOneOfAirportMatches() {

        Offer[] expected = new Offer[]{};
        Offer[] actual = manager.getAll("SVO","DME");
        assertArrayEquals(expected, actual);
    }

    @Test
    void getAllIfOneMatch() {

        Offer[] expected = new Offer[]{first};
        Offer[] actual = manager.getAll("SVO","SIP");
        assertArrayEquals(expected, actual);
    }

}