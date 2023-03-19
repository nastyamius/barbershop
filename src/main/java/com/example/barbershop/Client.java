
package com.example.barbershop;

        import jakarta.persistence.Entity;
        import jakarta.persistence.GeneratedValue;
        import jakarta.persistence.GenerationType;
        import jakarta.persistence.Id;

@Entity
public class Client {
    private Long id;
    private String FIO;
    private String date_z;
    private String usluga;
    private String barber;

    protected Client(){
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId(){return id;}
    public void setId(Long id){this.id = id;}
    public String getType(){return FIO;}
    public void setType(String type){this.FIO = FIO;}
    public String getD_class(){return date_z;}
    public void setD_class(String d_class){this.date_z = date_z;}
    public String getDate_arr(){return usluga;}
    public void setDate_arr(String date_arr){this.usluga = usluga;}
    public String getDate_dep(){return barber;}
    public void setDate_dep(String date_dep){this.barber = barber;}


}
