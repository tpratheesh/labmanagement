package com.socgen.labmanagement.repository;

import com.socgen.labmanagement.modal.Lab;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LabRepository extends JpaRepository<Lab, Long> {
}
