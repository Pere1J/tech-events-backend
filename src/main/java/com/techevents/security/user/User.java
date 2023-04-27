package com.techevents.security.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.techevents.domain.models.Event;
import com.techevents.security.token.Token;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "_user")
public class User implements UserDetails {

  @Id
  @GeneratedValue
  private Long id;
  private String name;
  private String email;

  @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @JoinTable(
          name = "user_event",
          joinColumns = @JoinColumn(name = "user_id"),
          inverseJoinColumns = @JoinColumn(name = "event_id"))
  private List<Event> events;



  //@JsonIgnore para no llevar los datos en la response al front-end
  @JsonIgnore
  private String password;
  @JsonIgnore
  @Enumerated(EnumType.STRING)
  private Role role;
  @JsonIgnore
  @OneToMany(mappedBy = "user")
  private List<Token> tokens;
  @JsonIgnore
  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return List.of(new SimpleGrantedAuthority(role.name()));
  }
  @JsonIgnore
  @Override
  public String getPassword() {
    return password;
  }
  @JsonIgnore
  @Override
  public String getUsername() {
    return email;
  }
  @JsonIgnore
  @Override
  public boolean isAccountNonExpired() {
    return true;
  }
  @JsonIgnore
  @Override
  public boolean isAccountNonLocked() {
    return true;
  }
  @JsonIgnore
  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }
  @JsonIgnore
  @Override
  public boolean isEnabled() {
    return true;
  }



}


