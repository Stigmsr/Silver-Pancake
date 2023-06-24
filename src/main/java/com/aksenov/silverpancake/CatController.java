package com.aksenov.silverpancake;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
class CatController {
    private final CatRepository repository;

    CatController(CatRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/cats")
    List<Cat> all() {
        return repository.findAll();
    }

    @PostMapping("/cats")
    Cat newCat(@RequestBody Cat newCat) {
        return repository.save(newCat);
    }

    @GetMapping("/cats/{id}")
    Cat one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new CatNotFoundException(id));
    }

    @PutMapping("/cats/{id}")
    Cat replaceCat(@RequestBody Cat newCat, @PathVariable Long id) {

        return repository.findById(id)
                .map(Cat -> {
                    Cat.setName(newCat.getName());
                    Cat.setBreed(newCat.getBreed());
                    return repository.save(Cat);
                })
                .orElseGet(() -> {
                    newCat.setId(id);
                    return repository.save(newCat);
                });
    }

    @DeleteMapping("/cats/{id}")
    void deleteCat(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
