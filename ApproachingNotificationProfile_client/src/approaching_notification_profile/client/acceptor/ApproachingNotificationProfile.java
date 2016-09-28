package approaching_notification_profile.client.acceptor;
import org.robotservices.custom_profile.lib.client.acceptor.AcceptorCustomProfileBase;
import org.robotservices.custom_profile.lib.common.util.ClassUtil;
import org.robotservices.custom_profile.lib.common.util.XMLUtil;
import org.robotservices.schemas.v02.common_profile.RetValue;

import approaching_notification_profile.common.ApproachingNotification_profile_receive_approaching_notification_of_object_profile;
import approaching_notification_profile.common.ApproachingNotification_profile_receive_approaching_notification_profile;

public class ApproachingNotificationProfile extends AcceptorCustomProfileBase {

	private IApproachingNotification_profile approachingNotification_profile = null;


	/**
	 * SVtoCL
	 * @param xml
	 * @return
	 */
	public String receiveApproachingNotification(long convId,String xml) {

		//XMLをクラスにマッピング
		ApproachingNotification_profile_receive_approaching_notification_profile approachingNotification_profile_receive_approaching_notification_profile = XMLUtil.unmarshal(xml, ApproachingNotification_profile_receive_approaching_notification_profile.class);

		//インスタンスは使いまわす
		//インスタンスは使いまわす
		if(this.approachingNotification_profile == null) {
			this.approachingNotification_profile = ClassUtil.getCustomProfileImple("ApproachingNotificationProfileImpl");
		}

		String to_robot_id    = approachingNotification_profile_receive_approaching_notification_profile.getFrom_robot_id();
		long distance_mm      = approachingNotification_profile_receive_approaching_notification_profile.getDistance_mm();

		RetValue retValue = this.approachingNotification_profile.receiveApproachingNotification(convId,to_robot_id, distance_mm);

		String returnXml = XMLUtil.marshal(retValue);
		return returnXml;

	}

	/**
	 * SVtoCL
	 * @param xml
	 * @return
	 */
	public String receiveApproachingNotificationOfObject(long convId,String xml) {

		//XMLをクラスにマッピング
		ApproachingNotification_profile_receive_approaching_notification_of_object_profile profile = XMLUtil.unmarshal(xml, ApproachingNotification_profile_receive_approaching_notification_of_object_profile.class);

		//インスタンスは使いまわす
		//インスタンスは使いまわす
		if(this.approachingNotification_profile == null) {
			this.approachingNotification_profile = ClassUtil.getCustomProfileImple("ApproachingNotificationProfileImpl");
		}

		String notification_source_robot    = profile.getNotification_source_robot();
		String approaching_object_name = profile.getApproaching_object_name();
		long distance_mm      = profile.getDistance_mm();

		RetValue retValue = this.approachingNotification_profile.receiveApproachingNotificationOfObject(convId,notification_source_robot,approaching_object_name, distance_mm);

		String returnXml = XMLUtil.marshal(retValue);
		return returnXml;
	}


}