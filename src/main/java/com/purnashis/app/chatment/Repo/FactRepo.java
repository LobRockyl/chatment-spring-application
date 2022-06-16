package com.purnashis.app.chatment.Repo;

import com.purnashis.app.chatment.models.Fact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FactRepo extends JpaRepository<Fact, Long> {
}
