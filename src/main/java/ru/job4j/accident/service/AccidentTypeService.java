package ru.job4j.accident.service;

import org.springframework.stereotype.Service;
import ru.job4j.accident.model.AccidentType;
import ru.job4j.accident.repository.AccidentTypeRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccidentTypeService {

    private final AccidentTypeRepository repository;

    public AccidentTypeService(AccidentTypeRepository repository) {
        this.repository = repository;
    }

    public List<AccidentType> findAll() {
        List<AccidentType> list = new ArrayList<>();
        repository.findAll().forEach(list::add);
        return list;
    }

    public AccidentType findById(int id) {
        return repository.findById(id).get();
    }

}
