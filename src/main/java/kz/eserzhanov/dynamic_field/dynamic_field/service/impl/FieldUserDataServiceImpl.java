package kz.eserzhanov.dynamic_field.dynamic_field.service.impl;

import kz.eserzhanov.dynamic_field.dynamic_field.database.repository.FieldUserDataRepository;
import kz.eserzhanov.dynamic_field.dynamic_field.service.FieldUserDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FieldUserDataServiceImpl implements FieldUserDataService {
    private final FieldUserDataRepository fieldUserDataRepository;

    @Autowired
    public FieldUserDataServiceImpl(FieldUserDataRepository fieldUserDataRepository) {
        this.fieldUserDataRepository = fieldUserDataRepository;
    }
}
