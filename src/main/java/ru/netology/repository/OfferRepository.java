package ru.netology.repository;

import lombok.NoArgsConstructor;
import ru.netology.domain.Offer;

@NoArgsConstructor
public class OfferRepository {
    private Offer[] offers = new Offer[0];

    public void save(Offer item) {
        int length = offers.length + 1;
        Offer[] tmp = new Offer[length];
        System.arraycopy(offers, 0, tmp, 0, offers.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        offers = tmp;
    }

    public Offer[] findAll() {
        return offers;
    }

    public void removeById(int id) {
        int length = offers.length - 1;
        Offer[] tmp = new Offer[length];
        int index = 0;
        for (Offer item : offers) {
            if (item.getId() != id) {
                tmp[index] = item;
                index++;
            }
        }
        offers = tmp;
    }

}
