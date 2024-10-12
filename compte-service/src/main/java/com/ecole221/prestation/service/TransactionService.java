package com.ecole221.prestation.service;


import com.ecole221.prestation.model.Transaction;
import com.ecole221.prestation.repository.TranscationRepository;
import org.springframework.stereotype.Service;

@Service
public class TransactionService implements ITransaction{
    private final TranscationRepository transcationRepository;

    public TransactionService(TranscationRepository transcationRepository) {
        this.transcationRepository = transcationRepository;
    }

    @Override
    public Transaction save(Transaction transaction) {
        return transcationRepository.save(transaction);
    }
}
