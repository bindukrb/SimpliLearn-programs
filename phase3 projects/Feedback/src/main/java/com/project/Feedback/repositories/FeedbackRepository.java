package com.project.Feedback.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.project.Feedback.entity.Feedback;

@Repository
public interface FeedbackRepository extends CrudRepository<Feedback, Integer> {

	public Feedback findByUser(String feedback);
}
