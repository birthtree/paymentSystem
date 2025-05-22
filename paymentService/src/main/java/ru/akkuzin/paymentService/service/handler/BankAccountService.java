package ru.akkuzin.paymentService.service.handler;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.akkuzin.paymentService.model.entity.BackAccount;
import ru.akkuzin.paymentService.repository.BackAccountRepository;
import jakarta.transaction.Transactional;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class BankAccountService {
    private final BackAccountRepository backAccountRepository;


    @Transactional
    public Optional<BackAccount> findById(Long id) {
        return backAccountRepository.findById(id);
    }
}
