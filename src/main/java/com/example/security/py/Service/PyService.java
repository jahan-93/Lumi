package com.example.security.py.Service;

import com.example.security.py.Entity.PyEntity;
import com.example.security.py.dto.TendencyDTO;
import com.example.security.py.repository.PyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PyService {
    private final PyRepository repository;

    public void TendencySave(TendencyDTO dto) {
        PyEntity entity = new PyEntity();
        entity.setMorningNight(dto.getMorningNight());
        entity.setFocus(dto.getFocus());
        entity.setMaxFocus(dto.getMaxFocus());
        entity.setSleep(dto.getSleep());
        entity.setRising(dto.getRising());

        repository.save(entity);
    }
}
