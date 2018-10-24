package ru.shvartz.lab2.dao;
import java.util.Optional;
import java.util.stream.Stream;

public interface UserDAO {
    Stream<User> getAll() throws Exception;
    Optional<User> getById(int id) throws Exception;
    boolean AddUser(User user) throws Exception;
    boolean update(User user) throws Exception;
    boolean delete (User user) throws Exception;
}
