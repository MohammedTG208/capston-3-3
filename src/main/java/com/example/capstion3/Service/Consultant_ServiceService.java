package com.example.capstion3.Service;

import com.example.capstion3.API.APIException;
import com.example.capstion3.Model.Consultant_Service;
import com.example.capstion3.Repository.Consultant_ServiceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class Consultant_ServiceService {
    private final Consultant_ServiceRepository consultant_ServiceRepository;

    public List<Consultant_Service> getAllConsultantService(){
        if (consultant_ServiceRepository.findAll()==null){
            throw new APIException("Consultant_Service is Empty");
        }else {
            return consultant_ServiceRepository.findAll();
        }
    }

    public void addNewConsultantService(Consultant_Service consultant_Service)  {
        consultant_ServiceRepository.save(consultant_Service);
    }

    public void updateConsultantService(Consultant_Service consultant_Service,Integer id)  {
        if (consultant_ServiceRepository.findConsultant_ServiceById(id)==null){
            throw new APIException("not found by this id to update");
        }else {
            Consultant_Service updateConsultant_Service = consultant_ServiceRepository.findConsultant_ServiceById(id);
            updateConsultant_Service.setDescription(consultant_Service.getDescription());
            updateConsultant_Service.setPrice(consultant_Service.getPrice());
            consultant_ServiceRepository.save(updateConsultant_Service);
        }
    }

    public void deleteConsultantService(Integer id)  {
        if (consultant_ServiceRepository.findConsultant_ServiceById(id)==null){
            throw new APIException("not found by this id to delete");
        }else {
            consultant_ServiceRepository.deleteById(id);
        }
    }
}
