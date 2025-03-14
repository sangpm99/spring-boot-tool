package tool.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tool.project.models.Cookie;

public interface CookieRepository extends JpaRepository<Cookie, Long> {
}
