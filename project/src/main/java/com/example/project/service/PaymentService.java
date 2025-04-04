package com.example.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.project.entity.Payment;
import com.example.project.repository.PaymentRepository;

@Service
public class PaymentService {
    @Autowired  PaymentRepository repo;
    
    @Autowired EmailService emailService; 

    public Page<Payment> getAll(int page, int size) {
        PageRequest obj = PageRequest.of(page, size);
        return repo.findAll(obj);
    }
    
    public String post(Payment obj) {
        repo.save(obj);
        emailService.sendMail("727723euit262@skcet.ac.in", "New Payment Received", "A new payment has been received.");
        return "Payment received successfully.";
    }

    public String delete(Long id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            emailService.sendMail("727723euit262@skcet.ac.in", "Payment Deleted", 
                    "Payment with ID " + id + " has been deleted.");
            return "Payment ID " + id + " deleted successfully.";
        }
        return "Payment ID " + id + " not found!";
    }

    public String update(Long id, Payment newPayment) {
        if (repo.existsById(id)) {
            newPayment.setId(id);
            repo.save(newPayment);
            emailService.sendMail("727723euit262@skcet.ac.in", "Payment Updated", 
                    "Payment with ID " + id + " has been updated.");
            return "Payment ID " + id + " updated successfully.";
        }
        return "Payment ID " + id + " not found!";
    }
}
