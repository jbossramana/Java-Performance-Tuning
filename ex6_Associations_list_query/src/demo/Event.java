package demo;

import java.util.Date;
import java.util.Set;

public class Event {

  
  private Long id;
  private String name;
  private Date startDate;
  private int duration;
  private Set speakers;
 
  public void setId(Long id) {
    this.id = id;
  }
  public Long getId() {
    return id;
  }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    

  public void setSpeakers(Set speakers) {
    this.speakers = speakers;
  }
  public Set getSpeakers() {
    return speakers;
  }

    

}
