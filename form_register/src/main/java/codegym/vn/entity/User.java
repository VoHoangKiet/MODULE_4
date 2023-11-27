package codegym.vn.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.Length;

@Entity
public class User {
    @Id
    @GeneratedValue
    private int id;
    @NotBlank
    @Length(min = 5,max = 45,message = "{name.size}")
    private String firstName;
    @NotBlank
    @Length(min = 5,max = 45,message = "{name.size}")
    private String lastName;
    @NotBlank(message = "{phone.null}")
    private String phone;
    @Min(value = 18,message = "{age.size}")
    private int age;
    @Email(message = "{email.form}")
    private String email;

    public User(int id, String firstName, String lastName, String phone, int age, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.age = age;
        this.email = email;
    }

    public User() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
