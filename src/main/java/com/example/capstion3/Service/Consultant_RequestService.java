package com.example.capstion3.Service;

import com.example.capstion3.API.APIException;
import com.example.capstion3.Model.Consultant_Request;
import com.example.capstion3.Repository.Consultant_RequestRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class Consultant_RequestService {
    private Consultant_RequestRepository cRrepository;

    public List<Consultant_Request> getAllConsultant_Requests() {
        if (cRrepository.findAll().isEmpty()) {
            throw new APIException("No consultant requests found");
        }else {
            return cRrepository.findAll();
        }
    }

    public void addNewConsultantRequest(Consultant_Request consultant_request) {
        cRrepository.save(consultant_request);
    }

    public void deleteConsultantRequest(Integer id) {
        if (cRrepository.findConsultant_RequestById(id)==null){
            throw new APIException("Consultant request not found to delete");
        }else {
            cRrepository.deleteById(id);
        }
    }

    public void updateConsultantRequest(Consultant_Request consultant_request,Integer id) {
        if (cRrepository.findConsultant_RequestById(id)==null){
            throw new APIException("Consultant request not found to update");
        }else {
            Consultant_Request updatedConsultantRequest = cRrepository.findConsultant_RequestById(id);
            updatedConsultantRequest.setRequest_date(consultant_request.getRequest_date());
            updatedConsultantRequest.setDescription(consultant_request.getDescription());
            updatedConsultantRequest.setStatus(consultant_request.getStatus());
            cRrepository.save(updatedConsultantRequest);
        }
    }
}
