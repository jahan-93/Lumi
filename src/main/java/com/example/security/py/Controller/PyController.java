package com.example.security.py.Controller;

import com.example.security.py.Service.PyService;
import com.example.security.py.dto.TendencyDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PyController {

    PyService pyService;

    @PostMapping("/lumi/Py/tendency")
    public void tendency(@RequestBody TendencyDTO dto) {
        pyService.TendencySave(dto);
    }
}
