package ru.job4j.accident.service;

import org.springframework.stereotype.Service;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.repository.AccidentRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccidentService {

    private final AccidentRepository accidentRepository;

    public AccidentService(AccidentRepository accidentRepository) {
        this.accidentRepository = accidentRepository;
    }

    public List<Accident> findAll() {
        List<Accident> list = new ArrayList<>();
        accidentRepository.findAll().forEach(list::add);
        return list;
    }

    public void create(Accident accident) {
        accidentRepository.save(accident);
    }

    public Accident findById(int id) {
        return accidentRepository.findById(id).get();
    }

    public void update(Accident accident) {
        accidentRepository.updates(
                accident.getName(),
                accident.getType().getId(),
                accident.getText(),
                accident.getAddress(),
                accident.getId()
        );
    }
}
