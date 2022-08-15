package ru.job4j.accident.service;

import org.springframework.stereotype.Service;
import ru.job4j.accident.model.AccidentType;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccidentTypeService {

    List<AccidentType> types = new ArrayList<>();

    public AccidentTypeService() {
        types.add(new AccidentType(1, "Столкновение"));
        types.add(new AccidentType(2, "Опрокидывание"));
        types.add(new AccidentType(3, "Наезд на препятствие"));
        types.add(new AccidentType(4, "Наезд на пешехода"));
        types.add(new AccidentType(5, "Наезд на велосипедиста"));
        types.add(new AccidentType(6, "Наезд на животное"));
        types.add(new AccidentType(7, "Наезд на гужевой транспорт"));
        types.add(new AccidentType(8, "Наезд на стоящее транспортное средство"));
        types.add(new AccidentType(9, "Прочие происшествия"));
    }

    public List<AccidentType> findAll() {
        return types;
    }

    public AccidentType findById(int id) {
        return types.get(id - 1);
    }
}
