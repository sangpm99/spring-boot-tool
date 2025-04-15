package tool.project.model;
import tool.project.hellper.formatter;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String slug;

    @ManyToMany(mappedBy = "categories")
    private List<Product> products = new ArrayList<>();
    
    public Category() {}

    public Category(String name) {
        this.name = name;
        this.slug = formatter.toSlug(name);
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getSlug() { return slug; }
    public void setSlug(String slug) { this.slug = slug; }
}
