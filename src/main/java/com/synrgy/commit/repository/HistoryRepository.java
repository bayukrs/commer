package com.synrgy.commit.repository;

import com.synrgy.commit.model.HistoryEntity;
import com.synrgy.commit.model.oauth.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HistoryRepository extends JpaRepository<HistoryEntity, Long> {
    List<HistoryEntity> findByUser(User user);
}
