package org.firstinspires.ftc.teamcode.tests;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import org.firstinspires.ftc.teamcode.tests.DriveTrainIMU;

@Autonomous
public class OpModeBasico extends LinearOpMode {

    private DriveTrainIMU drive;
    private static final double tempoTile = 1.5;

    @Override
    public void runOpMode() {
        drive = new DriveTrainIMU(hardwareMap);

        waitForStart();

        if (opModeIsActive()) {
            drive.resetIMU();
            double tempoInicio = getRuntime();

            while (opModeIsActive() && (getRuntime() - tempoInicio < tempoTile)) {
                drive.strafe(0.5);

                if (Math.abs(drive.getRotation()) > 5.0) {
                    break;
                }

                telemetry.addData("Quanto o IMU girou", drive.getRotation());
                telemetry.update();
            }

            drive.stop();
        }
    }
}
