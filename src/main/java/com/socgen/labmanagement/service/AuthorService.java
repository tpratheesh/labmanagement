package com.socgen.labmanagement.service;

import com.socgen.labmanagement.modal.Author;
import com.socgen.labmanagement.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<Author> getAuthors() {
        return this.authorRepository.findAll();
    }

    public Author getAuthor(Long id) {
        return this.authorRepository.findById(id)
                .orElse(null);
    }

    public void createAuthor(Author author) {
        if (this.getAuthor(author.getId()) != null) {
            throw new RuntimeException("Author exists!");
        }
        this.authorRepository.save(author);
    }

    public void updateAuthor(Author author) {
        if (this.getAuthor(author.getId()) == null) {
            throw new RuntimeException("Author does not exist!");
        }
        this.authorRepository.save(author);
    }

    public void deleteAuthor(Long id) {
        if (this.getAuthor(id) == null) {
            throw new RuntimeException("Author does not exist!");
        }
        this.authorRepository.deleteById(id);
    }
}
