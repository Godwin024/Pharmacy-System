package ng.OurChemo.data.repositories;

import ng.OurChemo.data.models.Drug;

import java.util.ArrayList;
import java.util.List;

public class DrugRepositoryImpl implements DrugRepository {

    private List<Drug> drugs = new ArrayList<>();

    @Override
    public int count() {
        return drugs.size();
    }

    @Override
    public void save(Drug drug) {
        drugs.add(drug);

    }

    @Override
    public  Drug findById(int id){
        for (Drug drug : drugs){
            if (drug.getId() == id){
                return drug;
            }
        }
        return  null;
    }
    
    @Override
    public void deleteById(int id){
        for (int count = 0; count < drugs.size(); count++){
            if(drugs.get(count).getId() == id){
                drugs.remove(count);
                break;
            }
        }
        
    }

    @Override
    public List<Drug> findAll(){
        return drugs;
    }

    @Override
    public void updatePrice(int id, int newPrice){
        Drug drug = findById(id);
        if(drug != null){
            drug.setPrice(newPrice);
            }
        }


}
