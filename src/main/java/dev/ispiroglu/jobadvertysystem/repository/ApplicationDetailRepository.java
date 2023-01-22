package dev.ispiroglu.jobadvertysystem.repository;

import dev.ispiroglu.jobadvertysystem.model.Advert;
import dev.ispiroglu.jobadvertysystem.model.ApplicationDetail;
import dev.ispiroglu.jobadvertysystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationDetailRepository extends JpaRepository<ApplicationDetail, Long> {

  ApplicationDetail getApplicationDetailByAdvertAndUser(Advert advert, User user);
}
