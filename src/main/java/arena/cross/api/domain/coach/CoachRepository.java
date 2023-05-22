package arena.cross.api.domain.coach;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoachRepository extends JpaRepository<Coach, Long> {
    Page<Coach> findAllByAtivoTrue(Pageable paginacao);
}
