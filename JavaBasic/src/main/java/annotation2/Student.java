package annotation2;

public class Student {

    public Long id;

    public String name;

    @Length(min = 11, max = 11, errorMsg = "电话号码长度必须为11位")
    public String mobile;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
