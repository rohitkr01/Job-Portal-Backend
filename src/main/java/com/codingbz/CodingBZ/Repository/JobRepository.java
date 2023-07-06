package com.codingbz.CodingBZ.Repository;

import com.codingbz.CodingBZ.Model.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepository extends JpaRepository<Job,Long> {

}
