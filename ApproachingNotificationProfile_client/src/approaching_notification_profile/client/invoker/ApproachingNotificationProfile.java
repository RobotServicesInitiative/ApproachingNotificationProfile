package approaching_notification_profile.client.invoker;

import java.util.logging.Logger;

import org.robotservices.custom_profile.lib.client.AbstractCustomProfile;
import org.robotservices.custom_profile.lib.client.InvokerCustomProfileFactory;
import org.robotservices.custom_profile.lib.client.PushDataCustomProfile;
import org.robotservices.custom_profile.lib.common.util.CustomProfileConst;
import org.robotservices.custom_profile.lib.common.util.HeaderTimeStampUtil;
import org.robotservices.custom_profile.lib.common.util.XMLUtil;
import org.robotservices.schemas.v02.common_profile.RetValue;
import org.robotservices.schemas.v02.common_profile.RoboHeader;
import org.robotservices.v02.exception.RSiException;

import approaching_notification_profile.common.ApproachingNotificationProfileConst;
import approaching_notification_profile.common.ApproachingNotification_profile_end_profile;
import approaching_notification_profile.common.ApproachingNotification_profile_send_approaching_notification_of_object_profile;
import approaching_notification_profile.common.ApproachingNotification_profile_send_approaching_notification_profile;
import approaching_notification_profile.common.ApproachingNotification_profile_start_profile;

public class ApproachingNotificationProfile extends AbstractCustomProfile implements IApproachingNotification_profile {

	private static final Logger logger = Logger.getLogger(ApproachingNotificationProfile.class.toString());

	@SuppressWarnings("rawtypes")
	public RetValue startProfile() throws RSiException {

		//XMLの作成
		RoboHeader roboHeader = new RoboHeader();
		roboHeader.setVersion(CustomProfileConst.ROBO_HEADER_VERSION);
		roboHeader.setDirection(CustomProfileConst.ROBO_HEADER_DIRECTION.CLtoSV.toString());
		roboHeader.setMessageType(CustomProfileConst.ROBO_HEADER_MESSAGE_TYPE.async.toString());
		roboHeader.setMessageId("MessageId");
		roboHeader.setReplyToMessageId("ReplyToMessageId");
		roboHeader.setLastReply(false);

		roboHeader.setTimestamp(HeaderTimeStampUtil.getHederTimeStampISO8601());

		ApproachingNotification_profile_start_profile approachingNotification_profile_start_profile = new ApproachingNotification_profile_start_profile();

		approachingNotification_profile_start_profile.setRoboHeader(roboHeader);

		String xml = XMLUtil.marshal(approachingNotification_profile_start_profile);

		//カスタムプロファイル送信
		InvokerCustomProfileFactory invokerCustomProfileFactory = this.getInvokerCustomProfileFactory();
		PushDataCustomProfile pushDataCustomProfile = invokerCustomProfileFactory.getPushDataCustomProfile();

		String receiveXML = pushDataCustomProfile.pushDataCustomProfile(ApproachingNotificationProfileConst.SERVICE_ACCEPTOR_CUSTOM_PROFILE_NAME,ApproachingNotificationProfileConst.OPERATION_START_PROFILE, xml);
		RetValue retValue = XMLUtil.unmarshal(receiveXML, RetValue.class);

		return retValue;
	}

	@Override
	public RetValue endProfile() throws RSiException {
		//XMLの作成
		RoboHeader roboHeader = new RoboHeader();
		roboHeader.setVersion(CustomProfileConst.ROBO_HEADER_VERSION);
		roboHeader.setDirection(CustomProfileConst.ROBO_HEADER_DIRECTION.CLtoSV.toString());
		roboHeader.setMessageType(CustomProfileConst.ROBO_HEADER_MESSAGE_TYPE.async.toString());
		roboHeader.setMessageId("MessageId");
		roboHeader.setReplyToMessageId("ReplyToMessageId");
		roboHeader.setLastReply(false);

		roboHeader.setTimestamp(HeaderTimeStampUtil.getHederTimeStampISO8601());

		ApproachingNotification_profile_end_profile approachingNotification_profile_end_profile = new ApproachingNotification_profile_end_profile();

		approachingNotification_profile_end_profile.setRoboHeader(roboHeader);

		String xml = XMLUtil.marshal(approachingNotification_profile_end_profile);

		//カスタムプロファイル送信
		@SuppressWarnings("rawtypes")
		InvokerCustomProfileFactory invokerCustomProfileFactory = this.getInvokerCustomProfileFactory();
		PushDataCustomProfile pushDataCustomProfile = invokerCustomProfileFactory.getPushDataCustomProfile();

		String receiveXML = pushDataCustomProfile.pushDataCustomProfile(ApproachingNotificationProfileConst.SERVICE_ACCEPTOR_CUSTOM_PROFILE_NAME,ApproachingNotificationProfileConst.OPERATION_NAME_END_PROFILE, xml);

		RetValue retValue = XMLUtil.unmarshal(receiveXML, RetValue.class);
		return retValue;
	}

