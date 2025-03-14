package tool.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tool.project.models.Cookie;
import tool.project.repository.CookieRepository;

import java.util.List;

@Service
public class CookieService {
    @Autowired
    private CookieRepository repository;

    public List<Cookie> listAll() {
        return repository.findAll();
    }

    public Cookie get(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Cookie save(Cookie cookie) {
        return repository.save(cookie);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
