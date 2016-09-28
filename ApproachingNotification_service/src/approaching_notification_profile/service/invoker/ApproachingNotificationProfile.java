package approaching_notification_profile.service.invoker;

import org.robotservices.custom_profile.lib.common.util.CustomProfileConst;
import org.robotservices.custom_profile.lib.common.util.HeaderTimeStampUtil;
import org.robotservices.custom_profile.lib.common.util.XMLUtil;
import org.robotservices.custom_profile.lib.service.invoker.InvokerCustomProfileBase;
import org.robotservices.custom_profile.lib.service.invoker.PushDataCustomProfile;
import org.robotservices.schemas.v02.common_profile.RetValue;
import org.robotservices.schemas.v02.common_profile.RoboHeader;
import org.robotservices.v02.exception.RSiException;

import approaching_notification_profile.common.ApproachingNotificationProfileConst;
import approaching_notification_profile.common.ApproachingNotification_profile_receive_approaching_notification_of_object_profile;
import approaching_notification_profile.common.ApproachingNotification_profile_receive_approaching_notification_profile;


public class ApproachingNotificationProfile extends InvokerCustomProfileBase  {


	/**
	 * SVtoCL
	 * @param xml
	 * @return
	 * @throws RSiException
	 */
	public RetValue receiveApproachingNotification(String from_robot_id, long distance_mm) throws RSiException {

		//ここでＸＭＬを作って、下に送信を委譲する
		RoboHeader roboHeader =new RoboHeader();
		roboHeader.setDirection(CustomProfileConst.ROBO_HEADER_DIRECTION.SVtoCL.toString());
		roboHeader.setMessageId("messageId");
		roboHeader.setMessageType(CustomProfileConst.ROBO_HEADER_MESSAGE_TYPE.sync.toString());
		roboHeader.setLastReply(false);
		roboHeader.setTimestamp(HeaderTimeStampUtil.getHederTimeStampISO8601());
		roboHeader.setVersion(CustomProfileConst.ROBO_HEADER_VERSION.toString());

		ApproachingNotification_profile_receive_approaching_notification_profile approachingNotification_profile_receive_approaching_notification_profile = new ApproachingNotification_profile_receive_approaching_notification_profile();
		approachingNotification_profile_receive_approaching_notification_profile.setRoboHeader(roboHeader);
		approachingNotification_profile_receive_approaching_notification_profile.setFrom_robot_id(from_robot_id);
		approachingNotification_profile_receive_approaching_notification_profile.setDistance_mm(distance_mm);

		//XML化
		String xml = XMLUtil.marshal(approachingNotification_profile_receive_approaching_notification_profile);

		PushDataCustomProfile pushDataCustomProfile = new PushDataCustomProfile(this.getConvId(),this.getInvokerProfileFactory());
		String returnXml = pushDataCustomProfile.pushDataCustomProfile(ApproachingNotificationProfileConst.CLIENT_ACCEPTOR_CUSTOM_PROFILE_NAME,ApproachingNotificationProfileConst.OPERATION_NAME_RECIVE_APPROACHING_NOTIICATION, xml);

		RetValue retValue = XMLUtil.unmarshal(returnXml, RetValue.class);

		return retValue;
	}


	/**
	 * SVtoCL
	 * @param xml
	 * @return
	 * @throws RSiException
	 */
	public RetValue receiveApproachingNotificationOfObject(String notification_source_robot,String  approaching_object_name, long distance_mm) throws RSiException {

		//ここでＸＭＬを作って、下に送信を委譲する
		RoboHeader roboHeader =new RoboHeader();
		roboHeader.setDirection(CustomProfileConst.ROBO_HEADER_DIRECTION.SVtoCL.toString());
		roboHeader.setMessageId("messageId");
		roboHeader.setMessageType(CustomProfileConst.ROBO_HEADER_MESSAGE_TYPE.sync.toString());
		roboHeader.setLastReply(false);
		roboHeader.setTimestamp(HeaderTimeStampUtil.getHederTimeStampISO8601());
		roboHeader.setVersion(CustomProfileConst.ROBO_HEADER_VERSION.toString());

		ApproachingNotification_profile_receive_approaching_notification_of_object_profile approachingNotification_profile_receive_approaching_notification_of_object_profile = new ApproachingNotification_profile_receive_approaching_notification_of_object_profile();
		approachingNotification_profile_receive_approaching_notification_of_object_profile.setRoboHeader(roboHeader);
		approachingNotification_profile_receive_approaching_notification_of_object_profile.setNotification_source_robot(notification_source_robot);
		approachingNotification_profile_receive_approaching_notification_of_object_profile.setApproaching_object_name(approaching_object_name);
		approachingNotification_profile_receive_approaching_notification_of_object_profile.setDistance_mm(distance_mm);

		//XML化
		String xml = XMLUtil.marshal(approachingNotification_profile_receive_approaching_notification_of_object_profile);

		PushDataCustomProfile pushDataCustomProfile = new PushDataCustomProfile(this.getConvId(),this.getInvokerProfileFactory());
		String returnXml = pushDataCustomProfile.pushDataCustomProfile(ApproachingNotificationProfileConst.CLIENT_ACCEPTOR_CUSTOM_PROFILE_NAME,ApproachingNotificationProfileConst.OPERATION_NAME_RECIVE_APPROACHING_NOTIICATION_OF_OBJECT, xml);

		RetValue retValue = XMLUtil.unmarshal(returnXml, RetValue.class);

		return retValue;
	}


}