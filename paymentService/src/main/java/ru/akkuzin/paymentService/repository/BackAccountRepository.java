package ru.akkuzin.paymentService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.akkuzin.paymentService.model.entity.BackAccount;

@Repository
public interface BackAccountRepository extends JpaRepository<BackAccount, Long> {
}
