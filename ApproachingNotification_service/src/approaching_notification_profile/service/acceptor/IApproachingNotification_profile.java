package approaching_notification_profile.service.acceptor;

import org.robotservices.schemas.v02.common_profile.RetValue;

public interface IApproachingNotification_profile {

	public RetValue startProfile(long convId);
	public RetValue endProfile(long convId);

	public RetValue sendApproachingNotification_profile(long convId,String to_robot_id, long distance_mm);

	public RetValue sendApproachingNotificationOfObject_profile(long convId,String notification_destination_robot,String approaching_object_name, long distance_mm);


}
