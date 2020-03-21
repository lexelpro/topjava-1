package ru.javawebinar.topjava.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
@NamedQueries({
		@NamedQuery(name = Meal.ALL_BY_USER_ID_SORTED, query = "select m from Meal m where m.user.id = :userId"),
		@NamedQuery(name = Meal.DELETE, query = "DELETE FROM Meal m where m.id = :id and m.user.id = :userId"),
		@NamedQuery(name = Meal.BY_ID_AND_USER_ID, query = "SELECT m from Meal m where m.id = :id and m.user.id = :userId"),
		@NamedQuery(name = Meal.GET_BETWEEN, query = "SELECT m from Meal m where m.dateTime >= :startDate and m.dateTime < :endDate and m.user.id = :userId order by m.dateTime desc")
})
@Entity
@Table(name = "meals", uniqueConstraints = {@UniqueConstraint(columnNames = "id", name = "meals_pkey")})
public class Meal extends AbstractBaseEntity {
	public static final String ALL_BY_USER_ID_SORTED = "Meal.getAllByUserIdSorted";
	public static final String DELETE = "Meal.Delete";
	public static final String BY_ID_AND_USER_ID = "Meal.byIdAndUserId";
	public static final String GET_BETWEEN = "Meal.between";
	@Column(name ="date_time",nullable = false)
	@NotNull
	private LocalDateTime dateTime;

	@Column(name = "description", nullable = false)
	@NotBlank
	private String description;

	@Column(name = "calories", nullable = false)
    private int calories;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(nullable = false, name = "user_id")
    private User user;

    public Meal() {
    }

    public Meal(LocalDateTime dateTime, String description, int calories) {
        this(null, dateTime, description, calories);
    }

    public Meal(Integer id, LocalDateTime dateTime, String description, int calories) {
        super(id);
        this.dateTime = dateTime;
        this.description = description;
        this.calories = calories;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public String getDescription() {
        return description;
    }

    public int getCalories() {
        return calories;
    }

    public LocalDate getDate() {
        return dateTime.toLocalDate();
    }

    public LocalTime getTime() {
        return dateTime.toLocalTime();
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Meal{" +
                "id=" + id +
                ", dateTime=" + dateTime +
                ", description='" + description + '\'' +
                ", calories=" + calories +
                '}';
    }
}
