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

    @Column(name="expiration")
    private Timestamp expiration;

    @Column(name="done",columnDefinition = "boolean default false")
    private Boolean done;

    @Column(name="CreatedAt")
    private Timestamp createdAt;

    @Column(name="updateAt")
    private Timestamp updateAt;
    @PrePersist
    public void onPrePresist(){
        if(this.done==null) this.done=false;
        if(this.expiration==null) this.expiration=new Timestamp(System.currentTimeMillis());
        if(this.createdAt==null) this.createdAt=new Timestamp(System.currentTimeMillis());
        if(this.updateAt==null) this.updateAt=new Timestamp(System.currentTimeMillis());
    }
    @PreUpdate
    public void onPreUpdate(){
        this.updateAt= new Timestamp(System.currentTimeMillis());
    }

}
