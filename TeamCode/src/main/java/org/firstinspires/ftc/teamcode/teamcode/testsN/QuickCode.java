package org.firstinspires.ftc.teamcode.teamcode.testsN;

import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.IMU;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;

public class QuickCode {

    public IMU imu;

    public void init(HardwareMap hwMap){
        imu = hwMap.get(IMU.class, "imu");

        RevHubOrientationOnRobot RevOrientation = new RevHubOrientationOnRobot(
                RevHubOrientationOnRobot.LogoFacingDirection.FORWARD, //editar conforme o control hub esta no seu robo
                RevHubOrientationOnRobot.UsbFacingDirection.DOWN // direção da logo e direão do cabo
        );

        imu.initialize(new IMU.Parameters(RevOrientation)); //configuramos uma nova orientação pro IMU
                                                            //inicializamos o IMU

    }

    public double getHeading(AngleUnit angleUnit) {
        return imu.getRobotYawPitchRollAngles().getYaw(angleUnit);
    }
}
