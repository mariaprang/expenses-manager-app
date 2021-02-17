package expensesTracker.models;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="user_photos")
public class PhotoFile extends BaseEntity{


    private String name;

    private String type;

    @Lob
    private byte[] data;

    public PhotoFile() {
    }

    public PhotoFile(String name, String type, byte[] data) {
        this.name = name;
        this.type = type;
        this.data = data;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }
}
