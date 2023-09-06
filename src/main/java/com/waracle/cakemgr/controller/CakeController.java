package com.waracle.cakemgr.controller;

import com.waracle.cakemgr.exception.CakeNotFoundException;
import com.waracle.cakemgr.repository.CakeRepository;
import com.waracle.cakemgr.model.Cake;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CakeController {

    private final CakeRepository repository;

    public CakeController(CakeRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/cakes")
    public List<Cake> cakes() {
        return repository.findAll();
    }

    @GetMapping("/cake/{id}")
    public Cake cake(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new CakeNotFoundException(id));
    }

    @PostMapping("/cake")
    public Cake newCake(@RequestBody Cake newCake) {
        return repository.save(newCake);
    }

    @PutMapping("/cake/{id}")
    public Cake updateCake(@RequestBody Cake newCake, @PathVariable Long id) {
        return repository.findById(id)
                .map(cake -> {
                    cake.setTitle(newCake.getTitle());
                    cake.setDescription(newCake.getDescription());
                    cake.setImage(newCake.getImage());
                    return repository.save(cake);
                })
                .orElseThrow(() -> new CakeNotFoundException(id));
    }

    @DeleteMapping("/cake/{id}")
    void deleteCake(@PathVariable Long id) {
        repository.deleteById(id);
    }

}
