package ng.OurChemo.data.repositories;

import ng.OurChemo.data.models.Drug;

import java.util.List;

public interface DrugRepository {
    int count();

    void save(Drug drug);

    Drug findById(int id);

    void deleteById(int id);

    List<Drug> findAll();

    void updatePrice(int id, int newPrice);
}
