package dev.ispiroglu.jobadvertysystem.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class AdvertOwner {

  @Id
  @GeneratedValue
  Long id;

  public AdvertOwner(Advert advert, User user) {
    this.advert = advert;
    this.user = user;
  }

  public AdvertOwner() {
  }

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "advert_id")
  @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
  private Advert advert;

  @ManyToOne
  @JoinColumn(name = "user_id")
  @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
  private User user;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Advert getAdvert() {
    return advert;
  }

  public void setAdvert(Advert advert) {
    this.advert = advert;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  @Override
  public String toString() {
    return "AdvertOwner{" +
        "advert=" + advert +
        ", user=" + user +
        '}';
  }
}
