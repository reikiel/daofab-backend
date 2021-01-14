package com.example.repository;

import com.example.model.Child;
import com.example.model.Parent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChildRepository extends JpaRepository<Child, Long> {

    List<Child> findByParentId(Long parentId);

    List<Child> findByReceiver(String receiver);
}