	@Override
	public RetValue sendApproachingNotification_profile(String to_robot_id,
			long distance_mm) throws RSiException {

		//XMLの作成
		RoboHeader roboHeader = new RoboHeader();
		roboHeader.setVersion(CustomProfileConst.ROBO_HEADER_VERSION);
		roboHeader.setDirection(CustomProfileConst.ROBO_HEADER_DIRECTION.CLtoSV.toString());
		roboHeader.setMessageType(CustomProfileConst.ROBO_HEADER_MESSAGE_TYPE.async.toString());
		roboHeader.setMessageId("MessageId");
		roboHeader.setReplyToMessageId("ReplyToMessageId");
		roboHeader.setLastReply(false);

		roboHeader.setTimestamp(HeaderTimeStampUtil.getHederTimeStampISO8601());

		ApproachingNotification_profile_send_approaching_notification_profile approachingNotification_profile_send_approaching_notification_profile = new ApproachingNotification_profile_send_approaching_notification_profile();

		approachingNotification_profile_send_approaching_notification_profile.setTo_robot_id(to_robot_id);
		approachingNotification_profile_send_approaching_notification_profile.setDistance_mm(distance_mm);

		String xml = XMLUtil.marshal(approachingNotification_profile_send_approaching_notification_profile);

		//カスタムプロファイル送信
		@SuppressWarnings("rawtypes")
		InvokerCustomProfileFactory invokerCustomProfileFactory = this.getInvokerCustomProfileFactory();
		PushDataCustomProfile pushDataCustomProfile = invokerCustomProfileFactory.getPushDataCustomProfile();

		String receiveXML = pushDataCustomProfile.pushDataCustomProfile(ApproachingNotificationProfileConst.SERVICE_ACCEPTOR_CUSTOM_PROFILE_NAME,ApproachingNotificationProfileConst.OPERATION_NAME_SEND_APPROACHING_NOTIICATION, xml);

		RetValue retValue = XMLUtil.unmarshal(receiveXML, RetValue.class);
		return retValue;
	}

	@Override
	public RetValue sendApproachingNotificationOfObject_profile(
			String notification_destination_robot,
			String approaching_object_name, long distance_mm)
			throws RSiException {

		//XMLの作成
		RoboHeader roboHeader = new RoboHeader();
		roboHeader.setVersion(CustomProfileConst.ROBO_HEADER_VERSION);
		roboHeader.setDirection(CustomProfileConst.ROBO_HEADER_DIRECTION.CLtoSV.toString());
		roboHeader.setMessageType(CustomProfileConst.ROBO_HEADER_MESSAGE_TYPE.async.toString());
		roboHeader.setMessageId("MessageId");
		roboHeader.setReplyToMessageId("ReplyToMessageId");
		roboHeader.setLastReply(false);

		roboHeader.setTimestamp(HeaderTimeStampUtil.getHederTimeStampISO8601());

		ApproachingNotification_profile_send_approaching_notification_of_object_profile profile = new ApproachingNotification_profile_send_approaching_notification_of_object_profile();

		profile.setNotification_destination_robot(notification_destination_robot);
		profile.setApproaching_object_name(approaching_object_name);
		profile.setDistance_mm(distance_mm);

		String xml = XMLUtil.marshal(profile);

		//カスタムプロファイル送信
		@SuppressWarnings("rawtypes")
		InvokerCustomProfileFactory invokerCustomProfileFactory = this.getInvokerCustomProfileFactory();
		PushDataCustomProfile pushDataCustomProfile = invokerCustomProfileFactory.getPushDataCustomProfile();

		String receiveXML = pushDataCustomProfile.pushDataCustomProfile(ApproachingNotificationProfileConst.SERVICE_ACCEPTOR_CUSTOM_PROFILE_NAME,ApproachingNotificationProfileConst.OPERATION_NAME_SEND_APPROACHING_NOTIICATION_OF_OBJECT, xml);

		RetValue retValue = XMLUtil.unmarshal(receiveXML, RetValue.class);
		return retValue;
	}



}