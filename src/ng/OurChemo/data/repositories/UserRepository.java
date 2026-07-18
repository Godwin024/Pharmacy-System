package ng.OurChemo.data.repositories;


import ng.OurChemo.data.models.User;

import java.util.List;

public interface UserRepository {

    int count();

    void save(User user);

    User findById(int id);

    void deleteById(int id);

    List<User> findAll();


}
