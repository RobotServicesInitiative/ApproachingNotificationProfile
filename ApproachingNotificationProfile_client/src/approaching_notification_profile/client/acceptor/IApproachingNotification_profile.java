package approaching_notification_profile.client.acceptor;

import org.robotservices.schemas.v02.common_profile.RetValue;



public interface IApproachingNotification_profile {

	public RetValue receiveApproachingNotification(long convId ,String from_robot_id, long distance_mm);

	public RetValue receiveApproachingNotificationOfObject(long convId ,String notification_source_robot,String approaching_object_name, long distance_mm);

}
