package ru.job4j.accident.repository;

import org.springframework.stereotype.Repository;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.model.AccidentType;

import java.util.HashMap;
import java.util.List;

@Repository
public class AccidentMem {

    HashMap<Integer, Accident> accidentMem = new HashMap<Integer, Accident>();

    public AccidentMem() {
        accidentMem.put(1, new Accident(1, "Ivan", "A1", "Street 1", new AccidentType(1, "fd")));
        accidentMem.put(2, new Accident(2, "Danil", "B1", "Street 2", new AccidentType(1, "fd")));
        accidentMem.put(3, new Accident(3, "Egor", "C1", "Street 3", new AccidentType(1, "fd")));
    }

    public List<Accident> findAll() {
        return accidentMem.values().stream().toList();
    }

    public void create(Accident accident) {
        accident.setId(accidentMem.size() + 1);
        accidentMem.put(accidentMem.size() + 1, accident);
    }

    public Accident findById(int id) {
        return accidentMem.get(id);
    }

    public void update(Accident accident) {
        accidentMem.get(accident.getId()).setName(accident.getName());
        accidentMem.get(accident.getId()).setText(accident.getText());
        accidentMem.get(accident.getId()).setAddress(accident.getAddress());
        accidentMem.get(accident.getId()).setType(accident.getType());

    }
}
