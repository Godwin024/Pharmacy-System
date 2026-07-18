package ng.OurChemo.data.repositories;

import ng.OurChemo.data.models.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImpl implements UserRepository {

    private List<User> users = new ArrayList<>();

    @Override
    public int count() {
        return users.size();
    }

    @Override
    public void save(User user) {
        users.add(user);

    }

    @Override
    public  User findById(int id){
        for (User user : users){
            if (user.getId() == id){
                return user;
            }
        }
        return  null;
    }

    @Override
    public void deleteById(int id){
        for (int count = 0; count < users.size(); count++){
            if(users.get(count).getId() == id){
                users.remove(count);
                break;
            }
        }

    }

    @Override
    public List<User> findAll(){
        return users;
    }



}
