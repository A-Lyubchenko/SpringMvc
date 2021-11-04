package ua.lyubchenko.repositories;

import java.util.List;

public interface IRepositories<T> {

    List<T> getArrayList();

    T getPersonById(int id);

    void addPersonToRepository(T person);

    void update(int id, T person);
}
