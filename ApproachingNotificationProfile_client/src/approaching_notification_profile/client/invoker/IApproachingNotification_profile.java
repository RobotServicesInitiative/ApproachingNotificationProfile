package approaching_notification_profile.client.invoker;

import org.robotservices.schemas.v02.common_profile.RetValue;
import org.robotservices.v02.exception.RSiException;

public interface IApproachingNotification_profile {

	public RetValue startProfile() throws RSiException;
	public RetValue endProfile() throws RSiException;

	public RetValue sendApproachingNotification_profile(String to_robot_id, long distance_mm) throws RSiException;

	public RetValue sendApproachingNotificationOfObject_profile(String notification_destination_robot, String approaching_object_name,long distance_mm) throws RSiException;

}
