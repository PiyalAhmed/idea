package org.ideascale.repository;

import org.ideascale.model.Community;
import org.ideascale.model.GroupCustomField;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommunityRepo extends JpaRepository<Community, Long> {
}
