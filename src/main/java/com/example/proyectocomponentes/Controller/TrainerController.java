package com.example.proyectocomponentes.Controller;

import com.example.proyectocomponentes.models.Trainer;
import com.example.proyectocomponentes.repository.ITrainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class TrainerController {
    @Autowired
    ITrainer iTrainer;

    @GetMapping("allTrainers")
    public List<Trainer> getAllTrainers(){
        return iTrainer.findAll();
    }

    @PostMapping("createTrainer")
    public Trainer createTrainer(@RequestBody Trainer trainer){
        trainer.setFirstName(trainer.getFirstName());
        trainer.setLastName(trainer.getFirstName());
        trainer.setEmail(trainer.getEmail());
        trainer.setPhone(trainer.getPhone());
        return iTrainer.save(trainer);
    }

    @GetMapping("trainer/{name}")
    public String trainerName(@PathVariable(value = "name")String name){
        return iTrainer.byName(name);
    }

    @PutMapping("editTrainer/{id}")
    public ResponseEntity<Trainer> createTrainer(@PathVariable(value = "id")Integer id, @RequestBody Trainer trainerUpdate){
        Optional<Trainer> trainer = iTrainer.findById(id);
        trainer.get().setFirstName(trainerUpdate.getFirstName());
        trainer.get().setLastName(trainerUpdate.getLastName());
        trainer.get().setEmail(trainerUpdate.getEmail());
        trainer.get().setPhone(trainerUpdate.getPhone());
        Trainer updateTrainer = iTrainer.save(trainer.get());

        return ResponseEntity.ok(updateTrainer);
    }

}
