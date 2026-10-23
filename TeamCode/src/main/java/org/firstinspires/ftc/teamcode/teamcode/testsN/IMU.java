package org.firstinspires.ftc.teamcode.teamcode.testsN;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;


public class IMU extends OpMode {

    QuickCode QuickIMU = new QuickCode();

    @Override
    public void loop() {
        telemetry.addData("Heading", QuickIMU.getHeading(AngleUnit.DEGREES));

    }

    @Override
    public void init() {
        QuickIMU.init(hardwareMap);

    }
}
