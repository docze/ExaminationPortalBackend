package pl.woonkievitch.Authentication.entity;

import javax.persistence.*;

@Entity
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue
    @Column(name="role_id")
    private int id;
    private String role;

    public int getId() {
        return id;
    }

    public String getRole() {

        return role;
    }

    public void setRole(String name) {
        this.role = role;
    }

}
