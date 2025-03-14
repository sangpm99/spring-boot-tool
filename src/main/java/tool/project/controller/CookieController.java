package tool.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import tool.project.models.Cookie;
import tool.project.service.CookieService;

@RestController
@RequestMapping("/cookies")
@CrossOrigin(origins = "*") // Cho phép CORS
public class CookieController {
    @Autowired
    private CookieService service;

    @GetMapping
    public List<Cookie> listAll() {
        return service.listAll();
    }

    @GetMapping("/{id}")
    public Cookie get(@PathVariable Long id) {
        return service.get(id);
    }

    @PostMapping
    public Cookie create(@RequestBody Cookie cookie) {
        return service.save(cookie);
    }

    @PutMapping("/{id}")
    public Cookie update(@PathVariable Long id, @RequestBody Cookie cookie) {
        cookie.setId(id);
        return service.save(cookie);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
