package org.earelin.demeter.application;

import java.util.List;
import org.earelin.demeter.application.dto.CreateFamilyDto;
import org.earelin.demeter.domain.catalog.Family;
import org.earelin.demeter.repositories.FamilyRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/families")
public class FamilyController {

  private final FamilyRepository repository;

  public FamilyController(FamilyRepository repository) {
    this.repository = repository;
  }

  @GetMapping
  public List<Family> findAll() {
    return repository.findAllByOrderByName();
  }

  @GetMapping("/{id}")
  public Family findById(@PathVariable Long id) {
    return repository.findById(id)
        .orElseThrow(() -> new ResponseStatusException(
            HttpStatus.NOT_FOUND,
            "Family not found: " + id
        ));
  }

  @DeleteMapping("/{id}")
  public void deleteById(@PathVariable long id) {
    if (!repository.existsById(id)) {
      throw new ResponseStatusException(
          HttpStatus.NOT_FOUND,
          "Family not found: " + id
      );
    }
    repository.deleteById(id);
  }

  @PostMapping
  public ResponseEntity<Family> create(@RequestBody CreateFamilyDto family) {
    throw new UnsupportedOperationException();
  }

  @PutMapping("/{id}")
  public ResponseEntity<Family> updateById(
      @PathVariable long id,
      @RequestBody Family family) {
    throw new UnsupportedOperationException();
  }
}
