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
    "from_robot_id",
    "distance_mm",
})
@XmlRootElement(name = "snsoauth_profile",namespace="http://www.robotservices.org/schemas/ApproachingNotification_profile_receive_approaching_notification_of_object_profile")
public class ApproachingNotification_profile_receive_approaching_notification_of_object_profile {

	    @XmlElement(name="robo_header", namespace = "http://www.robotservices.org/schemas/V02/Common_profile", required = true)
	    protected RoboHeader roboHeader;

	    public RoboHeader getRoboHeader() {
	        return roboHeader;
	    }
	    public void setRoboHeader(RoboHeader value) {
	        this.roboHeader = value;
	    }

	    /**
	     * 接近してくるrobot_id
	     */
	    @XmlElement(name="notification_source_robot")
	    private String notification_source_robot;

	    /**
	     * 接近物体名
	     */
	    @XmlElement(name="approaching_object_name")
	    private String approaching_object_name;

	    /**
	     * 接近距離 [mm]
	     */
	    @XmlElement(name="distance_mm")
	    private long distance_mm;


		public long getDistance_mm() {
			return distance_mm;
		}
		public void setDistance_mm(long distance_mm) {
			this.distance_mm = distance_mm;
		}
		public String getNotification_source_robot() {
			return notification_source_robot;
		}
		public void setNotification_source_robot(String notification_source_robot) {
			this.notification_source_robot = notification_source_robot;
		}
		public String getApproaching_object_name() {
			return approaching_object_name;
		}
		public void setApproaching_object_name(String approaching_object_name) {
			this.approaching_object_name = approaching_object_name;
		}

}
