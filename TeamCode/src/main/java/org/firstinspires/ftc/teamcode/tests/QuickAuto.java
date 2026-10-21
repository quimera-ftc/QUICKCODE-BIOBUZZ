package org.firstinspires.ftc.teamcode.tests;

import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.IMU;

public class QuickAuto {

    private IMU imu;

    public void init(HardwareMap hwMap) {

        imu = hwMap.get(IMU.class, "imu");

        RevHubOrientationOnRobot RevOrientation = new RevHubOrientationOnRobot(
                RevHubOrientationOnRobot.LogoFacingDirection.FORWARD,//nessa parte é preciso checar a estrutura do seu robo
                RevHubOrientationOnRobot.UsbFacingDirection.DOWN  //e preencher direção do cabo e da logo do hub
        );

        imu.initialize(new IMU.Parameters(RevOrientation)); //esse bloco é responsavel pela incialização do robo
                                                            //criamos uma nova orientação(depende do seu hub) e incializamos
    }


}
