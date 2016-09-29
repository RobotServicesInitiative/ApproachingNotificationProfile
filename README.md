# ApproachingNotificationProfile
RSNP CsutomProfile ApproachingNotificationProfile

## 最新ライブラリ
<https://github.com/RobotServicesInitiative/ApproachingNotificationProfile/blob/master/ApproachingNotificationProfile_client/CutomProfile_ApproachingNotificationProfile_client_201609262234.jar>  
<https://github.com/RobotServicesInitiative/ApproachingNotificationProfile/blob/master/ApproachingNotification_common/CutomProfile_ApproachingNotification_common_201609262218.jar>  
<https://github.com/RobotServicesInitiative/ApproachingNotificationProfile/blob/master/ApproachingNotification_service/CutomProfile_ApproachingNotification_service_201609262218.jar>  

##ロボット側Invokerインターフェース
*	public RetValue sendApproachingNotification_profile(String to_robot_id, long distance_mm)  
サービスに通知元の自ロボットが、to_robot_idに、distance_mmほど近づいたことを通知する  
to_robot_id not null  
distance_mm not null  

* public RetValue startProfile()  
ApproachingNotification_profileを開始する

* public RetValue endProfile()  
ApproachingNotification_profileを終了する

*	public RetValue sendApproachingNotificationOfObject_profile(String notification_destination_robot, String approaching_object_name,long distance_mm)  
サービスに、approaching_object_nameが、notification_destination_robotに、distance_mmほど近づいたことを通知する  

##サービス側Invokerインターフェース

* public RetValue receiveApproachingNotification(String from_robot_id, long distance_mm)   
from_robot_idが、distance_mmほど、通知先ロボットに近付いたことを通知する  
from_robot_id not null  
distance_mm not null  

* public RetValue receiveApproachingNotificationOfObject(String notification_source_robot,String  approaching_object_name, long distance_mm)  
notification_source_robotから、approaching_object_nameが、通知先ロボットに、distance_mmほど近づいたことを通知する   
notification_source_robot not null   
approaching_object_name not null   
distance_mm not null
