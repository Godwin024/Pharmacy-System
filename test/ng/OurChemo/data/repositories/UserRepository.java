package ng.OurChemo.data.repositories;

import ng.OurChemo.data.models.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UsersRepositoryTest {

    private UserRepository repository;
    @BeforeEach
    void setUp(){
        repository = new UserRepositoryImpl();
    }

    @Test
    public void testThatRepositoryIsEmpty(){
        assertEquals(0, repository.count());
    }

    @Test
    public void testThatSaveOneUserIncreasesCountByOne(){
        User user = new User();

        repository.save(user);
        assertEquals(1, repository.count());
    }

    @Test
    public void testThatSavingTwoUsers_IncreasesCountToTwo(){

        User user1 = new User();
        User user2 = new User();
        repository.save(user1);
        repository.save(user2);
        assertEquals(2, repository.count());

    }

    @Test
    public void testThatRepository_CanFindUserById(){

        User user = new User();
        user.setId(1);
        repository.save(user);
        User foundUser = repository.findById(1);
        assertEquals(1, foundUser.getId());
    }

    @Test
    public void testThatRepository_CanDeleteUserById(){
        User user = new User();
        user.setId(1);
        repository.save(user);
        assertEquals(1, repository.count());
        repository.deleteById(1);
        assertEquals(0, repository.count());
    }

    @Test
    public  void testThatRepository_CanFindAllUsers(){

        User user1 = new User();
        user1.setId(1);
        User user2 = new User();
        user2.setId(2);
        repository.save(user1);
        repository.save(user2);
        List<User> users = repository.findAll();
        assertEquals(2, users.size());
    }

}