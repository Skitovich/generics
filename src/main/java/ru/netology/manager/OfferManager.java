package ru.netology.manager;

import ru.netology.domain.Offer;
import ru.netology.repository.OfferRepository;

import java.util.Arrays;

public class OfferManager {


    private OfferRepository repository;

    public OfferManager(OfferRepository repository) {
        this.repository = repository;
    }

    public void add(Offer item) {
        repository.save(item);
    }


    public void removeById(int id) {
        repository.removeById(id);
    }

    public Offer[] getAll(String from, String to) {
        Offer[] result = new Offer[0];
        for (Offer product : repository.findAll()) {
            if (product.getTo().equals(to) & product.getFrom().equals(from)) {
                Offer[] tmp = new Offer[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = product;
                result = tmp;
            }
        }
        Arrays.sort(result);
        return result;
    }
}
