package tool.project.models;

import jakarta.persistence.*;

@Entity
@Table(name = "cookies")
public class Cookie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String cookieName;

    @Column(nullable = false)
    private String userAgent;

    // Constructors
    public Cookie() {}

    public Cookie(String cookieName, String userAgent) {
        this.cookieName = cookieName;
        this.userAgent = userAgent;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCookieName() {
        return cookieName;
    }

    public void setCookieName(String cookieName) {
        this.cookieName = cookieName;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }
}
