package org.ideascale.repository;

import org.ideascale.model.GroupCustomField;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GroupCustomFieldRepo extends JpaRepository<GroupCustomField, Long> {
    Optional<GroupCustomField> findByCustomFieldId(Long Id);
    long countAllByCommunityId(Long id);
}
