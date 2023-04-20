package retrain.maven.neko.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "users_info")
public class UsersInfoEntity implements Serializable {
    @Id
    @Column(name = "user_id")
    private String id;

    @MapsId
    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private UsersEntity userId;

    private String firstName;
    private String lastName;

    private String address;
    
    @Column(unique = true)
    private String phone;

    private String image;
    private LocalDateTime timestamps;
}
