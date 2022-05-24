package io.laraich.springjwt.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity @Data @NoArgsConstructor @AllArgsConstructor
public class User {
        public User(String username, String password, String email, ArrayList<Role> arrayList) {
    }

        public User() {
        }

        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;
        private String username;
        private String password;
        private String email;

        public User(Long id, String username, String password, String email, Collection<Role> roles) {
                this.id = id;
                this.username = username;
                this.password = password;
                this.email = email;
                this.roles = roles;
        }

        public Long getId() {
                return this.id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        public String getUsername() {
                return this.username;
        }

        public void setUsername(String username) {
                this.username = username;
        }

        public String getPassword() {
                return this.password;
        }

        public void setPassword(String password) {
                this.password = password;
        }

        public String getEmail() {
                return this.email;
        }

        public void setEmail(String email) {
                this.email = email;
        }
        public void setRoles(Collection<Role> roles) {
                this.roles = roles;
        }

        public User id(Long id) {
                setId(id);
                return this;
        }

        public User username(String username) {
                setUsername(username);
                return this;
        }

        public User password(String password) {
                setPassword(password);
                return this;
        }

        public User email(String email) {
                setEmail(email);
                return this;
        }

        public User roles(Collection<Role> roles) {
                setRoles(roles);
                return this;
        }

   

        @Override
        public String toString() {
                return "{" +
                        " id='" + getId() + "'" +
                        ", username='" + getUsername() + "'" +
                        ", password='" + getPassword() + "'" +
                        ", email='" + getEmail() + "'" +
                        ", roles='" + getRoles() + "'" +
                        "}";
        }


        @ManyToMany(fetch = FetchType.EAGER)
        private Collection<Role> roles = new ArrayList<>();

        public Collection<Role> getRoles() {
            return this.roles;
        }

}
