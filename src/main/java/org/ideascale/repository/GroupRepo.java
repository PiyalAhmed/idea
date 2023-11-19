package org.ideascale.repository;

import org.ideascale.model.CommunityGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepo extends JpaRepository<CommunityGroup, Long> {
}
