
package entity;

import javax.persistence.*;

@Entity
@Table(name="DEVICE")
public class Device {

    @Id
	@Column(name="deviceId", nullable=false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int deviceId;

    @Column(name="description")
    private String description;

    public Device(String description) {
        this.description = description;
    }

    public Device() {
    }
    public int getDeviceId() {

        return deviceId;
    }

    public void setDescription(String description) {

        this.description = description;
    }

    public String getDescription() {

        return description;
    }
	@Override
	public String toString() {

        return "Device [deviceId=" + deviceId + ", description=" + description + "]";
	}


}

