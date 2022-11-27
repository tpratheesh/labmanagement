package com.socgen.labmanagement.service;

import com.socgen.labmanagement.modal.Author;
import com.socgen.labmanagement.modal.Category;
import com.socgen.labmanagement.modal.Lab;
import com.socgen.labmanagement.repository.LabRepository;
import com.socgen.labmanagement.web.form.LabForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LabService {

    private final AuthorService authorService;
    private final CategoryService categoryService;
    private final LabRepository labRepository;

    @Autowired
    public LabService(AuthorService authorService, CategoryService categoryService, LabRepository labRepository) {
        this.labRepository = labRepository;
        this.authorService = authorService;
        this.categoryService = categoryService;
    }

    public List<Lab> getLabs() {
        return this.labRepository.findAll();
    }

    public Lab getLab(Long id) {
        return this.labRepository.findById(id)
                .orElse(null);
    }

    public void createLab(LabForm lab) {
        if (this.getLab(lab.getId()) != null) {
            throw new RuntimeException("Lab exists!");
        }
        Category category = this.categoryService.getCategory(lab.getCategory());
        if (category == null) {
            throw new RuntimeException("Category does not exist!");
        }
        Author author = this.authorService.getAuthor(lab.getAuthor());
        if (author == null) {
            throw new RuntimeException("Author does not exist!");
        }
        this.labRepository.save(new Lab(lab.getId(),
                lab.getName(),
                lab.getDescription(),
                category,
                author));
    }

    public void updateLab(LabForm lab) {
        if (this.getLab(lab.getId()) == null) {
            throw new RuntimeException("Lab does not exist!");
        }
        Category category = this.categoryService.getCategory(lab.getCategory());
        if (category == null) {
            throw new RuntimeException("Category does not exist!");
        }
        Author author = this.authorService.getAuthor(lab.getAuthor());
        if (author == null) {
            throw new RuntimeException("Author does not exist!");
        }
        this.labRepository.save(new Lab(lab.getId(),
                lab.getName(),
                lab.getDescription(),
                category,
                author));
    }

    public void deleteLab(Long id) {
        if (this.getLab(id) == null) {
            throw new RuntimeException("Lab does not exist!");
        }
        this.labRepository.deleteById(id);
    }
}
