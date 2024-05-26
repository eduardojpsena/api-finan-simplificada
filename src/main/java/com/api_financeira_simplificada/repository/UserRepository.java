package com.api_financeira_simplificada.repository;

import com.api_financeira_simplificada.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
