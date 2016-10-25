package com.cybage.model;

import javax.persistence.*;

import org.codehaus.jackson.annotate.JsonProperty;

//import java.util.Set;
@Entity
@Table(name="trainer")
public class Trainer 
{	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="trainer_id")
	@JsonProperty
	int id;
	
	@JsonProperty
	 @Column(name="trainer_name")
	String trainerName;
	
	@JsonProperty
	@Column(name="trainer_age")
	int trainerAge;
	
	public Trainer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getTrainerName() {
		return trainerName;
	}
	public void setTrainerName(String trainerName) {
		this.trainerName = trainerName;
	}
	public int getTrainerAge() {
		return trainerAge;
	}
	public void setTrainerAge(int trainerAge) {
		this.trainerAge = trainerAge;
	}
	
	@Override
	public String toString() {
		return "Trainer [trainerName=" + trainerName + ", trainerAge=" + trainerAge + "]";
	}

}
