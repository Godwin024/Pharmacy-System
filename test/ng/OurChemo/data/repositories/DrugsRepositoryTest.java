package ng.OurChemo.data.repositories;

import ng.OurChemo.data.models.Drug;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DrugsRepositoryTest {

    private DrugRepository repository;
    @BeforeEach
    void setUp(){
        repository = new DrugRepositoryImpl();
    }

    @Test
    public void testThatRepositoryIsEmpty(){
            assertEquals(0, repository.count());
    }

    @Test
    public void testThatSaveOneDrugIncreasesCountByOne(){
        Drug drug = new Drug();
        repository.save(drug);
        assertEquals(1, repository.count());
    }

    @Test
    public void testThatSavingTwoDrugs_IncreasesCountToTwo(){

        Drug drug1 = new Drug();
        Drug drug2 = new Drug();
        repository.save(drug1);
        repository.save(drug2);
        assertEquals(2, repository.count());

    }

    @Test
    public void testThatRepository_CanFindDrugById(){

        Drug drug = new Drug();
        drug.setId(1);
        repository.save(drug);
        Drug foundDrug = repository.findById(1);
        assertEquals(1, foundDrug.getId());
    }

    @Test
    public void testThatRepository_CanDeleteDrugById(){

        Drug drug = new Drug();
        drug.setId(1);
        repository.save(drug);
        assertEquals(1, repository.count());
        repository.deleteById(1);
        assertEquals(0, repository.count());
    }

    @Test
    public  void testThatRepository_CanFindAllDrugs(){

        Drug drug1 = new Drug();
        drug1.setId(1);
        Drug drug2 = new Drug();
        drug2.setId(2);
        repository.save(drug1);
        repository.save(drug2);
        List<Drug> drugs = repository.findAll();
        assertEquals(2, drugs.size());
    }

    @Test
    public  void testThatRepository_CanUpdateDrugPrice(){

        Drug drug = new Drug();
        drug.setId(1);
        drug.setPrice(500);
        repository.save(drug);
        repository.updatePrice(1, 700);
        Drug updatedDrug = repository.findById(1);
        assertEquals(700, updatedDrug.getPrice());
    }
}