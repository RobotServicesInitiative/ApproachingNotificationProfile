package approaching_notification_profile.common;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.robotservices.schemas.v02.common_profile.RoboHeader;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
	"roboHeader"
})
@XmlRootElement(name = "snsoauth_profile",namespace="http://www.robotservices.org/schemas/ApproachingNotification_profile_start_profile")
public class ApproachingNotification_profile_start_profile {

    @XmlElement(name="robo_header", namespace = "http://www.robotservices.org/schemas/V02/Common_profile", required = true)
    protected RoboHeader roboHeader;

    public RoboHeader getRoboHeader() {
        return roboHeader;
    }
    public void setRoboHeader(RoboHeader value) {
        this.roboHeader = value;
    }


}
