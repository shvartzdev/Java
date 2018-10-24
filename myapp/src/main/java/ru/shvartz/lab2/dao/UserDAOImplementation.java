package ru.shvartz.lab2.dao;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

public class UserDAOImplementation implements UserDAO {

    private Map<Integer, User> idToUser = new HashMap<>();

    @Override
    public Stream<User> getAll() throws Exception {
        return idToUser.values().stream();
    }

    @Override
    public Optional<User> getById(int id) throws Exception {
        return Optional.ofNullable(idToUser.get(id));
    }

    @Override
    public boolean AddUser(User user) throws Exception {
        return (getById(user.getId()).isPresent() ? true : false);
    }

    @Override
    public boolean update(User user) throws Exception {
        return idToUser.replace(user.getId(), user) != null;
    }

    @Override
    public boolean delete(User user) throws Exception {
        return idToUser.remove(user.getId()) != null;
    }
}
