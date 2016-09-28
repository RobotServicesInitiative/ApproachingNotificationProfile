package approaching_notification_profile.common;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.robotservices.schemas.v02.common_profile.RoboHeader;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
	"roboHeader",
    "to_robot_id",
    "distance_mm",
})
@XmlRootElement(name = "snsoauth_profile",namespace="http://www.robotservices.org/schemas/ApproachingNotification_profile_send_approaching_notification_profile")
public class ApproachingNotification_profile_send_approaching_notification_profile {

	    @XmlElement(name="robo_header", namespace = "http://www.robotservices.org/schemas/V02/Common_profile", required = true)
	    protected RoboHeader roboHeader;

	    public RoboHeader getRoboHeader() {
	        return roboHeader;
	    }
	    public void setRoboHeader(RoboHeader value) {
	        this.roboHeader = value;
	    }

	    /**
	     * 近づかれているrobot_id
	     */
	    @XmlElement(name="to_robot_id")
	    private String to_robot_id;

	    /**
	     * 接近距離 [mm]
	     */
	    @XmlElement(name="distance_mm")
	    private long distance_mm;

		public String getTo_robot_id() {
			return to_robot_id;
		}
		public void setTo_robot_id(String to_robot_id) {
			this.to_robot_id = to_robot_id;
		}
		public long getDistance_mm() {
			return distance_mm;
		}
		public void setDistance_mm(long distance_mm) {
			this.distance_mm = distance_mm;
		}

}
