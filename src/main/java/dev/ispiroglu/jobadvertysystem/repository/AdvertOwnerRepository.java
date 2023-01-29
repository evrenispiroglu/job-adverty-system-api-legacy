package dev.ispiroglu.jobadvertysystem.repository;

import dev.ispiroglu.jobadvertysystem.model.AdvertOwner;
import dev.ispiroglu.jobadvertysystem.model.User;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdvertOwnerRepository extends JpaRepository<AdvertOwner, Long> {

  Page<AdvertOwner> findAdvertOwnersByUserAndAdvert_Active(User user, PageRequest pageRequest,
                                                           boolean active);

  Page<AdvertOwner> findAdvertOwnersByAdvert_Active(PageRequest pageRequest,
                                                    boolean active);

  List<AdvertOwner> findAdvertOwnersByUserAndAdvert_Active(User user, boolean active);
}
