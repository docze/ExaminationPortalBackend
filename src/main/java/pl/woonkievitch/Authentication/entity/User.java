package pl.woonkievitch.Authentication.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name ="my_user")
public class User {
    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private long id;
    private String login;
    private String password;
    private int activate;
    @ManyToMany
    @JoinTable(name="user_role",
            joinColumns = @JoinColumn(name ="user_id"),
            inverseJoinColumns = @JoinColumn(name ="role_id") )
    private Set<Role> roleSet;

    private String email;

    public long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public int getActivate() {
        return activate;
    }

    public Set<Role> getRoleSet() {
        return roleSet;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setActivate(int activate) {
        this.activate = activate;
    }

    public void setRoleSet(Set<Role> roleSet) {
        this.roleSet = roleSet;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
