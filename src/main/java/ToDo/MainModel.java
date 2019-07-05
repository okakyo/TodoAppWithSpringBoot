package ToDo;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Getter
@Setter
@Entity
public class MainModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="title",nullable = false)
    private String title;

    @Column(name="expiration",nullable = false)
    private Timestamp expiration;

    @Column(name="done",nullable=false,columnDefinition = "bit default 0")
    private Boolean done;

    @Column(name="CreatedAt",nullable = false)
    private Timestamp createdAt;

    @Column(name="updateAt",nullable = false)
    private Timestamp updateAt;
    @PrePersist
    public void onPrePresist(){
       if(this.createdAt==null) this.createdAt=new Timestamp(System.currentTimeMillis());
       if(this.updateAt==null) this.updateAt=new Timestamp(System.currentTimeMillis());
    }
    @PreUpdate
    public void onPreUpdate(){
        this.updateAt= new Timestamp(System.currentTimeMillis());
    }

}
