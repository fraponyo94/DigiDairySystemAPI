package com.dairy.project.dairysystem.Service;


import com.dairy.project.dairysystem.Repository.CowRepository;
import com.dairy.project.dairysystem.entity.Cow;
import com.dairy.project.dairysystem.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CowService {

    @Autowired
    private CowRepository cowRepository;

    //Find cow by Id
    public Cow findById(String cowId) throws ResourceNotFoundException {
        Optional<Cow> cow = cowRepository.findById(cowId);

        if(cow.isPresent()){
            return cow.get();
        }else {
            throw new ResourceNotFoundException("Cow not found for this id :: " + cowId);
        }

    }

    //Update cow
    public Cow saveE(Cow cow,@Nullable Cow cowdetails){
        if(cowdetails == null){
            return  cowRepository.save(cow);

        }else {
            cow.setBirthdate(cowdetails.getBirthdate());
            cow.setBreed(cowdetails.getBreed());
            cow.setDeathDate(cowdetails.getDeathDate());
            cow.setName(cowdetails.getName());
            cow.setPurchaseAmount(cowdetails.getPurchaseAmount());
            cow.setSaleAmount(cowdetails.getSaleAmount());
            cow.setPregnant(cowdetails.isPregnant());
            cow.setPurchaseDate(cowdetails.getPurchaseDate());


            return cowRepository.save(cow);
        }
    }

    //Remove Cow
    public void deleteCow(Cow cow){
        cowRepository.delete(cow);

    }


    //Find all cow(s)
    public List<Cow> findAll() {
        return cowRepository.findAll();
    }
}
