package com.lcwaikiki.advertservice.repository;

import com.lcwaikiki.advertservice.model.Advert;
import com.lcwaikiki.advertservice.model.ApplicationDetail;
import com.lcwaikiki.advertservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationDetailRepository extends JpaRepository<ApplicationDetail, Long> {

  ApplicationDetail getApplicationDetailByAdvertAndUser(Advert advert, User user);
}
