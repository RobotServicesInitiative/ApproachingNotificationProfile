package approaching_notification_profile.service.acceptor;
import org.robotservices.custom_profile.lib.common.util.XMLUtil;
import org.robotservices.custom_profile.lib.service.acceptor.AcceptorCustomProfileBase;
import org.robotservices.custom_profile.lib.service.util.ClassUtil;
import org.robotservices.schemas.v02.common_profile.RetValue;

import approaching_notification_profile.common.ApproachingNotification_profile_end_profile;
import approaching_notification_profile.common.ApproachingNotification_profile_send_approaching_notification_of_object_profile;
import approaching_notification_profile.common.ApproachingNotification_profile_send_approaching_notification_profile;
import approaching_notification_profile.common.ApproachingNotification_profile_start_profile;

public class ApproachingNotificationProfile extends AcceptorCustomProfileBase {

	private IApproachingNotification_profile approachingNotification_profile = null;

	/**
	 * CLtoSV
	 * @param xml
	 * @return
	 */
	public String startProfile(long convId,String xml) {
		@SuppressWarnings("unused")
		ApproachingNotification_profile_start_profile approachingNotification_profile_start_profile = XMLUtil.unmarshal(xml, ApproachingNotification_profile_start_profile.class);

		//ここからさらにディスパッチする
		this.approachingNotification_profile = ClassUtil.getCustomProfileImple("ApproachingNotificationProfileImpl");

		RetValue retValue = approachingNotification_profile.startProfile(convId);
		String returnXml = XMLUtil.marshal(retValue);

		return returnXml;
	}

	/**
	 * CLtoSV
	 * @param xml
	 * @return
	 */
	public String endProfile(long convId,String xml) {
		@SuppressWarnings("unused")
		ApproachingNotification_profile_end_profile approachingNotification_profile_end_profile = XMLUtil.unmarshal(xml, ApproachingNotification_profile_end_profile.class);
		//インスタンスは使いまわす

		RetValue retValue = this.approachingNotification_profile.endProfile(convId);
		String returnXml = XMLUtil.marshal(retValue);

		return returnXml;

	}

	/**
	 * CLtoSV
	 * @param xml
	 * @return
	 */
	public String sendApproachingNotification(long convId,String xml) {
		ApproachingNotification_profile_send_approaching_notification_profile spproachingNotification_profile_send_approaching_notification_profile = XMLUtil.unmarshal(xml, ApproachingNotification_profile_send_approaching_notification_profile.class);
		//インスタンスは使いまわす

		String to_robot_id    = spproachingNotification_profile_send_approaching_notification_profile.getTo_robot_id();
		long distance_mm = spproachingNotification_profile_send_approaching_notification_profile.getDistance_mm();

		RetValue retValue = this.approachingNotification_profile.sendApproachingNotification_profile(convId,to_robot_id, distance_mm);

		String returnXml = XMLUtil.marshal(retValue);
		return returnXml;

	}

	/**
	 * CLtoSV
	 * @param xml
	 * @return
	 */
	public String sendApproachingNotificationOfObject(long convId,String xml) {
		ApproachingNotification_profile_send_approaching_notification_of_object_profile profile = XMLUtil.unmarshal(xml, ApproachingNotification_profile_send_approaching_notification_of_object_profile.class);
		//インスタンスは使いまわす

		String notification_destination_robot    = profile.getNotification_destination_robot();
		String approaching_object_name = profile.getApproaching_object_name();
		long distance_mm = profile.getDistance_mm();

		RetValue retValue = this.approachingNotification_profile.sendApproachingNotificationOfObject_profile(convId,notification_destination_robot,approaching_object_name, distance_mm);

		String returnXml = XMLUtil.marshal(retValue);
		return returnXml;

	}


}