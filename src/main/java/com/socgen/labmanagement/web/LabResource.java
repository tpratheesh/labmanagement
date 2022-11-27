package com.socgen.labmanagement.web;

import com.socgen.labmanagement.modal.Lab;
import com.socgen.labmanagement.service.LabService;
import com.socgen.labmanagement.web.form.LabForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class LabResource {

    private final LabService labService;

    @Autowired
    public LabResource(LabService labService) {
        this.labService = labService;
    }

    @GetMapping("/labs")
    public List<Lab> getLabs() {
        return this.labService.getLabs();
    }

    @GetMapping("/labs/{id}")
    public Lab getLab(@PathVariable Long id) {
        return this.labService.getLab(id);
    }

    @PostMapping("/labs")
    public void createLab(@RequestBody LabForm Lab) {
        this.labService.createLab(Lab);
    }

    @PutMapping("/labs")
    public void updateLab(@RequestBody LabForm Lab) {
        this.labService.updateLab(Lab);
    }

    @DeleteMapping("/labs/{id}")
    public void deleteLab(@PathVariable Long id) {
        this.labService.deleteLab(id);
    }
}
